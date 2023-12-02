package com.baidu.card;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.CardPeiWanView;
import com.baidu.tieba.in6;
import com.baidu.tieba.os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tbclient.Voice;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/card/CardPeiWanSegment;", "Lcom/baidu/card/BaseCardSegment;", "Lcom/baidu/tieba/card/data/CardPeiWanData;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "fromScene", "", "getFromScene", "()I", "setFromScene", "(I)V", "peiWanCard", "Lcom/baidu/tbadk/core/view/CardPeiWanView;", "clickStatistic", "", "cardPeiWanData", "isVoice", "", "getView", "Landroid/view/View;", "onBindDataToView", "data", "onChangeSkinType", "context", WriteMulitImageActivityConfig.SKIN_TYPE, "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CardPeiWanSegment extends os<in6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public final CardPeiWanView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPeiWanSegment(TbPageContext<?> pageContext) {
        super(pageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Activity pageActivity = pageContext.getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
        this.g = new CardPeiWanView(pageActivity, null, 0, 6, null);
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: t */
    public void onBindDataToView(final in6 in6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, in6Var) == null) && in6Var != null) {
            this.g.setData(in6Var, new Function0<Unit>(this, in6Var) { // from class: com.baidu.card.CardPeiWanSegment$onBindDataToView$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ in6 $data;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardPeiWanSegment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, in6Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$data = in6Var;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.s(this.$data, false);
                    }
                }
            }, new Function0<Unit>(this, in6Var) { // from class: com.baidu.card.CardPeiWanSegment$onBindDataToView$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ in6 $data;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CardPeiWanSegment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, in6Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$data = in6Var;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.s(this.$data, true);
                    }
                }
            });
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.g.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void s(in6 in6Var, boolean z) {
        String str;
        Long l;
        Long l2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, in6Var, z) == null) && in6Var != null) {
            boolean z2 = true;
            String str2 = null;
            if (z) {
                int i = this.f;
                if (i == 1) {
                    str = CommonStatisticKey.KEY_HOME_PEI_WAN_VOICE_CLICK;
                } else {
                    if (i == 2) {
                        str = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_VOICE_CLICK;
                    }
                    str = null;
                }
            } else {
                int i2 = this.f;
                if (i2 == 1) {
                    str = CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK;
                } else {
                    if (i2 == 2) {
                        str = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_CLICK;
                    }
                    str = null;
                }
            }
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z2 = false;
            }
            if (!z2) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("obj_locate", in6Var.position);
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, in6Var.e());
                if (z) {
                    Voice k = in6Var.k();
                    if (k != null) {
                        l2 = k.uid;
                    } else {
                        l2 = null;
                    }
                    statisticItem.addParam("obj_id", String.valueOf(l2));
                }
                statisticItem.addParam("obj_param1", in6Var.d() ? 1 : 0);
                if (this.f == 2) {
                    ThreadData threadData = in6Var.getThreadData();
                    if (threadData != null) {
                        l = Long.valueOf(threadData.getFid());
                    } else {
                        l = null;
                    }
                    statisticItem.addParam("fid", String.valueOf(l));
                    ThreadData threadData2 = in6Var.getThreadData();
                    if (threadData2 != null) {
                        str2 = threadData2.getForum_name();
                    }
                    statisticItem.addParam("fname", str2);
                }
                statisticItem.eventStat();
            }
        }
    }
}
