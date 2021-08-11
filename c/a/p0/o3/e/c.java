package c.a.p0.o3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundGroupActivity f22984a;

    /* renamed from: b  reason: collision with root package name */
    public View f22985b;

    /* renamed from: c  reason: collision with root package name */
    public View f22986c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f22987d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f22988e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f22989f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22990g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22991h;

    /* renamed from: i  reason: collision with root package name */
    public int f22992i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.o3.e.a f22993j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22994e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22994e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(this.f22994e.f22984a.getActivity())));
            }
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundGroupActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22992i = 0;
        this.f22984a = backgroundGroupActivity;
        this.f22992i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f22984a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f22985b = inflate;
        this.f22984a.setContentView(inflate);
        this.f22986c = this.f22985b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f22985b.findViewById(R.id.view_navigation_bar);
        this.f22987d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f22987d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f22985b.findViewById(R.id.view_member_recommend);
        this.f22988e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f22989f = (BdListView) this.f22985b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f22984a.getActivity());
        this.f22990g = textView;
        textView.setHeight(l.g(this.f22984a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f22984a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f22991h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f22991h.setOnClickListener(new a(this));
        this.f22993j = new c.a.p0.o3.e.a(this.f22984a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f22984a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f22984a.getActivity(), R.dimen.ds98)));
        this.f22989f.addHeaderView(textView3, 0);
        this.f22989f.addFooterView(this.f22991h);
        this.f22989f.setAdapter((ListAdapter) this.f22993j);
    }

    public final List<Object> b(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.b());
                List<DressItemData> a2 = bVar.a();
                int size = a2.size();
                if (size > 3) {
                    size = 3;
                }
                for (int i2 = 0; i2 < size; i2 = i2 + 2 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < 3; i3++) {
                        int i4 = i2 + i3;
                        if (i4 < size) {
                            arrayList2.add(a2.get(i4));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f22985b, R.color.CAM_X0204);
            this.f22984a.hideNetRefreshView(this.f22985b);
            this.f22986c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22985b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22986c.setVisibility(8);
        }
    }

    public void f() {
        c.a.p0.o3.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.o0.u0.a.a(this.f22984a.getPageContext(), this.f22985b);
            this.f22984a.getLayoutMode().j(this.f22991h);
            c.a.o0.s.u.c.d(this.f22991h).t(R.color.CAM_X0108);
            NavigationBar navigationBar = this.f22987d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f22984a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f22989f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f22993j) != null) {
                aVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f22990g, R.color.CAM_X0204);
            this.f22988e.changeSkinType();
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f22989f.setVisibility(0);
                this.f22993j.a(list);
                this.f22993j.notifyDataSetChanged();
                return;
            }
            this.f22989f.setVisibility(8);
        }
    }

    public final boolean h(c.a.p0.o3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f22988e.setVisibility(0);
                this.f22988e.fillView(eVar);
                return true;
            }
            this.f22988e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22986c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22986c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f22985b, R.color.CAM_X0201);
            String string = this.f22984a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f22984a.setNetRefreshViewTopMargin(this.f22992i);
            this.f22984a.showNetRefreshView(this.f22985b, string, false);
        }
    }

    public void k(c.a.p0.o3.h.e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f22989f.removeHeaderView(this.f22990g);
                    this.f22989f.addHeaderView(this.f22990g);
                } else {
                    this.f22989f.removeHeaderView(this.f22990g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
