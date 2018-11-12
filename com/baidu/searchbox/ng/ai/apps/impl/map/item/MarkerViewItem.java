package com.baidu.searchbox.ng.ai.apps.impl.map.item;

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
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.animation.LatLngEvaluator;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.CalloutViewCreateHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
/* loaded from: classes4.dex */
public class MarkerViewItem {
    public static final int LEVEL_ENTITY_MARKER = 66;
    public static final int LEVEL_REAL_MARKER = 88;
    public static final Boolean SHOW_CALLOUT_LABEL = true;
    public View callout;
    public ViewGroup container;
    public Marker entity;
    public Marker label;
    private ValueAnimator mValueAnimator;
    public Marker marker;
    public MarkerModel markerModel;

    /* loaded from: classes4.dex */
    public interface AnimationEndCallback {
        void onAnimationEnd();
    }

    public void setPosition(MapViewItem mapViewItem, LatLng latLng) {
        if (this.marker != null) {
            this.marker.setPosition(latLng);
            this.markerModel.coordinate.latitude = latLng.latitude;
            this.markerModel.coordinate.longitude = latLng.longitude;
            if (this.entity != null) {
                this.entity.setPosition(latLng);
            }
            if (SHOW_CALLOUT_LABEL.booleanValue()) {
                if (this.label != null) {
                    this.label.setPosition(latLng);
                }
                if (this.container != null) {
                    mapViewItem.mapView.removeView(this.container);
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    mapViewItem.mapView.addView(this.container, builder.build());
                    this.container.setAlpha(0.0f);
                }
            }
        }
    }

    public void showCallout(MapViewItem mapViewItem) {
        if (this.markerModel != null && this.markerModel.callout != null && this.markerModel.callout.isValid() && this.markerModel.anchor != null && this.callout == null && !TextUtils.equals(this.markerModel.callout.display, MarkerModel.Callout.ALWAYS)) {
            mapViewItem.mapView.removeView(this.container);
            this.container.removeView(this.callout);
            View creatCallout = CalloutViewCreateHelper.creatCallout(mapViewItem, this.markerModel);
            this.callout = creatCallout;
            this.container.addView(creatCallout, 0);
            this.container.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(this.marker.getPosition());
            Bitmap bitmap = this.marker.getIcon().getBitmap();
            builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.markerModel.anchor.y)) + 0.0d));
            mapViewItem.mapView.addView(this.container, builder.build());
            this.container.setAlpha(0.0f);
            if (this.entity != null) {
                this.entity.remove();
            }
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.container);
            if (fromView != null) {
                Bitmap bitmap2 = fromView.getBitmap();
                if (bitmap2.getHeight() > 0 && bitmap2.getWidth() > 0) {
                    this.entity = (Marker) mapViewItem.mapView.getMap().addOverlay(new MarkerOptions().position(new LatLng(this.markerModel.coordinate.latitude, this.markerModel.coordinate.longitude)).icon(fromView).zIndex(66).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.markerModel.anchor.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.markerModel.anchor.y * bitmap.getHeight()))) / fromView.getBitmap().getHeight()));
                }
            }
        }
    }

    public void translateMarkerWithAnimation(final MapViewItem mapViewItem, LatLng latLng, long j, final AnimationEndCallback animationEndCallback) {
        if ((this.mValueAnimator == null || !this.mValueAnimator.isRunning()) && this.marker != null) {
            if (j < 0) {
                j = -j;
            }
            this.mValueAnimator = ValueAnimator.ofObject(new LatLngEvaluator(), this.marker.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.mValueAnimator.setDuration(j);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem.1
                boolean isEnd = false;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    MarkerViewItem.this.setPosition(mapViewItem, (LatLng) valueAnimator.getAnimatedValue());
                    if (!this.isEnd && animatedFraction > 0.99d) {
                        this.isEnd = true;
                        if (animationEndCallback != null) {
                            animationEndCallback.onAnimationEnd();
                        }
                    }
                }
            });
            this.mValueAnimator.start();
        }
    }
}
