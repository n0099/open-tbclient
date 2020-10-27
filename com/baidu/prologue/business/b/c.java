package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes19.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.jy(this.cct.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).dD(true).dE(true).jz("-1");
        File ba = com.baidu.prologue.business.data.d.ba(this.cct.url, this.cct.md5);
        if (ba.exists()) {
            dVar.v(ba);
        } else {
            dVar.jx(this.cct.url);
        }
    }
}
