package c.a.r0.w0.j2;

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
    public TbPageContext f26912a;

    /* renamed from: b  reason: collision with root package name */
    public View f26913b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26914c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f26915d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26916e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26917f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26918g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26919h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26920i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f26921j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26922e;

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
            this.f26922e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f26922e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f26922e.f26912a, new String[]{this.f26922e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f26922e.l));
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
        this.f26912a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f26913b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f26914c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f26915d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f26916e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f26917f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f26918g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f26919h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f26920i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.f26921j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f26915d.setPageId(uniqueId);
        this.f26916e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f26913b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f26914c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f26914c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26917f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26918g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26919h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f26920i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26921j, R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f26913b.setVisibility(8);
                this.f26914c.setVisibility(0);
                this.f26914c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f26913b.setVisibility(0);
            this.f26914c.setVisibility(8);
            this.f26915d.startLoad(sportScheduleInfo.home_team_icon, 10, false);
            this.f26916e.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, "...");
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, "...");
            }
            this.f26917f.setText(str2);
            this.f26918g.setText(str3);
            this.f26919h.setText(sportScheduleInfo.match_top_info);
            this.f26920i.setText(sportScheduleInfo.match_middle_info);
            this.f26921j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f26913b.setOnClickListener(this.m);
        }
    }
}
