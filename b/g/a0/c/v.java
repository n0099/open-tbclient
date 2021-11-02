package b.g.a0.c;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.channel.jy.R;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBMediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class v extends BasePidLoader<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<f, b> f31010h;

    /* loaded from: classes6.dex */
    public class a implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f31011a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f31013c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ v f31014d;

        public a(v vVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31014d = vVar;
            this.f31013c = fVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f31014d.mReporter.recordOnClicked(this.f31012b);
                this.f31012b = true;
                this.f31014d.onAdClicked();
                synchronized (this.f31014d.f31010h) {
                    b bVar = this.f31014d.f31010h.get(this.f31013c);
                    if (bVar != null) {
                        bVar.f31017c.onAdClicked(bVar.f31015a, this.f31014d.mPid.ssp.type, this.f31014d.mPid.pid);
                    }
                }
            }
        }

        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                LogPrinter.e("onFail code: " + i2 + ", message: " + str, new Object[0]);
                this.f31014d.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f31014d.onError(i2, str);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f31014d.mReporter.recordLoadSucceed();
                this.f31014d.onAdLoaded((v) this.f31013c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f31015a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31016b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdInteractionListener f31017c;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31015a = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Ssp.Pid pid) {
        super(pid, true, true);
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
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31010h = new HashMap<>();
    }

    public JYNativeAdView a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(R.layout.fun_jy_ad_native_view, (ViewGroup) null, false);
            jYNativeAdView.f62772a.setText(fVar.f());
            jYNativeAdView.f62775d.setText(fVar.h());
            GlideHelper.get().load(jYNativeAdView.getContext(), fVar.j(), jYNativeAdView.f62776e);
            jYNativeAdView.f62777f.setText(fVar.g());
            jYNativeAdView.f62778g = (fVar.l() * 1.0f) / (fVar.k() * 1.0f);
            fVar.c(jYNativeAdView, jYNativeAdView.f62774c);
            return jYNativeAdView;
        }
        return (JYNativeAdView) invokeL.objValue;
    }

    public final z c(Context context, f fVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, str)) == null) {
            return new z(fVar, fVar.o() ? new PBMediaView(context.getApplicationContext()) : null, str, this.mPid, this);
        }
        return (z) invokeLLL.objValue;
    }

    public final void d(f fVar, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str, funAdInteractionListener) == null) {
            synchronized (this.f31010h) {
                b bVar = this.f31010h.get(fVar);
                if (bVar == null) {
                    bVar = new b(str);
                    this.f31010h.put(fVar, bVar);
                }
                this.mReporter.recordShowStart(bVar.f31016b);
                bVar.f31016b = true;
                bVar.f31017c = funAdInteractionListener;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(f fVar) {
        f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (fVar2 = fVar) == null) {
            return;
        }
        fVar2.a();
        synchronized (this.f31010h) {
            this.f31010h.remove(fVar2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, fVar)) == null) ? c(context, fVar, str) : (FunNativeAd) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, fVar)) == null) {
            f fVar2 = fVar;
            z c2 = c(context, fVar2, str);
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, fVar2, c2, new w(this, c2));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean isAdAvailable(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            f fVar2 = fVar;
            return fVar2 != null && fVar2.n();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            f fVar = (f) b.g.a0.c.a.a(context, this.mPid);
            if (fVar == null) {
                onError(0, "jy native广告创建失败");
                return;
            }
            fVar.e(new a(this, fVar));
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            fVar.b();
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, f fVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, fVar)) == null) {
            this.mReporter.recordShowStart();
            JYNativeAdView a2 = a(fVar);
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, f fVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, str, funNativeAdInflater, fVar)) == null) {
            f fVar2 = fVar;
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(c(activity, fVar2, str));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            fVar2.d(adContainer, null, clickViews);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
