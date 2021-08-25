package c.a.q0.v0.i2;

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
    public TbPageContext f26239a;

    /* renamed from: b  reason: collision with root package name */
    public View f26240b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26241c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f26242d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26243e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26244f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26245g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26246h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26247i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f26248j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26249e;

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
            this.f26249e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f26249e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f26249e.f26239a, new String[]{this.f26249e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f26249e.l));
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
        this.f26239a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f26240b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f26241c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f26242d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f26243e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f26244f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f26245g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f26246h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f26247i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.f26248j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f26242d.setPageId(uniqueId);
        this.f26243e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f26240b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f26241c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f26241c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26244f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26245g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26246h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f26247i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26248j, R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f26240b.setVisibility(8);
                this.f26241c.setVisibility(0);
                this.f26241c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f26240b.setVisibility(0);
            this.f26241c.setVisibility(8);
            this.f26242d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f26243e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f26244f.setText(str2);
            this.f26245g.setText(str3);
            this.f26246h.setText(sportScheduleInfo.match_top_info);
            this.f26247i.setText(sportScheduleInfo.match_middle_info);
            this.f26248j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f26240b.setOnClickListener(this.m);
        }
    }
}
