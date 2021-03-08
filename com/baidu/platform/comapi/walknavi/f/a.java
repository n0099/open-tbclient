package com.baidu.platform.comapi.walknavi.f;

import com.baidu.platform.comapi.wnplatform.m.c;
import com.baidu.platform.comapi.wnplatform.o.i;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.comapi.wnplatform.m.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2954a = false;
    private c b = null;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f2954a = false;
        this.b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        this.f2954a = false;
        if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
            a();
            WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "playTTSText--->" + str + "type:" + i);
        if (com.baidu.platform.comapi.walknavi.b.f2901a == com.baidu.platform.comapi.walknavi.b.a().r()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.b == com.baidu.platform.comapi.walknavi.b.a().r()) {
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
        this.b = cVar;
        this.f2954a = true;
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
        if (this.b == null || this.f2954a) {
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
