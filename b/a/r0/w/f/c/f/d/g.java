package b.a.r0.w.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.j;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f26193a;

    /* renamed from: b  reason: collision with root package name */
    public View f26194b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f26195c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26196d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26197e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f26198f;

    /* renamed from: g  reason: collision with root package name */
    public i f26199g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.w.f.a.e f26200h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f26201i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26202e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26202e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26202e.f26200h == null || this.f26202e.f26200h.f26027h == null || view != this.f26202e.f26194b || this.f26202e.f26199g == null) {
                        return;
                    }
                    this.f26202e.f26199g.a(this.f26202e.f26200h);
                    return;
                }
                l.J(this.f26202e.f26193a.getPageActivity(), this.f26202e.f26193a.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26201i = new a(this);
        this.f26193a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f26194b = inflate;
        this.f26198f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f26195c = (HeadImageView) this.f26194b.findViewById(R.id.iv_anchor_avatar);
        this.f26196d = (TextView) this.f26194b.findViewById(R.id.tv_anchor_name);
        this.f26197e = (TextView) this.f26194b.findViewById(R.id.tv_live_aud_num);
        this.f26194b.setOnClickListener(this.f26201i);
        this.f26195c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f26195c.setIsRound(true);
        this.f26195c.setPlaceHolder(1);
        this.f26195c.setAutoChangeStyle(true);
        this.f26195c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26198f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f26193a.getPageActivity()) - (this.f26193a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f26193a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26194b : (View) invokeV.objValue;
    }

    public void f(b.a.r0.w.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f26027h) != null && d2Var.J() != null) {
                e().setVisibility(0);
                this.f26200h = eVar;
                eVar.f26027h.J().getUserId();
                this.f26195c.startLoad(eVar.f26027h.J().getPortrait(), 25, false, false);
                String name_show = eVar.f26027h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f26196d.setText(name_show);
                }
                if (eVar.f26027h.m1() != null) {
                    this.f26197e.setText(String.format(this.f26193a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(eVar.f26027h.m1().audience_count)));
                }
                g(this.f26193a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f26196d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26197e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f26195c.setBorderColor(this.f26193a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f26195c.setBorderColor(this.f26193a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f26193a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f26193a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f26193a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f26197e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f26197e.setCompoundDrawablePadding(this.f26193a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f26199g = iVar;
        }
    }
}
