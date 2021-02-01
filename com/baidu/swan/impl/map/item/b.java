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
/* loaded from: classes9.dex */
public class b {
    public static final Boolean epn = true;
    public d epj;
    public Marker epk;
    public Marker epl;
    public View epm;
    public ViewGroup epo;
    public Marker epp;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes9.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.epk != null) {
            this.epk.setPosition(latLng);
            this.epj.dhA.latitude = latLng.latitude;
            this.epj.dhA.longitude = latLng.longitude;
            if (this.epp != null) {
                this.epp.setPosition(latLng);
            }
            if (epn.booleanValue()) {
                if (this.epl != null) {
                    this.epl.setPosition(latLng);
                }
                if (this.epo != null) {
                    cVar.epz.removeView(this.epo);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.epz.addView(this.epo, builder.build());
                    this.epo.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.epj != null && this.epj.die != null && this.epj.die.isValid() && this.epj.dig != null && this.epm == null && !TextUtils.equals(this.epj.die.ctk, "ALWAYS")) {
            cVar.epz.removeView(this.epo);
            this.epo.removeView(this.epm);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.epj);
            this.epm = a2;
            this.epo.addView(a2, 0);
            this.epo.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.epk.getPosition());
            Bitmap bitmap = this.epk.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.epj.dig.y)) + 0.0d));
            cVar.epz.addView(this.epo, builder.build());
            this.epo.setAlpha(0.0f);
            if (this.epp != null) {
                this.epp.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.epo);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.epp = (Marker) cVar.epz.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.epj.dhA.latitude, this.epj.dhA.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.epj.dig.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.epj.dig.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.epk != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.epk.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean epq = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.epq && animatedFraction > 0.99d) {
                        this.epq = true;
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
