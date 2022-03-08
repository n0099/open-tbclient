package c.a.r0.d1.n2;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f15900b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15901c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f15902d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15903e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15904f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15905g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15906h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15907i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f15908j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15909e;

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
            this.f15909e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || m.isEmpty(this.f15909e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f15909e.a, new String[]{this.f15909e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f15909e.l));
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
        this.a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f15900b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f15901c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f15902d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f15903e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f15904f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f15905g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f15906h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f15907i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.f15908j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f15902d.setPageId(uniqueId);
        this.f15903e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f15900b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f15901c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f15901c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15904f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15905g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15906h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f15907i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15908j, (int) R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f15900b.setVisibility(8);
                this.f15901c.setVisibility(0);
                this.f15901c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f15900b.setVisibility(0);
            this.f15901c.setVisibility(8);
            this.f15902d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f15903e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f15904f.setText(str2);
            this.f15905g.setText(str3);
            this.f15906h.setText(sportScheduleInfo.match_top_info);
            this.f15907i.setText(sportScheduleInfo.match_middle_info);
            this.f15908j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f15900b.setOnClickListener(this.m);
        }
    }
}
