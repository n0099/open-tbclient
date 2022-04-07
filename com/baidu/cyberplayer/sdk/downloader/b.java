package com.baidu.cyberplayer.sdk.downloader;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, long j);

        void a(String str, long j, long j2);

        void a(String str, long j, String str2);

        void b(String str, long j);
    }

    public static long a(String str, OutputStream outputStream, a aVar) throws Exception {
        InterceptResult invokeLLL;
        Throwable th;
        HttpURLConnection httpURLConnection;
        int i;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65536, null, str, outputStream, aVar)) != null) {
            return invokeLLL.longValue;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Unable to execute downloads on the UI thread.");
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200 && responseCode != 206) {
                    throw new RuntimeException("url that you conneted has error ...");
                }
                long contentLength = httpURLConnection.getContentLength();
                if (contentLength > 0) {
                    if (aVar != null) {
                        aVar.a(str, contentLength);
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[51200];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            int read = inputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            int i4 = i3 + read;
                            outputStream.write(bArr2, i2, read);
                            if (aVar != null) {
                                i = i4;
                                bArr = bArr2;
                                aVar.a(str, i4, contentLength);
                            } else {
                                i = i4;
                                bArr = bArr2;
                            }
                            bArr2 = bArr;
                            i3 = i;
                            i2 = 0;
                        }
                        CyberLog.d("Downloader", "download finished. use time=" + (System.currentTimeMillis() - currentTimeMillis));
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e) {
                                CyberLog.d("Downloader", "disconnect Exception:" + e.toString());
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return contentLength;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                CyberLog.d("Downloader", "disconnect Exception:" + e2.toString());
                                throw th;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new RuntimeException("the file that you start has a wrong size ... ");
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public static void a(HashMap<String, String> hashMap, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, hashMap, aVar) == null) {
            String str = hashMap.get("url");
            String str2 = hashMap.get("file-folder");
            String str3 = hashMap.get("file-name");
            if (str == null || str2 == null || str3 == null) {
                return;
            }
            o.b(str2);
            String str4 = str2 + File.separator + str3;
            String str5 = hashMap.get("is-asyn");
            if (TextUtils.isEmpty(str5) || !str5.equals("0")) {
                CyberTaskExcutor.getInstance().execute(new Runnable(str4, str, aVar) { // from class: com.baidu.cyberplayer.sdk.downloader.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ a c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str4, str, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = str4;
                        this.b = str;
                        this.c = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b.b(this.a, this.b, this.c);
                        }
                    }
                });
            } else {
                b(str4, str, aVar);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x000d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static byte[] a(HashMap<String, String> hashMap) {
        Interceptable interceptable;
        InterceptResult invokeL;
        Interceptable interceptable2 = $ic;
        if (interceptable2 == null || (invokeL = (interceptable = interceptable2).invokeL(65539, null, hashMap)) == null) {
            String str = hashMap.get("url");
            byte[] bArr = null;
            bArr = null;
            bArr = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = interceptable;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (str == null) {
                return null;
            }
            try {
                interceptable = new ByteArrayOutputStream();
                try {
                    a(str, (OutputStream) interceptable, (a) null);
                    bArr = interceptable.toByteArray();
                    interceptable.close();
                    interceptable = interceptable;
                } catch (Exception unused) {
                    CyberLog.w("Downloader", "download failed. IOException");
                    if (interceptable != 0) {
                        interceptable.close();
                        interceptable = interceptable;
                    }
                    return bArr;
                }
            } catch (Exception unused2) {
                interceptable = 0;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x004f -> B:44:0x0052). Please submit an issue!!! */
    public static void b(String str, String str2, a aVar) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, aVar) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        File file = new File(str);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                long a2 = a(str2, fileOutputStream, aVar);
                if (aVar != null) {
                    aVar.b(str2, a2);
                }
                fileOutputStream.close();
            } catch (Exception e3) {
                fileOutputStream2 = fileOutputStream;
                e = e3;
                if (aVar != null) {
                    aVar.a(str2, 0L, e.toString());
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
