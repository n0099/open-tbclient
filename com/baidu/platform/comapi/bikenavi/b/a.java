package com.baidu.platform.comapi.bikenavi.b;

import com.baidu.platform.comapi.wnplatform.n.c;
import com.baidu.platform.comapi.wnplatform.p.j;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes3.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {

    /* renamed from: a  reason: collision with root package name */
    private c f4196a = null;

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        a();
        WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f4196a = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(c cVar) {
        this.f4196a = cVar;
    }

    public void a() {
        if (this.f4196a != null) {
            this.f4196a.a();
        }
    }

    public int b() {
        if (this.f4196a != null) {
            return this.f4196a.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        if (com.baidu.platform.comapi.walknavi.b.f4402a == com.baidu.platform.comapi.walknavi.b.a().u()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.f4403b == com.baidu.platform.comapi.walknavi.b.a().u()) {
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

    public int a(String str, boolean z) {
        if (this.f4196a != null) {
            return this.f4196a.a(str, z);
        }
        return 0;
    }

    public void c() {
        if (this.f4196a != null) {
            this.f4196a.c();
        }
    }
}
