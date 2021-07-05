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
/* loaded from: classes3.dex */
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
    public int f7087a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7088b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7089c;

    /* renamed from: d  reason: collision with root package name */
    public String f7090d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7091e;

    /* renamed from: f  reason: collision with root package name */
    public int f7092f;

    /* renamed from: g  reason: collision with root package name */
    public int f7093g;

    /* renamed from: h  reason: collision with root package name */
    public int f7094h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7095i;
    public int j;
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
        this.f7093g = -16777216;
        this.f7094h = 12;
        this.j = 4;
        this.k = 32;
        this.f7088b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Text text = new Text();
            text.A = this.f7088b;
            text.z = this.f7087a;
            text.B = this.f7089c;
            text.f7078a = this.f7090d;
            text.f7079b = this.f7091e;
            text.f7080c = this.f7092f;
            text.f7081d = this.f7093g;
            text.f7082e = this.f7094h;
            text.f7083f = this.f7095i;
            text.f7084g = this.j;
            text.f7085h = this.k;
            text.f7086i = this.l;
            return text;
        }
        return (Overlay) invokeV.objValue;
    }

    public TextOptions align(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            this.j = i2;
            this.k = i3;
            return this;
        }
        return (TextOptions) invokeII.objValue;
    }

    public TextOptions bgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f7092f = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public TextOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            this.f7089c = bundle;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions fontColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f7093g = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public TextOptions fontSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f7094h = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }

    public float getAlignX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.floatValue;
    }

    public float getAlignY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.floatValue;
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f7092f : invokeV.intValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f7089c : (Bundle) invokeV.objValue;
    }

    public int getFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f7093g : invokeV.intValue;
    }

    public int getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f7094h : invokeV.intValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7091e : (LatLng) invokeV.objValue;
    }

    public float getRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.floatValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f7090d : (String) invokeV.objValue;
    }

    public Typeface getTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f7095i : (Typeface) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f7087a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f7088b : invokeV.booleanValue;
    }

    public TextOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, latLng)) == null) {
            if (latLng != null) {
                this.f7091e = latLng;
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
            this.f7090d = str;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions typeface(Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, typeface)) == null) {
            this.f7095i = typeface;
            return this;
        }
        return (TextOptions) invokeL.objValue;
    }

    public TextOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.f7088b = z;
            return this;
        }
        return (TextOptions) invokeZ.objValue;
    }

    public TextOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.f7087a = i2;
            return this;
        }
        return (TextOptions) invokeI.objValue;
    }
}
