package com.baidu.ar.photo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arrender.l;
import com.baidu.ar.h.i;
import java.io.File;
/* loaded from: classes6.dex */
public class a implements TakePictureCallback {
    private String tB;
    private PhotoCallback tC;

    public void a(l lVar, String str, PhotoCallback photoCallback) {
        if (lVar == null || TextUtils.isEmpty(str) || photoCallback == null) {
            return;
        }
        this.tB = str;
        this.tC = photoCallback;
        lVar.a(this);
    }

    @Override // com.baidu.ar.arplay.core.renderer.TakePictureCallback
    public void onPictureTake(boolean z, Bitmap bitmap, long j) {
        if (this.tC == null || TextUtils.isEmpty(this.tB)) {
            return;
        }
        i.d(new File(this.tB));
        i.a(this.tB, bitmap, 100);
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.tC.onPictureTake(z, this.tB);
    }
}
