package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.pu4;
/* loaded from: classes3.dex */
public class CommonUserLikeButton extends TextView implements pu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public a d;
    public View.OnClickListener e;
    public boolean f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonUserLikeButton(Context context) {
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
        this.f = false;
        f();
    }

    @Override // com.repackage.pu4
    public void a(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.e) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    @Override // com.repackage.pu4
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // com.repackage.pu4
    public void c(boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            e(z, i);
        }
    }

    @Override // com.repackage.pu4
    public void d(int i) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (aVar = this.d) == null) {
            return;
        }
        aVar.a(i);
    }

    public void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            h(z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setSingleLine();
            setIncludeFontPadding(false);
            setTextSize(0, li.f(getContext(), R.dimen.obfuscated_res_0x7f0701f9));
            setGravity(17);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (this.c) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this, (int) R.color.CAM_X0109);
                setBackgroundDrawable(null);
                return;
            }
            SkinManager.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
            if (this.f) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
            } else {
                SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
            if (z) {
                setClickable(false);
                setText(this.a);
                setPadding(0, 0, 0, 0);
            } else {
                setClickable(true);
                setText(this.b);
                setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), 0);
            }
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void setBackGroundIsTransMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f = z;
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.d = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
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
        this.f = false;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
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
        this.f = false;
        f();
    }
}
