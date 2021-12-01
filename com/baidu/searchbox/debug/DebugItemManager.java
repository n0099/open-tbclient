package com.baidu.searchbox.debug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fR+\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/debug/DebugItemManager;", "", "type", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "provider", "", "addDebugInfo", "(Ljava/lang/String;Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;)V", "collectDebugProvider", "()V", "Ljava/util/ArrayList;", "getProviderList", "(Ljava/lang/String;)Ljava/util/ArrayList;", "Ljava/util/HashMap;", "itemListMap", "Ljava/util/HashMap;", "getItemListMap", "()Ljava/util/HashMap;", "<init>", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class DebugItemManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ArrayList<DebugDataGroupProvider>> itemListMap;

    public DebugItemManager() {
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
        this.itemListMap = new HashMap<>();
        collectDebugProvider();
    }

    public final void addDebugInfo(String str, DebugDataGroupProvider debugDataGroupProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, debugDataGroupProvider) == null) {
            ArrayList<DebugDataGroupProvider> arrayList = this.itemListMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.itemListMap.put(str, arrayList);
            }
            arrayList.add(debugDataGroupProvider);
        }
    }

    public final void collectDebugProvider() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final HashMap<String, ArrayList<DebugDataGroupProvider>> getItemListMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.itemListMap : (HashMap) invokeV.objValue;
    }

    public final ArrayList<DebugDataGroupProvider> getProviderList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList<DebugDataGroupProvider> arrayList = this.itemListMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            Intrinsics.checkExpressionValueIsNotNull(arrayList, "itemListMap.get(type) ?: ArrayList()");
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
