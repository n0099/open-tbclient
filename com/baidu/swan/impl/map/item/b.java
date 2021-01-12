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
    public static final Boolean ene = true;
    public d emZ;
    public Marker ena;
    public Marker enb;
    public View enc;
    public ViewGroup enf;
    public Marker eng;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes8.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.ena != null) {
            this.ena.setPosition(latLng);
            this.emZ.dfp.latitude = latLng.latitude;
            this.emZ.dfp.longitude = latLng.longitude;
            if (this.eng != null) {
                this.eng.setPosition(latLng);
            }
            if (ene.booleanValue()) {
                if (this.enb != null) {
                    this.enb.setPosition(latLng);
                }
                if (this.enf != null) {
                    cVar.enq.removeView(this.enf);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.enq.addView(this.enf, builder.build());
                    this.enf.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.emZ != null && this.emZ.dfS != null && this.emZ.dfS.isValid() && this.emZ.dfU != null && this.enc == null && !TextUtils.equals(this.emZ.dfS.crw, "ALWAYS")) {
            cVar.enq.removeView(this.enf);
            this.enf.removeView(this.enc);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.emZ);
            this.enc = a2;
            this.enf.addView(a2, 0);
            this.enf.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.ena.getPosition());
            Bitmap bitmap = this.ena.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.emZ.dfU.y)) + 0.0d));
            cVar.enq.addView(this.enf, builder.build());
            this.enf.setAlpha(0.0f);
            if (this.eng != null) {
                this.eng.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.enf);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.eng = (Marker) cVar.enq.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.emZ.dfp.latitude, this.emZ.dfp.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.emZ.dfU.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.emZ.dfU.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.ena != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.ena.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean enh = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.enh && animatedFraction > 0.99d) {
                        this.enh = true;
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
