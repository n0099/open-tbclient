package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f41915e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41916f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41917g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41918h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41919i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41920j;

    /* renamed from: k  reason: collision with root package name */
    public GradientDrawable f41921k;

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
            SkinManager.setViewTextColor(this.f41916f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f41917g, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f41918h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f41919i, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f41920j, R.color.CAM_X0107);
            if (this.f41921k == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                this.f41921k = gradientDrawable;
                gradientDrawable.setCornerRadii(new float[]{n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.f41921k.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackground(this.f41921k);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            setPadding(0, 0, 0, n.f(context, R.dimen.tbds21));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f41915e = linearLayout;
            linearLayout.setOrientation(1);
            this.f41915e.setGravity(17);
            addView(this.f41915e, -1, n.f(context, R.dimen.tbds182));
            int f2 = n.f(context, R.dimen.tbds44);
            TextView textView = new TextView(context);
            this.f41916f = textView;
            float f3 = f2;
            textView.setTextSize(0, f3);
            this.f41916f.setGravity(17);
            this.f41915e.addView(this.f41916f, -1, -2);
            TextView textView2 = new TextView(context);
            this.f41917g = textView2;
            textView2.setTextSize(0, n.f(context, R.dimen.tbds34));
            this.f41917g.setGravity(17);
            this.f41917g.setPadding(0, n.f(context, R.dimen.tbds10), 0, 0);
            this.f41915e.addView(this.f41917g, -1, -2);
            TextView textView3 = new TextView(context);
            this.f41918h = textView3;
            textView3.setId(R.id.save_draft_dialog_not_save);
            this.f41918h.setTextSize(0, f3);
            this.f41918h.setGravity(17);
            this.f41918h.setText(R.string.not_save);
            addView(this.f41918h, -1, n.f(context, R.dimen.tbds136));
            TextView textView4 = new TextView(context);
            this.f41919i = textView4;
            textView4.setId(R.id.save_draft_dialog_save);
            this.f41919i.setTextSize(0, f3);
            this.f41919i.setGravity(17);
            addView(this.f41919i, -1, n.f(context, R.dimen.tbds136));
            TextView textView5 = new TextView(context);
            this.f41920j = textView5;
            textView5.setId(R.id.save_draft_dialog_cancle);
            this.f41920j.setTextSize(0, f3);
            this.f41920j.setGravity(17);
            this.f41920j.setText(R.string.cancel);
            addView(this.f41920j, -1, n.f(context, R.dimen.tbds136));
            a();
        }
    }

    public void setButtonTag(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
            this.f41919i.setTag(i2, obj);
            this.f41918h.setTag(i2, obj);
            this.f41920j.setTag(i2, obj);
        }
    }

    public void setCancelVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f41920j.setVisibility(i2);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f41918h.setOnClickListener(onClickListener);
            this.f41919i.setOnClickListener(onClickListener);
            this.f41920j.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            this.f41916f.setText(str);
            this.f41919i.setText(str3);
            if (!m.isEmpty(str2)) {
                this.f41917g.setText(str2);
                this.f41917g.setVisibility(0);
                return;
            }
            this.f41917g.setVisibility(8);
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
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            this.f41916f.setText(str);
            this.f41919i.setText(str3);
            if (!m.isEmpty(str4)) {
                this.f41918h.setText(str4);
            }
            if (!m.isEmpty(str2)) {
                this.f41917g.setText(str2);
                this.f41917g.setVisibility(0);
                return;
            }
            this.f41917g.setVisibility(8);
        }
    }
}
