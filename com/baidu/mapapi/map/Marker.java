package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class Marker extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLng a;
    public BitmapDescriptor b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;
    public float g;
    public String h;
    public int i;
    public boolean j;
    public boolean k;
    public float l;
    public int m;
    public boolean n;
    public ArrayList<BitmapDescriptor> o;
    public int p;
    public Animation q;
    public float r;
    public float s;
    public float t;
    public Point u;
    public InfoWindow v;
    public InfoWindow.a w;
    public boolean x;

    public Marker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = false;
        this.n = false;
        this.p = 20;
        this.r = 1.0f;
        this.s = 1.0f;
        this.t = 1.0f;
        this.x = false;
        this.type = com.baidu.mapsdkplatform.comapi.map.h.c;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, arrayList, bundle) == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BitmapDescriptor> it = arrayList.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
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
                if (messageDigest != null) {
                    messageDigest.update(array, 0, array.length);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder("");
                    while (i < digest.length) {
                        sb.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                        i++;
                    }
                    bundle2.putString("image_hashcode", sb.toString());
                }
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
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            Bundle bundle2 = new Bundle();
            BitmapDescriptor bitmapDescriptor = this.b;
            if (bitmapDescriptor != null) {
                bundle.putBundle("image_info", bitmapDescriptor.b());
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
            bundle.putInt("animatetype", this.m);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("perspective", this.e ? 1 : 0);
            bundle.putFloat("anchor_x", this.c);
            bundle.putFloat("anchor_y", this.d);
            bundle.putFloat(AnimationProperty.ROTATE, this.g);
            bundle.putInt("y_offset", this.i);
            bundle.putInt("isflat", this.j ? 1 : 0);
            bundle.putInt("istop", this.k ? 1 : 0);
            bundle.putInt("period", this.p);
            bundle.putFloat(AnimationProperty.OPACITY, this.l);
            bundle.putFloat(AnimationProperty.SCALE_X, this.r);
            bundle.putFloat(AnimationProperty.SCALE_Y, this.s);
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
        return (Bundle) invokeL.objValue;
    }

    public void cancelAnimation() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animation = this.q) == null) {
            return;
        }
        animation.bdAnimation.b();
    }

    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.floatValue;
    }

    public Point getFixedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : (Point) invokeV.objValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (BitmapDescriptor) invokeV.objValue;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (ArrayList) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public InfoWindow getInfoWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.v : (InfoWindow) invokeV.objValue;
    }

    public int getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g : invokeV.floatValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t : invokeV.floatValue;
    }

    public float getScaleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.r : invokeV.floatValue;
    }

    public float getScaleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.s : invokeV.floatValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : invokeV.intValue;
    }

    public void hideInfoWindow() {
        InfoWindow.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (aVar = this.w) == null) {
            return;
        }
        aVar.a(this.v);
        this.x = false;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean isFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isFlat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean isInfoWindowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean isPerspective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void setAlpha(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f) == null) {
            if (f < 0.0f || f > 1.0d) {
                this.l = 1.0f;
                return;
            }
            this.l = f;
            this.listener.b(this);
        }
    }

    public void setAnchor(float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.c = f;
        this.d = f2;
        this.listener.b(this);
    }

    public void setAnimateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.m = i;
            this.listener.b(this);
        }
    }

    public void setAnimation(Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, animation) == null) || animation == null) {
            return;
        }
        this.q = animation;
        animation.bdAnimation.a(this, animation);
    }

    public void setDraggable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f = z;
            this.listener.b(this);
        }
    }

    public void setFixedScreenPosition(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, point) == null) {
            if (point == null) {
                throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
            }
            this.u = point;
            this.n = true;
            this.listener.b(this);
        }
    }

    public void setFlat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.j = z;
            this.listener.b(this);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bitmapDescriptor) == null) {
            if (bitmapDescriptor == null) {
                throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
            }
            this.b = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, arrayList) == null) {
            if (arrayList == null) {
                throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
            }
            if (arrayList.size() == 0) {
                return;
            }
            if (arrayList.size() == 1) {
                bitmapDescriptor = arrayList.get(0);
            } else {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) == null || arrayList.get(i).a == null) {
                        return;
                    }
                }
                this.o = (ArrayList) arrayList.clone();
                bitmapDescriptor = null;
            }
            this.b = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            if (i <= 0) {
                throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
            }
            this.p = i;
            this.listener.b(this);
        }
    }

    public void setPerspective(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.e = z;
            this.listener.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
            }
            this.a = latLng;
            this.listener.b(this);
        }
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
            }
            this.a = latLng;
            this.listener.b(this);
            InfoWindow infoWindow = this.v;
            if (infoWindow != null) {
                infoWindow.setPosition(latLng);
            }
        }
    }

    public void setRotate(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f) == null) {
            while (f < 0.0f) {
                f += 360.0f;
            }
            this.g = f % 360.0f;
            this.listener.b(this);
        }
    }

    public void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.r = f;
            this.s = f;
            this.listener.b(this);
        }
    }

    public void setScaleX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.r = f;
            this.listener.b(this);
        }
    }

    public void setScaleY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.s = f;
            this.listener.b(this);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.h = str;
        }
    }

    public void setToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.k = true;
            this.listener.b(this);
        }
    }

    public void setYOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.i = i;
            this.listener.b(this);
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, infoWindow) == null) {
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
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, infoWindow) == null) || infoWindow == null) {
            return;
        }
        if (!infoWindow.j) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
        }
        if (infoWindow.b == null) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        this.v = infoWindow;
        infoWindow.i = true;
        InfoWindow.a aVar = this.w;
        if (aVar != null) {
            aVar.b(infoWindow);
            this.x = true;
        }
    }

    public void startAnimation() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (animation = this.q) == null) {
            return;
        }
        animation.bdAnimation.a();
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, bitmapDescriptor) == null) || (infoWindow = this.v) == null || infoWindow.k) {
            return;
        }
        infoWindow.setBitmapDescriptor(bitmapDescriptor);
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, latLng) == null) || (infoWindow = this.v) == null) {
            return;
        }
        infoWindow.setPosition(latLng);
    }

    public void updateInfoWindowView(View view2) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, view2) == null) && (infoWindow = this.v) != null && infoWindow.j) {
            infoWindow.setView(view2);
        }
    }

    public void updateInfoWindowYOffset(int i) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i) == null) || (infoWindow = this.v) == null) {
            return;
        }
        infoWindow.setYOffset(i);
    }
}
