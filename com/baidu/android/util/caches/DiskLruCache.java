package com.baidu.android.util.caches;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final int IO_BUFFER_SIZE = 8192;
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TMP = "journal.tmp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final Charset UTF_8;
    public static final String VERSION_1 = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public final int appVersion;
    public final Callable<Void> cleanupCallable;
    public final File directory;
    public final ExecutorService executorService;
    public final File journalFile;
    public final File journalFileTmp;
    public Writer journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries;
    public final long maxSize;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;

    /* loaded from: classes.dex */
    public final class Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Entry entry;
        public boolean hasErrors;
        public final /* synthetic */ DiskLruCache this$0;

        /* loaded from: classes.dex */
        public class FaultHidingOutputStream extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Editor this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FaultHidingOutputStream(Editor editor, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {editor, outputStream};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((OutputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = editor;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i, i2);
                    } catch (IOException unused) {
                        this.this$1.hasErrors = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.this$1.hasErrors = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.flush();
                    } catch (IOException unused) {
                        this.this$1.hasErrors = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i);
                    } catch (IOException unused) {
                        this.this$1.hasErrors = true;
                    }
                }
            }
        }

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.entry = entry;
        }

        public String getString(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                InputStream newInputStream = newInputStream(i);
                if (newInputStream != null) {
                    return DiskLruCache.inputStreamToString(newInputStream);
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public void set(int i, String str) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                OutputStreamWriter outputStreamWriter = null;
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), DiskLruCache.UTF_8);
                    try {
                        outputStreamWriter2.write(str);
                        DiskLruCache.closeQuietly(outputStreamWriter2);
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        DiskLruCache.closeQuietly(outputStreamWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void abort() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.completeEdit(this, false);
            }
        }

        public void commit() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.hasErrors) {
                    this.this$0.completeEdit(this, false);
                    this.this$0.remove(this.entry.key);
                    return;
                }
                this.this$0.completeEdit(this, true);
            }
        }

        public InputStream newInputStream(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor == this) {
                        if (!this.entry.readable) {
                            return null;
                        }
                        return new FileInputStream(this.entry.getCleanFile(i));
                    }
                    throw new IllegalStateException();
                }
            }
            return (InputStream) invokeI.objValue;
        }

        public OutputStream newOutputStream(int i) throws IOException {
            InterceptResult invokeI;
            FaultHidingOutputStream faultHidingOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor == this) {
                        faultHidingOutputStream = new FaultHidingOutputStream(new FileOutputStream(this.entry.getDirtyFile(i)));
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return faultHidingOutputStream;
            }
            return (OutputStream) invokeI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Editor currentEditor;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache diskLruCache, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.valueCount];
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, strArr) == null) {
                if (strArr.length == this.this$0.valueCount) {
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            this.lengths[i] = Long.parseLong(strArr[i]);
                        } catch (NumberFormatException unused) {
                            throw invalidLengths(strArr);
                        }
                    }
                    return;
                }
                throw invalidLengths(strArr);
            }
        }

        public File getCleanFile(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                File file = this.this$0.directory;
                return new File(file, this.key + "." + i);
            }
            return (File) invokeI.objValue;
        }

        public File getDirtyFile(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                File file = this.this$0.directory;
                return new File(file, this.key + "." + i + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String getLengths() throws IOException {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.lengths) {
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class Snapshot implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream[] ins;
        public final String key;
        public final long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str, Long.valueOf(j), inputStreamArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.ins = inputStreamArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (InputStream inputStream : this.ins) {
                    DiskLruCache.closeQuietly(inputStream);
                }
            }
        }

        public Editor edit() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (Editor) invokeV.objValue;
            }
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.ins[i];
            }
            return (InputStream) invokeI.objValue;
        }

        public String getString(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return DiskLruCache.inputStreamToString(getInputStream(i));
            }
            return (String) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-667936020, "Lcom/baidu/android/util/caches/DiskLruCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-667936020, "Lcom/baidu/android/util/caches/DiskLruCache;");
                return;
            }
        }
        UTF_8 = Charset.forName("UTF-8");
    }

    private void checkNotClosed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65549, this) != null) || this.journalWriter != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i = this.redundantOpCount;
            if (i >= 2000 && i >= this.lruEntries.size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            while (this.size > this.maxSize) {
                remove(this.lruEntries.entrySet().iterator().next().getKey());
            }
        }
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                close();
                deleteContents(this.directory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                checkNotClosed();
                trimToSize();
                this.journalWriter.flush();
            }
        }
    }

    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.directory;
        }
        return (File) invokeV.objValue;
    }

    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.journalWriter == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long maxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.maxSize;
        }
        return invokeV.longValue;
    }

    public synchronized long size() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                j = this.size;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public DiskLruCache(File file, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.cleanupCallable = new Callable<Void>(this) { // from class: com.baidu.android.util.caches.DiskLruCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DiskLruCache this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    synchronized (this.this$0) {
                        if (this.this$0.journalWriter != null) {
                            this.this$0.trimToSize();
                            if (this.this$0.journalRebuildRequired()) {
                                this.this$0.rebuildJournal();
                                this.this$0.redundantOpCount = 0;
                            }
                            return null;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i2 > 0) {
                    DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
                    if (diskLruCache.journalFile.exists()) {
                        try {
                            diskLruCache.readJournal();
                            diskLruCache.processJournal();
                            diskLruCache.journalWriter = new BufferedWriter(new FileWriter(diskLruCache.journalFile, true), 8192);
                            return diskLruCache;
                        } catch (IOException unused) {
                            diskLruCache.delete();
                        }
                    }
                    file.mkdirs();
                    DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
                    diskLruCache2.rebuildJournal();
                    return diskLruCache2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (DiskLruCache) invokeCommon.objValue;
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void deleteIfExists(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) {
            return readFully(new InputStreamReader(inputStream, UTF_8));
        }
        return (String) invokeL.objValue;
    }

    public Editor edit(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return edit(str, -1L);
        }
        return (Editor) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, editor, z) == null) {
            synchronized (this) {
                Entry entry = editor.entry;
                if (entry.currentEditor == editor) {
                    if (z && !entry.readable) {
                        for (int i = 0; i < this.valueCount; i++) {
                            if (!entry.getDirtyFile(i).exists()) {
                                editor.abort();
                                throw new IllegalStateException("edit didn't create file " + i);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        File dirtyFile = entry.getDirtyFile(i2);
                        if (z) {
                            if (dirtyFile.exists()) {
                                File cleanFile = entry.getCleanFile(i2);
                                dirtyFile.renameTo(cleanFile);
                                long j = entry.lengths[i2];
                                long length = cleanFile.length();
                                entry.lengths[i2] = length;
                                this.size = (this.size - j) + length;
                            }
                        } else {
                            deleteIfExists(dirtyFile);
                        }
                    }
                    this.redundantOpCount++;
                    entry.currentEditor = null;
                    if (!entry.readable && !z) {
                        this.lruEntries.remove(entry.key);
                        this.journalWriter.write("REMOVE " + entry.key + '\n');
                        if (this.size <= this.maxSize || journalRebuildRequired()) {
                            this.executorService.submit(this.cleanupCallable);
                        }
                    }
                    entry.readable = true;
                    this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                    if (z) {
                        long j2 = this.nextSequenceNumber;
                        this.nextSequenceNumber = 1 + j2;
                        entry.sequenceNumber = j2;
                    }
                    if (this.size <= this.maxSize) {
                    }
                    this.executorService.submit(this.cleanupCallable);
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, tArr, i, i2)) == null) {
            int length = tArr.length;
            if (i <= i2) {
                if (i >= 0 && i <= length) {
                    int i3 = i2 - i;
                    int min = Math.min(i3, length - i);
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
                    System.arraycopy(tArr, i, tArr2, 0, min);
                    return tArr2;
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            throw new IllegalArgumentException();
        }
        return (T[]) ((Object[]) invokeLII.objValue);
    }

    public static void deleteContents(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, file) == null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete file: " + file2);
                    }
                }
                return;
            }
            throw new IllegalArgumentException("not a directory: " + file);
        }
    }

    public static String readAsciiLine(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, inputStream)) == null) {
            StringBuilder sb = new StringBuilder(80);
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    if (read == 10) {
                        int length = sb.length();
                        if (length > 0) {
                            int i = length - 1;
                            if (sb.charAt(i) == '\r') {
                                sb.setLength(i);
                            }
                        }
                        return sb.toString();
                    }
                    sb.append((char) read);
                } else {
                    throw new EOFException();
                }
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor edit(String str, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65555, this, str, j)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(str);
                    this.lruEntries.put(str, entry);
                } else if (entry.currentEditor != null) {
                    return null;
                }
                Editor editor = new Editor(entry);
                entry.currentEditor = editor;
                Writer writer = this.journalWriter;
                writer.write("DIRTY " + str + '\n');
                this.journalWriter.flush();
                return editor;
            }
        }
        return (Editor) invokeLJ.objValue;
    }

    private void processJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            deleteIfExists(this.journalFileTmp);
            Iterator<Entry> it = this.lruEntries.values().iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                int i = 0;
                if (next.currentEditor != null) {
                    next.currentEditor = null;
                    while (i < this.valueCount) {
                        deleteIfExists(next.getCleanFile(i));
                        deleteIfExists(next.getDirtyFile(i));
                        i++;
                    }
                    it.remove();
                } else {
                    synchronized (this) {
                        while (i < this.valueCount) {
                            this.size += next.lengths[i];
                            i++;
                        }
                    }
                }
            }
        }
    }

    public static String readFully(Reader reader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, reader)) == null) {
            try {
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        return stringWriter.toString();
                    }
                }
            } finally {
                reader.close();
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    private void validateKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
            if (!str.contains(" ") && !str.contains("\n") && !str.contains("\r")) {
                return;
            }
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private void readJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.journalFile), 8192);
            try {
                String readAsciiLine = readAsciiLine(bufferedInputStream);
                String readAsciiLine2 = readAsciiLine(bufferedInputStream);
                String readAsciiLine3 = readAsciiLine(bufferedInputStream);
                String readAsciiLine4 = readAsciiLine(bufferedInputStream);
                String readAsciiLine5 = readAsciiLine(bufferedInputStream);
                if (!"libcore.io.DiskLruCache".equals(readAsciiLine) || !"1".equals(readAsciiLine2) || !Integer.toString(this.appVersion).equals(readAsciiLine3) || !Integer.toString(this.valueCount).equals(readAsciiLine4) || !"".equals(readAsciiLine5)) {
                    throw new IOException("unexpected journal header: [" + readAsciiLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + readAsciiLine2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readAsciiLine4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readAsciiLine5 + PreferencesUtil.RIGHT_MOUNT);
                }
                while (true) {
                    try {
                        readJournalLine(readAsciiLine(bufferedInputStream));
                    } catch (EOFException unused) {
                        return;
                    }
                }
            } finally {
                closeQuietly(bufferedInputStream);
            }
        }
    }

    private void readJournalLine(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            String[] split = str.split(" ");
            if (split.length >= 2) {
                String str2 = split[1];
                if (split[0].equals("REMOVE") && split.length == 2) {
                    this.lruEntries.remove(str2);
                    return;
                }
                Entry entry = this.lruEntries.get(str2);
                if (entry == null) {
                    entry = new Entry(str2);
                    this.lruEntries.put(str2, entry);
                }
                if (split[0].equals("CLEAN") && split.length == this.valueCount + 2) {
                    entry.readable = true;
                    entry.currentEditor = null;
                    entry.setLengths((String[]) copyOfRange(split, 2, split.length));
                    return;
                } else if (split[0].equals("DIRTY") && split.length == 2) {
                    entry.currentEditor = new Editor(entry);
                    return;
                } else if (split[0].equals("READ") && split.length == 2) {
                    return;
                } else {
                    throw new IOException("unexpected journal line: " + str);
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public synchronized boolean remove(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry != null && entry.currentEditor == null) {
                    for (int i = 0; i < this.valueCount; i++) {
                        File cleanFile = entry.getCleanFile(i);
                        if (cleanFile.delete()) {
                            this.size -= entry.lengths[i];
                            entry.lengths[i] = 0;
                        } else {
                            throw new IOException("failed to delete " + cleanFile);
                        }
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.lruEntries.remove(str);
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            synchronized (this) {
                if (this.journalWriter != null) {
                    this.journalWriter.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.journalFileTmp), 8192);
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        bufferedWriter.write("DIRTY " + entry.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                    }
                }
                bufferedWriter.close();
                this.journalFileTmp.renameTo(this.journalFile);
                this.journalWriter = new BufferedWriter(new FileWriter(this.journalFile, true), 8192);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.journalWriter == null) {
                    return;
                }
                Iterator it = new ArrayList(this.lruEntries.values()).iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
            }
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry == null) {
                    return null;
                }
                if (!entry.readable) {
                    return null;
                }
                InputStream[] inputStreamArr = new InputStream[this.valueCount];
                for (int i = 0; i < this.valueCount; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(entry.getCleanFile(i));
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                this.redundantOpCount++;
                this.journalWriter.append((CharSequence) ("READ " + str + '\n'));
                if (journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                return new Snapshot(str, entry.sequenceNumber, inputStreamArr);
            }
        }
        return (Snapshot) invokeL.objValue;
    }
}
