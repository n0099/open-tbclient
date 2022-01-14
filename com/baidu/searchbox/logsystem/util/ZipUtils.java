package com.baidu.searchbox.logsystem.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes11.dex */
public class ZipUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZipUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.FileInputStream, java.io.InputStream] */
    public static void zip(File file, List<ZipSrc> list) throws IOException {
        byte[] bArr;
        ZipOutputStream zipOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, file, list) == null) || file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                bArr = new byte[4096];
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        try {
            zipOutputStream.setComment(file.getName());
            for (ZipSrc zipSrc : list) {
                File file2 = zipSrc.mFile;
                try {
                    try {
                        if (file2.canRead()) {
                            ?? fileInputStream = new FileInputStream(file2);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(zipSrc.mOutName));
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                zipOutputStream2 = fileInputStream;
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                zipOutputStream2 = fileInputStream;
                                e.printStackTrace();
                                Closeables.closeSafely(zipOutputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                zipOutputStream2 = fileInputStream;
                                Closeables.closeSafely(zipOutputStream2);
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    }
                    Closeables.closeSafely(zipOutputStream2);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            zipOutputStream.flush();
            Closeables.closeSafely(zipOutputStream);
        } catch (FileNotFoundException e5) {
            e = e5;
            zipOutputStream2 = zipOutputStream;
            if (LLog.sDebug) {
                e.printStackTrace();
            }
            Closeables.closeSafely(zipOutputStream2);
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream2 = zipOutputStream;
            Closeables.closeSafely(zipOutputStream2);
            throw th;
        }
    }

    /* loaded from: classes11.dex */
    public static final class ZipSrc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public File mFile;
        @NonNull
        public String mOutName;

        public ZipSrc(@NonNull File file, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mFile = file;
            if (TextUtils.isEmpty(str)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = str;
            }
        }

        public ZipSrc(@NonNull File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFile = file;
            this.mOutName = file.getName();
        }
    }
}
