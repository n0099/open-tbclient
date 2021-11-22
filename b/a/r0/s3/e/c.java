package b.a.r0.s3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundGroupActivity f24902a;

    /* renamed from: b  reason: collision with root package name */
    public View f24903b;

    /* renamed from: c  reason: collision with root package name */
    public View f24904c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24905d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f24906e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f24907f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24908g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24909h;

    /* renamed from: i  reason: collision with root package name */
    public int f24910i;
    public b.a.r0.s3.e.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24911e;

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
            this.f24911e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(this.f24911e.f24902a.getActivity())));
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
        this.f24910i = 0;
        this.f24902a = backgroundGroupActivity;
        this.f24910i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f24902a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f24903b = inflate;
        this.f24902a.setContentView(inflate);
        this.f24904c = this.f24903b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f24903b.findViewById(R.id.view_navigation_bar);
        this.f24905d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24905d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f24903b.findViewById(R.id.view_member_recommend);
        this.f24906e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f24907f = (BdListView) this.f24903b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f24902a.getActivity());
        this.f24908g = textView;
        textView.setHeight(l.g(this.f24902a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f24902a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f24909h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f24909h.setOnClickListener(new a(this));
        this.j = new b.a.r0.s3.e.a(this.f24902a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f24902a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f24902a.getActivity(), R.dimen.ds98)));
        this.f24907f.addHeaderView(textView3, 0);
        this.f24907f.addFooterView(this.f24909h);
        this.f24907f.setAdapter((ListAdapter) this.j);
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
            SkinManager.setBackgroundColor(this.f24903b, R.color.CAM_X0204);
            this.f24902a.hideNetRefreshView(this.f24903b);
            this.f24904c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24903b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24904c.setVisibility(8);
        }
    }

    public void f() {
        b.a.r0.s3.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.v0.a.a(this.f24902a.getPageContext(), this.f24903b);
            this.f24902a.getLayoutMode().j(this.f24909h);
            b.a.q0.s.u.c.d(this.f24909h).v(R.color.CAM_X0108);
            NavigationBar navigationBar = this.f24905d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24902a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f24907f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
                aVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f24908g, R.color.CAM_X0204);
            this.f24906e.changeSkinType();
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24907f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f24907f.setVisibility(8);
        }
    }

    public final boolean h(b.a.r0.s3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24906e.setVisibility(0);
                this.f24906e.fillView(eVar);
                return true;
            }
            this.f24906e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24904c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24904c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24903b, R.color.CAM_X0201);
            String string = this.f24902a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24902a.setNetRefreshViewTopMargin(this.f24910i);
            this.f24902a.showNetRefreshView(this.f24903b, string, false);
        }
    }

    public void k(b.a.r0.s3.h.e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f24907f.removeHeaderView(this.f24908g);
                    this.f24907f.addHeaderView(this.f24908g);
                } else {
                    this.f24907f.removeHeaderView(this.f24908g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
