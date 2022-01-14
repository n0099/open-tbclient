package com.baidu.ar.anime;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.d.e;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public int cj;
    public int ck;
    public boolean cl;
    public InterfaceC1756a cm;

    /* renamed from: com.baidu.ar.anime.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1756a {
        void b(FramePixels framePixels);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-45179963, "Lcom/baidu/ar/anime/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-45179963, "Lcom/baidu/ar/anime/a;");
        }
    }

    public a() {
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
        this.cj = 720;
        this.ck = 1280;
        this.cl = true;
        this.cm = null;
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(this.cj);
        this.nk.setOutputHeight(this.ck);
    }

    public void a(InterfaceC1756a interfaceC1756a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1756a) == null) {
            this.cm = interfaceC1756a;
        }
    }

    public void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.nk.setOutputWidth(this.ck);
            this.nk.setOutputHeight(this.cj);
            this.nk.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
        }
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(new l(getName(), true));
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cl : invokeV.booleanValue;
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.b(new l(getName(), true));
    }

    @Override // com.baidu.ar.d.j
    public final boolean c(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, framePixels)) == null) {
            if (this.cl) {
                this.cl = false;
                InterfaceC1756a interfaceC1756a = this.cm;
                if (interfaceC1756a != null) {
                    interfaceC1756a.b(framePixels);
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.nk.setPreFilterID(str);
        }
    }
}
