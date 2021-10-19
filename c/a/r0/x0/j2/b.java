package c.a.r0.x0.j2;

import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27107a;

    /* renamed from: b  reason: collision with root package name */
    public View f27108b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27109c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f27110d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f27111e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27112f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27113g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27114h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27115i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f27116j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27117e;

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
            this.f27117e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f27117e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f27117e.f27107a, new String[]{this.f27117e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f27117e.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsSportsRecommendFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f27107a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f27108b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f27109c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f27110d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f27111e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f27112f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f27113g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f27114h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f27115i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.f27116j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f27110d.setPageId(uniqueId);
        this.f27111e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f27108b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f27109c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f27109c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27112f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27113g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27114h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f27115i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27116j, R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f27108b.setVisibility(8);
                this.f27109c.setVisibility(0);
                this.f27109c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f27108b.setVisibility(0);
            this.f27109c.setVisibility(8);
            this.f27110d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f27111e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f27112f.setText(str2);
            this.f27113g.setText(str3);
            this.f27114h.setText(sportScheduleInfo.match_top_info);
            this.f27115i.setText(sportScheduleInfo.match_middle_info);
            this.f27116j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f27108b.setOnClickListener(this.m);
        }
    }
}
