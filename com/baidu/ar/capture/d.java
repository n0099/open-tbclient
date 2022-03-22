package com.baidu.ar.capture;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.j;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "d";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean ld;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1381812208, "Lcom/baidu/ar/capture/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1381812208, "Lcom/baidu/ar/capture/d;");
        }
    }

    public d(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.ld = false;
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.nk = pixelReadParams;
        pixelReadParams.setPreFilterID(str);
        this.nk.setOutputWidth(i);
        this.nk.setOutputHeight(i2);
        if ("camera".equals(str)) {
            this.nk.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.ld = false;
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, framePixels)) == null) {
            if (!this.ld || this.mv == null) {
                return true;
            }
            c cVar = new c();
            cVar.W(TAG);
            cVar.setTimestamp(framePixels.getTimestamp());
            cVar.setData(framePixels.getPixelData());
            this.mv.a(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public String cL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nk.getPreFilterID() : (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.ld = z;
        }
    }
}
