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
    public static final Boolean dBg = true;
    public d dBc;
    public Marker dBd;
    public Marker dBe;
    public View dBf;
    public ViewGroup dBh;
    public Marker dBi;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes19.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dBd != null) {
            this.dBd.setPosition(latLng);
            this.dBc.cxA.latitude = latLng.latitude;
            this.dBc.cxA.longitude = latLng.longitude;
            if (this.dBi != null) {
                this.dBi.setPosition(latLng);
            }
            if (dBg.booleanValue()) {
                if (this.dBe != null) {
                    this.dBe.setPosition(latLng);
                }
                if (this.dBh != null) {
                    cVar.dBs.removeView(this.dBh);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dBs.addView(this.dBh, builder.build());
                    this.dBh.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dBc != null && this.dBc.cyc != null && this.dBc.cyc.isValid() && this.dBc.cye != null && this.dBf == null && !TextUtils.equals(this.dBc.cyc.atP, "ALWAYS")) {
            cVar.dBs.removeView(this.dBh);
            this.dBh.removeView(this.dBf);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dBc);
            this.dBf = a2;
            this.dBh.addView(a2, 0);
            this.dBh.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dBd.getPosition());
            Bitmap bitmap = this.dBd.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dBc.cye.y)) + 0.0d));
            cVar.dBs.addView(this.dBh, builder.build());
            this.dBh.setAlpha(0.0f);
            if (this.dBi != null) {
                this.dBi.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dBh);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dBi = (Marker) cVar.dBs.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dBc.cxA.latitude, this.dBc.cxA.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dBc.cye.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dBc.cye.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dBd != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dBd.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dBj = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dBj && animatedFraction > 0.99d) {
                        this.dBj = true;
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
