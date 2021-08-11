package c.a.p0.v0.i2;

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
    public TbPageContext f25903a;

    /* renamed from: b  reason: collision with root package name */
    public View f25904b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25905c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f25906d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25907e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25908f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25909g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25910h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25911i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f25912j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25913e;

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
            this.f25913e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f25913e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f25913e.f25903a, new String[]{this.f25913e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f25913e.l));
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
        this.f25903a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f25904b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f25905c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f25906d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f25907e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f25908f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f25909g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f25910h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f25911i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.f25912j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f25906d.setPageId(uniqueId);
        this.f25907e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f25904b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f25905c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f25905c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25908f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25909g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25910h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f25911i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25912j, R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f25904b.setVisibility(8);
                this.f25905c.setVisibility(0);
                this.f25905c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f25904b.setVisibility(0);
            this.f25905c.setVisibility(8);
            this.f25906d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f25907e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f25908f.setText(str2);
            this.f25909g.setText(str3);
            this.f25910h.setText(sportScheduleInfo.match_top_info);
            this.f25911i.setText(sportScheduleInfo.match_middle_info);
            this.f25912j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f25904b.setOnClickListener(this.m);
        }
    }
}
