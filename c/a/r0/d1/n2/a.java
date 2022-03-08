package c.a.r0.d1.n2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f15890b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f15891c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f15892d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15893e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f15894f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15895g;

    /* renamed from: h  reason: collision with root package name */
    public String f15896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15897i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f15898j;

    /* renamed from: c.a.r0.d1.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1014a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15899e;

        public View$OnClickListenerC1014a(a aVar) {
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
            this.f15899e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15899e.f15890b) {
                    if (m.isEmpty(this.f15899e.f15896h) || this.f15899e.f15894f == null || this.f15899e.f15894f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f15899e.a, new String[]{this.f15899e.f15896h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f15899e.f15894f.getForum().getId()).param("obj_type", this.f15899e.f15897i ? 2 : 1));
                } else if ((view != this.f15899e.f15892d && view != this.f15899e.f15893e) || this.f15899e.f15894f == null || this.f15899e.f15894f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f15899e.a.getPageActivity(), this.f15899e.f15894f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f15899e.f15894f.getForum().getId()));
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
        this.f15898j = new View$OnClickListenerC1014a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.a = frsSportsRecommendFragment.getPageContext();
        this.f15890b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f15891c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f15892d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f15893e = (TextView) view.findViewById(R.id.forum_name);
        this.f15890b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f15892d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f15892d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f15892d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f15892d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f15892d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f15893e, (int) R.color.CAM_X0101);
            BarImageView barImageView = this.f15892d;
            if (barImageView != null) {
                barImageView.setBorderWidth(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f15892d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f15892d.setStrokeColorResId(R.color.CAM_X0201);
                this.f15892d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f15894f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f15895g) {
            return;
        }
        LinearGradientView linearGradientView = this.f15891c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f15891c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f15890b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f15894f = frsViewData;
        this.f15895g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f15893e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f15892d.startLoad(this.f15894f.getForum().getImage_url(), 10, false);
        i();
        this.f15892d.setOnClickListener(this.f15898j);
        this.f15893e.setOnClickListener(this.f15898j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f15892d.refresh();
            if (m.isEmpty(str)) {
                this.f15895g = false;
                i();
                return;
            }
            this.f15895g = true;
            this.f15896h = str2;
            this.f15897i = z;
            this.f15890b.startLoad(str, 10, false);
            this.f15890b.setOnClickListener(this.f15898j);
        }
    }
}
