package com.baidu.location.d;

import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f5  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        URL url;
        HttpsURLConnection httpsURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2;
        URL url2;
        HttpsURLConnection httpsURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        this.b.a();
        this.b.b();
        this.b.h = this.a;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            url = new URL(this.b.h);
            try {
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection3.setInstanceFollowRedirects(false);
                    httpsURLConnection3.setDoOutput(true);
                    httpsURLConnection3.setDoInput(true);
                    httpsURLConnection3.setConnectTimeout(a.b);
                    httpsURLConnection3.setReadTimeout(a.c);
                    httpsURLConnection3.setRequestMethod("POST");
                    httpsURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection3.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
                    for (Map.Entry<String, Object> entry : this.b.k.entrySet()) {
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append(ETAG.EQUAL);
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append(ETAG.ITEM_SEPARATOR);
                    }
                    if (stringBuffer.length() > 0) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    OutputStream outputStream = httpsURLConnection3.getOutputStream();
                    try {
                        outputStream.write(stringBuffer.toString().getBytes());
                        outputStream.flush();
                        if (httpsURLConnection3.getResponseCode() == 200) {
                            InputStream inputStream3 = httpsURLConnection3.getInputStream();
                            try {
                                String contentEncoding = httpsURLConnection3.getContentEncoding();
                                inputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream3 : new GZIPInputStream(new BufferedInputStream(inputStream3));
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                        this.b.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                        this.b.a(true);
                                    } catch (Error e) {
                                        byteArrayOutputStream3 = outputStream;
                                        httpsURLConnection = httpsURLConnection3;
                                        e = e;
                                        try {
                                            e.printStackTrace();
                                            Log.i(a.a, "https NetworkCommunicationError!");
                                            this.b.j = null;
                                            this.b.a(false);
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            if (url != null) {
                                            }
                                            if (byteArrayOutputStream3 != null) {
                                                try {
                                                    byteArrayOutputStream3.close();
                                                } catch (Exception e2) {
                                                    Log.d(a.a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e3) {
                                                    Log.d(a.a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                    return;
                                                } catch (Exception e4) {
                                                    Log.d(a.a, "close baos IOException!");
                                                    return;
                                                }
                                            }
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            if (httpsURLConnection != null) {
                                            }
                                            if (url != null) {
                                            }
                                            if (byteArrayOutputStream3 != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        byteArrayOutputStream3 = byteArrayOutputStream;
                                        url2 = url;
                                        byteArrayOutputStream2 = outputStream;
                                        inputStream2 = inputStream;
                                        httpsURLConnection2 = httpsURLConnection3;
                                        e = e5;
                                        try {
                                            e.printStackTrace();
                                            Log.i(a.a, "https NetworkCommunicationException!");
                                            this.b.j = null;
                                            this.b.a(false);
                                            if (httpsURLConnection2 != null) {
                                                httpsURLConnection2.disconnect();
                                            }
                                            if (url2 != null) {
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                try {
                                                    byteArrayOutputStream2.close();
                                                } catch (Exception e6) {
                                                    Log.d(a.a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Exception e7) {
                                                    Log.d(a.a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream3 != null) {
                                                try {
                                                    byteArrayOutputStream3.close();
                                                    return;
                                                } catch (Exception e8) {
                                                    Log.d(a.a, "close baos IOException!");
                                                    return;
                                                }
                                            }
                                            return;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            url = url2;
                                            byteArrayOutputStream = byteArrayOutputStream3;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            httpsURLConnection = httpsURLConnection2;
                                            inputStream = inputStream2;
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            if (url != null) {
                                            }
                                            if (byteArrayOutputStream3 != null) {
                                                try {
                                                    byteArrayOutputStream3.close();
                                                } catch (Exception e9) {
                                                    Log.d(a.a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e10) {
                                                    Log.d(a.a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e11) {
                                                    Log.d(a.a, "close baos IOException!");
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        byteArrayOutputStream3 = outputStream;
                                        httpsURLConnection = httpsURLConnection3;
                                        th = th3;
                                        if (httpsURLConnection != null) {
                                        }
                                        if (url != null) {
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Error e12) {
                                    byteArrayOutputStream = null;
                                    byteArrayOutputStream3 = outputStream;
                                    httpsURLConnection = httpsURLConnection3;
                                    e = e12;
                                } catch (Exception e13) {
                                    url2 = url;
                                    inputStream2 = inputStream;
                                    httpsURLConnection2 = httpsURLConnection3;
                                    e = e13;
                                    byteArrayOutputStream2 = outputStream;
                                } catch (Throwable th4) {
                                    byteArrayOutputStream = null;
                                    byteArrayOutputStream3 = outputStream;
                                    httpsURLConnection = httpsURLConnection3;
                                    th = th4;
                                }
                            } catch (Error e14) {
                                inputStream = inputStream3;
                                byteArrayOutputStream = null;
                                byteArrayOutputStream3 = outputStream;
                                httpsURLConnection = httpsURLConnection3;
                                e = e14;
                            } catch (Exception e15) {
                                httpsURLConnection2 = httpsURLConnection3;
                                e = e15;
                                byteArrayOutputStream2 = outputStream;
                                inputStream2 = inputStream3;
                                url2 = url;
                            } catch (Throwable th5) {
                                inputStream = inputStream3;
                                byteArrayOutputStream = null;
                                byteArrayOutputStream3 = outputStream;
                                httpsURLConnection = httpsURLConnection3;
                                th = th5;
                            }
                        } else {
                            this.b.j = null;
                            this.b.a(false);
                            byteArrayOutputStream = null;
                            inputStream = null;
                        }
                        if (httpsURLConnection3 != null) {
                            httpsURLConnection3.disconnect();
                        }
                        if (url != null) {
                        }
                        if (outputStream != 0) {
                            try {
                                outputStream.close();
                            } catch (Exception e16) {
                                Log.d(a.a, "close os IOException!");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                                Log.d(a.a, "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e18) {
                                Log.d(a.a, "close baos IOException!");
                            }
                        }
                    } catch (Error e19) {
                        byteArrayOutputStream = null;
                        inputStream = null;
                        byteArrayOutputStream3 = outputStream;
                        httpsURLConnection = httpsURLConnection3;
                        e = e19;
                    } catch (Exception e20) {
                        url2 = url;
                        httpsURLConnection2 = httpsURLConnection3;
                        e = e20;
                        byteArrayOutputStream2 = outputStream;
                        inputStream2 = null;
                    } catch (Throwable th6) {
                        byteArrayOutputStream = null;
                        inputStream = null;
                        byteArrayOutputStream3 = outputStream;
                        httpsURLConnection = httpsURLConnection3;
                        th = th6;
                    }
                } catch (Error e21) {
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection = httpsURLConnection3;
                    e = e21;
                } catch (Exception e22) {
                    inputStream2 = null;
                    url2 = url;
                    httpsURLConnection2 = httpsURLConnection3;
                    e = e22;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th7) {
                    byteArrayOutputStream = null;
                    inputStream = null;
                    httpsURLConnection = httpsURLConnection3;
                    th = th7;
                }
            } catch (Error e23) {
                e = e23;
                byteArrayOutputStream = null;
                inputStream = null;
                httpsURLConnection = null;
            } catch (Exception e24) {
                e = e24;
                byteArrayOutputStream2 = null;
                inputStream2 = null;
                url2 = url;
                httpsURLConnection2 = null;
            } catch (Throwable th8) {
                th = th8;
                byteArrayOutputStream = null;
                inputStream = null;
                httpsURLConnection = null;
            }
        } catch (Error e25) {
            e = e25;
            byteArrayOutputStream = null;
            inputStream = null;
            url = null;
            httpsURLConnection = null;
        } catch (Exception e26) {
            e = e26;
            byteArrayOutputStream2 = null;
            inputStream2 = null;
            url2 = null;
            httpsURLConnection2 = null;
        } catch (Throwable th9) {
            th = th9;
            byteArrayOutputStream = null;
            inputStream = null;
            url = null;
            httpsURLConnection = null;
        }
    }
}
