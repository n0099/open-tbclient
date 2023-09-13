package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.divider.EmoTextGridItemDecoration;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.spswitch.utils.EmotionVipHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BDEmotionTextLayout extends BDEmotionBaseLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EMOTION_TEXT_COLUMNS = 3;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public int getSpanCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public boolean showDelBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    public boolean showPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDEmotionTextLayout(@NonNull Context context) {
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

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    @Nullable
    public BDEmotionDynamicAdapter.OnEmotionClickListener getEmotionClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new BDEmotionDynamicAdapter.OnEmotionClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionTextLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionTextLayout this$0;

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
                    BDEmotionTextLayout bDEmotionTextLayout = this.this$0;
                    if (bDEmotionTextLayout.mTypeModel == null) {
                        return;
                    }
                    EmotionVipHelper.doCheckVip(bDEmotionTextLayout.getContext(), this.this$0.mTypeModel.getAuth(), new EmotionVipHelper.OnVipCheckListener(this, emotionItemModel) { // from class: com.baidu.spswitch.emotion.view.BDEmotionTextLayout.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ EmotionItemModel val$itemModel;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, emotionItemModel};
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
                        }

                        @Override // com.baidu.spswitch.utils.EmotionVipHelper.OnVipCheckListener
                        public void onResult(boolean z) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) {
                                if (z) {
                                    GlobalOnItemClickListenerManager.getInstance().emotionTextItemClick(this.val$itemModel);
                                } else {
                                    EmotionVipHelper.doBuyVip(this.this$1.this$0.getContext(), this.this$1.this$0.mTypeModel.getAuth(), this.this$1.this$0.mTypeModel.getSchema(), new EmotionVipHelper.OnBuyVipListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionTextLayout.1.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ C01881 this$2;

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
                                                GlobalOnItemClickListenerManager.getInstance().emotionTextItemClick(this.this$2.val$itemModel);
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
            };
        }
        return (BDEmotionDynamicAdapter.OnEmotionClickListener) invokeV.objValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    @NonNull
    public RecyclerView.ItemDecoration getItemDecoration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new EmoTextGridItemDecoration();
        }
        return (RecyclerView.ItemDecoration) invokeV.objValue;
    }

    @Override // com.baidu.spswitch.emotion.view.BDEmotionBaseLayout
    @NonNull
    public RecyclerView.LayoutManager getLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager) { // from class: com.baidu.spswitch.emotion.view.BDEmotionTextLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionTextLayout this$0;
                public final /* synthetic */ GridLayoutManager val$manager;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, gridLayoutManager};
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
                    this.val$manager = gridLayoutManager;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                        if (i == 0) {
                            return this.val$manager.getSpanCount();
                        }
                        return 1;
                    }
                    return invokeI.intValue;
                }
            });
            return gridLayoutManager;
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }
}
