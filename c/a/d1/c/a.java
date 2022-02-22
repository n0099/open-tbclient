package c.a.d1.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x007d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x009c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0098 -> B:72:0x009b). Please submit an issue!!! */
    public static void a(File file, List<C0139a> list) throws IOException {
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            if (r2.invokeLL(65536, null, file, list) != null) {
                return;
            }
        }
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[8192];
                    r2 = new ZipOutputStream(new FileOutputStream(file));
                    try {
                        r2.setComment(file.getName());
                        for (C0139a c0139a : list) {
                            File file2 = c0139a.a;
                            if (file2.canRead()) {
                                FileInputStream fileInputStream2 = new FileInputStream(file2);
                                try {
                                    r2.putNextEntry(new ZipEntry(c0139a.f3560b));
                                    while (true) {
                                        int read = fileInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        r2.write(bArr, 0, read);
                                    }
                                    fileInputStream2.close();
                                    fileInputStream = fileInputStream2;
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    fileInputStream = fileInputStream2;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
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
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (r2 != 0) {
                                        try {
                                            r2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
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
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        r2.close();
                    } catch (FileNotFoundException e7) {
                        e = e7;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                r2 = 0;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c.a.d1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0139a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public File a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public String f3560b;

        public C0139a(@NonNull File file, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            if (TextUtils.isEmpty(str)) {
                this.f3560b = this.a.getName();
            } else {
                this.f3560b = str;
            }
        }

        public C0139a(@NonNull File file, @NonNull String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = file;
            if (TextUtils.isEmpty(str)) {
                this.f3560b = this.a.getName();
            } else {
                this.f3560b = str;
            }
        }
    }
}
