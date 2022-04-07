package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.r;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ARAuthFacade implements j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_TYPE_AIP = 1;
    public static final int AUTH_TYPE_AR_SERVER = 2;
    public static final int AUTH_TYPE_PACKAGE = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public f iX;
    public boolean iY;
    public volatile i iZ;
    public IAuthCallback ja;
    public final List<IDuMixAuthCallback> jb;
    public List<IAuthCallback> jc;
    public boolean jd;
    public com.baidu.ar.h.d je;
    public byte[] jf;
    public boolean jg;

    public ARAuthFacade() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.iY = false;
        this.jb = new ArrayList();
        this.jc = new ArrayList();
        this.jd = false;
        this.jg = false;
    }

    private k a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, fVar)) == null) {
            boolean z = (fVar.jH & 2) > 0;
            boolean z2 = (fVar.jH & 4) > 0;
            boolean z3 = (fVar.jH & 1) > 0;
            ArrayList arrayList = new ArrayList();
            if (z2) {
                arrayList.add(new l(fVar));
            }
            if (z) {
                arrayList.add(new b(fVar));
            }
            if (z3 && d.cx()) {
                arrayList.add(new c(fVar));
            }
            if (arrayList.size() > 1) {
                return new h((k[]) arrayList.toArray(new k[arrayList.size()]));
            }
            if (arrayList.size() == 1) {
                return (k) arrayList.get(0);
            }
            return null;
        }
        return (k) invokeL.objValue;
    }

    private void a(Context context, IAuthCallback iAuthCallback, Runnable runnable, ICallbackWith<List<Integer>> iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, context, iAuthCallback, runnable, iCallbackWith) == null) {
            if (this.iZ == null) {
                f fVar = this.iX;
                this.iZ = new i(fVar != null ? fVar.jN : null);
                f fVar2 = this.iX;
                if (fVar2 != null ? a(context, iAuthCallback, fVar2, iCallbackWith) : false) {
                    return;
                }
                a("未知鉴权方式", this.iX, context);
                if (runnable != null) {
                    r.a(runnable, 0L);
                }
            } else if (this.iZ.isRunning()) {
                if (iAuthCallback != null) {
                    this.jc.add(iAuthCallback);
                }
            } else if (this.iZ.isFailed()) {
                this.iZ.cC();
                if (iAuthCallback != null) {
                    iAuthCallback.onError(this.iZ.cB(), 0);
                }
            } else {
                this.iZ.cC();
                if (iAuthCallback != null) {
                    iAuthCallback.onSuccess();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f fVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, fVar, context) == null) {
            if (this.iZ != null) {
                this.iZ.U(str);
            }
            if (context != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pkg", context.getPackageName());
                if (fVar != null) {
                    hashMap.put("authtype", String.valueOf(fVar.jH));
                    hashMap.put("r_appid", fVar.jL);
                }
                hashMap.put("event_param", str);
                StatisticApi.onEvent(StatisticConstants.AUTH_FAILURE, hashMap);
            }
        }
    }

    private boolean a(Context context, IAuthCallback iAuthCallback, f fVar, ICallbackWith<List<Integer>> iCallbackWith) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, this, context, iAuthCallback, fVar, iCallbackWith)) == null) {
            k a = a(fVar);
            if (a != null) {
                a.a(new k.a(this, iCallbackWith) { // from class: com.baidu.ar.auth.ARAuthFacade.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARAuthFacade jj;
                    public final /* synthetic */ ICallbackWith jn;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iCallbackWith};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.jj = this;
                        this.jn = iCallbackWith;
                    }

                    @Override // com.baidu.ar.auth.k.a
                    public void a(Set<Integer> set) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, set) == null) || this.jj.iZ == null) {
                            return;
                        }
                        this.jj.iZ.b(set);
                        ICallbackWith iCallbackWith2 = this.jn;
                        if (iCallbackWith2 != null) {
                            iCallbackWith2.run(this.jj.iZ.cD());
                        }
                    }
                });
                if (this.je == null) {
                    com.baidu.ar.h.d dVar = new com.baidu.ar.h.d("ARAuthWorker");
                    this.je = dVar;
                    dVar.start();
                }
                this.je.execute(new Runnable(this, a, context, iAuthCallback, fVar) { // from class: com.baidu.ar.auth.ARAuthFacade.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARAuthFacade jj;
                    public final /* synthetic */ IAuthCallback jl;
                    public final /* synthetic */ k jo;
                    public final /* synthetic */ f jp;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a, context, iAuthCallback, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.jj = this;
                        this.jo = a;
                        this.val$context = context;
                        this.jl = iAuthCallback;
                        this.jp = fVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.jo.doAuth(this.val$context, new IAuthCallback(this) { // from class: com.baidu.ar.auth.ARAuthFacade.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass8 jq;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.jq = this;
                                }

                                @Override // com.baidu.ar.auth.IAuthCallback
                                public void onError(String str, int i) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeLI(1048576, this, str, i) == null) {
                                        AnonymousClass8 anonymousClass8 = this.jq;
                                        anonymousClass8.jj.a(str, anonymousClass8.jp, anonymousClass8.val$context);
                                        IAuthCallback iAuthCallback2 = this.jq.jl;
                                        if (iAuthCallback2 != null) {
                                            iAuthCallback2.onError(str, i);
                                        }
                                        if (this.jq.jj.jc.isEmpty()) {
                                            return;
                                        }
                                        for (IAuthCallback iAuthCallback3 : this.jq.jj.jc) {
                                            iAuthCallback3.onError(str, i);
                                        }
                                    }
                                }

                                @Override // com.baidu.ar.auth.IAuthCallback
                                public void onSuccess() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        if (this.jq.jj.iZ != null) {
                                            this.jq.jj.iZ.cA();
                                        }
                                        IAuthCallback iAuthCallback2 = this.jq.jl;
                                        if (iAuthCallback2 != null) {
                                            iAuthCallback2.onSuccess();
                                        }
                                        if (this.jq.jj.jc.isEmpty()) {
                                            return;
                                        }
                                        for (IAuthCallback iAuthCallback3 : this.jq.jj.jc) {
                                            iAuthCallback3.onSuccess();
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IDuMixAuthCallback[] cv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            IDuMixAuthCallback[] iDuMixAuthCallbackArr = new IDuMixAuthCallback[this.jb.size()];
            this.jb.toArray(iDuMixAuthCallbackArr);
            return iDuMixAuthCallbackArr;
        }
        return (IDuMixAuthCallback[]) invokeV.objValue;
    }

    private f d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, bArr)) == null) {
            f fVar = new f();
            try {
                e.a(bArr, fVar);
                this.iX = fVar;
            } catch (Exception e) {
                e.printStackTrace();
                this.iX = null;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    private void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            if (!this.iY) {
                f fVar = null;
                byte[] bArr = this.jf;
                if (bArr == null || bArr.length <= 0) {
                    try {
                        fVar = e.m(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    fVar = d(bArr);
                }
                this.iX = fVar;
            }
            this.iY = true;
            f fVar2 = this.iX;
            if (fVar2 == null || TextUtils.isEmpty(fVar2.jL)) {
                return;
            }
            DuMixARConfig.setAppId(this.iX.jL);
            DuMixARConfig.setAPIKey(this.iX.jM);
            DuMixARConfig.setSecretKey("");
        }
    }

    private void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i) == null) {
            r.a(new Runnable(this, i) { // from class: com.baidu.ar.auth.ARAuthFacade.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ARAuthFacade jj;
                public final /* synthetic */ int jm;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.jj = this;
                    this.jm = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.jj.ja != null) {
                            this.jj.ja.onError("未授权功能: " + this.jm, this.jm);
                        }
                        for (IDuMixAuthCallback iDuMixAuthCallback : this.jj.cv()) {
                            iDuMixAuthCallback.onFeatureRejected(this.jm);
                        }
                    }
                }
            }, 0L);
        }
    }

    @Override // com.baidu.ar.auth.j
    public List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, bArr, iDuMixAuthCallback)) == null) {
            if (this.iZ != null) {
                if (iDuMixAuthCallback != null) {
                    if (this.iZ.isRunning()) {
                        this.jb.add(iDuMixAuthCallback);
                    } else if (this.iZ.isFailed()) {
                        iDuMixAuthCallback.onResult(false);
                    } else {
                        iDuMixAuthCallback.onResult(true);
                    }
                }
                f fVar = this.iX;
                return fVar != null ? fVar.jN : new ArrayList();
            } else if (bArr != null) {
                this.jd = true;
                if (iDuMixAuthCallback != null) {
                    this.jb.add(iDuMixAuthCallback);
                }
                f d = d(bArr);
                this.iY = true;
                Runnable runnable = new Runnable(this) { // from class: com.baidu.ar.auth.ARAuthFacade.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARAuthFacade jj;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.jj = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IDuMixAuthCallback[] cv;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (IDuMixAuthCallback iDuMixAuthCallback2 : this.jj.cv()) {
                                iDuMixAuthCallback2.onAvailFeaturesUpdate(new ArrayList());
                                iDuMixAuthCallback2.onResult(false);
                                iDuMixAuthCallback2.onFeatureRejected(0);
                            }
                        }
                    }
                };
                a(context.getApplicationContext(), new IAuthCallback(this, runnable) { // from class: com.baidu.ar.auth.ARAuthFacade.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARAuthFacade jj;
                    public final /* synthetic */ Runnable jk;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.jj = this;
                        this.jk = runnable;
                    }

                    @Override // com.baidu.ar.auth.IAuthCallback
                    public void onError(String str, int i) {
                        Runnable runnable2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i) == null) || (runnable2 = this.jk) == null) {
                            return;
                        }
                        runnable2.run();
                    }

                    @Override // com.baidu.ar.auth.IAuthCallback
                    public void onSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            for (IDuMixAuthCallback iDuMixAuthCallback2 : this.jj.cv()) {
                                iDuMixAuthCallback2.onResult(true);
                            }
                        }
                    }
                }, runnable, new ICallbackWith<List<Integer>>(this) { // from class: com.baidu.ar.auth.ARAuthFacade.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARAuthFacade jj;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.jj = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.ar.callback.ICallbackWith
                    /* renamed from: e */
                    public void run(List<Integer> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                            for (IDuMixAuthCallback iDuMixAuthCallback2 : this.jj.cv()) {
                                iDuMixAuthCallback2.onAvailFeaturesUpdate(list);
                            }
                        }
                    }
                });
                return this.iX != null ? d.jN : new ArrayList();
            } else {
                throw new IllegalStateException("license数据不能为空");
            }
        }
        return (List) invokeLLL.objValue;
    }

    @Override // com.baidu.ar.auth.j
    public List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bArr, iCallbackWith, iCallbackWith2)) == null) {
            return checkAuth(context, bArr, (iCallbackWith == null && iCallbackWith2 == null) ? null : new IDuMixAuthCallback(this, iCallbackWith, iCallbackWith2) { // from class: com.baidu.ar.auth.ARAuthFacade.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ICallbackWith jh;
                public final /* synthetic */ ICallbackWith ji;
                public final /* synthetic */ ARAuthFacade jj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iCallbackWith, iCallbackWith2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.jj = this;
                    this.jh = iCallbackWith;
                    this.ji = iCallbackWith2;
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onAvailFeaturesUpdate(List<Integer> list) {
                    ICallbackWith iCallbackWith3;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) || (iCallbackWith3 = this.jh) == null) {
                        return;
                    }
                    iCallbackWith3.run(list);
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onFeatureRejected(int i) {
                    ICallbackWith iCallbackWith3;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (iCallbackWith3 = this.ji) == null) {
                        return;
                    }
                    iCallbackWith3.run(Integer.valueOf(i));
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    }
                }
            });
        }
        return (List) invokeLLLL.objValue;
    }

    @Override // com.baidu.ar.auth.j
    public boolean checkFeatureAuth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            boolean v = this.iZ != null ? this.iZ.v(i) : true;
            if (!v) {
                u(i);
            }
            if (v) {
                HashMap hashMap = new HashMap();
                hashMap.put("feature_code", String.valueOf(i));
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_FEATURE_AUTH, 200L, hashMap);
            }
            return v;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.ar.auth.j
    public boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bArr)) == null) {
            if (this.iZ != null) {
                return this.iZ.isRunning() || !this.iZ.isFailed();
            }
            if (bArr != null && context != null) {
                this.jd = true;
                f d = d(bArr);
                this.iY = true;
                if (d == null) {
                    this.iZ = new i(null);
                    com.baidu.ar.h.b.b("ARAuth", "invalid license data");
                    this.iZ.U("invalid license data");
                    return false;
                }
                k a = a(d);
                if (a instanceof l) {
                    f fVar = this.iX;
                    this.iZ = new i(fVar != null ? fVar.jN : null);
                    String[] strArr = new String[1];
                    boolean a2 = ((l) a).a(context, strArr);
                    i iVar = this.iZ;
                    if (a2) {
                        iVar.cA();
                    } else {
                        iVar.U(strArr[0]);
                        com.baidu.ar.h.b.b("ARAuth", strArr[0]);
                    }
                    return a2;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.auth.j
    public Bitmap createTipBitmap(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? g.o(context) : (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.ar.auth.j
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, iAuthCallback) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.ja = iAuthCallback;
        if (!this.iY) {
            h(applicationContext);
        }
        a(applicationContext, iAuthCallback, new Runnable(this, iAuthCallback) { // from class: com.baidu.ar.auth.ARAuthFacade.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ARAuthFacade jj;
            public final /* synthetic */ IAuthCallback jl;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iAuthCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.jj = this;
                this.jl = iAuthCallback;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.jl == null) {
                    return;
                }
                this.jl.onError(this.jj.jd ? "请检查传入checkAuth方法的arLicense数据" : !d.cx() ? "请检查dumixar.license文件" : "请检查license文件", 0);
            }
        }, (ICallbackWith<List<Integer>>) null);
    }

    @Override // com.baidu.ar.auth.j
    public boolean enableFeature(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.iZ != null) {
                return this.iZ.v(i);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.ar.auth.j
    public boolean isShowAuthTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            f fVar = this.iX;
            return fVar == null || !fVar.jJ;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ar.auth.j
    public void loadAuthInfo(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || this.jg) {
            return;
        }
        h(context);
    }

    @Override // com.baidu.ar.auth.j
    public void receiveAuthFailMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            u(i);
        }
    }

    @Override // com.baidu.ar.auth.j
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.baidu.ar.h.d dVar = this.je;
            if (dVar != null) {
                dVar.stop();
                this.je = null;
            }
            this.iY = false;
            this.iZ = null;
            this.ja = null;
            this.jb.clear();
            this.jc.clear();
        }
    }

    @Override // com.baidu.ar.auth.j
    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, bArr, str, str2, str3) == null) {
            this.jf = bArr;
            DuMixARConfig.setAppId(str);
            DuMixARConfig.setAPIKey(str2);
            DuMixARConfig.setSecretKey(str3);
            this.jg = !TextUtils.isEmpty(str2);
        }
    }
}
