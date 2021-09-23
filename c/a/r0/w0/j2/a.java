package c.a.r0.w0.j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26921a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f26922b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f26923c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f26924d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26925e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f26926f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26927g;

    /* renamed from: h  reason: collision with root package name */
    public String f26928h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26929i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f26930j;

    /* renamed from: c.a.r0.w0.j2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1257a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26931e;

        public View$OnClickListenerC1257a(a aVar) {
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
            this.f26931e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f26931e.f26922b) {
                    if (k.isEmpty(this.f26931e.f26928h) || this.f26931e.f26926f == null || this.f26931e.f26926f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f26931e.f26921a, new String[]{this.f26931e.f26928h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f26931e.f26926f.getForum().getId()).param("obj_type", this.f26931e.f26929i ? 2 : 1));
                } else if ((view != this.f26931e.f26924d && view != this.f26931e.f26925e) || this.f26931e.f26926f == null || this.f26931e.f26926f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f26931e.f26921a.getPageActivity(), this.f26931e.f26926f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f26931e.f26926f.getForum().getId()));
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
        this.f26930j = new View$OnClickListenerC1257a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f26921a = frsSportsRecommendFragment.getPageContext();
        this.f26922b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f26923c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f26924d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f26925e = (TextView) view.findViewById(R.id.forum_name);
        this.f26922b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f26924d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f26924d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26924d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f26924d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f26924d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f26925e, R.color.CAM_X0101);
            BarImageView barImageView = this.f26924d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f26924d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f26924d.setStrokeColorResId(R.color.CAM_X0201);
                this.f26924d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f26926f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f26927g) {
            return;
        }
        LinearGradientView linearGradientView = this.f26923c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f26923c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f26922b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f26926f = frsViewData;
        this.f26927g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f26925e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f26924d.startLoad(this.f26926f.getForum().getImage_url(), 10, false);
        i();
        this.f26924d.setOnClickListener(this.f26930j);
        this.f26925e.setOnClickListener(this.f26930j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f26924d.refresh();
            if (k.isEmpty(str)) {
                this.f26927g = false;
                i();
                return;
            }
            this.f26927g = true;
            this.f26928h = str2;
            this.f26929i = z;
            this.f26922b.startLoad(str, 10, false);
            this.f26922b.setOnClickListener(this.f26930j);
        }
    }
}
