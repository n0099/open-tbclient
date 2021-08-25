package c.a.q0.v0.i1.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f26220a;

    /* renamed from: b  reason: collision with root package name */
    public View f26221b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26222c;

    /* renamed from: d  reason: collision with root package name */
    public BottomMenuView f26223d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f26224e;

    /* renamed from: f  reason: collision with root package name */
    public int f26225f;

    /* renamed from: g  reason: collision with root package name */
    public int f26226g;

    /* renamed from: h  reason: collision with root package name */
    public int f26227h;

    public a(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26220a = tbPageContext;
        this.f26221b = view;
        this.f26222c = (ImageView) view.findViewById(R.id.normal_write_icon);
        BottomMenuView bottomMenuView = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.f26223d = bottomMenuView;
        bottomMenuView.setOnMenuItemClickListener(this);
        this.f26225f = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.f26226g = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.f26227h = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, subMenuItemView, subBottomMenu) == null) || subBottomMenu == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f26220a, new String[]{subBottomMenu.url});
        ForumData forumData = this.f26224e;
        String id = forumData != null ? forumData.getId() : "";
        ForumData forumData2 = this.f26224e;
        TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", subBottomMenu.name));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void b(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItemView, bottomMenu) == null) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (bottomMenu != null && ListUtils.getCount(bottomMenu.submenu) == 0) {
                UrlManager.getInstance().dealOneLink(this.f26220a, new String[]{bottomMenu.url});
                ForumData forumData = this.f26224e;
                String id = forumData != null ? forumData.getId() : "";
                ForumData forumData2 = this.f26224e;
                TiebaStatic.log(new StatisticItem("c13117").param("fid", id).param("fname", forumData2 != null ? forumData2.getName() : "").param("uid", currentAccountId).param("obj_param1", bottomMenu.name));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13118").param("uid", currentAccountId));
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f26222c.getLayoutParams();
            if (z) {
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.addRule(14, 0);
                layoutParams.bottomMargin = this.f26225f;
                layoutParams.rightMargin = this.f26226g;
                return;
            }
            layoutParams.addRule(11, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = this.f26227h;
            layoutParams.rightMargin = 0;
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) && this.f26223d.getVisibility() == 0) {
            this.f26223d.onChangeSkinType(tbPageContext, i2);
        }
    }

    public void e(List<BottomMenu> list, ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, forumData) == null) {
            this.f26224e = forumData;
            boolean z = ListUtils.getCount(list) > 0;
            c(z);
            if (z) {
                this.f26223d.setVisibility(0);
                this.f26223d.showMenu(list, this.f26220a);
                return;
            }
            this.f26223d.setVisibility(8);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f26223d.setVisibility(z ? 0 : 8);
        }
    }
}
