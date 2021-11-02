package com.baidu.searchbox.ui.bubble.builder;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleTextBuilder extends BubbleBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleTextManager mManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleTextBuilder() {
        this(new BubbleTextManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((BubbleTextManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BubbleTextBuilder isMiniBubble(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.mManager.getViews().isMiniBubble(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    public BubbleTextBuilder setFontSize(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            this.mManager.setFontSizew(i2, f2);
            return this;
        }
        return (BubbleTextBuilder) invokeCommon.objValue;
    }

    public BubbleTextBuilder setSpan(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, spannableStringBuilder)) == null) {
            this.mManager.getViews().setText(spannableStringBuilder);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    public BubbleTextBuilder setText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, charSequence)) == null) {
            this.mManager.getViews().setText(charSequence);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    public BubbleTextBuilder setTextColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i2, i3)) == null) {
            try {
                this.mManager.getViews().setTextColor(i2, i3);
                return this;
            } catch (Exception unused) {
                this.mManager.getViews().setTextColor(Color.parseColor("#CC000000"), Color.parseColor("#CC000000"));
                return this;
            }
        }
        return (BubbleTextBuilder) invokeII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextBuilder(BubbleTextManager bubbleTextManager) {
        super(bubbleTextManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleTextManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BubbleBaseManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mManager = bubbleTextManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextManager build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mManager : (BubbleTextManager) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableAnchorClk(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            super.enableAnchorClk(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableAnimation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            super.enableAnimation(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableBgClk(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            super.enableBgClk(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableClkDismiss(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            super.enableClkDismiss(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder isAutoDetectShowPosition(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            super.isAutoDetectShowPosition(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAnchorAndRootView(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, view, viewGroup)) == null) {
            super.setAnchorAndRootView(view, viewGroup);
            return this;
        }
        return (BubbleTextBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAnchorView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            super.setAnchorView(view);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAutoDismiss(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            super.setAutoDismiss(z);
            return this;
        }
        return (BubbleTextBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAutoDismissInterval(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            super.setAutoDismissInterval(i2);
            return this;
        }
        return (BubbleTextBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setForceShowLeftEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            super.setForceShowLeftEndPoint();
            return this;
        }
        return (BubbleTextBuilder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setForceShowPosition(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bubblePosition)) == null) {
            super.setForceShowPosition(bubblePosition);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOffsetOfArrow(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            super.setOffsetOfArrow(f2);
            return this;
        }
        return (BubbleTextBuilder) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOnAnchorClickListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, onAnchorClickListener)) == null) {
            super.setOnAnchorClickListener(onAnchorClickListener);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, onBubbleEventListener)) == null) {
            super.setOnBubbleEventListener(onBubbleEventListener);
            return this;
        }
        return (BubbleTextBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setPaddingBetweenAnchor(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048613, this, f2)) == null) {
            super.setPaddingBetweenAnchor(f2);
            return this;
        }
        return (BubbleTextBuilder) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setBackgroundColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i2, i3)) == null) {
            super.setBackgroundColor(i2, i3);
            return this;
        }
        return (BubbleTextBuilder) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setBackgroundColor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, str2)) == null) {
            super.setBackgroundColor(str, str2);
            return this;
        }
        return (BubbleTextBuilder) invokeLL.objValue;
    }

    public BubbleTextBuilder setTextColor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "#FFFFFF";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "#666666";
            }
            try {
                this.mManager.getViews().setTextColor(Color.parseColor(str), Color.parseColor(str2));
                return this;
            } catch (Exception unused) {
                this.mManager.getViews().setTextColor(Color.parseColor("#CC000000"), Color.parseColor("#CC000000"));
                return this;
            }
        }
        return (BubbleTextBuilder) invokeLL.objValue;
    }
}
