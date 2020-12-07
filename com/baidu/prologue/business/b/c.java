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
        dVar.km(this.cna.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).ec(true).ed(true).kn("-1");
        File bg = com.baidu.prologue.business.data.d.bg(this.cna.url, this.cna.md5);
        if (bg.exists()) {
            dVar.t(bg);
        } else {
            dVar.kl(this.cna.url);
        }
    }
}
