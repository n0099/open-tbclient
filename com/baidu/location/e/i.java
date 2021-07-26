package com.baidu.location.e;

import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes2.dex */
public class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6831a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f6832b;

    public i(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6832b = eVar;
        this.f6831a = str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x01de */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0105 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018b  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.ByteArrayOutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        InputStream inputStream;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        ?? r12;
        ?? r122;
        Object obj;
        StringBuffer stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f6832b.a();
            this.f6832b.b();
            this.f6832b.f6823h = this.f6831a;
            HttpsURLConnection httpsURLConnection2 = null;
            InputStream inputStream2 = null;
            try {
                try {
                    stringBuffer = new StringBuffer();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Error e2) {
                e = e2;
                inputStream = null;
                httpsURLConnection = null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                httpsURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                outputStream = null;
            }
            try {
                try {
                    httpsURLConnection = (HttpsURLConnection) new URL(this.f6832b.f6823h).openConnection();
                    try {
                        httpsURLConnection.setInstanceFollowRedirects(false);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setConnectTimeout(a.f6784b);
                        httpsURLConnection.setReadTimeout(a.f6785c);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpsURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                        if (k.ax != null) {
                            httpsURLConnection.setRequestProperty("bd-loc-android", k.ax);
                        }
                        for (Map.Entry<String, Object> entry : this.f6832b.k.entrySet()) {
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
                                    if (contentEncoding != null && contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) {
                                        inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                    }
                                    r122 = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            r122.write(bArr, 0, read);
                                        }
                                        this.f6832b.j = new String(r122.toByteArray(), "utf-8");
                                        this.f6832b.a(true);
                                        inputStream2 = inputStream;
                                        r122 = r122;
                                    } catch (Error e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        Log.i(a.f6783a, "https NetworkCommunicationError!");
                                        this.f6832b.j = null;
                                        this.f6832b.a(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused) {
                                                Log.d(a.f6783a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused2) {
                                                Log.d(a.f6783a, "close is IOException!");
                                            }
                                        }
                                        if (r122 == 0) {
                                            return;
                                        }
                                        r122.close();
                                    } catch (Exception e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        Log.i(a.f6783a, "https NetworkCommunicationException!");
                                        this.f6832b.j = null;
                                        this.f6832b.a(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused3) {
                                                Log.d(a.f6783a, "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused4) {
                                                Log.d(a.f6783a, "close is IOException!");
                                            }
                                        }
                                        if (r122 == 0) {
                                            return;
                                        }
                                        r122.close();
                                    }
                                } catch (Error e6) {
                                    e = e6;
                                    r122 = 0;
                                } catch (Exception e7) {
                                    e = e7;
                                    r122 = 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = null;
                                    httpsURLConnection2 = httpsURLConnection;
                                    r12 = obj;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused5) {
                                            Log.d(a.f6783a, "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused6) {
                                            Log.d(a.f6783a, "close is IOException!");
                                        }
                                    }
                                    if (r12 != 0) {
                                        try {
                                            r12.close();
                                        } catch (Exception unused7) {
                                            Log.d(a.f6783a, "close baos IOException!");
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                this.f6832b.j = null;
                                this.f6832b.a(false);
                                r122 = 0;
                            }
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception unused8) {
                                    Log.d(a.f6783a, "close os IOException!");
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused9) {
                                    Log.d(a.f6783a, "close is IOException!");
                                }
                            }
                            if (r122 == 0) {
                                return;
                            }
                        } catch (Error e8) {
                            e = e8;
                            inputStream = null;
                            r122 = 0;
                        } catch (Exception e9) {
                            e = e9;
                            inputStream = null;
                            r122 = 0;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                            obj = null;
                        }
                    } catch (Error e10) {
                        e = e10;
                        inputStream = null;
                        outputStream = null;
                        r122 = outputStream;
                        e.printStackTrace();
                        Log.i(a.f6783a, "https NetworkCommunicationError!");
                        this.f6832b.j = null;
                        this.f6832b.a(false);
                        if (httpsURLConnection != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (r122 == 0) {
                        }
                        r122.close();
                    } catch (Exception e11) {
                        e = e11;
                        inputStream = null;
                        outputStream = null;
                        r122 = outputStream;
                        e.printStackTrace();
                        Log.i(a.f6783a, "https NetworkCommunicationException!");
                        this.f6832b.j = null;
                        this.f6832b.a(false);
                        if (httpsURLConnection != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (r122 == 0) {
                        }
                        r122.close();
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        outputStream = null;
                        obj = null;
                    }
                } catch (Error e12) {
                    e = e12;
                    inputStream = null;
                    httpsURLConnection = null;
                    outputStream = httpsURLConnection;
                    r122 = outputStream;
                    e.printStackTrace();
                    Log.i(a.f6783a, "https NetworkCommunicationError!");
                    this.f6832b.j = null;
                    this.f6832b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r122 == 0) {
                    }
                    r122.close();
                } catch (Exception e13) {
                    e = e13;
                    inputStream = null;
                    httpsURLConnection = null;
                    outputStream = httpsURLConnection;
                    r122 = outputStream;
                    e.printStackTrace();
                    Log.i(a.f6783a, "https NetworkCommunicationException!");
                    this.f6832b.j = null;
                    this.f6832b.a(false);
                    if (httpsURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r122 == 0) {
                    }
                    r122.close();
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    outputStream = null;
                    r12 = outputStream;
                    if (httpsURLConnection2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r12 != 0) {
                    }
                    throw th;
                }
                r122.close();
            } catch (Exception unused10) {
                Log.d(a.f6783a, "close baos IOException!");
            }
        }
    }
}
