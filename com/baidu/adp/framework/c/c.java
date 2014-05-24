package com.baidu.adp.framework.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.adp.lib.network.websocket.k;
import com.baidu.adp.lib.network.websocket.l;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c extends f {
    private static c c = null;
    private String d = null;
    private String e = null;
    private String[] f = null;
    private List<BasicNameValuePair> g = null;
    private l h = null;
    private k i = null;
    private e j = null;
    private int[] k = com.baidu.adp.framework.b.a;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private c() {
        this.a = new g(20000, TbConfig.BIG_IMAGE_MIN_CAPACITY, KirinConfig.READ_TIME_OUT);
        this.b = 3;
    }

    public void a(l lVar) {
        this.h = lVar;
    }

    public l b() {
        return this.h;
    }

    public void a(k kVar) {
        this.i = kVar;
    }

    public k c() {
        return this.i;
    }

    public String d() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String[] f() {
        return this.f;
    }

    public List<BasicNameValuePair> g() {
        return this.g;
    }

    public void a(List<BasicNameValuePair> list) {
        this.g = list;
    }

    public void h() {
        BdSocketLinkService.init(this);
    }

    public void a(boolean z, String str) {
        BdSocketLinkService.startService(z, str);
    }

    public void a(int i, String str) {
        BdSocketLinkService.close(i, str);
    }

    public void c(String str) {
        BdSocketLinkService.stopReConnStrategy(str);
    }

    public void a(d dVar) {
        MessageManager.getInstance().setOnMesssageCallback(dVar);
    }

    public void a(boolean z) {
        MessageManager.getInstance().setSocketMessageBlock(z);
    }

    public e i() {
        return this.j;
    }

    public void a(e eVar) {
        this.j = eVar;
    }
}
