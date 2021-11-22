package b.a.r0.x0.u2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27934a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f27935b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f27936c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f27937d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27938e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f27939f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27940g;

    /* renamed from: h  reason: collision with root package name */
    public String f27941h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27942i;
    public final View.OnClickListener j;

    /* renamed from: b.a.r0.x0.u2.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1363a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27943e;

        public View$OnClickListenerC1363a(a aVar) {
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
            this.f27943e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f27943e.f27935b) {
                    if (k.isEmpty(this.f27943e.f27941h) || this.f27943e.f27939f == null || this.f27943e.f27939f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f27943e.f27934a, new String[]{this.f27943e.f27941h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f27943e.f27939f.getForum().getId()).param("obj_type", this.f27943e.f27942i ? 2 : 1));
                } else if ((view != this.f27943e.f27937d && view != this.f27943e.f27938e) || this.f27943e.f27939f == null || this.f27943e.f27939f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f27943e.f27934a.getPageActivity(), this.f27943e.f27939f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f27943e.f27939f.getForum().getId()));
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
        this.j = new View$OnClickListenerC1363a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f27934a = frsSportsRecommendFragment.getPageContext();
        this.f27935b = (TbImageView) view.findViewById(f1.head_top_bg_mask);
        this.f27936c = (LinearGradientView) view.findViewById(f1.head_top_gradient_bg);
        this.f27937d = (BarImageView) view.findViewById(f1.frs_image);
        this.f27938e = (TextView) view.findViewById(f1.forum_name);
        this.f27935b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f27937d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f27937d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f27937d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(i1.bar_header));
        this.f27937d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f27937d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f27938e, c1.CAM_X0101);
            BarImageView barImageView = this.f27937d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), d1.tbds1));
                this.f27937d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
                this.f27937d.setStrokeColorResId(c1.CAM_X0201);
                this.f27937d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f27939f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f27940g) {
            return;
        }
        LinearGradientView linearGradientView = this.f27936c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f27936c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f27935b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f27939f = frsViewData;
        this.f27940g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f27938e.setText(String.format(TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_bar_name), name));
        this.f27937d.startLoad(this.f27939f.getForum().getImage_url(), 10, false);
        i();
        this.f27937d.setOnClickListener(this.j);
        this.f27938e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f27937d.refresh();
            if (k.isEmpty(str)) {
                this.f27940g = false;
                i();
                return;
            }
            this.f27940g = true;
            this.f27941h = str2;
            this.f27942i = z;
            this.f27935b.startLoad(str, 10, false);
            this.f27935b.setOnClickListener(this.j);
        }
    }
}
