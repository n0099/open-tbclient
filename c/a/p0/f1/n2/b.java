package c.a.p0.f1.n2;

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
    public View f14286b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14287c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f14288d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f14289e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14290f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14291g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14292h;
    public TextView i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || m.isEmpty(this.a.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.a.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsSportsRecommendFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f14286b = view.findViewById(R.id.obfuscated_res_0x7f090bcf);
        this.f14287c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd7);
        this.f14288d = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090bd0);
        this.f14289e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090bd5);
        this.f14290f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd1);
        this.f14291g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd6);
        this.f14292h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd4);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd3);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090bd2);
        this.f14288d.setPageId(uniqueId);
        this.f14289e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f14286b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f14287c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f14287c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14290f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14291g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14292h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f14286b.setVisibility(8);
                this.f14287c.setVisibility(0);
                this.f14287c.setText(R.string.obfuscated_res_0x7f0f0733);
                return;
            }
            this.f14286b.setVisibility(0);
            this.f14287c.setVisibility(8);
            this.f14288d.J(sportScheduleInfo.home_team_icon, 10, false);
            this.f14289e.J(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
            }
            this.f14290f.setText(str2);
            this.f14291g.setText(str3);
            this.f14292h.setText(sportScheduleInfo.match_top_info);
            this.i.setText(sportScheduleInfo.match_middle_info);
            this.j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f14286b.setOnClickListener(this.m);
        }
    }
}
