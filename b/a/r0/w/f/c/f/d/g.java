package b.a.r0.w.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
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
    public TbPageContext<?> f24676a;

    /* renamed from: b  reason: collision with root package name */
    public View f24677b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f24678c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24679d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24680e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f24681f;

    /* renamed from: g  reason: collision with root package name */
    public i f24682g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.w.f.a.e f24683h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24684i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24685e;

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
            this.f24685e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f24685e.f24683h == null || this.f24685e.f24683h.f24510h == null || view != this.f24685e.f24677b || this.f24685e.f24682g == null) {
                        return;
                    }
                    this.f24685e.f24682g.a(this.f24685e.f24683h);
                    return;
                }
                l.J(this.f24685e.f24676a.getPageActivity(), this.f24685e.f24676a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f24684i = new a(this);
        this.f24676a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f24677b = inflate;
        this.f24681f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f24678c = (HeadImageView) this.f24677b.findViewById(R.id.iv_anchor_avatar);
        this.f24679d = (TextView) this.f24677b.findViewById(R.id.tv_anchor_name);
        this.f24680e = (TextView) this.f24677b.findViewById(R.id.tv_live_aud_num);
        this.f24677b.setOnClickListener(this.f24684i);
        this.f24678c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f24678c.setIsRound(true);
        this.f24678c.setPlaceHolder(1);
        this.f24678c.setAutoChangeStyle(true);
        this.f24678c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f24681f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f24676a.getPageActivity()) - (this.f24676a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f24676a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24677b : (View) invokeV.objValue;
    }

    public void f(b.a.r0.w.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f24510h) != null && d2Var.J() != null) {
                e().setVisibility(0);
                this.f24683h = eVar;
                eVar.f24510h.J().getUserId();
                this.f24678c.startLoad(eVar.f24510h.J().getPortrait(), 25, false, false);
                String name_show = eVar.f24510h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f24679d.setText(name_show);
                }
                if (eVar.f24510h.l1() != null) {
                    this.f24680e.setText(String.format(this.f24676a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(eVar.f24510h.l1().audience_count)));
                }
                g(this.f24676a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f24679d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f24680e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f24678c.setBorderColor(this.f24676a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f24678c.setBorderColor(this.f24676a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f24676a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f24676a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f24676a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f24680e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f24680e.setCompoundDrawablePadding(this.f24676a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f24682g = iVar;
        }
    }
}
