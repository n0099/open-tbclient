package c.a.r0.d1.u2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.i1;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f16030b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f16031c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f16032d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16033e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16034f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16035g;

    /* renamed from: h  reason: collision with root package name */
    public String f16036h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16037i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f16038j;

    /* renamed from: c.a.r0.d1.u2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0964a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16039e;

        public View$OnClickListenerC0964a(a aVar) {
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
            this.f16039e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f16039e.f16030b) {
                    if (k.isEmpty(this.f16039e.f16036h) || this.f16039e.f16034f == null || this.f16039e.f16034f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f16039e.a, new String[]{this.f16039e.f16036h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f16039e.f16034f.getForum().getId()).param("obj_type", this.f16039e.f16037i ? 2 : 1));
                } else if ((view != this.f16039e.f16032d && view != this.f16039e.f16033e) || this.f16039e.f16034f == null || this.f16039e.f16034f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f16039e.a.getPageActivity(), this.f16039e.f16034f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f16039e.f16034f.getForum().getId()));
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
        this.f16038j = new View$OnClickListenerC0964a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.a = frsSportsRecommendFragment.getPageContext();
        this.f16030b = (TbImageView) view.findViewById(f1.head_top_bg_mask);
        this.f16031c = (LinearGradientView) view.findViewById(f1.head_top_gradient_bg);
        this.f16032d = (BarImageView) view.findViewById(f1.frs_image);
        this.f16033e = (TextView) view.findViewById(f1.forum_name);
        this.f16030b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f16032d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f16032d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f16032d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(i1.bar_header));
        this.f16032d.setStrokeWith(l.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f16032d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f16033e, c1.CAM_X0101);
            BarImageView barImageView = this.f16032d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds1));
                this.f16032d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
                this.f16032d.setStrokeColorResId(c1.CAM_X0201);
                this.f16032d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f16034f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f16035g) {
            return;
        }
        LinearGradientView linearGradientView = this.f16031c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f16031c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f16030b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f16034f = frsViewData;
        this.f16035g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f16033e.setText(String.format(TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_bar_name), name));
        this.f16032d.startLoad(this.f16034f.getForum().getImage_url(), 10, false);
        i();
        this.f16032d.setOnClickListener(this.f16038j);
        this.f16033e.setOnClickListener(this.f16038j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f16032d.refresh();
            if (k.isEmpty(str)) {
                this.f16035g = false;
                i();
                return;
            }
            this.f16035g = true;
            this.f16036h = str2;
            this.f16037i = z;
            this.f16030b.startLoad(str, 10, false);
            this.f16030b.setOnClickListener(this.f16038j);
        }
    }
}
