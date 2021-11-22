package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import mapsdkvi.com.gdi.bgl.android.java.EnvDrawText;
/* loaded from: classes7.dex */
public final class Text extends Overlay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "Text";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f40333a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f40334b;

    /* renamed from: c  reason: collision with root package name */
    public int f40335c;

    /* renamed from: d  reason: collision with root package name */
    public int f40336d;

    /* renamed from: e  reason: collision with root package name */
    public int f40337e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f40338f;

    /* renamed from: g  reason: collision with root package name */
    public int f40339g;

    /* renamed from: h  reason: collision with root package name */
    public int f40340h;

    /* renamed from: i  reason: collision with root package name */
    public float f40341i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1025219688, "Lcom/baidu/mapapi/map/Text;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1025219688, "Lcom/baidu/mapapi/map/Text;");
        }
    }

    public Text() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f40963e;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Typeface typeface = this.f40338f;
            if (typeface != null) {
                EnvDrawText.removeFontCache(typeface.hashCode());
            }
            return super.a();
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            super.a(bundle);
            if (this.f40334b != null) {
                bundle.putString("text", this.f40333a);
                GeoPoint ll2mc = CoordUtil.ll2mc(this.f40334b);
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                int i2 = this.f40336d;
                bundle.putInt("font_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
                int i3 = this.f40335c;
                bundle.putInt("bg_color", Color.argb(i3 >>> 24, i3 & 255, (i3 >> 8) & 255, (i3 >> 16) & 255));
                bundle.putInt("font_size", this.f40337e);
                Typeface typeface = this.f40338f;
                if (typeface != null) {
                    EnvDrawText.registFontCache(typeface.hashCode(), this.f40338f);
                    bundle.putInt("type_face", this.f40338f.hashCode());
                }
                int i4 = this.f40339g;
                float f2 = 1.0f;
                bundle.putFloat("align_x", i4 != 1 ? i4 != 2 ? 0.5f : 1.0f : 0.0f);
                int i5 = this.f40340h;
                if (i5 == 8) {
                    f2 = 0.0f;
                } else if (i5 != 16) {
                    f2 = 0.5f;
                }
                bundle.putFloat("align_y", f2);
                bundle.putFloat("rotate", this.f40341i);
                bundle.putInt("update", this.j);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
        }
        return (Bundle) invokeL.objValue;
    }

    public float getAlignX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40339g : invokeV.floatValue;
    }

    public float getAlignY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40340h : invokeV.floatValue;
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40335c : invokeV.intValue;
    }

    public int getFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40336d : invokeV.intValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40337e : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40334b : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40341i : invokeV.floatValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40333a : (String) invokeV.objValue;
    }

    public Typeface getTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40338f : (Typeface) invokeV.objValue;
    }

    public void setAlign(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.f40339g = i2;
            this.f40340h = i3;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f40335c = i2;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f40336d = i2;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f40337e = i2;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: position can not be null");
            }
            this.f40334b = latLng;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setRotate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.f40341i = f2;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (str == null || str.equals("")) {
                throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
            }
            this.f40333a = str;
            this.j = 1;
            this.listener.b(this);
        }
    }

    public void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, typeface) == null) {
            this.f40338f = typeface;
            this.j = 1;
            this.listener.b(this);
        }
    }
}
