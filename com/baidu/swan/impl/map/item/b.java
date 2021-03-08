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
/* loaded from: classes8.dex */
public class b {
    public static final Boolean eqO = true;
    public d eqK;
    public Marker eqL;
    public Marker eqM;
    public View eqN;
    public ViewGroup eqP;
    public Marker eqQ;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes8.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.eqL != null) {
            this.eqL.setPosition(latLng);
            this.eqK.dje.latitude = latLng.latitude;
            this.eqK.dje.longitude = latLng.longitude;
            if (this.eqQ != null) {
                this.eqQ.setPosition(latLng);
            }
            if (eqO.booleanValue()) {
                if (this.eqM != null) {
                    this.eqM.setPosition(latLng);
                }
                if (this.eqP != null) {
                    cVar.era.removeView(this.eqP);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.era.addView(this.eqP, builder.build());
                    this.eqP.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.eqK != null && this.eqK.djH != null && this.eqK.djH.isValid() && this.eqK.djJ != null && this.eqN == null && !TextUtils.equals(this.eqK.djH.cuP, "ALWAYS")) {
            cVar.era.removeView(this.eqP);
            this.eqP.removeView(this.eqN);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.eqK);
            this.eqN = a2;
            this.eqP.addView(a2, 0);
            this.eqP.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.eqL.getPosition());
            Bitmap bitmap = this.eqL.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.eqK.djJ.y)) + 0.0d));
            cVar.era.addView(this.eqP, builder.build());
            this.eqP.setAlpha(0.0f);
            if (this.eqQ != null) {
                this.eqQ.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.eqP);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.eqQ = (Marker) cVar.era.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.eqK.dje.latitude, this.eqK.dje.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.eqK.djJ.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.eqK.djJ.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.eqL != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.eqL.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean eqR = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.eqR && animatedFraction > 0.99d) {
                        this.eqR = true;
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
