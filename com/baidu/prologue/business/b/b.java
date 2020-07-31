package com.baidu.prologue.business.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.baidu.prologue.business.data.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes8.dex */
public class b extends a<com.baidu.prologue.business.c.c> {
    protected static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;

    public b(Context context, e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(com.baidu.prologue.business.c.c cVar) {
        super.a((b) cVar);
        File aK = d.aK(this.bFI.url, this.bFI.md5);
        if (aK != null) {
            cVar.f(BitmapFactory.decodeFile(aK.getAbsolutePath()));
        }
        cVar.setImageUrl(this.bFI.url);
    }
}
