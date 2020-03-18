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
/* loaded from: classes12.dex */
public class b {
    public static final Boolean cws = true;
    public d cwo;
    public Marker cwp;
    public Marker cwq;
    public View cwr;
    public ViewGroup cwt;
    public Marker cwu;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cwp != null) {
            this.cwp.setPosition(latLng);
            this.cwo.bzX.latitude = latLng.latitude;
            this.cwo.bzX.longitude = latLng.longitude;
            if (this.cwu != null) {
                this.cwu.setPosition(latLng);
            }
            if (cws.booleanValue()) {
                if (this.cwq != null) {
                    this.cwq.setPosition(latLng);
                }
                if (this.cwt != null) {
                    cVar.cwE.removeView(this.cwt);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cwE.addView(this.cwt, builder.build());
                    this.cwt.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cwo != null && this.cwo.bAz != null && this.cwo.bAz.isValid() && this.cwo.bAB != null && this.cwr == null && !TextUtils.equals(this.cwo.bAz.TH, "ALWAYS")) {
            cVar.cwE.removeView(this.cwt);
            this.cwt.removeView(this.cwr);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cwo);
            this.cwr = a2;
            this.cwt.addView(a2, 0);
            this.cwt.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cwp.getPosition());
            Bitmap bitmap = this.cwp.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cwo.bAB.y)) + 0.0d));
            cVar.cwE.addView(this.cwt, builder.build());
            this.cwt.setAlpha(0.0f);
            if (this.cwu != null) {
                this.cwu.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cwt);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cwu = (Marker) cVar.cwE.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cwo.bzX.latitude, this.cwo.bzX.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cwo.bAB.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cwo.bAB.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cwp != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cwp.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cwv = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cwv && animatedFraction > 0.99d) {
                        this.cwv = true;
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
