package a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class f implements FunAdFactory {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static f f1026c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<t, g>> f1027a;

    /* renamed from: b  reason: collision with root package name */
    public final p f1028b;

    public f() {
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
        this.f1027a = new HashMap();
        this.f1028b = new p(new HashMap());
    }

    public f(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1027a = new HashMap();
        this.f1028b = pVar;
        f1026c = this;
    }

    public final g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f1027a) {
                t b2 = j.b(str);
                if (b2 == null) {
                    return null;
                }
                Map<t, g> map = this.f1027a.get(str);
                if (map == null) {
                    map = new HashMap<>();
                    this.f1027a.put(str, map);
                }
                g gVar = map.get(b2);
                if (gVar == null) {
                    gVar = b2.f1102a.a(this.f1028b);
                    map.put(b2, gVar);
                }
                return gVar;
            }
        }
        return (g) invokeL.objValue;
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, funAdInteractionListener, viewGroup, funNativeAdInflater) == null) {
            g a2 = a(str);
            if (a2 != null) {
                a2.a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater);
                return;
            }
            a.a.a.a.y.d.a("No Loader found for sid:%s", str);
            funAdInteractionListener.onAdError(str);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f1027a) {
                t b2 = j.b(str);
                if (b2 == null) {
                    a.a.a.a.y.d.b("No SlotId found for sid:%s when destroyAd", str);
                    return;
                }
                Map<t, g> map = this.f1027a.get(str);
                if (map == null) {
                    a.a.a.a.y.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (t tVar : map.keySet()) {
                    map.get(tVar).a();
                    if (!b2.equals(tVar)) {
                        a.a.a.a.y.d.a("Remove redundant loader for sid:%s", str);
                        hashSet.add(tVar);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    map.remove((t) it.next());
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            g a2 = a(str);
            if (a2 == null) {
                a.a.a.a.y.d.a("No Loader found for sid:%s", str);
                return null;
            }
            return a2.a(context);
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            g a2 = a(str);
            if (a2 == null) {
                a.a.a.a.y.d.a("No Loader found for sid:%s", str);
                return false;
            }
            return a2.b();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, funAdSlot, funAdLoadListener) == null) {
            g a2 = a(funAdSlot.getSid());
            if (a2 != null) {
                a2.a(context, funAdSlot, funAdLoadListener);
                return;
            }
            a.a.a.a.y.d.a("No Loader found for sid:%s", funAdSlot.getSid());
            funAdLoadListener.onError(funAdSlot.getSid());
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, funAdInteractionListener) == null) {
            a(activity, str, funAdInteractionListener, viewGroup, null);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, str, funAdInteractionListener, funNativeAdInflater) == null) {
            a(activity, str, funAdInteractionListener, null, funNativeAdInflater);
        }
    }
}
