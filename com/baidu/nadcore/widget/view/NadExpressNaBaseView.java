package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.nadcore.widget.uitemplate.NadExpressBottomView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f51;
import com.repackage.g51;
import com.repackage.mn0;
import com.repackage.o51;
import com.repackage.p51;
/* loaded from: classes2.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final p51 i;
    @Nullable
    public TextView j;
    @Nullable
    public o51 k;
    @Nullable
    public NadExpressBottomView l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            o51 o51Var = this.k;
            if (o51Var != null) {
                o51Var.e();
            }
        }
    }

    public o51 getOperateBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (o51) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c6);
            this.l = (NadExpressBottomView) findViewById(R.id.obfuscated_res_0x7f0915c1);
            k(context);
        }
    }

    public abstract void j(LayoutInflater layoutInflater, mn0 mn0Var);

    public abstract void k(Context context);

    public void l(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            o51 c = this.i.c(adBaseModel);
            this.k = c;
            if (c != null) {
                c.i(0);
                this.k.update(adBaseModel, this);
                this.k.j();
                f51 f51Var = this.c;
                if (f51Var != null) {
                    this.k.h(f51Var);
                }
                g51 g51Var = this.a;
                if (g51Var != null) {
                    this.k.f(g51Var);
                }
            }
        }
    }

    public abstract void m(AdBaseModel adBaseModel);

    public abstract void n(AdBaseModel adBaseModel);

    public void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) || adBaseModel == null || this.j == null) {
            return;
        }
        mn0 mn0Var = adBaseModel.p;
        if (mn0Var == null || mn0Var.l) {
            int i = adBaseModel.b ? R.color.obfuscated_res_0x7f060293 : R.color.obfuscated_res_0x7f060263;
            TextView textView = this.j;
            textView.setTextColor(textView.getContext().getResources().getColor(i));
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.onClick(view2);
            if (getTag() instanceof AdBaseModel) {
                o((AdBaseModel) getTag());
            }
        }
    }

    public void setMaxTitleLine(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setMaxLines(i);
    }

    public void setTitleColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setTitleLineSpacing(float f, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setLineSpacing(f, f2);
    }

    public void setTitleSize(float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048590, this, f) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextSize(f);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewDownloadListener(f51 f51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, f51Var) == null) {
            super.setViewDownloadListener(f51Var);
            o51 o51Var = this.k;
            if (o51Var != null) {
                o51Var.h(f51Var);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(g51 g51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, g51Var) == null) {
            super.setViewStatChangeListener(g51Var);
            o51 o51Var = this.k;
            if (o51Var != null) {
                o51Var.f(g51Var);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adBaseModel) == null) {
            super.update(adBaseModel);
            m(adBaseModel);
            NadExpressBottomView nadExpressBottomView = this.l;
            if (nadExpressBottomView != null) {
                nadExpressBottomView.update(adBaseModel);
            }
            l(adBaseModel);
            n(adBaseModel);
            o(adBaseModel);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(adBaseModel.f.g);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (mn0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable mn0 mn0Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), mn0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        j(LayoutInflater.from(context), mn0Var);
        i(context);
        this.i = new p51(this);
    }
}
