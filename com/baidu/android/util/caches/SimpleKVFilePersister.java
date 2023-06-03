package com.baidu.android.util.caches;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.ExecutorUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
@SuppressLint({"BDThrowableCheck"})
@Deprecated
/* loaded from: classes.dex */
public class SimpleKVFilePersister {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SimpleKVFilePersister";
    public transient /* synthetic */ FieldHolder $fh;
    public File mCacheFileDir;
    public final ReentrantReadWriteLock mFileOpLock;

    public SimpleKVFilePersister(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFileOpLock = new ReentrantReadWriteLock();
        if (!TextUtils.isEmpty(str)) {
            this.mCacheFileDir = new File(AppRuntime.getAppContext().getFilesDir(), str);
            return;
        }
        throw new IllegalArgumentException("dir must not empty");
    }

    public boolean deleteFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                this.mFileOpLock.writeLock().lock();
                File file = new File(this.mCacheFileDir, str);
                if (!file.exists()) {
                    return false;
                }
                return file.delete();
            } finally {
                this.mFileOpLock.writeLock().unlock();
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
        if (r5 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r5 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getByteArrayFromFileSync(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            File file = new File(this.mCacheFileDir, str);
            if (!file.exists()) {
                return new byte[0];
            }
            FileInputStream fileInputStream2 = null;
            try {
                this.mFileOpLock.readLock().lock();
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                this.mFileOpLock.readLock().unlock();
                return bArr;
            } catch (FileNotFoundException unused4) {
                fileInputStream2 = fileInputStream;
            } catch (IOException unused5) {
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                this.mFileOpLock.readLock().unlock();
                throw th;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
        this.mFileOpLock.readLock().unlock();
        return new byte[0];
    }

    public String getStringFromFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new String(getByteArrayFromFileSync(str));
        }
        return (String) invokeL.objValue;
    }

    public File getTargetFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return new File(this.mCacheFileDir, str);
        }
        return (File) invokeL.objValue;
    }

    public boolean isTargetExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return getTargetFile(str).exists();
        }
        return invokeL.booleanValue;
    }

    public void putByteArrayToFileAsync(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bArr) == null) {
            ExecutorUtils.postOnIO(new Runnable(this, str, bArr) { // from class: com.baidu.android.util.caches.SimpleKVFilePersister.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleKVFilePersister this$0;
                public final /* synthetic */ byte[] val$data;
                public final /* synthetic */ String val$fileName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, bArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fileName = str;
                    this.val$data = bArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.putByteArrayToFileSync(this.val$fileName, this.val$data);
                    }
                }
            }, "simple kv persist");
        }
    }

    public void putByteArrayToFileAsyncMayDelay(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bArr) == null) {
            ExecutorUtils.postOnComputation(new Runnable(this, str, bArr) { // from class: com.baidu.android.util.caches.SimpleKVFilePersister.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleKVFilePersister this$0;
                public final /* synthetic */ byte[] val$data;
                public final /* synthetic */ String val$fileName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, bArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fileName = str;
                    this.val$data = bArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.putByteArrayToFileSync(this.val$fileName, this.val$data);
                    }
                }
            }, "simple kv persist");
        }
    }

    public void putStringToFileAsync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            ExecutorUtils.postOnIO(new Runnable(this, str, str2) { // from class: com.baidu.android.util.caches.SimpleKVFilePersister.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleKVFilePersister this$0;
                public final /* synthetic */ String val$fileName;
                public final /* synthetic */ String val$values;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fileName = str;
                    this.val$values = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.putStringToFileSync(this.val$fileName, this.val$values);
                    }
                }
            }, "simple kv persist");
        }
    }

    public void putStringToFileAsyncMayDelay(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            ExecutorUtils.postOnComputation(new Runnable(this, str, str2) { // from class: com.baidu.android.util.caches.SimpleKVFilePersister.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleKVFilePersister this$0;
                public final /* synthetic */ String val$fileName;
                public final /* synthetic */ String val$values;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fileName = str;
                    this.val$values = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.putStringToFileSync(this.val$fileName, this.val$values);
                    }
                }
            }, "simple kv persist");
        }
    }

    public boolean putStringToFileSync(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            return putByteArrayToFileSync(str, str2.getBytes());
        }
        return invokeLL.booleanValue;
    }

    public boolean putByteArrayToFileSync(String str, byte[] bArr) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, bArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (this.mCacheFileDir.exists() && !this.mCacheFileDir.isDirectory()) {
                this.mCacheFileDir.delete();
            }
            if (!this.mCacheFileDir.exists() && !this.mCacheFileDir.mkdirs()) {
                return false;
            }
            File file = new File(this.mCacheFileDir, str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                this.mFileOpLock.writeLock().lock();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused) {
                    }
                    this.mFileOpLock.writeLock().unlock();
                    return true;
                } catch (IOException unused2) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    this.mFileOpLock.writeLock().unlock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.mFileOpLock.writeLock().unlock();
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th3) {
                bufferedOutputStream = null;
                th = th3;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
