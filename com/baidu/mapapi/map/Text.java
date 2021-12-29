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
import com.tachikoma.core.component.anim.AnimationProperty;
import mapsdkvi.com.gdi.bgl.android.java.EnvDrawText;
/* loaded from: classes10.dex */
public final class Text extends Overlay {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: k  reason: collision with root package name */
    public static final String f36605k = "Text";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f36606b;

    /* renamed from: c  reason: collision with root package name */
    public int f36607c;

    /* renamed from: d  reason: collision with root package name */
    public int f36608d;

    /* renamed from: e  reason: collision with root package name */
    public int f36609e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f36610f;

    /* renamed from: g  reason: collision with root package name */
    public int f36611g;

    /* renamed from: h  reason: collision with root package name */
    public int f36612h;

    /* renamed from: i  reason: collision with root package name */
    public float f36613i;

    /* renamed from: j  reason: collision with root package name */
    public int f36614j;

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
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f37094e;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Typeface typeface = this.f36610f;
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
            if (this.f36606b != null) {
                bundle.putString("text", this.a);
                GeoPoint ll2mc = CoordUtil.ll2mc(this.f36606b);
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                int i2 = this.f36608d;
                bundle.putInt("font_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
                int i3 = this.f36607c;
                bundle.putInt("bg_color", Color.argb(i3 >>> 24, i3 & 255, (i3 >> 8) & 255, (i3 >> 16) & 255));
                bundle.putInt("font_size", this.f36609e);
                Typeface typeface = this.f36610f;
                if (typeface != null) {
                    EnvDrawText.registFontCache(typeface.hashCode(), this.f36610f);
                    bundle.putInt("type_face", this.f36610f.hashCode());
                }
                int i4 = this.f36611g;
                float f2 = 1.0f;
                bundle.putFloat("align_x", i4 != 1 ? i4 != 2 ? 0.5f : 1.0f : 0.0f);
                int i5 = this.f36612h;
                if (i5 == 8) {
                    f2 = 0.0f;
                } else if (i5 != 16) {
                    f2 = 0.5f;
                }
                bundle.putFloat("align_y", f2);
                bundle.putFloat(AnimationProperty.ROTATE, this.f36613i);
                bundle.putInt("update", this.f36614j);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
        }
        return (Bundle) invokeL.objValue;
    }

    public float getAlignX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36611g : invokeV.floatValue;
    }

    public float getAlignY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36612h : invokeV.floatValue;
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36607c : invokeV.intValue;
    }

    public int getFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36608d : invokeV.intValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36609e : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36606b : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36613i : invokeV.floatValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public Typeface getTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f36610f : (Typeface) invokeV.objValue;
    }

    public void setAlign(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.f36611g = i2;
            this.f36612h = i3;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f36607c = i2;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f36608d = i2;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f36609e = i2;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: position can not be null");
            }
            this.f36606b = latLng;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setRotate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.f36613i = f2;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (str == null || str.equals("")) {
                throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
            }
            this.a = str;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }

    public void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, typeface) == null) {
            this.f36610f = typeface;
            this.f36614j = 1;
            this.listener.b(this);
        }
    }
}
