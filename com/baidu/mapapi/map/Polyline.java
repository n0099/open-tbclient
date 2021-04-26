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
    public int f7257a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f7258b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f7259c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f7260d;

    /* renamed from: e  reason: collision with root package name */
    public int f7261e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7262f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7263g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7264h = true;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f7265i;
    public List<BitmapDescriptor> j;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polyline;
    }

    private Bundle a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.f7265i).b();
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
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7258b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f7261e);
        Overlay.a(this.f7258b, bundle);
        Overlay.a(this.f7257a, bundle);
        a(this.f7259c, bundle);
        b(this.f7260d, bundle);
        int[] iArr = this.f7259c;
        int i2 = 1;
        if (iArr != null && iArr.length > 0 && iArr.length > this.f7258b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        if (this.f7262f) {
            bundle.putInt("dotline", 1);
        } else {
            bundle.putInt("dotline", 0);
        }
        bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f7263g ? 1 : 0);
        try {
            if (this.f7265i != null) {
                bundle.putInt(SchedulerSupport.CUSTOM, 1);
                bundle.putBundle("image_info", a(false));
            } else {
                if (this.f7262f) {
                    bundle.putBundle("image_info", a(true));
                }
                bundle.putInt(SchedulerSupport.CUSTOM, 0);
            }
            if (this.j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false));
            } else {
                if (this.f7262f && ((this.f7259c != null && this.f7259c.length > 0) || (this.f7260d != null && this.f7260d.length > 0))) {
                    bundle.putBundle("image_info_list", b(true));
                }
                bundle.putInt("customlist", 0);
            }
            if (!this.f7264h) {
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
        return this.f7257a;
    }

    public List<LatLng> getPoints() {
        return this.f7258b;
    }

    public int getWidth() {
        return this.f7261e;
    }

    public boolean isDottedLine() {
        return this.f7262f;
    }

    public boolean isFocus() {
        return this.f7263g;
    }

    public void setColor(int i2) {
        this.f7257a = i2;
        this.listener.b(this);
    }

    public void setDottedLine(boolean z) {
        this.f7262f = z;
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.f7263g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("indexList can not empty");
        }
        this.f7259c = iArr;
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not less than 2 or more than 10000");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        this.f7258b = list;
        this.listener.b(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("textureList can not empty");
        }
        this.j = list;
    }

    public void setWidth(int i2) {
        if (i2 > 0) {
            this.f7261e = i2;
            this.listener.b(this);
        }
    }
}
