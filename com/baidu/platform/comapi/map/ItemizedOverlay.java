package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.OverlayItem;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class ItemizedOverlay<Item extends OverlayItem> extends Overlay implements Comparator<Integer> {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<OverlayItem> f4259a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<Integer> f4260b;
    protected Drawable c;
    protected MapSurfaceView d;
    protected MapTextureView e;
    protected boolean f;
    protected Drawable g;
    protected OverlayItem h;
    protected int i = 0;
    protected int j;

    public ItemizedOverlay(Drawable drawable, MapSurfaceView mapSurfaceView) {
        this.mType = 27;
        this.c = drawable;
        this.f4259a = new ArrayList<>();
        this.f4260b = new ArrayList<>();
        this.d = mapSurfaceView;
        this.mLayerID = 0L;
    }

    public ItemizedOverlay(Drawable drawable, MapTextureView mapTextureView) {
        this.mType = 27;
        this.c = drawable;
        this.f4259a = new ArrayList<>();
        this.f4260b = new ArrayList<>();
        this.e = mapTextureView;
        this.mLayerID = 0L;
    }

    private void a(List<OverlayItem> list, boolean z) {
        if (this.mLayerID == 0) {
            if (z) {
                return;
            }
            synchronized (this) {
                if (this.f4259a != null && list != null) {
                    this.f4259a.addAll(list);
                }
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.clear();
        ArrayList arrayList = new ArrayList();
        bundle.putLong("itemaddr", this.mLayerID);
        bundle.putInt("bshow", 1);
        if (z) {
            bundle.putString("extparam", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            OverlayItem overlayItem = list.get(i2);
            if (overlayItem.getMarker() == null) {
                overlayItem.setMarker(this.c);
            }
            if (TextUtils.isEmpty(overlayItem.getId())) {
                overlayItem.setId(ab.a());
            }
            ParcelItem parcelItem = new ParcelItem();
            Drawable marker = overlayItem.getMarker();
            byte[] gifData = overlayItem.getGifData();
            if (marker != null || gifData != null) {
                Bundle bundle2 = new Bundle();
                GeoPoint a2 = overlayItem.getCoordType() == OverlayItem.CoordType.CoordType_BD09LL ? x.a(overlayItem.getPoint()) : overlayItem.getPoint();
                bundle2.putInt("x", (int) a2.getLongitude());
                bundle2.putInt("y", (int) a2.getLatitude());
                bundle2.putFloat(MapBundleKey.MapObjKey.OBJ_GEO_Z, overlayItem.getGeoZ());
                bundle2.putInt(MapBundleKey.MapObjKey.OBJ_INDOOR_POI, overlayItem.getIndoorPoi());
                bundle2.putInt("showLR", 1);
                bundle2.putInt("iconwidth", 0);
                bundle2.putInt("iconlayer", 1);
                bundle2.putFloat("ax", overlayItem.getAnchorX());
                bundle2.putFloat("ay", overlayItem.getAnchorY());
                bundle2.putInt("bound", overlayItem.getBound());
                bundle2.putInt(MapBundleKey.MapObjKey.OBJ_LEVEL, overlayItem.getLevel());
                bundle2.putInt("mask", overlayItem.getMask());
                bundle2.putString("popname", "" + overlayItem.getId());
                if (gifData != null) {
                    bundle2.putFloat("gifscale", overlayItem.getScale());
                    bundle2.putInt("gifsize", gifData.length);
                    bundle2.putByteArray("imgdata", gifData);
                    bundle2.putInt("imgindex", c());
                } else {
                    Bitmap a3 = com.baidu.platform.comapi.util.d.a(marker);
                    if (a3 != null) {
                        bundle2.putInt("imgindex", overlayItem.getResId());
                        bundle2.putInt("imgW", a3.getWidth());
                        bundle2.putInt("imgH", a3.getHeight());
                        if (z || !a(overlayItem)) {
                            ByteBuffer allocate = ByteBuffer.allocate(a3.getWidth() * a3.getHeight() * 4);
                            a3.copyPixelsToBuffer(allocate);
                            bundle2.putByteArray("imgdata", allocate.array());
                        } else {
                            bundle2.putByteArray("imgdata", null);
                        }
                    }
                }
                String[] a4 = a(overlayItem.getClickRect());
                if (a4 != null && a4.length > 0) {
                    bundle2.putStringArray("clickrect", a4);
                }
                bundle2.putBundle("animate", overlayItem.getAnimate());
                bundle2.putBundle("delay", overlayItem.getDelay());
                parcelItem.setBundle(bundle2);
                arrayList.add(parcelItem);
                if (!z) {
                    this.f4259a.add(overlayItem);
                }
            }
            i = i2 + 1;
        }
        if (arrayList.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                parcelItemArr[i4] = (ParcelItem) arrayList.get(i4);
                i3 = i4 + 1;
            }
            bundle.putParcelableArray("itemdatas", parcelItemArr);
            this.d.getController().getBaseMap().AddItemData(bundle);
        }
        synchronized (this) {
            this.f = true;
        }
    }

    private int b(boolean z) {
        ArrayList arrayList;
        int i;
        int i2 = 0;
        if (this.f4259a != null) {
            synchronized (this) {
                if (this.f4259a.size() != 0) {
                    synchronized (this) {
                        arrayList = new ArrayList(this.f4259a);
                    }
                    int i3 = Integer.MIN_VALUE;
                    int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    Iterator it = arrayList.iterator();
                    while (true) {
                        i = i4;
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoPoint point = ((OverlayItem) it.next()).getPoint();
                        i4 = z ? (int) point.getLatitude() : (int) point.getLongitude();
                        if (i4 > i3) {
                            i3 = i4;
                        }
                        if (i4 >= i) {
                            i4 = i;
                        }
                    }
                    i2 = i3 - i;
                }
            }
        }
        return i2;
    }

    private int c() {
        if (this.j < Integer.MAX_VALUE) {
            int i = this.j + 1;
            this.j = i;
            return i;
        }
        return 0;
    }

    protected int a(int i) {
        synchronized (this) {
            if (this.f4259a == null || this.f4259a.size() == 0) {
                i = -1;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f4259a);
        }
        removeAll();
        addItem(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(boolean z) {
        this.f = z;
    }

    protected boolean a(OverlayItem overlayItem) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f4259a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            OverlayItem overlayItem2 = (OverlayItem) it.next();
            if (overlayItem.getResId() == -1) {
                return false;
            }
            if (overlayItem2.getResId() != -1 && overlayItem.getResId() == overlayItem2.getResId()) {
                return true;
            }
        }
        return false;
    }

    protected String[] a(ArrayList<Bundle> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject = new JSONObject();
            Bundle bundle = arrayList.get(i);
            for (String str : bundle.keySet()) {
                try {
                    jSONObject.put(str, bundle.get(str));
                } catch (JSONException e) {
                }
            }
            strArr[i] = jSONObject.toString();
        }
        return strArr;
    }

    public void addItem(OverlayItem overlayItem) {
        if (overlayItem != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(overlayItem);
            addItem(arrayList);
        }
    }

    public void addItem(List<OverlayItem> list) {
        a(list, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        GeoPoint point;
        GeoPoint point2;
        synchronized (this) {
            point = this.f4259a.get(num.intValue()).getPoint();
            point2 = this.f4259a.get(num2.intValue()).getPoint();
        }
        if (point.getLatitude() > point2.getLatitude()) {
            return -1;
        }
        if (point.getLatitude() >= point2.getLatitude()) {
            if (point.getLongitude() < point2.getLongitude()) {
                return -1;
            }
            return point.getLongitude() == point2.getLongitude() ? 0 : 1;
        }
        return 1;
    }

    public ArrayList<OverlayItem> getAllItem() {
        return this.f4259a;
    }

    public GeoPoint getCenter() {
        int a2 = a(0);
        if (a2 == -1) {
            return null;
        }
        return getItem(a2).getPoint();
    }

    public final OverlayItem getItem(int i) {
        ArrayList arrayList;
        if (this.f4259a == null) {
            return null;
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f4259a);
        }
        if (arrayList.size() <= i || i < 0) {
            return null;
        }
        return (OverlayItem) arrayList.get(i);
    }

    public int getLatSpanE6() {
        return b(true);
    }

    public int getLonSpanE6() {
        return b(false);
    }

    public int getUpdateType() {
        return this.i;
    }

    public void initLayer() {
        this.mLayerID = this.d.getController().getBaseMap().AddLayer(0, 0, MapController.ITEM_LAYER_TAG);
        if (this.mLayerID == 0) {
            throw new RuntimeException("can not add new layer");
        }
    }

    public boolean onTap(int i) {
        return false;
    }

    public boolean onTap(int i, int i2, GeoPoint geoPoint) {
        return false;
    }

    public boolean onTap(GeoPoint geoPoint, MapSurfaceView mapSurfaceView) {
        return false;
    }

    public boolean removeAll() {
        boolean z = true;
        synchronized (this) {
            if (this.f4259a.isEmpty()) {
                z = false;
            } else {
                if (this.d.getController() != null && this.d.getController().getBaseMap() != null) {
                    this.d.getController().getBaseMap().ClearLayer(this.mLayerID);
                }
                synchronized (this) {
                    this.f4259a.clear();
                    this.f = true;
                }
            }
        }
        return z;
    }

    public boolean removeItem(OverlayItem overlayItem) {
        if (this.mLayerID == 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("itemaddr", this.mLayerID);
        if (overlayItem.getId().equals("")) {
            return false;
        }
        bundle.putString("id", overlayItem.getId());
        if (this.d.getController().getBaseMap().RemoveItemData(bundle)) {
            synchronized (this) {
                this.f4259a.remove(overlayItem);
                this.f = true;
            }
            return true;
        }
        return false;
    }

    public boolean removeOneItem(Iterator<OverlayItem> it, OverlayItem overlayItem) {
        if (this.mLayerID == 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("itemaddr", this.mLayerID);
        if (overlayItem.getId().equals("")) {
            return false;
        }
        bundle.putString("id", overlayItem.getId());
        if (this.d.getController().getBaseMap().RemoveItemData(bundle)) {
            it.remove();
            synchronized (this) {
                this.f = true;
            }
            return true;
        }
        return false;
    }

    public void setFocus(int i, boolean z) {
        OverlayItem item;
        ArrayList arrayList;
        if (this.h == null || (item = getItem(i)) == null) {
            return;
        }
        if (z) {
            this.h.setGeoPoint(new GeoPoint(item.getPoint().getLatitude(), item.getPoint().getLongitude()));
            synchronized (this) {
                arrayList = new ArrayList(this.f4259a);
            }
            if (arrayList.contains(this.h)) {
                updateItem(this.h);
            } else {
                addItem(this.h);
            }
        } else {
            removeItem(this.h);
        }
        if (this.d != null) {
            this.d.refresh(this);
        }
    }

    public void setFocusMarker(Drawable drawable) {
        this.g = drawable;
        if (this.h == null) {
            this.h = new OverlayItem(null, "", "");
        }
        this.h.setMarker(this.g);
    }

    public void setFocusMarker(Drawable drawable, float f, float f2) {
        this.g = drawable;
        if (this.h == null) {
            this.h = new OverlayItem(null, "", "");
            this.h.setAnchor(f, f2);
        }
        this.h.setMarker(this.g);
    }

    public void setUpdateType(int i) {
        this.i = i;
    }

    public void setmMarker(Drawable drawable) {
        this.c = drawable;
    }

    public synchronized int size() {
        return this.f4259a == null ? 0 : this.f4259a.size();
    }

    public boolean updateItem(OverlayItem overlayItem) {
        ArrayList arrayList;
        boolean z;
        if (overlayItem != null && !overlayItem.getId().equals("")) {
            synchronized (this) {
                arrayList = new ArrayList(this.f4259a);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (overlayItem.getId().equals(((OverlayItem) it.next()).getId())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(overlayItem);
                a(arrayList2, true);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean updateItem(List<OverlayItem> list) {
        if (list == null) {
            return false;
        }
        a(list, true);
        return true;
    }
}
