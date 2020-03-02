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
    public static final Boolean cwg = true;
    public d cwc;
    public Marker cwd;
    public Marker cwe;
    public View cwf;
    public ViewGroup cwh;
    public Marker cwi;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cwd != null) {
            this.cwd.setPosition(latLng);
            this.cwc.bzL.latitude = latLng.latitude;
            this.cwc.bzL.longitude = latLng.longitude;
            if (this.cwi != null) {
                this.cwi.setPosition(latLng);
            }
            if (cwg.booleanValue()) {
                if (this.cwe != null) {
                    this.cwe.setPosition(latLng);
                }
                if (this.cwh != null) {
                    cVar.cws.removeView(this.cwh);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cws.addView(this.cwh, builder.build());
                    this.cwh.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cwc != null && this.cwc.bAn != null && this.cwc.bAn.isValid() && this.cwc.bAp != null && this.cwf == null && !TextUtils.equals(this.cwc.bAn.Tw, "ALWAYS")) {
            cVar.cws.removeView(this.cwh);
            this.cwh.removeView(this.cwf);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cwc);
            this.cwf = a2;
            this.cwh.addView(a2, 0);
            this.cwh.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cwd.getPosition());
            Bitmap bitmap = this.cwd.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cwc.bAp.y)) + 0.0d));
            cVar.cws.addView(this.cwh, builder.build());
            this.cwh.setAlpha(0.0f);
            if (this.cwi != null) {
                this.cwi.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cwh);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cwi = (Marker) cVar.cws.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cwc.bzL.latitude, this.cwc.bzL.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cwc.bAp.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cwc.bAp.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cwd != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cwd.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cwj = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cwj && animatedFraction > 0.99d) {
                        this.cwj = true;
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
