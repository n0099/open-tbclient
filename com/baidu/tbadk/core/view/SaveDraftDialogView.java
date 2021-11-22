package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f46230e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46231f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46232g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46233h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46234i;
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
            SkinManager.setViewTextColor(this.f46231f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f46232g, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f46233h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f46234i, R.color.CAM_X0302);
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
            this.f46230e = linearLayout;
            linearLayout.setOrientation(1);
            this.f46230e.setGravity(17);
            addView(this.f46230e, -1, l.g(context, R.dimen.tbds182));
            int g2 = l.g(context, R.dimen.tbds44);
            TextView textView = new TextView(context);
            this.f46231f = textView;
            float f2 = g2;
            textView.setTextSize(0, f2);
            this.f46231f.setGravity(17);
            this.f46230e.addView(this.f46231f, -1, -2);
            TextView textView2 = new TextView(context);
            this.f46232g = textView2;
            textView2.setTextSize(0, l.g(context, R.dimen.tbds34));
            this.f46232g.setGravity(17);
            this.f46232g.setPadding(0, l.g(context, R.dimen.tbds10), 0, 0);
            this.f46230e.addView(this.f46232g, -1, -2);
            TextView textView3 = new TextView(context);
            this.f46233h = textView3;
            textView3.setId(R.id.save_draft_dialog_not_save);
            this.f46233h.setTextSize(0, f2);
            this.f46233h.setGravity(17);
            this.f46233h.setText(R.string.not_save);
            addView(this.f46233h, -1, l.g(context, R.dimen.tbds136));
            TextView textView4 = new TextView(context);
            this.f46234i = textView4;
            textView4.setId(R.id.save_draft_dialog_save);
            this.f46234i.setTextSize(0, f2);
            this.f46234i.setGravity(17);
            addView(this.f46234i, -1, l.g(context, R.dimen.tbds136));
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

    public void setButtonTag(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
            this.f46234i.setTag(i2, obj);
            this.f46233h.setTag(i2, obj);
            this.j.setTag(i2, obj);
        }
    }

    public void setCancelVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.j.setVisibility(i2);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f46233h.setOnClickListener(onClickListener);
            this.f46234i.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            this.f46231f.setText(str);
            this.f46234i.setText(str3);
            if (!k.isEmpty(str2)) {
                this.f46232g.setText(str2);
                this.f46232g.setVisibility(0);
                return;
            }
            this.f46232g.setVisibility(8);
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
            this.f46231f.setText(str);
            this.f46234i.setText(str3);
            if (!k.isEmpty(str4)) {
                this.f46233h.setText(str4);
            }
            if (!k.isEmpty(str2)) {
                this.f46232g.setText(str2);
                this.f46232g.setVisibility(0);
                return;
            }
            this.f46232g.setVisibility(8);
        }
    }
}
