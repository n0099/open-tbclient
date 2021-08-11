package c.a.p0.v.d.c.f.d;

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
import c.a.o0.s.q.c2;
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
    public TbPageContext<?> f24826a;

    /* renamed from: b  reason: collision with root package name */
    public View f24827b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f24828c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24829d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24830e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f24831f;

    /* renamed from: g  reason: collision with root package name */
    public i f24832g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v.d.a.c f24833h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24834i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24835e;

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
            this.f24835e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f24835e.f24833h == null || this.f24835e.f24833h.f24658h == null || view != this.f24835e.f24827b || this.f24835e.f24832g == null) {
                        return;
                    }
                    this.f24835e.f24832g.a(this.f24835e.f24833h);
                    return;
                }
                l.J(this.f24835e.f24826a.getPageActivity(), this.f24835e.f24826a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f24834i = new a(this);
        this.f24826a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f24827b = inflate;
        this.f24831f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f24828c = (HeadImageView) this.f24827b.findViewById(R.id.iv_anchor_avatar);
        this.f24829d = (TextView) this.f24827b.findViewById(R.id.tv_anchor_name);
        this.f24830e = (TextView) this.f24827b.findViewById(R.id.tv_live_aud_num);
        this.f24827b.setOnClickListener(this.f24834i);
        this.f24828c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f24828c.setIsRound(true);
        this.f24828c.setPlaceHolder(1);
        this.f24828c.setAutoChangeStyle(true);
        this.f24828c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f24831f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f24826a.getPageActivity()) - (this.f24826a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f24826a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24827b : (View) invokeV.objValue;
    }

    public void f(c.a.p0.v.d.a.c cVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (c2Var = cVar.f24658h) != null && c2Var.J() != null) {
                e().setVisibility(0);
                this.f24833h = cVar;
                cVar.f24658h.J().getUserId();
                this.f24828c.startLoad(cVar.f24658h.J().getPortrait(), 25, false, false);
                String name_show = cVar.f24658h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f24829d.setText(name_show);
                }
                if (cVar.f24658h.j1() != null) {
                    this.f24830e.setText(String.format(this.f24826a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f24658h.j1().audience_count)));
                }
                g(this.f24826a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f24829d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f24830e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f24828c.setBorderColor(this.f24826a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f24828c.setBorderColor(this.f24826a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f24826a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f24826a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f24826a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f24830e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f24830e.setCompoundDrawablePadding(this.f24826a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f24832g = iVar;
        }
    }
}
