package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.service.Protocol;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class k {
    public static cn.jiguang.h.e mf;

    public static c a(String str, String str2, Context context, boolean z, int i, int i2) {
        try {
            try {
                try {
                    byte[] a = cn.jiguang.d.h.x.a(str2.getBytes(HTTP.UTF_8));
                    cn.jiguang.h.b bVar = new cn.jiguang.h.b(str);
                    bVar.setConnectTimeout(30000);
                    bVar.setReadTimeout(30000);
                    bVar.y(true);
                    bVar.z(true);
                    bVar.setUseCaches(false);
                    String a2 = cn.jiguang.d.h.a.a.a();
                    byte[] a3 = cn.jiguang.d.h.a.a.a(a, a2, i2 == 2 ? "0102030405060708" : "iop203040506aPk!");
                    bVar.i(a3);
                    bVar.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(a3.length));
                    bVar.B(true);
                    if (mf == null) {
                        try {
                            String cerTificate = Protocol.getCerTificate();
                            if (!TextUtils.isEmpty(cerTificate)) {
                                mf = new cn.jiguang.h.e(cerTificate);
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (mf != null) {
                        bVar.a(mf);
                    }
                    bVar.setRequestProperty("Accept", "application/jason");
                    bVar.setRequestProperty("Accept-Encoding", "gzip");
                    bVar.setRequestProperty("X-App-Key", cn.jiguang.d.a.b(context));
                    if (i2 == 2) {
                        bVar.C(true);
                        bVar.D(true);
                        bVar.A(true);
                        bVar.setRequestProperty(AUTH.WWW_AUTH_RESP, aa.a(a2));
                    } else {
                        bVar.C(false);
                        bVar.D(false);
                        bVar.setRequestProperty(AUTH.WWW_AUTH_RESP, "Basic " + aa.a(cn.jiguang.g.a.a(a3), a2));
                    }
                    bVar.setRequestProperty("Charset", HTTP.UTF_8);
                    while (i > 0) {
                        i--;
                        cn.jiguang.h.c b = cn.jiguang.h.d.b(context, bVar);
                        int responseCode = b.getResponseCode();
                        cn.jiguang.e.c.a("HttpHelper", "status code:" + responseCode + " retry left:" + i);
                        switch (responseCode) {
                            case 200:
                                return new c(0, b.cr());
                            case 401:
                                return new c(-3, b.cr());
                            case 404:
                            case 410:
                            case 429:
                                return new c(-1, b.cr());
                            case 503:
                                return new c(-2, b.cr());
                            case 3005:
                                break;
                            default:
                                return responseCode >= 500 ? new c(-1, b.cr()) : new c(-2, b.cr());
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
