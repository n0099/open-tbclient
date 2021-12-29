package c.a.t0.d1.u2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f16935b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f16936c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f16937d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16938e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16939f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16940g;

    /* renamed from: h  reason: collision with root package name */
    public String f16941h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16942i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f16943j;

    /* renamed from: c.a.t0.d1.u2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1033a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16944e;

        public View$OnClickListenerC1033a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16944e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f16944e.f16935b) {
                    if (m.isEmpty(this.f16944e.f16941h) || this.f16944e.f16939f == null || this.f16944e.f16939f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f16944e.a, new String[]{this.f16944e.f16941h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f16944e.f16939f.getForum().getId()).param("obj_type", this.f16944e.f16942i ? 2 : 1));
                } else if ((view != this.f16944e.f16937d && view != this.f16944e.f16938e) || this.f16944e.f16939f == null || this.f16944e.f16939f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f16944e.a.getPageActivity(), this.f16944e.f16939f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f16944e.f16939f.getForum().getId()));
                }
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
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
        this.f16943j = new View$OnClickListenerC1033a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.a = frsSportsRecommendFragment.getPageContext();
        this.f16935b = (TbImageView) view.findViewById(f1.head_top_bg_mask);
        this.f16936c = (LinearGradientView) view.findViewById(f1.head_top_gradient_bg);
        this.f16937d = (BarImageView) view.findViewById(f1.frs_image);
        this.f16938e = (TextView) view.findViewById(f1.forum_name);
        this.f16935b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f16937d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f16937d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f16937d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(i1.bar_header));
        this.f16937d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f16937d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f16938e, c1.CAM_X0101);
            BarImageView barImageView = this.f16937d;
            if (barImageView != null) {
                barImageView.setBorderWidth(n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds1));
                this.f16937d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
                this.f16937d.setStrokeColorResId(c1.CAM_X0201);
                this.f16937d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f16939f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        if (this.f16940g) {
            return;
        }
        LinearGradientView linearGradientView = this.f16936c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f16936c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f16935b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f16939f = frsViewData;
        this.f16940g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f16938e.setText(String.format(TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_bar_name), name));
        this.f16937d.startLoad(this.f16939f.getForum().getImage_url(), 10, false);
        i();
        this.f16937d.setOnClickListener(this.f16943j);
        this.f16938e.setOnClickListener(this.f16943j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f16937d.refresh();
            if (m.isEmpty(str)) {
                this.f16940g = false;
                i();
                return;
            }
            this.f16940g = true;
            this.f16941h = str2;
            this.f16942i = z;
            this.f16935b.startLoad(str, 10, false);
            this.f16935b.setOnClickListener(this.f16943j);
        }
    }
}
