package com.baidu.poly.widget.hostmarket;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.i;
import b.a.e0.s.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HostMarketView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43087e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43088f;

    /* renamed from: g  reason: collision with root package name */
    public SwitchButton f43089g;

    /* renamed from: h  reason: collision with root package name */
    public PayChannelEntity f43090h;

    /* renamed from: i  reason: collision with root package name */
    public c f43091i;
    public boolean j;

    /* loaded from: classes7.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f43092e;

        public a(HostMarketView hostMarketView) {
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
            this.f43092e = hostMarketView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f43092e.g(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b.a.e0.s.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f43093a;

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
            this.f43093a = hostMarketView;
        }

        @Override // b.a.e0.s.e.a
        public void a(a.C0057a c0057a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0057a) == null) {
                this.f43093a.f43091i.b(c0057a);
                if (c0057a == null) {
                    return;
                }
                if (c0057a.f2753a != 0) {
                    this.f43093a.f43089g.toggleNoEvent();
                    Toast.makeText(this.f43093a.getContext(), this.f43093a.getResources().getString(i.host_market_calculate_error), 0).show();
                }
                this.f43093a.f43090h.setIsSelected(this.f43093a.f43089g.isChecked() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z, PayChannelEntity payChannelEntity, b.a.e0.s.e.a aVar);

        void b(a.C0057a c0057a);
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

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(h.hostmarket_item, (ViewGroup) this, true);
            this.f43087e = (TextView) findViewById(g.title);
            this.f43088f = (TextView) findViewById(g.subtitle);
            SwitchButton switchButton = (SwitchButton) findViewById(g.switch_button);
            this.f43089g = switchButton;
            switchButton.setOnCheckedChangeListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f43090h == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f43087e.setText(this.f43090h.getDisplayName());
            this.f43088f.setText(this.f43090h.getPayText());
            if (!TextUtils.isEmpty(this.f43090h.getDisplayColor())) {
                try {
                    this.f43088f.setTextColor(Color.parseColor(this.f43090h.getDisplayColor()));
                } catch (Exception unused) {
                }
            }
            if (this.j) {
                this.f43089g.setVisibility(4);
                return;
            }
            this.f43089g.setVisibility(0);
            if (this.f43090h.getIsSelected() == 1) {
                this.f43089g.setChecked(true);
            } else {
                this.f43089g.setChecked(false);
            }
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f43091i == null) {
            return;
        }
        this.f43090h.setIsSelected(this.f43089g.isChecked() ? 1 : 0);
        this.f43091i.a(z, this.f43090h, new b(this));
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f43091i = cVar;
        }
    }

    public void update(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, payChannelEntity) == null) {
            this.f43090h = payChannelEntity;
            if (payChannelEntity != null) {
                this.j = payChannelEntity.getIsSelected() == 1;
            }
            f();
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
        this.j = false;
        e(context);
    }
}
