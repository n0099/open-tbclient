package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.utils.CommonViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewSwitcher f28003b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f28004c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28005d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28006e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28007f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28008g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28009h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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
        this.a = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d04a6);
            setCanceledOnTouchOutside(false);
            this.f28003b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0923db);
            this.f28005d = (TextView) findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f28006e = (TextView) findViewById(R.id.obfuscated_res_0x7f0907ae);
            this.f28007f = (TextView) findViewById(R.id.obfuscated_res_0x7f091460);
            this.f28008g = (TextView) findViewById(R.id.obfuscated_res_0x7f091658);
            this.f28009h = (TextView) findViewById(R.id.obfuscated_res_0x7f091657);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091659);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a8);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091534);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091541);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ffc);
            this.f28004c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091656);
            CommonViewUtility.setViewClickAlpha(this.j, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f28005d.setText(str);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f28006e.setVisibility(0);
            this.f28006e.setText(str);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f28005d.setVisibility(0);
            } else {
                this.f28005d.setVisibility(8);
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m.setVisibility(0);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f28007f.setText(i);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onClickListener) == null) {
            this.j.setText(str);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.l.setText(str);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
                this.f28003b.setDisplayedChild(0);
            } else {
                this.f28003b.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f28007f.setVisibility(0);
            this.f28007f.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.k.setText(str);
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f28004c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e61));
                this.f28005d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088c));
                this.f28006e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060881));
                this.f28007f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088b));
                this.f28008g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088b));
                this.f28009h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088b));
                this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088b));
                this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060885));
                this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060889));
                this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060889));
                this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5b));
                this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5d));
                this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5d));
                return;
            }
            this.f28004c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e60));
            this.f28005d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088c));
            this.f28006e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060880));
            this.f28007f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088a));
            this.f28008g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088a));
            this.f28009h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088a));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06088a));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060884));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060888));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060888));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5a));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5c));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5c));
        }
    }
}
