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
        dVar.jf(this.bTV.md5).b(new com.baidu.prologue.business.a.a((Activity) this.mContext)).dp(true).dq(true).jg("-1");
        File aT = com.baidu.prologue.business.data.d.aT(this.bTV.url, this.bTV.md5);
        if (aT.exists()) {
            dVar.v(aT);
        } else {
            dVar.je(this.bTV.url);
        }
    }
}
