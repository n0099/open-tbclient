package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "AtomicFile";
    public transient /* synthetic */ FieldHolder $fh;
    public final File mBaseName;
    public final File mLegacyBackupName;
    public final File mNewName;

    public AtomicFile(@NonNull File file) {
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
        this.mNewName = new File(file.getPath() + ".new");
        this.mLegacyBackupName = new File(file.getPath() + ".bak");
    }

    public static void rename(@NonNull File file, @NonNull File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, file, file2) == null) {
            if (file2.isDirectory() && !file2.delete()) {
                Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
            }
            if (!file.renameTo(file2)) {
                Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
            }
        }
    }

    public static boolean sync(@NonNull FileOutputStream fileOutputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fileOutputStream)) == null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fileOutputStream) != null) || fileOutputStream == null) {
            return;
        }
        if (!sync(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        rename(this.mNewName, this.mBaseName);
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBaseName.delete();
            this.mNewName.delete();
            this.mLegacyBackupName.delete();
        }
    }

    @NonNull
    public File getBaseFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBaseName;
        }
        return (File) invokeV.objValue;
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fileOutputStream) != null) || fileOutputStream == null) {
            return;
        }
        if (!sync(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        if (!this.mNewName.delete()) {
            Log.e("AtomicFile", "Failed to delete new file " + this.mNewName);
        }
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mLegacyBackupName.exists()) {
                rename(this.mLegacyBackupName, this.mBaseName);
            }
            if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
                Log.e("AtomicFile", "Failed to delete outdated new file " + this.mNewName);
            }
            return new FileInputStream(this.mBaseName);
        }
        return (FileInputStream) invokeV.objValue;
    }

    @NonNull
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

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mLegacyBackupName.exists()) {
                rename(this.mLegacyBackupName, this.mBaseName);
            }
            try {
                return new FileOutputStream(this.mNewName);
            } catch (FileNotFoundException unused) {
                if (this.mNewName.getParentFile().mkdirs()) {
                    try {
                        return new FileOutputStream(this.mNewName);
                    } catch (FileNotFoundException e) {
                        throw new IOException("Failed to create new file " + this.mNewName, e);
                    }
                }
                throw new IOException("Failed to create directory for " + this.mNewName);
            }
        }
        return (FileOutputStream) invokeV.objValue;
    }
}
