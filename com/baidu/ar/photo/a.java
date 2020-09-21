package com.baidu.ar.photo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.filter.TakePictureCallback;
import com.baidu.ar.arrender.k;
import com.baidu.ar.g.i;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements TakePictureCallback {
    private String sO;
    private PhotoCallback sP;

    public void a(k kVar, String str, PhotoCallback photoCallback) {
        if (kVar == null || TextUtils.isEmpty(str) || photoCallback == null) {
            return;
        }
        this.sO = str;
        this.sP = photoCallback;
        kVar.a(this);
    }

    @Override // com.baidu.ar.arplay.core.filter.TakePictureCallback
    public void onPictureTake(boolean z, Bitmap bitmap, long j) {
        if (this.sP == null || TextUtils.isEmpty(this.sO)) {
            return;
        }
        i.d(new File(this.sO));
        i.a(this.sO, bitmap, 100);
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.sP.onPictureTake(z, this.sO);
    }
}
