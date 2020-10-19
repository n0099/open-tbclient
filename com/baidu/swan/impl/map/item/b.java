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
    public static final Boolean dPi = true;
    public d dPe;
    public Marker dPf;
    public Marker dPg;
    public View dPh;
    public ViewGroup dPj;
    public Marker dPk;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes25.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dPf != null) {
            this.dPf.setPosition(latLng);
            this.dPe.cLG.latitude = latLng.latitude;
            this.dPe.cLG.longitude = latLng.longitude;
            if (this.dPk != null) {
                this.dPk.setPosition(latLng);
            }
            if (dPi.booleanValue()) {
                if (this.dPg != null) {
                    this.dPg.setPosition(latLng);
                }
                if (this.dPj != null) {
                    cVar.dPu.removeView(this.dPj);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dPu.addView(this.dPj, builder.build());
                    this.dPj.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dPe != null && this.dPe.cMi != null && this.dPe.cMi.isValid() && this.dPe.cMk != null && this.dPh == null && !TextUtils.equals(this.dPe.cMi.ava, "ALWAYS")) {
            cVar.dPu.removeView(this.dPj);
            this.dPj.removeView(this.dPh);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dPe);
            this.dPh = a2;
            this.dPj.addView(a2, 0);
            this.dPj.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dPf.getPosition());
            Bitmap bitmap = this.dPf.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dPe.cMk.y)) + 0.0d));
            cVar.dPu.addView(this.dPj, builder.build());
            this.dPj.setAlpha(0.0f);
            if (this.dPk != null) {
                this.dPk.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dPj);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dPk = (Marker) cVar.dPu.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dPe.cLG.latitude, this.dPe.cLG.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dPe.cMk.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dPe.cMk.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dPf != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dPf.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dPl = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dPl && animatedFraction > 0.99d) {
                        this.dPl = true;
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
