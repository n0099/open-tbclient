package com.baidu.ar.face;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.n;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
import com.baidu.ar.face.algo.FAUPoint2D;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.detector.FaceDetector;
import com.baidu.ar.face.detector.j;
import com.baidu.ar.face.detector.m;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.h.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FaceAR extends com.baidu.ar.c implements IFace {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceAR";
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;
    public LuaMsgListener cc;
    public Object mLock;
    public e mv;
    public com.baidu.ar.face.attributes.a nA;
    public boolean nB;
    public int nn;
    public FaceDetector np;
    public FaceListener nq;
    public List<String> nr;
    public String ns;
    public String nt;
    public int nu;
    public int[] nv;
    public int nw;
    public b nx;
    public a.b ny;
    public a.C1636a nz;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1307748651, "Lcom/baidu/ar/face/FaceAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1307748651, "Lcom/baidu/ar/face/FaceAR;");
        }
    }

    public FaceAR() {
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
        this.nr = new ArrayList();
        this.ns = null;
        this.nt = null;
        this.nu = 0;
        this.nw = 0;
        this.nx = new b();
        this.ny = null;
        this.cb = null;
        this.nn = -1;
        this.nB = false;
        this.mLock = new Object();
    }

    private boolean Y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String f2 = i.f(new File(com.baidu.ar.h.a.aP(str)));
                if (TextUtils.isEmpty(f2)) {
                    return false;
                }
                this.nx.b(f2, this.nw);
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.has("mainTriggers")) {
                        this.nr.clear();
                        this.nr.add(jSONObject.getString("mainTriggers"));
                        return true;
                    }
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, mVar) == null) || mVar.eC() == null || mVar.eC().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eC().getFaceFrame();
        if (faceFrame.getTriggersList() == null || faceFrame.getTriggersList().size() <= 0) {
            return;
        }
        for (String[] strArr : faceFrame.getTriggersList()) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    String str2 = this.ns;
                    if (str2 != null && str2.contains(str)) {
                        FaceListener faceListener = this.nq;
                        if (faceListener != null) {
                            faceListener.onTriggerFired(str);
                        }
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE_EXPRESSION);
                    }
                }
            }
        }
    }

    private void a(int[] iArr) {
        int[] iArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, iArr) == null) {
            try {
                iArr2 = c.a(this.nv, iArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                iArr2 = null;
            }
            int i2 = 0;
            if (iArr2 != null && iArr != null && iArr.length > this.nu) {
                int length = iArr2.length;
                while (i2 < length) {
                    int i3 = iArr2[i2];
                    HashMap hashMap = new HashMap();
                    hashMap.put("param_algo_faceid", String.valueOf(i3));
                    StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_ON, hashMap);
                    i2++;
                }
            } else if (iArr2 != null && (iArr == null || iArr.length < this.nu)) {
                int length2 = iArr2.length;
                while (i2 < length2) {
                    int i4 = iArr2[i2];
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("param_algo_faceid", String.valueOf(i4));
                    StatisticApi.onEvent(StatisticConstants.EVENT_FACE_MASKS_OFF, hashMap2);
                    i2++;
                }
            }
            this.nv = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, mVar) == null) || mVar.eC() == null || mVar.eC().getFaceFrame() == null) {
            return;
        }
        FaceFrame faceFrame = mVar.eC().getFaceFrame();
        if (faceFrame.getTrackedPointsList() == null || faceFrame.getTrackedPointsList().size() <= 0) {
            this.nu = 0;
            if (TextUtils.isEmpty(this.nt) || this.nv == null) {
                return;
            }
            a((int[]) null);
            return;
        }
        FAUPoint2D[] fAUPoint2DArr = faceFrame.getTrackedPointsList().get(0);
        int size = faceFrame.getTrackedPointsList().size();
        if (TextUtils.isEmpty(this.nt) || fAUPoint2DArr.length <= 0) {
            return;
        }
        if (faceFrame.getFaceIDList() != null && this.nu != size) {
            a(faceFrame.getFaceIDList());
        }
        this.nu = size;
    }

    private void dl() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || this.np == null) {
            return;
        }
        String str = "ability_face_model";
        if (!q().contains("ability_face_model")) {
            str = "ability_makeup_filter";
            if (!q().contains("ability_makeup_filter")) {
                return;
            }
        }
        this.np.r(str);
    }

    private boolean dm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            int i2 = this.nw;
            return i2 == 2 || i2 == 1;
        }
        return invokeV.booleanValue;
    }

    private void dn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.T) {
                this.nx.dr();
                return;
            }
            int i2 = 180;
            int i3 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            int i4 = this.mInputWidth;
            int i5 = this.mInputHeight;
            int i6 = this.S;
            if (i6 == 90 || i6 == 270) {
                i4 = this.mInputHeight;
                i5 = this.mInputWidth;
            }
            float f2 = i4;
            float f3 = i5;
            float f4 = 180;
            if (Float.compare((f2 * 1.0f) / f3, (1.0f * f4) / ((float) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP)) != 0) {
                if (i4 > i5) {
                    i2 = Math.round(f2 * (f4 / f3));
                    i3 = 180;
                } else {
                    i3 = Math.round(f3 * (f4 / f2));
                }
            }
            this.nx.setAlgoImageWidth(i2);
            this.nx.setAlgoImageHeight(i3);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private j m14do() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            dn();
            j jVar = new j();
            jVar.I(this.nx.getAlgoImageWidth());
            jVar.J(this.nx.getAlgoImageHeight());
            a.b bVar = this.ny;
            if (bVar == null) {
                return jVar;
            }
            jVar.ac(bVar.pW);
            jVar.ad(this.ny.pV);
            jVar.ak(this.ny.qa);
            jVar.al(this.ny.qb);
            a.b bVar2 = this.ny;
            String str = bVar2.pX;
            String str2 = bVar2.pY;
            String str3 = bVar2.pZ;
            String str4 = TAG;
            com.baidu.ar.h.b.c(str4, "classification result：" + this.ny.qg);
            a.C1636a a2 = this.nx.a(this.ny);
            if (a2 != null) {
                this.nz = a2;
                this.nw = c.a(a2.pO, str, str2, str3);
                String str5 = TAG;
                com.baidu.ar.h.b.c(str5, "createFaceParams() mDeviceModelLevel = " + this.nw);
                jVar.ae(a2.pN);
                jVar.af(str);
                jVar.ag(str2);
                jVar.ah(str3);
                jVar.ai(a2.pP);
                jVar.aj(a2.pQ);
                jVar.setTrackingSmoothAlpha(Float.parseFloat(a2.pR));
                jVar.setTrackingSmoothThreshold(Float.parseFloat(a2.pS));
                jVar.setTrackingMouthThreshold(Float.parseFloat(a2.pT));
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.nx.dA()) {
            w(true);
            this.nx.x(false);
        }
    }

    private float dq() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (this.mInputWidth == 0 || (i2 = this.mInputHeight) == 0) {
                return 56.144978f;
            }
            int i3 = this.S;
            if (i3 == 90 || i3 == 270) {
                i2 = this.mInputWidth;
            }
            return (float) (((Math.atan2(i2 * 0.5f, Math.max(this.mInputWidth, this.mInputHeight) * 0.94375f) * 2.0d) * 180.0d) / 3.141592653589793d);
        }
        return invokeV.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65560, this, j2) == null) {
            l r = r();
            if (j2 <= 0 || r == null || q() == null) {
                return;
            }
            try {
                if (q().size() > 0) {
                    r.a(j2, q().get(0));
                }
            } catch (IndexOutOfBoundsException unused) {
                str = TAG;
                str2 = "updateRenderFaceHandle IndexOutOfBoundsException!!!!";
                com.baidu.ar.h.b.b(str, str2);
                a(j2);
            } catch (NullPointerException unused2) {
                str = TAG;
                str2 = "updateRenderFaceHandle NullPointerException!!!!";
                com.baidu.ar.h.b.b(str, str2);
                a(j2);
            }
            a(j2);
        }
    }

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v8 */
    private void w(boolean z) {
        com.baidu.ar.filter.a s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65561, this, z) == null) || (s = s()) == null) {
            return;
        }
        ?? r5 = (z && this.nx.dB() && q().contains("ability_makeup_filter")) ? 1 : 0;
        s.a(FilterNode.makeupFilter, (boolean) r5);
        s.a(FilterParam.MakeupFilter.beautyMakeupFilter, Integer.valueOf((int) r5));
        s.eF();
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null) {
                return;
            }
            try {
                if (algoHandleController.getHandleType(j2) != 10 || this.np == null) {
                    return;
                }
                long handleFaceHandle = AlgoHandleAdapter.getHandleFaceHandle(j2);
                if (handleFaceHandle > 0) {
                    AlgoHandleAdapter.setHandleFaceHandle(j2, 0L);
                    if (this.np != null) {
                        this.np.b(handleFaceHandle);
                    }
                }
                this.np.q(j2);
            } catch (Exception e2) {
                String str = "Destory algoHandle failed.  " + e2.getMessage();
            }
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.adjust(hashMap);
            dl();
        }
    }

    public void configSyncStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.nx.y(z);
            FaceDetector faceDetector = this.np;
            if (faceDetector != null) {
                faceDetector.D(z);
            }
            b(z);
            if (r() != null) {
                r().k(z);
            }
            this.nx.x(true);
        }
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.baidu.ar.h.b.c(TAG, "onCaseCreate start!!!");
            this.nt = str;
            boolean Y = Y(str);
            if (!Y) {
                this.nt = null;
            }
            l r = r();
            if (r != null) {
                r.l(true);
                r.setFieldOfView(dq());
            }
            if (TextUtils.isEmpty(this.nt)) {
                this.nx.A(this.nw);
            } else {
                this.nx.B(this.nw);
            }
            if (!Y) {
                this.nx.ds();
            }
            this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
            List<String> list = this.nr;
            if (list != null && list.size() > 0) {
                List<String> list2 = this.nr;
                this.ns = list2.get(list2.size() - 1);
            }
            FaceListener faceListener = this.nq;
            if (faceListener != null) {
                faceListener.onStickerLoadingFinished(this.nr);
            }
            if (this.nx.dD() > 1) {
                w(false);
            } else {
                w(true);
            }
            dl();
            com.baidu.ar.face.attributes.a aVar = this.nA;
            if (aVar != null) {
                aVar.reset();
            }
        }
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.ar.h.b.c(TAG, "onCaseDestroy!!!");
            this.nt = null;
            this.ns = null;
            this.nu = 0;
            configSyncStatus(dm());
            a((int[]) null);
            this.nx.A(this.nw);
            this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
            dl();
        }
    }

    @Override // com.baidu.ar.c, com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onInputSizeChange(i2, i3);
        }
    }

    @Override // com.baidu.ar.c
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.pause();
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.ar.h.b.c(TAG, "release");
            synchronized (this.mLock) {
                if (this.nB) {
                    this.nB = false;
                    configSyncStatus(false);
                    a((int[]) null);
                    w(false);
                    this.nx.x(false);
                    FaceDetector faceDetector = this.np;
                    if (faceDetector != null) {
                        faceDetector.a((AlgoHandleController) null);
                    }
                    a(this.np);
                    AlgoHandleController algoHandleController = this.cb;
                    if (algoHandleController != null) {
                        algoHandleController.release();
                        this.cb = null;
                    }
                    com.baidu.ar.face.attributes.a aVar = this.nA;
                    if (aVar != null) {
                        aVar.release();
                    }
                    l r = r();
                    if (r != null) {
                        r.q(10);
                    }
                    super.release();
                }
            }
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.resume();
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, faceListener) == null) {
            this.nq = faceListener;
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        a.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) {
            com.baidu.ar.h.b.c(TAG, "detect_frame setup");
            synchronized (this.mLock) {
                if (this.nB) {
                    return;
                }
                this.nB = true;
                boolean z = false;
                if (hashMap != null && !TextUtils.isEmpty((String) hashMap.get("single_frame"))) {
                    z = ((String) hashMap.get("single_frame")).equals("true");
                }
                super.setup(hashMap);
                if (this.cb == null) {
                    this.cb = new AlgoHandleController();
                }
                JSONObject t = t();
                com.baidu.ar.face.a.a aVar = new com.baidu.ar.face.a.a();
                if (t == null || t.toString().trim().equals(StringUtil.EMPTY_ARRAY)) {
                    com.baidu.ar.h.b.k(TAG, "abilityScheme is null, use default config!");
                    a2 = aVar.a(getFaceModelPath(), (JSONObject) null);
                } else {
                    String str = TAG;
                    com.baidu.ar.h.b.c(str, "start parse abilityScheme config: " + t.toString());
                    a2 = aVar.a(getFaceModelPath(), t);
                }
                this.ny = a2;
                if (r() != null) {
                    this.nt = r().bx();
                }
                FaceDetector faceDetector = new FaceDetector();
                this.np = faceDetector;
                if (z) {
                    faceDetector.ej();
                } else {
                    faceDetector.ek();
                }
                this.np.a(this.cb);
                dl();
                this.mv = new e(this) { // from class: com.baidu.ar.face.FaceAR.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceAR nC;

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
                        this.nC = this;
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(com.baidu.ar.d.b bVar) {
                        m eA;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || bVar == null || !(bVar instanceof com.baidu.ar.face.detector.l) || (eA = ((com.baidu.ar.face.detector.l) bVar).eA()) == null) {
                            return;
                        }
                        FaceResultData c2 = c.c(eA);
                        n nVar = (n) bVar.dd();
                        if (nVar != null && c2 != null) {
                            c2.setAlgoImageWidth(nVar.bX());
                            c2.setAlgoImageHeight(nVar.bY());
                        }
                        this.nC.mIsFrontCamera = eA.isFrontCamera();
                        if (this.nC.nA != null) {
                            this.nC.nA.a(eA, c2, this.nC.nx.getAlgoImageWidth(), this.nC.nx.getAlgoImageHeight());
                        }
                        if (this.nC.nq != null) {
                            this.nC.nq.onFaceResult(c2);
                        }
                        this.nC.o(eA.dN());
                        this.nC.dp();
                        this.nC.a(eA);
                        this.nC.b(eA);
                    }

                    @Override // com.baidu.ar.d.e
                    public void a(com.baidu.ar.d.l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                            String str2 = FaceAR.TAG;
                            com.baidu.ar.h.b.c(str2, "FaceDetector onSetup result = " + lVar.isSuccess());
                            this.nC.nn = lVar.dk();
                            l r = this.nC.r();
                            if (r != null) {
                                r.b(this.nC.nn, this.nC.nx.dB());
                            }
                        }
                    }

                    @Override // com.baidu.ar.d.e
                    public void b(com.baidu.ar.d.l lVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                            String str2 = FaceAR.TAG;
                            com.baidu.ar.h.b.c(str2, "FaceDetector onRelease result = " + lVar.isSuccess());
                        }
                    }
                };
                this.np.p(getContext());
                j m14do = m14do();
                this.nx.z(this.nw);
                configSyncStatus(dm());
                this.np.E(u());
                this.np.b(m14do);
                a(this.np, this.mv);
                com.baidu.ar.face.attributes.a aVar2 = new com.baidu.ar.face.attributes.a(r());
                this.nA = aVar2;
                aVar2.b(getContext(), this.ny.qc);
                this.np.a(this.nz, this.nw, this.nx, this.ny, this.nt);
                if (this.cc == null) {
                    this.cc = new LuaMsgListener(this) { // from class: com.baidu.ar.face.FaceAR.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FaceAR nC;

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
                            this.nC = this;
                        }

                        @Override // com.baidu.ar.lua.LuaMsgListener
                        public List<String> getMsgKeyListened() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add("event_name");
                                return arrayList;
                            }
                            return (List) invokeV.objValue;
                        }

                        @Override // com.baidu.ar.lua.LuaMsgListener
                        public void onLuaMessage(HashMap<String, Object> hashMap2) {
                            int a3;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap2) == null) || (a3 = c.a(hashMap2, this.nC.np.em())) < 0) {
                                return;
                            }
                            this.nC.configSyncStatus(a3 == 2);
                        }
                    };
                }
                a(this.cc);
                this.np.b((Bundle) null);
            }
        }
    }
}
