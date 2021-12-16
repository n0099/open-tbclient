package com.baidu.ar.arrender;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler aO;
    public List<String> ic;
    public LuaMsgListener ie;

    /* renamed from: if  reason: not valid java name */
    public com.baidu.ar.lua.d f1if;
    public IARPRenderer ig;
    public PixelReadParams ih;
    public PixelReadListener ii;

    public k(Looper looper, com.baidu.ar.lua.d dVar, IARPRenderer iARPRenderer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, dVar, iARPRenderer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (looper == null || dVar == null || iARPRenderer == null) {
            com.baidu.ar.h.b.b("FrameCapture", "create FrameCapture error!!! As params NULLLLL!!!");
        }
        this.aO = new Handler(looper);
        this.f1if = dVar;
        this.ig = iARPRenderer;
    }

    private void a(com.baidu.ar.lua.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, dVar) == null) {
            this.ic = Arrays.asList("event_name");
            LuaMsgListener luaMsgListener = new LuaMsgListener(this) { // from class: com.baidu.ar.arrender.k.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k ij;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ij = this;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.ij.ic : (List) invokeV.objValue;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    PixelReadParams pixelReadParams;
                    PixelRotation pixelRotation;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || this.ij.ig == null || this.ij.ih == null || this.ij.ii == null) {
                        return;
                    }
                    String str = (String) hashMap.get("event_name");
                    com.baidu.ar.h.b.c("FrameCapture", "createLuaCaptureListener eventName = " + str);
                    if (!"capture_frame".equals(str)) {
                        if ("clear_capture".equals(str)) {
                            this.ij.ig.clearCaptureData();
                            return;
                        }
                        return;
                    }
                    this.ij.ih.setPreFilterID((String) hashMap.get("filter_id"));
                    if (this.ij.ih.getPreFilterID().equals("camera") || TextUtils.isEmpty(this.ij.ih.getPreFilterID())) {
                        if (this.ij.ig.isFrontCamera()) {
                            pixelReadParams = this.ij.ih;
                            pixelRotation = PixelRotation.RotateRightFlipHorizontal;
                        } else {
                            pixelReadParams = this.ij.ih;
                            pixelRotation = PixelRotation.RotateRight;
                        }
                        pixelReadParams.setPixelRotate(pixelRotation);
                    }
                    this.ij.ig.createPixelReaderByPreFilterID(this.ij.ih, this.ij.ii);
                }
            };
            this.ie = luaMsgListener;
            dVar.addLuaMsgListener(luaMsgListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (handler = this.aO) == null) {
            return;
        }
        handler.post(new Runnable(this) { // from class: com.baidu.ar.arrender.k.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k ij;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.ij = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.ij.bU();
                }
            }
        });
    }

    private void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i2, i3) == null) {
            PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
            this.ih = pixelReadParams;
            pixelReadParams.setOutputWidth(i2);
            this.ih.setOutputHeight(i3);
            this.ih.setFrameType(PixelReadParams.FrameType.SINGLE_FRAME);
            this.ii = new PixelReadListener(this) { // from class: com.baidu.ar.arrender.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k ij;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ij = this;
                }

                @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
                public boolean onPixelRead(FramePixels framePixels) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, framePixels)) == null) {
                        if (framePixels == null || this.ij.ig == null) {
                            return false;
                        }
                        com.baidu.ar.h.b.c("FrameCapture", "onPixelRead textureID = " + framePixels.getTextureID());
                        this.ij.ig.setCaptureData(framePixels.getTextureID());
                        this.ij.bW();
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            };
        }
    }

    public void bU() {
        IARPRenderer iARPRenderer;
        PixelReadParams pixelReadParams;
        PixelReadListener pixelReadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iARPRenderer = this.ig) == null || (pixelReadParams = this.ih) == null || (pixelReadListener = this.ii) == null) {
            return;
        }
        iARPRenderer.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void bV() {
        IARPRenderer iARPRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iARPRenderer = this.ig) == null) {
            return;
        }
        iARPRenderer.clearCaptureData();
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            h(i2, i3);
            a(this.f1if);
        }
    }

    public void release() {
        LuaMsgListener luaMsgListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Handler handler = this.aO;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.aO = null;
            }
            com.baidu.ar.lua.d dVar = this.f1if;
            if (dVar != null && (luaMsgListener = this.ie) != null) {
                dVar.removeLuaMsgListener(luaMsgListener);
            }
            this.f1if = null;
            this.ie = null;
            this.ic = null;
            this.ih = null;
            this.ii = null;
            this.ig = null;
        }
    }
}
