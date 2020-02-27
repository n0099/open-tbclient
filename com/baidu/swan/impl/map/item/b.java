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
    public static final Boolean cwf = true;
    public d cwb;
    public Marker cwc;
    public Marker cwd;
    public View cwe;
    public ViewGroup cwg;
    public Marker cwh;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cwc != null) {
            this.cwc.setPosition(latLng);
            this.cwb.bzK.latitude = latLng.latitude;
            this.cwb.bzK.longitude = latLng.longitude;
            if (this.cwh != null) {
                this.cwh.setPosition(latLng);
            }
            if (cwf.booleanValue()) {
                if (this.cwd != null) {
                    this.cwd.setPosition(latLng);
                }
                if (this.cwg != null) {
                    cVar.cwr.removeView(this.cwg);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cwr.addView(this.cwg, builder.build());
                    this.cwg.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cwb != null && this.cwb.bAm != null && this.cwb.bAm.isValid() && this.cwb.bAo != null && this.cwe == null && !TextUtils.equals(this.cwb.bAm.Tw, "ALWAYS")) {
            cVar.cwr.removeView(this.cwg);
            this.cwg.removeView(this.cwe);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cwb);
            this.cwe = a2;
            this.cwg.addView(a2, 0);
            this.cwg.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cwc.getPosition());
            Bitmap bitmap = this.cwc.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cwb.bAo.y)) + 0.0d));
            cVar.cwr.addView(this.cwg, builder.build());
            this.cwg.setAlpha(0.0f);
            if (this.cwh != null) {
                this.cwh.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cwg);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cwh = (Marker) cVar.cwr.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cwb.bzK.latitude, this.cwb.bzK.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cwb.bAo.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cwb.bAo.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cwc != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cwc.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cwi = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cwi && animatedFraction > 0.99d) {
                        this.cwi = true;
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
