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
import b.a.e0.f;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.k.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class HostMarketView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42126e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42127f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42128g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42129h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f42130i;
    public o j;
    public a k;
    public boolean l;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, o oVar, b.a.e0.k.j.a aVar);

        void b(a.C0057a c0057a);
    }

    /* loaded from: classes7.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f42131e;

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
            this.f42131e = hostMarketView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f42131e.g(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements b.a.e0.k.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f42132a;

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
            this.f42132a = hostMarketView;
        }

        @Override // b.a.e0.k.j.a
        public void a(a.C0057a c0057a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0057a) == null) {
                this.f42132a.k.b(c0057a);
                if (c0057a == null) {
                    return;
                }
                if (c0057a.f2673a == 0) {
                    if (this.f42132a.f42130i.isChecked()) {
                        this.f42132a.f42129h.setVisibility(0);
                    } else {
                        this.f42132a.f42129h.setVisibility(4);
                    }
                } else {
                    this.f42132a.f42130i.o();
                    Toast.makeText(this.f42132a.getContext(), this.f42132a.getResources().getString(h.host_market_calculate_error), 0).show();
                }
                this.f42132a.j.i(this.f42132a.f42130i.isChecked() ? 1 : 0);
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

    public final String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new DecimalFormat("0.00").format((j * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(g.hostmarket_item, (ViewGroup) this, true);
            this.f42126e = (ImageView) findViewById(f.icon);
            this.f42127f = (TextView) findViewById(f.title);
            this.f42128g = (TextView) findViewById(f.subtitle);
            this.f42129h = (TextView) findViewById(f.cut_text);
            SwitchButton switchButton = (SwitchButton) findViewById(f.switch_button);
            this.f42130i = switchButton;
            switchButton.setOnCheckedChangeListener(new b(this));
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.k == null) {
            return;
        }
        this.j.i(this.f42130i.isChecked() ? 1 : 0);
        this.k.a(z, this.j, new c(this));
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.j == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            b.a.e0.k.d.b.c().b(this.f42126e, this.j.getIcon());
            this.f42127f.setText(this.j.getDisplayName());
            this.f42128g.setText(this.j.S());
            if (!TextUtils.isEmpty(this.j.M())) {
                try {
                    this.f42128g.setTextColor(Color.parseColor(this.j.M()));
                } catch (Exception unused) {
                }
            }
            if (this.l) {
                this.f42130i.setVisibility(4);
                this.f42129h.setVisibility(0);
                TextView textView = this.f42129h;
                textView.setText("-" + b(this.j.L()) + "元");
                return;
            }
            this.f42130i.setVisibility(0);
            this.f42129h.setVisibility(4);
            if (this.j.P() == 1) {
                this.f42130i.setChecked(true);
            } else {
                this.f42130i.setChecked(false);
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
            this.j = oVar;
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
