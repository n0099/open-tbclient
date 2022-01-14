package c.a.t0.d1.r1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16433b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16434c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16435d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16436e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f16437f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f16438g;

    /* renamed from: h  reason: collision with root package name */
    public View f16439h;

    /* renamed from: i  reason: collision with root package name */
    public b f16440i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f16441j;
    public View.OnClickListener k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16442e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16442e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f16442e.f16437f.getId()) {
                    if (this.f16442e.f16433b.getPageActivity() != null) {
                        this.f16442e.f16433b.getPageActivity().finish();
                    }
                    this.f16442e.f(2);
                } else if (view.getId() == this.f16442e.f16438g.getId()) {
                    if (this.f16442e.f16441j != null) {
                        this.f16442e.f16441j.onClick(view);
                    }
                    this.f16442e.f(1);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.f16433b = tbPageContext;
        this.a = view;
        this.f16434c = (TextView) view.findViewById(f1.to_user_name);
        this.f16435d = (TextView) view.findViewById(f1.content);
        this.f16436e = (TextView) view.findViewById(f1.sender);
        this.f16437f = (TBSpecificationBtn) view.findViewById(f1.btn_known);
        c.a.s0.s.j0.n.c cVar = new c.a.s0.s.j0.n.c();
        cVar.p(c1.CAM_X0618);
        this.f16437f.setConfig(cVar);
        this.f16437f.setTextSize(d1.tbds42);
        this.f16437f.setText(tbPageContext.getString(i1.guide_popup_window_known));
        this.f16437f.setOnClickListener(this.k);
        this.f16438g = (TBSpecificationBtn) view.findViewById(f1.btn_share);
        c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
        bVar.p(c1.CAM_X0302, c1.CAM_X0101);
        this.f16438g.setConfig(bVar);
        this.f16438g.setTextSize(d1.tbds42);
        this.f16438g.setText(tbPageContext.getString(i1.go_to_share));
        this.f16438g.setOnClickListener(this.k);
        this.f16439h = view.findViewById(f1.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(c1.black_alpha100), tbPageContext.getResources().getColor(c1.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f16439h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f16440i = bVar2;
        bVar2.k();
        i();
        String str = this.f16440i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f16440i.f16427e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f16440i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f16440i.f16427e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f16434c, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16435d, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16436e, c1.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f16434c;
            textView.setText(this.f16440i.f16426d + ":");
            this.f16435d.setText(this.f16440i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f16436e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f16441j = onClickListener;
        }
    }
}
