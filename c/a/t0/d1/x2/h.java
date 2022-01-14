package c.a.t0.d1.x2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.d1.c1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.d1.o1;
import c.a.t0.d1.x2.f;
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
    public f.e f16791b;

    /* renamed from: c  reason: collision with root package name */
    public List<o1> f16792c;

    /* renamed from: d  reason: collision with root package name */
    public View f16793d;

    /* renamed from: e  reason: collision with root package name */
    public View f16794e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f16795f;

    /* renamed from: g  reason: collision with root package name */
    public f f16796g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f16797h;

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
                if (this.a.f16796g != null) {
                    this.a.f16796g.d();
                }
                this.a.f16791b.a(o1Var.f16351b);
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
        this.f16797h = new a(this);
    }

    @Override // c.a.t0.d1.x2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.a = context;
        this.f16796g = fVar;
        this.f16791b = fVar.e();
        View inflate = LayoutInflater.from(this.a).inflate(g1.tab_menu_multline_view, (ViewGroup) null);
        this.f16793d = inflate;
        this.f16794e = inflate.findViewById(f1.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f16793d.findViewById(f1.categorycontainer);
        this.f16795f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f16797h);
    }

    @Override // c.a.t0.d1.x2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f16793d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f16793d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.d1.x2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f16793d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, c1.CAM_X0201);
                SkinManager.setBackgroundColor(this.f16794e, c1.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f16795f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // c.a.t0.d1.x2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16793d : (View) invokeV.objValue;
    }

    @Override // c.a.t0.d1.x2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f16792c = list;
        o1 o1Var = new o1();
        o1Var.f16351b = 0;
        o1Var.a = this.a.getResources().getString(i1.all);
        o1Var.f16352c = false;
        SkinManager.setBackgroundColor(this.f16793d, c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f16794e, c1.CAM_X0204);
        this.f16795f.setData(this.f16792c, o1Var);
    }
}
