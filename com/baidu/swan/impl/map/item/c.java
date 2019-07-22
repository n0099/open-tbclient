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
    public static final Boolean bok = true;
    public d bog;
    public Marker boh;
    public Marker boi;
    public View boj;
    public ViewGroup bol;
    public Marker bom;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.boh != null) {
            this.boh.setPosition(latLng);
            this.bog.aAr.latitude = latLng.latitude;
            this.bog.aAr.longitude = latLng.longitude;
            if (this.bom != null) {
                this.bom.setPosition(latLng);
            }
            if (bok.booleanValue()) {
                if (this.boi != null) {
                    this.boi.setPosition(latLng);
                }
                if (this.bol != null) {
                    bVar.bof.removeView(this.bol);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.bof.addView(this.bol, builder.build());
                    this.bol.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.bog != null && this.bog.aAR != null && this.bog.aAR.isValid() && this.bog.aAT != null && this.boj == null && !TextUtils.equals(this.bog.aAR.abR, "ALWAYS")) {
            bVar.bof.removeView(this.bol);
            this.bol.removeView(this.boj);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.bog);
            this.boj = a2;
            this.bol.addView(a2, 0);
            this.bol.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.boh.getPosition());
            Bitmap bitmap = this.boh.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.bog.aAT.y)) + 0.0d));
            bVar.bof.addView(this.bol, builder.build());
            this.bol.setAlpha(0.0f);
            if (this.bom != null) {
                this.bom.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.bol);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.bom = (Marker) bVar.bof.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.bog.aAr.latitude, this.bog.aAr.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.bog.aAT.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.bog.aAT.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.boh != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.boh.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean bon = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.bon && animatedFraction > 0.99d) {
                        this.bon = true;
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
