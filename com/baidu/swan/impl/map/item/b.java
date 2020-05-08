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
    public static final Boolean cVt = true;
    public d cVp;
    public Marker cVq;
    public Marker cVr;
    public View cVs;
    public ViewGroup cVu;
    public Marker cVv;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cVq != null) {
            this.cVq.setPosition(latLng);
            this.cVp.bYj.latitude = latLng.latitude;
            this.cVp.bYj.longitude = latLng.longitude;
            if (this.cVv != null) {
                this.cVv.setPosition(latLng);
            }
            if (cVt.booleanValue()) {
                if (this.cVr != null) {
                    this.cVr.setPosition(latLng);
                }
                if (this.cVu != null) {
                    cVar.cVF.removeView(this.cVu);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cVF.addView(this.cVu, builder.build());
                    this.cVu.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cVp != null && this.cVp.bYM != null && this.cVp.bYM.isValid() && this.cVp.bYO != null && this.cVs == null && !TextUtils.equals(this.cVp.bYM.alZ, "ALWAYS")) {
            cVar.cVF.removeView(this.cVu);
            this.cVu.removeView(this.cVs);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cVp);
            this.cVs = a2;
            this.cVu.addView(a2, 0);
            this.cVu.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cVq.getPosition());
            Bitmap bitmap = this.cVq.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cVp.bYO.y)) + 0.0d));
            cVar.cVF.addView(this.cVu, builder.build());
            this.cVu.setAlpha(0.0f);
            if (this.cVv != null) {
                this.cVv.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cVu);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cVv = (Marker) cVar.cVF.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cVp.bYj.latitude, this.cVp.bYj.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cVp.bYO.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cVp.bYO.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cVq != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cVq.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cVw = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cVw && animatedFraction > 0.99d) {
                        this.cVw = true;
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
