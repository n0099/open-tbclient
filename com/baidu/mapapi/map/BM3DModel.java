package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes2.dex */
public final class BM3DModel extends Overlay {
    public String a;
    public String b;
    public LatLng c;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float d = 1.0f;
    public boolean e = false;
    public BM3DModelOptions.BM3DModelType l = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;

    public BM3DModel() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.m;
    }

    public BM3DModelOptions.BM3DModelType getBM3DModelType() {
        return this.l;
    }

    public String getModelName() {
        return this.b;
    }

    public String getModelPath() {
        return this.a;
    }

    public float getOffsetX() {
        return this.i;
    }

    public float getOffsetY() {
        return this.j;
    }

    public float getOffsetZ() {
        return this.k;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public float getRotateX() {
        return this.f;
    }

    public float getRotateY() {
        return this.g;
    }

    public float getRotateZ() {
        return this.h;
    }

    public float getScale() {
        return this.d;
    }

    public boolean isZoomFixed() {
        return this.e;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (!TextUtils.isEmpty(this.a)) {
            bundle.putString("modelPath", this.a);
            if (!TextUtils.isEmpty(this.b)) {
                bundle.putString("modelName", this.b);
                LatLng latLng = this.c;
                if (latLng != null) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                    bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                    bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                    bundle.putInt("modelType", this.l.ordinal());
                    bundle.putFloat("scale", this.d);
                    bundle.putInt("zoomFixed", this.e ? 1 : 0);
                    bundle.putFloat("rotateX", this.f);
                    bundle.putFloat("rotateY", this.g);
                    bundle.putFloat("rotateZ", this.h);
                    bundle.putFloat("offsetX", this.i);
                    bundle.putFloat("offsetY", this.j);
                    bundle.putFloat("offsetZ", this.k);
                    return bundle;
                }
                throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public void setBM3DModelType(BM3DModelOptions.BM3DModelType bM3DModelType) {
        this.l = bM3DModelType;
        this.listener.c(this);
    }

    public void setModelName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
    }

    public void setModelPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.c = latLng;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
    }

    public void setScale(float f) {
        this.d = f;
        this.listener.c(this);
    }

    public void setZoomFixed(boolean z) {
        this.e = z;
        this.listener.c(this);
    }

    public void setOffset(float f, float f2, float f3) {
        this.i = f;
        this.j = f2;
        this.k = f3;
        this.listener.c(this);
    }

    public void setRotate(float f, float f2, float f3) {
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.listener.c(this);
    }
}
