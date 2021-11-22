package b.a.r0.w.f.i;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.h;
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
/* loaded from: classes5.dex */
public class c extends b.a.r0.b0.b<b.a.r0.w.f.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public b.a.r0.w.f.a.b n;
    public a o;
    public int p;
    public int q;
    public d r;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26483a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26484b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26485c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26486d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f26487e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f26488f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f26489g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f26490h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f26491i;
        public LinearLayout j;
        public ImageView k;
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
            this.f26483a = view;
            this.f26484b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26485c = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.f26486d = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.f26489g = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.f26490h = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26491i = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.j = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f26487e = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.f26488f = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.k = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.l = (TextView) view.findViewById(R.id.tvNewCount);
            this.k.setImageResource(R.drawable.icon_video_tieba);
            this.f26485c.setTypeface(Typeface.defaultFromStyle(1));
            this.f26484b.setDefaultBgResource(b.a.r0.w.f.i.a.a());
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
        o();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_active_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f26490h, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f26491i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f26485c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.o.f26486d, R.color.CAM_X0111);
        this.o.f26486d.setAlpha(0.9f);
        SkinManager.setViewTextColor(this.o.f26487e, R.color.live_cp_other_b);
        SkinManager.setViewTextColor(this.o.f26488f, R.color.live_cp_other_b);
        this.m = i2;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int k = l.k(this.f16225g) / 2;
            this.p = k;
            this.q = (k * 9) / 16;
            this.o = new a(i());
            i().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a.r0.w.f.a.b bVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view != i() || (d2Var = (bVar = this.n).f26018e) == null || d2Var.u1 == null) {
            return;
        }
        d dVar = this.r;
        if (dVar != null) {
            dVar.a(view, bVar);
        }
        s(this.n.f26018e.u1.f14120g);
        b.a.r0.w.f.e.a.c().h(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.w.f.a.b bVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || (d2Var = bVar.f26018e) == null) {
            return;
        }
        this.n = bVar;
        int i2 = this.q;
        h hVar = d2Var.u1;
        int i3 = hVar.f14117d;
        if (i3 > 0) {
            i2 = (this.p * hVar.f14118e) / i3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.f26490h.getLayoutParams();
        layoutParams.width = this.p;
        layoutParams.height = i2;
        this.o.f26490h.setLayoutParams(layoutParams);
        this.o.f26491i.setText(bVar.f26018e.getTitle());
        this.o.f26484b.startLoad(bVar.f26018e.u1.f14119f, 10, false);
        this.o.f26485c.setText(bVar.f26018e.u1.f14115b);
        this.o.f26486d.setText(bVar.f26018e.u1.f14116c);
        this.o.f26486d.setVisibility(8);
        this.o.l.setText(bVar.f26018e.u1.f14116c);
        k(this.f16224f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.r = dVar;
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                l.L(this.f16224f.getPageActivity(), R.string.url_is_null);
            } else {
                UrlManager.getInstance().dealOneLinkWithDialog(this.f16224f, "", new String[]{str}, false, null, true);
            }
        }
    }
}
