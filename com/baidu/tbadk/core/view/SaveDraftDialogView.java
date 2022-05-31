package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.li;
/* loaded from: classes3.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public GradientDrawable g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveDraftDialogView(Context context) {
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
        b(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
            if (this.g == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                this.g = gradientDrawable;
                gradientDrawable.setCornerRadii(new float[]{li.f(getContext(), R.dimen.tbds31), li.f(getContext(), R.dimen.tbds31), li.f(getContext(), R.dimen.tbds31), li.f(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.g.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackground(this.g);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            setPadding(0, 0, 0, li.f(context, R.dimen.tbds21));
            LinearLayout linearLayout = new LinearLayout(context);
            this.a = linearLayout;
            linearLayout.setOrientation(1);
            this.a.setGravity(17);
            addView(this.a, -1, li.f(context, R.dimen.tbds182));
            int f = li.f(context, R.dimen.tbds44);
            TextView textView = new TextView(context);
            this.b = textView;
            float f2 = f;
            textView.setTextSize(0, f2);
            this.b.setGravity(17);
            this.a.addView(this.b, -1, -2);
            TextView textView2 = new TextView(context);
            this.c = textView2;
            textView2.setTextSize(0, li.f(context, R.dimen.tbds34));
            this.c.setGravity(17);
            this.c.setPadding(0, li.f(context, R.dimen.tbds10), 0, 0);
            this.a.addView(this.c, -1, -2);
            TextView textView3 = new TextView(context);
            this.d = textView3;
            textView3.setId(R.id.obfuscated_res_0x7f091bd8);
            this.d.setTextSize(0, f2);
            this.d.setGravity(17);
            this.d.setText(R.string.obfuscated_res_0x7f0f0c9d);
            addView(this.d, -1, li.f(context, R.dimen.tbds136));
            TextView textView4 = new TextView(context);
            this.e = textView4;
            textView4.setId(R.id.obfuscated_res_0x7f091bd9);
            this.e.setTextSize(0, f2);
            this.e.setGravity(17);
            addView(this.e, -1, li.f(context, R.dimen.tbds136));
            TextView textView5 = new TextView(context);
            this.f = textView5;
            textView5.setId(R.id.obfuscated_res_0x7f091bd7);
            this.f.setTextSize(0, f2);
            this.f.setGravity(17);
            this.f.setText(R.string.obfuscated_res_0x7f0f0376);
            addView(this.f, -1, li.f(context, R.dimen.tbds136));
            a();
        }
    }

    public void setButtonTag(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            this.e.setTag(i, obj);
            this.d.setTag(i, obj);
            this.f.setTag(i, obj);
        }
    }

    public void setCancelVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            this.b.setText(str);
            this.e.setText(str3);
            if (!ki.isEmpty(str2)) {
                this.c.setText(str2);
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet) {
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
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        b(context);
    }

    public void setText(String str, @Nullable String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            this.b.setText(str);
            this.e.setText(str3);
            if (!ki.isEmpty(str4)) {
                this.d.setText(str4);
            }
            if (!ki.isEmpty(str2)) {
                this.c.setText(str2);
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
        }
    }
}
