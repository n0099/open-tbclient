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
/* loaded from: classes25.dex */
public class b {
    public static final Boolean dXF = true;
    public d dXB;
    public Marker dXC;
    public Marker dXD;
    public View dXE;
    public ViewGroup dXG;
    public Marker dXH;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes25.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.dXC != null) {
            this.dXC.setPosition(latLng);
            this.dXB.cUc.latitude = latLng.latitude;
            this.dXB.cUc.longitude = latLng.longitude;
            if (this.dXH != null) {
                this.dXH.setPosition(latLng);
            }
            if (dXF.booleanValue()) {
                if (this.dXD != null) {
                    this.dXD.setPosition(latLng);
                }
                if (this.dXG != null) {
                    cVar.dXR.removeView(this.dXG);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.dXR.addView(this.dXG, builder.build());
                    this.dXG.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.dXB != null && this.dXB.cUE != null && this.dXB.cUE.isValid() && this.dXB.cUG != null && this.dXE == null && !TextUtils.equals(this.dXB.cUE.avb, "ALWAYS")) {
            cVar.dXR.removeView(this.dXG);
            this.dXG.removeView(this.dXE);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.dXB);
            this.dXE = a2;
            this.dXG.addView(a2, 0);
            this.dXG.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.dXC.getPosition());
            Bitmap bitmap = this.dXC.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.dXB.cUG.y)) + 0.0d));
            cVar.dXR.addView(this.dXG, builder.build());
            this.dXG.setAlpha(0.0f);
            if (this.dXH != null) {
                this.dXH.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.dXG);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.dXH = (Marker) cVar.dXR.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.dXB.cUc.latitude, this.dXB.cUc.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.dXB.cUG.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.dXB.cUG.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.dXC != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.dXC.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean dXI = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.dXI && animatedFraction > 0.99d) {
                        this.dXI = true;
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
