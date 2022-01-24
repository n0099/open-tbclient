package c.a.t0.v0.l.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.v0.l.d.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f24461b;

    /* renamed from: c  reason: collision with root package name */
    public View f24462c;

    /* renamed from: d  reason: collision with root package name */
    public RoundRelativeLayout f24463d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24464e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f24465f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f24466g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f24467h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f24468i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f24469j;
    public ImageView k;
    public HotUserRankImageOverlayView l;
    public ImageView m;
    public int n;
    public String o;
    public String p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24470e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24470e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f24470e.f24461b.getPageActivity());
                hotUserRankActivityConfig.setCategory(this.f24470e.o);
                this.f24470e.f24461b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13655");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f24470e.p);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
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
        this.a = 3;
        this.f24461b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.f24462c = inflate;
        this.f24463d = (RoundRelativeLayout) inflate.findViewById(R.id.view_container);
        this.f24464e = (ImageView) this.f24462c.findViewById(R.id.ic_red_background);
        this.f24465f = (ImageView) this.f24462c.findViewById(R.id.ic_red_pic);
        this.f24466g = (TbImageView) this.f24462c.findViewById(R.id.rank_icon);
        this.f24467h = (ImageView) this.f24462c.findViewById(R.id.rank_icon_default);
        this.f24468i = (TextView) this.f24462c.findViewById(R.id.forum_text);
        this.f24469j = (TextView) this.f24462c.findViewById(R.id.no_1_user);
        this.l = (HotUserRankImageOverlayView) this.f24462c.findViewById(R.id.image_overlay_view);
        this.k = (ImageView) this.f24462c.findViewById(R.id.iv_crown);
        this.m = (ImageView) this.f24462c.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.init(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.f24463d.setOnClickListener(new a(this));
        int f2 = n.f(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = f2;
        this.f24463d.setRoundLayoutRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24462c : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.a = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f24463d, R.color.CAM_X0206);
        if (this.f24467h.getVisibility() == 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f24467h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f24464e, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f24465f, R.drawable.pic_list_redword);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f24468i, R.color.CAM_X0311);
        SkinManager.setViewTextColor(this.f24469j, R.color.CAM_X0311);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mask_first24, null);
        this.l.onChangeSkinType();
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        String str = cVar.f24445b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.f24468i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = cVar.a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.f24469j;
            textView2.setText("NO.1 " + cVar.a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (ShortUserInfo shortUserInfo : cVar.a) {
                if (i2 > 2) {
                    break;
                }
                i2++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(cVar.f24446c)) {
                this.f24466g.setVisibility(0);
                this.f24467h.setVisibility(8);
                this.f24466g.startLoad(cVar.f24446c, 12, false);
            } else {
                this.f24467h.setVisibility(0);
                this.f24466g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f24467h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }
}
