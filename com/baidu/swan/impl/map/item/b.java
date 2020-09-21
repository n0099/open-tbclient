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
/* loaded from: classes24.dex */
public class b {
    public static final Boolean dDh = true;
    public d dDd;
    public Marker dDe;
    public Marker dDf;
    public View dDg;
    public ViewGroup dDi;
    public Marker dDj;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes24.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dDe != null) {
            this.dDe.setPosition(latLng);
            this.dDd.czB.latitude = latLng.latitude;
            this.dDd.czB.longitude = latLng.longitude;
            if (this.dDj != null) {
                this.dDj.setPosition(latLng);
            }
            if (dDh.booleanValue()) {
                if (this.dDf != null) {
                    this.dDf.setPosition(latLng);
                }
                if (this.dDi != null) {
                    cVar.dDt.removeView(this.dDi);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dDt.addView(this.dDi, builder.build());
                    this.dDi.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dDd != null && this.dDd.cAd != null && this.dDd.cAd.isValid() && this.dDd.cAf != null && this.dDg == null && !TextUtils.equals(this.dDd.cAd.aur, "ALWAYS")) {
            cVar.dDt.removeView(this.dDi);
            this.dDi.removeView(this.dDg);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dDd);
            this.dDg = a2;
            this.dDi.addView(a2, 0);
            this.dDi.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dDe.getPosition());
            Bitmap bitmap = this.dDe.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dDd.cAf.y)) + 0.0d));
            cVar.dDt.addView(this.dDi, builder.build());
            this.dDi.setAlpha(0.0f);
            if (this.dDj != null) {
                this.dDj.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dDi);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dDj = (Marker) cVar.dDt.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dDd.czB.latitude, this.dDd.czB.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dDd.cAf.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dDd.cAf.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dDe != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dDe.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dDk = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dDk && animatedFraction > 0.99d) {
                        this.dDk = true;
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
