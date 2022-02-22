package c.a.u0.p1.l.a;

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
import c.a.d.o.e.v;
import c.a.t0.g0.g;
import c.a.t0.g0.h;
import c.a.u0.p1.l.a.c.c;
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
/* loaded from: classes8.dex */
public class b implements c.a.t0.y0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f20856e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20857f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f20858g;

    /* renamed from: h  reason: collision with root package name */
    public View f20859h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f20860i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f20861j;
    public RelativeLayout k;
    public BdTypeRecyclerView l;
    public g m;
    public h n;
    public View.OnClickListener o;
    public boolean p;

    /* loaded from: classes8.dex */
    public class a implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20862e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20862e = bVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f20862e.f20856e == null || this.f20862e.f20856e.getPageActivity() == null || !(nVar instanceof c.a.u0.p1.l.a.c.b)) {
                return;
            }
            this.f20862e.s();
            String str = ((c.a.u0.p1.l.a.c.b) nVar).f20867e;
            if (!this.f20862e.p) {
                if (this.f20862e.f20856e.getPageActivity() instanceof SuspendedActivity) {
                    ((SuspendedActivity) this.f20862e.f20856e.getPageActivity()).setForceFinishWithoutAnim(true);
                }
                this.f20862e.f20856e.getPageActivity().finish();
                if (this.f20862e.f20856e == null || this.f20862e.f20856e.getPageActivity() == null) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f20862e.f20856e.getPageActivity()).setType(9).setFrom("main_tab").setCallFrom("2").setIsPostLocalChannelDynamic(true).setLocalChannelTopic(str).send();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC, str);
            this.f20862e.f20856e.getPageActivity().setResult(-1, intent);
            this.f20862e.f20856e.getPageActivity().finish();
        }
    }

    /* renamed from: c.a.u0.p1.l.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1278b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20864f;

        public View$OnClickListenerC1278b(b bVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20864f = bVar;
            this.f20863e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20864f.f20856e == null) {
                return;
            }
            this.f20864f.r();
            this.f20864f.k(this.f20863e);
        }
    }

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20856e = tbPageContext;
        this.f20857f = linearLayout;
        this.f20858g = navigationBar;
        this.o = onClickListener;
        j();
        i();
    }

    @Override // c.a.t0.y0.a
    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.l.setPressed(false);
        }
    }

    public final void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.k == null || (gVar = this.m) == null || !gVar.isViewAttached()) {
            return;
        }
        this.m.dettachView(this.k);
    }

    @Override // c.a.t0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k == null || (hVar = this.n) == null || !hVar.isViewAttached()) {
            return;
        }
        this.n.dettachView(this.k);
    }

    public final void i() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tbPageContext = this.f20856e) == null || this.f20857f == null) {
            return;
        }
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.layout_local_channel_topic_list, (ViewGroup) this.f20857f, true);
        this.k = (RelativeLayout) this.f20857f.findViewById(R.id.local_channel_topic_list_root);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f20857f.findViewById(R.id.recycler_view);
        this.l = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f20856e.getPageActivity()));
        this.l.setFadingEdgeLength(0);
        this.l.setOverScrollMode(2);
        this.l.addItemDecoration(new LocalChannelTopicDecoration());
        ArrayList arrayList = new ArrayList();
        c.a.u0.p1.l.a.a aVar = new c.a.u0.p1.l.a.a(this.f20856e, c.a.u0.p1.l.a.c.b.f20866i);
        aVar.V(new a(this));
        arrayList.add(aVar);
        this.l.addAdapters(arrayList);
        this.l.setVisibility(8);
        h();
        o();
    }

    @Override // c.a.t0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getVisibility() != 0) {
                return true;
            }
            return this.l.getFirstVisiblePosition() == 0 && this.l.getChildAt(0) != null && this.l.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f20856e == null || (navigationBar = this.f20858g) == null) {
            return;
        }
        navigationBar.setFixedHeight(false);
        if (this.f20858g.getContentLayout() != null && this.f20858g.getContentLayout().getLayoutParams() != null) {
            this.f20858g.getContentLayout().getLayoutParams().height = c.a.d.f.p.n.f(this.f20856e.getPageActivity(), R.dimen.tbds161);
            this.f20858g.getContentLayout().requestLayout();
        }
        this.f20859h = LayoutInflater.from(this.f20856e.getPageActivity()).inflate(R.layout.layout_local_channel_topic_navigation, this.f20858g.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER), true);
        this.f20860i = (EMTextView) this.f20858g.findViewById(R.id.local_channel_topic_guide_title);
        this.f20861j = (EMTextView) this.f20858g.findViewById(R.id.local_channel_topic_guide_subtitle);
    }

    public final void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f20856e.getPageActivity());
            pbActivityConfig.setThreadId(cVar.a.f20865b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || intent == null) {
            return;
        }
        this.p = intent.getBooleanExtra(LocalChannelTopicListActivityConfig.KEY_IS_RESPONSE_FOR_TOPIC, false);
        t();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            p(this.f20856e.getString(R.string.list_has_no_more), true);
            g();
            this.l.setVisibility(8);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            g();
            p(str, false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f20856e == null || this.k == null) {
            return;
        }
        g gVar = this.m;
        if (gVar == null || !gVar.isViewAttached()) {
            if (this.m == null) {
                this.m = new g(this.f20856e.getPageActivity());
            }
            this.m.attachView(this.k);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // c.a.t0.y0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || this.f20856e == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f20860i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f20861j, R.color.CAM_X0108);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0108), null);
        if (this.f20861j != null && pureDrawable != null) {
            int f2 = c.a.d.f.p.n.f(this.f20856e.getPageActivity(), R.dimen.tbds31);
            pureDrawable.setBounds(0, 0, f2, f2);
            this.f20861j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.m(i2);
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.l;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.l.getAdapter().notifyDataSetChanged();
    }

    public final void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) || this.f20856e == null || this.k == null) {
            return;
        }
        h hVar = this.n;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.n == null) {
                this.n = new h(this.f20856e.getPageActivity(), this.o);
            }
            if (z) {
                this.n.i(R.drawable.new_pic_emotion_07);
                this.n.e();
            } else {
                this.n.i(R.drawable.new_pic_emotion_08);
                this.n.p();
            }
            this.n.o(str);
            this.n.attachView(this.k);
        }
    }

    public void q(c cVar) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            if (cVar == null) {
                m();
            } else if (this.f20859h == null || (eMTextView = this.f20861j) == null || this.l == null) {
            } else {
                c.a.u0.p1.l.a.c.a aVar = cVar.a;
                if (aVar != null) {
                    eMTextView.setText(aVar.a);
                    this.f20861j.setVisibility(0);
                    this.f20859h.setOnClickListener(new View$OnClickListenerC1278b(this, cVar));
                }
                if (ListUtils.isEmpty(cVar.f20871b)) {
                    m();
                    return;
                }
                g();
                h();
                this.l.setVisibility(0);
                this.l.setData(cVar.f20871b);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c14524"));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c14523"));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TiebaStatic.log(new StatisticItem("c14522").param("obj_source", this.p ? 2 : 1));
        }
    }
}
