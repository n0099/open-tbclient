package b.a.r0.x0.q1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27665a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f27666b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27667c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27668d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27669e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f27670f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f27671g;

    /* renamed from: h  reason: collision with root package name */
    public View f27672h;

    /* renamed from: i  reason: collision with root package name */
    public b f27673i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27674e;

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
            this.f27674e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f27674e.f27670f.getId()) {
                    if (this.f27674e.f27666b.getPageActivity() != null) {
                        this.f27674e.f27666b.getPageActivity().finish();
                    }
                    this.f27674e.f(2);
                } else if (view.getId() == this.f27674e.f27671g.getId()) {
                    if (this.f27674e.j != null) {
                        this.f27674e.j.onClick(view);
                    }
                    this.f27674e.f(1);
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
        this.f27666b = tbPageContext;
        this.f27665a = view;
        this.f27667c = (TextView) view.findViewById(f1.to_user_name);
        this.f27668d = (TextView) view.findViewById(f1.content);
        this.f27669e = (TextView) view.findViewById(f1.sender);
        this.f27670f = (TBSpecificationBtn) view.findViewById(f1.btn_known);
        b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
        cVar.p(c1.CAM_X0618);
        this.f27670f.setConfig(cVar);
        this.f27670f.setTextSize(d1.tbds42);
        this.f27670f.setText(tbPageContext.getString(i1.guide_popup_window_known));
        this.f27670f.setOnClickListener(this.k);
        this.f27671g = (TBSpecificationBtn) view.findViewById(f1.btn_share);
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
        bVar.p(c1.CAM_X0302, c1.CAM_X0101);
        this.f27671g.setConfig(bVar);
        this.f27671g.setTextSize(d1.tbds42);
        this.f27671g.setText(tbPageContext.getString(i1.go_to_share));
        this.f27671g.setOnClickListener(this.k);
        this.f27672h = view.findViewById(f1.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(c1.black_alpha100), tbPageContext.getResources().getColor(c1.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f27672h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f27673i = bVar2;
        bVar2.k();
        i();
        String str = this.f27673i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f27673i.f27660e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f27673i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f27673i.f27660e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f27667c, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f27668d, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f27669e, c1.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f27665a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f27667c;
            textView.setText(this.f27673i.f27659d + ":");
            this.f27668d.setText(this.f27673i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f27669e;
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
