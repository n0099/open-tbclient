package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.n;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.face.detector.m;
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
public class FamilyWithChildAR extends com.baidu.ar.c implements ICapture {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;
    public LuaMsgListener cc;
    public ICaptureAbilityListener lb;
    public int ll;
    public int lm;
    public d ln;
    public d lo;
    public com.baidu.ar.d.e lp;
    public com.baidu.ar.d.e lq;
    public com.baidu.ar.d.e lr;
    public ICallbackWith<ICaptureResult> ls;
    public volatile boolean lt;
    public e lu;
    public boolean lv;
    public boolean lw;
    public a lx;

    public FamilyWithChildAR() {
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
        this.ll = 720;
        this.lm = 1280;
        this.lt = false;
        this.lv = false;
        this.lw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            if (this.ln == null) {
                this.ln = new d("camera", this.ll, this.lm);
                com.baidu.ar.d.e eVar = new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.capture.FamilyWithChildAR.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FamilyWithChildAR ly;

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
                        this.ly = this;
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(com.baidu.ar.d.b bVar) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) && this.ly.lt && (bVar instanceof c)) {
                            this.ly.a((c) bVar);
                        }
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        }
                    }

                    @Override // com.baidu.ar.d.e
                    public void b(l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        }
                    }
                };
                this.lp = eVar;
                a(this.ln, eVar);
            }
            d dVar = this.lo;
            if (dVar != null && !dVar.cL().equals(str)) {
                a(this.lo);
                this.lo = null;
            }
            if (this.lo == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "target";
                }
                this.lo = new d(str, this.ll, this.lm);
                com.baidu.ar.d.e eVar2 = new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.capture.FamilyWithChildAR.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FamilyWithChildAR ly;

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
                        this.ly = this;
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(com.baidu.ar.d.b bVar) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) && this.ly.lt && (bVar instanceof c)) {
                            this.ly.b((c) bVar);
                        }
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        }
                    }

                    @Override // com.baidu.ar.d.e
                    public void b(l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        }
                    }
                };
                this.lq = eVar2;
                a(this.lo, eVar2);
            }
            if (this.lw) {
                return;
            }
            this.lw = true;
            com.baidu.ar.d.e eVar3 = new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.capture.FamilyWithChildAR.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FamilyWithChildAR ly;

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
                    this.ly = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        if (this.ly.lt && (bVar instanceof com.baidu.ar.face.detector.l)) {
                            this.ly.a((com.baidu.ar.face.detector.l) bVar);
                        }
                        if (this.ly.cb != null) {
                            this.ly.cb.destroyHandle(bVar.de());
                        } else {
                            AlgoHandleAdapter.destroyHandle(bVar.de());
                        }
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            };
            this.lr = eVar3;
            a("FaceDetector", eVar3, (HashMap<String, Object>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, cVar) == null) {
            String str = "camera time: " + cVar.getTimestamp();
            e eVar = this.lu;
            if ((eVar == null || eVar.le == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
                d dVar = this.ln;
                if (dVar != null) {
                    dVar.s(false);
                }
                this.lu.le = cVar.getData();
                cN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.face.detector.l lVar) {
        m eA;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, lVar) == null) || this.lv) {
            return;
        }
        String str = "face time: " + lVar.getTimestamp();
        if (!b(lVar) || (eA = lVar.eA()) == null) {
            return;
        }
        this.lv = true;
        FaceResultData c2 = com.baidu.ar.face.c.c(eA);
        n nVar = (n) lVar.dd();
        if (c2 != null && nVar != null) {
            c2.setAlgoImageWidth(nVar.bX());
            c2.setAlgoImageHeight(nVar.bY());
        }
        e eVar = this.lu;
        if (eVar != null) {
            eVar.lk = c2;
        }
        cN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, cVar) == null) {
            String str = "output time: " + cVar.getTimestamp();
            e eVar = this.lu;
            if ((eVar == null || eVar.lf == null) && b((com.baidu.ar.d.b) cVar) && this.lu != null) {
                d dVar = this.lo;
                if (dVar != null) {
                    dVar.s(false);
                }
                this.lu.lf = cVar.getData();
                cN();
            }
        }
    }

    private void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, runnable) == null) {
            if (this.lx == null) {
                a aVar = new a("FamilyWithChildAR");
                this.lx = aVar;
                aVar.start();
            }
            this.lx.execute(runnable);
        }
    }

    private boolean b(com.baidu.ar.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, bVar)) == null) {
            e eVar = this.lu;
            if (eVar != null) {
                if (eVar.getTimestamp() == bVar.getTimestamp()) {
                    return true;
                }
                if (bVar.getTimestamp() <= this.lu.getTimestamp()) {
                    return false;
                }
                this.lu = null;
                d dVar = this.ln;
                if (dVar != null) {
                    dVar.s(true);
                }
                d dVar2 = this.lo;
                if (dVar2 != null) {
                    dVar2.s(true);
                }
                this.lv = false;
            }
            if (this.lu == null) {
                e eVar2 = new e();
                this.lu = eVar2;
                eVar2.timestamp = bVar.getTimestamp();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.lw = false;
            com.baidu.ar.d.e eVar = this.lr;
            if (eVar != null) {
                a("FaceDetector", eVar);
                this.lr = null;
            }
            d dVar = this.ln;
            if (dVar != null) {
                a(dVar);
            }
            d dVar2 = this.lo;
            if (dVar2 != null) {
                a(dVar2);
            }
            this.lo = null;
            this.ln = null;
            this.lp = null;
            this.lq = null;
        }
    }

    private void cN() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || !this.lt || (eVar = this.lu) == null || this.ls == null || eVar.le == null || eVar.lf == null || !this.lv) {
            return;
        }
        t(false);
        e eVar2 = this.lu;
        eVar2.li = this.ll;
        eVar2.lj = this.lm;
        b(new Runnable(this) { // from class: com.baidu.ar.capture.FamilyWithChildAR.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FamilyWithChildAR ly;

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
                this.ly = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.ly.cM();
                    this.ly.ls.run(this.ly.lu);
                    this.ly.lu = null;
                }
            }
        });
        this.lv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, iCallbackWith) == null) {
            if (iCallbackWith != null) {
                this.ls = iCallbackWith;
            }
            if (this.lt) {
                return;
            }
            this.lv = false;
            this.lu = null;
            t(true);
        }
    }

    private void t(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65558, this, z) == null) || this.ln == null || this.lo == null) {
            return;
        }
        this.lt = z;
        this.ln.s(z);
        this.lo.s(z);
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j2) != 23) {
                return;
            }
            this.cb.destroyHandle(j2);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCallbackWith) == null) {
            V(null);
            d(iCallbackWith);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ICaptureAbilityListener iCaptureAbilityListener = this.lb;
            if (iCaptureAbilityListener != null) {
                iCaptureAbilityListener.onClose();
            }
            this.lb = null;
            LuaMsgListener luaMsgListener = this.cc;
            if (luaMsgListener != null) {
                b(luaMsgListener);
                this.cc = null;
            }
            cM();
            a aVar = this.lx;
            if (aVar != null) {
                aVar.stop();
                this.lx = null;
            }
            this.ls = null;
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            com.baidu.ar.arrender.l r = r();
            if (r != null) {
                r.q(23);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, strArr) == null) || strArr == null || strArr.length <= 0 || r() == null) {
            return;
        }
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        long a = f.a(this.cb, strArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bitmapArr) == null) || bitmapArr == null || bitmapArr.length <= 0 || r() == null) {
            return;
        }
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        long a = f.a(this.cb, bitmapArr, 23);
        r().a(a, "ability_capture");
        a(a);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iCaptureAbilityListener) == null) {
            this.lb = iCaptureAbilityListener;
            if (iCaptureAbilityListener != null) {
                iCaptureAbilityListener.onOpen();
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iCallbackWith) == null) {
            this.ls = iCallbackWith;
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            super.setup(hashMap);
            int i2 = this.mInputWidth;
            int i3 = this.mInputHeight;
            if (i2 > i3) {
                this.ll = i3;
                this.lm = i2;
            } else {
                this.ll = i2;
                this.lm = i3;
            }
            this.cb = new AlgoHandleController();
            LuaMsgListener luaMsgListener = new LuaMsgListener(this) { // from class: com.baidu.ar.capture.FamilyWithChildAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FamilyWithChildAR ly;

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
                    this.ly = this;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Arrays.asList("event_name") : (List) invokeV.objValue;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap2) == null) {
                        String str = (String) hashMap2.get("event_name");
                        if ("get_pixel_frame".equals(str)) {
                            this.ly.V((String) hashMap2.get("filter_id"));
                            this.ly.d((ICallbackWith<ICaptureResult>) null);
                        } else if (!"need_face".equals(str) || this.ly.lb == null) {
                        } else {
                            this.ly.lb.onOpen();
                        }
                    }
                }
            };
            this.cc = luaMsgListener;
            a(luaMsgListener);
            com.baidu.ar.arrender.l r = r();
            if (r != null) {
                r.b(23, false);
            }
        }
    }
}
