package c.a.r0.x0.f1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26793a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26794b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26795c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26796d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26797e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f26798f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f26799g;

    /* renamed from: h  reason: collision with root package name */
    public View f26800h;

    /* renamed from: i  reason: collision with root package name */
    public b f26801i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f26802j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26803e;

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
            this.f26803e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f26803e.f26798f.getId()) {
                    if (this.f26803e.f26794b.getPageActivity() != null) {
                        this.f26803e.f26794b.getPageActivity().finish();
                    }
                    this.f26803e.f(2);
                } else if (view.getId() == this.f26803e.f26799g.getId()) {
                    if (this.f26803e.f26802j != null) {
                        this.f26803e.f26802j.onClick(view);
                    }
                    this.f26803e.f(1);
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
        this.f26794b = tbPageContext;
        this.f26793a = view;
        this.f26795c = (TextView) view.findViewById(R.id.to_user_name);
        this.f26796d = (TextView) view.findViewById(R.id.content);
        this.f26797e = (TextView) view.findViewById(R.id.sender);
        this.f26798f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
        cVar.p(R.color.CAM_X0618);
        this.f26798f.setConfig(cVar);
        this.f26798f.setTextSize(R.dimen.tbds42);
        this.f26798f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f26798f.setOnClickListener(this.k);
        this.f26799g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f26799g.setConfig(bVar);
        this.f26799g.setTextSize(R.dimen.tbds42);
        this.f26799g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f26799g.setOnClickListener(this.k);
        this.f26800h = view.findViewById(R.id.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f26800h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f26801i = bVar2;
        bVar2.k();
        i();
        String str = this.f26801i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f26801i.f26787e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f26801i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f26801i.f26787e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f26795c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f26796d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f26797e, R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f26793a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f26795c;
            textView.setText(this.f26801i.f26786d + ":");
            this.f26796d.setText(this.f26801i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f26797e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f26802j = onClickListener;
        }
    }
}
