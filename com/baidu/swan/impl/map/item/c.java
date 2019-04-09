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
    public static final Boolean bhs = true;
    public d bho;
    public Marker bhp;
    public Marker bhq;
    public View bhr;
    public ViewGroup bht;
    public Marker bhu;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bhp != null) {
            this.bhp.setPosition(latLng);
            this.bho.ayM.latitude = latLng.latitude;
            this.bho.ayM.longitude = latLng.longitude;
            if (this.bhu != null) {
                this.bhu.setPosition(latLng);
            }
            if (bhs.booleanValue()) {
                if (this.bhq != null) {
                    this.bhq.setPosition(latLng);
                }
                if (this.bht != null) {
                    bVar.bhn.removeView(this.bht);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bhn.addView(this.bht, builder.build());
                    this.bht.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bho != null && this.bho.azl != null && this.bho.azl.isValid() && this.bho.azn != null && this.bhr == null && !TextUtils.equals(this.bho.azl.adG, "ALWAYS")) {
            bVar.bhn.removeView(this.bht);
            this.bht.removeView(this.bhr);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bho);
            this.bhr = a2;
            this.bht.addView(a2, 0);
            this.bht.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bhp.getPosition());
            Bitmap bitmap = this.bhp.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bho.azn.y)) + 0.0d));
            bVar.bhn.addView(this.bht, builder.build());
            this.bht.setAlpha(0.0f);
            if (this.bhu != null) {
                this.bhu.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bht);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bhu = (Marker) bVar.bhn.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bho.ayM.latitude, this.bho.ayM.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bho.azn.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bho.azn.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bhp != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bhp.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bhv = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bhv && animatedFraction > 0.99d) {
                        this.bhv = true;
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
