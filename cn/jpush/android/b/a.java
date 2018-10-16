package cn.jpush.android.b;

import android.content.Context;
import cn.jiguang.h.b;
import cn.jiguang.h.c;
import cn.jiguang.h.d;
import cn.jpush.android.d.f;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class a {
    public static c a(String str, int i, long j) {
        c cVar = null;
        if (j < 200 || j > 60000) {
            j = SystemScreenshotManager.DELAY_TIME;
        }
        int i2 = 0;
        while (true) {
            try {
                b bVar = new b(str);
                bVar.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
                bVar.setRequestProperty("Accept-Encoding", HTTP.IDENTITY_CODING);
                cVar = d.a((Context) null, bVar);
                if (cVar.getResponseCode() == 200) {
                    break;
                }
            } catch (AssertionError e) {
            } catch (Exception e2) {
            }
            if (i2 >= 5) {
                break;
            }
            i2++;
            try {
                Thread.sleep(j);
            } catch (InterruptedException e3) {
            }
        }
        return cVar;
    }

    public static byte[] a(String str, int i, long j, int i2) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 4 && (bArr = b(str, 5, 5000L)) == null; i3++) {
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r4.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] b(String str, int i, long j) {
        HttpURLConnection httpURLConnection;
        int i2;
        int i3;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        byte[] bArr;
        byte[] bArr2;
        int i4 = 0;
        i = (i <= 0 || i > 10) ? 1 : 1;
        if (j < 200 || j > 60000) {
            j = SystemScreenshotManager.DELAY_TIME;
        }
        int i5 = -1;
        int i6 = 0;
        InputStream inputStream2 = null;
        HttpURLConnection httpURLConnection3 = null;
        while (true) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    try {
                        httpURLConnection.setRequestProperty("Accept-Encoding", HTTP.IDENTITY_CODING);
                        httpURLConnection.addRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
                        i5 = httpURLConnection.getResponseCode();
                    } catch (Throwable th) {
                        httpURLConnection3 = httpURLConnection;
                        th = th;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e) {
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        throw th;
                    }
                } catch (SSLHandshakeException e2) {
                    f.a("HttpManager", "Catch SSLHandshakeException, http client execute error!");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        bArr = null;
                    } else {
                        bArr = null;
                    }
                    if (200 == i5) {
                        if (400 != i5 && 404 != i5) {
                            return null;
                        }
                        return null;
                    } else if (i4 == 0) {
                        return null;
                    } else {
                        try {
                            if (bArr.length < i4) {
                                return null;
                            }
                            return bArr;
                        } catch (Exception e4) {
                            return null;
                        }
                    }
                } catch (SSLPeerUnverifiedException e5) {
                    int i7 = i4;
                    i3 = i5;
                    inputStream = inputStream2;
                    httpURLConnection2 = httpURLConnection;
                    i2 = i7;
                    try {
                        f.d("HttpManager", "Catch SSLPeerUnverifiedException, http client execute error!");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            httpURLConnection3 = httpURLConnection2;
                            inputStream2 = inputStream;
                            i5 = i3;
                            i4 = i2;
                        } else {
                            httpURLConnection3 = httpURLConnection2;
                            inputStream2 = inputStream;
                            i5 = i3;
                            i4 = i2;
                        }
                        if (i6 >= i) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection3 = httpURLConnection2;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection3 = httpURLConnection;
                        if (i6 >= i) {
                        }
                    }
                    httpURLConnection3 = httpURLConnection;
                    if (i6 >= i) {
                    }
                }
            } catch (SSLHandshakeException e9) {
                httpURLConnection = httpURLConnection3;
            } catch (SSLPeerUnverifiedException e10) {
                i2 = i4;
                i3 = i5;
                inputStream = inputStream2;
                httpURLConnection2 = httpURLConnection3;
            } catch (Exception e11) {
                httpURLConnection = httpURLConnection3;
            } catch (Throwable th3) {
                th = th3;
            }
            if (i5 == 200) {
                i4 = httpURLConnection.getContentLength();
                inputStream2 = httpURLConnection.getInputStream();
                if (inputStream2 == null) {
                    bArr2 = null;
                    break;
                }
                bArr2 = d.f(inputStream2);
                break;
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e12) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                httpURLConnection3 = httpURLConnection;
                if (i6 >= i) {
                    return null;
                }
                int i8 = i6 + 1;
                try {
                    Thread.sleep(i8 * j);
                    i6 = i8;
                } catch (InterruptedException e13) {
                    i6 = i8;
                }
            }
            httpURLConnection3 = httpURLConnection;
            if (i6 >= i) {
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            bArr = bArr2;
        } else {
            bArr = bArr2;
        }
        if (200 == i5) {
        }
    }
}
