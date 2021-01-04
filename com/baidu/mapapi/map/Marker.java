package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public final class Marker extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2852a;

    /* renamed from: b  reason: collision with root package name */
    BitmapDescriptor f2853b;
    float c;
    float d;
    boolean e;
    boolean f;
    float g;
    String h;
    int i;
    float l;
    int m;
    ArrayList<BitmapDescriptor> p;
    Animation r;
    Point v;
    InfoWindow w;
    InfoWindow.a x;
    boolean j = false;
    boolean k = false;
    boolean n = false;
    boolean o = true;
    int q = 20;
    float s = 1.0f;
    float t = 1.0f;
    float u = 1.0f;
    boolean y = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.marker;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        MessageDigest messageDigest;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (it.hasNext()) {
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = it.next().f2797a;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            bundle2.putByteArray("image_data", array);
            bundle2.putInt("image_width", bitmap.getWidth());
            bundle2.putInt("image_height", bitmap.getHeight());
            try {
                messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(array, 0, array.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                for (byte b2 : digest) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                bundle2.putString("image_hashcode", sb.toString());
            }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        if (this.f2853b != null) {
            bundle.putBundle("image_info", this.f2853b.b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f2852a);
        bundle.putInt("animatetype", this.m);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.e ? 1 : 0);
        bundle.putFloat("anchor_x", this.c);
        bundle.putFloat("anchor_y", this.d);
        bundle.putFloat(RotateImageAction.ACTION_NAME, this.g);
        bundle.putInt("y_offset", this.i);
        bundle.putInt("isflat", this.j ? 1 : 0);
        bundle.putInt("istop", this.k ? 1 : 0);
        bundle.putInt("period", this.q);
        bundle.putFloat("alpha", this.l);
        bundle.putFloat("scaleX", this.s);
        bundle.putFloat("scaleY", this.t);
        bundle.putInt("isClickable", this.o ? 1 : 0);
        if (this.v != null) {
            bundle.putInt("fix_x", this.v.x);
            bundle.putInt("fix_y", this.v.y);
        }
        bundle.putInt("isfixed", this.n ? 1 : 0);
        if (this.p != null && this.p.size() > 0) {
            a(this.p, bundle);
        }
        bundle2.putBundle("param", bundle);
        return bundle;
    }

    public void cancelAnimation() {
        if (this.r != null) {
            this.r.bdAnimation.b();
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
        return this.v;
    }

    public BitmapDescriptor getIcon() {
        return this.f2853b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.p;
    }

    public String getId() {
        return this.z;
    }

    public InfoWindow getInfoWindow() {
        return this.w;
    }

    public int getPeriod() {
        return this.q;
    }

    public LatLng getPosition() {
        return this.f2852a;
    }

    public float getRotate() {
        return this.g;
    }

    public float getScale() {
        return this.u;
    }

    public float getScaleX() {
        return this.s;
    }

    public float getScaleY() {
        return this.t;
    }

    public String getTitle() {
        return this.h;
    }

    public int getYOffset() {
        return this.i;
    }

    public void hideInfoWindow() {
        if (this.x != null) {
            this.x.a(this.w);
            this.y = false;
        }
    }

    public boolean isClickable() {
        return this.o;
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

    public boolean isInfoWindowEnabled() {
        return this.y;
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
            this.r = animation;
            this.r.bdAnimation.a(this, animation);
        }
    }

    public void setClickable(boolean z) {
        this.o = z;
        this.listener.b(this);
    }

    public void setDraggable(boolean z) {
        this.f = z;
        this.listener.b(this);
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.v = point;
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
        this.f2853b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        int i = 0;
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() != 1) {
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    this.p = (ArrayList) arrayList.clone();
                    this.f2853b = null;
                    break;
                } else if (arrayList.get(i2) == null || arrayList.get(i2).f2797a == null) {
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        } else {
            this.f2853b = arrayList.get(0);
        }
        this.listener.b(this);
    }

    public void setPeriod(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.q = i;
        this.listener.b(this);
    }

    public void setPerspective(boolean z) {
        this.e = z;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f2852a = latLng;
        this.listener.b(this);
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f2852a = latLng;
        this.listener.b(this);
        if (this.w != null) {
            this.w.setPosition(latLng);
        }
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
        this.s = f;
        this.t = f;
        this.listener.b(this);
    }

    public void setScaleX(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.s = f;
        this.listener.b(this);
    }

    public void setScaleY(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.t = f;
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

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
        }
        this.w = infoWindow;
        if (this.x != null) {
            this.x.b(infoWindow);
            this.y = true;
        }
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            return;
        }
        if (!infoWindow.j) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
        }
        if (infoWindow.f2825b == null) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        this.w = infoWindow;
        this.w.i = true;
        if (this.x != null) {
            this.x.b(infoWindow);
            this.y = true;
        }
    }

    public void startAnimation() {
        if (this.r != null) {
            this.r.bdAnimation.a();
        }
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (this.w == null || this.w.k) {
            return;
        }
        this.w.setBitmapDescriptor(bitmapDescriptor);
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        if (this.w != null) {
            this.w.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view) {
        if (this.w == null || !this.w.j) {
            return;
        }
        this.w.setView(view);
    }

    public void updateInfoWindowYOffset(int i) {
        if (this.w != null) {
            this.w.setYOffset(i);
        }
    }
}
