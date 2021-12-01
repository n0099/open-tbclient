package c.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.GuardedBy;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.IRipperCallBack;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class t0 implements FunAdFactory {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f28909f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, LinkedHashMap<p, FunAdLoader>> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f28910b;
    @GuardedBy("mInitializeLock")

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<a> f28911c;
    @GuardedBy("mInitializeLock")

    /* renamed from: d  reason: collision with root package name */
    public int f28912d;
    @GuardedBy("mInitializeLock")

    /* renamed from: e  reason: collision with root package name */
    public i f28913e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f28914b;

        /* renamed from: c  reason: collision with root package name */
        public final FunAdLoadListener f28915c;

        public a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f28914b = funAdSlot;
            this.f28915c = funAdLoadListener;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1579643553, "Lc/g/t0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1579643553, "Lc/g/t0;");
                return;
            }
        }
        f28909f = !t0.class.desiredAssertionStatus();
    }

    public t0() {
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
        this.a = new HashMap();
        this.f28910b = new Object();
        this.f28911c = new LinkedList<>();
        this.f28912d = 0;
    }

    public final List<FunAdLoader> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.a) {
                p b2 = h.b(str);
                if (b2 == null) {
                    return null;
                }
                LinkedHashMap<p, FunAdLoader> linkedHashMap = this.a.get(str);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    this.a.put(str, linkedHashMap);
                }
                if (linkedHashMap.get(b2) == null) {
                    linkedHashMap.put(b2, b2.a.a(this.f28913e));
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.values());
                Collections.reverse(arrayList);
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    public final void b(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater, IRipperCallBack iRipperCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, funAdInteractionListener, viewGroup, funNativeAdInflater, iRipperCallBack}) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return;
            }
            Iterator<FunAdLoader> it = a2.iterator();
            while (it.hasNext()) {
                FunAdLoader next = it.next();
                if (!it.hasNext()) {
                    next.show(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater, null);
                    return;
                } else if (next.isReady()) {
                    next.show(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater, null);
                    return;
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f28910b) {
                this.f28911c.clear();
            }
            synchronized (this.a) {
                p b2 = h.b(str);
                if (b2 == null) {
                    LogPrinter.e("No SlotId found for sid:%s when destroyAd", str);
                    return;
                }
                LinkedHashMap<p, FunAdLoader> linkedHashMap = this.a.get(str);
                if (linkedHashMap == null) {
                    LogPrinter.e("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (Map.Entry<p, FunAdLoader> entry : linkedHashMap.entrySet()) {
                    p key = entry.getKey();
                    entry.getValue().destroy();
                    if (!b2.equals(key)) {
                        LogPrinter.d("Remove redundant loader for sid:%s", str);
                        hashSet.add(key);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    linkedHashMap.remove((p) it.next());
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    @Deprecated
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                return null;
            }
            for (FunAdLoader funAdLoader : a2) {
                FunNativeAd nativeAd = funAdLoader.getNativeAd(context);
                if (nativeAd != null) {
                    return nativeAd;
                }
            }
            return null;
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                return null;
            }
            for (FunAdLoader funAdLoader : a2) {
                FunNativeAd2 nativeAd2 = funAdLoader.getNativeAd2(context);
                if (nativeAd2 != null) {
                    return nativeAd2;
                }
            }
            return null;
        }
        return (FunNativeAd2) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                return false;
            }
            for (FunAdLoader funAdLoader : a2) {
                if (funAdLoader.isReady()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.f28910b) {
                i2 = this.f28912d;
            }
            if (i2 == -1) {
                LogPrinter.e("loadAd err because of AdSdks initialized failed", new Object[0]);
                funAdLoadListener.onError(funAdSlot.getSid());
            } else if (i2 == 0) {
                synchronized (this.f28910b) {
                    this.f28911c.add(new a(context, funAdSlot, funAdLoadListener));
                }
            } else if (i2 != 1) {
                throw new RuntimeException("Unknown st:" + i2);
            } else {
                List<FunAdLoader> a2 = a(funAdSlot.getSid());
                if (a2 == null) {
                    LogPrinter.d("No Loader found for sid:%s", funAdSlot.getSid());
                    funAdLoadListener.onError(funAdSlot.getSid());
                    return;
                }
                Iterator<FunAdLoader> it = a2.iterator();
                FunAdLoader next = it.next();
                while (it.hasNext()) {
                    it.next().recycleLisener();
                }
                next.load(context, funAdSlot, funAdLoadListener);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, viewGroup, str, funAdInteractionListener) == null) {
            b(activity, str, funAdInteractionListener, viewGroup, null, null);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, funAdInteractionListener, funNativeAdInflater) == null) {
            b(activity, str, funAdInteractionListener, null, funNativeAdInflater, null);
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, viewGroup, str, funAdInteractionListener)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return null;
            }
            for (FunAdLoader funAdLoader : a2) {
                FunSplashAd showSplash = funAdLoader.showSplash(activity, viewGroup, str, funAdInteractionListener);
                if (showSplash != null) {
                    return showSplash;
                }
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
