package b.a.r0.x0.v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.x0.b1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.n1;
import b.a.r0.x0.v2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26482a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f26483b;

    /* renamed from: c  reason: collision with root package name */
    public List<n1> f26484c;

    /* renamed from: d  reason: collision with root package name */
    public View f26485d;

    /* renamed from: e  reason: collision with root package name */
    public View f26486e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f26487f;

    /* renamed from: g  reason: collision with root package name */
    public f f26488g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f26489h;

    /* loaded from: classes5.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26490a;

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
            this.f26490a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, n1 n1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, n1Var) == null) {
                if (this.f26490a.f26488g != null) {
                    this.f26490a.f26488g.d();
                }
                this.f26490a.f26483b.a(n1Var.f25998b);
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
        this.f26489h = new a(this);
    }

    @Override // b.a.r0.x0.v2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f26482a = context;
        this.f26488g = fVar;
        this.f26483b = fVar.e();
        View inflate = LayoutInflater.from(this.f26482a).inflate(f1.tab_menu_multline_view, (ViewGroup) null);
        this.f26485d = inflate;
        this.f26486e = inflate.findViewById(e1.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f26485d.findViewById(e1.categorycontainer);
        this.f26487f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f26489h);
    }

    @Override // b.a.r0.x0.v2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f26485d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f26485d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.v2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f26485d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, b1.CAM_X0201);
                SkinManager.setBackgroundColor(this.f26486e, b1.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f26487f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // b.a.r0.x0.v2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26485d : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.v2.b
    public void setData(List<n1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f26484c = list;
        n1 n1Var = new n1();
        n1Var.f25998b = 0;
        n1Var.f25997a = this.f26482a.getResources().getString(h1.all);
        n1Var.f25999c = false;
        SkinManager.setBackgroundColor(this.f26485d, b1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f26486e, b1.CAM_X0204);
        this.f26487f.setData(this.f26484c, n1Var);
    }
}
