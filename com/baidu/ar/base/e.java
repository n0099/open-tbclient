package com.baidu.ar.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.TakePictureCallback;
import com.baidu.ar.TakePictureCallback2;
import com.baidu.ar.util.Utils;
import com.baidu.baiduarsdk.blend.b;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class e implements b.d {
    private static final String a = e.class.getSimpleName();
    private String b;
    private int c;
    private TakePictureCallback d;
    private Bitmap e;
    private TakePictureCallback2 f;

    public e(int i, TakePictureCallback2 takePictureCallback2) {
        this.c = 0;
        this.f = takePictureCallback2;
        this.c = i;
    }

    public e(String str, int i, TakePictureCallback takePictureCallback) {
        this.c = 0;
        this.b = str;
        this.c = i;
        this.d = takePictureCallback;
    }

    @Override // com.baidu.baiduarsdk.blend.b.d
    public void a(final int[] iArr, final int i, final int i2) {
        new Thread(new Runnable() { // from class: com.baidu.ar.base.e.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap rotateBitmap = Utils.rotateBitmap(Utils.scaleBitmap(Utils.createBitmapFromColors(iArr, i, i2)), (e.this.c + SubsamplingScaleImageView.ORIENTATION_180) % 360);
                if (e.this.f != null) {
                    e.this.e = rotateBitmap;
                    e.this.f.onPictureTake(true, e.this.e);
                    return;
                }
                Utils.saveBitmap(e.this.b, rotateBitmap, 100);
                if (rotateBitmap != null) {
                    rotateBitmap.recycle();
                }
                if (e.this.d != null) {
                    e.this.d.onPictureTake(TextUtils.isEmpty(e.this.b) ? false : true, e.this.b);
                }
            }
        }).start();
    }
}
