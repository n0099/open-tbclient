package com.baidu.android.imsdk.retrieve.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public class FileZipUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public final class ZipSrc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mDelete;
        public File mFile;
        public String mOutName;

        public ZipSrc(File file) {
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
            this.mFile = file;
            this.mOutName = file.getName();
        }

        public ZipSrc(File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public ZipSrc(File file, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mFile = file;
            if (TextUtils.isEmpty(str)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = str;
            }
            this.mDelete = z;
        }
    }

    public FileZipUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00a2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x009e -> B:83:0x00a1). Please submit an issue!!! */
    public static void zip(File file, List list) throws IOException {
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            if (r2.invokeLL(65537, null, file, list) != null) {
                return;
            }
        }
        if (file != null && file.exists() && list != null && list.size() != 0) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        r2 = new ZipOutputStream(new FileOutputStream(file));
                        try {
                            r2.setComment(file.getName());
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ZipSrc zipSrc = (ZipSrc) it.next();
                                File file2 = zipSrc.mFile;
                                if (file2.canRead() && file2.isFile()) {
                                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                                    try {
                                        r2.putNextEntry(new ZipEntry(zipSrc.mOutName));
                                        while (true) {
                                            int read = fileInputStream2.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            r2.write(bArr, 0, read);
                                        }
                                        fileInputStream2.close();
                                        fileInputStream = fileInputStream2;
                                    } catch (FileNotFoundException e) {
                                        e = e;
                                        fileInputStream = fileInputStream2;
                                        e.printStackTrace();
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (r2 != 0) {
                                            r2.close();
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (r2 != 0) {
                                            try {
                                                r2.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                            r2.flush();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            r2.close();
                        } catch (FileNotFoundException e6) {
                            e = e6;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    r2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = 0;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
    }
}
