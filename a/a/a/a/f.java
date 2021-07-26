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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class f implements FunAdFactory {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static f f1025c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, LinkedHashMap<a.a.a.a.s.g, g>> f1026a;

    /* renamed from: b  reason: collision with root package name */
    public final o f1027b;

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
        this.f1026a = new HashMap();
        this.f1027b = new o(new HashMap());
    }

    public f(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1026a = new HashMap();
        this.f1027b = oVar;
        f1025c = this;
    }

    public final List<g> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f1026a) {
                a.a.a.a.s.g b2 = a.a.a.a.s.c.b(str);
                if (b2 == null) {
                    return null;
                }
                LinkedHashMap<a.a.a.a.s.g, g> linkedHashMap = this.f1026a.get(str);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    this.f1026a.put(str, linkedHashMap);
                }
                if (linkedHashMap.get(b2) == null) {
                    linkedHashMap.put(b2, b2.f1356a.a(this.f1027b));
                }
                return new ArrayList(linkedHashMap.values());
            }
        }
        return (List) invokeL.objValue;
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, funAdInteractionListener, viewGroup, funNativeAdInflater) == null) {
            List<g> a2 = a(str);
            if (a2 == null) {
                a.a.a.a.v.d.a("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return;
            }
            Iterator<g> it = a2.iterator();
            while (it.hasNext() && !it.next().a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater)) {
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f1026a) {
                a.a.a.a.s.g b2 = a.a.a.a.s.c.b(str);
                if (b2 == null) {
                    a.a.a.a.v.d.b("No SlotId found for sid:%s when destroyAd", str);
                    return;
                }
                LinkedHashMap<a.a.a.a.s.g, g> linkedHashMap = this.f1026a.get(str);
                if (linkedHashMap == null) {
                    a.a.a.a.v.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (Map.Entry<a.a.a.a.s.g, g> entry : linkedHashMap.entrySet()) {
                    a.a.a.a.s.g key = entry.getKey();
                    entry.getValue().a();
                    if (!b2.equals(key)) {
                        a.a.a.a.v.d.a("Remove redundant loader for sid:%s", str);
                        hashSet.add(key);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    linkedHashMap.remove((a.a.a.a.s.g) it.next());
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            List<g> a2 = a(str);
            if (a2 == null) {
                a.a.a.a.v.d.a("No Loader found for sid:%s", str);
                return null;
            }
            for (g gVar : a2) {
                FunNativeAd a3 = gVar.a(context);
                if (a3 != null) {
                    return a3;
                }
            }
            return null;
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<g> a2 = a(str);
            if (a2 == null) {
                a.a.a.a.v.d.a("No Loader found for sid:%s", str);
                return false;
            }
            for (g gVar : a2) {
                if (gVar.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, funAdSlot, funAdLoadListener) == null) {
            List<g> a2 = a(funAdSlot.getSid());
            if (a2 != null) {
                a2.get(0).a(context, funAdSlot, funAdLoadListener);
                return;
            }
            a.a.a.a.v.d.a("No Loader found for sid:%s", funAdSlot.getSid());
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
