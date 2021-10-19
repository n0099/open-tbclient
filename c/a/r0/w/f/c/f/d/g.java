package c.a.r0.w.f.c.f.d;

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
import c.a.q0.s.q.d2;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25835a;

    /* renamed from: b  reason: collision with root package name */
    public View f25836b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f25837c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25838d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25839e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25840f;

    /* renamed from: g  reason: collision with root package name */
    public i f25841g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.w.f.a.c f25842h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25843i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f25844e;

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
            this.f25844e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25844e.f25842h == null || this.f25844e.f25842h.f25667h == null || view != this.f25844e.f25836b || this.f25844e.f25841g == null) {
                        return;
                    }
                    this.f25844e.f25841g.a(this.f25844e.f25842h);
                    return;
                }
                l.J(this.f25844e.f25835a.getPageActivity(), this.f25844e.f25835a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f25843i = new a(this);
        this.f25835a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f25836b = inflate;
        this.f25840f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f25837c = (HeadImageView) this.f25836b.findViewById(R.id.iv_anchor_avatar);
        this.f25838d = (TextView) this.f25836b.findViewById(R.id.tv_anchor_name);
        this.f25839e = (TextView) this.f25836b.findViewById(R.id.tv_live_aud_num);
        this.f25836b.setOnClickListener(this.f25843i);
        this.f25837c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f25837c.setIsRound(true);
        this.f25837c.setPlaceHolder(1);
        this.f25837c.setAutoChangeStyle(true);
        this.f25837c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f25840f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f25835a.getPageActivity()) - (this.f25835a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f25835a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25836b : (View) invokeV.objValue;
    }

    public void f(c.a.r0.w.f.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25667h) != null && d2Var.J() != null) {
                e().setVisibility(0);
                this.f25842h = cVar;
                cVar.f25667h.J().getUserId();
                this.f25837c.startLoad(cVar.f25667h.J().getPortrait(), 25, false, false);
                String name_show = cVar.f25667h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f25838d.setText(name_show);
                }
                if (cVar.f25667h.l1() != null) {
                    this.f25839e.setText(String.format(this.f25835a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f25667h.l1().audience_count)));
                }
                g(this.f25835a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f25838d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25839e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f25837c.setBorderColor(this.f25835a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f25837c.setBorderColor(this.f25835a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f25835a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f25835a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f25835a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f25839e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f25839e.setCompoundDrawablePadding(this.f25835a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f25841g = iVar;
        }
    }
}
