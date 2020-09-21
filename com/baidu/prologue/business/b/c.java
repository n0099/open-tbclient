package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes10.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.iD(this.bNm.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).di(true).dj(true).iE("-1");
        File aO = com.baidu.prologue.business.data.d.aO(this.bNm.url, this.bNm.md5);
        if (aO.exists()) {
            dVar.r(aO);
        } else {
            dVar.iC(this.bNm.url);
        }
    }
}
