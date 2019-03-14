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
/* loaded from: classes5.dex */
public class c {
    public static final Boolean bho = true;
    public d bhk;
    public Marker bhl;
    public Marker bhm;
    public View bhn;
    public ViewGroup bhp;
    public Marker bhq;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bhl != null) {
            this.bhl.setPosition(latLng);
            this.bhk.ayI.latitude = latLng.latitude;
            this.bhk.ayI.longitude = latLng.longitude;
            if (this.bhq != null) {
                this.bhq.setPosition(latLng);
            }
            if (bho.booleanValue()) {
                if (this.bhm != null) {
                    this.bhm.setPosition(latLng);
                }
                if (this.bhp != null) {
                    bVar.bhj.removeView(this.bhp);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bhj.addView(this.bhp, builder.build());
                    this.bhp.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bhk != null && this.bhk.azh != null && this.bhk.azh.isValid() && this.bhk.azj != null && this.bhn == null && !TextUtils.equals(this.bhk.azh.adA, "ALWAYS")) {
            bVar.bhj.removeView(this.bhp);
            this.bhp.removeView(this.bhn);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bhk);
            this.bhn = a2;
            this.bhp.addView(a2, 0);
            this.bhp.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bhl.getPosition());
            Bitmap bitmap = this.bhl.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bhk.azj.y)) + 0.0d));
            bVar.bhj.addView(this.bhp, builder.build());
            this.bhp.setAlpha(0.0f);
            if (this.bhq != null) {
                this.bhq.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bhp);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bhq = (Marker) bVar.bhj.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bhk.ayI.latitude, this.bhk.ayI.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bhk.azj.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bhk.azj.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bhl != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bhl.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bhr = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bhr && animatedFraction > 0.99d) {
                        this.bhr = true;
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
