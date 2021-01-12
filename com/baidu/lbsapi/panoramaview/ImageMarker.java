package com.baidu.lbsapi.panoramaview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes6.dex */
public class ImageMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f2507a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f2508b;
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
        this.f2507a = drawable;
        if (drawable != null) {
            this.f2508b = ((BitmapDrawable) this.f2507a).getBitmap();
            if (this.f2508b == null) {
                throw new IllegalStateException("when add an overlay item, it must have image info, can not be null");
            }
            if (this.f2508b.getConfig() != Bitmap.Config.ARGB_8888) {
                this.f2508b = this.f2508b.copy(Bitmap.Config.ARGB_8888, true);
            }
        }
    }

    public void setMarker(String str) {
        this.c = str;
    }

    public Drawable getMarkerDrawable() {
        return this.f2507a;
    }

    public Bitmap getMarkerBitmap() {
        return this.f2508b;
    }
}
