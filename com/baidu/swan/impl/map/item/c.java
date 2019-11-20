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
    public static final Boolean bGD = true;
    public Marker bGA;
    public Marker bGB;
    public View bGC;
    public ViewGroup bGE;
    public Marker bGF;
    public d bGz;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.bGA != null) {
            this.bGA.setPosition(latLng);
            this.bGz.aTL.latitude = latLng.latitude;
            this.bGz.aTL.longitude = latLng.longitude;
            if (this.bGF != null) {
                this.bGF.setPosition(latLng);
            }
            if (bGD.booleanValue()) {
                if (this.bGB != null) {
                    this.bGB.setPosition(latLng);
                }
                if (this.bGE != null) {
                    bVar.bGy.removeView(this.bGE);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bGy.addView(this.bGE, builder.build());
                    this.bGE.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bGz != null && this.bGz.aUl != null && this.bGz.aUl.isValid() && this.bGz.aUn != null && this.bGC == null && !TextUtils.equals(this.bGz.aUl.Lo, "ALWAYS")) {
            bVar.bGy.removeView(this.bGE);
            this.bGE.removeView(this.bGC);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bGz);
            this.bGC = a2;
            this.bGE.addView(a2, 0);
            this.bGE.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.bGA.getPosition());
            Bitmap bitmap = this.bGA.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bGz.aUn.y)) + 0.0d));
            bVar.bGy.addView(this.bGE, builder.build());
            this.bGE.setAlpha(0.0f);
            if (this.bGF != null) {
                this.bGF.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bGE);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bGF = (Marker) bVar.bGy.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bGz.aTL.latitude, this.bGz.aTL.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bGz.aUn.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bGz.aUn.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.bGA != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.bGA.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bGG = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bGG && animatedFraction > 0.99d) {
                        this.bGG = true;
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
