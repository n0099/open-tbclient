package com.baidu.lbsapi.panoramaview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes3.dex */
public class ImageMarker extends a {
    private Drawable a;
    private Bitmap b;
    private String c;

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        if (this.c != null && !this.c.equals("")) {
            bundle.putInt("markerType", 1001);
            bundle.putString("image_url", this.c);
        } else {
            bundle.putInt("markerType", 1002);
        }
        return super.toBundle(str, bundle);
    }

    public void setMarker(Drawable drawable) {
        this.a = drawable;
        if (drawable != null) {
            this.b = ((BitmapDrawable) this.a).getBitmap();
            if (this.b == null) {
                throw new IllegalStateException("when add an overlay item, it must have image info, can not be null");
            }
            if (this.b.getConfig() != Bitmap.Config.ARGB_8888) {
                this.b = this.b.copy(Bitmap.Config.ARGB_8888, true);
            }
        }
    }

    public void setMarker(String str) {
        this.c = str;
    }

    public Drawable getMarkerDrawable() {
        return this.a;
    }

    public Bitmap getMarkerBitmap() {
        return this.b;
    }
}
