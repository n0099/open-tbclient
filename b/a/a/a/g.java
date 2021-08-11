package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.fun.ad.sdk.FunSplashAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class g implements FunAdFactory {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static g f1067c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, LinkedHashMap<b.a.a.a.u.g, h>> f1068a;

    /* renamed from: b  reason: collision with root package name */
    public final p f1069b;

    public g() {
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
        this.f1068a = new HashMap();
        this.f1069b = new p(new HashMap());
    }

    public g(p pVar) {
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
        this.f1068a = new HashMap();
        this.f1069b = pVar;
        f1067c = this;
    }

    public final List<h> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f1068a) {
                b.a.a.a.u.g e2 = b.a.a.a.u.c.e(str);
                if (e2 == null) {
                    return null;
                }
                LinkedHashMap<b.a.a.a.u.g, h> linkedHashMap = this.f1068a.get(str);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    this.f1068a.put(str, linkedHashMap);
                }
                if (linkedHashMap.get(e2) == null) {
                    linkedHashMap.put(e2, e2.f1443a.a(this.f1069b));
                }
                return new ArrayList(linkedHashMap.values());
            }
        }
        return (List) invokeL.objValue;
    }

    public final void b(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, funAdInteractionListener, viewGroup, funNativeAdInflater) == null) {
            List<h> a2 = a(str);
            if (a2 == null) {
                b.a.a.a.x.d.b("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return;
            }
            Iterator<h> it = a2.iterator();
            while (it.hasNext() && !it.next().a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater)) {
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f1068a) {
                b.a.a.a.u.g e2 = b.a.a.a.u.c.e(str);
                if (e2 == null) {
                    b.a.a.a.x.d.f("No SlotId found for sid:%s when destroyAd", str);
                    return;
                }
                LinkedHashMap<b.a.a.a.u.g, h> linkedHashMap = this.f1068a.get(str);
                if (linkedHashMap == null) {
                    b.a.a.a.x.d.f("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (Map.Entry<b.a.a.a.u.g, h> entry : linkedHashMap.entrySet()) {
                    b.a.a.a.u.g key = entry.getKey();
                    entry.getValue().a();
                    if (!e2.equals(key)) {
                        b.a.a.a.x.d.b("Remove redundant loader for sid:%s", str);
                        hashSet.add(key);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    linkedHashMap.remove((b.a.a.a.u.g) it.next());
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            List<h> a2 = a(str);
            if (a2 == null) {
                b.a.a.a.x.d.b("No Loader found for sid:%s", str);
                return null;
            }
            for (h hVar : a2) {
                FunNativeAd a3 = hVar.a(context);
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
            List<h> a2 = a(str);
            if (a2 == null) {
                b.a.a.a.x.d.b("No Loader found for sid:%s", str);
                return false;
            }
            for (h hVar : a2) {
                if (hVar.b()) {
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
            List<h> a2 = a(funAdSlot.getSid());
            if (a2 != null) {
                a2.get(0).b(context, funAdSlot, funAdLoadListener);
                return;
            }
            b.a.a.a.x.d.b("No Loader found for sid:%s", funAdSlot.getSid());
            funAdLoadListener.onError(funAdSlot.getSid());
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, funAdInteractionListener) == null) {
            b(activity, str, funAdInteractionListener, viewGroup, null);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, str, funAdInteractionListener, funNativeAdInflater) == null) {
            b(activity, str, funAdInteractionListener, null, funNativeAdInflater);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, funAdInteractionListener)) == null) {
            List<h> a2 = a(str);
            if (a2 == null) {
                b.a.a.a.x.d.b("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return null;
            }
            for (h hVar : a2) {
                FunSplashAd showSplash = hVar.showSplash(activity, viewGroup, str, funAdInteractionListener);
                if (showSplash != null) {
                    return showSplash;
                }
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
