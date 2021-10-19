package c.a.r0.x0.j2;

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
    public TbPageContext f27096a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f27097b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f27098c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f27099d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27100e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f27101f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27102g;

    /* renamed from: h  reason: collision with root package name */
    public String f27103h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27104i;

    /* renamed from: j  reason: collision with root package name */
    public final View.OnClickListener f27105j;

    /* renamed from: c.a.r0.x0.j2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1266a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27106e;

        public View$OnClickListenerC1266a(a aVar) {
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
            this.f27106e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f27106e.f27097b) {
                    if (k.isEmpty(this.f27106e.f27103h) || this.f27106e.f27101f == null || this.f27106e.f27101f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f27106e.f27096a, new String[]{this.f27106e.f27103h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f27106e.f27101f.getForum().getId()).param("obj_type", this.f27106e.f27104i ? 2 : 1));
                } else if ((view != this.f27106e.f27099d && view != this.f27106e.f27100e) || this.f27106e.f27101f == null || this.f27106e.f27101f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f27106e.f27096a.getPageActivity(), this.f27106e.f27101f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f27106e.f27101f.getForum().getId()));
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
        this.f27105j = new View$OnClickListenerC1266a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f27096a = frsSportsRecommendFragment.getPageContext();
        this.f27097b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f27098c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f27099d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f27100e = (TextView) view.findViewById(R.id.forum_name);
        this.f27097b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f27099d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f27099d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f27099d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f27099d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f27099d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f27100e, R.color.CAM_X0101);
            BarImageView barImageView = this.f27099d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f27099d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f27099d.setStrokeColorResId(R.color.CAM_X0201);
                this.f27099d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f27101f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f27102g) {
            return;
        }
        LinearGradientView linearGradientView = this.f27098c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f27098c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f27097b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f27101f = frsViewData;
        this.f27102g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f27100e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f27099d.startLoad(this.f27101f.getForum().getImage_url(), 10, false);
        i();
        this.f27099d.setOnClickListener(this.f27105j);
        this.f27100e.setOnClickListener(this.f27105j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f27099d.refresh();
            if (k.isEmpty(str)) {
                this.f27102g = false;
                i();
                return;
            }
            this.f27102g = true;
            this.f27103h = str2;
            this.f27104i = z;
            this.f27097b.startLoad(str, 10, false);
            this.f27097b.setOnClickListener(this.f27105j);
        }
    }
}
