package com.baidu.searchbox.ui.bubble.builder;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.manager.BubbleJumpArrowManager;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleJumpArrowBuilder extends BubbleTextBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleJumpArrowManager mManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleJumpArrowBuilder() {
        this(new BubbleJumpArrowManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((BubbleJumpArrowManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.mManager.setJumpArrowClickListener(onClickListener);
        }
    }

    public void setJumpArrowVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mManager.setJumpArrowVisible(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleJumpArrowBuilder(BubbleJumpArrowManager bubbleJumpArrowManager) {
        super(bubbleJumpArrowManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleJumpArrowManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BubbleTextManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mManager = bubbleJumpArrowManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder, com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleJumpArrowManager build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mManager : (BubbleJumpArrowManager) invokeV.objValue;
    }
}
