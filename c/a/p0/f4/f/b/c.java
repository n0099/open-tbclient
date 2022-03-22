package c.a.p0.f4.f.b;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.f4.h.e;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleGroupActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15068b;

    /* renamed from: c  reason: collision with root package name */
    public View f15069c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15070d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f15071e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f15072f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15073g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15074h;
    public int i;
    public c.a.p0.f4.f.b.a j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(this.a.a.getActivity())));
            }
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, c.a.p0.f4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleGroupActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.a = bubbleGroupActivity;
        this.i = n.f(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070297);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0166, (ViewGroup) null);
        this.f15068b = inflate;
        this.a.setContentView(inflate);
        this.f15069c = this.f15068b.findViewById(R.id.obfuscated_res_0x7f090392);
        NavigationBar navigationBar = (NavigationBar) this.f15068b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15070d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15070d.setTitleText(R.string.obfuscated_res_0x7f0f0521);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15068b.findViewById(R.id.obfuscated_res_0x7f0923ce);
        this.f15071e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f15072f = (BdListView) this.f15068b.findViewById(R.id.obfuscated_res_0x7f09128b);
        TextView textView = new TextView(this.a.getActivity());
        this.f15073g = textView;
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        TextView textView2 = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0532, (ViewGroup) null);
        this.f15074h = textView2;
        textView2.setText(R.string.obfuscated_res_0x7f0f0acc);
        this.f15074h.setOnClickListener(new a(this));
        this.j = new c.a.p0.f4.f.b.a(this.a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070282)));
        this.f15072f.x(textView3, 0);
        this.f15072f.addFooterView(this.f15074h);
        this.f15072f.setAdapter((ListAdapter) this.j);
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
                    for (int i = 0; i < size; i = i + 1 + 1) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < 2; i2++) {
                            int i3 = i + i2;
                            if (i3 < size) {
                                arrayList2.add(a2.get(i3));
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
            SkinManager.setBackgroundColor(this.f15068b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15068b);
            this.f15069c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15068b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15069c.setVisibility(8);
        }
    }

    public void f() {
        c.a.p0.f4.f.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f15068b);
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f15074h);
            NavigationBar navigationBar = this.f15070d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f15072f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
                aVar.notifyDataSetChanged();
            }
            this.f15071e.d();
            SkinManager.setBackgroundColor(this.f15073g, R.color.CAM_X0204);
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15072f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f15072f.setVisibility(8);
        }
    }

    public final boolean h(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15071e.setVisibility(0);
                this.f15071e.e(eVar);
                return true;
            }
            this.f15071e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15069c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15069c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15068b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.setNetRefreshViewTopMargin(this.i);
            this.a.showNetRefreshView(this.f15068b, string, false);
        }
    }

    public void k(e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f15072f.removeHeaderView(this.f15073g);
                    this.f15072f.addHeaderView(this.f15073g);
                } else {
                    this.f15072f.removeHeaderView(this.f15073g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
