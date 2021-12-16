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
import c.a.g0.g;
import c.a.g0.h;
import c.a.g0.i;
import c.a.g0.s.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class HostMarketView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f39009e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39010f;

    /* renamed from: g  reason: collision with root package name */
    public SwitchButton f39011g;

    /* renamed from: h  reason: collision with root package name */
    public PayChannelEntity f39012h;

    /* renamed from: i  reason: collision with root package name */
    public c f39013i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39014j;

    /* loaded from: classes10.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f39015e;

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
            this.f39015e = hostMarketView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f39015e.g(z);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.a.g0.s.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HostMarketView a;

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
            this.a = hostMarketView;
        }

        @Override // c.a.g0.s.e.a
        public void a(a.C0118a c0118a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0118a) == null) {
                this.a.f39013i.b(c0118a);
                if (c0118a == null) {
                    return;
                }
                if (c0118a.a != 0) {
                    this.a.f39011g.toggleNoEvent();
                    Toast.makeText(this.a.getContext(), this.a.getResources().getString(i.host_market_calculate_error), 0).show();
                }
                this.a.f39012h.setIsSelected(this.a.f39011g.isChecked() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(boolean z, PayChannelEntity payChannelEntity, c.a.g0.s.e.a aVar);

        void b(a.C0118a c0118a);
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
            this.f39009e = (TextView) findViewById(g.title);
            this.f39010f = (TextView) findViewById(g.subtitle);
            SwitchButton switchButton = (SwitchButton) findViewById(g.switch_button);
            this.f39011g = switchButton;
            switchButton.setOnCheckedChangeListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f39012h == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f39009e.setText(this.f39012h.getDisplayName());
            this.f39010f.setText(this.f39012h.getPayText());
            if (!TextUtils.isEmpty(this.f39012h.getDisplayColor())) {
                try {
                    this.f39010f.setTextColor(Color.parseColor(this.f39012h.getDisplayColor()));
                } catch (Exception unused) {
                }
            }
            if (this.f39014j) {
                this.f39011g.setVisibility(4);
                return;
            }
            this.f39011g.setVisibility(0);
            if (this.f39012h.getIsSelected() == 1) {
                this.f39011g.setChecked(true);
            } else {
                this.f39011g.setChecked(false);
            }
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f39013i == null) {
            return;
        }
        this.f39012h.setIsSelected(this.f39011g.isChecked() ? 1 : 0);
        this.f39013i.a(z, this.f39012h, new b(this));
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f39013i = cVar;
        }
    }

    public void update(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, payChannelEntity) == null) {
            this.f39012h = payChannelEntity;
            if (payChannelEntity != null) {
                this.f39014j = payChannelEntity.getIsSelected() == 1;
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
        this.f39014j = false;
        e(context);
    }
}
