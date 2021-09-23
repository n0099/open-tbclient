package com.baidu.poly.widget.hostmarket;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import c.a.e0.f;
import c.a.e0.g;
import c.a.e0.h;
import c.a.e0.k.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes5.dex */
public class HostMarketView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44456e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44457f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44458g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44459h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f44460i;

    /* renamed from: j  reason: collision with root package name */
    public o f44461j;
    public a k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, o oVar, c.a.e0.k.j.a aVar);

        void b(a.C0062a c0062a);
    }

    /* loaded from: classes5.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f44462e;

        public b(HostMarketView hostMarketView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hostMarketView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44462e = hostMarketView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f44462e.g(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.e0.k.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f44463a;

        public c(HostMarketView hostMarketView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hostMarketView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44463a = hostMarketView;
        }

        @Override // c.a.e0.k.j.a
        public void a(a.C0062a c0062a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0062a) == null) {
                this.f44463a.k.b(c0062a);
                if (c0062a == null) {
                    return;
                }
                if (c0062a.f3225a == 0) {
                    if (this.f44463a.f44460i.isChecked()) {
                        this.f44463a.f44459h.setVisibility(0);
                    } else {
                        this.f44463a.f44459h.setVisibility(4);
                    }
                } else {
                    this.f44463a.f44460i.o();
                    Toast.makeText(this.f44463a.getContext(), this.f44463a.getResources().getString(h.host_market_calculate_error), 0).show();
                }
                this.f44463a.f44461j.i(this.f44463a.f44460i.isChecked() ? 1 : 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HostMarketView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(g.hostmarket_item, (ViewGroup) this, true);
            this.f44456e = (ImageView) findViewById(f.icon);
            this.f44457f = (TextView) findViewById(f.title);
            this.f44458g = (TextView) findViewById(f.subtitle);
            this.f44459h = (TextView) findViewById(f.cut_text);
            SwitchButton switchButton = (SwitchButton) findViewById(f.switch_button);
            this.f44460i = switchButton;
            switchButton.setOnCheckedChangeListener(new b(this));
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.k == null) {
            return;
        }
        this.f44461j.i(this.f44460i.isChecked() ? 1 : 0);
        this.k.a(z, this.f44461j, new c(this));
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f44461j == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            c.a.e0.k.d.b.c().b(this.f44456e, this.f44461j.getIcon());
            this.f44457f.setText(this.f44461j.getDisplayName());
            this.f44458g.setText(this.f44461j.S());
            if (!TextUtils.isEmpty(this.f44461j.M())) {
                try {
                    this.f44458g.setTextColor(Color.parseColor(this.f44461j.M()));
                } catch (Exception unused) {
                }
            }
            if (this.l) {
                this.f44460i.setVisibility(4);
                this.f44459h.setVisibility(0);
                TextView textView = this.f44459h;
                textView.setText("-" + b(this.f44461j.L()) + "元");
                return;
            }
            this.f44460i.setVisibility(0);
            this.f44459h.setVisibility(4);
            if (this.f44461j.P() == 1) {
                this.f44460i.setChecked(true);
            } else {
                this.f44460i.setChecked(false);
            }
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.k = aVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            this.f44461j = oVar;
            if (oVar != null) {
                this.l = oVar.P() == 1;
            }
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HostMarketView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = false;
        f(context);
    }
}
