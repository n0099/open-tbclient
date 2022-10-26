package com.baidu.searchbox.live.list.controller;

import android.content.Context;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.list.controller.RecyleController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/list/controller/RecyleController$ListAdapter;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyleController$adapter$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ RecyleController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyleController$adapter$2(RecyleController recyleController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyleController};
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
        this.this$0 = recyleController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final RecyleController.ListAdapter invoke() {
        InterceptResult invokeV;
        MiniUniqueId miniUniqueId;
        IMixActivityInterface iMixActivityInterface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = this.this$0.getContext();
            List itemData = this.this$0.getListController().getItemData();
            miniUniqueId = this.this$0.mixUniqueId;
            List shellList = this.this$0.getListController().getShellList();
            iMixActivityInterface = this.this$0.mixActivity;
            return new RecyleController.ListAdapter(context, itemData, miniUniqueId, shellList, iMixActivityInterface);
        }
        return (RecyleController.ListAdapter) invokeV.objValue;
    }
}
