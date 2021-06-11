package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import io.reactivex.annotations.SchedulerSupport;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polyline extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public int f7016a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f7017b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f7018c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f7019d;

    /* renamed from: e  reason: collision with root package name */
    public int f7020e = 5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7021f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7022g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7023h = true;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f7024i;
    public List<BitmapDescriptor> j;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polyline;
    }

    private Bundle a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.f7024i).b();
    }

    public static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    private Bundle b(boolean z) {
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle("texture_0", BitmapDescriptorFactory.fromAsset("lineDashTexture.png").b());
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i2 = 0;
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            if (this.j.get(i3) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i2), this.j.get(i3).b());
                i2++;
            }
        }
        bundle2.putInt("total", i2);
        return bundle2;
    }

    public static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7017b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f7020e);
        Overlay.a(this.f7017b, bundle);
        Overlay.a(this.f7016a, bundle);
        a(this.f7018c, bundle);
        b(this.f7019d, bundle);
        int[] iArr = this.f7018c;
        int i2 = 1;
        if (iArr != null && iArr.length > 0 && iArr.length > this.f7017b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        bundle.putInt("dotline", this.f7021f ? 1 : 0);
        bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f7022g ? 1 : 0);
        try {
            if (this.f7024i != null) {
                bundle.putInt(SchedulerSupport.CUSTOM, 1);
                bundle.putBundle("image_info", a(false));
            } else {
                if (this.f7021f) {
                    bundle.putBundle("image_info", a(true));
                }
                bundle.putInt(SchedulerSupport.CUSTOM, 0);
            }
            if (this.j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false));
            } else {
                if (this.f7021f && ((this.f7018c != null && this.f7018c.length > 0) || (this.f7019d != null && this.f7019d.length > 0))) {
                    bundle.putBundle("image_info_list", b(true));
                }
                bundle.putInt("customlist", 0);
            }
            if (!this.f7023h) {
                i2 = 0;
            }
            bundle.putInt("keep", i2);
        } catch (Exception unused) {
            Log.e("baidumapsdk", "load texture resource failed!");
            bundle.putInt("dotline", 0);
        }
        return bundle;
    }

    public int getColor() {
        return this.f7016a;
    }

    public int[] getColorList() {
        return this.f7019d;
    }

    public List<LatLng> getPoints() {
        return this.f7017b;
    }

    public BitmapDescriptor getTexture() {
        return this.f7024i;
    }

    public int getWidth() {
        return this.f7020e;
    }

    public boolean isDottedLine() {
        return this.f7021f;
    }

    public boolean isFocus() {
        return this.f7022g;
    }

    public boolean isIsKeepScale() {
        return this.f7023h;
    }

    public void setColor(int i2) {
        this.f7016a = i2;
        this.listener.b(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.f7019d = iArr;
    }

    public void setDottedLine(boolean z) {
        this.f7021f = z;
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.f7022g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.f7018c = iArr;
    }

    public void setIsKeepScale(boolean z) {
        this.f7023h = z;
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.f7017b = list;
        this.listener.b(this);
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.f7024i = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
        }
        this.j = list;
    }

    public void setWidth(int i2) {
        if (i2 > 0) {
            this.f7020e = i2;
            this.listener.b(this);
        }
    }
}
