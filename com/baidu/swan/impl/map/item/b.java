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
import com.baidu.swan.apps.z.a.a.d;
/* loaded from: classes9.dex */
public class b {
    public static final Boolean crS = true;
    public d crO;
    public Marker crP;
    public Marker crQ;
    public View crR;
    public ViewGroup crT;
    public Marker crU;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes9.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.crP != null) {
            this.crP.setPosition(latLng);
            this.crO.buN.latitude = latLng.latitude;
            this.crO.buN.longitude = latLng.longitude;
            if (this.crU != null) {
                this.crU.setPosition(latLng);
            }
            if (crS.booleanValue()) {
                if (this.crQ != null) {
                    this.crQ.setPosition(latLng);
                }
                if (this.crT != null) {
                    cVar.cse.removeView(this.crT);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cse.addView(this.crT, builder.build());
                    this.crT.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.crO != null && this.crO.bvq != null && this.crO.bvq.isValid() && this.crO.bvs != null && this.crR == null && !TextUtils.equals(this.crO.bvq.RK, "ALWAYS")) {
            cVar.cse.removeView(this.crT);
            this.crT.removeView(this.crR);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.crO);
            this.crR = a2;
            this.crT.addView(a2, 0);
            this.crT.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.crP.getPosition());
            Bitmap bitmap = this.crP.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.crO.bvs.y)) + 0.0d));
            cVar.cse.addView(this.crT, builder.build());
            this.crT.setAlpha(0.0f);
            if (this.crU != null) {
                this.crU.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.crT);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.crU = (Marker) cVar.cse.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.crO.buN.latitude, this.crO.buN.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.crO.bvs.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.crO.bvs.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.crP != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.crP.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean crV = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.crV && animatedFraction > 0.99d) {
                        this.crV = true;
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
