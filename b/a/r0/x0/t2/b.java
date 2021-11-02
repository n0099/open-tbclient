package b.a.r0.x0.t2;

import android.view.View;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SportScheduleInfo;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26348a;

    /* renamed from: b  reason: collision with root package name */
    public View f26349b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26350c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f26351d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26352e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26353f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26354g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26355h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26356i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26357e;

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
            this.f26357e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f26357e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f26357e.f26348a, new String[]{this.f26357e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f26357e.l));
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
        this.f26348a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f26349b = view.findViewById(e1.frs_sports_schedule_card_layout);
        this.f26350c = (TextView) view.findViewById(e1.frs_sports_tab_view);
        this.f26351d = (TbImageView) view.findViewById(e1.frs_sports_schedule_left_team_icon);
        this.f26352e = (TbImageView) view.findViewById(e1.frs_sports_schedule_right_team_icon);
        this.f26353f = (TextView) view.findViewById(e1.frs_sports_schedule_left_team_name);
        this.f26354g = (TextView) view.findViewById(e1.frs_sports_schedule_right_team_name);
        this.f26355h = (TextView) view.findViewById(e1.frs_sports_schedule_match_top);
        this.f26356i = (TextView) view.findViewById(e1.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(e1.frs_sports_schedule_match_bottom);
        this.f26351d.setPageId(uniqueId);
        this.f26352e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f26349b, d1.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f26350c, d1.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f26350c, b1.CAM_X0105);
            SkinManager.setViewTextColor(this.f26353f, b1.CAM_X0105);
            SkinManager.setViewTextColor(this.f26354g, b1.CAM_X0105);
            SkinManager.setViewTextColor(this.f26355h, b1.CAM_X0108);
            SkinManager.setViewTextColor(this.f26356i, b1.CAM_X0105);
            SkinManager.setViewTextColor(this.j, b1.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f26349b.setVisibility(8);
                this.f26350c.setVisibility(0);
                this.f26350c.setText(h1.frs_sports_recommend_tab_txt);
                return;
            }
            this.f26349b.setVisibility(0);
            this.f26350c.setVisibility(8);
            this.f26351d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f26352e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f26353f.setText(str2);
            this.f26354g.setText(str3);
            this.f26355h.setText(sportScheduleInfo.match_top_info);
            this.f26356i.setText(sportScheduleInfo.match_middle_info);
            this.j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f26349b.setOnClickListener(this.m);
        }
    }
}
