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
    public static final Boolean bnx = true;
    public d bnt;
    public Marker bnu;
    public Marker bnv;
    public View bnw;
    public ViewGroup bny;
    public Marker bnz;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bnu != null) {
            this.bnu.setPosition(latLng);
            this.bnt.azK.latitude = latLng.latitude;
            this.bnt.azK.longitude = latLng.longitude;
            if (this.bnz != null) {
                this.bnz.setPosition(latLng);
            }
            if (bnx.booleanValue()) {
                if (this.bnv != null) {
                    this.bnv.setPosition(latLng);
                }
                if (this.bny != null) {
                    bVar.bns.removeView(this.bny);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bns.addView(this.bny, builder.build());
                    this.bny.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bnt != null && this.bnt.aAj != null && this.bnt.aAj.isValid() && this.bnt.aAl != null && this.bnw == null && !TextUtils.equals(this.bnt.aAj.abu, "ALWAYS")) {
            bVar.bns.removeView(this.bny);
            this.bny.removeView(this.bnw);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bnt);
            this.bnw = a2;
            this.bny.addView(a2, 0);
            this.bny.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bnu.getPosition());
            Bitmap bitmap = this.bnu.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bnt.aAl.y)) + 0.0d));
            bVar.bns.addView(this.bny, builder.build());
            this.bny.setAlpha(0.0f);
            if (this.bnz != null) {
                this.bnz.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bny);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bnz = (Marker) bVar.bns.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bnt.azK.latitude, this.bnt.azK.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bnt.aAl.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bnt.aAl.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bnu != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bnu.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bnA = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bnA && animatedFraction > 0.99d) {
                        this.bnA = true;
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
