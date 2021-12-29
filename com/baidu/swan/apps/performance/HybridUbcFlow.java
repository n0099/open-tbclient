package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import c.a.r0.a.k;
import c.a.r0.a.n2.m;
import c.a.r0.a.n2.n;
import c.a.r0.a.u1.l.f;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.w;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class HybridUbcFlow {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final SubmitStrategy s;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f40316b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f40317c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f40318d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, UbcFlowEvent> f40319e;

    /* renamed from: f  reason: collision with root package name */
    public final List<UbcFlowEvent> f40320f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40321g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40322h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40323i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40324j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f40325k;
    public volatile boolean l;
    public SubmitStrategy m;
    public final Map<String, List<e>> n;
    public final Map<String, Object> o;
    public final String p;
    public String q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static abstract class SubmitStrategy {
        public static final /* synthetic */ SubmitStrategy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SubmitStrategy HYBRID;
        public static final SubmitStrategy HYBRID_WEB;
        public static final SubmitStrategy NA_ONLY;
        public static final SubmitStrategy PREFETCH_NA;
        public static final SubmitStrategy RELAUNCH;
        public static final SubmitStrategy RELAUNCH_WEB;
        public static final SubmitStrategy ROUTE;
        public static final SubmitStrategy ROUTE_NA;
        public static final SubmitStrategy ROUTE_WEB;
        public static final SubmitStrategy SWAN_WEB;
        public static final SubmitStrategy VIDEO_NA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(630304424, "Lcom/baidu/swan/apps/performance/HybridUbcFlow$SubmitStrategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(630304424, "Lcom/baidu/swan/apps/performance/HybridUbcFlow$SubmitStrategy;");
                    return;
                }
            }
            HYBRID = new SubmitStrategy("HYBRID", 0) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t() : invokeL.booleanValue;
                }
            };
            HYBRID_WEB = new SubmitStrategy("HYBRID_WEB", 1) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w() : invokeL.booleanValue;
                }
            };
            RELAUNCH = new SubmitStrategy("RELAUNCH", 2) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t() : invokeL.booleanValue;
                }
            };
            RELAUNCH_WEB = new SubmitStrategy("RELAUNCH_WEB", 3) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w() : invokeL.booleanValue;
                }
            };
            NA_ONLY = new SubmitStrategy("NA_ONLY", 4) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() : invokeL.booleanValue;
                }
            };
            ROUTE = new SubmitStrategy("ROUTE", 5) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t() : invokeL.booleanValue;
                }
            };
            ROUTE_NA = new SubmitStrategy("ROUTE_NA", 6) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() : invokeL.booleanValue;
                }
            };
            ROUTE_WEB = new SubmitStrategy("ROUTE_WEB", 7) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.x() : invokeL.booleanValue;
                }
            };
            VIDEO_NA = new SubmitStrategy("VIDEO_NA", 8) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() : invokeL.booleanValue;
                }
            };
            SWAN_WEB = new SubmitStrategy("SWAN_WEB", 9) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() : invokeL.booleanValue;
                }
            };
            SubmitStrategy submitStrategy = new SubmitStrategy("PREFETCH_NA", 10) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy
                public boolean submitAllowed(HybridUbcFlow hybridUbcFlow) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.s() : invokeL.booleanValue;
                }
            };
            PREFETCH_NA = submitStrategy;
            $VALUES = new SubmitStrategy[]{HYBRID, HYBRID_WEB, RELAUNCH, RELAUNCH_WEB, NA_ONLY, ROUTE, ROUTE_NA, ROUTE_WEB, VIDEO_NA, SWAN_WEB, submitStrategy};
        }

        public SubmitStrategy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SubmitStrategy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SubmitStrategy) Enum.valueOf(SubmitStrategy.class, str) : (SubmitStrategy) invokeL.objValue;
        }

        public static SubmitStrategy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SubmitStrategy[]) $VALUES.clone() : (SubmitStrategy[]) invokeV.objValue;
        }

        public abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);

        public /* synthetic */ SubmitStrategy(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes11.dex */
    public class a implements Comparator<UbcFlowEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ubcFlowEvent, ubcFlowEvent2)) == null) ? Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f40326e;

        public b(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40326e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40326e.o();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Comparator<UbcFlowEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ubcFlowEvent, ubcFlowEvent2)) == null) ? Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1300243329, "Lcom/baidu/swan/apps/performance/HybridUbcFlow$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1300243329, "Lcom/baidu/swan/apps/performance/HybridUbcFlow$d;");
                    return;
                }
            }
            int[] iArr = new int[UbcFlowEvent.RecordType.values().length];
            a = iArr;
            try {
                iArr[UbcFlowEvent.RecordType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UbcFlowEvent.RecordType.UPDATE_RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UbcFlowEvent.RecordType.UPDATE_EARLIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UbcFlowEvent.RecordType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a.r0.a.z2.g1.c<HybridUbcFlow> f40327b;

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, c.a.r0.a.z2.g1.c cVar, a aVar) {
            this(hybridUbcFlow, str, cVar);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f40327b == null || TextUtils.isEmpty(this.a)) ? false : true : invokeV.booleanValue;
        }

        public e(HybridUbcFlow hybridUbcFlow, String str, c.a.r0.a.z2.g1.c<HybridUbcFlow> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow, str, cVar};
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
            this.f40327b = cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586827201, "Lcom/baidu/swan/apps/performance/HybridUbcFlow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-586827201, "Lcom/baidu/swan/apps/performance/HybridUbcFlow;");
                return;
            }
        }
        r = k.a;
        s = SubmitStrategy.HYBRID;
    }

    public HybridUbcFlow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40316b = new JSONObject();
        this.f40317c = new HashMap();
        this.f40318d = new ArrayList();
        this.f40319e = new HashMap();
        this.f40320f = new ArrayList();
        this.f40321g = false;
        this.f40322h = false;
        this.f40323i = false;
        this.f40324j = false;
        this.f40325k = false;
        this.l = false;
        this.m = s;
        this.n = new HashMap();
        this.o = new ConcurrentHashMap();
        this.q = "";
        this.p = str;
    }

    private void update(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ubcFlowEvent) == null) {
            this.f40318d.remove(ubcFlowEvent.a);
            this.f40318d.add(ubcFlowEvent.a);
            this.f40319e.put(ubcFlowEvent.a, ubcFlowEvent);
        }
    }

    public HybridUbcFlow A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = r;
            this.f40321g = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = r;
            this.f40323i = true;
            c("fmp_callback");
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow C(@Nullable c.a.r0.a.p.e.b bVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("naPaintFlowDone, slave page=");
                if (bVar == null) {
                    str = StringUtil.NULL_STRING;
                } else {
                    str = bVar.n() + ", routeId=" + bVar.l0();
                }
                sb.append(str);
                sb.toString();
            }
            if (bVar != null) {
                String l0 = bVar.l0();
                if (l0 != null) {
                    b("routeId", l0);
                }
                String c2 = bVar.c();
                if (c2 != null) {
                    b(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
                }
                String n = bVar.n();
                if (n != null) {
                    b("pageUrl", n);
                }
            }
            c("fmp_callback");
            this.f40323i = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.f40317c.put(str, str2);
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public HybridUbcFlow E(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, obj)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            try {
                this.f40316b.put(str, obj);
            } catch (JSONException e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public HybridUbcFlow F(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ubcFlowEvent)) == null) {
            if (r) {
                String str = "record " + ubcFlowEvent;
            }
            if (v(ubcFlowEvent)) {
                synchronized (this.f40318d) {
                    int i2 = d.a[ubcFlowEvent.c().ordinal()];
                    if (i2 == 1) {
                        update(ubcFlowEvent);
                    } else if (i2 == 2) {
                        Q(ubcFlowEvent);
                    } else if (i2 != 3) {
                        y(ubcFlowEvent);
                    } else {
                        O(ubcFlowEvent);
                    }
                }
                return this;
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow G(List<UbcFlowEvent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (r) {
                String str = "record events size = " + list.size();
            }
            synchronized (this.f40318d) {
                for (UbcFlowEvent ubcFlowEvent : list) {
                    F(ubcFlowEvent);
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow H(String str, c.a.r0.a.z2.g1.c<HybridUbcFlow> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, cVar)) == null) {
            e eVar = new e(this, str, cVar, null);
            if (eVar.a()) {
                synchronized (this.n) {
                    List<e> list = this.n.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.n.put(str, list);
                    }
                    list.add(eVar);
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public HybridUbcFlow I(SubmitStrategy submitStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, submitStrategy)) == null) {
            if (submitStrategy != null) {
                this.m = submitStrategy;
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Collections.sort(this.f40320f, new a(this));
        }
    }

    public final synchronized void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.l) {
                    return;
                }
                this.l = true;
                R();
                c("callback_on_submit");
                q.j(new b(this), "HybridUbcFlow");
                c.a.r0.a.u1.l.c.b();
            }
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SubmitStrategy submitStrategy = this.m;
            if (submitStrategy == null) {
                submitStrategy = s;
            }
            return submitStrategy.submitAllowed(this);
        }
        return invokeV.booleanValue;
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            boolean z = !TextUtils.isEmpty(str);
            if (!TextUtils.isEmpty(this.q)) {
                return !z || TextUtils.equals(this.q, str);
            }
            this.q = j(z, str);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void O(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.f40319e.get(ubcFlowEvent.a);
            if (!v(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
                update(ubcFlowEvent);
            }
        }
    }

    public void P() {
        UbcFlowEvent ubcFlowEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.f40318d) {
                this.f40320f.clear();
                for (String str : this.f40318d) {
                    if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f40319e.get(str)) != null && ubcFlowEvent.g() > 0) {
                        this.f40320f.add(ubcFlowEvent);
                    }
                }
                K();
            }
        }
    }

    public final void Q(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.f40319e.get(ubcFlowEvent.a);
            if (!v(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
                update(ubcFlowEvent);
            }
        }
    }

    public final void R() {
        c.a.r0.a.h0.t.h.a aVar;
        UbcFlowEvent a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && TextUtils.equals("670", this.a) && f.a() && (aVar = (c.a.r0.a.h0.t.h.a) k("fmp_data_record")) != null && aVar.c() && (a2 = aVar.a()) != null) {
            D("fmp_type", aVar.b());
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(a2.a);
            ubcFlowEvent.h(a2.g());
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            F(ubcFlowEvent);
        }
    }

    public HybridUbcFlow S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            boolean z = r;
            this.f40324j = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            boolean z = r;
            this.f40325k = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public synchronized <T> void b(@NonNull String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, t) == null) {
            synchronized (this) {
                this.o.put(str, t);
            }
        }
    }

    public final void c(String str) {
        List<e> list;
        c.a.r0.a.z2.g1.c<HybridUbcFlow> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.n.get(str)) == null || list.isEmpty()) {
            return;
        }
        for (e eVar : list) {
            if (eVar != null && (cVar = eVar.f40327b) != null) {
                cVar.onCallback(this);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && M()) {
            L();
        }
    }

    public final synchronized JSONObject e() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                try {
                    int size = this.f40318d.size();
                    String[] strArr = new String[size];
                    this.f40318d.toArray(strArr);
                    ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = strArr[i2];
                        if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f40319e.get(str)) != null && ubcFlowEvent.g() > 0) {
                            arrayList.add(ubcFlowEvent);
                        }
                    }
                    Collections.sort(arrayList, new c(this));
                    JSONArray jSONArray = new JSONArray();
                    for (UbcFlowEvent ubcFlowEvent2 : arrayList) {
                        jSONArray.put(ubcFlowEvent2.i());
                    }
                    if (jSONArray.length() != 0) {
                        jSONObject.put("events", jSONArray);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f40317c.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            String value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            jSONObject2.put(key, value);
                        }
                    }
                    if (jSONObject2.length() != 0) {
                        jSONObject.put("ext", jSONObject2);
                    }
                    if (this.f40316b != null && this.f40316b.length() > 0) {
                        jSONObject.put(SavedStateHandle.VALUES, this.f40316b);
                    }
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r3.g() < 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        if (r1.g() >= 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        return r3.g() - r1.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, strArr)) == null) {
            int length = strArr.length;
            UbcFlowEvent ubcFlowEvent = null;
            int i2 = 0;
            UbcFlowEvent ubcFlowEvent2 = null;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                UbcFlowEvent ubcFlowEvent3 = this.f40319e.get(strArr[i2]);
                if (ubcFlowEvent2 == null) {
                    if (ubcFlowEvent3 == null || ubcFlowEvent3.g() < 1) {
                        break;
                    }
                    ubcFlowEvent2 = ubcFlowEvent3;
                } else if (ubcFlowEvent3 != null && ubcFlowEvent3.g() > 0) {
                    ubcFlowEvent = ubcFlowEvent3;
                    break;
                }
                i2++;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public UbcFlowEvent g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? this.f40319e.get(str) : (UbcFlowEvent) invokeL.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? this.f40317c.get(str) : (String) invokeL.objValue;
    }

    public SubmitStrategy i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.m : (SubmitStrategy) invokeV.objValue;
    }

    public final String j(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048604, this, z, str)) == null) ? f.b() ? z ? str : this.q : z ? this.q : str : (String) invokeZL.objValue;
    }

    public synchronized <T> T k(@NonNull String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            synchronized (this) {
                t = (T) this.o.get(str);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f40316b : (JSONObject) invokeV.objValue;
    }

    public HybridUbcFlow n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            boolean z = r;
            this.f40322h = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (TextUtils.equals("670", this.a)) {
                c.a.r0.a.e0.d.k("HybridUbcFlow", "getMemoryInfo scene=launch_end_mem");
                this.f40317c.put("sys_total_mem", c.a.r0.a.e0.g.e.c().k());
                this.f40317c.put("launch_end_mem", c.a.r0.a.e0.g.e.c().h(c.a.r0.a.d2.d.J().r().V().j("main_pid", -1)));
                c.a.r0.a.e0.g.e.c().l();
            }
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "static", Float.valueOf(c.a.r0.a.c1.a.m().a()));
            this.f40317c.put("device_score", jSONObject.toString());
            String a2 = c.a.r0.a.c1.a.n0().a();
            if (!TextUtils.isEmpty(a2)) {
                this.f40317c.put("dyeId", a2);
            }
            this.f40317c.put("localABTestSids", c.a.r0.a.h1.b.b().a());
            this.f40317c.put("hostLaunchType", String.valueOf(c.a.r0.a.d2.d.J().r().V().i("host_launch_type")));
            P();
            c.a.r0.a.n2.q.c(this);
            c("component_reporter");
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            c.a.r0.a.n2.a c2 = n.c(this.a);
            for (UbcFlowEvent ubcFlowEvent : this.f40320f) {
                if (!ubcFlowEvent.b()) {
                    c.a.r0.a.n2.b.e(c2, ubcFlowEvent.a, ubcFlowEvent.j(), ubcFlowEvent.g());
                }
            }
            if (q()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.f40317c.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        jSONObject2.put(key, value);
                    }
                }
                m.a(jSONObject2);
                E("ext", jSONObject2);
            } catch (Exception e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            c.a.r0.a.n2.b.f(c2, this.f40316b.toString());
            c.a.r0.a.n2.b.c(c2);
            if (TextUtils.equals("670", this.a)) {
                c.a.r0.a.u1.l.a.d(this.f40320f, this.f40316b);
                c.a.r0.a.e0.d.k("HybridUbcFlow", "670: " + e().toString());
            }
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) ? this.f40319e.get(str) != null : invokeL.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this.f40318d) {
                isEmpty = this.f40318d.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f40322h : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f40321g : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f40323i : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? !TextUtils.isEmpty(this.q) : invokeV.booleanValue;
    }

    public final boolean v(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, ubcFlowEvent)) == null) ? (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.a)) ? false : true : invokeL.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f40324j : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f40325k : invokeV.booleanValue;
    }

    public final void y(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, ubcFlowEvent) == null) || v(this.f40319e.get(ubcFlowEvent.a))) {
            return;
        }
        update(ubcFlowEvent);
    }

    public HybridUbcFlow z(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, hybridUbcFlow)) == null) {
            if (hybridUbcFlow == null) {
                return this;
            }
            hybridUbcFlow.P();
            G(hybridUbcFlow.f40320f);
            this.f40317c.putAll(hybridUbcFlow.f40317c);
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }
}
