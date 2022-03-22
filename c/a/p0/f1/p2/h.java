package c.a.p0.f1.p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.f1.e1;
import c.a.p0.f1.p2.f;
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
    public f.e f14403b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f14404c;

    /* renamed from: d  reason: collision with root package name */
    public View f14405d;

    /* renamed from: e  reason: collision with root package name */
    public View f14406e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f14407f;

    /* renamed from: g  reason: collision with root package name */
    public f f14408g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f14409h;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.f14408g != null) {
                    this.a.f14408g.c();
                }
                this.a.f14403b.a(e1Var.f13939b);
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14409h = new a(this);
    }

    @Override // c.a.p0.f1.p2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.a = context;
        this.f14408g = fVar;
        this.f14403b = fVar.d();
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07f9, (ViewGroup) null);
        this.f14405d = inflate;
        this.f14406e = inflate.findViewById(R.id.obfuscated_res_0x7f0920c0);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f14405d.findViewById(R.id.obfuscated_res_0x7f0905a4);
        this.f14407f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f14409h);
    }

    @Override // c.a.p0.f1.p2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f14405d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f14405d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.p2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14405d : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.p2.b
    public void setData(List<e1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f14404c = list;
        e1 e1Var = new e1();
        e1Var.f13939b = 0;
        e1Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f025f);
        e1Var.f13940c = false;
        SkinManager.setBackgroundColor(this.f14405d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f14406e, R.color.CAM_X0204);
        this.f14407f.setData(this.f14404c, e1Var);
    }
}
