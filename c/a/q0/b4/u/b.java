package c.a.q0.b4.u;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f16396a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.e0.e f16397b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16398e;

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
            this.f16398e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16398e.a();
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
        this.f16396a = tbPageContext;
    }

    public void a() {
        c.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f16397b) == null) {
            return;
        }
        eVar.I();
    }

    public void b(View view) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (tbPageContext = this.f16396a) == null || view == null) {
            return;
        }
        if (this.f16397b == null) {
            c.a.q0.e0.e eVar = new c.a.q0.e0.e(tbPageContext, view);
            this.f16397b = eVar;
            eVar.g0(R.drawable.pic_sign_tip_down);
            this.f16397b.S(1);
            this.f16397b.O(32);
            this.f16397b.L(2);
            this.f16397b.V(false);
            this.f16397b.M(new a(this));
            int dimensionPixelSize = this.f16396a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f16396a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f16396a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f16396a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f16396a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f16397b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f16397b.j0(-dimensionPixelSize4);
            this.f16397b.k0(-dimensionPixelSize5);
            this.f16397b.N(3000);
        }
        String string = this.f16396a.getResources().getString(R.string.write_activity_tip_content);
        this.f16397b.Y(R.drawable.icon_pure_guide_haowu16);
        this.f16397b.R(true);
        this.f16397b.m0(string, "commodity_tip_show_controller");
    }
}
