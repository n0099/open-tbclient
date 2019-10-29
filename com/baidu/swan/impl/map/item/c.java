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
    public static final Boolean bHu = true;
    public d bHq;
    public Marker bHr;
    public Marker bHs;
    public View bHt;
    public ViewGroup bHv;
    public Marker bHw;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bHr != null) {
            this.bHr.setPosition(latLng);
            this.bHq.aUd.latitude = latLng.latitude;
            this.bHq.aUd.longitude = latLng.longitude;
            if (this.bHw != null) {
                this.bHw.setPosition(latLng);
            }
            if (bHu.booleanValue()) {
                if (this.bHs != null) {
                    this.bHs.setPosition(latLng);
                }
                if (this.bHv != null) {
                    bVar.bHp.removeView(this.bHv);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bHp.addView(this.bHv, builder.build());
                    this.bHv.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bHq != null && this.bHq.aUD != null && this.bHq.aUD.isValid() && this.bHq.aUF != null && this.bHt == null && !TextUtils.equals(this.bHq.aUD.LQ, "ALWAYS")) {
            bVar.bHp.removeView(this.bHv);
            this.bHv.removeView(this.bHt);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bHq);
            this.bHt = a2;
            this.bHv.addView(a2, 0);
            this.bHv.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bHr.getPosition());
            Bitmap bitmap = this.bHr.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bHq.aUF.y)) + 0.0d));
            bVar.bHp.addView(this.bHv, builder.build());
            this.bHv.setAlpha(0.0f);
            if (this.bHw != null) {
                this.bHw.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bHv);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bHw = (Marker) bVar.bHp.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bHq.aUd.latitude, this.bHq.aUd.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bHq.aUF.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bHq.aUF.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bHr != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bHr.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bHx = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bHx && animatedFraction > 0.99d) {
                        this.bHx = true;
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
