package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes8.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.gP(this.bFI.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).db(true).dc(true).gQ("-1");
        File aK = com.baidu.prologue.business.data.d.aK(this.bFI.url, this.bFI.md5);
        if (aK.exists()) {
            dVar.q(aK);
        } else {
            dVar.gO(this.bFI.url);
        }
    }
}
