package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CommonLikeButton extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context) {
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
        TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ea);
        d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setSingleLine();
            setIncludeFontPadding(false);
            setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds34));
            setGravity(17);
        }
    }

    public void setBackGroundIsTransMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }
}
