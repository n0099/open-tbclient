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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hh0;
import com.repackage.iy0;
import com.repackage.ri0;
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
                this.a.j1();
                NadDialogActivity nadDialogActivity = this.a;
                nadDialogActivity.r1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_POSITIVE.type, this.a.z);
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
                this.a.i1();
                NadDialogActivity nadDialogActivity = this.a;
                nadDialogActivity.r1(nadDialogActivity.A, ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BTN_NAGITIVE.type, this.a.z);
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

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.B0(bundle);
            setContentView(ri0.a().a());
            Intent intent = getIntent();
            this.B = intent;
            if (intent != null) {
                this.z = intent.getStringExtra("ext");
                this.A = this.B.getStringExtra("alsPage");
            }
            l1();
            m1();
            r1(this.A, ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_DIALOG_SHOW.type, this.z);
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public abstract int k1();

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09225c);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f092279);
            this.w = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09009d);
            this.x = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091353);
            this.y = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091352);
            LayoutInflater.from(this).inflate(k1(), (ViewGroup) this.x, true);
            this.w.setBackground(hh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d3d));
            this.w.setDividerDrawable(hh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d3f));
            this.y.setDividerDrawable(hh0.b().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d40));
            if (o1()) {
                this.u.setText(q1());
                this.u.setOnClickListener(new a(this));
            } else {
                this.u.setVisibility(8);
            }
            if (n1()) {
                this.v.setText(p1());
                this.v.setOnClickListener(new b(this));
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void r1(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048586, this, str, str2, str3, str4) == null) && NetWorkUtils.b(hh0.b())) {
            iy0.b(new ClogBuilder().z(str2).v(str).j(str3).p(str4));
        }
    }
}
