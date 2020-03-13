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
    public static final Boolean cwh = true;
    public d cwd;
    public Marker cwe;
    public Marker cwf;
    public View cwg;
    public ViewGroup cwi;
    public Marker cwj;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes12.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(c cVar, LatLng latLng) {
        if (this.cwe != null) {
            this.cwe.setPosition(latLng);
            this.cwd.bzM.latitude = latLng.latitude;
            this.cwd.bzM.longitude = latLng.longitude;
            if (this.cwj != null) {
                this.cwj.setPosition(latLng);
            }
            if (cwh.booleanValue()) {
                if (this.cwf != null) {
                    this.cwf.setPosition(latLng);
                }
                if (this.cwi != null) {
                    cVar.cwt.removeView(this.cwi);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    cVar.cwt.addView(this.cwi, builder.build());
                    this.cwi.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(c cVar) {
        if (this.cwd != null && this.cwd.bAo != null && this.cwd.bAo.isValid() && this.cwd.bAq != null && this.cwg == null && !TextUtils.equals(this.cwd.bAo.Tw, "ALWAYS")) {
            cVar.cwt.removeView(this.cwi);
            this.cwi.removeView(this.cwg);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(cVar, this.cwd);
            this.cwg = a2;
            this.cwi.addView(a2, 0);
            this.cwi.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.cwe.getPosition());
            Bitmap bitmap = this.cwe.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.cwd.bAq.y)) + 0.0d));
            cVar.cwt.addView(this.cwi, builder.build());
            this.cwi.setAlpha(0.0f);
            if (this.cwj != null) {
                this.cwj.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.cwi);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.cwj = (Marker) cVar.cwt.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.cwd.bzM.latitude, this.cwd.bzM.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.cwd.bAq.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.cwd.bAq.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final c cVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.cwe != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.cwe.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.b.1
                boolean cwk = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    b.this.b(cVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.cwk && animatedFraction > 0.99d) {
                        this.cwk = true;
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
