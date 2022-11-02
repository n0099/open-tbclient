package com.baidu.searchbox.live.list.controller;

import android.text.TextUtils;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.mix.MixInvokeAbility;
import com.baidu.searchbox.live.model.MixModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1", "invoke", "()Lcom/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListController$mMixEventDispatcher$2 extends Lambda implements Function0<AnonymousClass1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ListController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListController$mMixEventDispatcher$2(ListController listController) {
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
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2$1] */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new MixInvokeAbility(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ListController$mMixEventDispatcher$2 this$0;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
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

                /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
                    if (android.text.TextUtils.isEmpty(r5) != false) goto L34;
                 */
                @Override // com.baidu.searchbox.live.interfaces.mix.MixInvokeAbility
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onCommonEvent(String str, Object obj) {
                    IntentData intentData;
                    IntentData.SchemeModel schemeModel;
                    String str2;
                    IntentData intentData2;
                    MixModel mixModel;
                    String str3;
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str, obj) == null) && str.hashCode() == -179496859 && str.equals(MixConstants.KEY_NETWORK_CHANGED)) {
                        String str5 = null;
                        if (!(obj instanceof Boolean)) {
                            obj = null;
                        }
                        Boolean bool = (Boolean) obj;
                        if (bool != null && bool.booleanValue()) {
                            boolean z = true;
                            if (this.this$0.this$0.getItemData().size() > 1) {
                                return;
                            }
                            intentData = this.this$0.this$0.mIntentData;
                            if (intentData != null) {
                                schemeModel = intentData.getModel();
                            } else {
                                schemeModel = null;
                            }
                            if (schemeModel != null) {
                                str2 = schemeModel.getRoomType();
                            } else {
                                str2 = null;
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                if (schemeModel != null) {
                                    str3 = schemeModel.getRoomType();
                                } else {
                                    str3 = null;
                                }
                                if (Intrinsics.areEqual("0", str3)) {
                                    if (schemeModel != null) {
                                        str4 = schemeModel.getTemplateId();
                                    } else {
                                        str4 = null;
                                    }
                                }
                                z = false;
                            }
                            if (this.this$0.this$0.getItemData().size() == 0) {
                                intentData2 = this.this$0.this$0.mIntentData;
                                if (intentData2 != null) {
                                    str5 = intentData2.getId();
                                }
                                if (!TextUtils.isEmpty(str5) && z) {
                                    mixModel = this.this$0.this$0.mNetModel;
                                    if (mixModel != null) {
                                        mixModel.reqLiveType();
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.this$0.this$0.queryLiveList();
                        }
                    }
                }
            };
        }
        return (AnonymousClass1) invokeV.objValue;
    }
}
