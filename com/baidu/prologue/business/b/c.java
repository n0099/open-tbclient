package com.baidu.prologue.business.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.c.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes5.dex */
public class c extends a<d> {
    public c(@NonNull Context context, @NonNull e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(d dVar) {
        super.a((c) dVar);
        dVar.iV(this.cpp.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).eh(true).ei(true).iW("-1");
        File be = com.baidu.prologue.business.data.d.be(this.cpp.url, this.cpp.md5);
        if (be.exists()) {
            dVar.w(be);
        } else {
            dVar.iU(this.cpp.url);
        }
    }
}
