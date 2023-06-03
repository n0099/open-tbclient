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
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public GradientDrawable e;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            if (this.e == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                this.e = gradientDrawable;
                gradientDrawable.setCornerRadii(new float[]{vi.g(getContext(), R.dimen.tbds31), vi.g(getContext(), R.dimen.tbds31), vi.g(getContext(), R.dimen.tbds31), vi.g(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.e.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackground(this.e);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            setPadding(0, vi.g(context, R.dimen.M_H_X003), 0, 0);
            TextView textView = new TextView(context);
            this.a = textView;
            textView.setTextSize(0, vi.g(context, R.dimen.tbds40));
            this.a.setGravity(17);
            addView(this.a, -1, vi.g(context, R.dimen.tbds96));
            int g = vi.g(context, R.dimen.tbds44);
            int g2 = vi.g(context, R.dimen.tbds125);
            TextView textView2 = new TextView(context);
            this.c = textView2;
            textView2.setId(R.id.save_draft_dialog_save);
            float f = g;
            this.c.setTextSize(0, f);
            this.c.setGravity(17);
            addView(this.c, -1, g2);
            TextView textView3 = new TextView(context);
            this.b = textView3;
            textView3.setId(R.id.save_draft_dialog_not_save);
            this.b.setTextSize(0, f);
            this.b.setGravity(17);
            this.b.setText(R.string.not_save);
            addView(this.b, -1, g2);
            TextView textView4 = new TextView(context);
            this.d = textView4;
            textView4.setId(R.id.save_draft_dialog_cancle);
            this.d.setTextSize(0, f);
            this.d.setGravity(17);
            this.d.setText(R.string.obfuscated_res_0x7f0f03c9);
            addView(this.d, -1, g2);
            addView(new TextView(context), -1, vi.g(context, R.dimen.tbds36));
            a();
        }
    }

    public void setButtonTag(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            this.c.setTag(i, obj);
            this.b.setTag(i, obj);
            this.d.setTag(i, obj);
        }
    }

    public void setText(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.setText(str);
            this.c.setText(str2);
        }
    }

    public void setCancelVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
            this.c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            this.a.setText(str);
            this.c.setText(str2);
            if (!ui.isEmpty(str3)) {
                this.b.setText(str3);
            }
        }
    }
}
