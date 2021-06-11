package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class Marker extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6981a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6982b;

    /* renamed from: c  reason: collision with root package name */
    public float f6983c;

    /* renamed from: d  reason: collision with root package name */
    public float f6984d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6985e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6986f;

    /* renamed from: g  reason: collision with root package name */
    public float f6987g;

    /* renamed from: h  reason: collision with root package name */
    public String f6988h;

    /* renamed from: i  reason: collision with root package name */
    public int f6989i;
    public float l;
    public int m;
    public ArrayList<BitmapDescriptor> o;
    public Animation q;
    public Point u;
    public InfoWindow v;
    public InfoWindow.a w;
    public boolean j = false;
    public boolean k = false;
    public boolean n = false;
    public int p = 20;
    public float r = 1.0f;
    public float s = 1.0f;
    public float t = 1.0f;
    public boolean x = false;

    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i2;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = it.next().f6851a;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            bundle2.putByteArray("image_data", array);
            bundle2.putInt("image_width", bitmap.getWidth());
            bundle2.putInt("image_height", bitmap.getHeight());
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            if (messageDigest != null) {
                messageDigest.update(array, 0, array.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                while (i2 < digest.length) {
                    sb.append(Integer.toString((digest[i2] & 255) + 256, 16).substring(1));
                    i2++;
                }
                bundle2.putString("image_hashcode", sb.toString());
            }
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i2 < arrayList2.size()) {
                parcelItemArr[i2] = (ParcelItem) arrayList2.get(i2);
                i2++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.f6982b;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6981a);
        bundle.putInt("animatetype", this.m);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.f6985e ? 1 : 0);
        bundle.putFloat("anchor_x", this.f6983c);
        bundle.putFloat("anchor_y", this.f6984d);
        bundle.putFloat("rotate", this.f6987g);
        bundle.putInt("y_offset", this.f6989i);
        bundle.putInt("isflat", this.j ? 1 : 0);
        bundle.putInt("istop", this.k ? 1 : 0);
        bundle.putInt("period", this.p);
        bundle.putFloat("alpha", this.l);
        bundle.putFloat("scaleX", this.r);
        bundle.putFloat("scaleY", this.s);
        Point point = this.u;
        if (point != null) {
            bundle.putInt("fix_x", point.x);
            bundle.putInt("fix_y", this.u.y);
        }
        bundle.putInt("isfixed", this.n ? 1 : 0);
        ArrayList<BitmapDescriptor> arrayList = this.o;
        if (arrayList != null && arrayList.size() > 0) {
            a(this.o, bundle);
        }
        bundle2.putBundle("param", bundle);
        return bundle;
    }

    public void cancelAnimation() {
        Animation animation = this.q;
        if (animation != null) {
            animation.bdAnimation.b();
        }
    }

    public float getAlpha() {
        return this.l;
    }

    public float getAnchorX() {
        return this.f6983c;
    }

    public float getAnchorY() {
        return this.f6984d;
    }

    public Point getFixedPosition() {
        return this.u;
    }

    public BitmapDescriptor getIcon() {
        return this.f6982b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.o;
    }

    public String getId() {
        return this.y;
    }

    public InfoWindow getInfoWindow() {
        return this.v;
    }

    public int getPeriod() {
        return this.p;
    }

    public LatLng getPosition() {
        return this.f6981a;
    }

    public float getRotate() {
        return this.f6987g;
    }

    public float getScale() {
        return this.t;
    }

    public float getScaleX() {
        return this.r;
    }

    public float getScaleY() {
        return this.s;
    }

    public String getTitle() {
        return this.f6988h;
    }

    public int getYOffset() {
        return this.f6989i;
    }

    public void hideInfoWindow() {
        InfoWindow.a aVar = this.w;
        if (aVar != null) {
            aVar.a(this.v);
            this.x = false;
        }
    }

    public boolean isDraggable() {
        return this.f6986f;
    }

    public boolean isFixed() {
        return this.n;
    }

    public boolean isFlat() {
        return this.j;
    }

    public boolean isInfoWindowEnabled() {
        return this.x;
    }

    public boolean isPerspective() {
        return this.f6985e;
    }

    public void setAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0d) {
            this.l = 1.0f;
            return;
        }
        this.l = f2;
        this.listener.b(this);
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6983c = f2;
        this.f6984d = f3;
        this.listener.b(this);
    }

    public void setAnimateType(int i2) {
        this.m = i2;
        this.listener.b(this);
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.q = animation;
            animation.bdAnimation.a(this, animation);
        }
    }

    public void setDraggable(boolean z) {
        this.f6986f = z;
        this.listener.b(this);
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.u = point;
        this.n = true;
        this.listener.b(this);
    }

    public void setFlat(boolean z) {
        this.j = z;
        this.listener.b(this);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.f6982b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() == 1) {
            bitmapDescriptor = arrayList.get(0);
        } else {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) == null || arrayList.get(i2).f6851a == null) {
                    return;
                }
            }
            this.o = (ArrayList) arrayList.clone();
            bitmapDescriptor = null;
        }
        this.f6982b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPeriod(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.p = i2;
        this.listener.b(this);
    }

    public void setPerspective(boolean z) {
        this.f6985e = z;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f6981a = latLng;
        this.listener.b(this);
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f6981a = latLng;
        this.listener.b(this);
        InfoWindow infoWindow = this.v;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void setRotate(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.f6987g = f2 % 360.0f;
        this.listener.b(this);
    }

    public void setScale(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.r = f2;
        this.s = f2;
        this.listener.b(this);
    }

    public void setScaleX(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.r = f2;
        this.listener.b(this);
    }

    public void setScaleY(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.s = f2;
        this.listener.b(this);
    }

    public void setTitle(String str) {
        this.f6988h = str;
    }

    public void setToTop() {
        this.k = true;
        this.listener.b(this);
    }

    public void setYOffset(int i2) {
        this.f6989i = i2;
        this.listener.b(this);
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
        }
        this.v = infoWindow;
        InfoWindow.a aVar = this.w;
        if (aVar != null) {
            aVar.b(infoWindow);
            this.x = true;
        }
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            return;
        }
        if (!infoWindow.j) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
        }
        if (infoWindow.f6915b == null) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        this.v = infoWindow;
        infoWindow.f6922i = true;
        InfoWindow.a aVar = this.w;
        if (aVar != null) {
            aVar.b(infoWindow);
            this.x = true;
        }
    }

    public void startAnimation() {
        Animation animation = this.q;
        if (animation != null) {
            animation.bdAnimation.a();
        }
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow = this.v;
        if (infoWindow == null || infoWindow.k) {
            return;
        }
        infoWindow.setBitmapDescriptor(bitmapDescriptor);
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow = this.v;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view) {
        InfoWindow infoWindow = this.v;
        if (infoWindow == null || !infoWindow.j) {
            return;
        }
        infoWindow.setView(view);
    }

    public void updateInfoWindowYOffset(int i2) {
        InfoWindow infoWindow = this.v;
        if (infoWindow != null) {
            infoWindow.setYOffset(i2);
        }
    }
}
