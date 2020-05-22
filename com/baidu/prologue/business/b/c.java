package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes6.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.gJ(this.bAx.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).cU(true).cV(true).gK("-1");
        File aI = com.baidu.prologue.business.data.d.aI(this.bAx.url, this.bAx.md5);
        if (aI.exists()) {
            dVar.q(aI);
        } else {
            dVar.gI(this.bAx.url);
        }
    }
}
