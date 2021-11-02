package b.a.r0.x0.p1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26047a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26048b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26049c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26050d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26051e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f26052f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f26053g;

    /* renamed from: h  reason: collision with root package name */
    public View f26054h;

    /* renamed from: i  reason: collision with root package name */
    public b f26055i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26056e;

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
            this.f26056e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f26056e.f26052f.getId()) {
                    if (this.f26056e.f26048b.getPageActivity() != null) {
                        this.f26056e.f26048b.getPageActivity().finish();
                    }
                    this.f26056e.f(2);
                } else if (view.getId() == this.f26056e.f26053g.getId()) {
                    if (this.f26056e.j != null) {
                        this.f26056e.j.onClick(view);
                    }
                    this.f26056e.f(1);
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
        this.f26048b = tbPageContext;
        this.f26047a = view;
        this.f26049c = (TextView) view.findViewById(e1.to_user_name);
        this.f26050d = (TextView) view.findViewById(e1.content);
        this.f26051e = (TextView) view.findViewById(e1.sender);
        this.f26052f = (TBSpecificationBtn) view.findViewById(e1.btn_known);
        b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
        cVar.p(b1.CAM_X0618);
        this.f26052f.setConfig(cVar);
        this.f26052f.setTextSize(c1.tbds42);
        this.f26052f.setText(tbPageContext.getString(h1.guide_popup_window_known));
        this.f26052f.setOnClickListener(this.k);
        this.f26053g = (TBSpecificationBtn) view.findViewById(e1.btn_share);
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
        bVar.p(b1.CAM_X0302, b1.CAM_X0101);
        this.f26053g.setConfig(bVar);
        this.f26053g.setTextSize(c1.tbds42);
        this.f26053g.setText(tbPageContext.getString(h1.go_to_share));
        this.f26053g.setOnClickListener(this.k);
        this.f26054h = view.findViewById(e1.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(b1.black_alpha100), tbPageContext.getResources().getColor(b1.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f26054h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f26055i = bVar2;
        bVar2.k();
        i();
        String str = this.f26055i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f26055i.f26042e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f26055i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f26055i.f26042e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f26049c, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.f26050d, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.f26051e, b1.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f26047a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f26049c;
            textView.setText(this.f26055i.f26041d + ":");
            this.f26050d.setText(this.f26055i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f26051e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
