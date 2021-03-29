package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polyline extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public int f6975a;

    /* renamed from: b  reason: collision with root package name */
    public List<LatLng> f6976b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f6977c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6978d;

    /* renamed from: e  reason: collision with root package name */
    public int f6979e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6980f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6981g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6982h = true;
    public BitmapDescriptor i;
    public List<BitmapDescriptor> j;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polyline;
    }

    private Bundle a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.i).b();
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
        int i = 0;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            if (this.j.get(i2) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i), this.j.get(i2).b());
                i++;
            }
        }
        bundle2.putInt("total", i);
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
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6976b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f6979e);
        Overlay.a(this.f6976b, bundle);
        Overlay.a(this.f6975a, bundle);
        a(this.f6977c, bundle);
        b(this.f6978d, bundle);
        int[] iArr = this.f6977c;
        int i = 1;
        if (iArr != null && iArr.length > 0 && iArr.length > this.f6976b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        if (this.f6980f) {
            bundle.putInt("dotline", 1);
        } else {
            bundle.putInt("dotline", 0);
        }
        bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.f6981g ? 1 : 0);
        try {
            if (this.i != null) {
                bundle.putInt("custom", 1);
                bundle.putBundle("image_info", a(false));
            } else {
                if (this.f6980f) {
                    bundle.putBundle("image_info", a(true));
                }
                bundle.putInt("custom", 0);
            }
            if (this.j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false));
            } else {
                if (this.f6980f && ((this.f6977c != null && this.f6977c.length > 0) || (this.f6978d != null && this.f6978d.length > 0))) {
                    bundle.putBundle("image_info_list", b(true));
                }
                bundle.putInt("customlist", 0);
            }
            if (!this.f6982h) {
                i = 0;
            }
            bundle.putInt("keep", i);
        } catch (Exception unused) {
            Log.e("baidumapsdk", "load texture resource failed!");
            bundle.putInt("dotline", 0);
        }
        return bundle;
    }

    public int getColor() {
        return this.f6975a;
    }

    public List<LatLng> getPoints() {
        return this.f6976b;
    }

    public int getWidth() {
        return this.f6979e;
    }

    public boolean isDottedLine() {
        return this.f6980f;
    }

    public boolean isFocus() {
        return this.f6981g;
    }

    public void setColor(int i) {
        this.f6975a = i;
        this.listener.b(this);
    }

    public void setDottedLine(boolean z) {
        this.f6980f = z;
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.f6981g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("indexList can not empty");
        }
        this.f6977c = iArr;
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
        this.f6976b = list;
        this.listener.b(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("textureList can not empty");
        }
        this.j = list;
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.f6979e = i;
            this.listener.b(this);
        }
    }
}
