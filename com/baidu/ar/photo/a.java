package com.baidu.ar.photo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arrender.j;
import com.baidu.ar.f.g;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements TakePictureCallback {
    private String rK;
    private PhotoCallback rL;

    public void a(j jVar, String str, PhotoCallback photoCallback) {
        if (jVar == null || TextUtils.isEmpty(str) || photoCallback == null) {
            return;
        }
        this.rK = str;
        this.rL = photoCallback;
        jVar.a(this);
    }

    @Override // com.baidu.ar.arplay.core.filter.TakePictureCallback
    public void onPictureTake(boolean z, Bitmap bitmap, long j) {
        if (this.rL == null || TextUtils.isEmpty(this.rK)) {
            return;
        }
        g.d(new File(this.rK));
        g.a(this.rK, bitmap, 100);
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.rL.onPictureTake(z, this.rK);
    }
}
