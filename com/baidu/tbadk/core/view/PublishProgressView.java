package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.o0.s.q.k1;
import c.a.o0.s.u.c;
import c.a.p0.i3.q0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PublishProgressBar f47552e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47553f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47554g;

    /* renamed from: h  reason: collision with root package name */
    public k1 f47555h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context, attributeSet);
    }

    private void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            this.f47553f.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.f47552e.c(i2))));
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
            this.f47552e = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
            this.f47553f = (TextView) inflate.findViewById(R.id.progress_text);
            TextView textView = (TextView) inflate.findViewById(R.id.progress_close_btn);
            this.f47554g = textView;
            textView.setOnClickListener(this);
            this.f47552e.setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public final void b() {
        k1 k1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (k1Var = this.f47555h) == null) {
            return;
        }
        if (k1Var.d()) {
            setProgress(this.f47555h.a());
            setVisibility(0);
            return;
        }
        setVisibility(8);
        setProgress(0);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47552e.b();
            c d2 = c.d(this.f47553f);
            d2.t(R.color.CAM_X0101);
            d2.x(R.dimen.T_X06);
            d2.y(R.string.F_X01);
            c d3 = c.d(this.f47554g);
            d3.t(R.color.CAM_X0101);
            d3.x(R.dimen.T_X09);
            d3.y(R.string.F_X01);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == R.id.progress_close_btn) {
            k1 k1Var = this.f47555h;
            if (k1Var != null) {
                k1Var.b();
                b();
            }
            j.c();
        }
    }

    public void updateCurProgressData(@NonNull k1 k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, k1Var) == null) {
            if (k1Var.equals(this.f47555h)) {
                this.f47555h.g(k1Var);
                b();
                return;
            }
            this.f47555h = k1Var;
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context, AttributeSet attributeSet) {
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
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishProgressView(Context context) {
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
        a(context, null);
    }
}
