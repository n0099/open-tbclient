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
    public int f6973a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f6974b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f6975c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6976d;

    /* renamed from: e  reason: collision with root package name */
    public int f6977e = 5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6978f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6979g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6980h = true;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f6981i;
    public List<BitmapDescriptor> j;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polyline;
    }

    private Bundle a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.f6981i).b();
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
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6974b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f6977e);
        Overlay.a(this.f6974b, bundle);
        Overlay.a(this.f6973a, bundle);
        a(this.f6975c, bundle);
        b(this.f6976d, bundle);
        int[] iArr = this.f6975c;
        int i2 = 1;
        if (iArr != null && iArr.length > 0 && iArr.length > this.f6974b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        bundle.putInt("dotline", this.f6978f ? 1 : 0);
        bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f6979g ? 1 : 0);
        try {
            if (this.f6981i != null) {
                bundle.putInt(SchedulerSupport.CUSTOM, 1);
                bundle.putBundle("image_info", a(false));
            } else {
                if (this.f6978f) {
                    bundle.putBundle("image_info", a(true));
                }
                bundle.putInt(SchedulerSupport.CUSTOM, 0);
            }
            if (this.j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false));
            } else {
                if (this.f6978f && ((this.f6975c != null && this.f6975c.length > 0) || (this.f6976d != null && this.f6976d.length > 0))) {
                    bundle.putBundle("image_info_list", b(true));
                }
                bundle.putInt("customlist", 0);
            }
            if (!this.f6980h) {
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
        return this.f6973a;
    }

    public int[] getColorList() {
        return this.f6976d;
    }

    public List<LatLng> getPoints() {
        return this.f6974b;
    }

    public BitmapDescriptor getTexture() {
        return this.f6981i;
    }

    public int getWidth() {
        return this.f6977e;
    }

    public boolean isDottedLine() {
        return this.f6978f;
    }

    public boolean isFocus() {
        return this.f6979g;
    }

    public boolean isIsKeepScale() {
        return this.f6980h;
    }

    public void setColor(int i2) {
        this.f6973a = i2;
        this.listener.b(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.f6976d = iArr;
    }

    public void setDottedLine(boolean z) {
        this.f6978f = z;
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.f6979g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.f6975c = iArr;
    }

    public void setIsKeepScale(boolean z) {
        this.f6980h = z;
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
        this.f6974b = list;
        this.listener.b(this);
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.f6981i = bitmapDescriptor;
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
            this.f6977e = i2;
            this.listener.b(this);
        }
    }
}
