package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import c.a.p0.a.j2.n;
import c.a.p0.a.k;
import c.a.p0.a.v2.q;
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
/* loaded from: classes6.dex */
public final class HybridUbcFlow {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final SubmitStrategy s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46173a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f46174b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f46175c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f46176d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, UbcFlowEvent> f46177e;

    /* renamed from: f  reason: collision with root package name */
    public final List<UbcFlowEvent> f46178f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46179g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46180h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46181i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f46182j;
    public boolean k;
    public volatile boolean l;
    public SubmitStrategy m;
    public final Map<String, List<e>> n;
    public final Map<String, Object> o;
    public final String p;
    public String q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static abstract class SubmitStrategy {
        public static final /* synthetic */ SubmitStrategy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SubmitStrategy HYBRID;
        public static final SubmitStrategy HYBRID_WEB;
        public static final SubmitStrategy NA_ONLY;
        public static final SubmitStrategy RELAUNCH;
        public static final SubmitStrategy RELAUNCH_WEB;
        public static final SubmitStrategy ROUTE;
        public static final SubmitStrategy ROUTE_NA;
        public static final SubmitStrategy ROUTE_WEB;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.t() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.t() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.r() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() : invokeL.booleanValue;
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() && hybridUbcFlow.p() && hybridUbcFlow.u() : invokeL.booleanValue;
                }
            };
            SubmitStrategy submitStrategy = new SubmitStrategy("VIDEO_NA", 8) { // from class: com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.9
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) ? hybridUbcFlow.q() : invokeL.booleanValue;
                }
            };
            VIDEO_NA = submitStrategy;
            $VALUES = new SubmitStrategy[]{HYBRID, HYBRID_WEB, RELAUNCH, RELAUNCH_WEB, NA_ONLY, ROUTE, ROUTE_NA, ROUTE_WEB, submitStrategy};
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46183e;

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
            this.f46183e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46183e.m();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46184a;
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
            f46184a = iArr;
            try {
                iArr[UbcFlowEvent.RecordType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46184a[UbcFlowEvent.RecordType.UPDATE_RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46184a[UbcFlowEvent.RecordType.UPDATE_EARLIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46184a[UbcFlowEvent.RecordType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f46185a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a.p0.a.v2.e1.b<HybridUbcFlow> f46186b;

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, c.a.p0.a.v2.e1.b bVar, a aVar) {
            this(hybridUbcFlow, str, bVar);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f46186b == null || TextUtils.isEmpty(this.f46185a)) ? false : true : invokeV.booleanValue;
        }

        public e(HybridUbcFlow hybridUbcFlow, String str, c.a.p0.a.v2.e1.b<HybridUbcFlow> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46185a = str;
            this.f46186b = bVar;
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
        r = k.f7085a;
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
        this.f46174b = new JSONObject();
        this.f46175c = new HashMap();
        this.f46176d = new ArrayList();
        this.f46177e = new HashMap();
        this.f46178f = new ArrayList();
        this.f46179g = false;
        this.f46180h = false;
        this.f46181i = false;
        this.f46182j = false;
        this.k = false;
        this.l = false;
        this.m = s;
        this.n = new HashMap();
        this.o = new ConcurrentHashMap();
        this.q = "";
        this.p = str;
    }

    public HybridUbcFlow A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.f46175c.put(str, str2);
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public HybridUbcFlow B(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            try {
                this.f46174b.put(str, obj);
            } catch (JSONException e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public HybridUbcFlow C(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ubcFlowEvent)) == null) {
            if (r) {
                String str = "record " + ubcFlowEvent;
            }
            if (s(ubcFlowEvent)) {
                synchronized (this.f46176d) {
                    int i2 = d.f46184a[ubcFlowEvent.c().ordinal()];
                    if (i2 == 1) {
                        L(ubcFlowEvent);
                    } else if (i2 == 2) {
                        O(ubcFlowEvent);
                    } else if (i2 != 3) {
                        v(ubcFlowEvent);
                    } else {
                        M(ubcFlowEvent);
                    }
                }
                return this;
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow D(List<UbcFlowEvent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (r) {
                String str = "record events size = " + list.size();
            }
            synchronized (this.f46176d) {
                for (UbcFlowEvent ubcFlowEvent : list) {
                    C(ubcFlowEvent);
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow E(String str, c.a.p0.a.v2.e1.b<HybridUbcFlow> bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bVar)) == null) {
            e eVar = new e(this, str, bVar, null);
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

    public HybridUbcFlow F(SubmitStrategy submitStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, submitStrategy)) == null) {
            if (submitStrategy != null) {
                this.m = submitStrategy;
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f46173a = str;
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Collections.sort(this.f46178f, new a(this));
        }
    }

    public final synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.l) {
                    return;
                }
                this.l = true;
                b("callback_on_submit");
                q.i(new b(this), "HybridUbcFlow");
                c.a.p0.a.r1.l.c.b();
            }
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SubmitStrategy submitStrategy = this.m;
            if (submitStrategy == null) {
                submitStrategy = s;
            }
            return submitStrategy.submitAllowed(this);
        }
        return invokeV.booleanValue;
    }

    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            boolean z = !TextUtils.isEmpty(str);
            if (!TextUtils.isEmpty(this.q)) {
                return !z || TextUtils.equals(this.q, str);
            }
            if (z) {
                str = this.q;
            }
            this.q = str;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ubcFlowEvent) == null) {
            this.f46176d.remove(ubcFlowEvent.f46188a);
            this.f46176d.add(ubcFlowEvent.f46188a);
            this.f46177e.put(ubcFlowEvent.f46188a, ubcFlowEvent);
        }
    }

    public final void M(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.f46177e.get(ubcFlowEvent.f46188a);
            if (!s(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
                L(ubcFlowEvent);
            }
        }
    }

    public void N() {
        UbcFlowEvent ubcFlowEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.f46176d) {
                this.f46178f.clear();
                for (String str : this.f46176d) {
                    if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f46177e.get(str)) != null && ubcFlowEvent.g() > 0) {
                        this.f46178f.add(ubcFlowEvent);
                    }
                }
                H();
            }
        }
    }

    public final void O(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.f46177e.get(ubcFlowEvent.f46188a);
            if (!s(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
                L(ubcFlowEvent);
            }
        }
    }

    public HybridUbcFlow P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            boolean z = r;
            this.f46182j = true;
            c();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            boolean z = r;
            this.k = true;
            c();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final void b(String str) {
        List<e> list;
        c.a.p0.a.v2.e1.b<HybridUbcFlow> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (list = this.n.get(str)) == null || list.isEmpty()) {
            return;
        }
        for (e eVar : list) {
            if (eVar != null && (bVar = eVar.f46186b) != null) {
                bVar.onCallback(this);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && J()) {
            I();
        }
    }

    public final synchronized JSONObject d() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        UbcFlowEvent ubcFlowEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                try {
                    int size = this.f46176d.size();
                    String[] strArr = new String[size];
                    this.f46176d.toArray(strArr);
                    ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = strArr[i2];
                        if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.f46177e.get(str)) != null && ubcFlowEvent.g() > 0) {
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
                    for (Map.Entry<String, String> entry : this.f46175c.entrySet()) {
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
                    if (this.f46174b != null && this.f46174b.length() > 0) {
                        jSONObject.put(SavedStateHandle.VALUES, this.f46174b);
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
    public long e(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, strArr)) == null) {
            int length = strArr.length;
            UbcFlowEvent ubcFlowEvent = null;
            int i2 = 0;
            UbcFlowEvent ubcFlowEvent2 = null;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                UbcFlowEvent ubcFlowEvent3 = this.f46177e.get(strArr[i2]);
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

    public UbcFlowEvent f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? this.f46177e.get(str) : (UbcFlowEvent) invokeL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? this.f46175c.get(str) : (String) invokeL.objValue;
    }

    public SubmitStrategy h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m : (SubmitStrategy) invokeV.objValue;
    }

    public <T> T i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? (T) this.o.get(str) : (T) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f46173a : (String) invokeV.objValue;
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f46174b : (JSONObject) invokeV.objValue;
    }

    public HybridUbcFlow l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            boolean z = r;
            this.f46180h = true;
            c();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (TextUtils.equals("670", this.f46173a)) {
                c.a.p0.a.e0.d.h("HybridUbcFlow", "getMemoryInfo scene=launch_end_mem");
                this.f46175c.put("sys_total_mem", c.a.p0.a.e0.g.d.b().d());
                this.f46175c.put("launch_end_mem", c.a.p0.a.e0.g.d.b().c(c.a.p0.a.a2.d.g().r().L().j("main_pid", -1)));
            }
            N();
            n.c(this);
            b("component_reporter");
            if (TextUtils.isEmpty(this.f46173a)) {
                return;
            }
            c.a.p0.a.j2.a c2 = c.a.p0.a.j2.k.c(this.f46173a);
            for (UbcFlowEvent ubcFlowEvent : this.f46178f) {
                if (!ubcFlowEvent.b()) {
                    c.a.p0.a.j2.b.e(c2, ubcFlowEvent.f46188a, ubcFlowEvent.j(), ubcFlowEvent.g());
                }
            }
            if (o()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : this.f46175c.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        jSONObject.put(key, value);
                    }
                }
                B("ext", jSONObject);
            } catch (Exception e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.a.j2.b.f(c2, this.f46174b.toString());
            c.a.p0.a.j2.b.c(c2);
            if (TextUtils.equals("670", this.f46173a)) {
                c.a.p0.a.r1.l.a.d(this.f46178f, this.f46174b);
                c.a.p0.a.e0.d.h("HybridUbcFlow", "670: " + d().toString());
            }
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? this.f46177e.get(str) != null : invokeL.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            synchronized (this.f46176d) {
                isEmpty = this.f46176d.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f46180h : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f46179g : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f46181i : invokeV.booleanValue;
    }

    public final boolean s(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, ubcFlowEvent)) == null) ? (ubcFlowEvent == null || TextUtils.isEmpty(ubcFlowEvent.f46188a)) ? false : true : invokeL.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f46182j : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final void v(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, ubcFlowEvent) == null) || s(this.f46177e.get(ubcFlowEvent.f46188a))) {
            return;
        }
        L(ubcFlowEvent);
    }

    public HybridUbcFlow w(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, hybridUbcFlow)) == null) {
            if (hybridUbcFlow == null) {
                return this;
            }
            hybridUbcFlow.N();
            D(hybridUbcFlow.f46178f);
            this.f46175c.putAll(hybridUbcFlow.f46175c);
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            boolean z = r;
            this.f46179g = true;
            c();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            boolean z = r;
            this.f46181i = true;
            b("fmp_callback");
            c();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow z(@Nullable c.a.p0.a.p.e.b bVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bVar)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("naPaintFlowDone, slave page=");
                if (bVar == null) {
                    str = StringUtil.NULL_STRING;
                } else {
                    str = bVar.n() + ", routeId=" + bVar.i0();
                }
                sb.append(str);
                sb.toString();
            }
            if (bVar != null) {
                String i0 = bVar.i0();
                if (i0 != null) {
                    this.o.put("routeId", i0);
                }
                String c2 = bVar.c();
                if (c2 != null) {
                    this.o.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
                }
                String n = bVar.n();
                if (n != null) {
                    this.o.put("pageUrl", n);
                }
            }
            b("fmp_callback");
            this.f46181i = true;
            c();
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }
}
