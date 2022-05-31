package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m41;
import com.repackage.tz0;
import com.repackage.xz0;
import com.repackage.ym0;
/* loaded from: classes2.dex */
public class NadRewardCountDownView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public xz0 d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public int k;
    public g l;
    public m41 m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public a(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k == 1) {
                return;
            }
            if (this.a.k != 2) {
                if (this.a.k != 3 || this.a.l == null) {
                    return;
                }
                this.a.l.f();
                return;
            }
            this.a.r();
            if (this.a.m != null) {
                tz0.b(this.a.m);
                if (this.a.l != null) {
                    this.a.l.d();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public b(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k == 4 && this.a.l != null) {
                this.a.l.e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends xz0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public c(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // com.repackage.xz0.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                if (this.a.k < 3) {
                    NadRewardCountDownView nadRewardCountDownView = this.a;
                    nadRewardCountDownView.i = "恭喜您已获得" + this.a.h + "!";
                    this.a.k = 3;
                }
                if (this.a.b.getVisibility() != 0) {
                    this.a.b.setVisibility(0);
                }
                this.a.a.setText(String.format(this.a.i, Integer.valueOf(this.a.f)));
                this.a.invalidate();
            }
        }

        @Override // com.repackage.xz0.c
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                super.f(j);
                this.a.f = (((int) j) / 1000) + 1;
                if (this.a.k < 2 && this.a.g > 0 && this.a.e - this.a.f > this.a.g) {
                    if (this.a.b.getVisibility() != 0) {
                        this.a.b.setVisibility(0);
                    }
                    this.a.k = 2;
                }
                this.a.a.setText(String.format(this.a.i, Integer.valueOf(this.a.f)));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements m41.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public d(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // com.repackage.m41.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.m.dismiss();
                if (z && this.a.l != null) {
                    this.a.l.c();
                }
                this.a.t();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public e(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.l == null) {
                return;
            }
            this.a.l.g();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends xz0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardCountDownView a;

        public f(NadRewardCountDownView nadRewardCountDownView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardCountDownView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardCountDownView;
        }

        @Override // com.repackage.xz0.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                if (this.a.k != 4) {
                    this.a.j = "";
                    this.a.k = 4;
                }
                this.a.c.setText(this.a.j);
                this.a.c.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e07));
                this.a.requestLayout();
            }
        }

        @Override // com.repackage.xz0.c
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                super.f(j);
                this.a.f = (((int) j) / 1000) + 1;
                this.a.c.setText(String.format(this.a.j, Integer.valueOf(this.a.f)));
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardCountDownView(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.dispatchWindowVisibilityChanged(i);
            boolean z = i == 0;
            if (z) {
                t();
            }
            if (z) {
                return;
            }
            r();
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05b3, (ViewGroup) this, true);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ba);
            this.b = textView;
            textView.setText("跳过");
            this.b.setVisibility(8);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09147d);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0914bb);
            this.a.setClickable(true);
            this.b.setOnClickListener(new a(this));
            this.c.setOnClickListener(new b(this));
            setVisibility(8);
        }
    }

    public void r() {
        xz0 xz0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (xz0Var = this.d) == null) {
            return;
        }
        xz0Var.d();
        g gVar = this.l;
        if (gVar != null) {
            gVar.b();
        }
    }

    public void s() {
        xz0 xz0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xz0Var = this.d) == null) {
            return;
        }
        xz0Var.b();
        this.d = null;
    }

    public void setRewardDownInnerListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.l = gVar;
        }
    }

    public void t() {
        xz0 xz0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xz0Var = this.d) == null) {
            return;
        }
        xz0Var.e();
        g gVar = this.l;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s();
            this.b.setVisibility(8);
            this.a.setVisibility(8);
            this.c.setVisibility(0);
            xz0 xz0Var = new xz0(3000L, 1000L);
            this.d = xz0Var;
            xz0Var.f(new f(this));
            this.d.g();
        }
    }

    public void update(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || adBaseModel == null || adBaseModel.j == null) {
            return;
        }
        setTag(adBaseModel);
        ym0 ym0Var = adBaseModel.p;
        float f2 = 1.0f;
        if (ym0Var != null) {
            this.g = ym0Var.e;
            String str = ym0Var.i;
            if (!TextUtils.isEmpty(str) && str.length() <= 4) {
                this.h = str;
                this.i = "%2ss后可以领取" + this.h;
            }
            float f3 = adBaseModel.p.g;
            if (f3 > 0.0f && f3 <= 1.0f) {
                f2 = f3;
            }
        }
        int floor = (int) Math.floor(adBaseModel.j.b * f2);
        this.e = floor;
        this.f = floor;
        xz0 xz0Var = new xz0(floor * 1000, 1000L);
        this.d = xz0Var;
        xz0Var.f(new c(this));
        m41 m41Var = new m41(getContext(), adBaseModel, new d(this));
        this.m = m41Var;
        m41Var.setOnDismissListener(new e(this));
        this.a.setVisibility(0);
        setVisibility(0);
        this.d.g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet) {
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
    public NadRewardCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.g = -1;
        this.h = "奖励";
        this.i = "%2ss后可以领取" + this.h;
        this.j = "%2ss";
        this.k = 1;
        q(context);
    }
}
