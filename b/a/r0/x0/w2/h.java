package b.a.r0.x0.w2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.x0.c1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
import b.a.r0.x0.o1;
import b.a.r0.x0.w2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f28082a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f28083b;

    /* renamed from: c  reason: collision with root package name */
    public List<o1> f28084c;

    /* renamed from: d  reason: collision with root package name */
    public View f28085d;

    /* renamed from: e  reason: collision with root package name */
    public View f28086e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f28087f;

    /* renamed from: g  reason: collision with root package name */
    public f f28088g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f28089h;

    /* loaded from: classes6.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f28090a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28090a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, o1 o1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, o1Var) == null) {
                if (this.f28090a.f28088g != null) {
                    this.f28090a.f28088g.d();
                }
                this.f28090a.f28083b.a(o1Var.f27597b);
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28089h = new a(this);
    }

    @Override // b.a.r0.x0.w2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f28082a = context;
        this.f28088g = fVar;
        this.f28083b = fVar.e();
        View inflate = LayoutInflater.from(this.f28082a).inflate(g1.tab_menu_multline_view, (ViewGroup) null);
        this.f28085d = inflate;
        this.f28086e = inflate.findViewById(f1.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f28085d.findViewById(f1.categorycontainer);
        this.f28087f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f28089h);
    }

    @Override // b.a.r0.x0.w2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f28085d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f28085d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.w2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f28085d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, c1.CAM_X0201);
                SkinManager.setBackgroundColor(this.f28086e, c1.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f28087f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // b.a.r0.x0.w2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28085d : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.w2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f28084c = list;
        o1 o1Var = new o1();
        o1Var.f27597b = 0;
        o1Var.f27596a = this.f28082a.getResources().getString(i1.all);
        o1Var.f27598c = false;
        SkinManager.setBackgroundColor(this.f28085d, c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f28086e, c1.CAM_X0204);
        this.f28087f.setData(this.f28084c, o1Var);
    }
}
