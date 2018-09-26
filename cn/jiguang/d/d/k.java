package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.service.Protocol;
import com.baidu.ar.msghandler.ComponentMessageType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class k {
    public static cn.jiguang.h.e lw;

    public static c a(String str, String str2, Context context, boolean z, int i, int i2) {
        try {
            try {
                try {
                    byte[] a = cn.jiguang.d.h.x.a(str2.getBytes("UTF-8"));
                    cn.jiguang.h.b bVar = new cn.jiguang.h.b(str);
                    bVar.setConnectTimeout(30000);
                    bVar.setReadTimeout(30000);
                    bVar.j(true);
                    bVar.k(true);
                    bVar.setUseCaches(false);
                    String a2 = cn.jiguang.d.h.a.a.a();
                    byte[] a3 = cn.jiguang.d.h.a.a.a(a, a2, i2 == 2 ? "0102030405060708" : "iop203040506aPk!");
                    bVar.f(a3);
                    bVar.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(a3.length));
                    bVar.m(true);
                    if (lw == null) {
                        try {
                            String cerTificate = Protocol.getCerTificate();
                            if (!TextUtils.isEmpty(cerTificate)) {
                                lw = new cn.jiguang.h.e(cerTificate);
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (lw != null) {
                        bVar.a(lw);
                    }
                    bVar.setRequestProperty("Accept", "application/jason");
                    bVar.setRequestProperty("Accept-Encoding", "gzip");
                    bVar.setRequestProperty("X-App-Key", cn.jiguang.d.a.b(context));
                    if (i2 == 2) {
                        bVar.n(true);
                        bVar.o(true);
                        bVar.l(true);
                        bVar.setRequestProperty(AUTH.WWW_AUTH_RESP, aa.a(a2));
                    } else {
                        bVar.n(false);
                        bVar.o(false);
                        bVar.setRequestProperty(AUTH.WWW_AUTH_RESP, "Basic " + aa.a(cn.jiguang.g.a.a(a3), a2));
                    }
                    bVar.setRequestProperty("Charset", "UTF-8");
                    while (i > 0) {
                        i--;
                        cn.jiguang.h.c b = cn.jiguang.h.d.b(context, bVar);
                        int responseCode = b.getResponseCode();
                        cn.jiguang.e.c.a("HttpHelper", "status code:" + responseCode + " retry left:" + i);
                        switch (responseCode) {
                            case 200:
                                return new c(0, b.cb());
                            case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                                return new c(-3, b.cb());
                            case HttpStatus.SC_NOT_FOUND /* 404 */:
                            case HttpStatus.SC_GONE /* 410 */:
                            case 429:
                                return new c(-1, b.cb());
                            case HttpStatus.SC_SERVICE_UNAVAILABLE /* 503 */:
                                return new c(-2, b.cb());
                            case ComponentMessageType.MSG_TYPE_LOGO_START /* 3005 */:
                                break;
                            default:
                                return responseCode >= 500 ? new c(-1, b.cb()) : new c(-2, b.cb());
                        }
                    }
                    return new c(-2, "Failed - retry enough");
                } catch (IOException e) {
                    return new c(-2, "zip err:" + e.getMessage());
                }
            } catch (UnsupportedEncodingException e2) {
                return new c(-2, "Exception - " + e2.getMessage());
            }
        } catch (AssertionError e3) {
            return new c(-2, "Catch AssertionError to avoid http close crash - " + e3.getMessage());
        } catch (Exception e4) {
            return new c(-2, "Exception - " + e4.getMessage());
        } catch (Throwable th2) {
            return new c(-2, "Exception - " + th2.getMessage());
        }
    }
}
