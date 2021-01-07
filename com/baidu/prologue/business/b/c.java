package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
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
        dVar.kg(this.cug.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).el(true).em(true).kh("-1");
        File bf = com.baidu.prologue.business.data.d.bf(this.cug.url, this.cug.md5);
        if (bf.exists()) {
            dVar.x(bf);
        } else {
            dVar.kf(this.cug.url);
        }
    }
}
