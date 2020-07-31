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
    public static final Boolean dra = true;
    public d dqW;
    public Marker dqX;
    public Marker dqY;
    public View dqZ;
    public ViewGroup drb;
    public Marker drc;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes19.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dqX != null) {
            this.dqX.setPosition(latLng);
            this.dqW.cpG.latitude = latLng.latitude;
            this.dqW.cpG.longitude = latLng.longitude;
            if (this.drc != null) {
                this.drc.setPosition(latLng);
            }
            if (dra.booleanValue()) {
                if (this.dqY != null) {
                    this.dqY.setPosition(latLng);
                }
                if (this.drb != null) {
                    cVar.drm.removeView(this.drb);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.drm.addView(this.drb, builder.build());
                    this.drb.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dqW != null && this.dqW.cqi != null && this.dqW.cqi.isValid() && this.dqW.cqk != null && this.dqZ == null && !TextUtils.equals(this.dqW.cqi.aoP, "ALWAYS")) {
            cVar.drm.removeView(this.drb);
            this.drb.removeView(this.dqZ);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dqW);
            this.dqZ = a2;
            this.drb.addView(a2, 0);
            this.drb.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dqX.getPosition());
            Bitmap bitmap = this.dqX.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dqW.cqk.y)) + 0.0d));
            cVar.drm.addView(this.drb, builder.build());
            this.drb.setAlpha(0.0f);
            if (this.drc != null) {
                this.drc.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.drb);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.drc = (Marker) cVar.drm.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dqW.cpG.latitude, this.dqW.cpG.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dqW.cqk.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dqW.cqk.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dqX != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dqX.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean drd = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.drd && animatedFraction > 0.99d) {
                        this.drd = true;
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
