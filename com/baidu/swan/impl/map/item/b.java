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
/* loaded from: classes24.dex */
public class b {
    public static final Boolean ebO = true;
    public d ebK;
    public Marker ebL;
    public Marker ebM;
    public View ebN;
    public ViewGroup ebP;
    public Marker ebQ;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes24.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.ebL != null) {
            this.ebL.setPosition(latLng);
            this.ebK.cYl.latitude = latLng.latitude;
            this.ebK.cYl.longitude = latLng.longitude;
            if (this.ebQ != null) {
                this.ebQ.setPosition(latLng);
            }
            if (ebO.booleanValue()) {
                if (this.ebM != null) {
                    this.ebM.setPosition(latLng);
                }
                if (this.ebP != null) {
                    cVar.eca.removeView(this.ebP);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.eca.addView(this.ebP, builder.build());
                    this.ebP.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.ebK != null && this.ebK.cYN != null && this.ebK.cYN.isValid() && this.ebK.cYP != null && this.ebN == null && !TextUtils.equals(this.ebK.cYN.ciz, "ALWAYS")) {
            cVar.eca.removeView(this.ebP);
            this.ebP.removeView(this.ebN);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.ebK);
            this.ebN = a2;
            this.ebP.addView(a2, 0);
            this.ebP.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.ebL.getPosition());
            Bitmap bitmap = this.ebL.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.ebK.cYP.y)) + 0.0d));
            cVar.eca.addView(this.ebP, builder.build());
            this.ebP.setAlpha(0.0f);
            if (this.ebQ != null) {
                this.ebQ.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.ebP);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.ebQ = (Marker) cVar.eca.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.ebK.cYl.latitude, this.ebK.cYl.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.ebK.cYP.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.ebK.cYP.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.ebL != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.ebL.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean ebR = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.ebR && animatedFraction > 0.99d) {
                        this.ebR = true;
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
