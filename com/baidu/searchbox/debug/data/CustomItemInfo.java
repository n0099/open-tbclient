package com.baidu.searchbox.debug.data;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/debug/data/CustomItemInfo;", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "viewFetcher", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "getViewFetcher", "()Lcom/baidu/searchbox/debug/data/ViewFetcher;", "setViewFetcher", "(Lcom/baidu/searchbox/debug/data/ViewFetcher;)V", "<init>", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class CustomItemInfo extends DebugItemInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewFetcher viewFetcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomItemInfo(ViewFetcher viewFetcher) {
        super(null, ViewType.CUSTOMIZE_VIEW);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewFetcher};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (ViewType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.viewFetcher = viewFetcher;
    }

    public final ViewFetcher getViewFetcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.viewFetcher;
        }
        return (ViewFetcher) invokeV.objValue;
    }

    public final void setViewFetcher(ViewFetcher viewFetcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewFetcher) == null) {
            this.viewFetcher = viewFetcher;
        }
    }
}
