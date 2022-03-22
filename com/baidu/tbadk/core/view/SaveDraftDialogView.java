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
/* loaded from: classes5.dex */
public class SaveDraftDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30110b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30111c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30112d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30113e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f30114f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f30115g;

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
            SkinManager.setViewTextColor(this.f30110b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f30111c, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f30112d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f30113e, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f30114f, (int) R.color.CAM_X0107);
            if (this.f30115g == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                this.f30115g = gradientDrawable;
                gradientDrawable.setCornerRadii(new float[]{n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), n.f(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.f30115g.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackground(this.f30115g);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            setPadding(0, 0, 0, n.f(context, R.dimen.tbds21));
            LinearLayout linearLayout = new LinearLayout(context);
            this.a = linearLayout;
            linearLayout.setOrientation(1);
            this.a.setGravity(17);
            addView(this.a, -1, n.f(context, R.dimen.tbds182));
            int f2 = n.f(context, R.dimen.tbds44);
            TextView textView = new TextView(context);
            this.f30110b = textView;
            float f3 = f2;
            textView.setTextSize(0, f3);
            this.f30110b.setGravity(17);
            this.a.addView(this.f30110b, -1, -2);
            TextView textView2 = new TextView(context);
            this.f30111c = textView2;
            textView2.setTextSize(0, n.f(context, R.dimen.tbds34));
            this.f30111c.setGravity(17);
            this.f30111c.setPadding(0, n.f(context, R.dimen.tbds10), 0, 0);
            this.a.addView(this.f30111c, -1, -2);
            TextView textView3 = new TextView(context);
            this.f30112d = textView3;
            textView3.setId(R.id.obfuscated_res_0x7f091bec);
            this.f30112d.setTextSize(0, f3);
            this.f30112d.setGravity(17);
            this.f30112d.setText(R.string.obfuscated_res_0x7f0f0c7a);
            addView(this.f30112d, -1, n.f(context, R.dimen.tbds136));
            TextView textView4 = new TextView(context);
            this.f30113e = textView4;
            textView4.setId(R.id.obfuscated_res_0x7f091bed);
            this.f30113e.setTextSize(0, f3);
            this.f30113e.setGravity(17);
            addView(this.f30113e, -1, n.f(context, R.dimen.tbds136));
            TextView textView5 = new TextView(context);
            this.f30114f = textView5;
            textView5.setId(R.id.obfuscated_res_0x7f091beb);
            this.f30114f.setTextSize(0, f3);
            this.f30114f.setGravity(17);
            this.f30114f.setText(R.string.obfuscated_res_0x7f0f036c);
            addView(this.f30114f, -1, n.f(context, R.dimen.tbds136));
            a();
        }
    }

    public void setButtonTag(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            this.f30113e.setTag(i, obj);
            this.f30112d.setTag(i, obj);
            this.f30114f.setTag(i, obj);
        }
    }

    public void setCancelVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f30114f.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f30112d.setOnClickListener(onClickListener);
            this.f30113e.setOnClickListener(onClickListener);
            this.f30114f.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            this.f30110b.setText(str);
            this.f30113e.setText(str3);
            if (!m.isEmpty(str2)) {
                this.f30111c.setText(str2);
                this.f30111c.setVisibility(0);
                return;
            }
            this.f30111c.setVisibility(8);
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
            this.f30110b.setText(str);
            this.f30113e.setText(str3);
            if (!m.isEmpty(str4)) {
                this.f30112d.setText(str4);
            }
            if (!m.isEmpty(str2)) {
                this.f30111c.setText(str2);
                this.f30111c.setVisibility(0);
                return;
            }
            this.f30111c.setVisibility(8);
        }
    }
}
