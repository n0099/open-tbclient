package com.baidu.searchbox.live.list.controller;

import android.content.Context;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/list/controller/IListManager;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListController$listManager$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ListController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListController$listManager$2(ListController listController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = listController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final IListManager invoke() {
        InterceptResult invokeV;
        MiniUniqueId miniUniqueId;
        IMixActivityInterface iMixActivityInterface;
        MiniUniqueId miniUniqueId2;
        IMixActivityInterface iMixActivityInterface2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (((AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE())).getSwitch("live_android_mixview_pager", false)) {
                ListController listController = this.this$0;
                Context context = listController.getContext();
                miniUniqueId2 = this.this$0.mixUniqueId;
                iMixActivityInterface2 = this.this$0.mixActivity;
                return new PagerController(listController, context, miniUniqueId2, iMixActivityInterface2);
            }
            ListController listController2 = this.this$0;
            Context context2 = listController2.getContext();
            miniUniqueId = this.this$0.mixUniqueId;
            iMixActivityInterface = this.this$0.mixActivity;
            return new RecyleController(listController2, context2, miniUniqueId, iMixActivityInterface);
        }
        return (IListManager) invokeV.objValue;
    }
}
