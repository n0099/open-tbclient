package com.baidu.prologue.business.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.baidu.prologue.business.data.d;
import com.baidu.prologue.business.data.e;
import java.io.File;
/* loaded from: classes5.dex */
public class b extends a<com.baidu.prologue.business.c.c> {
    protected static final boolean DEBUG = com.baidu.prologue.a.a.a.coo;

    public b(Context context, e eVar) {
        super(context, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.prologue.business.b.a
    public void a(com.baidu.prologue.business.c.c cVar) {
        super.a((b) cVar);
        File be = d.be(this.cpp.url, this.cpp.md5);
        if (be != null) {
            cVar.h(BitmapFactory.decodeFile(be.getAbsolutePath()));
        }
        cVar.setImageUrl(this.cpp.url);
    }
}
