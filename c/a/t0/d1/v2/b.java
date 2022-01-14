package c.a.t0.d1.v2;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.t0.d1.c1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f16689b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16690c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f16691d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16692e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16693f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16694g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16695h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16696i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16697j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16698e;

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
            this.f16698e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || m.isEmpty(this.f16698e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f16698e.a, new String[]{this.f16698e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f16698e.l));
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
        this.f16689b = view.findViewById(f1.frs_sports_schedule_card_layout);
        this.f16690c = (TextView) view.findViewById(f1.frs_sports_tab_view);
        this.f16691d = (TbImageView) view.findViewById(f1.frs_sports_schedule_left_team_icon);
        this.f16692e = (TbImageView) view.findViewById(f1.frs_sports_schedule_right_team_icon);
        this.f16693f = (TextView) view.findViewById(f1.frs_sports_schedule_left_team_name);
        this.f16694g = (TextView) view.findViewById(f1.frs_sports_schedule_right_team_name);
        this.f16695h = (TextView) view.findViewById(f1.frs_sports_schedule_match_top);
        this.f16696i = (TextView) view.findViewById(f1.frs_sports_schedule_match_middle);
        this.f16697j = (TextView) view.findViewById(f1.frs_sports_schedule_match_bottom);
        this.f16691d.setPageId(uniqueId);
        this.f16692e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f16689b, e1.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f16690c, e1.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f16690c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16693f, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16694g, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16695h, c1.CAM_X0108);
            SkinManager.setViewTextColor(this.f16696i, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16697j, c1.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f16689b.setVisibility(8);
                this.f16690c.setVisibility(0);
                this.f16690c.setText(i1.frs_sports_recommend_tab_txt);
                return;
            }
            this.f16689b.setVisibility(0);
            this.f16690c.setVisibility(8);
            this.f16691d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f16692e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f16693f.setText(str2);
            this.f16694g.setText(str3);
            this.f16695h.setText(sportScheduleInfo.match_top_info);
            this.f16696i.setText(sportScheduleInfo.match_middle_info);
            this.f16697j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f16689b.setOnClickListener(this.m);
        }
    }
}
