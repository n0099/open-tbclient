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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f12518e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12519f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12520g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12521h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12522i;
    public TextView j;
    public GradientDrawable k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveDraftDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            SkinManager.setViewTextColor(this.f12519f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12520g, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f12521h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12522i, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
            if (this.k == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                this.k = gradientDrawable;
                gradientDrawable.setCornerRadii(new float[]{l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.k.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackground(this.k);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            setPadding(0, 0, 0, l.g(context, R.dimen.tbds21));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f12518e = linearLayout;
            linearLayout.setOrientation(1);
            this.f12518e.setGravity(17);
            addView(this.f12518e, -1, l.g(context, R.dimen.tbds182));
            int g2 = l.g(context, R.dimen.tbds44);
            TextView textView = new TextView(context);
            this.f12519f = textView;
            float f2 = g2;
            textView.setTextSize(0, f2);
            this.f12519f.setGravity(17);
            this.f12518e.addView(this.f12519f, -1, -2);
            TextView textView2 = new TextView(context);
            this.f12520g = textView2;
            textView2.setTextSize(0, l.g(context, R.dimen.tbds34));
            this.f12520g.setGravity(17);
            this.f12520g.setPadding(0, l.g(context, R.dimen.tbds10), 0, 0);
            this.f12518e.addView(this.f12520g, -1, -2);
            TextView textView3 = new TextView(context);
            this.f12521h = textView3;
            textView3.setId(R.id.save_draft_dialog_not_save);
            this.f12521h.setTextSize(0, f2);
            this.f12521h.setGravity(17);
            this.f12521h.setText(R.string.not_save);
            addView(this.f12521h, -1, l.g(context, R.dimen.tbds136));
            TextView textView4 = new TextView(context);
            this.f12522i = textView4;
            textView4.setId(R.id.save_draft_dialog_save);
            this.f12522i.setTextSize(0, f2);
            this.f12522i.setGravity(17);
            addView(this.f12522i, -1, l.g(context, R.dimen.tbds136));
            TextView textView5 = new TextView(context);
            this.j = textView5;
            textView5.setId(R.id.save_draft_dialog_cancle);
            this.j.setTextSize(0, f2);
            this.j.setGravity(17);
            this.j.setText(R.string.cancel);
            addView(this.j, -1, l.g(context, R.dimen.tbds136));
            a();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f12521h.setOnClickListener(onClickListener);
            this.f12522i.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            this.f12519f.setText(str);
            this.f12522i.setText(str3);
            if (!k.isEmpty(str2)) {
                this.f12520g.setText(str2);
                this.f12520g.setVisibility(0);
                return;
            }
            this.f12520g.setVisibility(8);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            this.f12519f.setText(str);
            this.f12522i.setText(str3);
            if (!k.isEmpty(str4)) {
                this.f12521h.setText(str4);
            }
            if (!k.isEmpty(str2)) {
                this.f12520g.setText(str2);
                this.f12520g.setVisibility(0);
                return;
            }
            this.f12520g.setVisibility(8);
        }
    }
}
