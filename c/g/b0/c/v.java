package c.g.b0.c;

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
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBMediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class v extends ReporterPidLoader<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<f, b> f28343h;

    /* loaded from: classes9.dex */
    public class a implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28344b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f28345c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ v f28346d;

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
            this.f28346d = vVar;
            this.f28345c = fVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.f28346d.onAdClicked(this.f28344b);
                this.f28344b = true;
                synchronized (this.f28346d.f28343h) {
                    b bVar = this.f28346d.f28343h.get(this.f28345c);
                    if (bVar != null) {
                        bVar.f28348c.onAdClicked(bVar.a, this.f28346d.mPid.ssp.type, this.f28346d.mPid.pid);
                    }
                }
            }
        }

        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                LogPrinter.e("onFail code: " + i2 + ", message: " + str, new Object[0]);
                this.f28346d.onError(i2, str);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f28346d.onAdLoaded((v) this.f28345c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28347b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdInteractionListener f28348c;

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
            this.a = str;
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
        this.f28343h = new HashMap<>();
    }

    public JYNativeAdView a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(R.layout.fun_jy_ad_native_view, (ViewGroup) null, false);
            jYNativeAdView.a.setText(fVar.f());
            jYNativeAdView.f54152d.setText(fVar.h());
            GlideHelper.get().load(jYNativeAdView.getContext(), fVar.j(), jYNativeAdView.f54153e);
            jYNativeAdView.f54154f.setText(fVar.g());
            jYNativeAdView.f54155g = (fVar.l() * 1.0f) / (fVar.k() * 1.0f);
            fVar.c(jYNativeAdView, jYNativeAdView.f54151c);
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
            synchronized (this.f28343h) {
                b bVar = this.f28343h.get(fVar);
                if (bVar == null) {
                    bVar = new b(str);
                    this.f28343h.put(fVar, bVar);
                }
                onShowStart(bVar.f28347b);
                bVar.f28347b = true;
                bVar.f28348c = funAdInteractionListener;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (fVar = (f) obj) == null) {
            return;
        }
        fVar.a();
        synchronized (this.f28343h) {
            this.f28343h.remove(fVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) ? c(context, (f) obj, str) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            f fVar = (f) obj;
            z c2 = c(context, fVar, str);
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, fVar, c2, new w(this, c2));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean isAdAvailable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            f fVar = (f) obj;
            return fVar != null && fVar.n();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            f fVar = (f) c.g.b0.c.a.a(context, this.mPid);
            onLoadStart(funAdSlot);
            if (fVar == null) {
                onError(0, "jy native广告创建失败");
                return;
            }
            fVar.e(new a(this, fVar));
            fVar.b();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, obj)) == null) {
            onShowStart();
            JYNativeAdView a2 = a((f) obj);
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, str, funNativeAdInflater, obj)) == null) {
            f fVar = (f) obj;
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(c(activity, fVar, str));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            fVar.d(adContainer, null, clickViews);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
