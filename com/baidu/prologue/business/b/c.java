package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes14.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.jF(this.cgt.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).dM(true).dN(true).jG("-1");
        File aZ = com.baidu.prologue.business.data.d.aZ(this.cgt.url, this.cgt.md5);
        if (aZ.exists()) {
            dVar.v(aZ);
        } else {
            dVar.jE(this.cgt.url);
        }
    }
}
