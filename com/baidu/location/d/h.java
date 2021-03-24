package com.baidu.location.d;

import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f6711b;

    public h(e eVar, String str) {
        this.f6711b = eVar;
        this.f6710a = str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x01cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00f9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b6  */
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
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.ByteArrayOutputStream] */
    @Override // java.lang.Thread, java.lang.Runnable
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
        this.f6711b.a();
        this.f6711b.b();
        this.f6711b.f6705h = this.f6710a;
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                stringBuffer = new StringBuffer();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(this.f6711b.f6705h).openConnection();
                try {
                    httpsURLConnection.setInstanceFollowRedirects(false);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setConnectTimeout(a.f6669b);
                    httpsURLConnection.setReadTimeout(a.f6670c);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    for (Map.Entry<String, Object> entry : this.f6711b.k.entrySet()) {
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
                                    this.f6711b.j = new String(r122.toByteArray(), "utf-8");
                                    this.f6711b.a(true);
                                    inputStream2 = inputStream;
                                    r122 = r122;
                                } catch (Error e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    Log.i(a.f6668a, "https NetworkCommunicationError!");
                                    this.f6711b.j = null;
                                    this.f6711b.a(false);
                                    if (httpsURLConnection != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (r122 == 0) {
                                    }
                                    r122.close();
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    Log.i(a.f6668a, "https NetworkCommunicationException!");
                                    this.f6711b.j = null;
                                    this.f6711b.a(false);
                                    if (httpsURLConnection != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (r122 == 0) {
                                    }
                                    r122.close();
                                }
                            } catch (Error e4) {
                                e = e4;
                                r122 = 0;
                            } catch (Exception e5) {
                                e = e5;
                                r122 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                obj = null;
                                httpsURLConnection2 = httpsURLConnection;
                                r12 = obj;
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
                        } else {
                            this.f6711b.j = null;
                            this.f6711b.a(false);
                            r122 = 0;
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused) {
                                Log.d(a.f6668a, "close os IOException!");
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused2) {
                                Log.d(a.f6668a, "close is IOException!");
                            }
                        }
                        if (r122 == 0) {
                            return;
                        }
                    } catch (Error e6) {
                        e = e6;
                        inputStream = null;
                        r122 = 0;
                    } catch (Exception e7) {
                        e = e7;
                        inputStream = null;
                        r122 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        obj = null;
                    }
                } catch (Error e8) {
                    e = e8;
                    inputStream = null;
                    outputStream = null;
                    r122 = outputStream;
                    e.printStackTrace();
                    Log.i(a.f6668a, "https NetworkCommunicationError!");
                    this.f6711b.j = null;
                    this.f6711b.a(false);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused3) {
                            Log.d(a.f6668a, "close os IOException!");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                            Log.d(a.f6668a, "close is IOException!");
                        }
                    }
                    if (r122 == 0) {
                        return;
                    }
                    r122.close();
                } catch (Exception e9) {
                    e = e9;
                    inputStream = null;
                    outputStream = null;
                    r122 = outputStream;
                    e.printStackTrace();
                    Log.i(a.f6668a, "https NetworkCommunicationException!");
                    this.f6711b.j = null;
                    this.f6711b.a(false);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused5) {
                            Log.d(a.f6668a, "close os IOException!");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused6) {
                            Log.d(a.f6668a, "close is IOException!");
                        }
                    }
                    if (r122 == 0) {
                        return;
                    }
                    r122.close();
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    outputStream = null;
                    obj = null;
                }
            } catch (Error e10) {
                e = e10;
                inputStream = null;
                httpsURLConnection = null;
                outputStream = httpsURLConnection;
                r122 = outputStream;
                e.printStackTrace();
                Log.i(a.f6668a, "https NetworkCommunicationError!");
                this.f6711b.j = null;
                this.f6711b.a(false);
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
                httpsURLConnection = null;
                outputStream = httpsURLConnection;
                r122 = outputStream;
                e.printStackTrace();
                Log.i(a.f6668a, "https NetworkCommunicationException!");
                this.f6711b.j = null;
                this.f6711b.a(false);
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
                r12 = outputStream;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception unused7) {
                        Log.d(a.f6668a, "close os IOException!");
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused8) {
                        Log.d(a.f6668a, "close is IOException!");
                    }
                }
                if (r12 != 0) {
                    try {
                        r12.close();
                    } catch (Exception unused9) {
                        Log.d(a.f6668a, "close baos IOException!");
                    }
                }
                throw th;
            }
        } catch (Error e12) {
            e = e12;
            inputStream = null;
            httpsURLConnection = null;
        } catch (Exception e13) {
            e = e13;
            inputStream = null;
            httpsURLConnection = null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            outputStream = null;
        }
        try {
            r122.close();
        } catch (Exception unused10) {
            Log.d(a.f6668a, "close baos IOException!");
        }
    }
}
