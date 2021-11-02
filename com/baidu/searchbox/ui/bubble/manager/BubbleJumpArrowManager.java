package com.baidu.searchbox.ui.bubble.manager;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.views.BubbleJumpArrowView;
import com.baidu.searchbox.ui.bubble.views.BubbleTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleJumpArrowManager extends BubbleTextManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleJumpArrowView mArrowViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleJumpArrowManager() {
        super(new BubbleJumpArrowView());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BubbleTextView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mArrowViews = (BubbleJumpArrowView) this.mViews;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onShow();
            BubbleJumpArrowView bubbleJumpArrowView = this.mArrowViews;
            if (bubbleJumpArrowView != null) {
                bubbleJumpArrowView.onShowArrow();
                this.mArrowViews.setJumpArrowClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleJumpArrowManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BubbleJumpArrowManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.onClickCore(view);
                        }
                    }
                });
            }
        }
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.mArrowViews.setJumpArrowClickListener(onClickListener);
        }
    }

    public void setJumpArrowVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mArrowViews.setJumpArrowVisible(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleJumpArrowView getViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mArrowViews : (BubbleJumpArrowView) invokeV.objValue;
    }
}
