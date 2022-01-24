package c.a.t0.e1.x2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.e1.c1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.e1.o1;
import c.a.t0.e1.x2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f17123b;

    /* renamed from: c  reason: collision with root package name */
    public List<o1> f17124c;

    /* renamed from: d  reason: collision with root package name */
    public View f17125d;

    /* renamed from: e  reason: collision with root package name */
    public View f17126e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f17127f;

    /* renamed from: g  reason: collision with root package name */
    public f f17128g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f17129h;

    /* loaded from: classes7.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, o1 o1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, o1Var) == null) {
                if (this.a.f17128g != null) {
                    this.a.f17128g.d();
                }
                this.a.f17123b.a(o1Var.f16683b);
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
        this.f17129h = new a(this);
    }

    @Override // c.a.t0.e1.x2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.a = context;
        this.f17128g = fVar;
        this.f17123b = fVar.e();
        View inflate = LayoutInflater.from(this.a).inflate(g1.tab_menu_multline_view, (ViewGroup) null);
        this.f17125d = inflate;
        this.f17126e = inflate.findViewById(f1.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f17125d.findViewById(f1.categorycontainer);
        this.f17127f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f17129h);
    }

    @Override // c.a.t0.e1.x2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f17125d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f17125d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.e1.x2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f17125d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, c1.CAM_X0201);
                SkinManager.setBackgroundColor(this.f17126e, c1.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f17127f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // c.a.t0.e1.x2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17125d : (View) invokeV.objValue;
    }

    @Override // c.a.t0.e1.x2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f17124c = list;
        o1 o1Var = new o1();
        o1Var.f16683b = 0;
        o1Var.a = this.a.getResources().getString(i1.all);
        o1Var.f16684c = false;
        SkinManager.setBackgroundColor(this.f17125d, c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f17126e, c1.CAM_X0204);
        this.f17127f.setData(this.f17124c, o1Var);
    }
}
