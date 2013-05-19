package com.baidu.tbadk.a;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.c.a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    /* renamed from: a */
    public int b(String str, f fVar) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (fVar != null) {
            bitmap = fVar.b;
            if (bitmap != null) {
                bitmap2 = fVar.b;
                int height = bitmap2.getHeight();
                bitmap3 = fVar.b;
                return height * bitmap3.getWidth() * 2;
            }
        }
        return 0;
    }
}
