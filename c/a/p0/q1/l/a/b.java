package c.a.p0.q1.l.a;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.p0.q1.l.a.c.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.local.LocalChannelTopicDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b implements c.a.o0.x0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f17527b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17528c;

    /* renamed from: d  reason: collision with root package name */
    public View f17529d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f17530e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f17531f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17532g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f17533h;
    public g i;
    public h j;
    public View.OnClickListener k;
    public boolean l;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.a == null || this.a.a.getPageActivity() == null || !(nVar instanceof c.a.p0.q1.l.a.c.b)) {
                return;
            }
            this.a.r();
            String str = ((c.a.p0.q1.l.a.c.b) nVar).a;
            if (!this.a.l) {
                if (this.a.a.getPageActivity() instanceof SuspendedActivity) {
                    ((SuspendedActivity) this.a.a.getPageActivity()).setForceFinishWithoutAnim(true);
                }
                this.a.a.getPageActivity().finish();
                if (this.a.a == null || this.a.a.getPageActivity() == null) {
                    return;
                }
                WriteActivityConfig.newInstance(this.a.a.getPageActivity()).setType(9).setFrom("main_tab").setCallFrom("2").setIsPostLocalChannelDynamic(true).setLocalChannelTopic(str).send();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC, str);
            this.a.a.getPageActivity().setResult(-1, intent);
            this.a.a.getPageActivity().finish();
        }
    }

    /* renamed from: c.a.p0.q1.l.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1314b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17534b;

        public View$OnClickListenerC1314b(b bVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17534b = bVar;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17534b.a == null) {
                return;
            }
            this.f17534b.q();
            this.f17534b.j(this.a);
        }
    }

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f17527b = linearLayout;
        this.f17528c = navigationBar;
        this.k = onClickListener;
        i();
        h();
    }

    public final void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17532g == null || (gVar = this.i) == null || !gVar.isViewAttached()) {
            return;
        }
        this.i.dettachView(this.f17532g);
    }

    public final void g() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17532g == null || (hVar = this.j) == null || !hVar.isViewAttached()) {
            return;
        }
        this.j.dettachView(this.f17532g);
    }

    @Override // c.a.o0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.a) == null || this.f17527b == null) {
            return;
        }
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d049f, (ViewGroup) this.f17527b, true);
        this.f17532g = (RelativeLayout) this.f17527b.findViewById(R.id.obfuscated_res_0x7f09131d);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f17527b.findViewById(R.id.obfuscated_res_0x7f091a27);
        this.f17533h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.f17533h.setFadingEdgeLength(0);
        this.f17533h.setOverScrollMode(2);
        this.f17533h.addItemDecoration(new LocalChannelTopicDecoration());
        ArrayList arrayList = new ArrayList();
        c.a.p0.q1.l.a.a aVar = new c.a.p0.q1.l.a.a(this.a, c.a.p0.q1.l.a.c.b.f17536e);
        aVar.V(new a(this));
        arrayList.add(aVar);
        this.f17533h.a(arrayList);
        this.f17533h.setVisibility(8);
        g();
        n();
    }

    public final void i() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null || (navigationBar = this.f17528c) == null) {
            return;
        }
        navigationBar.setFixedHeight(false);
        if (this.f17528c.getContentLayout() != null && this.f17528c.getContentLayout().getLayoutParams() != null) {
            this.f17528c.getContentLayout().getLayoutParams().height = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds161);
            this.f17528c.getContentLayout().requestLayout();
        }
        this.f17529d = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a0, this.f17528c.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER), true);
        this.f17530e = (EMTextView) this.f17528c.findViewById(R.id.obfuscated_res_0x7f09131c);
        this.f17531f = (EMTextView) this.f17528c.findViewById(R.id.obfuscated_res_0x7f09131b);
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17533h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getVisibility() != 0) {
                return true;
            }
            return this.f17533h.getFirstVisiblePosition() == 0 && this.f17533h.getChildAt(0) != null && this.f17533h.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageActivity());
            pbActivityConfig.setThreadId(cVar.a.f17535b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        this.l = intent.getBooleanExtra(LocalChannelTopicListActivityConfig.KEY_IS_RESPONSE_FOR_TOPIC, false);
        s();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(this.a.getString(R.string.obfuscated_res_0x7f0f09e6), true);
            f();
            this.f17533h.setVisibility(8);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17533h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            f();
            o(str, false);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a == null || this.f17532g == null) {
            return;
        }
        g gVar = this.i;
        if (gVar == null || !gVar.isViewAttached()) {
            if (this.i == null) {
                this.i = new g(this.a.getPageActivity());
            }
            this.i.attachView(this.f17532g);
        }
    }

    public final void o(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) || this.a == null || this.f17532g == null) {
            return;
        }
        h hVar = this.j;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.j == null) {
                this.j = new h(this.a.getPageActivity(), this.k);
            }
            if (z) {
                this.j.i(R.drawable.new_pic_emotion_07);
                this.j.e();
            } else {
                this.j.i(R.drawable.new_pic_emotion_08);
                this.j.p();
            }
            this.j.o(str);
            this.j.attachView(this.f17532g);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // c.a.o0.x0.b
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f17530e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f17531f, (int) R.color.CAM_X0108);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0108), null);
        if (this.f17531f != null && pureDrawable != null) {
            int f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds31);
            pureDrawable.setBounds(0, 0, f2, f2);
            this.f17531f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.m(i);
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f17533h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f17533h.getAdapter().notifyDataSetChanged();
    }

    public void p(c cVar) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            if (cVar == null) {
                l();
            } else if (this.f17529d == null || (eMTextView = this.f17531f) == null || this.f17533h == null) {
            } else {
                c.a.p0.q1.l.a.c.a aVar = cVar.a;
                if (aVar != null) {
                    eMTextView.setText(aVar.a);
                    this.f17531f.setVisibility(0);
                    this.f17529d.setOnClickListener(new View$OnClickListenerC1314b(this, cVar));
                }
                if (ListUtils.isEmpty(cVar.f17540b)) {
                    l();
                    return;
                }
                f();
                g();
                this.f17533h.setVisibility(0);
                this.f17533h.setData(cVar.f17540b);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(new StatisticItem("c14524"));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c14523"));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c14522").param("obj_source", this.l ? 2 : 1));
        }
    }

    @Override // c.a.o0.x0.a
    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.f17533h.setPressed(false);
        }
    }
}
