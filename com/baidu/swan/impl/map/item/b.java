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
/* loaded from: classes25.dex */
public class b {
    public static final Boolean eiP = true;
    public d eiL;
    public Marker eiM;
    public Marker eiN;
    public View eiO;
    public ViewGroup eiQ;
    public Marker eiR;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes25.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.eiM != null) {
            this.eiM.setPosition(latLng);
            this.eiL.dfk.latitude = latLng.latitude;
            this.eiL.dfk.longitude = latLng.longitude;
            if (this.eiR != null) {
                this.eiR.setPosition(latLng);
            }
            if (eiP.booleanValue()) {
                if (this.eiN != null) {
                    this.eiN.setPosition(latLng);
                }
                if (this.eiQ != null) {
                    cVar.ejb.removeView(this.eiQ);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.ejb.addView(this.eiQ, builder.build());
                    this.eiQ.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.eiL != null && this.eiL.dfN != null && this.eiL.dfN.isValid() && this.eiL.dfP != null && this.eiO == null && !TextUtils.equals(this.eiL.dfN.cph, "ALWAYS")) {
            cVar.ejb.removeView(this.eiQ);
            this.eiQ.removeView(this.eiO);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.eiL);
            this.eiO = a2;
            this.eiQ.addView(a2, 0);
            this.eiQ.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.eiM.getPosition());
            Bitmap bitmap = this.eiM.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.eiL.dfP.y)) + 0.0d));
            cVar.ejb.addView(this.eiQ, builder.build());
            this.eiQ.setAlpha(0.0f);
            if (this.eiR != null) {
                this.eiR.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.eiQ);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.eiR = (Marker) cVar.ejb.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.eiL.dfk.latitude, this.eiL.dfk.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.eiL.dfP.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.eiL.dfP.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.eiM != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.eiM.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean eiS = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.eiS && animatedFraction > 0.99d) {
                        this.eiS = true;
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
