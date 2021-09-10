package c.a.r0.y.b;

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
/* loaded from: classes4.dex */
public class c implements b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f29202e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f29203f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f29204g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f29205h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f29206i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f29207j;
    public ImageView k;
    public ImageView l;
    public RelativeLayout m;
    public RelativeLayout n;
    public RelativeLayout o;
    public RelativeLayout p;
    public RelativeLayout q;
    public a r;
    public float s;
    public float t;

    public c(TbPageContext tbPageContext, int i2, int i3, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), Integer.valueOf(i3), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29203f = tbPageContext;
        this.r = aVar;
        float f2 = (i2 * 1.0f) / i3;
        this.f29202e = f2;
        this.s = f2;
        this.t = 0.0f;
        a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f29203f.getPageActivity().findViewById(R.id.capture_ratio_container);
            this.f29204g = linearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(linearLayout);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0214);
            this.f29205h = (ImageView) this.f29203f.getPageActivity().findViewById(R.id.ratio_original);
            this.m = (RelativeLayout) this.f29203f.getPageActivity().findViewById(R.id.ratio_original_container);
            this.k = (ImageView) this.f29203f.getPageActivity().findViewById(R.id.ratio_9_16);
            this.p = (RelativeLayout) this.f29203f.getPageActivity().findViewById(R.id.ratio_9_16_container);
            this.f29207j = (ImageView) this.f29203f.getPageActivity().findViewById(R.id.ratio_3_4);
            this.o = (RelativeLayout) this.f29203f.getPageActivity().findViewById(R.id.ratio_3_4_container);
            this.f29206i = (ImageView) this.f29203f.getPageActivity().findViewById(R.id.ratio_16_9);
            this.n = (RelativeLayout) this.f29203f.getPageActivity().findViewById(R.id.ratio_16_9_container);
            this.l = (ImageView) this.f29203f.getPageActivity().findViewById(R.id.ratio_1_1);
            this.q = (RelativeLayout) this.f29203f.getPageActivity().findViewById(R.id.ratio_1_1_container);
            g();
            this.m.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.q.setOnClickListener(this);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.y.b.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29204g.getVisibility() : invokeV.intValue;
    }

    @Override // c.a.r0.y.b.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f29204g.setVisibility(i2);
        }
    }

    @Override // c.a.r0.y.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.m.setVisibility(i2);
            if (i2 == 8) {
                this.t = 1.7777778f;
                f(1.7777778f);
            }
        }
    }

    @Override // c.a.r0.y.b.b
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.floatValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.s = f2;
            a aVar = this.r;
            if (aVar != null) {
                aVar.a(f2);
            }
            g();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29205h.setImageDrawable(this.f29203f.getResources().getDrawable(R.drawable.icon_pure_proportion_original));
            this.k.setImageDrawable(this.f29203f.getResources().getDrawable(R.drawable.icon_pure_proportion_9_16));
            this.f29207j.setImageDrawable(this.f29203f.getResources().getDrawable(R.drawable.icon_pure_proportion_3_4));
            this.f29206i.setImageDrawable(this.f29203f.getResources().getDrawable(R.drawable.icon_pure_proportion_16_9));
            this.l.setImageDrawable(this.f29203f.getResources().getDrawable(R.drawable.icon_pure_proportion_1_1));
            float f2 = this.t;
            if (f2 == 0.0f) {
                this.f29205h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_proportion_original, this.f29203f.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.7777778f) {
                this.k.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_proportion_9_16, this.f29203f.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.3333334f) {
                this.f29207j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_proportion_3_4, this.f29203f.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 0.5625f) {
                this.f29206i.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_proportion_16_9, this.f29203f.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f2 == 1.0f) {
                this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_proportion_1_1, this.f29203f.getResources().getColor(R.color.CAM_X0302), null));
            }
        }
    }

    @Override // c.a.r0.y.b.b
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : invokeV.floatValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view.getId() == R.id.ratio_original_container) {
                this.t = 0.0f;
                f(this.f29202e);
            } else if (view.getId() == R.id.ratio_9_16_container) {
                this.t = 1.7777778f;
                f(1.7777778f);
            } else if (view.getId() == R.id.ratio_3_4_container) {
                this.t = 1.3333334f;
                f(1.3333334f);
            } else if (view.getId() == R.id.ratio_16_9_container) {
                this.t = 0.5625f;
                f(0.5625f);
            } else if (view.getId() == R.id.ratio_1_1_container) {
                this.t = 1.0f;
                f(1.0f);
            }
        }
    }

    @Override // c.a.r0.y.b.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.t = 0.0f;
            f(this.f29202e);
        }
    }

    public c(TbPageContext tbPageContext, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29203f = tbPageContext;
        this.r = aVar;
        this.f29202e = 1.7777778f;
        this.s = 1.7777778f;
        this.t = 0.0f;
        a();
    }
}
