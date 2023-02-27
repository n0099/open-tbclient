package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.util.List;
/* loaded from: classes2.dex */
public final class Prism extends Overlay {
    public float a;
    public List<LatLng> b;
    public int c = -16777216;
    public int d = DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK;
    public BuildingInfo e;
    public boolean f;
    public BitmapDescriptor g;
    public int h;
    public boolean i;

    public Prism() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.l;
    }

    public BuildingInfo getBuildingInfo() {
        return this.e;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.g;
    }

    public float getHeight() {
        return this.a;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public int getShowLevel() {
        return this.h;
    }

    public int getSideFaceColor() {
        return this.d;
    }

    public int getTopFaceColor() {
        return this.c;
    }

    public boolean isAnimation() {
        return this.i;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Overlay.b(this.c, bundle);
        Overlay.c(this.d, bundle);
        BitmapDescriptor bitmapDescriptor = this.g;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        BuildingInfo buildingInfo = this.e;
        int i = 0;
        if (buildingInfo != null) {
            bundle.putDouble("m_height", buildingInfo.getHeight());
            bundle.putString("encodedPoints", this.e.getGeom());
            bundle.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
            bundle.putInt("m_showLevel", this.h);
            bundle.putInt("m_isAnimation", this.i ? 1 : 0);
        } else {
            List<LatLng> list = this.b;
            if (list != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                Overlay.a(this.b, bundle);
                bundle.putDouble("m_height", this.a);
            }
        }
        if (this.e != null) {
            i = 1;
        }
        bundle.putInt("m_isBuilding", i);
        return bundle;
    }

    public void setAnimation(boolean z) {
        this.i = z;
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        this.e = buildingInfo;
        this.listener.c(this);
    }

    public void setCustomSideImage(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        this.listener.c(this);
    }

    public void setHeight(float f) {
        this.a = f;
        this.listener.c(this);
    }

    public void setShowLevel(int i) {
        this.h = i;
    }

    public void setSideFaceColor(int i) {
        this.d = i;
        this.listener.c(this);
    }

    public void setTopFaceColor(int i) {
        this.c = i;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 3) {
                if (!list.contains(null)) {
                    int i = 0;
                    while (i < list.size()) {
                        int i2 = i + 1;
                        for (int i3 = i2; i3 < list.size(); i3++) {
                            if (list.get(i) == list.get(i3)) {
                                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                            }
                        }
                        i = i2;
                    }
                    this.b = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }
}
