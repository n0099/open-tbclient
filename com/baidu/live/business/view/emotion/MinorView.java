package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.da0;
import com.baidu.tieba.la0;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class MinorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView a;
    public AppCompatTextView b;
    public AppCompatTextView c;
    public AppCompatTextView d;
    public la0 e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MinorView a;

        public a(MinorView minorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {minorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = minorView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (da0.f(this.a.getContext())) {
                    if (this.a.e != null) {
                        this.a.e.a(view2);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0a0b, 1).show();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinorView(Context context) {
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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setOnClickListener(new a(this));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.width = da0.b(getContext(), EmotionStrategy.getInstance().minorWidth);
            layoutParams.height = da0.b(getContext(), EmotionStrategy.getInstance().minorHeight);
            this.a.setLayoutParams(layoutParams);
            setImageResource(uc0.f().i(str));
            this.b.setTextColor(uc0.f().a(getContext(), str, "color_8585853"));
            this.c.setTextColor(uc0.f().a(getContext(), str, "color_B8B8B8"));
            this.d.setTextColor(uc0.f().a(getContext(), str, "color_4367B4"));
        }
    }

    public void setActionCallback(la0 la0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, la0Var) == null) {
            this.e = la0Var;
        }
    }

    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i == -1) {
            return;
        }
        this.a.setActualImageResource(i);
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.b.setText(charSequence);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinorView(Context context, @Nullable AttributeSet attributeSet) {
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

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.setText(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinorView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0543, this);
        setOrientation(1);
        setGravity(17);
        this.a = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09153e);
        this.b = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f091540);
        this.c = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f09153d);
        this.d = (AppCompatTextView) findViewById(R.id.obfuscated_res_0x7f0909b5);
        b();
    }
}
