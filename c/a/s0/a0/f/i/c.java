package c.a.s0.a0.f.i;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c extends c.a.s0.g0.b<c.a.s0.a0.f.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public c.a.s0.a0.f.a.b n;
    public a o;
    public int p;
    public int q;
    public d r;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14602b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14603c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14604d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14605e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14606f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f14607g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f14608h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14609i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f14610j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f14611k;
        public TextView l;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f14602b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14603c = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.f14604d = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.f14607g = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.f14608h = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14609i = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14610j = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f14605e = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.f14606f = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.f14611k = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.l = (TextView) view.findViewById(R.id.tvNewCount);
            this.f14611k.setImageResource(R.drawable.icon_video_tieba);
            this.f14603c.setTypeface(Typeface.defaultFromStyle(1));
            this.f14602b.setDefaultBgResource(c.a.s0.a0.f.i.a.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.p = 0;
        this.q = 0;
        p();
    }

    @Override // c.a.s0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_active_layout : invokeV.intValue;
    }

    @Override // c.a.s0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f14608h, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f14609i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f14603c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.o.f14604d, R.color.CAM_X0111);
        this.o.f14604d.setAlpha(0.9f);
        SkinManager.setViewTextColor(this.o.f14605e, R.color.live_cp_other_b);
        SkinManager.setViewTextColor(this.o.f14606f, R.color.live_cp_other_b);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.s0.a0.f.a.b bVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view != j() || (d2Var = (bVar = this.n).f14182e) == null || d2Var.w1 == null) {
            return;
        }
        d dVar = this.r;
        if (dVar != null) {
            dVar.a(view, bVar);
        }
        t(this.n.f14182e.w1.f13343g);
        c.a.s0.a0.f.e.a.c().h(true);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int k2 = m.k(this.f17716g) / 2;
            this.p = k2;
            this.q = (k2 * 9) / 16;
            this.o = new a(j());
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.g0.b
    /* renamed from: q */
    public void k(c.a.s0.a0.f.a.b bVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || (d2Var = bVar.f14182e) == null) {
            return;
        }
        this.n = bVar;
        int i2 = this.q;
        h hVar = d2Var.w1;
        int i3 = hVar.f13340d;
        if (i3 > 0) {
            i2 = (this.p * hVar.f13341e) / i3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.f14608h.getLayoutParams();
        layoutParams.width = this.p;
        layoutParams.height = i2;
        this.o.f14608h.setLayoutParams(layoutParams);
        this.o.f14609i.setText(bVar.f14182e.getTitle());
        this.o.f14602b.startLoad(bVar.f14182e.w1.f13342f, 10, false);
        this.o.f14603c.setText(bVar.f14182e.w1.f13338b);
        this.o.f14604d.setText(bVar.f14182e.w1.f13339c);
        this.o.f14604d.setVisibility(8);
        this.o.l.setText(bVar.f14182e.w1.f13339c);
        l(this.f17715f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.r = dVar;
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                m.L(this.f17715f.getPageActivity(), R.string.url_is_null);
            } else {
                UrlManager.getInstance().dealOneLinkWithDialog(this.f17715f, "", new String[]{str}, false, null, true);
            }
        }
    }
}
