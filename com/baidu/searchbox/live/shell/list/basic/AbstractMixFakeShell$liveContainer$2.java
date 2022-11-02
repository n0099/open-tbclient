package com.baidu.searchbox.live.shell.list.basic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/widget/LiveContainer;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AbstractMixFakeShell$liveContainer$2 extends Lambda implements Function0<LiveContainer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AbstractMixFakeShell this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMixFakeShell$liveContainer$2(AbstractMixFakeShell abstractMixFakeShell) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractMixFakeShell};
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
        this.this$0 = abstractMixFakeShell;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LiveContainer invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LiveContainer liveContainer = new LiveContainer(this.this$0.getContext(), null, 0, 6, null);
            liveContainer.setAttachListener(new LiveContainer.ViewAttachListener(this) { // from class: com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell$liveContainer$2$$special$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractMixFakeShell$liveContainer$2 this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
                public void onDataChanged(LiveContainer.LiveItemModel liveItemModel) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveItemModel) == null) {
                        this.this$0.this$0.onLiveBindData(liveItemModel);
                    }
                }

                @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
                public void onAttach() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.this$0.onLiveAttach();
                    }
                }

                @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
                public void onDetach() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.this$0.this$0.onLiveDetach();
                    }
                }

                @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
                public void onDeselected(int i, LiveContainer.LiveItemModel liveItemModel) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, liveItemModel) == null) {
                        this.this$0.this$0.onLiveDeselected();
                    }
                }

                @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
                public void onSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), liveItemModel, Boolean.valueOf(z)}) == null) {
                        this.this$0.this$0.onPageSelected(i, liveItemModel, z);
                    }
                }
            });
            return liveContainer;
        }
        return (LiveContainer) invokeV.objValue;
    }
}
