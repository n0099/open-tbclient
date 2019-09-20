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
import com.baidu.swan.apps.x.a.a.d;
/* loaded from: classes5.dex */
public class c {
    public static final Boolean boI = true;
    public d boE;
    public Marker boF;
    public Marker boG;
    public View boH;
    public ViewGroup boJ;
    public Marker boK;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes5.dex */
    public interface a {
        void onAnimationEnd();
    }

    public void b(b bVar, LatLng latLng) {
        if (this.boF != null) {
            this.boF.setPosition(latLng);
            this.boE.aAP.latitude = latLng.latitude;
            this.boE.aAP.longitude = latLng.longitude;
            if (this.boK != null) {
                this.boK.setPosition(latLng);
            }
            if (boI.booleanValue()) {
                if (this.boG != null) {
                    this.boG.setPosition(latLng);
                }
                if (this.boJ != null) {
                    bVar.boD.removeView(this.boJ);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    bVar.boD.addView(this.boJ, builder.build());
                    this.boJ.setAlpha(0.0f);
                }
            }
        }
    }

    public void c(b bVar) {
        if (this.boE != null && this.boE.aBp != null && this.boE.aBp.isValid() && this.boE.aBr != null && this.boH == null && !TextUtils.equals(this.boE.aBp.abR, "ALWAYS")) {
            bVar.boD.removeView(this.boJ);
            this.boJ.removeView(this.boH);
            View a2 = com.baidu.swan.impl.map.a.b.a.a(bVar, this.boE);
            this.boH = a2;
            this.boJ.addView(a2, 0);
            this.boJ.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.boF.getPosition());
            Bitmap bitmap = this.boF.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.boE.aBr.y)) + 0.0d));
            bVar.boD.addView(this.boJ, builder.build());
            this.boJ.setAlpha(0.0f);
            if (this.boK != null) {
                this.boK.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.boJ);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.boK = (Marker) bVar.boD.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.boE.aAP.latitude, this.boE.aAP.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.boE.aBr.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.boE.aBr.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void a(final b bVar, LatLng latLng, long j, final a aVar) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.boF != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new com.baidu.swan.impl.map.a.a.a.a(), this.boF.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.impl.map.item.c.1
                boolean boL = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.b(bVar, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.boL && animatedFraction > 0.99d) {
                        this.boL = true;
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
