package c.a.p0.f1.h1;

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
    public TbPageContext f13988b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13989c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13990d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13991e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f13992f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f13993g;

    /* renamed from: h  reason: collision with root package name */
    public View f13994h;
    public b i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.a.f13992f.getId()) {
                    if (this.a.f13988b.getPageActivity() != null) {
                        this.a.f13988b.getPageActivity().finish();
                    }
                    this.a.f(2);
                } else if (view.getId() == this.a.f13993g.getId()) {
                    if (this.a.j != null) {
                        this.a.j.onClick(view);
                    }
                    this.a.f(1);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.f13988b = tbPageContext;
        this.a = view;
        this.f13989c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092087);
        this.f13990d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906d7);
        this.f13991e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c97);
        this.f13992f = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090419);
        c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
        cVar.p(R.color.CAM_X0618);
        this.f13992f.setConfig(cVar);
        this.f13992f.setTextSize(R.dimen.tbds42);
        this.f13992f.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f07ef));
        this.f13992f.setOnClickListener(this.k);
        this.f13993g = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090437);
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f13993g.setConfig(bVar);
        this.f13993g.setTextSize(R.dimen.tbds42);
        this.f13993g.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f07b0));
        this.f13993g.setOnClickListener(this.k);
        this.f13994h = view.findViewById(R.id.obfuscated_res_0x7f0903c9);
        int i3 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f13994h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.i = bVar2;
        bVar2.k();
        i();
        String str = this.i.m;
        if (str != null && str.equals("bazhu")) {
            i3 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i3).param("fid", this.i.f13984e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            String str = this.i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.i.f13984e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setViewTextColor(this.f13989c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f13990d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f13991e, (int) R.color.CAM_X0109);
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
            TextView textView = this.f13989c;
            textView.setText(this.i.f13983d + ":");
            this.f13990d.setText(this.i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f13991e;
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
