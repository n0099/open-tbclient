package com.baidu.location.e;

import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.location.e.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class h extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ f b;

    public h(f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fVar;
        this.a = str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x01dd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0111 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.ByteArrayOutputStream] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        ?? r13;
        ?? r132;
        Object obj;
        StringBuffer stringBuffer;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.a();
            this.b.g = this.a;
            HttpsURLConnection httpsURLConnection2 = null;
            InputStream inputStream2 = null;
            try {
                try {
                    HttpsURLConnection.setDefaultSSLSocketFactory(k.k());
                    stringBuffer = new StringBuffer();
                    url = new URL(this.b.g);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                } catch (Error e) {
                    e = e;
                    inputStream = null;
                    httpsURLConnection = null;
                    outputStream = httpsURLConnection;
                    r132 = outputStream;
                    e.printStackTrace();
                    Log.i("baidu_location_service", "https NetworkCommunicationError!");
                    this.b.i = null;
                    this.b.a(false);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                            Log.d("baidu_location_service", "close os IOException!");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                            Log.d("baidu_location_service", "close is IOException!");
                        }
                    }
                    if (r132 == 0) {
                        return;
                    }
                    r132.close();
                } catch (Exception e2) {
                    e = e2;
                    inputStream = null;
                    httpsURLConnection = null;
                    outputStream = httpsURLConnection;
                    r132 = outputStream;
                    e.printStackTrace();
                    Log.i("baidu_location_service", "https NetworkCommunicationException!");
                    this.b.i = null;
                    this.b.a(false);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused3) {
                            Log.d("baidu_location_service", "close os IOException!");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                            Log.d("baidu_location_service", "close is IOException!");
                        }
                    }
                    if (r132 == 0) {
                        return;
                    }
                    r132.close();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    outputStream = null;
                    r13 = outputStream;
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused5) {
                            Log.d("baidu_location_service", "close os IOException!");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused6) {
                            Log.d("baidu_location_service", "close is IOException!");
                        }
                    }
                    if (r13 != 0) {
                        try {
                            r13.close();
                        } catch (Exception unused7) {
                            Log.d("baidu_location_service", "close baos IOException!");
                        }
                    }
                    throw th;
                }
                try {
                    httpsURLConnection.setInstanceFollowRedirects(false);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setConnectTimeout(a.a);
                    httpsURLConnection.setReadTimeout(a.b);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setHostnameVerifier(new f.a(url));
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    if (k.aw != null) {
                        httpsURLConnection.setRequestProperty("bd-loc-android", k.aw);
                    }
                    for (Map.Entry<String, Object> entry : this.b.j.entrySet()) {
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append("&");
                    }
                    if (stringBuffer.length() > 0) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(stringBuffer.toString().getBytes());
                        outputStream.flush();
                        if (httpsURLConnection.getResponseCode() == 200) {
                            inputStream = httpsURLConnection.getInputStream();
                            try {
                                String contentEncoding = httpsURLConnection.getContentEncoding();
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                }
                                r132 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        r132.write(bArr, 0, read);
                                    }
                                    this.b.i = new String(r132.toByteArray(), IMAudioTransRequest.CHARSET);
                                    this.b.a(true);
                                    inputStream2 = inputStream;
                                    r132 = r132;
                                } catch (Error e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    Log.i("baidu_location_service", "https NetworkCommunicationError!");
                                    this.b.i = null;
                                    this.b.a(false);
                                    if (httpsURLConnection != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (r132 == 0) {
                                    }
                                    r132.close();
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    Log.i("baidu_location_service", "https NetworkCommunicationException!");
                                    this.b.i = null;
                                    this.b.a(false);
                                    if (httpsURLConnection != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (r132 == 0) {
                                    }
                                    r132.close();
                                }
                            } catch (Error e5) {
                                e = e5;
                                r132 = 0;
                            } catch (Exception e6) {
                                e = e6;
                                r132 = 0;
                            } catch (Throwable th3) {
                                th = th3;
                                obj = null;
                                httpsURLConnection2 = httpsURLConnection;
                                r13 = obj;
                                if (httpsURLConnection2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (r13 != 0) {
                                }
                                throw th;
                            }
                        } else {
                            this.b.i = null;
                            this.b.a(false);
                            r132 = 0;
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused8) {
                                Log.d("baidu_location_service", "close os IOException!");
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused9) {
                                Log.d("baidu_location_service", "close is IOException!");
                            }
                        }
                        if (r132 == 0) {
                            return;
                        }
                    } catch (Error e7) {
                        e = e7;
                        inputStream = null;
                        r132 = 0;
                    } catch (Exception e8) {
                        e = e8;
                        inputStream = null;
                        r132 = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                        obj = null;
                    }
                } catch (Error e9) {
                    e = e9;
                    inputStream = null;
                    outputStream = null;
                    r132 = outputStream;
                    e.printStackTrace();
                    Log.i("baidu_location_service", "https NetworkCommunicationError!");
                    this.b.i = null;
                    this.b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r132 == 0) {
                    }
                    r132.close();
                } catch (Exception e10) {
                    e = e10;
                    inputStream = null;
                    outputStream = null;
                    r132 = outputStream;
                    e.printStackTrace();
                    Log.i("baidu_location_service", "https NetworkCommunicationException!");
                    this.b.i = null;
                    this.b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r132 == 0) {
                    }
                    r132.close();
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    outputStream = null;
                    obj = null;
                }
            } catch (Error e11) {
                e = e11;
                inputStream = null;
                httpsURLConnection = null;
            } catch (Exception e12) {
                e = e12;
                inputStream = null;
                httpsURLConnection = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                outputStream = null;
            }
            try {
                r132.close();
            } catch (Exception unused10) {
                Log.d("baidu_location_service", "close baos IOException!");
            }
        }
    }
}
