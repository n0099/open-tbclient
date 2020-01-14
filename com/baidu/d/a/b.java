package com.baidu.d.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
import com.facebook.imagepipeline.g.c;
import com.facebook.imagepipeline.g.d;
/* loaded from: classes10.dex */
public class b implements com.facebook.imagepipeline.f.a {
    @Override // com.facebook.imagepipeline.f.a
    public boolean a(c cVar) {
        return cVar instanceof d;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Drawable b(c cVar) {
        if (cVar instanceof d) {
            d dVar = (d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, dVar.dpd());
            return (dVar.dph() == 0 || dVar.dph() == -1) ? bitmapDrawable : new i(bitmapDrawable, dVar.dph());
        }
        return null;
    }
}
