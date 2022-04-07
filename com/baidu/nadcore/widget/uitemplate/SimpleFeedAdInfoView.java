package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lo0;
import com.repackage.mo0;
/* loaded from: classes2.dex */
public class SimpleFeedAdInfoView extends SimpleAdInfoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public AppCompatRatingBar j;
    public TextView k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleFeedAdInfoView(@NonNull Context context) {
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

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            super.a(attributeSet);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ce);
            this.j = (AppCompatRatingBar) findViewById(R.id.obfuscated_res_0x7f0914cf);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0914d0);
            c();
            setRatingBarViewLP(R.drawable.obfuscated_res_0x7f080daa);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.i;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06024e));
            }
            AppCompatRatingBar appCompatRatingBar = this.j;
            if (appCompatRatingBar != null) {
                appCompatRatingBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060299), PorterDuff.Mode.SRC_ATOP);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060271));
            }
            TextView textView3 = this.a;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060271));
            }
            TextView textView4 = this.b;
            if (textView4 != null) {
                textView4.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060271));
            }
            TextView textView5 = this.c;
            if (textView5 != null) {
                textView5.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060271));
            }
            TextView textView6 = this.d;
            if (textView6 != null) {
                textView6.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060271));
            }
        }
    }

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void setAdInfo(mo0 mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mo0Var) == null) {
            super.setAdInfo(mo0Var);
            if (this.i != null) {
                if (!TextUtils.isEmpty(mo0Var.c)) {
                    this.i.setText(mo0Var.c);
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
            }
            TextView textView = this.k;
            if (textView != null) {
                double d = mo0Var.e;
                if (d != -1.0d) {
                    textView.setText(String.valueOf(d));
                    this.k.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
            AppCompatRatingBar appCompatRatingBar = this.j;
            if (appCompatRatingBar != null) {
                double d2 = mo0Var.e;
                if (d2 != -1.0d) {
                    appCompatRatingBar.setRating((float) d2);
                    this.j.setVisibility(0);
                    return;
                }
                appCompatRatingBar.setVisibility(8);
            }
        }
    }

    public void setRatingBarViewLP(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.j == null || (drawable = getResources().getDrawable(i)) == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.j.setLayoutParams(layoutParams);
    }

    public void update(AdBaseModel adBaseModel) {
        mo0 mo0Var;
        lo0.a aVar;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, adBaseModel) == null) || adBaseModel == null || (mo0Var = adBaseModel.i) == null) {
            return;
        }
        setAdInfo(mo0Var);
        c();
        lo0 lo0Var = adBaseModel.p;
        if (lo0Var == null || (aVar = lo0Var.j) == null || (i = aVar.h) == 0) {
            return;
        }
        setRatingBarViewLP(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }
}
