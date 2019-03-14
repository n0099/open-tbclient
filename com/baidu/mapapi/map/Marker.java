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
/* loaded from: classes5.dex */
public final class Marker extends Overlay {
    LatLng a;
    BitmapDescriptor b;
    float c;
    float d;
    boolean e;
    boolean f;
    float g;
    String h;
    int i;
    float l;
    int m;
    ArrayList<BitmapDescriptor> o;
    Animation q;
    Point u;
    boolean j = false;
    boolean k = false;
    boolean n = false;
    int p = 20;
    float r = 1.0f;
    float s = 1.0f;
    float t = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (it.hasNext()) {
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = it.next().a;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            bundle2.putByteArray("image_data", array);
            bundle2.putInt("image_width", bitmap.getWidth());
            bundle2.putInt("image_height", bitmap.getHeight());
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(array, 0, array.length);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            bundle2.putString("image_hashcode", sb.toString());
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            for (int i = 0; i < arrayList2.size(); i++) {
                parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        if (this.b != null) {
            bundle.putBundle("image_info", this.b.b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
        bundle.putInt("animatetype", this.m);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.e ? 1 : 0);
        bundle.putFloat("anchor_x", this.c);
        bundle.putFloat("anchor_y", this.d);
        bundle.putFloat("rotate", this.g);
        bundle.putInt("y_offset", this.i);
        bundle.putInt("isflat", this.j ? 1 : 0);
        bundle.putInt("istop", this.k ? 1 : 0);
        bundle.putInt("period", this.p);
        bundle.putFloat("alpha", this.l);
        bundle.putFloat("scaleX", this.r);
        bundle.putFloat("scaleY", this.s);
        if (this.u != null) {
            bundle.putInt("fix_x", this.u.x);
            bundle.putInt("fix_y", this.u.y);
        }
        bundle.putInt("isfixed", this.n ? 1 : 0);
        if (this.o != null && this.o.size() > 0) {
            a(this.o, bundle);
        }
        bundle2.putBundle("param", bundle);
        return bundle;
    }

    public void cancelAnimation() {
        if (this.q != null) {
            this.q.bdAnimation.b();
        }
    }

    public float getAlpha() {
        return this.l;
    }

    public float getAnchorX() {
        return this.c;
    }

    public float getAnchorY() {
        return this.d;
    }

    public Point getFixedPosition() {
        return this.u;
    }

    public BitmapDescriptor getIcon() {
        return this.b;
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
        return this.a;
    }

    public float getRotate() {
        return this.g;
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
        return this.h;
    }

    public int getYOffset() {
        return this.i;
    }

    public boolean isDraggable() {
        return this.f;
    }

    public boolean isFixed() {
        return this.n;
    }

    public boolean isFlat() {
        return this.j;
    }

    public boolean isPerspective() {
        return this.e;
    }

    public void setAlpha(float f) {
        if (f < 0.0f || f > 1.0d) {
            this.l = 1.0f;
            return;
        }
        this.l = f;
        this.listener.b(this);
    }

    public void setAnchor(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.c = f;
        this.d = f2;
        this.listener.b(this);
    }

    public void setAnimateType(int i) {
        this.m = i;
        this.listener.b(this);
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.q = animation;
            this.q.bdAnimation.a(this, animation);
        }
    }

    public void setDraggable(boolean z) {
        this.f = z;
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
        this.b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        int i = 0;
        if (arrayList == null) {
            throw new IllegalArgumentException("marker's icons can not be null");
        }
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    this.o = (ArrayList) arrayList.clone();
                    this.b = null;
                    break;
                } else if (arrayList.get(i2) == null || arrayList.get(i2).a == null) {
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        } else {
            this.b = arrayList.get(0);
        }
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
        this.e = z;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("marker's position can not be null");
        }
        this.a = latLng;
        this.listener.b(this);
    }

    public void setRotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.g = f % 360.0f;
        this.listener.b(this);
    }

    public void setScale(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.r = f;
        this.s = f;
        this.listener.b(this);
    }

    public void setScaleX(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.r = f;
        this.listener.b(this);
    }

    public void setScaleY(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.s = f;
        this.listener.b(this);
    }

    public void setTitle(String str) {
        this.h = str;
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
        if (this.q != null) {
            this.q.bdAnimation.a();
        }
    }
}
