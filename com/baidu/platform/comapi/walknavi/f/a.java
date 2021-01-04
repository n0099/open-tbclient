package com.baidu.platform.comapi.walknavi.f;

import com.baidu.platform.comapi.wnplatform.n.c;
import com.baidu.platform.comapi.wnplatform.p.j;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes15.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4485a = false;

    /* renamed from: b  reason: collision with root package name */
    private c f4486b = null;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f4485a = false;
        this.f4486b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        this.f4485a = false;
        if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
            a();
            WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "playTTSText--->" + str + "type:" + i);
        if (com.baidu.platform.comapi.walknavi.b.f4401a == com.baidu.platform.comapi.walknavi.b.a().u()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.f4402b == com.baidu.platform.comapi.walknavi.b.a().u()) {
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
        this.f4486b = cVar;
        this.f4485a = true;
    }

    public void a() {
        if (this.f4486b != null) {
            this.f4486b.a();
        }
    }

    public int b() {
        if (this.f4486b != null) {
            return this.f4486b.b();
        }
        return 0;
    }

    public int a(String str, boolean z) {
        if (this.f4486b == null || this.f4485a) {
            return 0;
        }
        return this.f4486b.a(str, z);
    }

    public void c() {
        if (this.f4486b != null) {
            this.f4486b.c();
        }
    }
}
