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
/* loaded from: classes10.dex */
public class b {
    public static final Boolean csd = true;
    public d crZ;
    public Marker csa;
    public Marker csb;
    public View csc;
    public ViewGroup cse;
    public Marker csf;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes10.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.csa != null) {
            this.csa.setPosition(latLng);
            this.crZ.bvB.latitude = latLng.latitude;
            this.crZ.bvB.longitude = latLng.longitude;
            if (this.csf != null) {
                this.csf.setPosition(latLng);
            }
            if (csd.booleanValue()) {
                if (this.csb != null) {
                    this.csb.setPosition(latLng);
                }
                if (this.cse != null) {
                    cVar.csp.removeView(this.cse);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.csp.addView(this.cse, builder.build());
                    this.cse.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.crZ != null && this.crZ.bwd != null && this.crZ.bwd.isValid() && this.crZ.bwf != null && this.csc == null && !TextUtils.equals(this.crZ.bwd.RP, "ALWAYS")) {
            cVar.csp.removeView(this.cse);
            this.cse.removeView(this.csc);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.crZ);
            this.csc = a2;
            this.cse.addView(a2, 0);
            this.cse.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.csa.getPosition());
            Bitmap bitmap = this.csa.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.crZ.bwf.y)) + 0.0d));
            cVar.csp.addView(this.cse, builder.build());
            this.cse.setAlpha(0.0f);
            if (this.csf != null) {
                this.csf.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cse);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.csf = (Marker) cVar.csp.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.crZ.bvB.latitude, this.crZ.bvB.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.crZ.bwf.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.crZ.bwf.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.csa != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.csa.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean csg = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.csg && animatedFraction > 0.99d) {
                        this.csg = true;
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
