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
import com.baidu.swan.apps.z.a.a.d;
/* loaded from: classes12.dex */
public class b {
    public static final Boolean cVo = true;
    public d cVk;
    public Marker cVl;
    public Marker cVm;
    public View cVn;
    public ViewGroup cVp;
    public Marker cVq;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cVl != null) {
            this.cVl.setPosition(latLng);
            this.cVk.bYd.latitude = latLng.latitude;
            this.cVk.bYd.longitude = latLng.longitude;
            if (this.cVq != null) {
                this.cVq.setPosition(latLng);
            }
            if (cVo.booleanValue()) {
                if (this.cVm != null) {
                    this.cVm.setPosition(latLng);
                }
                if (this.cVp != null) {
                    cVar.cVA.removeView(this.cVp);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cVA.addView(this.cVp, builder.build());
                    this.cVp.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cVk != null && this.cVk.bYG != null && this.cVk.bYG.isValid() && this.cVk.bYI != null && this.cVn == null && !TextUtils.equals(this.cVk.bYG.alT, "ALWAYS")) {
            cVar.cVA.removeView(this.cVp);
            this.cVp.removeView(this.cVn);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cVk);
            this.cVn = a2;
            this.cVp.addView(a2, 0);
            this.cVp.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cVl.getPosition());
            Bitmap bitmap = this.cVl.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cVk.bYI.y)) + 0.0d));
            cVar.cVA.addView(this.cVp, builder.build());
            this.cVp.setAlpha(0.0f);
            if (this.cVq != null) {
                this.cVq.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cVp);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cVq = (Marker) cVar.cVA.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cVk.bYd.latitude, this.cVk.bYd.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cVk.bYI.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cVk.bYI.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cVl != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cVl.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cVr = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cVr && animatedFraction > 0.99d) {
                        this.cVr = true;
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
