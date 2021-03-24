package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.animation.Animation;
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
    public LatLng f6941a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6942b;

    /* renamed from: c  reason: collision with root package name */
    public float f6943c;

    /* renamed from: d  reason: collision with root package name */
    public float f6944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6945e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6946f;

    /* renamed from: g  reason: collision with root package name */
    public float f6947g;

    /* renamed from: h  reason: collision with root package name */
    public String f6948h;
    public int i;
    public float l;
    public int m;
    public ArrayList<BitmapDescriptor> o;
    public Animation q;
    public Point u;
    public boolean j = false;
    public boolean k = false;
    public boolean n = false;
    public int p = 20;
    public float r = 1.0f;
    public float s = 1.0f;
    public float t = 1.0f;

    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = it.next().f6822a;
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
            messageDigest.update(array, 0, array.length);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            while (i < digest.length) {
                sb.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                i++;
            }
            bundle2.putString("image_hashcode", sb.toString());
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i < arrayList2.size()) {
                parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                i++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.f6942b;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6941a);
        bundle.putInt("animatetype", this.m);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.f6945e ? 1 : 0);
        bundle.putFloat("anchor_x", this.f6943c);
        bundle.putFloat("anchor_y", this.f6944d);
        bundle.putFloat("rotate", this.f6947g);
        bundle.putInt("y_offset", this.i);
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
        return this.f6943c;
    }

    public float getAnchorY() {
        return this.f6944d;
    }

    public Point getFixedPosition() {
        return this.u;
    }

    public BitmapDescriptor getIcon() {
        return this.f6942b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.o;
    }

    public String getId() {
        return this.v;
    }

    public int getPeriod() {
        return this.p;
    }

    public LatLng getPosition() {
        return this.f6941a;
    }

    public float getRotate() {
        return this.f6947g;
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
        return this.f6948h;
    }

    public int getYOffset() {
        return this.i;
    }

    public boolean isDraggable() {
        return this.f6946f;
    }

    public boolean isFixed() {
        return this.n;
    }

    public boolean isFlat() {
        return this.j;
    }

    public boolean isPerspective() {
        return this.f6945e;
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
        this.f6943c = f2;
        this.f6944d = f3;
        this.listener.b(this);
    }

    public void setAnimateType(int i) {
        this.m = i;
        this.listener.b(this);
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.q = animation;
            animation.bdAnimation.a(this, animation);
        }
    }

    public void setDraggable(boolean z) {
        this.f6946f = z;
        this.listener.b(this);
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("the screenPosition can not be null");
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
            throw new IllegalArgumentException("marker's icon can not be null");
        }
        this.f6942b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        if (arrayList == null) {
            throw new IllegalArgumentException("marker's icons can not be null");
        }
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() == 1) {
            bitmapDescriptor = arrayList.get(0);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f6822a == null) {
                    return;
                }
            }
            this.o = (ArrayList) arrayList.clone();
            bitmapDescriptor = null;
        }
        this.f6942b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPeriod(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("marker's period must be greater than zero ");
        }
        this.p = i;
        this.listener.b(this);
    }

    public void setPerspective(boolean z) {
        this.f6945e = z;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("marker's position can not be null");
        }
        this.f6941a = latLng;
        this.listener.b(this);
    }

    public void setRotate(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.f6947g = f2 % 360.0f;
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
        this.f6948h = str;
    }

    public void setToTop() {
        this.k = true;
        this.listener.b(this);
    }

    public void setYOffset(int i) {
        this.i = i;
        this.listener.b(this);
    }

    public void startAnimation() {
        Animation animation = this.q;
        if (animation != null) {
            animation.bdAnimation.a();
        }
    }
}
