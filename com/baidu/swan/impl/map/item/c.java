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
    public static final Boolean bhr = true;
    public d bhn;
    public Marker bho;
    public Marker bhp;
    public View bhq;
    public ViewGroup bhs;
    public Marker bht;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bho != null) {
            this.bho.setPosition(latLng);
            this.bhn.ayL.latitude = latLng.latitude;
            this.bhn.ayL.longitude = latLng.longitude;
            if (this.bht != null) {
                this.bht.setPosition(latLng);
            }
            if (bhr.booleanValue()) {
                if (this.bhp != null) {
                    this.bhp.setPosition(latLng);
                }
                if (this.bhs != null) {
                    bVar.bhm.removeView(this.bhs);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bhm.addView(this.bhs, builder.build());
                    this.bhs.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bhn != null && this.bhn.azk != null && this.bhn.azk.isValid() && this.bhn.azm != null && this.bhq == null && !TextUtils.equals(this.bhn.azk.adF, "ALWAYS")) {
            bVar.bhm.removeView(this.bhs);
            this.bhs.removeView(this.bhq);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bhn);
            this.bhq = a2;
            this.bhs.addView(a2, 0);
            this.bhs.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bho.getPosition());
            Bitmap bitmap = this.bho.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bhn.azm.y)) + 0.0d));
            bVar.bhm.addView(this.bhs, builder.build());
            this.bhs.setAlpha(0.0f);
            if (this.bht != null) {
                this.bht.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bhs);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bht = (Marker) bVar.bhm.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bhn.ayL.latitude, this.bhn.ayL.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bhn.azm.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bhn.azm.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bho != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bho.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bhu = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bhu && animatedFraction > 0.99d) {
                        this.bhu = true;
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
