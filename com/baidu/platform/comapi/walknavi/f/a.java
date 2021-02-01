package com.baidu.platform.comapi.walknavi.f;

import com.baidu.platform.comapi.wnplatform.m.c;
import com.baidu.platform.comapi.wnplatform.o.i;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.comapi.wnplatform.m.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4271a = false;

    /* renamed from: b  reason: collision with root package name */
    private c f4272b = null;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f4271a = false;
        this.f4272b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        this.f4271a = false;
        if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
            a();
            WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "playTTSText--->" + str + "type:" + i);
        if (com.baidu.platform.comapi.walknavi.b.f4188a == com.baidu.platform.comapi.walknavi.b.a().r()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.f4189b == com.baidu.platform.comapi.walknavi.b.a().r()) {
            if (i == 1) {
                i.a().b(com.baidu.platform.comapi.wnplatform.e.a.a().b());
                return 1;
            } else if (i == 2) {
                i.a().c(com.baidu.platform.comapi.wnplatform.e.a.a().c());
                return 1;
            } else if (i.a().b()) {
                return 0;
            } else {
                return a(str, false);
            }
        }
        return a(str, false);
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.a
    public void a(c cVar) {
        this.f4272b = cVar;
        this.f4271a = true;
    }

    public void a() {
        if (this.f4272b != null) {
            this.f4272b.a();
        }
    }

    public int b() {
        if (this.f4272b != null) {
            return this.f4272b.b();
        }
        return 0;
    }

    public int a(String str, boolean z) {
        if (this.f4272b == null || this.f4271a) {
            return 0;
        }
        return this.f4272b.a(str, z);
    }

    public void c() {
        if (this.f4272b != null) {
            this.f4272b.c();
        }
    }
}
