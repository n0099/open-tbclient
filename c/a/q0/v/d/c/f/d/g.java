package c.a.q0.v.d.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25159a;

    /* renamed from: b  reason: collision with root package name */
    public View f25160b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f25161c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25162d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25163e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25164f;

    /* renamed from: g  reason: collision with root package name */
    public i f25165g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v.d.a.c f25166h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25167i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f25168e;

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
            this.f25168e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25168e.f25166h == null || this.f25168e.f25166h.f24991h == null || view != this.f25168e.f25160b || this.f25168e.f25165g == null) {
                        return;
                    }
                    this.f25168e.f25165g.a(this.f25168e.f25166h);
                    return;
                }
                l.J(this.f25168e.f25159a.getPageActivity(), this.f25168e.f25159a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f25167i = new a(this);
        this.f25159a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f25160b = inflate;
        this.f25164f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f25161c = (HeadImageView) this.f25160b.findViewById(R.id.iv_anchor_avatar);
        this.f25162d = (TextView) this.f25160b.findViewById(R.id.tv_anchor_name);
        this.f25163e = (TextView) this.f25160b.findViewById(R.id.tv_live_aud_num);
        this.f25160b.setOnClickListener(this.f25167i);
        this.f25161c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f25161c.setIsRound(true);
        this.f25161c.setPlaceHolder(1);
        this.f25161c.setAutoChangeStyle(true);
        this.f25161c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f25164f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f25159a.getPageActivity()) - (this.f25159a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f25159a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25160b : (View) invokeV.objValue;
    }

    public void f(c.a.q0.v.d.a.c cVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (c2Var = cVar.f24991h) != null && c2Var.J() != null) {
                e().setVisibility(0);
                this.f25166h = cVar;
                cVar.f24991h.J().getUserId();
                this.f25161c.startLoad(cVar.f24991h.J().getPortrait(), 25, false, false);
                String name_show = cVar.f24991h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f25162d.setText(name_show);
                }
                if (cVar.f24991h.j1() != null) {
                    this.f25163e.setText(String.format(this.f25159a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f24991h.j1().audience_count)));
                }
                g(this.f25159a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f25162d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25163e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f25161c.setBorderColor(this.f25159a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f25161c.setBorderColor(this.f25159a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f25159a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f25159a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f25159a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f25163e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f25163e.setCompoundDrawablePadding(this.f25159a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f25165g = iVar;
        }
    }
}
