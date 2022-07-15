package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.c90;
import com.repackage.eb0;
import com.repackage.t80;
/* loaded from: classes2.dex */
public class ErrorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public SimpleDraweeView b;
    public TextView c;
    public b d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ErrorView a;

        public a(ErrorView errorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {errorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = errorView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (NetWorkUtils.b(this.a.getContext())) {
                    if (this.a.d != null) {
                        this.a.d.a(view2);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f09f0, 1).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context) {
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
            this.a.setOnClickListener(new a(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (NetWorkUtils.b(getContext())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.width = t80.a(getContext(), c90.a().o);
                layoutParams.height = t80.a(getContext(), c90.a().p);
                this.b.setLayoutParams(layoutParams);
                setImageResource(eb0.e().c(z));
                this.c.setText(R.string.obfuscated_res_0x7f0f09ef);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams2.width = t80.a(getContext(), c90.a().u);
                layoutParams2.height = t80.a(getContext(), c90.a().v);
                this.b.setLayoutParams(layoutParams2);
                setImageResource(eb0.e().d(z));
                this.c.setText(R.string.obfuscated_res_0x7f0f09f0);
            }
            this.c.setTextColor(eb0.e().a(getContext(), z, "color_8585852"));
            this.a.setTextColor(eb0.e().a(getContext(), z, "color_5252522"));
            this.a.setBackground(eb0.e().m(getContext(), z));
        }
    }

    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.setVisibility(i);
            if (i == 0) {
                c(z);
            }
        }
    }

    public void setActionCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i == -1) {
            return;
        }
        this.b.setActualImageResource(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context, AttributeSet attributeSet) {
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
    public ErrorView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d050c, this);
        setOrientation(1);
        setGravity(17);
        this.b = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f0908e8);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0908e6);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0908e7);
        b();
    }
}
