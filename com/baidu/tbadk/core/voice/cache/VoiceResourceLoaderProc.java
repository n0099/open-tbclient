package com.baidu.tbadk.core.voice.cache;

import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.ae;
import com.baidu.tbadk.l;
/* loaded from: classes.dex */
public class VoiceResourceLoaderProc implements com.baidu.adp.lib.e.f {
    private com.baidu.adp.lib.e.e extraInfo;
    private ak mNetwork = null;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.f
    public d getFromMemory(String str, com.baidu.adp.lib.e.e eVar) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.f
    public d getFromLocal(String str, com.baidu.adp.lib.e.d dVar) {
        String a = w.a(str, 1);
        if (a == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.a = str;
        dVar2.b = a;
        return dVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.f
    public d getFromRemote(String str, com.baidu.adp.lib.e.d dVar) {
        int i;
        this.extraInfo = dVar.a();
        String str2 = null;
        if (this.extraInfo != null) {
            str2 = (String) this.extraInfo.a("from");
        }
        d dVar2 = new d();
        this.mNetwork = new ak(String.valueOf(n.a) + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.extraInfo != null) {
            this.extraInfo.a("network", this.mNetwork);
        }
        byte[] h = this.mNetwork.h();
        if (!this.mNetwork.c()) {
            dVar2.c = 3;
            dVar2.d = ae.a(l.sync_mark_fail_con);
            return dVar2;
        } else if (h == null || h.length == 0) {
            dVar2.c = 4;
            dVar2.d = ae.a(l.voice_cache_error_no_file);
            return dVar2;
        } else {
            if (str == null) {
                i = 5;
            } else {
                i = h == null ? 6 : h.length == 0 ? 6 : w.a(str, h, 1) == null ? w.e() < ((long) h.length) ? 2 : 1 : 0;
            }
            if (i == 0) {
                dVar2.b = w.a(str, 1);
                dVar2.a = str;
            } else {
                dVar2.c = i;
                dVar2.d = d.a(i);
            }
            return dVar2;
        }
    }
}
