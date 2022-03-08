package c.a.r0.d1.p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.d1.e1;
import c.a.r0.d1.p2.f;
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
/* loaded from: classes2.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f16073b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f16074c;

    /* renamed from: d  reason: collision with root package name */
    public View f16075d;

    /* renamed from: e  reason: collision with root package name */
    public View f16076e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f16077f;

    /* renamed from: g  reason: collision with root package name */
    public f f16078g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f16079h;

    /* loaded from: classes2.dex */
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
        public void a(View view, e1 e1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, e1Var) == null) {
                if (this.a.f16078g != null) {
                    this.a.f16078g.d();
                }
                this.a.f16073b.a(e1Var.f15466b);
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
        this.f16079h = new a(this);
    }

    @Override // c.a.r0.d1.p2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.a = context;
        this.f16078g = fVar;
        this.f16073b = fVar.e();
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f16075d = inflate;
        this.f16076e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f16075d.findViewById(R.id.categorycontainer);
        this.f16077f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f16079h);
    }

    @Override // c.a.r0.d1.p2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f16075d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f16075d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.p2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f16075d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.f16076e, R.color.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f16077f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // c.a.r0.d1.p2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16075d : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p2.b
    public void setData(List<e1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f16074c = list;
        e1 e1Var = new e1();
        e1Var.f15466b = 0;
        e1Var.a = this.a.getResources().getString(R.string.all);
        e1Var.f15467c = false;
        SkinManager.setBackgroundColor(this.f16075d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f16076e, R.color.CAM_X0204);
        this.f16077f.setData(this.f16074c, e1Var);
    }
}
