package b.f.a0.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class y extends BasePidLoader<h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f31882a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31883b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f31884c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f31885d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f31886e;

        public a(y yVar, h hVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, hVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31886e = yVar;
            this.f31884c = hVar;
            this.f31885d = funAdSlot;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f31886e.mReporter.recordOnClicked(this.f31883b);
                this.f31883b = true;
                this.f31886e.onAdClicked();
            }
        }

        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                LogPrinter.e("JySplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f31886e.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f31886e.onError(i2, str);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f31886e.mReporter.recordLoadSucceed();
                this.f31886e.onAdLoaded((y) this.f31884c);
                this.f31886e.mAdRipper.report(this.f31884c, this.f31885d.getSid());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Ssp.Pid pid) {
        super(pid, true, false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(h hVar) {
        h hVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) || (hVar2 = hVar) == null) {
            return;
        }
        hVar2.a();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            h hVar = (h) b.f.a0.c.a.a(context, this.mPid);
            if (hVar == null) {
                onError(0, "jy 开屏广告创建失败");
                return;
            }
            hVar.c(5000L);
            hVar.e(new a(this, hVar, funAdSlot));
            hVar.b();
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, h hVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, hVar)) == null) {
            this.mReporter.recordShowStart();
            hVar.d(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
