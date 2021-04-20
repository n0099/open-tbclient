package com.baidu.platform.comapi.walknavi.f;

import com.baidu.platform.comapi.wnplatform.m.c;
import com.baidu.platform.comapi.wnplatform.o.i;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.comapi.wnplatform.m.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9603a = false;

    /* renamed from: b  reason: collision with root package name */
    public c f9604b = null;

    public int b() {
        c cVar = this.f9604b;
        if (cVar != null) {
            return cVar.b();
        }
        return 0;
    }

    public void c() {
        c cVar = this.f9604b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        this.f9603a = false;
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            return true;
        }
        a();
        WNaviTTSPlayer.setTTSPlayerListener(new b(this));
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        c();
        WNaviTTSPlayer.setTTSPlayerListener(null);
        this.f9603a = false;
        this.f9604b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "playTTSText--->" + str + "type:" + i);
        if (com.baidu.platform.comapi.walknavi.b.f9453a == com.baidu.platform.comapi.walknavi.b.a().r()) {
            return a(str, false);
        }
        if (com.baidu.platform.comapi.walknavi.b.f9454b == com.baidu.platform.comapi.walknavi.b.a().r()) {
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
        this.f9604b = cVar;
        this.f9603a = true;
    }

    public void a() {
        c cVar = this.f9604b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public int a(String str, boolean z) {
        c cVar = this.f9604b;
        if (cVar == null || this.f9603a) {
            return 0;
        }
        return cVar.a(str, z);
    }
}
