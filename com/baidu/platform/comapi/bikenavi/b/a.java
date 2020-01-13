package com.baidu.platform.comapi.bikenavi.b;

import com.baidu.platform.comapi.wnplatform.m.c;
import com.baidu.platform.comapi.wnplatform.o.i;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
/* loaded from: classes6.dex */
public class a extends com.baidu.platform.comapi.wnplatform.m.a {
    private c a = null;

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
        this.a = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.a
    public void a(c cVar) {
        this.a = cVar;
    }

    public void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public int b() {
        if (this.a != null) {
            return this.a.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) {
        if (com.baidu.platform.comapi.walknavi.b.a == com.baidu.platform.comapi.walknavi.b.a().r()) {
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

    public int a(String str, boolean z) {
        if (this.a != null) {
            return this.a.a(str, z);
        }
        return 0;
    }

    public void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
