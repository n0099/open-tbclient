package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.bb3;
import com.baidu.tieba.cy2;
import com.baidu.tieba.e43;
import com.baidu.tieba.ey2;
import com.baidu.tieba.f12;
import com.baidu.tieba.f22;
import com.baidu.tieba.fh3;
import com.baidu.tieba.hy2;
import com.baidu.tieba.jq2;
import com.baidu.tieba.la3;
import com.baidu.tieba.lq1;
import com.baidu.tieba.ma3;
import com.baidu.tieba.mn2;
import com.baidu.tieba.pk1;
import com.baidu.tieba.sa2;
import com.baidu.tieba.xa3;
import com.baidu.tieba.ya3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.zg3;
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
/* loaded from: classes3.dex */
public final class HybridUbcFlow {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final SubmitStrategy s;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final JSONObject b;
    public final Map<String, String> c;
    public final List<String> d;
    public final Map<String, UbcFlowEvent> e;
    public final List<UbcFlowEvent> f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public volatile boolean l;
    public SubmitStrategy m;
    public final Map<String, List<e>> n;
    public final Map<String, Object> o;
    public final String p;
    public String q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public abstract boolean submitAllowed(HybridUbcFlow hybridUbcFlow);

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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.w()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        return hybridUbcFlow.s();
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.t()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        return hybridUbcFlow.s();
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        if (hybridUbcFlow.s() && hybridUbcFlow.r() && hybridUbcFlow.x()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        return hybridUbcFlow.s();
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        return hybridUbcFlow.s();
                    }
                    return invokeL.booleanValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, hybridUbcFlow)) == null) {
                        return hybridUbcFlow.s();
                    }
                    return invokeL.booleanValue;
                }
            };
            PREFETCH_NA = submitStrategy;
            $VALUES = new SubmitStrategy[]{HYBRID, HYBRID_WEB, RELAUNCH, RELAUNCH_WEB, NA_ONLY, ROUTE, ROUTE_NA, ROUTE_WEB, VIDEO_NA, SWAN_WEB, submitStrategy};
        }

        public SubmitStrategy(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public /* synthetic */ SubmitStrategy(String str, int i, a aVar) {
            this(str, i);
        }

        public static SubmitStrategy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SubmitStrategy) Enum.valueOf(SubmitStrategy.class, str);
            }
            return (SubmitStrategy) invokeL.objValue;
        }

        public static SubmitStrategy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SubmitStrategy[]) $VALUES.clone();
            }
            return (SubmitStrategy[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ubcFlowEvent, ubcFlowEvent2)) == null) {
                return Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;

        public b(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o();
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ubcFlowEvent, ubcFlowEvent2)) == null) {
                return Long.compare(ubcFlowEvent.g(), ubcFlowEvent2.g());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final yi3<HybridUbcFlow> b;

        public e(HybridUbcFlow hybridUbcFlow, String str, yi3<HybridUbcFlow> yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hybridUbcFlow, str, yi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = yi3Var;
        }

        public /* synthetic */ e(HybridUbcFlow hybridUbcFlow, String str, yi3 yi3Var, a aVar) {
            this(hybridUbcFlow, str, yi3Var);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b != null && !TextUtils.isEmpty(this.a)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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
        r = pk1.a;
        s = SubmitStrategy.HYBRID;
    }

    public HybridUbcFlow A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "naFlowDone");
            }
            this.g = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "naPaintFlowDone");
            }
            this.i = true;
            c("fmp_callback");
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Collections.sort(this.f, new a(this));
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

    public HybridUbcFlow S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "webwidgetPaintDone");
            }
            this.j = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public HybridUbcFlow T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "webViewWidgetDone");
            }
            this.k = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && M()) {
            L();
        }
    }

    public SubmitStrategy i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.m;
        }
        return (SubmitStrategy) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.b;
        }
        return (JSONObject) invokeV.objValue;
    }

    public HybridUbcFlow n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "h5FlowDone");
            }
            this.h = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this.d) {
                isEmpty = this.d.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return !TextUtils.isEmpty(this.q);
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public HybridUbcFlow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new JSONObject();
        this.c = new HashMap();
        this.d = new ArrayList();
        this.e = new HashMap();
        this.f = new ArrayList();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = s;
        this.n = new HashMap();
        this.o = new ConcurrentHashMap();
        this.q = "";
        this.p = str;
    }

    public HybridUbcFlow C(@Nullable lq1 lq1Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq1Var)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("naPaintFlowDone, slave page=");
                if (lq1Var == null) {
                    str = StringUtil.NULL_STRING;
                } else {
                    str = lq1Var.m() + ", routeId=" + lq1Var.j0();
                }
                sb.append(str);
                Log.i("HybridUbcFlow", sb.toString());
            }
            if (lq1Var != null) {
                String j0 = lq1Var.j0();
                if (j0 != null) {
                    b("routeId", j0);
                }
                String a2 = lq1Var.a();
                if (a2 != null) {
                    b(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
                }
                String m = lq1Var.m();
                if (m != null) {
                    b(PrefetchEvent.EVENT_KEY_PAGE_URL, m);
                }
            }
            c("fmp_callback");
            this.i = true;
            d();
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
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
            int i = 0;
            UbcFlowEvent ubcFlowEvent2 = null;
            while (true) {
                if (i >= length) {
                    break;
                }
                UbcFlowEvent ubcFlowEvent3 = this.e.get(strArr[i]);
                if (ubcFlowEvent2 == null) {
                    if (ubcFlowEvent3 == null || ubcFlowEvent3.g() < 1) {
                        break;
                    }
                    ubcFlowEvent2 = ubcFlowEvent3;
                } else if (ubcFlowEvent3 != null && ubcFlowEvent3.g() > 0) {
                    ubcFlowEvent = ubcFlowEvent3;
                    break;
                }
                i++;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    private void update(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ubcFlowEvent) == null) {
            this.d.remove(ubcFlowEvent.a);
            this.d.add(ubcFlowEvent.a);
            this.e.put(ubcFlowEvent.a, ubcFlowEvent);
        }
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

    public final void O(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.e.get(ubcFlowEvent.a);
            if (!v(ubcFlowEvent2) || ubcFlowEvent.g() < ubcFlowEvent2.g()) {
                update(ubcFlowEvent);
            }
        }
    }

    public final void Q(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ubcFlowEvent) == null) {
            UbcFlowEvent ubcFlowEvent2 = this.e.get(ubcFlowEvent.a);
            if (!v(ubcFlowEvent2) || ubcFlowEvent.g() > ubcFlowEvent2.g()) {
                update(ubcFlowEvent);
            }
        }
    }

    public UbcFlowEvent g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return this.e.get(str);
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            return this.c.get(str);
        }
        return (String) invokeL.objValue;
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

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.e.get(str) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, ubcFlowEvent)) == null) {
            if (ubcFlowEvent != null && !TextUtils.isEmpty(ubcFlowEvent.a)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y(UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, ubcFlowEvent) == null) && !v(this.e.get(ubcFlowEvent.a))) {
            update(ubcFlowEvent);
        }
    }

    public HybridUbcFlow z(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, hybridUbcFlow)) == null) {
            if (hybridUbcFlow == null) {
                return this;
            }
            hybridUbcFlow.P();
            G(hybridUbcFlow.f);
            this.c.putAll(hybridUbcFlow.c);
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            this.c.put(str, str2);
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
                this.b.put(str, obj);
            } catch (JSONException e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public synchronized <T> void b(@NonNull String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, t) == null) {
            synchronized (this) {
                this.o.put(str, t);
            }
        }
    }

    public final String j(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048604, this, z, str)) == null) {
            if (hy2.b()) {
                if (!z) {
                    return this.q;
                }
                return str;
            } else if (z) {
                return this.q;
            } else {
                return str;
            }
        }
        return (String) invokeZL.objValue;
    }

    public HybridUbcFlow F(UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ubcFlowEvent)) == null) {
            if (r) {
                Log.i("HybridUbcFlow", "record " + ubcFlowEvent);
            }
            if (!v(ubcFlowEvent)) {
                return this;
            }
            synchronized (this.d) {
                int i = d.a[ubcFlowEvent.c().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            y(ubcFlowEvent);
                        } else {
                            O(ubcFlowEvent);
                        }
                    } else {
                        Q(ubcFlowEvent);
                    }
                } else {
                    update(ubcFlowEvent);
                }
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
                Log.i("HybridUbcFlow", "record events size = " + list.size());
            }
            synchronized (this.d) {
                for (UbcFlowEvent ubcFlowEvent : list) {
                    F(ubcFlowEvent);
                }
            }
            return this;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public HybridUbcFlow H(String str, yi3<HybridUbcFlow> yi3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, yi3Var)) == null) {
            e eVar = new e(this, str, yi3Var, null);
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
                zg3.j(new b(this), "HybridUbcFlow");
                ey2.b();
            }
        }
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            boolean z = !TextUtils.isEmpty(str);
            if (TextUtils.isEmpty(this.q)) {
                this.q = j(z, str);
                return true;
            } else if (!z || TextUtils.equals(this.q, str)) {
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c(String str) {
        List<e> list;
        yi3<HybridUbcFlow> yi3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && (list = this.n.get(str)) != null && !list.isEmpty()) {
            for (e eVar : list) {
                if (eVar != null && (yi3Var = eVar.b) != null) {
                    yi3Var.a(this);
                }
            }
        }
    }

    public void P() {
        UbcFlowEvent ubcFlowEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.d) {
                this.f.clear();
                for (String str : this.d) {
                    if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.e.get(str)) != null && ubcFlowEvent.g() > 0) {
                        this.f.add(ubcFlowEvent);
                    }
                }
                K();
            }
        }
    }

    public final void R() {
        sa2 sa2Var;
        UbcFlowEvent a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && TextUtils.equals("670", this.a) && hy2.a() && (sa2Var = (sa2) k("fmp_data_record")) != null && sa2Var.c() && (a2 = sa2Var.a()) != null) {
            D("fmp_type", sa2Var.b());
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(a2.a);
            ubcFlowEvent.h(a2.g());
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            F(ubcFlowEvent);
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
                    int size = this.d.size();
                    String[] strArr = new String[size];
                    this.d.toArray(strArr);
                    ArrayList<UbcFlowEvent> arrayList = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        String str = strArr[i];
                        if (!TextUtils.isEmpty(str) && (ubcFlowEvent = this.e.get(str)) != null && ubcFlowEvent.g() > 0) {
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
                    for (Map.Entry<String, String> entry : this.c.entrySet()) {
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
                    if (this.b != null && this.b.length() > 0) {
                        jSONObject.put(SavedStateHandle.VALUES, this.b);
                    }
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (TextUtils.equals("670", this.a)) {
                f12.k("HybridUbcFlow", "getMemoryInfo scene=launch_end_mem");
                this.c.put("sys_total_mem", f22.c().k());
                this.c.put("launch_end_mem", f22.c().h(e43.K().q().W().j("main_pid", -1)));
                f22.c().l();
            }
            JSONObject jSONObject = new JSONObject();
            fh3.f(jSONObject, "static", Float.valueOf(mn2.m().a()));
            this.c.put("device_score", jSONObject.toString());
            String a2 = mn2.n0().a();
            if (!TextUtils.isEmpty(a2)) {
                this.c.put("dyeId", a2);
            }
            this.c.put("localABTestSids", jq2.b().a());
            this.c.put("hostLaunchType", String.valueOf(e43.K().q().W().i("host_launch_type")));
            P();
            bb3.c(this);
            c("component_reporter");
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            la3 c2 = ya3.c(this.a);
            for (UbcFlowEvent ubcFlowEvent : this.f) {
                if (!ubcFlowEvent.b()) {
                    ma3.e(c2, ubcFlowEvent.a, ubcFlowEvent.j(), ubcFlowEvent.g());
                }
            }
            if (q()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.c.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        jSONObject2.put(key, value);
                    }
                }
                xa3.a(jSONObject2);
                E("ext", jSONObject2);
            } catch (Exception e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            ma3.f(c2, this.b.toString());
            ma3.c(c2);
            if (TextUtils.equals("670", this.a)) {
                cy2.d(this.f, this.b);
                f12.k("HybridUbcFlow", "670: " + e().toString());
            }
        }
    }
}
