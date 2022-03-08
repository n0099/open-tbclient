package c.a.r0.d1.h1;

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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15542b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15543c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15544d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15545e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f15546f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f15547g;

    /* renamed from: h  reason: collision with root package name */
    public View f15548h;

    /* renamed from: i  reason: collision with root package name */
    public b f15549i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f15550j;
    public View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15551e;

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
            this.f15551e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f15551e.f15546f.getId()) {
                    if (this.f15551e.f15542b.getPageActivity() != null) {
                        this.f15551e.f15542b.getPageActivity().finish();
                    }
                    this.f15551e.f(2);
                } else if (view.getId() == this.f15551e.f15547g.getId()) {
                    if (this.f15551e.f15550j != null) {
                        this.f15551e.f15550j.onClick(view);
                    }
                    this.f15551e.f(1);
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
        this.f15542b = tbPageContext;
        this.a = view;
        this.f15543c = (TextView) view.findViewById(R.id.to_user_name);
        this.f15544d = (TextView) view.findViewById(R.id.content);
        this.f15545e = (TextView) view.findViewById(R.id.sender);
        this.f15546f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        c.a.q0.r.l0.n.c cVar = new c.a.q0.r.l0.n.c();
        cVar.p(R.color.CAM_X0618);
        this.f15546f.setConfig(cVar);
        this.f15546f.setTextSize(R.dimen.tbds42);
        this.f15546f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f15546f.setOnClickListener(this.k);
        this.f15547g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f15547g.setConfig(bVar);
        this.f15547g.setTextSize(R.dimen.tbds42);
        this.f15547g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f15547g.setOnClickListener(this.k);
        this.f15548h = view.findViewById(R.id.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f15548h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f15549i = bVar2;
        bVar2.k();
        i();
        String str = this.f15549i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f15549i.f15536e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f15549i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f15549i.f15536e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f15543c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f15544d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f15545e, (int) R.color.CAM_X0109);
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
            TextView textView = this.f15543c;
            textView.setText(this.f15549i.f15535d + ":");
            this.f15544d.setText(this.f15549i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f15545e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f15550j = onClickListener;
        }
    }
}
