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
        dVar.gR(this.bFl.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).cZ(true).da(true).gS("-1");
        File aK = com.baidu.prologue.business.data.d.aK(this.bFl.url, this.bFl.md5);
        if (aK.exists()) {
            dVar.q(aK);
        } else {
            dVar.gQ(this.bFl.url);
        }
    }
}
