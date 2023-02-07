package com.baidu.searchbox.retrieve.core;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchJob_FetchActions_ListProvider;
import com.baidu.tieba.ak1;
import com.baidu.tieba.ck1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FetchActions {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public ck1<IFetchJob> mFetchCommandList;

    /* renamed from: com.baidu.searchbox.retrieve.core.FetchActions$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void initmFetchCommandList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ak1 b = ak1.b();
            this.mFetchCommandList = b;
            b.a(new IFetchJob_FetchActions_ListProvider());
        }
    }

    /* loaded from: classes3.dex */
    public static class Inner {
        public static /* synthetic */ Interceptable $ic;
        public static final FetchActions sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(849162191, "Lcom/baidu/searchbox/retrieve/core/FetchActions$Inner;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(849162191, "Lcom/baidu/searchbox/retrieve/core/FetchActions$Inner;");
                    return;
                }
            }
            sInstance = new FetchActions(null);
        }

        public Inner() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1606003039, "Lcom/baidu/searchbox/retrieve/core/FetchActions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1606003039, "Lcom/baidu/searchbox/retrieve/core/FetchActions;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchActions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static FetchActions getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Inner.sInstance;
        }
        return (FetchActions) invokeV.objValue;
    }

    public /* synthetic */ FetchActions(AnonymousClass1 anonymousClass1) {
        this();
        initmFetchCommandList();
    }

    public List<IFetchJob> getFetchCommandList() {
        InterceptResult invokeV;
        List<IFetchJob> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ck1<IFetchJob> ck1Var = this.mFetchCommandList;
            if (ck1Var == null || (list = ck1Var.getList()) == null || list.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            boolean z = false;
            try {
                for (IFetchJob iFetchJob : list) {
                    String fetchJobType = iFetchJob.getFetchJobType();
                    if (TextUtils.isEmpty(fetchJobType)) {
                        arrayList.add(iFetchJob);
                        z = true;
                        if (DEBUG) {
                            throw new RuntimeException("only debug mode has this crash ===>>>> local fetch type is null ");
                        }
                    } else if (arrayList2.contains(fetchJobType)) {
                        arrayList3.add(iFetchJob);
                    } else {
                        arrayList2.add(fetchJobType);
                    }
                }
                if (z) {
                    list.removeAll(arrayList);
                }
                return list;
            } catch (Exception e) {
                if (!DEBUG) {
                    return null;
                }
                throw e;
            }
        }
        return (List) invokeV.objValue;
    }
}
