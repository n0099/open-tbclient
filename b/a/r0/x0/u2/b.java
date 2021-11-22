package b.a.r0.x0.u2;

import android.view.View;
import android.widget.TextView;
import b.a.e.f.p.k;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27944a;

    /* renamed from: b  reason: collision with root package name */
    public View f27945b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27946c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f27947d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f27948e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27949f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27950g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27951h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27952i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27953e;

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
            this.f27953e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f27953e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f27953e.f27944a, new String[]{this.f27953e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f27953e.l));
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
        this.f27944a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f27945b = view.findViewById(f1.frs_sports_schedule_card_layout);
        this.f27946c = (TextView) view.findViewById(f1.frs_sports_tab_view);
        this.f27947d = (TbImageView) view.findViewById(f1.frs_sports_schedule_left_team_icon);
        this.f27948e = (TbImageView) view.findViewById(f1.frs_sports_schedule_right_team_icon);
        this.f27949f = (TextView) view.findViewById(f1.frs_sports_schedule_left_team_name);
        this.f27950g = (TextView) view.findViewById(f1.frs_sports_schedule_right_team_name);
        this.f27951h = (TextView) view.findViewById(f1.frs_sports_schedule_match_top);
        this.f27952i = (TextView) view.findViewById(f1.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(f1.frs_sports_schedule_match_bottom);
        this.f27947d.setPageId(uniqueId);
        this.f27948e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f27945b, e1.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f27946c, e1.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f27946c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27949f, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27950g, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27951h, c1.CAM_X0108);
            SkinManager.setViewTextColor(this.f27952i, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.j, c1.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f27945b.setVisibility(8);
                this.f27946c.setVisibility(0);
                this.f27946c.setText(i1.frs_sports_recommend_tab_txt);
                return;
            }
            this.f27945b.setVisibility(0);
            this.f27946c.setVisibility(8);
            this.f27947d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f27948e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f27949f.setText(str2);
            this.f27950g.setText(str3);
            this.f27951h.setText(sportScheduleInfo.match_top_info);
            this.f27952i.setText(sportScheduleInfo.match_middle_info);
            this.j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f27945b.setOnClickListener(this.m);
        }
    }
}
