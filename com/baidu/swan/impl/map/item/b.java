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
/* loaded from: classes12.dex */
public class b {
    public static final Boolean dgu = true;
    public d dgq;
    public Marker dgr;
    public Marker dgs;
    public View dgt;
    public ViewGroup dgv;
    public Marker dgw;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dgr != null) {
            this.dgr.setPosition(latLng);
            this.dgq.ciL.latitude = latLng.latitude;
            this.dgq.ciL.longitude = latLng.longitude;
            if (this.dgw != null) {
                this.dgw.setPosition(latLng);
            }
            if (dgu.booleanValue()) {
                if (this.dgs != null) {
                    this.dgs.setPosition(latLng);
                }
                if (this.dgv != null) {
                    cVar.dgG.removeView(this.dgv);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dgG.addView(this.dgv, builder.build());
                    this.dgv.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dgq != null && this.dgq.cjo != null && this.dgq.cjo.isValid() && this.dgq.cjq != null && this.dgt == null && !TextUtils.equals(this.dgq.cjo.anB, "ALWAYS")) {
            cVar.dgG.removeView(this.dgv);
            this.dgv.removeView(this.dgt);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dgq);
            this.dgt = a2;
            this.dgv.addView(a2, 0);
            this.dgv.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dgr.getPosition());
            Bitmap bitmap = this.dgr.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dgq.cjq.y)) + 0.0d));
            cVar.dgG.addView(this.dgv, builder.build());
            this.dgv.setAlpha(0.0f);
            if (this.dgw != null) {
                this.dgw.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dgv);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dgw = (Marker) cVar.dgG.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dgq.ciL.latitude, this.dgq.ciL.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dgq.cjq.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dgq.cjq.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dgr != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dgr.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dgx = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dgx && animatedFraction > 0.99d) {
                        this.dgx = true;
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
