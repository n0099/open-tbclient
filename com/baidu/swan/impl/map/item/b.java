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
/* loaded from: classes9.dex */
public class b {
    public static final Boolean erT = true;
    public d erP;
    public Marker erQ;
    public Marker erR;
    public View erS;
    public ViewGroup erU;
    public Marker erV;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes9.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.erQ != null) {
            this.erQ.setPosition(latLng);
            this.erP.dke.latitude = latLng.latitude;
            this.erP.dke.longitude = latLng.longitude;
            if (this.erV != null) {
                this.erV.setPosition(latLng);
            }
            if (erT.booleanValue()) {
                if (this.erR != null) {
                    this.erR.setPosition(latLng);
                }
                if (this.erU != null) {
                    cVar.esf.removeView(this.erU);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.esf.addView(this.erU, builder.build());
                    this.erU.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.erP != null && this.erP.dkH != null && this.erP.dkH.isValid() && this.erP.dkJ != null && this.erS == null && !TextUtils.equals(this.erP.dkH.cwn, "ALWAYS")) {
            cVar.esf.removeView(this.erU);
            this.erU.removeView(this.erS);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.erP);
            this.erS = a2;
            this.erU.addView(a2, 0);
            this.erU.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.erQ.getPosition());
            Bitmap bitmap = this.erQ.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.erP.dkJ.y)) + 0.0d));
            cVar.esf.addView(this.erU, builder.build());
            this.erU.setAlpha(0.0f);
            if (this.erV != null) {
                this.erV.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.erU);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.erV = (Marker) cVar.esf.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.erP.dke.latitude, this.erP.dke.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.erP.dkJ.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.erP.dkJ.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.erQ != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.erQ.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean erW = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.erW && animatedFraction > 0.99d) {
                        this.erW = true;
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
