package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewSwitcher a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f28010b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28011c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28012d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28013e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28014f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28015g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28016h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.obfuscated_res_0x7f100143);
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28016h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d04a8);
            setCanceledOnTouchOutside(false);
            this.f28010b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091655);
            this.a = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0923db);
            this.f28011c = (TextView) findViewById(R.id.obfuscated_res_0x7f092059);
            this.f28012d = (TextView) findViewById(R.id.obfuscated_res_0x7f091460);
            this.f28013e = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a8);
            this.f28014f = (TextView) findViewById(R.id.obfuscated_res_0x7f091534);
            this.f28015g = (TextView) findViewById(R.id.obfuscated_res_0x7f091541);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f28011c.setText(str);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f28011c.setVisibility(i);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f28012d.setVisibility(i);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f28013e.setText(str);
            this.f28013e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f28015g.setText(str);
            this.f28015g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
                this.a.setDisplayedChild(0);
            } else {
                this.a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f28012d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f28014f.setText(str);
            this.f28014f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f28010b.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e61));
                this.f28011c.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f06088d));
                this.f28012d.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060881));
                this.f28014f.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060885));
                this.f28013e.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060889));
                this.f28015g.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060885));
                this.f28014f.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5b));
                this.f28013e.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5d));
                this.f28015g.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5b));
                return;
            }
            this.f28010b.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e60));
            this.f28011c.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f06088c));
            this.f28012d.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060880));
            this.f28014f.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060884));
            this.f28015g.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060884));
            this.f28013e.setTextColor(this.f28016h.getResources().getColor(R.color.obfuscated_res_0x7f060888));
            this.f28014f.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5a));
            this.f28013e.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5c));
            this.f28015g.setBackgroundDrawable(this.f28016h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5a));
        }
    }
}
