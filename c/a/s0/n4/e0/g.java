package c.a.s0.n4.e0;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.k0.g f20245b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20246e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20246e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20246e.f20245b.I();
            }
        }
    }

    public g(TbPageContext tbPageContext) {
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

    public void b() {
        c.a.s0.k0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f20245b) == null) {
            return;
        }
        gVar.I();
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View launcherForId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) || editorTools == null || (editorBar = editorTools.mEB) == null || this.a == null || (launcherForId = editorBar.getLauncherForId(26)) == null) {
            return;
        }
        if (this.f20245b == null) {
            c.a.s0.k0.g gVar = new c.a.s0.k0.g(this.a, launcherForId);
            this.f20245b = gVar;
            gVar.g0(c.a.s0.n4.f.bg_tip_blue_down);
            this.f20245b.O(32);
            this.f20245b.L(2);
            this.f20245b.M(new a(this));
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(c.a.s0.n4.e.ds10);
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(c.a.s0.n4.e.ds24);
            int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(c.a.s0.n4.e.ds4);
            this.f20245b.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f20245b.j0(0);
            this.f20245b.k0(-dimensionPixelSize3);
            this.f20245b.N(3000);
        }
        this.f20245b.m0(this.a.getResources().getString(c.a.s0.n4.j.hot_topic_tip), "key_show_hottopic_tip");
    }
}
