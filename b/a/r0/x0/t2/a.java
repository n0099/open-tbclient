package b.a.r0.x0.t2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
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

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26338a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f26339b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f26340c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f26341d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26342e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f26343f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26344g;

    /* renamed from: h  reason: collision with root package name */
    public String f26345h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26346i;
    public final View.OnClickListener j;

    /* renamed from: b.a.r0.x0.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1290a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26347e;

        public View$OnClickListenerC1290a(a aVar) {
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
            this.f26347e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f26347e.f26339b) {
                    if (k.isEmpty(this.f26347e.f26345h) || this.f26347e.f26343f == null || this.f26347e.f26343f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f26347e.f26338a, new String[]{this.f26347e.f26345h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f26347e.f26343f.getForum().getId()).param("obj_type", this.f26347e.f26346i ? 2 : 1));
                } else if ((view != this.f26347e.f26341d && view != this.f26347e.f26342e) || this.f26347e.f26343f == null || this.f26347e.f26343f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f26347e.f26338a.getPageActivity(), this.f26347e.f26343f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f26347e.f26343f.getForum().getId()));
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
        this.j = new View$OnClickListenerC1290a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f26338a = frsSportsRecommendFragment.getPageContext();
        this.f26339b = (TbImageView) view.findViewById(e1.head_top_bg_mask);
        this.f26340c = (LinearGradientView) view.findViewById(e1.head_top_gradient_bg);
        this.f26341d = (BarImageView) view.findViewById(e1.frs_image);
        this.f26342e = (TextView) view.findViewById(e1.forum_name);
        this.f26339b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f26341d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f26341d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26341d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(h1.bar_header));
        this.f26341d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), c1.tbds4));
        this.f26341d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f26342e, b1.CAM_X0101);
            BarImageView barImageView = this.f26341d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), c1.tbds1));
                this.f26341d.setBorderColor(SkinManager.getColor(b1.black_alpha15));
                this.f26341d.setStrokeColorResId(b1.CAM_X0201);
                this.f26341d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f26343f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f26344g) {
            return;
        }
        LinearGradientView linearGradientView = this.f26340c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f26340c.changeSkinType(skinType);
        }
        TbImageView tbImageView = this.f26339b;
        if (tbImageView != null) {
            tbImageView.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f26343f = frsViewData;
        this.f26344g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, "...");
        }
        this.f26342e.setText(String.format(TbadkCoreApplication.getInst().getString(h1.frs_sports_recommend_bar_name), name));
        this.f26341d.startLoad(this.f26343f.getForum().getImage_url(), 10, false);
        i();
        this.f26341d.setOnClickListener(this.j);
        this.f26342e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f26341d.refresh();
            if (k.isEmpty(str)) {
                this.f26344g = false;
                i();
                return;
            }
            this.f26344g = true;
            this.f26345h = str2;
            this.f26346i = z;
            this.f26339b.startLoad(str, 10, false);
            this.f26339b.setOnClickListener(this.j);
        }
    }
}
