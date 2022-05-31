package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.st4;
/* loaded from: classes3.dex */
public class CommonLikeButton extends AppCompatTextView implements st4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public View.OnClickListener d;
    public boolean e;

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
        this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f98);
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.c = false;
        this.e = false;
        d();
    }

    @Override // com.repackage.st4
    public void a(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.d) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.repackage.st4
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // com.repackage.st4
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            setVisibility(0);
            this.c = z;
            if (z) {
                setClickable(false);
                setText(this.a);
                setPadding(0, 0, 0, 0);
            } else {
                setClickable(true);
                setText(this.b);
                setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070263), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), 0);
            }
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setSingleLine();
            setIncludeFontPadding(false);
            setTextSize(0, li.f(getContext(), R.dimen.tbds34));
            setGravity(17);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.c) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this, (int) R.color.CAM_X0109);
                setBackgroundDrawable(null);
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
            if (this.e) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
            } else {
                SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
            }
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void setBackGroundIsTransMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
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
        this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f98);
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.c = false;
        this.e = false;
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
        this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f98);
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4);
        this.c = false;
        this.e = false;
        d();
    }
}
