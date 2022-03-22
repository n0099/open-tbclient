package c.a.p0.f1.n2;

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
    public TbImageView f14279b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f14280c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f14281d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14282e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f14283f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14284g;

    /* renamed from: h  reason: collision with root package name */
    public String f14285h;
    public boolean i;
    public final View.OnClickListener j;

    /* renamed from: c.a.p0.f1.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1073a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1073a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.f14279b) {
                    if (m.isEmpty(this.a.f14285h) || this.a.f14283f == null || this.a.f14283f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.f14285h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.a.f14283f.getForum().getId()).param("obj_type", this.a.i ? 2 : 1));
                } else if ((view != this.a.f14281d && view != this.a.f14282e) || this.a.f14283f == null || this.a.f14283f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.a.getPageActivity(), this.a.f14283f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.a.f14283f.getForum().getId()));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new View$OnClickListenerC1073a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.a = frsSportsRecommendFragment.getPageContext();
        this.f14279b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090d29);
        this.f14280c = (LinearGradientView) view.findViewById(R.id.obfuscated_res_0x7f090d2b);
        this.f14281d = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090b37);
        this.f14282e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a67);
        this.f14279b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f14281d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f14281d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14281d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
        this.f14281d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f14281d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f14282e, (int) R.color.CAM_X0101);
            BarImageView barImageView = this.f14281d;
            if (barImageView != null) {
                barImageView.setBorderWidth(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f14281d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f14281d.setStrokeColorResId(R.color.CAM_X0201);
                this.f14281d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f14283f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f14284g) {
            return;
        }
        LinearGradientView linearGradientView = this.f14280c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f14280c.a(skinType);
        }
        TbImageView tbImageView = this.f14279b;
        if (tbImageView != null) {
            tbImageView.J(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f14283f = frsViewData;
        this.f14284g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f14282e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f072f), name));
        this.f14281d.J(this.f14283f.getForum().getImage_url(), 10, false);
        i();
        this.f14281d.setOnClickListener(this.j);
        this.f14282e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f14281d.refresh();
            if (m.isEmpty(str)) {
                this.f14284g = false;
                i();
                return;
            }
            this.f14284g = true;
            this.f14285h = str2;
            this.i = z;
            this.f14279b.J(str, 10, false);
            this.f14279b.setOnClickListener(this.j);
        }
    }
}
