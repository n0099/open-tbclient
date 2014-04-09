package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.ae;
import com.baidu.tbadk.l;
/* loaded from: classes.dex */
public final class g implements com.baidu.adp.lib.e.f {
    private ak a = null;
    private com.baidu.adp.lib.e.e b;

    @Override // com.baidu.adp.lib.e.f
    public final /* synthetic */ Object a(String str, com.baidu.adp.lib.e.d dVar) {
        String a = w.a(str, 1);
        if (a == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.a = str;
        dVar2.b = a;
        return dVar2;
    }

    @Override // com.baidu.adp.lib.e.f
    public final /* bridge */ /* synthetic */ Object a(String str, com.baidu.adp.lib.e.e eVar) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.f
    public final /* synthetic */ Object b(String str, com.baidu.adp.lib.e.d dVar) {
        this.b = dVar.a();
        String str2 = this.b != null ? (String) this.b.a("from") : null;
        d dVar2 = new d();
        this.a = new ak(String.valueOf(n.a) + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.a);
        }
        byte[] h = this.a.h();
        if (!this.a.c()) {
            dVar2.c = 3;
            dVar2.d = ae.a(l.sync_mark_fail_con);
        } else if (h == null || h.length == 0) {
            dVar2.c = 4;
            dVar2.d = ae.a(l.voice_cache_error_no_file);
        } else {
            int i = str == null ? 5 : h == null ? 6 : h.length == 0 ? 6 : w.a(str, h, 1) == null ? w.e() < ((long) h.length) ? 2 : 1 : 0;
            if (i == 0) {
                dVar2.b = w.a(str, 1);
                dVar2.a = str;
            } else {
                dVar2.c = i;
                dVar2.d = d.a(i);
            }
        }
        return dVar2;
    }
}
