package androidx.core.util;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class AtomicFile {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File mBackupName;
    public final File mBaseName;

    public AtomicFile(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBaseName = file;
        this.mBackupName = new File(file.getPath() + ".bak");
    }

    public static boolean sync(FileOutputStream fileOutputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fileOutputStream)) == null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fileOutputStream) == null) && fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            } catch (IOException e) {
                Log.w(com.google.android.exoplayer2.util.AtomicFile.TAG, "failWrite: Got exception:", e);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fileOutputStream) == null) && fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBackupName.delete();
            } catch (IOException e) {
                Log.w(com.google.android.exoplayer2.util.AtomicFile.TAG, "finishWrite: Got exception:", e);
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBaseName.delete();
            this.mBackupName.delete();
        }
    }

    public File getBaseFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBaseName;
        }
        return (File) invokeV.objValue;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mBackupName.exists()) {
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            }
            return new FileInputStream(this.mBaseName);
        }
        return (FileInputStream) invokeV.objValue;
    }

    public byte[] readFully() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FileInputStream openRead = openRead();
            try {
                byte[] bArr = new byte[openRead.available()];
                int i = 0;
                while (true) {
                    int read = openRead.read(bArr, i, bArr.length - i);
                    if (read <= 0) {
                        return bArr;
                    }
                    i += read;
                    int available = openRead.available();
                    if (available > bArr.length - i) {
                        byte[] bArr2 = new byte[available + i];
                        System.arraycopy(bArr, 0, bArr2, 0, i);
                        bArr = bArr2;
                    }
                }
            } finally {
                openRead.close();
            }
        } else {
            return (byte[]) invokeV.objValue;
        }
    }

    public FileOutputStream startWrite() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mBaseName.exists()) {
                if (!this.mBackupName.exists()) {
                    if (!this.mBaseName.renameTo(this.mBackupName)) {
                        Log.w(com.google.android.exoplayer2.util.AtomicFile.TAG, "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
                    }
                } else {
                    this.mBaseName.delete();
                }
            }
            try {
                return new FileOutputStream(this.mBaseName);
            } catch (FileNotFoundException unused) {
                if (this.mBaseName.getParentFile().mkdirs()) {
                    try {
                        return new FileOutputStream(this.mBaseName);
                    } catch (FileNotFoundException unused2) {
                        throw new IOException("Couldn't create " + this.mBaseName);
                    }
                }
                throw new IOException("Couldn't create directory " + this.mBaseName);
            }
        }
        return (FileOutputStream) invokeV.objValue;
    }
}
