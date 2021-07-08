package com.baidu.searchbox.bddownload.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.exception.PreAllocateException;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes2.dex */
public class MultiPointOutputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExecutorService FILE_IO_EXECUTOR;
    public static final String TAG = "MultiPointOutputStream";
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicLong allNoSyncLength;
    public boolean canceled;
    public final StreamsState doneState;
    public volatile boolean firstOutputStream;
    public final int flushBufferSize;
    public final BreakpointInfo info;
    public final boolean isPreAllocateLength;
    public final AtomicLong lastSyncTimestamp;
    @NonNull
    public ArrayList<Integer> noMoreStreamList;
    public final SparseArray<AtomicLong> noSyncLengthMap;
    public final SparseArray<DownloadOutputStream> outputStreamMap;
    public final SparseArray<Thread> parkedRunBlockThreadMap;
    public String path;
    public List<Integer> requireStreamBlocks;
    public volatile Thread runSyncThread;
    public StreamsState state;
    public final DownloadStore store;
    public final boolean supportSeek;
    public final int syncBufferIntervalMills;
    public final int syncBufferSize;
    public IOException syncException;
    public volatile Future syncFuture;
    @NonNull
    public final Runnable syncRunnable;
    public final DownloadTask task;

    /* loaded from: classes2.dex */
    public static class StreamsState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isNoMoreStream;
        public List<Integer> newNoMoreStreamBlockList;
        public List<Integer> noMoreStreamBlockList;

        public StreamsState() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.noMoreStreamBlockList = new ArrayList();
            this.newNoMoreStreamBlockList = new ArrayList();
        }

        public boolean isStreamsEndOrChanged() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isNoMoreStream || this.newNoMoreStreamBlockList.size() > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1161035627, "Lcom/baidu/searchbox/bddownload/core/file/MultiPointOutputStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1161035627, "Lcom/baidu/searchbox/bddownload/core/file/MultiPointOutputStream;");
                return;
            }
        }
        FILE_IO_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload file io", false));
    }

    public MultiPointOutputStream(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadStore downloadStore, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, breakpointInfo, downloadStore, runnable};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.outputStreamMap = new SparseArray<>();
        this.noSyncLengthMap = new SparseArray<>();
        this.allNoSyncLength = new AtomicLong();
        this.lastSyncTimestamp = new AtomicLong();
        this.canceled = false;
        this.parkedRunBlockThreadMap = new SparseArray<>();
        this.firstOutputStream = true;
        this.doneState = new StreamsState();
        this.state = new StreamsState();
        this.task = downloadTask;
        this.flushBufferSize = downloadTask.getFlushBufferSize();
        this.syncBufferSize = downloadTask.getSyncBufferSize();
        this.syncBufferIntervalMills = downloadTask.getSyncBufferIntervalMills();
        this.info = breakpointInfo;
        this.store = downloadStore;
        this.supportSeek = BdDownload.with().outputStreamFactory().supportSeek();
        this.isPreAllocateLength = BdDownload.with().processFileStrategy().isPreAllocateLength(downloadTask);
        this.noMoreStreamList = new ArrayList<>();
        if (runnable == null) {
            this.syncRunnable = new Runnable(this) { // from class: com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiPointOutputStream this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.runSyncDelayException();
                    }
                }
            };
        } else {
            this.syncRunnable = runnable;
        }
        File file = downloadTask.getFile();
        if (file != null) {
            this.path = file.getAbsolutePath();
        }
    }

    private void inspectValidPath() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.path == null && this.task.getFile() != null) {
            this.path = this.task.getFile().getAbsolutePath();
        }
    }

    public synchronized void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.requireStreamBlocks == null) {
                    return;
                }
                if (this.canceled) {
                    return;
                }
                this.canceled = true;
                this.noMoreStreamList.addAll(this.requireStreamBlocks);
                if (this.allNoSyncLength.get() <= 0) {
                    for (Integer num : this.requireStreamBlocks) {
                        try {
                            close(num.intValue());
                        } catch (IOException e2) {
                            Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + num + PreferencesUtil.RIGHT_MOUNT + e2);
                        }
                    }
                    this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
                    return;
                }
                if (this.syncFuture != null && !this.syncFuture.isDone()) {
                    inspectValidPath();
                    BdDownload.with().processFileStrategy().getFileLock().increaseLock(this.path);
                    try {
                        ensureSync(true, -1);
                        BdDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                    } catch (Throwable th) {
                        BdDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                        throw th;
                    }
                }
                for (Integer num2 : this.requireStreamBlocks) {
                    try {
                        close(num2.intValue());
                    } catch (IOException e3) {
                        Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + num2 + PreferencesUtil.RIGHT_MOUNT + e3);
                    }
                }
                this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
                return;
            }
        }
    }

    public void cancelAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FILE_IO_EXECUTOR.execute(new Runnable(this) { // from class: com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiPointOutputStream this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.cancel();
                    }
                }
            });
        }
    }

    public void catchBlockConnectException(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.noMoreStreamList.add(Integer.valueOf(i2));
        }
    }

    public synchronized void close(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                DownloadOutputStream downloadOutputStream = this.outputStreamMap.get(i2);
                if (downloadOutputStream != null) {
                    downloadOutputStream.close();
                    this.outputStreamMap.remove(i2);
                    this.noSyncLengthMap.remove(i2);
                    Util.d(TAG, "OutputStream close task[" + this.task.getId() + "] block[" + i2 + PreferencesUtil.RIGHT_MOUNT);
                }
            }
        }
    }

    public void done(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.noMoreStreamList.add(Integer.valueOf(i2));
            try {
                if (this.syncException == null) {
                    if (this.syncFuture != null && !this.syncFuture.isDone()) {
                        AtomicLong atomicLong = this.noSyncLengthMap.get(i2);
                        if (atomicLong != null && atomicLong.get() > 0) {
                            inspectStreamState(this.doneState);
                            ensureSync(this.doneState.isNoMoreStream, i2);
                        }
                    } else if (this.syncFuture == null) {
                        Util.d(TAG, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.task.getId() + "] block[" + i2 + PreferencesUtil.RIGHT_MOUNT);
                    } else {
                        Util.d(TAG, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.syncFuture.isDone() + "] task[" + this.task.getId() + "] block[" + i2 + PreferencesUtil.RIGHT_MOUNT);
                    }
                    return;
                }
                throw this.syncException;
            } finally {
                close(i2);
            }
        }
    }

    public void ensureSync(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.syncFuture == null || this.syncFuture.isDone()) {
            return;
        }
        if (!z) {
            this.parkedRunBlockThreadMap.put(i2, Thread.currentThread());
        }
        if (this.runSyncThread != null) {
            unparkThread(this.runSyncThread);
        } else {
            while (!isRunSyncThreadValid()) {
                parkThread(25L);
            }
            unparkThread(this.runSyncThread);
        }
        if (z) {
            unparkThread(this.runSyncThread);
            try {
                this.syncFuture.get();
                return;
            } catch (InterruptedException | ExecutionException unused) {
                return;
            }
        }
        parkThread();
    }

    public Future executeSyncRunnableAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? FILE_IO_EXECUTOR.submit(this.syncRunnable) : (Future) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void flushProcess() throws IOException {
        int size;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        synchronized (this.noSyncLengthMap) {
            size = this.noSyncLengthMap.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i2 = 0;
        while (true) {
            long j = 0;
            if (i2 >= size) {
                break;
            }
            try {
                int keyAt = this.outputStreamMap.keyAt(i2);
                long j2 = this.noSyncLengthMap.get(keyAt).get();
                if (j2 > 0) {
                    sparseArray.put(keyAt, Long.valueOf(j2));
                    this.outputStreamMap.get(keyAt).flushAndSync();
                }
                i2++;
            } catch (IOException e2) {
                Util.w(TAG, "OutputStream flush and sync data to filesystem failed " + e2);
                z = false;
            }
            if (z) {
                return;
            }
            int size2 = sparseArray.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int keyAt2 = sparseArray.keyAt(i3);
                long longValue = ((Long) sparseArray.valueAt(i3)).longValue();
                this.store.onSyncToFilesystemSuccess(this.info, keyAt2, longValue);
                j += longValue;
                this.noSyncLengthMap.get(keyAt2).addAndGet(-longValue);
                Util.d(TAG, "OutputStream sync success (" + this.task.getId() + ") block(" + keyAt2 + ")  syncLength(" + longValue + ") currentOffset(" + this.info.getBlock(keyAt2).getCurrentOffset() + SmallTailInfo.EMOTION_SUFFIX);
            }
            this.allNoSyncLength.addAndGet(-j);
            this.lastSyncTimestamp.set(SystemClock.uptimeMillis());
            return;
        }
        z = true;
        if (z) {
        }
    }

    public long getNextParkMillisecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.syncBufferIntervalMills - (now() - this.lastSyncTimestamp.get()) : invokeV.longValue;
    }

    public void inspectAndPersist() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            IOException iOException = this.syncException;
            if (iOException == null) {
                if (this.syncFuture == null) {
                    synchronized (this.syncRunnable) {
                        if (this.syncFuture == null) {
                            this.syncFuture = executeSyncRunnableAsync();
                        }
                    }
                    return;
                }
                return;
            }
            throw iOException;
        }
    }

    public void inspectComplete(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            BlockInfo block = this.info.getBlock(i2);
            if (Util.isCorrectFull(block.getCurrentOffset(), block.getContentLength())) {
                return;
            }
            throw new IOException("The current offset on block-info isn't update correct, " + block.getCurrentOffset() + " != " + block.getContentLength() + " on " + i2);
        }
    }

    public void inspectFreeSpace(StatFs statFs, long j) throws PreAllocateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, statFs, j) == null) {
            long freeSpaceBytes = Util.getFreeSpaceBytes(statFs);
            if (freeSpaceBytes < j) {
                throw new PreAllocateException(j, freeSpaceBytes);
            }
        }
    }

    public void inspectStreamState(StreamsState streamsState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, streamsState) == null) {
            streamsState.newNoMoreStreamBlockList.clear();
            int size = new HashSet((List) this.noMoreStreamList.clone()).size();
            if (size != this.requireStreamBlocks.size()) {
                Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is not equal to no more stream block count " + size);
                streamsState.isNoMoreStream = false;
            } else {
                Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is equal to no more stream block count " + size);
                streamsState.isNoMoreStream = true;
            }
            SparseArray<DownloadOutputStream> clone = this.outputStreamMap.clone();
            int size2 = clone.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int keyAt = clone.keyAt(i2);
                if (this.noMoreStreamList.contains(Integer.valueOf(keyAt)) && !streamsState.noMoreStreamBlockList.contains(Integer.valueOf(keyAt))) {
                    streamsState.noMoreStreamBlockList.add(Integer.valueOf(keyAt));
                    streamsState.newNoMoreStreamBlockList.add(Integer.valueOf(keyAt));
                }
            }
        }
    }

    public boolean isNoNeedFlushForLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.allNoSyncLength.get() < ((long) this.syncBufferSize) : invokeV.booleanValue;
    }

    public boolean isRunSyncThreadValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.runSyncThread != null : invokeV.booleanValue;
    }

    public long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? SystemClock.uptimeMillis() : invokeV.longValue;
    }

    public synchronized DownloadOutputStream outputStream(int i2) throws IOException {
        InterceptResult invokeI;
        DownloadOutputStream downloadOutputStream;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            synchronized (this) {
                downloadOutputStream = this.outputStreamMap.get(i2);
                if (downloadOutputStream == null) {
                    boolean isUriFileScheme = Util.isUriFileScheme(this.task.getUri());
                    if (isUriFileScheme) {
                        File file = this.task.getFile();
                        if (file != null) {
                            File parentFile = this.task.getParentFile();
                            if (!parentFile.exists() && !parentFile.mkdirs()) {
                                throw new IOException("Create parent folder failed!");
                            }
                            if (file.createNewFile()) {
                                Util.d(TAG, "Create new file: " + file.getName());
                            }
                            uri = Uri.fromFile(file);
                        } else {
                            throw new FileNotFoundException("Filename is not ready!");
                        }
                    } else {
                        uri = this.task.getUri();
                    }
                    DownloadOutputStream create = BdDownload.with().outputStreamFactory().create(BdDownload.with().context(), uri, this.flushBufferSize);
                    if (this.supportSeek) {
                        long rangeLeft = this.info.getBlock(i2).getRangeLeft();
                        if (rangeLeft > 0) {
                            create.seek(rangeLeft);
                            Util.d(TAG, "Create output stream write from (" + this.task.getId() + ") block(" + i2 + ") " + rangeLeft);
                        }
                    }
                    if (this.firstOutputStream) {
                        this.store.markFileDirty(this.task.getId());
                    }
                    if (!this.info.isChunked() && this.firstOutputStream && this.isPreAllocateLength) {
                        long totalLength = this.info.getTotalLength();
                        if (isUriFileScheme) {
                            File file2 = this.task.getFile();
                            long length = totalLength - file2.length();
                            if (length > 0) {
                                inspectFreeSpace(new StatFs(file2.getAbsolutePath()), length);
                                create.setLength(totalLength);
                            }
                        } else {
                            create.setLength(totalLength);
                        }
                    }
                    synchronized (this.noSyncLengthMap) {
                        this.outputStreamMap.put(i2, create);
                        this.noSyncLengthMap.put(i2, new AtomicLong());
                    }
                    this.firstOutputStream = false;
                    downloadOutputStream = create;
                }
            }
            return downloadOutputStream;
        }
        return (DownloadOutputStream) invokeI.objValue;
    }

    public void parkThread(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j));
        }
    }

    public void runSync() throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Util.d(TAG, "OutputStream start flush looper task[" + this.task.getId() + "] with syncBufferIntervalMills[" + this.syncBufferIntervalMills + "] syncBufferSize[" + this.syncBufferSize + PreferencesUtil.RIGHT_MOUNT);
            this.runSyncThread = Thread.currentThread();
            long j = (long) this.syncBufferIntervalMills;
            flushProcess();
            while (true) {
                parkThread(j);
                inspectStreamState(this.state);
                if (this.state.isStreamsEndOrChanged()) {
                    Util.d(TAG, "runSync state change isNoMoreStream[" + this.state.isNoMoreStream + "] newNoMoreStreamBlockList[" + this.state.newNoMoreStreamBlockList + PreferencesUtil.RIGHT_MOUNT);
                    if (this.allNoSyncLength.get() > 0) {
                        flushProcess();
                    }
                    for (Integer num : this.state.newNoMoreStreamBlockList) {
                        Thread thread = this.parkedRunBlockThreadMap.get(num.intValue());
                        this.parkedRunBlockThreadMap.remove(num.intValue());
                        if (thread != null) {
                            unparkThread(thread);
                        }
                    }
                    if (this.state.isNoMoreStream) {
                        break;
                    }
                } else {
                    if (isNoNeedFlushForLength()) {
                        i2 = this.syncBufferIntervalMills;
                    } else {
                        j = getNextParkMillisecond();
                        if (j <= 0) {
                            flushProcess();
                            i2 = this.syncBufferIntervalMills;
                        }
                    }
                    j = i2;
                }
            }
            int size = this.parkedRunBlockThreadMap.size();
            for (int i3 = 0; i3 < size; i3++) {
                Thread valueAt = this.parkedRunBlockThreadMap.valueAt(i3);
                if (valueAt != null) {
                    unparkThread(valueAt);
                }
            }
            this.parkedRunBlockThreadMap.clear();
            Util.d(TAG, "OutputStream stop flush looper task[" + this.task.getId() + PreferencesUtil.RIGHT_MOUNT);
        }
    }

    public void runSyncDelayException() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                runSync();
            } catch (IOException e2) {
                this.syncException = e2;
                Util.w(TAG, "Sync to breakpoint-store for task[" + this.task.getId() + "] failed with cause: " + e2);
            }
        }
    }

    public void setRequireStreamBlocks(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            this.requireStreamBlocks = list;
        }
    }

    public void unparkThread(Thread thread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, thread) == null) {
            LockSupport.unpark(thread);
        }
    }

    public synchronized void write(int i2, byte[] bArr, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (this.canceled) {
                    return;
                }
                outputStream(i2).write(bArr, 0, i3);
                long j = i3;
                this.allNoSyncLength.addAndGet(j);
                this.noSyncLengthMap.get(i2).addAndGet(j);
                inspectAndPersist();
            }
        }
    }

    public void parkThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LockSupport.park();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiPointOutputStream(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadStore downloadStore) {
        this(downloadTask, breakpointInfo, downloadStore, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, breakpointInfo, downloadStore};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DownloadTask) objArr2[0], (BreakpointInfo) objArr2[1], (DownloadStore) objArr2[2], (Runnable) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
