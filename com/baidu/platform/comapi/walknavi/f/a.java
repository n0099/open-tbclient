package com.baidu.platform.comapi.walknavi.f;

import com.baidu.platform.comapi.wnplatform.n.c;
import com.baidu.platform.comapi.wnplatform.p.j;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes26.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3010a = false;
    private c b = null;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f3010a = false;
        this.b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        this.f3010a = false;
        if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
            a();
            WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "playTTSText--->" + str + "type:" + i);
        if (com.baidu.platform.comapi.walknavi.b.f2957a == com.baidu.platform.comapi.walknavi.b.a().u()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.b == com.baidu.platform.comapi.walknavi.b.a().u()) {
            if (i == 1) {
                j.a().b(com.baidu.platform.comapi.wnplatform.f.a.a().b());
                return 1;
            } else if (i == 2) {
                j.a().c(com.baidu.platform.comapi.wnplatform.f.a.a().c());
                return 1;
            } else if (j.a().b()) {
                return 0;
            } else {
                return a(str, false);
            }
        }
        return a(str, false);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(c cVar) {
        this.b = cVar;
        this.f3010a = true;
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }

    public int b() {
        if (this.b != null) {
            return this.b.b();
        }
        return 0;
    }

    public int a(String str, boolean z) {
        if (this.b == null || this.f3010a) {
            return 0;
        }
        return this.b.a(str, z);
    }

    public void c() {
        if (this.b != null) {
            this.b.c();
        }
    }
}
