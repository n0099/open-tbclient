package c.a.r0.p3.f.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.p3.h.e;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f23995a;

    /* renamed from: b  reason: collision with root package name */
    public View f23996b;

    /* renamed from: c  reason: collision with root package name */
    public View f23997c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23998d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f23999e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f24000f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24001g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24002h;

    /* renamed from: i  reason: collision with root package name */
    public int f24003i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.p3.f.b.a f24004j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24005e;

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
            this.f24005e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(this.f24005e.f23995a.getActivity())));
            }
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, c.a.r0.p3.f.a.a aVar) {
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
        this.f24003i = 0;
        this.f23995a = bubbleGroupActivity;
        this.f24003i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f23995a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f23996b = inflate;
        this.f23995a.setContentView(inflate);
        this.f23997c = this.f23996b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23996b.findViewById(R.id.view_navigation_bar);
        this.f23998d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23998d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23996b.findViewById(R.id.view_member_recommend);
        this.f23999e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f24000f = (BdListView) this.f23996b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f23995a.getActivity());
        this.f24001g = textView;
        textView.setHeight(l.g(this.f23995a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f23995a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f24002h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f24002h.setOnClickListener(new a(this));
        this.f24004j = new c.a.r0.p3.f.b.a(this.f23995a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f23995a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f23995a.getActivity(), R.dimen.ds98)));
        this.f24000f.addHeaderView(textView3, 0);
        this.f24000f.addFooterView(this.f24002h);
        this.f24000f.setAdapter((ListAdapter) this.f24004j);
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
            SkinManager.setBackgroundColor(this.f23996b, R.color.CAM_X0204);
            this.f23995a.hideNetRefreshView(this.f23996b);
            this.f23997c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23996b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23997c.setVisibility(8);
        }
    }

    public void f() {
        c.a.r0.p3.f.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.w0.a.a(this.f23995a.getPageContext(), this.f23996b);
            c.a.q0.w0.a.a(this.f23995a.getPageContext(), this.f24002h);
            NavigationBar navigationBar = this.f23998d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23995a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f24000f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f24004j) != null) {
                aVar.notifyDataSetChanged();
            }
            this.f23999e.changeSkinType();
            SkinManager.setBackgroundColor(this.f24001g, R.color.CAM_X0204);
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24000f.setVisibility(0);
                this.f24004j.a(list);
                this.f24004j.notifyDataSetChanged();
                return;
            }
            this.f24000f.setVisibility(8);
        }
    }

    public final boolean h(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23999e.setVisibility(0);
                this.f23999e.fillView(eVar);
                return true;
            }
            this.f23999e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23997c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f23997c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23996b, R.color.CAM_X0201);
            String string = this.f23995a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23995a.setNetRefreshViewTopMargin(this.f24003i);
            this.f23995a.showNetRefreshView(this.f23996b, string, false);
        }
    }

    public void k(e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f24000f.removeHeaderView(this.f24001g);
                    this.f24000f.addHeaderView(this.f24001g);
                } else {
                    this.f24000f.removeHeaderView(this.f24001g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
