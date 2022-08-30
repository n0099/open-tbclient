package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.eh0;
import com.baidu.tieba.iy0;
import com.baidu.tieba.oi0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class NadDialogActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public Intent B;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadDialogActivity a;

        public a(NadDialogActivity nadDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u1();
                NadDialogActivity nadDialogActivity = this.a;
                nadDialogActivity.D1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_POSITIVE.type, this.a.z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadDialogActivity a;

        public b(NadDialogActivity nadDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t1();
                NadDialogActivity nadDialogActivity = this.a;
                nadDialogActivity.D1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_NAGITIVE.type, this.a.z);
            }
        }
    }

    public NadDialogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void D1(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) && NetWorkUtils.b(eh0.b())) {
            iy0.b(new ClogBuilder().z(str2).v(str).j(str3).p(str4));
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.P0(bundle);
            setContentView(oi0.a().a());
            Intent intent = getIntent();
            this.B = intent;
            if (intent != null) {
                this.z = intent.getStringExtra("ext");
                this.A = this.B.getStringExtra("alsPage");
            }
            w1();
            x1();
            D1(this.A, ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_DIALOG_SHOW.type, this.z);
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public abstract int v1();

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f092372);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f092391);
            this.w = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0900a2);
            this.x = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913d3);
            this.y = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913d2);
            LayoutInflater.from(this).inflate(v1(), (ViewGroup) this.x, true);
            this.w.setBackground(eh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d9c));
            this.w.setDividerDrawable(eh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d9e));
            this.y.setDividerDrawable(eh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d9f));
            if (A1()) {
                this.u.setText(C1());
                this.u.setOnClickListener(new a(this));
            } else {
                this.u.setVisibility(8);
            }
            if (z1()) {
                this.v.setText(B1());
                this.v.setOnClickListener(new b(this));
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
