package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.ae;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.e.f {
    private an a = null;
    private com.baidu.adp.lib.e.e b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.f
    /* renamed from: b */
    public d a(String str, com.baidu.adp.lib.e.e eVar) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.f
    /* renamed from: c */
    public d a(String str, com.baidu.adp.lib.e.d dVar) {
        String a = x.a(str, 1);
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
    /* renamed from: d */
    public d b(String str, com.baidu.adp.lib.e.d dVar) {
        this.b = dVar.a();
        String str2 = null;
        if (this.b != null) {
            str2 = (String) this.b.a("from");
        }
        d dVar2 = new d();
        this.a = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.a);
        }
        byte[] h = this.a.h();
        if (!this.a.c()) {
            dVar2.c = 3;
            dVar2.d = ae.a(y.neterror);
            return dVar2;
        } else if (h == null || h.length == 0) {
            dVar2.c = 4;
            dVar2.d = ae.a(y.voice_cache_error_no_file);
            return dVar2;
        } else {
            int a = e.a(str, h);
            if (a == 0) {
                dVar2.b = x.a(str, 1);
                dVar2.a = str;
            } else {
                dVar2.c = a;
                dVar2.d = d.a(a);
            }
            return dVar2;
        }
    }
}
