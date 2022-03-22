package c.a.p0.f0.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c implements b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f13823b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f13824c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f13825d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13826e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13827f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f13828g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13829h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public RelativeLayout l;
    public RelativeLayout m;
    public a n;
    public float o;
    public float p;

    public c(TbPageContext tbPageContext, int i, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13823b = tbPageContext;
        this.n = aVar;
        float f2 = (i * 1.0f) / i2;
        this.a = f2;
        this.o = f2;
        this.p = 0.0f;
        a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904aa);
            this.f13824c = linearLayout;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(linearLayout);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0214);
            this.f13825d = (ImageView) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919c2);
            this.i = (RelativeLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919c3);
            this.f13828g = (ImageView) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919c0);
            this.l = (RelativeLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919c1);
            this.f13827f = (ImageView) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919be);
            this.k = (RelativeLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919bf);
            this.f13826e = (ImageView) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919ba);
            this.j = (RelativeLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919bb);
            this.f13829h = (ImageView) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919bc);
            this.m = (RelativeLayout) this.f13823b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919bd);
            g();
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.m.setOnClickListener(this);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.b.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13824c.getVisibility() : invokeV.intValue;
    }

    @Override // c.a.p0.f0.b.b
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f13824c.setVisibility(i);
        }
    }

    @Override // c.a.p0.f0.b.b
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.i.setVisibility(i);
            if (i == 8) {
                this.p = 1.7777778f;
                f(1.7777778f);
            }
        }
    }

    @Override // c.a.p0.f0.b.b
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.floatValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.o = f2;
            a aVar = this.n;
            if (aVar != null) {
                aVar.a(f2);
            }
            g();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f13825d.setImageDrawable(this.f13823b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08097b));
            this.f13828g.setImageDrawable(this.f13823b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08097a));
            this.f13827f.setImageDrawable(this.f13823b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080979));
            this.f13826e.setImageDrawable(this.f13823b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080977));
            this.f13829h.setImageDrawable(this.f13823b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080978));
            float f2 = this.p;
            if (f2 == 0.0f) {
                this.f13825d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097b, this.f13823b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.7777778f) {
                this.f13828g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097a, this.f13823b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.3333334f) {
                this.f13827f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080979, this.f13823b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 0.5625f) {
                this.f13826e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080977, this.f13823b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.0f) {
                this.f13829h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080978, this.f13823b.getResources().getColor(R.color.CAM_X0302), null));
            }
        }
    }

    @Override // c.a.p0.f0.b.b
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.floatValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f0919c3) {
                this.p = 0.0f;
                f(this.a);
            } else if (view.getId() == R.id.obfuscated_res_0x7f0919c1) {
                this.p = 1.7777778f;
                f(1.7777778f);
            } else if (view.getId() == R.id.obfuscated_res_0x7f0919bf) {
                this.p = 1.3333334f;
                f(1.3333334f);
            } else if (view.getId() == R.id.obfuscated_res_0x7f0919bb) {
                this.p = 0.5625f;
                f(0.5625f);
            } else if (view.getId() == R.id.obfuscated_res_0x7f0919bd) {
                this.p = 1.0f;
                f(1.0f);
            }
        }
    }

    @Override // c.a.p0.f0.b.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.p = 0.0f;
            f(this.a);
        }
    }

    public c(TbPageContext tbPageContext, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13823b = tbPageContext;
        this.n = aVar;
        this.a = 1.7777778f;
        this.o = 1.7777778f;
        this.p = 0.0f;
        a();
    }
}
