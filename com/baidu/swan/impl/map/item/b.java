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
    public static final Boolean edw = true;
    public d eds;
    public Marker edt;
    public Marker edu;
    public View edv;
    public ViewGroup edx;
    public Marker edy;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes25.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.edt != null) {
            this.edt.setPosition(latLng);
            this.eds.cZV.latitude = latLng.latitude;
            this.eds.cZV.longitude = latLng.longitude;
            if (this.edy != null) {
                this.edy.setPosition(latLng);
            }
            if (edw.booleanValue()) {
                if (this.edu != null) {
                    this.edu.setPosition(latLng);
                }
                if (this.edx != null) {
                    cVar.edI.removeView(this.edx);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.edI.addView(this.edx, builder.build());
                    this.edx.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.eds != null && this.eds.daz != null && this.eds.daz.isValid() && this.eds.daB != null && this.edv == null && !TextUtils.equals(this.eds.daz.avb, "ALWAYS")) {
            cVar.edI.removeView(this.edx);
            this.edx.removeView(this.edv);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.eds);
            this.edv = a2;
            this.edx.addView(a2, 0);
            this.edx.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.edt.getPosition());
            Bitmap bitmap = this.edt.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.eds.daB.y)) + 0.0d));
            cVar.edI.addView(this.edx, builder.build());
            this.edx.setAlpha(0.0f);
            if (this.edy != null) {
                this.edy.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.edx);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.edy = (Marker) cVar.edI.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.eds.cZV.latitude, this.eds.cZV.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.eds.daB.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.eds.daB.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.edt != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.edt.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean edz = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.edz && animatedFraction > 0.99d) {
                        this.edz = true;
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
