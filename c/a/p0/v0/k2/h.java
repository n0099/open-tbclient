package c.a.p0.v0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.v0.d1;
import c.a.p0.v0.k2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26028a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f26029b;

    /* renamed from: c  reason: collision with root package name */
    public List<d1> f26030c;

    /* renamed from: d  reason: collision with root package name */
    public View f26031d;

    /* renamed from: e  reason: collision with root package name */
    public View f26032e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f26033f;

    /* renamed from: g  reason: collision with root package name */
    public f f26034g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f26035h;

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26036a;

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
            this.f26036a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d1 d1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, d1Var) == null) {
                if (this.f26036a.f26034g != null) {
                    this.f26036a.f26034g.d();
                }
                this.f26036a.f26029b.a(d1Var.f25576b);
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
        this.f26035h = new a(this);
    }

    @Override // c.a.p0.v0.k2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f26028a = context;
        this.f26034g = fVar;
        this.f26029b = fVar.e();
        View inflate = LayoutInflater.from(this.f26028a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f26031d = inflate;
        this.f26032e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f26031d.findViewById(R.id.categorycontainer);
        this.f26033f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f26035h);
    }

    @Override // c.a.p0.v0.k2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f26031d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f26031d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.v0.k2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f26031d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.f26032e, R.color.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f26033f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // c.a.p0.v0.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26031d : (View) invokeV.objValue;
    }

    @Override // c.a.p0.v0.k2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f26030c = list;
        d1 d1Var = new d1();
        d1Var.f25576b = 0;
        d1Var.f25575a = this.f26028a.getResources().getString(R.string.all);
        d1Var.f25577c = false;
        SkinManager.setBackgroundColor(this.f26031d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f26032e, R.color.CAM_X0204);
        this.f26033f.setData(this.f26030c, d1Var);
    }
}
