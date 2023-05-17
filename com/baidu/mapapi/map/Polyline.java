package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.List;
/* loaded from: classes3.dex */
public final class Polyline extends Overlay {
    public int a;
    public List<LatLng> b;
    public int[] c;
    public int[] d;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;
    public int e = 5;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public boolean i = true;
    public int l = 0;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public PolylineOptions.LineCapType p = PolylineOptions.LineCapType.LineCapButt;
    public PolylineOptions.LineJoinType q = PolylineOptions.LineJoinType.LineJoinRound;
    public PolylineOptions.LineDirectionCross180 r = PolylineOptions.LineDirectionCross180.NONE;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.i;
    }

    public int getColor() {
        return this.a;
    }

    public int[] getColorList() {
        return this.d;
    }

    public int getDottedLineType() {
        return this.l;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.p;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.r;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.q;
    }

    public List<LatLng> getPoints() {
        return this.b;
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

    public boolean isGeodesic() {
        return this.n;
    }

    public boolean isGradient() {
        return this.o;
    }

    public boolean isIsKeepScale() {
        return this.h;
    }

    public boolean isThined() {
        return this.m;
    }

    private Bundle a(boolean z, String str) {
        String str2;
        if (z) {
            if (this.l == 1) {
                str2 = "CircleDashTexture.png";
            } else {
                str2 = "lineDashTexture.png";
            }
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

    public static void b(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
            bundle.putInt("total", 1);
        }
    }

    public static void c(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_indexs", iArr);
        }
    }

    public static void d(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
        }
    }

    public static void a(List<LatLng> list, PolylineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        LatLng latLng;
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            LatLng latLng2 = list.get(i);
            if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST && latLng2.longitude < 0.0d) {
                latLng = new LatLng(latLng2.latitude, latLng2.longitude + 360.0d);
            } else {
                if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST && latLng2.longitude > 0.0d) {
                    latLng = new LatLng(latLng2.latitude, latLng2.longitude - 360.0d);
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng2);
                dArr[i] = ll2mc.getLongitudeE6();
                dArr2[i] = ll2mc.getLatitudeE6();
            }
            latLng2 = latLng;
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            dArr[i] = ll2mc2.getLongitudeE6();
            dArr2[i] = ll2mc2.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    public static void a(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("traffic_array", iArr);
        }
    }

    private Bundle b(Bundle bundle) {
        int[] iArr = this.d;
        if (iArr != null) {
            if (iArr.length != 0) {
                d(iArr, bundle);
                a(this.b, this.r, bundle);
                int length = this.d.length;
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr2[i] = i;
                }
                int size = this.b.size();
                int[] iArr3 = this.d;
                if (size == iArr3.length) {
                    iArr2[iArr3.length - 1] = iArr3.length - 2;
                }
                c(iArr2, bundle);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    private Bundle b(boolean z, String str) {
        String str2;
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            if (this.l == 1) {
                str2 = "CircleDashTexture.png";
            } else {
                str2 = "lineDashTexture.png";
            }
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

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.b;
        if (list != null && list.size() >= 2) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.b.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.e);
            if (this.o) {
                return b(bundle);
            }
            int i = 1;
            if (this.n && this.b.size() == 2) {
                this.b = com.baidu.mapsdkplatform.comapi.map.k.b(this.b.get(0), this.b.get(1));
            }
            a(this.b, this.r, bundle);
            Overlay.a(this.a, bundle);
            a(this.c, bundle);
            b(this.d, bundle);
            int[] iArr = this.c;
            if (iArr != null && iArr.length > 0 && iArr.length > this.b.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.f ? 1 : 0);
            bundle.putInt(AddFriendActivityConfig.TYPE_FOCUS, this.g ? 1 : 0);
            bundle.putInt("isClickable", this.i ? 1 : 0);
            if (this.n) {
                this.m = false;
                this.o = false;
            }
            bundle.putInt("isThined", this.m ? 1 : 0);
            bundle.putInt("isGradient", this.o ? 1 : 0);
            bundle.putInt("lineJoinType", this.q.ordinal());
            bundle.putInt("lineCapType", this.p.ordinal());
            bundle.putInt("lineDirectionCross180", this.r.ordinal());
            try {
                String str = "line_texture.png";
                if (this.j != null) {
                    bundle.putInt(ExceptionHandlerImpl.KEY_CUSTOM, 1);
                    bundle.putBundle("image_info", a(false, (String) null));
                } else {
                    if (this.f) {
                        bundle.putBundle("image_info", a(true, (String) null));
                        bundle.putInt("dotted_line_type", this.l);
                    } else {
                        bundle.putBundle("image_info", a(true, "line_texture.png"));
                    }
                    bundle.putInt(ExceptionHandlerImpl.KEY_CUSTOM, 0);
                }
                if (this.k != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false, (String) null));
                } else {
                    if (this.f) {
                        str = null;
                    }
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
                if (!this.h) {
                    i = 0;
                }
                bundle.putInt("keep", i);
            } catch (Exception unused) {
                Log.e("baidumapsdk", "load texture resource failed!");
                bundle.putInt("dotline", 0);
            }
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    public void setClickable(boolean z) {
        this.i = z;
        this.listener.c(this);
    }

    public void setColor(int i) {
        this.a = i;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.d = iArr;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
    }

    public void setDottedLine(boolean z) {
        this.f = z;
        this.listener.c(this);
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.l = polylineDottedLineType.ordinal();
        this.listener.c(this);
    }

    public void setFocus(boolean z) {
        this.g = z;
        this.listener.c(this);
    }

    public void setGeodesic(boolean z) {
        this.n = z;
        this.listener.c(this);
    }

    public void setGradient(boolean z) {
        this.o = z;
        this.listener.c(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.c = iArr;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
    }

    public void setIsKeepScale(boolean z) {
        this.h = z;
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        this.p = lineCapType;
        this.listener.c(this);
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.r = lineDirectionCross180;
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        this.q = lineJoinType;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.b = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.j = bitmapDescriptor;
        this.listener.c(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list != null && !list.isEmpty()) {
            this.k = list;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
    }

    public void setThined(boolean z) {
        this.m = z;
        this.listener.c(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.e = i;
            this.listener.c(this);
        }
    }
}
