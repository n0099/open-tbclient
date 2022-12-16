package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.OverlayItem;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.fun.ad.sdk.FunAdSdk;
import com.yy.gslbsdk.db.DelayTB;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ItemizedOverlay<Item extends OverlayItem> extends Overlay implements Comparator<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<OverlayItem> a;
    public ArrayList<Integer> b;
    public Drawable c;
    public MapSurfaceView d;
    public MapTextureView e;
    public boolean f;
    public Drawable g;
    public OverlayItem h;
    public int i;
    public int j;

    public boolean onTap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean onTap(int i, int i2, GeoPoint geoPoint) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048595, this, i, i2, geoPoint)) == null) {
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onTap(GeoPoint geoPoint, MapSurfaceView mapSurfaceView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, geoPoint, mapSurfaceView)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public ItemizedOverlay(Drawable drawable, MapSurfaceView mapSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, mapSurfaceView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.mType = 27;
        this.c = drawable;
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.d = mapSurfaceView;
        this.mLayerID = 0L;
    }

    public boolean removeOneItem(Iterator<OverlayItem> it, OverlayItem overlayItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, it, overlayItem)) == null) {
            if (this.mLayerID == 0) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("itemaddr", this.mLayerID);
            if (overlayItem.getId().equals("")) {
                return false;
            }
            bundle.putString("id", overlayItem.getId());
            if (!this.d.getController().getBaseMap().RemoveItemData(bundle)) {
                return false;
            }
            it.remove();
            synchronized (this) {
                this.f = true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public ItemizedOverlay(Drawable drawable, MapTextureView mapTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, mapTextureView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.mType = 27;
        this.c = drawable;
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.e = mapTextureView;
        this.mLayerID = 0L;
    }

    private void a(List<OverlayItem> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, list, z) == null) {
            a(list, z, false);
        }
    }

    private void a(List<OverlayItem> list, boolean z, boolean z2) {
        GeoPoint point;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                synchronized (this) {
                    if (this.a != null) {
                        this.a.clear();
                    }
                }
            }
            if (this.mLayerID == 0) {
                if (!z) {
                    synchronized (this) {
                        if (this.a != null && list != null) {
                            this.a.addAll(list);
                        }
                    }
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.clear();
            ArrayList arrayList = new ArrayList();
            bundle.putLong("itemaddr", this.mLayerID);
            bundle.putInt("bshow", 1);
            if (z) {
                bundle.putString("extparam", StickerDataChangeType.UPDATE);
            }
            for (int i = 0; i < list.size(); i++) {
                OverlayItem overlayItem = list.get(i);
                if (overlayItem.getMarker() == null) {
                    overlayItem.setMarker(this.c);
                }
                if (TextUtils.isEmpty(overlayItem.getId())) {
                    overlayItem.setId(ae.a());
                }
                ParcelItem parcelItem = new ParcelItem();
                Drawable marker = overlayItem.getMarker();
                byte[] gifData = overlayItem.getGifData();
                if (marker != null || gifData != null) {
                    Bundle bundle2 = new Bundle();
                    if (overlayItem.getCoordType() == OverlayItem.CoordType.CoordType_BD09LL) {
                        point = aa.a(overlayItem.getPoint());
                    } else {
                        point = overlayItem.getPoint();
                    }
                    bundle2.putDouble("x", point.getLongitude());
                    bundle2.putDouble("y", point.getLatitude());
                    bundle2.putFloat(MapBundleKey.MapObjKey.OBJ_GEO_Z, overlayItem.getGeoZ());
                    bundle2.putInt(MapBundleKey.MapObjKey.OBJ_INDOOR_POI, overlayItem.getIndoorPoi());
                    bundle2.putInt("showLR", 1);
                    bundle2.putInt("iconwidth", 0);
                    bundle2.putInt("iconlayer", 1);
                    bundle2.putFloat(FunAdSdk.PLATFORM_AX, overlayItem.getAnchorX());
                    bundle2.putFloat("ay", overlayItem.getAnchorY());
                    bundle2.putInt("bound", overlayItem.getBound());
                    bundle2.putInt("level", overlayItem.getLevel());
                    bundle2.putInt("mask", overlayItem.getMask());
                    bundle2.putString("popname", "" + overlayItem.getId());
                    if (gifData != null) {
                        bundle2.putFloat("gifscale", overlayItem.getScale());
                        bundle2.putInt("gifsize", gifData.length);
                        bundle2.putByteArray("imgdata", gifData);
                        bundle2.putInt("imgindex", c());
                    } else {
                        Bitmap a = com.baidu.platform.comapi.util.d.a(marker);
                        if (a != null) {
                            bundle2.putInt("imgindex", overlayItem.getResId());
                            bundle2.putInt("imgW", a.getWidth());
                            bundle2.putInt("imgH", a.getHeight());
                            if (!z && a(overlayItem)) {
                                bundle2.putByteArray("imgdata", null);
                            } else {
                                ByteBuffer allocate = ByteBuffer.allocate(a.getWidth() * a.getHeight() * 4);
                                a.copyPixelsToBuffer(allocate);
                                bundle2.putByteArray("imgdata", allocate.array());
                            }
                        }
                    }
                    String[] a2 = a(overlayItem.getClickRect());
                    if (a2 != null && a2.length > 0) {
                        bundle2.putStringArray("clickrect", a2);
                    }
                    bundle2.putBundle("animate", overlayItem.getAnimate());
                    bundle2.putBundle(DelayTB.DELAY, overlayItem.getDelay());
                    parcelItem.setBundle(bundle2);
                    arrayList.add(parcelItem);
                    if (!z) {
                        this.a.add(overlayItem);
                    }
                }
            }
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                }
                bundle.putParcelableArray("itemdatas", parcelItemArr);
                this.d.getController().getBaseMap().AddItemData(bundle, z2);
            }
            synchronized (this) {
                this.f = true;
            }
        }
    }

    private int b(boolean z) {
        InterceptResult invokeZ;
        ArrayList arrayList;
        double longitude;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            if (this.a == null) {
                return 0;
            }
            synchronized (this) {
                if (this.a.size() == 0) {
                    return 0;
                }
                synchronized (this) {
                    arrayList = new ArrayList(this.a);
                }
                int i = Integer.MIN_VALUE;
                int i2 = Integer.MAX_VALUE;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GeoPoint point = ((OverlayItem) it.next()).getPoint();
                    if (z) {
                        longitude = point.getLatitude();
                    } else {
                        longitude = point.getLongitude();
                    }
                    int i3 = (int) longitude;
                    if (i3 > i) {
                        i = i3;
                    }
                    if (i3 < i2) {
                        i2 = i3;
                    }
                }
                return i - i2;
            }
        }
        return invokeZ.intValue;
    }

    public boolean a(OverlayItem overlayItem) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, overlayItem)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.a);
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
        return invokeL.booleanValue;
    }

    public boolean removeItem(OverlayItem overlayItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, overlayItem)) == null) {
            if (this.mLayerID == 0) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("itemaddr", this.mLayerID);
            if (overlayItem.getId().equals("")) {
                return false;
            }
            bundle.putString("id", overlayItem.getId());
            if (!this.d.getController().getBaseMap().RemoveItemData(bundle)) {
                return false;
            }
            synchronized (this) {
                this.a.remove(overlayItem);
                this.f = true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateItem(OverlayItem overlayItem) {
        InterceptResult invokeL;
        ArrayList arrayList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, overlayItem)) == null) {
            if (overlayItem == null || overlayItem.getId().equals("")) {
                return false;
            }
            synchronized (this) {
                arrayList = new ArrayList(this.a);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (overlayItem.getId().equals(((OverlayItem) it.next()).getId())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(overlayItem);
            a(arrayList2, true);
            return true;
        }
        return invokeL.booleanValue;
    }

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.j;
            if (i < Integer.MAX_VALUE) {
                int i2 = i + 1;
                this.j = i2;
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.a);
            }
            removeAll();
            addItem(arrayList);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<OverlayItem> getAllItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public GeoPoint getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int a = a(0);
            if (a == -1) {
                return null;
            }
            return getItem(a).getPoint();
        }
        return (GeoPoint) invokeV.objValue;
    }

    public int getLatSpanE6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return b(true);
        }
        return invokeV.intValue;
    }

    public int getLonSpanE6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return b(false);
        }
        return invokeV.intValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            long AddLayer = this.d.getController().getBaseMap().AddLayer(0, 0, "item");
            this.mLayerID = AddLayer;
            if (AddLayer != 0) {
                return;
            }
            throw new RuntimeException("can not add new layer");
        }
    }

    public synchronized int size() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    size = 0;
                } else {
                    size = this.a.size();
                }
            }
            return size;
        }
        return invokeV.intValue;
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this) {
                if (this.a != null && this.a.size() != 0) {
                    return i;
                }
                return -1;
            }
        }
        return invokeI.intValue;
    }

    public void addItem(OverlayItem overlayItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, overlayItem) == null) && overlayItem != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(overlayItem);
            addItem(arrayList);
        }
    }

    public void addItemsByReplace(List<OverlayItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            a(list, false, true);
        }
    }

    public void setFocusMarker(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, drawable) == null) {
            this.g = drawable;
            if (this.h == null) {
                this.h = new OverlayItem(null, "", "");
            }
            this.h.setMarker(this.g);
        }
    }

    public void setUpdateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.i = i;
        }
    }

    public void setmMarker(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            this.c = drawable;
        }
    }

    public boolean updateItem(List<OverlayItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, list)) == null) {
            if (list == null) {
                return false;
            }
            a(list, true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this) {
                this.f = z;
            }
        }
    }

    public void addItem(List<OverlayItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            a(list, false, false);
        }
    }

    public String[] a(ArrayList<Bundle> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = new JSONObject();
                    Bundle bundle = arrayList.get(i);
                    for (String str : bundle.keySet()) {
                        try {
                            jSONObject.put(str, bundle.get(str));
                        } catch (JSONException unused) {
                        }
                    }
                    strArr[i] = jSONObject.toString();
                }
                return strArr;
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        InterceptResult invokeLL;
        GeoPoint point;
        GeoPoint point2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, num, num2)) == null) {
            synchronized (this) {
                point = this.a.get(num.intValue()).getPoint();
                point2 = this.a.get(num2.intValue()).getPoint();
            }
            if (point.getLatitude() > point2.getLatitude()) {
                return -1;
            }
            if (point.getLatitude() < point2.getLatitude()) {
                return 1;
            }
            if (point.getLongitude() < point2.getLongitude()) {
                return -1;
            }
            if (point.getLongitude() != point2.getLongitude()) {
                return 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public void setFocus(int i, boolean z) {
        OverlayItem item;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.h != null && (item = getItem(i)) != null) {
            if (z) {
                this.h.setGeoPoint(new GeoPoint(item.getPoint().getLatitude(), item.getPoint().getLongitude()));
                synchronized (this) {
                    arrayList = new ArrayList(this.a);
                }
                if (arrayList.contains(this.h)) {
                    updateItem(this.h);
                } else {
                    addItem(this.h);
                }
            } else {
                removeItem(this.h);
            }
            MapSurfaceView mapSurfaceView = this.d;
            if (mapSurfaceView != null) {
                mapSurfaceView.refresh(this);
            }
        }
    }

    public final OverlayItem getItem(int i) {
        InterceptResult invokeI;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.a == null) {
                return null;
            }
            synchronized (this) {
                arrayList = new ArrayList(this.a);
            }
            if (arrayList.size() <= i || i < 0) {
                return null;
            }
            return (OverlayItem) arrayList.get(i);
        }
        return (OverlayItem) invokeI.objValue;
    }

    public boolean removeAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return false;
                }
                if (this.d.getController() != null && this.d.getController().getBaseMap() != null) {
                    this.d.getController().getBaseMap().ClearLayer(this.mLayerID);
                }
                synchronized (this) {
                    this.a.clear();
                    this.f = true;
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void setFocusMarker(Drawable drawable, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{drawable, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.g = drawable;
            if (this.h == null) {
                OverlayItem overlayItem = new OverlayItem(null, "", "");
                this.h = overlayItem;
                overlayItem.setAnchor(f, f2);
            }
            this.h.setMarker(this.g);
        }
    }
}
