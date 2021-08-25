package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class TextOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41491a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41492b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f41493c;

    /* renamed from: d  reason: collision with root package name */
    public String f41494d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f41495e;

    /* renamed from: f  reason: collision with root package name */
    public int f41496f;

    /* renamed from: g  reason: collision with root package name */
    public int f41497g;

    /* renamed from: h  reason: collision with root package name */
    public int f41498h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f41499i;

    /* renamed from: j  reason: collision with root package name */
    public int f41500j;
    public int k;
    public float l;

    public TextOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41497g = -16777216;
        this.f41498h = 12;
        this.f41500j = 4;
        this.k = 32;
        this.f41492b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Text text = new Text();
            text.A = this.f41492b;
            text.z = this.f41491a;
            text.B = this.f41493c;
            text.f41481a = this.f41494d;
            text.f41482b = this.f41495e;
            text.f41483c = this.f41496f;
            text.f41484d = this.f41497g;
            text.f41485e = this.f41498h;
            text.f41486f = this.f41499i;
            text.f41487g = this.f41500j;
            text.f41488h = this.k;
            text.f41489i = this.l;
            return text;
        }
        return (Overlay) invokeV.objValue;
    }

    public TextOptions align(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            this.f41500j = i2;
            this.k = i3;
            return this;
        }
        return (TextOptions) invokeII.objValue;
    }

    public TextOptions bgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f41496f = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public TextOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            this.f41493c = bundle;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions fontColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f41497g = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public TextOptions fontSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f41498h = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public float getAlignX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41500j : invokeV.floatValue;
    }

    public float getAlignY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.floatValue;
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41496f : invokeV.intValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f41493c : (Bundle) invokeV.objValue;
    }

    public int getFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f41497g : invokeV.intValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f41498h : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f41495e : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.floatValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f41494d : (String) invokeV.objValue;
    }

    public Typeface getTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f41499i : (Typeface) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f41491a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f41492b : invokeV.booleanValue;
    }

    public TextOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, latLng)) == null) {
            if (latLng != null) {
                this.f41495e = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions rotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048595, this, f2)) == null) {
            this.l = f2;
            return this;
        }
        return (TextOptions) invokeF.objValue;
    }

    public TextOptions text(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (str == null || str.equals("")) {
                throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
            }
            this.f41494d = str;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions typeface(Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, typeface)) == null) {
            this.f41499i = typeface;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.f41492b = z;
            return this;
        }
        return (TextOptions) invokeZ.objValue;
    }

    public TextOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.f41491a = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }
}
