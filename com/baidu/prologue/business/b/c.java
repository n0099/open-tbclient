package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes9.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.ik(this.bLm.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).dk(true).dl(true).il("-1");
        File aO = com.baidu.prologue.business.data.d.aO(this.bLm.url, this.bLm.md5);
        if (aO.exists()) {
            dVar.r(aO);
        } else {
            dVar.ij(this.bLm.url);
        }
    }
}
