package com.baidu.lbsapi.panoramaview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes2.dex */
public class ImageMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f6362a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f6363b;

    /* renamed from: c  reason: collision with root package name */
    public String f6364c;

    public Bitmap getMarkerBitmap() {
        return this.f6363b;
    }

    public Drawable getMarkerDrawable() {
        return this.f6362a;
    }

    public void setMarker(Drawable drawable) {
        this.f6362a = drawable;
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            this.f6363b = bitmap;
            if (bitmap != null) {
                Bitmap.Config config = bitmap.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    this.f6363b = this.f6363b.copy(config2, true);
                    return;
                }
                return;
            }
            throw new IllegalStateException("when add an overlay item, it must have image info, can not be null");
        }
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        String str2 = this.f6364c;
        if (str2 != null && !str2.equals("")) {
            bundle.putInt("markerType", 1001);
            bundle.putString("image_url", this.f6364c);
        } else {
            bundle.putInt("markerType", 1002);
        }
        return super.toBundle(str, bundle);
    }

    public void setMarker(String str) {
        this.f6364c = str;
    }
}
