package c.a.r0.x0.l2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.x0.d1;
import c.a.r0.x0.l2.f;
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
    public Context f27226a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f27227b;

    /* renamed from: c  reason: collision with root package name */
    public List<d1> f27228c;

    /* renamed from: d  reason: collision with root package name */
    public View f27229d;

    /* renamed from: e  reason: collision with root package name */
    public View f27230e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f27231f;

    /* renamed from: g  reason: collision with root package name */
    public f f27232g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f27233h;

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f27234a;

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
            this.f27234a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d1 d1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, d1Var) == null) {
                if (this.f27234a.f27232g != null) {
                    this.f27234a.f27232g.d();
                }
                this.f27234a.f27227b.a(d1Var.f26741b);
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
        this.f27233h = new a(this);
    }

    @Override // c.a.r0.x0.l2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f27226a = context;
        this.f27232g = fVar;
        this.f27227b = fVar.e();
        View inflate = LayoutInflater.from(this.f27226a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f27229d = inflate;
        this.f27230e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f27229d.findViewById(R.id.categorycontainer);
        this.f27231f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f27233h);
    }

    @Override // c.a.r0.x0.l2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f27229d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f27229d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.x0.l2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f27229d;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.f27230e, R.color.CAM_X0204);
            }
            TabMenuPopView tabMenuPopView = this.f27231f;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    @Override // c.a.r0.x0.l2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27229d : (View) invokeV.objValue;
    }

    @Override // c.a.r0.x0.l2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f27228c = list;
        d1 d1Var = new d1();
        d1Var.f26741b = 0;
        d1Var.f26740a = this.f27226a.getResources().getString(R.string.all);
        d1Var.f26742c = false;
        SkinManager.setBackgroundColor(this.f27229d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f27230e, R.color.CAM_X0204);
        this.f27231f.setData(this.f27228c, d1Var);
    }
}
