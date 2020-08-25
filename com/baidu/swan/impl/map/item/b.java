package com.baidu.swan.impl.map.item;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.w.a.a.d;
/* loaded from: classes19.dex */
public class b {
    public static final Boolean dBc = true;
    public d dAY;
    public Marker dAZ;
    public Marker dBa;
    public View dBb;
    public ViewGroup dBd;
    public Marker dBe;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes19.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dAZ != null) {
            this.dAZ.setPosition(latLng);
            this.dAY.cxw.latitude = latLng.latitude;
            this.dAY.cxw.longitude = latLng.longitude;
            if (this.dBe != null) {
                this.dBe.setPosition(latLng);
            }
            if (dBc.booleanValue()) {
                if (this.dBa != null) {
                    this.dBa.setPosition(latLng);
                }
                if (this.dBd != null) {
                    cVar.dBo.removeView(this.dBd);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dBo.addView(this.dBd, builder.build());
                    this.dBd.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dAY != null && this.dAY.cxY != null && this.dAY.cxY.isValid() && this.dAY.cya != null && this.dBb == null && !TextUtils.equals(this.dAY.cxY.atN, "ALWAYS")) {
            cVar.dBo.removeView(this.dBd);
            this.dBd.removeView(this.dBb);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dAY);
            this.dBb = a2;
            this.dBd.addView(a2, 0);
            this.dBd.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dAZ.getPosition());
            Bitmap bitmap = this.dAZ.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dAY.cya.y)) + 0.0d));
            cVar.dBo.addView(this.dBd, builder.build());
            this.dBd.setAlpha(0.0f);
            if (this.dBe != null) {
                this.dBe.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dBd);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dBe = (Marker) cVar.dBo.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dAY.cxw.latitude, this.dAY.cxw.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dAY.cya.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dAY.cya.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dAZ != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dAZ.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dBf = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dBf && animatedFraction > 0.99d) {
                        this.dBf = true;
                        if (aVar != null) {
                            aVar.onAnimationEnd();
                        }
                    }
                }
            });
            this.mValueAnimator.start();
        }
    }
}
