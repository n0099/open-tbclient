package com.baidu.tbadk.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.stats.o;
import com.baidu.adp.lib.util.h;
import com.baidu.loginshare.e;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.a.g;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a extends d {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
    @Override // com.baidu.adp.framework.b.f
    public final /* synthetic */ HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String D;
        HttpMessage httpMessage2 = httpMessage;
        HttpMessageTask httpMessageTask2 = httpMessageTask;
        if (httpMessageTask2 != null && (httpMessageTask2 instanceof com.baidu.tbadk.c.b)) {
            com.baidu.tbadk.c.b bVar = (com.baidu.tbadk.c.b) httpMessageTask2;
            if (bVar.n()) {
                httpMessage2.a();
            } else {
                if (bVar.p() && (D = TbadkApplication.D()) != null) {
                    httpMessage2.a("BDUSS", D);
                }
                if (bVar.q()) {
                    httpMessage2.a("_client_type", "2");
                    if (!TbadkApplication.j().G()) {
                        httpMessage2.a("apid", "sw");
                    }
                    httpMessage2.a("_client_version", n.c());
                    if (TbadkApplication.j().C() != null) {
                        httpMessage2.a("_phone_imei", TbadkApplication.j().C());
                    }
                    String B = TbadkApplication.B();
                    if (B != null) {
                        httpMessage2.a("_client_id", B);
                    }
                    String I = TbadkApplication.I();
                    if (I != null && I.length() > 0) {
                        httpMessage2.a("from", I);
                    }
                    String a = g.a();
                    if (a != null) {
                        String c = com.baidu.tbadk.coreExtra.a.a.a().c();
                        if ("3".equalsIgnoreCase(a)) {
                            if (TbadkApplication.j().P() == 1) {
                                c = String.valueOf(c) + "ka=open";
                            }
                        } else if (TbadkApplication.j().Q() == 1) {
                            c = String.valueOf(c) + "ka=open";
                        }
                        httpMessage2.b("Cookie", c);
                    }
                    if (bVar.o()) {
                        TbadkApplication.j();
                        httpMessage2.a("tbs", TbadkApplication.A());
                    }
                    String z = TbadkApplication.j().z();
                    if (z != null) {
                        httpMessage2.a("cuid", z);
                    }
                    httpMessage2.a("timestamp", Long.toString(System.currentTimeMillis()));
                    httpMessage2.a("model", Build.MODEL);
                }
                au a2 = at.a();
                if (a2 != null) {
                    httpMessage2.a("stTime", String.valueOf(a2.b));
                    httpMessage2.a("stSize", String.valueOf(a2.c));
                    httpMessage2.a("stTimesNum", String.valueOf(a2.d));
                    httpMessage2.a("stMode", String.valueOf(a2.e));
                    httpMessage2.a("stMethod", String.valueOf(a2.a));
                }
                int a3 = at.a(0);
                if (a3 == 0 && a2 != null) {
                    a3 = a2.d;
                }
                httpMessage2.a("stErrorNums", String.valueOf(a3));
                if (bVar.c() == HttpMessageTask.HTTP_METHOD.POST) {
                    if (httpMessage2.c()) {
                        a(httpMessage2);
                    } else if (bVar.r()) {
                        a(httpMessage2);
                    }
                }
            }
            if ((bVar.d() && !bVar.m()) || bVar.n()) {
                httpMessage2.b("Accept-Encoding", "gzip");
            }
            httpMessage2.b("Charset", "UTF-8");
            httpMessage2.b("User-Agent", "BaiduTieba for Android " + n.c());
            if (!TextUtils.isEmpty(TbadkApplication.E())) {
                httpMessage2.b("client_user_token", TbadkApplication.E());
            }
            String a4 = o.a();
            if (!TextUtils.isEmpty(a4)) {
                httpMessage2.b("sid", a4);
            }
            String a5 = g.a();
            if (!TextUtils.isEmpty(a5)) {
                httpMessage2.b(e.e, a5);
            }
        }
        return httpMessage2;
    }

    public a(int i) {
        super(0);
    }

    private static void a(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> d = httpMessage.d();
        for (int i = 0; d != null && i < d.size(); i++) {
            Map.Entry<String, Object> entry = d.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    stringBuffer.append(String.valueOf(key) + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.a("sign", h.a(stringBuffer.toString()));
    }
}
