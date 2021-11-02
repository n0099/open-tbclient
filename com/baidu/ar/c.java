package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.c;
import com.baidu.ar.arrender.l;
import com.baidu.ar.d.g;
import com.baidu.ar.d.j;
import com.baidu.ar.d.k;
import com.baidu.ar.imu.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class c implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.filter.a B;
    public a C;
    public String L;
    public JSONObject M;
    public HashMap<String, com.baidu.ar.d.e> N;
    public List<k> O;
    public boolean P;
    public List<String> Q;
    public c.b R;
    public int S;
    public boolean T;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.ar.mdl.b f36454e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.ar.lua.b f36455f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.ar.arrender.c f36456g;

    /* renamed from: h  reason: collision with root package name */
    public g f36457h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.ar.imu.c f36458i;
    public Context mContext;
    public Handler mHandler;
    public int mInputHeight;
    public int mInputWidth;
    public boolean mIsFrontCamera;
    public int mOutputHeight;
    public int mOutputWidth;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(String str, com.baidu.ar.d.e eVar);

        boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap);
    }

    public c() {
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
        this.O = new ArrayList();
        this.P = false;
        this.Q = new CopyOnWriteArrayList();
        this.T = true;
        this.mIsFrontCamera = true;
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            com.baidu.ar.arrender.c cVar = this.f36456g;
            if (cVar == null || cVar.bt() == null) {
                return false;
            }
            return this.f36456g.bt().isSyncInputContent();
        }
        return invokeV.booleanValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
        }
    }

    public void a(Context context, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, looper) == null) {
            this.mContext = context;
            this.mHandler = new Handler(looper);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.C = aVar;
        }
    }

    public void a(g gVar, com.baidu.ar.arrender.c cVar, com.baidu.ar.filter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, gVar, cVar, aVar) == null) {
            this.f36457h = gVar;
            this.f36456g = cVar;
            this.B = aVar;
            this.mInputWidth = cVar.bt().getInputWidth();
            this.mInputHeight = cVar.bt().getInputHeight();
            this.mOutputWidth = cVar.bu().getOutputWidth();
            this.mOutputHeight = cVar.bu().getOutputHeight();
            this.S = cVar.bt().getInputDegree();
            this.T = cVar.bt().isCameraInput();
            this.mIsFrontCamera = cVar.bt().isFrontCamera();
            c.b bVar = new c.b(this) { // from class: com.baidu.ar.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c U;

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
                    this.U = this;
                }

                @Override // com.baidu.ar.arrender.c.b
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        c cVar2 = this.U;
                        cVar2.mOutputWidth = i2;
                        cVar2.mOutputHeight = i3;
                    }
                }
            };
            this.R = bVar;
            cVar.a(bVar);
            cVar.a(this);
            if (v()) {
                this.P = true;
            }
        }
    }

    public final void a(k kVar) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            if (kVar == null) {
                com.baidu.ar.h.b.b("AbstractAR", "removeDetector error!!! detector is null!!!");
                return;
            }
            if ((kVar instanceof j) && (cVar = this.f36456g) != null) {
                j jVar = (j) kVar;
                cVar.destroyPixelReader(jVar.di(), jVar);
            }
            g gVar = this.f36457h;
            if (gVar != null) {
                gVar.a(kVar);
            }
            List<k> list = this.O;
            if (list != null) {
                list.remove(kVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r2 != 270) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(k kVar, com.baidu.ar.d.e eVar) {
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, kVar, eVar) == null) {
            if (kVar == null) {
                com.baidu.ar.h.b.b("AbstractAR", "addDetector error!!! detector is null!!!");
                return;
            }
            if ((kVar instanceof j) && this.f36456g != null) {
                this.O.add(kVar);
                j jVar = (j) kVar;
                jVar.a(this.mHandler);
                jVar.b(this.P);
                PixelReadParams di = jVar.di();
                if (this.T && di.getIsPortrait()) {
                    if (!this.mIsFrontCamera) {
                        pixelRotation = PixelRotation.RotateRight;
                        di.setPixelRotate(pixelRotation);
                        this.f36456g.createPixelReader(di, jVar);
                    }
                    pixelRotation = PixelRotation.RotateRightFlipHorizontal;
                    di.setPixelRotate(pixelRotation);
                    this.f36456g.createPixelReader(di, jVar);
                } else {
                    if (!this.T) {
                        int i2 = this.S;
                        if (i2 == 0) {
                            pixelRotation = PixelRotation.FlipVertical;
                        } else if (i2 == 90) {
                            pixelRotation = PixelRotation.RotateRightFlipVertical;
                        } else if (i2 == 180) {
                            pixelRotation = PixelRotation.FlipHorizontal;
                        }
                        di.setPixelRotate(pixelRotation);
                    }
                    this.f36456g.createPixelReader(di, jVar);
                }
            }
            g gVar = this.f36457h;
            if (gVar != null) {
                gVar.a(kVar, eVar);
            }
        }
    }

    public void a(com.baidu.ar.imu.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f36458i = cVar;
        }
    }

    public final void a(com.baidu.ar.imu.g gVar) {
        com.baidu.ar.imu.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || (cVar = this.f36458i) == null) {
            return;
        }
        cVar.stop(gVar);
    }

    public final void a(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, luaMsgListener) == null) || (bVar = this.f36455f) == null || bVar.fk() == null) {
            return;
        }
        this.f36455f.fk().addLuaMsgListener(luaMsgListener);
    }

    public void a(com.baidu.ar.lua.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f36455f = bVar;
        }
    }

    public final void a(com.baidu.ar.lua.c cVar) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (bVar = this.f36455f) == null) {
            return;
        }
        bVar.c(cVar);
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            this.M = jSONObject;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mIsFrontCamera = z;
            for (k kVar : this.O) {
                if ((kVar instanceof j) && this.f36456g != null) {
                    PixelReadParams di = ((j) kVar).di();
                    if (this.T && di.getIsPortrait()) {
                        PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                        di.setPixelRotate(pixelRotation);
                        this.f36456g.updatePixelReader(di, pixelRotation);
                    }
                }
            }
        }
    }

    public final boolean a(i iVar, com.baidu.ar.imu.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, iVar, gVar)) == null) {
            com.baidu.ar.imu.c cVar = this.f36458i;
            if (cVar != null) {
                return cVar.start(iVar, gVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean a(String str, com.baidu.ar.d.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, eVar)) == null) {
            if (this.C == null || TextUtils.isEmpty(str) || eVar == null) {
                return false;
            }
            HashMap<String, com.baidu.ar.d.e> hashMap = this.N;
            if (hashMap != null) {
                hashMap.remove(str);
            }
            return this.C.a(str, eVar);
        }
        return invokeLL.booleanValue;
    }

    public final boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, eVar, hashMap)) == null) {
            if (this.C == null || TextUtils.isEmpty(str) || eVar == null) {
                return false;
            }
            if (this.N == null) {
                this.N = new HashMap<>();
            }
            this.N.put(str, eVar);
            return this.C.a(str, eVar, hashMap);
        }
        return invokeLLL.booleanValue;
    }

    public void adjust(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, hashMap) == null) || hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if ("sync".equals(str)) {
            z = true;
        } else {
            "async".equals(str);
        }
        boolean z2 = v() ? true : z;
        if (z2 != this.P) {
            this.P = z2;
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
                }
                g gVar = this.f36457h;
                if (gVar != null) {
                    gVar.a((j) kVar);
                }
            }
        }
    }

    public final void b(int i2, HashMap<String, Object> hashMap) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i2, hashMap) == null) || (bVar = this.f36455f) == null) {
            return;
        }
        bVar.b(i2, hashMap);
    }

    public final void b(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, luaMsgListener) == null) || (bVar = this.f36455f) == null || bVar.fk() == null) {
            return;
        }
        this.f36455f.fk().removeLuaMsgListener(luaMsgListener);
    }

    public final void b(com.baidu.ar.lua.c cVar) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) || (bVar = this.f36455f) == null) {
            return;
        }
        bVar.d(cVar);
    }

    public void b(String str, com.baidu.ar.d.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, str, eVar) == null) || this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.d.a)) {
                ((com.baidu.ar.d.a) kVar).b(eVar);
            }
        }
    }

    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            List<String> list2 = this.Q;
            if (list2 != null && !list2.contains(str)) {
                this.Q.add(str);
            }
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (v()) {
                z = true;
            }
            if (z != this.P) {
                this.P = z;
                List<k> list = this.O;
                if (list == null) {
                    return;
                }
                for (k kVar : list) {
                    if (kVar != null && (kVar instanceof j)) {
                        ((j) kVar).b(this.P);
                    }
                    g gVar = this.f36457h;
                    if (gVar != null) {
                        gVar.a((j) kVar);
                    }
                }
            }
        }
    }

    public void c(String str, com.baidu.ar.d.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, eVar) == null) || this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.d.a)) {
                ((com.baidu.ar.d.a) kVar).c(eVar);
            }
        }
    }

    public final void d(HashMap<String, Object> hashMap) {
        com.baidu.ar.lua.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, hashMap) == null) || (bVar = this.f36455f) == null) {
            return;
        }
        bVar.b(1902, hashMap);
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public String getFaceModelPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    public SparseArray<com.baidu.ar.mdl.a> getMdlConfigs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            com.baidu.ar.mdl.b bVar = this.f36454e;
            if (bVar == null) {
                com.baidu.ar.h.b.b("AbstractAR", "mMdlConfigParams is null.");
                return new SparseArray<>();
            }
            return bVar.fm();
        }
        return (SparseArray) invokeV.objValue;
    }

    public void i(String str) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (list = this.Q) == null || list.contains(str)) {
            return;
        }
        this.Q.add(str);
    }

    public void j(String str) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || (list = this.Q) == null) {
            return;
        }
        list.remove(str);
    }

    public void o() {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (list = this.Q) == null) {
            return;
        }
        list.clear();
    }

    public void onCaseCreate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
        }
    }

    public void onCaseDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    @Override // com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i2, int i3) {
        com.baidu.ar.arrender.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) || (cVar = this.f36456g) == null) {
            return;
        }
        this.mInputWidth = cVar.bt().getInputWidth();
        this.mInputHeight = this.f36456g.bt().getInputHeight();
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            List<String> list = this.Q;
            if (list == null || list.size() <= 0) {
                for (k kVar : this.O) {
                    if (kVar != null && (kVar instanceof com.baidu.ar.d.a) && ((com.baidu.ar.d.a) kVar).db()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    public final List<String> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.Q : (List) invokeV.objValue;
    }

    public final l r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f36456g : (l) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            HashMap<String, com.baidu.ar.d.e> hashMap = this.N;
            if (hashMap != null) {
                for (Map.Entry<String, com.baidu.ar.d.e> entry : hashMap.entrySet()) {
                    a(entry.getKey(), entry.getValue());
                }
                this.N.clear();
                this.N = null;
            }
            int size = this.O.size();
            k[] kVarArr = new k[size];
            this.O.toArray(kVarArr);
            for (int i2 = 0; i2 < size; i2++) {
                a(kVarArr[i2]);
            }
            this.O.clear();
            this.O = null;
            this.f36457h = null;
            this.f36458i = null;
            this.f36456g = null;
            this.B = null;
            this.f36455f = null;
            this.M = null;
            this.mHandler = null;
            this.mContext = null;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public final com.baidu.ar.filter.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.B : (com.baidu.ar.filter.a) invokeV.objValue;
    }

    public void setFaceModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.L = str;
        }
    }

    public void setMdlConfigParams(com.baidu.ar.mdl.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            this.f36454e = bVar;
        }
    }

    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, hashMap) == null) || hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (!TextUtils.isEmpty(str) && "sync".equals(str)) {
            this.P = true;
        }
        if (v()) {
            this.P = true;
        }
    }

    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.M : (JSONObject) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            com.baidu.ar.arrender.c cVar = this.f36456g;
            return (cVar == null || cVar.bt() == null || this.f36456g.bt().getInputTexture() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
