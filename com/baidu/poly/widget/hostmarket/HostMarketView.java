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
import c.a.f0.g;
import c.a.f0.h;
import c.a.f0.i;
import c.a.f0.s.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HostMarketView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38520e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38521f;

    /* renamed from: g  reason: collision with root package name */
    public SwitchButton f38522g;

    /* renamed from: h  reason: collision with root package name */
    public PayChannelEntity f38523h;

    /* renamed from: i  reason: collision with root package name */
    public c f38524i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f38525j;

    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HostMarketView f38526e;

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
            this.f38526e = hostMarketView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                this.f38526e.g(z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.a.f0.s.e.a {
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

        @Override // c.a.f0.s.e.a
        public void a(a.C0116a c0116a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0116a) == null) {
                this.a.f38524i.b(c0116a);
                if (c0116a == null) {
                    return;
                }
                if (c0116a.a != 0) {
                    this.a.f38522g.toggleNoEvent();
                    Toast.makeText(this.a.getContext(), this.a.getResources().getString(i.host_market_calculate_error), 0).show();
                }
                this.a.f38523h.setIsSelected(this.a.f38522g.isChecked() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(boolean z, PayChannelEntity payChannelEntity, c.a.f0.s.e.a aVar);

        void b(a.C0116a c0116a);
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
            this.f38520e = (TextView) findViewById(g.title);
            this.f38521f = (TextView) findViewById(g.subtitle);
            SwitchButton switchButton = (SwitchButton) findViewById(g.switch_button);
            this.f38522g = switchButton;
            switchButton.setOnCheckedChangeListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f38523h == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f38520e.setText(this.f38523h.getDisplayName());
            this.f38521f.setText(this.f38523h.getPayText());
            if (!TextUtils.isEmpty(this.f38523h.getDisplayColor())) {
                try {
                    this.f38521f.setTextColor(Color.parseColor(this.f38523h.getDisplayColor()));
                } catch (Exception unused) {
                }
            }
            if (this.f38525j) {
                this.f38522g.setVisibility(4);
                return;
            }
            this.f38522g.setVisibility(0);
            if (this.f38523h.getIsSelected() == 1) {
                this.f38522g.setChecked(true);
            } else {
                this.f38522g.setChecked(false);
            }
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f38524i == null) {
            return;
        }
        this.f38523h.setIsSelected(this.f38522g.isChecked() ? 1 : 0);
        this.f38524i.a(z, this.f38523h, new b(this));
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f38524i = cVar;
        }
    }

    public void update(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, payChannelEntity) == null) {
            this.f38523h = payChannelEntity;
            if (payChannelEntity != null) {
                this.f38525j = payChannelEntity.getIsSelected() == 1;
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
        this.f38525j = false;
        e(context);
    }
}
