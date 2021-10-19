package com.baidu.ar.filter;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.arrender.i;
import com.baidu.ar.arrender.l;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.h.b;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public DefaultParams f38465d;
    public String mCasePath;
    public l qh;
    public FilterStateListener qi;
    public HashMap<FilterNode, Boolean> qj;
    public HashMap<FilterNode, Boolean> qk;
    public HashMap<FilterNode, Boolean> ql;

    /* renamed from: com.baidu.ar.filter.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] qm;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-983249100, "Lcom/baidu/ar/filter/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-983249100, "Lcom/baidu/ar/filter/a$1;");
                    return;
                }
            }
            int[] iArr = new int[FilterParam.MakeupFilter.values().length];
            qm = iArr;
            try {
                iArr[FilterParam.MakeupFilter.lips.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qm[FilterParam.MakeupFilter.lipsMask.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qm[FilterParam.MakeupFilter.cheeks.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                qm[FilterParam.MakeupFilter.highlight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(DefaultParams defaultParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qj = new HashMap<>();
        this.qk = new HashMap<>();
        this.ql = new HashMap<>();
        this.f38465d = defaultParams;
        HashMap<FilterNode, Boolean> hashMap = this.qj;
        if (hashMap != null) {
            hashMap.put(FilterNode.lutFilter, Boolean.FALSE);
            this.qj.put(FilterNode.skinFilter, Boolean.FALSE);
            this.qj.put(FilterNode.faceFilter, Boolean.FALSE);
            this.qj.put(FilterNode.makeupFilter, Boolean.FALSE);
        }
        HashMap<FilterNode, Boolean> hashMap2 = this.qk;
        if (hashMap2 != null) {
            hashMap2.put(FilterNode.lutFilter, Boolean.TRUE);
            this.qk.put(FilterNode.skinFilter, Boolean.valueOf(this.f38465d.isUseBeautyFilter()));
            this.qk.put(FilterNode.faceFilter, Boolean.valueOf(this.f38465d.isUseFaceFilter()));
            this.qk.put(FilterNode.makeupFilter, Boolean.valueOf(this.f38465d.isUseMakeupFilter()));
        }
    }

    private void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65537, this, i2) == null) || this.qh == null) {
            return;
        }
        i iVar = new i();
        iVar.r("ability_common_filter");
        iVar.setFilterName(FilterNode.faceFilter.getNodeName());
        iVar.N("clearAllKnead");
        iVar.r(i2);
        this.qh.a(iVar);
    }

    private String a(FilterNode filterNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, filterNode)) == null) ? filterNode == null ? "ability_common_filter" : filterNode.equals(FilterNode.faceFilter) ? "ability_face_filter" : filterNode.equals(FilterNode.makeupFilter) ? "ability_makeup_filter" : "ability_common_filter" : (String) invokeL.objValue;
    }

    private void a(FilterParam.MakeupFilter makeupFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, makeupFilter) == null) {
            int i2 = AnonymousClass1.qm[makeupFilter.ordinal()];
            String str = (i2 == 1 || i2 == 2) ? StatisticConstants.EVENT_MAKEUP_LIPSTICK_ENTER : i2 != 3 ? i2 != 4 ? null : StatisticConstants.EVENT_MAKEUP_HIGHLIGHT_ENTER : StatisticConstants.EVENT_MAKEUP_BLUSHER_ENTER;
            if (str != null) {
                StatisticApi.onEvent(str);
            }
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            this.qh = lVar;
        }
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, filterNode, z) == null) {
            synchronized (this) {
                b.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
                if (filterNode != null && this.qk != null && this.qk.containsKey(filterNode)) {
                    this.qk.put(filterNode, Boolean.valueOf(z));
                }
            }
        }
    }

    public void a(FilterParam filterParam, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, filterParam, obj) == null) || filterParam == null) {
            return;
        }
        String str = null;
        boolean z = false;
        if (filterParam.getFilterNode().equals(FilterNode.makeupFilter)) {
            if (obj instanceof Float) {
                str = "/opacity";
            } else if (obj instanceof String) {
                a((FilterParam.MakeupFilter) filterParam);
                str = "/texture_path";
            } else if (obj instanceof Integer) {
                z = true;
                str = "/is_enable";
            }
        }
        a(filterParam, obj, str, z);
    }

    public void a(FilterParam filterParam, Object obj, String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{filterParam, obj, str, Boolean.valueOf(z)}) == null) || filterParam == null) {
            return;
        }
        i iVar = new i();
        FilterNode filterNode = filterParam.getFilterNode();
        iVar.r(a(filterNode));
        iVar.setFilterName(filterNode.getNodeName());
        if (TextUtils.isEmpty(str)) {
            str2 = filterParam.getParamName();
        } else {
            str2 = filterParam.getParamName() + str;
        }
        iVar.N(str2);
        if (obj instanceof Float) {
            iVar.a(((Float) obj).floatValue());
        } else if (obj instanceof String) {
            iVar.O((String) obj);
        } else if (obj instanceof Integer) {
            iVar.r(((Integer) obj).intValue());
        } else if (!(obj instanceof float[])) {
            b.b("ARFilterManager", "updateFilter value type error!!!");
            return;
        } else {
            iVar.a((float[]) obj);
        }
        iVar.e(z);
        l lVar = this.qh;
        if (lVar != null) {
            lVar.a(iVar);
        }
    }

    public void a(FilterParam filterParam, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, filterParam, z) == null) || filterParam == null) {
            return;
        }
        FilterNode filterNode = filterParam.getFilterNode();
        i iVar = new i();
        iVar.e(true);
        iVar.r(a(filterNode));
        iVar.setFilterName(filterNode.getNodeName());
        iVar.N("is_enable");
        iVar.r((z ? 1 : 0).intValue());
        l lVar = this.qh;
        if (lVar != null) {
            lVar.a(iVar);
        }
    }

    public void am(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mCasePath = str;
        }
    }

    public void bv() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lVar = this.qh) == null) {
            return;
        }
        lVar.bv();
    }

    public void clearAllFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            K(1);
        }
    }

    public synchronized void eE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.qj != null) {
                    this.qj.put(FilterNode.lutFilter, Boolean.TRUE);
                    this.qj.put(FilterNode.skinFilter, Boolean.TRUE);
                    this.qj.put(FilterNode.faceFilter, Boolean.TRUE);
                    this.qj.put(FilterNode.makeupFilter, Boolean.TRUE);
                    b.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.qj.toString());
                }
                eF();
            }
        }
    }

    public void eF() {
        HashMap<FilterNode, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HashMap<FilterNode, Boolean> hashMap2 = this.ql;
            if (hashMap2 != null && (hashMap = this.qj) != null && this.qk != null) {
                FilterNode filterNode = FilterNode.lutFilter;
                boolean z = true;
                hashMap2.put(filterNode, Boolean.valueOf(hashMap.get(filterNode).booleanValue() && this.qk.get(FilterNode.lutFilter).booleanValue()));
                HashMap<FilterNode, Boolean> hashMap3 = this.ql;
                FilterNode filterNode2 = FilterNode.skinFilter;
                hashMap3.put(filterNode2, Boolean.valueOf(this.qj.get(filterNode2).booleanValue() && this.qk.get(FilterNode.skinFilter).booleanValue()));
                HashMap<FilterNode, Boolean> hashMap4 = this.ql;
                FilterNode filterNode3 = FilterNode.faceFilter;
                hashMap4.put(filterNode3, Boolean.valueOf(this.qj.get(filterNode3).booleanValue() && this.qk.get(FilterNode.faceFilter).booleanValue()));
                HashMap<FilterNode, Boolean> hashMap5 = this.ql;
                FilterNode filterNode4 = FilterNode.makeupFilter;
                hashMap5.put(filterNode4, Boolean.valueOf((this.qj.get(filterNode4).booleanValue() && this.qk.get(FilterNode.makeupFilter).booleanValue()) ? false : false));
                b.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.ql.toString() + " && mCasePath = " + this.mCasePath);
            }
            FilterStateListener filterStateListener = this.qi;
            if (filterStateListener != null) {
                filterStateListener.onFilterStateChanged(this.ql, this.mCasePath);
            }
        }
    }

    public synchronized void f(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            synchronized (this) {
                if (list == null) {
                    return;
                }
                if (this.qj != null) {
                    this.qj.put(FilterNode.lutFilter, Boolean.valueOf(list.contains(FilterNode.lutFilter.getNodeName())));
                    this.qj.put(FilterNode.skinFilter, Boolean.valueOf(list.contains(FilterNode.skinFilter.getNodeName())));
                    this.qj.put(FilterNode.faceFilter, Boolean.valueOf(list.contains(FilterNode.faceFilter.getNodeName())));
                    this.qj.put(FilterNode.makeupFilter, Boolean.valueOf(list.contains(FilterNode.makeupFilter.getNodeName())));
                    b.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.qj.toString());
                }
                eF();
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f38465d = null;
                this.qh = null;
                this.qi = null;
                if (this.qj != null) {
                    this.qj.clear();
                    this.qj = null;
                }
                if (this.qk != null) {
                    this.qk.clear();
                    this.qk = null;
                }
                if (this.ql != null) {
                    this.ql.clear();
                    this.ql = null;
                }
            }
        }
    }

    public void resetAllFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            K(0);
        }
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, filterStateListener) == null) {
            this.qi = filterStateListener;
        }
    }

    public String updateFilterCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            l lVar = this.qh;
            if (lVar != null) {
                return lVar.updateFilterCase(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
