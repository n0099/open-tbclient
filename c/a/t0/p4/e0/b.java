package c.a.t0.p4.e0;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.k0.g f21106b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21107e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21107e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21107e.a();
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void a() {
        c.a.t0.k0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f21106b) == null) {
            return;
        }
        gVar.I();
    }

    public void b(View view) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (tbPageContext = this.a) == null || view == null) {
            return;
        }
        if (this.f21106b == null) {
            c.a.t0.k0.g gVar = new c.a.t0.k0.g(tbPageContext, view);
            this.f21106b = gVar;
            gVar.g0(c.a.t0.p4.f.pic_sign_tip_down);
            this.f21106b.S(1);
            this.f21106b.O(32);
            this.f21106b.L(2);
            this.f21106b.V(false);
            this.f21106b.M(new a(this));
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(c.a.t0.p4.e.ds10);
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(c.a.t0.p4.e.ds24);
            int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(c.a.t0.p4.e.tbds44);
            int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(c.a.t0.p4.e.tbds50);
            int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(c.a.t0.p4.e.tbds6);
            this.f21106b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f21106b.j0(-dimensionPixelSize4);
            this.f21106b.k0(-dimensionPixelSize5);
            this.f21106b.N(3000);
        }
        String string = this.a.getResources().getString(c.a.t0.p4.j.write_activity_tip_content);
        this.f21106b.Y(c.a.t0.p4.f.icon_pure_guide_haowu16);
        this.f21106b.R(true);
        this.f21106b.m0(string, "commodity_tip_show_controller");
    }
}
