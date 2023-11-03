package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.spswitch.utils.EmotionVipHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BDEmotionDynamicLayout extends BDEmotionBaseLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public boolean showDelBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public boolean showPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDEmotionDynamicLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEmotionHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            EmotionTypeModel emotionTypeModel = this.mTypeModel;
            if (emotionTypeModel != null) {
                return emotionTypeModel.getHeight();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEmotionWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            EmotionTypeModel emotionTypeModel = this.mTypeModel;
            if (emotionTypeModel != null) {
                return emotionTypeModel.getWidth();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public BDEmotionDynamicAdapter.OnEmotionClickListener getEmotionClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new BDEmotionDynamicAdapter.OnEmotionClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionDynamicLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionDynamicLayout this$0;

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

                @Override // com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter.OnEmotionClickListener
                public void onClick(View view2, int i, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeLIL(1048576, this, view2, i, obj) != null) || !(obj instanceof EmotionItemModel)) {
                        return;
                    }
                    EmotionItemModel emotionItemModel = (EmotionItemModel) obj;
                    BDEmotionPanelManager.OnDynamicEmotionClickListener dynamicEmotionClickListener = GlobalOnItemClickListenerManager.getInstance().getDynamicEmotionClickListener();
                    BDEmotionDynamicLayout bDEmotionDynamicLayout = this.this$0;
                    if (bDEmotionDynamicLayout.mTypeModel != null && dynamicEmotionClickListener != null) {
                        EmotionVipHelper.doCheckVip(bDEmotionDynamicLayout.getContext(), this.this$0.mTypeModel.getAuth(), new EmotionVipHelper.OnVipCheckListener(this, emotionItemModel, dynamicEmotionClickListener) { // from class: com.baidu.spswitch.emotion.view.BDEmotionDynamicLayout.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;
                            public final /* synthetic */ EmotionItemModel val$itemModel;
                            public final /* synthetic */ BDEmotionPanelManager.OnDynamicEmotionClickListener val$listener;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, emotionItemModel, dynamicEmotionClickListener};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$itemModel = emotionItemModel;
                                this.val$listener = dynamicEmotionClickListener;
                            }

                            @Override // com.baidu.spswitch.utils.EmotionVipHelper.OnVipCheckListener
                            public void onResult(boolean z) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) {
                                    this.val$itemModel.setWidth(this.this$1.this$0.getEmotionWidth());
                                    this.val$itemModel.setHeight(this.this$1.this$0.getEmotionHeight());
                                    if (z) {
                                        this.val$listener.onEmotionClick(this.val$itemModel);
                                    } else {
                                        EmotionVipHelper.doBuyVip(this.this$1.this$0.getContext(), this.this$1.this$0.mTypeModel.getAuth(), this.this$1.this$0.mTypeModel.getSchema(), new EmotionVipHelper.OnBuyVipListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionDynamicLayout.1.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ C01891 this$2;

                                            {
                                                Interceptable interceptable4 = $ic;
                                                if (interceptable4 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable4.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable4.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$2 = this;
                                            }

                                            @Override // com.baidu.spswitch.utils.EmotionVipHelper.OnBuyVipListener
                                            public void onResult(boolean z2) {
                                                Interceptable interceptable4 = $ic;
                                                if ((interceptable4 == null || interceptable4.invokeZ(1048576, this, z2) == null) && z2) {
                                                    C01891 c01891 = this.this$2;
                                                    c01891.val$listener.onEmotionClick(c01891.val$itemModel);
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                        BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig = this.this$0.mPanelConfig;
                        if (emotionPanelConfig != null) {
                            String str = emotionPanelConfig.from;
                            String str2 = emotionPanelConfig.page;
                            String str3 = emotionPanelConfig.source;
                            EmotionUbcHelper.doEmotionDynamicUBC(str, EmotionUbcHelper.TYPE_MEME_CLK, str2, str3, "", this.this$0.mTypeModel.getId() + "-" + emotionItemModel.getId());
                        }
                    }
                }
            };
        }
        return (BDEmotionDynamicAdapter.OnEmotionClickListener) invokeV.objValue;
    }
}
