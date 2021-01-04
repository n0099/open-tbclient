package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.List;
/* loaded from: classes15.dex */
public final class Polyline extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    int f2865a;

    /* renamed from: b  reason: collision with root package name */
    List<LatLng> f2866b;
    int[] c;
    int[] d;
    BitmapDescriptor j;
    List<BitmapDescriptor> k;
    int e = 5;
    boolean f = false;
    boolean g = false;
    boolean h = true;
    boolean i = true;
    int l = 0;
    boolean m = true;
    PolylineOptions.LineCapType n = PolylineOptions.LineCapType.LineCapButt;
    PolylineOptions.LineJoinType o = PolylineOptions.LineJoinType.LineJoinRound;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.polyline;
    }

    private Bundle a(boolean z, String str) {
        if (z) {
            String str2 = this.l == 1 ? "CircleDashTexture.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                return fromAsset.b();
            }
        }
        return this.j.b();
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    private Bundle b(boolean z, String str) {
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            String str2 = this.l == 1 ? "CircleDashTexture.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                bundle.putBundle("texture_0", fromAsset.b());
            }
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i), this.k.get(i2).b());
                i++;
            }
        }
        bundle2.putInt("total", i);
        return bundle2;
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f2866b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.e);
        Overlay.a(this.f2866b, bundle);
        Overlay.a(this.f2865a, bundle);
        a(this.c, bundle);
        b(this.d, bundle);
        if (this.c != null && this.c.length > 0 && this.c.length > this.f2866b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        bundle.putInt("dotline", this.f ? 1 : 0);
        bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.g ? 1 : 0);
        bundle.putInt("isClickable", this.i ? 1 : 0);
        bundle.putInt("isThined", this.m ? 1 : 0);
        bundle.putInt("lineJoinType", this.o.ordinal());
        bundle.putInt("lineCapType", this.n.ordinal());
        try {
            if (this.j != null) {
                bundle.putInt("custom", 1);
                bundle.putBundle("image_info", a(false, (String) null));
            } else {
                if (this.f) {
                    bundle.putBundle("image_info", a(true, (String) null));
                    bundle.putInt("dotted_line_type", this.l);
                } else {
                    bundle.putBundle("image_info", a(true, "line_texture.png"));
                }
                bundle.putInt("custom", 0);
            }
            if (this.k != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false, (String) null));
            } else {
                String str = !this.f ? "line_texture.png" : null;
                if (this.d != null && this.d.length > 0) {
                    bundle.putBundle("image_info_list", b(true, str));
                } else if (this.j != null) {
                    bundle.putBundle("image_info", this.j.b());
                    bundle.putInt("dotline", 0);
                } else {
                    bundle.putBundle("image_info", a(true, str));
                }
                bundle.putInt("customlist", 0);
            }
            bundle.putInt("keep", this.h ? 1 : 0);
        } catch (Exception e) {
            Log.e("baidumapsdk", "load texture resource failed!");
            bundle.putInt("dotline", 0);
        }
        return bundle;
    }

    public int getColor() {
        return this.f2865a;
    }

    public int[] getColorList() {
        return this.d;
    }

    public int getDottedLineType() {
        return this.l;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.n;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.o;
    }

    public List<LatLng> getPoints() {
        return this.f2866b;
    }

    public BitmapDescriptor getTexture() {
        return this.j;
    }

    public int getWidth() {
        return this.e;
    }

    public boolean isClickable() {
        return this.i;
    }

    public boolean isDottedLine() {
        return this.f;
    }

    public boolean isFocus() {
        return this.g;
    }

    public boolean isIsKeepScale() {
        return this.h;
    }

    public boolean isThined() {
        return this.m;
    }

    public void setClickable(boolean z) {
        this.i = z;
        this.listener.b(this);
    }

    public void setColor(int i) {
        this.f2865a = i;
        this.listener.b(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.d = iArr;
    }

    public void setDottedLine(boolean z) {
        this.f = z;
        this.listener.b(this);
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.l = polylineDottedLineType.ordinal();
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.c = iArr;
    }

    public void setIsKeepScale(boolean z) {
        this.h = z;
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        this.n = lineCapType;
        this.listener.b(this);
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        this.o = lineJoinType;
        this.listener.b(this);
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
        this.f2866b = list;
        this.listener.b(this);
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.j = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
        }
        this.k = list;
    }

    public void setThined(boolean z) {
        this.m = z;
        this.listener.b(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.e = i;
            this.listener.b(this);
        }
    }
}
