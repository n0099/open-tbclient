package com.baidu.location.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ f c;

    public g(f fVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = fVar;
        this.a = str;
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01c7 A[Catch: Exception -> 0x01cb, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x01cb, blocks: (B:91:0x01a2, B:108:0x01c7), top: B:153:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d2 A[LOOP:0: B:5:0x001e->B:114:0x01d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01fa A[EDGE_INSN: B:176:0x01fa->B:132:0x01fa ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b0  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        OutputStream outputStream;
        OutputStream outputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        StringBuffer stringBuffer;
        HttpsURLConnection httpsURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f fVar = this.c;
            fVar.g = d.c;
            fVar.a();
            int i = this.c.h;
            HttpsURLConnection httpsURLConnection2 = null;
            while (i > 0) {
                try {
                    URL url = new URL(this.c.g);
                    stringBuffer = new StringBuffer();
                    for (Map.Entry<String, Object> entry : this.c.j.entrySet()) {
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append("&");
                    }
                    if (stringBuffer.length() > 0) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                } catch (Error unused) {
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setConnectTimeout(a.a);
                    httpsURLConnection.setReadTimeout(a.a);
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    if (k.aw != null) {
                        httpsURLConnection.setRequestProperty("bd-loc-android", k.aw);
                    }
                    if (!TextUtils.isEmpty(this.a)) {
                        httpsURLConnection.setRequestProperty("Host", this.a);
                    }
                    OutputStream outputStream3 = httpsURLConnection.getOutputStream();
                    try {
                        outputStream3.write(stringBuffer.toString().getBytes());
                        outputStream3.flush();
                        if (httpsURLConnection.getResponseCode() == 200) {
                            inputStream2 = httpsURLConnection.getInputStream();
                            try {
                                String contentEncoding = httpsURLConnection.getContentEncoding();
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    inputStream2 = new GZIPInputStream(new BufferedInputStream(inputStream2));
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                    this.c.i = new String(byteArrayOutputStream.toByteArray(), IMAudioTransRequest.CHARSET);
                                    if (this.b) {
                                        this.c.l = byteArrayOutputStream.toByteArray();
                                    }
                                    this.c.a(true);
                                    z = true;
                                } catch (Error unused3) {
                                    outputStream = outputStream3;
                                    httpsURLConnection2 = httpsURLConnection;
                                    try {
                                        Log.d("baidu_location_service", "NetworkCommunicationError!");
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused4) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception unused5) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused6) {
                                                Log.d("baidu_location_service", "close baos IOException!");
                                            }
                                        }
                                        z = false;
                                        if (z) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStream2;
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused7) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused8) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused9) {
                                                Log.d("baidu_location_service", "close baos IOException!");
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused10) {
                                    outputStream2 = outputStream3;
                                    httpsURLConnection2 = httpsURLConnection;
                                    Log.d("baidu_location_service", "NetworkCommunicationException!");
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception unused11) {
                                            Log.d("baidu_location_service", "close os IOException!");
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused12) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    outputStream = outputStream3;
                                    httpsURLConnection2 = httpsURLConnection;
                                    inputStream = inputStream2;
                                    if (httpsURLConnection2 != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    throw th;
                                }
                            } catch (Error unused13) {
                                outputStream = outputStream3;
                                httpsURLConnection2 = httpsURLConnection;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationError!");
                                if (httpsURLConnection2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                z = false;
                                if (z) {
                                }
                            } catch (Exception unused14) {
                                outputStream2 = outputStream3;
                                httpsURLConnection2 = httpsURLConnection;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationException!");
                                if (httpsURLConnection2 != null) {
                                }
                                if (outputStream2 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                z = false;
                                if (z) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                outputStream = outputStream3;
                                httpsURLConnection2 = httpsURLConnection;
                                inputStream = inputStream2;
                                byteArrayOutputStream = null;
                                if (httpsURLConnection2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                throw th;
                            }
                        } else {
                            z = false;
                            inputStream2 = null;
                            byteArrayOutputStream = null;
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Exception unused15) {
                                Log.d("baidu_location_service", "close os IOException!");
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused16) {
                                Log.d("baidu_location_service", "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused17) {
                                Log.d("baidu_location_service", "close baos IOException!");
                            }
                        }
                        httpsURLConnection2 = httpsURLConnection;
                    } catch (Error unused18) {
                        outputStream = outputStream3;
                        httpsURLConnection2 = httpsURLConnection;
                        inputStream2 = null;
                        byteArrayOutputStream = null;
                        Log.d("baidu_location_service", "NetworkCommunicationError!");
                        if (httpsURLConnection2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        z = false;
                        if (z) {
                        }
                    } catch (Exception unused19) {
                        outputStream2 = outputStream3;
                        httpsURLConnection2 = httpsURLConnection;
                        inputStream2 = null;
                        byteArrayOutputStream = null;
                        Log.d("baidu_location_service", "NetworkCommunicationException!");
                        if (httpsURLConnection2 != null) {
                        }
                        if (outputStream2 != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        z = false;
                        if (z) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = outputStream3;
                        httpsURLConnection2 = httpsURLConnection;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        if (httpsURLConnection2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Error unused20) {
                    httpsURLConnection2 = httpsURLConnection;
                    outputStream = null;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    Log.d("baidu_location_service", "NetworkCommunicationError!");
                    if (httpsURLConnection2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    z = false;
                    if (z) {
                    }
                } catch (Exception unused21) {
                    httpsURLConnection2 = httpsURLConnection;
                    outputStream2 = null;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    Log.d("baidu_location_service", "NetworkCommunicationException!");
                    if (httpsURLConnection2 != null) {
                    }
                    if (outputStream2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    z = false;
                    if (z) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpsURLConnection2 = httpsURLConnection;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    if (httpsURLConnection2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
                if (z) {
                    break;
                }
                i--;
            }
            if (i > 0) {
                f.o = 0;
                return;
            }
            f.o++;
            f fVar2 = this.c;
            fVar2.i = null;
            fVar2.a(false);
        }
    }
}
