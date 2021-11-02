package b.a.r0.r3.f.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.r3.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity;
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
    public BubbleGroupActivity f23185a;

    /* renamed from: b  reason: collision with root package name */
    public View f23186b;

    /* renamed from: c  reason: collision with root package name */
    public View f23187c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23188d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f23189e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f23190f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23191g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23192h;

    /* renamed from: i  reason: collision with root package name */
    public int f23193i;
    public b.a.r0.r3.f.b.a j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23194e;

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
            this.f23194e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(this.f23194e.f23185a.getActivity())));
            }
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, b.a.r0.r3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleGroupActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23193i = 0;
        this.f23185a = bubbleGroupActivity;
        this.f23193i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f23185a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f23186b = inflate;
        this.f23185a.setContentView(inflate);
        this.f23187c = this.f23186b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23186b.findViewById(R.id.view_navigation_bar);
        this.f23188d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23188d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23186b.findViewById(R.id.view_member_recommend);
        this.f23189e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f23190f = (BdListView) this.f23186b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f23185a.getActivity());
        this.f23191g = textView;
        textView.setHeight(l.g(this.f23185a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f23185a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f23192h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f23192h.setOnClickListener(new a(this));
        this.j = new b.a.r0.r3.f.b.a(this.f23185a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f23185a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f23185a.getActivity(), R.dimen.ds98)));
        this.f23190f.addHeaderView(textView3, 0);
        this.f23190f.addFooterView(this.f23192h);
        this.f23190f.setAdapter((ListAdapter) this.j);
    }

    public final List<Object> b(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                List<DressItemData> a2 = bVar.a();
                int size = a2.size();
                if (size != 0) {
                    arrayList.add(bVar.b());
                    if (size > 4) {
                        size = 4;
                    }
                    for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < 2; i3++) {
                            int i4 = i2 + i3;
                            if (i4 < size) {
                                arrayList2.add(a2.get(i4));
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f23186b, R.color.CAM_X0204);
            this.f23185a.hideNetRefreshView(this.f23186b);
            this.f23187c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23186b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23187c.setVisibility(8);
        }
    }

    public void f() {
        b.a.r0.r3.f.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.w0.a.a(this.f23185a.getPageContext(), this.f23186b);
            b.a.q0.w0.a.a(this.f23185a.getPageContext(), this.f23192h);
            NavigationBar navigationBar = this.f23188d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23185a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f23190f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
                aVar.notifyDataSetChanged();
            }
            this.f23189e.changeSkinType();
            SkinManager.setBackgroundColor(this.f23191g, R.color.CAM_X0204);
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23190f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f23190f.setVisibility(8);
        }
    }

    public final boolean h(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23189e.setVisibility(0);
                this.f23189e.fillView(eVar);
                return true;
            }
            this.f23189e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23187c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f23187c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23186b, R.color.CAM_X0201);
            String string = this.f23185a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23185a.setNetRefreshViewTopMargin(this.f23193i);
            this.f23185a.showNetRefreshView(this.f23186b, string, false);
        }
    }

    public void k(e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f23190f.removeHeaderView(this.f23191g);
                    this.f23190f.addHeaderView(this.f23191g);
                } else {
                    this.f23190f.removeHeaderView(this.f23191g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
