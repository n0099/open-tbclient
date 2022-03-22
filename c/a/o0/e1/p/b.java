package c.a.o0.e1.p;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
/* loaded from: classes2.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f10192b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f10193c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10194d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f10195e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10196f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10197g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10198h;
    public TextView i;
    public ImageView j;
    public ProgressButton k;
    public final TiePlusHelper l;
    public final boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public c r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.l.onClick(view);
                if (this.a.r != null) {
                    this.a.r.a();
                }
            }
        }
    }

    /* renamed from: c.a.o0.e1.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0803b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC0803b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, TiePlusHelper tiePlusHelper, boolean z) {
        super(context, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tiePlusHelper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = tiePlusHelper;
        this.m = z;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int k = n.k(getContext());
            if (k < 975.0d) {
                return 759;
            }
            return (k * 322) / 414;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10192b = findViewById(R.id.obfuscated_res_0x7f0907e1);
            this.f10193c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090288);
            this.f10194d = (TextView) findViewById(R.id.obfuscated_res_0x7f090293);
            this.f10195e = (TextView) findViewById(R.id.obfuscated_res_0x7f090294);
            this.f10196f = (TextView) findViewById(R.id.obfuscated_res_0x7f090283);
            this.f10197g = (TextView) findViewById(R.id.obfuscated_res_0x7f09028e);
            this.f10198h = (TextView) findViewById(R.id.obfuscated_res_0x7f09028f);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09081a);
            this.k = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f090817);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f09248c);
            this.f10193c.setPlaceHolder(2);
            this.f10193c.setConrers(15);
            e();
            this.f10198h.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.f10197g.setTag((byte) 17);
            this.i.setTag((byte) 18);
            if (!StringUtils.isNull(this.n)) {
                this.f10194d.setText(this.n);
            }
            if (!StringUtils.isNull(this.q)) {
                this.f10193c.J(this.q, 10, false);
            }
            if (!StringUtils.isNull(this.o)) {
                this.f10195e.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0290), this.o));
            }
            if (!StringUtils.isNull(this.p)) {
                this.f10196f.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f04cf), this.p));
            }
            this.f10197g.setOnClickListener(this.l);
            this.f10198h.setOnClickListener(this.l);
            this.i.setOnClickListener(this.l);
            this.k.setOnClickListener(new a(this));
            this.k.setUseLongText(true);
            this.j.setOnClickListener(new View$OnClickListenerC0803b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.a);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f10194d);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            c.a.o0.r.v.c.d(this.f10195e).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.f10196f).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.f10197g).v(R.color.CAM_X0304);
            c.a.o0.r.v.c.d(this.f10198h).v(R.color.CAM_X0304);
            c.a.o0.r.v.c.d(this.i).v(R.color.CAM_X0107);
            c.a.o0.r.v.c.d(this.f10192b).f(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f0808f7, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.k.i();
        }
    }

    public b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.r = cVar;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.l.f(this.k);
            if (this.m) {
                MessageManager.getInstance().registerListener(this.l);
            }
            if (StringUtils.isNull(this.l.p()) || StringUtils.isNull(this.l.m())) {
                return;
            }
            TiePlusHelper tiePlusHelper = this.l;
            tiePlusHelper.Y(tiePlusHelper.p(), this.l.m(), getContext(), this.k);
            TiePlusHelper tiePlusHelper2 = this.l;
            tiePlusHelper2.X(tiePlusHelper2.p(), getContext(), this.i);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d083a, (ViewGroup) null);
            this.a = inflate;
            setContentView(inflate);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = c();
            getWindow().setAttributes(attributes);
            d();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            this.l.B(this.k);
            if (this.m) {
                MessageManager.getInstance().unRegisterListener(this.l);
            }
        }
    }
}
