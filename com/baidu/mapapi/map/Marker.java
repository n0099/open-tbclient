package com.baidu.mapapi.map;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class Marker extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InfoWindow.a A;
    public boolean B;
    public int C;
    public int D;
    public int E;
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
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public ArrayList<BitmapDescriptor> s;
    public int t;
    public Animation u;
    public float v;
    public float w;
    public float x;
    public Point y;
    public InfoWindow z;

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
        this.o = true;
        this.p = false;
        this.q = false;
        this.t = 20;
        this.v = 1.0f;
        this.w = 1.0f;
        this.x = 1.0f;
        this.B = false;
        this.C = Integer.MAX_VALUE;
        this.D = 4;
        this.E = 22;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.c;
    }

    private void a(InfoWindow infoWindow, InfoWindow infoWindow2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, infoWindow, infoWindow2) == null) {
            infoWindow.b = infoWindow2.getBitmapDescriptor();
            infoWindow.d = infoWindow2.getPosition();
            infoWindow.a = infoWindow2.getTag();
            infoWindow.c = infoWindow2.getView();
            infoWindow.g = infoWindow2.getYOffset();
            infoWindow.k = infoWindow2.k;
            infoWindow.e = infoWindow2.e;
        }
    }

    public void setAnchor(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.c = f;
            this.d = f2;
            this.listener.c(this);
        }
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, arrayList, bundle) == null) {
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
            bundle.putFloat("rotate", this.g);
            bundle.putInt("y_offset", this.i);
            bundle.putInt("isflat", this.j ? 1 : 0);
            bundle.putInt("istop", this.k ? 1 : 0);
            bundle.putInt("period", this.t);
            bundle.putFloat(Key.ALPHA, this.l);
            bundle.putInt("m_height", this.r);
            bundle.putFloat(Key.SCALE_X, this.v);
            bundle.putFloat(Key.SCALE_Y, this.w);
            bundle.putInt("isClickable", this.o ? 1 : 0);
            bundle.putInt("priority", this.C);
            bundle.putInt("isJoinCollision", this.p ? 1 : 0);
            bundle.putInt("isForceDisplay", this.q ? 1 : 0);
            bundle.putInt("startLevel", this.D);
            bundle.putInt("endLevel", this.E);
            Point point = this.y;
            if (point != null) {
                bundle.putInt("fix_x", point.x);
                bundle.putInt("fix_y", this.y.y);
            }
            bundle.putInt("isfixed", this.n ? 1 : 0);
            ArrayList<BitmapDescriptor> arrayList = this.s;
            if (arrayList != null && arrayList.size() > 0) {
                a(this.s, bundle);
            }
            bundle2.putBundle("param", bundle);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void cancelAnimation() {
        Animation animation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (animation = this.u) != null) {
            animation.bdAnimation.b();
        }
    }

    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public int getEndLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
    }

    public Point getFixedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.y;
        }
        return (Point) invokeV.objValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.s;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public InfoWindow getInfoWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.z;
        }
        return (InfoWindow) invokeV.objValue;
    }

    public int getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.C;
        }
        return invokeV.intValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.x;
        }
        return invokeV.floatValue;
    }

    public float getScaleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.v;
        }
        return invokeV.floatValue;
    }

    public float getScaleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.w;
        }
        return invokeV.floatValue;
    }

    public int getStartLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public void hideInfoWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            InfoWindow.a aVar = this.A;
            if (aVar != null) {
                aVar.a(this.z);
                this.B = false;
            }
            this.z = null;
        }
    }

    public boolean isClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean isFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean isForceDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean isInfoWindowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public boolean isJoinCollision() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean isPerspective() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void setToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.k = true;
            this.listener.c(this);
        }
    }

    public void startAnimation() {
        Animation animation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (animation = this.u) != null) {
            animation.bdAnimation.a();
        }
    }

    public void setAlpha(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f) == null) {
            if (f >= 0.0f && f <= 1.0d) {
                this.l = f;
                this.listener.c(this);
                return;
            }
            this.l = 1.0f;
        }
    }

    public void setAnimateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.m = i;
            this.listener.c(this);
        }
    }

    public void setAnimation(Animation animation) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, animation) == null) && animation != null) {
            this.u = animation;
            animation.bdAnimation.a(this, animation);
        }
    }

    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.o = z;
            this.listener.c(this);
        }
    }

    public void setDraggable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f = z;
            this.listener.c(this);
        }
    }

    public void setEndLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.E = i;
            this.listener.c(this);
        }
    }

    public void setFixedScreenPosition(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, point) == null) {
            if (point != null) {
                this.y = point;
                this.n = true;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
    }

    public void setFlat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.j = z;
            this.listener.c(this);
        }
    }

    public void setForceDisplay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.q = z;
            this.listener.c(this);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bitmapDescriptor) == null) {
            if (bitmapDescriptor != null) {
                this.b = bitmapDescriptor;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
    }

    public void setJoinCollision(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.p = z;
            this.listener.c(this);
        }
    }

    public void setPeriod(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            if (i > 0) {
                this.t = i;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
    }

    public void setPerspective(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.e = z;
            this.listener.c(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, latLng) == null) {
            if (latLng != null) {
                this.a = latLng;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, latLng) == null) {
            if (latLng != null) {
                this.a = latLng;
                this.listener.c(this);
                InfoWindow infoWindow = this.z;
                if (infoWindow != null) {
                    infoWindow.setPosition(latLng);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
    }

    public void setPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.C = i;
            this.listener.c(this);
        }
    }

    public void setRotate(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f) == null) {
            while (f < 0.0f) {
                f += 360.0f;
            }
            this.g = f % 360.0f;
            this.listener.c(this);
        }
    }

    public void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.v = f;
            this.w = f;
            this.listener.c(this);
        }
    }

    public void setScaleX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.v = f;
            this.listener.c(this);
        }
    }

    public void setScaleY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.w = f;
            this.listener.c(this);
        }
    }

    public void setStartLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.D = i;
            this.listener.c(this);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.h = str;
        }
    }

    public void setYOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.i = i;
            this.listener.c(this);
        }
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, bitmapDescriptor) == null) && (infoWindow = this.z) != null && !infoWindow.l) {
            infoWindow.setBitmapDescriptor(bitmapDescriptor);
        }
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, latLng) == null) && (infoWindow = this.z) != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view2) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, view2) == null) && (infoWindow = this.z) != null && infoWindow.k) {
            infoWindow.setView(view2);
        }
    }

    public void updateInfoWindowYOffset(int i) {
        InfoWindow infoWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048639, this, i) == null) && (infoWindow = this.z) != null) {
            infoWindow.setYOffset(i);
        }
    }

    public void setAnimation(Animation animation, TypeEvaluator typeEvaluator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, animation, typeEvaluator) == null) && animation != null) {
            this.u = animation;
            animation.bdAnimation.a(typeEvaluator);
            this.u.bdAnimation.a(this, animation);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, arrayList) == null) {
            if (arrayList != null) {
                if (arrayList.size() == 0) {
                    return;
                }
                if (arrayList.size() == 1) {
                    this.b = arrayList.get(0);
                } else {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i) == null || arrayList.get(i).a == null) {
                            return;
                        }
                    }
                    this.s = (ArrayList) arrayList.clone();
                    this.b = null;
                }
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, infoWindow) == null) {
            if (infoWindow != null) {
                InfoWindow infoWindow2 = this.z;
                if (infoWindow2 == null) {
                    this.z = infoWindow;
                } else {
                    InfoWindow.a aVar = this.A;
                    if (aVar != null) {
                        aVar.a(infoWindow2);
                    }
                    a(this.z, infoWindow);
                }
                InfoWindow.a aVar2 = this.A;
                if (aVar2 != null) {
                    aVar2.b(this.z);
                    this.B = true;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
        }
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, infoWindow) != null) || infoWindow == null) {
            return;
        }
        if (infoWindow.k) {
            if (infoWindow.c != null) {
                InfoWindow infoWindow2 = this.z;
                if (infoWindow2 == null) {
                    this.z = infoWindow;
                } else {
                    a(infoWindow2, infoWindow);
                }
                InfoWindow infoWindow3 = this.z;
                infoWindow3.j = true;
                InfoWindow.a aVar = this.A;
                if (aVar != null) {
                    aVar.b(infoWindow3);
                    this.B = true;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
    }
}
