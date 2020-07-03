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
import com.baidu.swan.apps.x.a.a.d;
/* loaded from: classes12.dex */
public class b {
    public static final Boolean dlg = true;
    public d dlc;
    public Marker dld;
    public Marker dle;
    public View dlf;
    public ViewGroup dlh;
    public Marker dli;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dld != null) {
            this.dld.setPosition(latLng);
            this.dlc.cnA.latitude = latLng.latitude;
            this.dlc.cnA.longitude = latLng.longitude;
            if (this.dli != null) {
                this.dli.setPosition(latLng);
            }
            if (dlg.booleanValue()) {
                if (this.dle != null) {
                    this.dle.setPosition(latLng);
                }
                if (this.dlh != null) {
                    cVar.dls.removeView(this.dlh);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dls.addView(this.dlh, builder.build());
                    this.dlh.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dlc != null && this.dlc.cod != null && this.dlc.cod.isValid() && this.dlc.cof != null && this.dlf == null && !TextUtils.equals(this.dlc.cod.aoT, "ALWAYS")) {
            cVar.dls.removeView(this.dlh);
            this.dlh.removeView(this.dlf);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dlc);
            this.dlf = a2;
            this.dlh.addView(a2, 0);
            this.dlh.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dld.getPosition());
            Bitmap bitmap = this.dld.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dlc.cof.y)) + 0.0d));
            cVar.dls.addView(this.dlh, builder.build());
            this.dlh.setAlpha(0.0f);
            if (this.dli != null) {
                this.dli.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dlh);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dli = (Marker) cVar.dls.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dlc.cnA.latitude, this.dlc.cnA.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dlc.cof.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dlc.cof.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dld != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dld.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dlj = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dlj && animatedFraction > 0.99d) {
                        this.dlj = true;
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
