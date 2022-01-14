package c.a.t0.q1.o;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.d.a.f;
import c.a.d.f.p.m;
import c.a.t0.q1.h;
import c.a.t0.q1.j.j;
import c.a.t0.q1.l.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends c.a.d.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelateTopicForumActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21614b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f21615c;

    /* renamed from: d  reason: collision with root package name */
    public View f21616d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21617e;

    /* renamed from: f  reason: collision with root package name */
    public j f21618f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f21619g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f21620h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f21621i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21622e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21622e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f21622e.f21619g.get(i2)) == null || !m.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", k.a).param("topic_id", this.f21622e.a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f21622e.a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relateTopicForumActivity, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21614b = null;
        this.f21616d = null;
        this.f21617e = null;
        this.f21619g = null;
        this.f21621i = new a(this);
        this.a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f21619g = list.subList(0, 20);
            } else {
                this.f21619g = list;
            }
        }
        g();
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21618f : (j) invokeV.objValue;
    }

    public void f() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21617e) == null || this.f21620h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f21620h.j();
    }

    public final void g() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(c.a.t0.q1.f.hot_topic_more_activity);
        View findViewById = this.a.findViewById(c.a.t0.q1.e.topic_list_root_view);
        this.f21616d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(c.a.t0.q1.e.view_navigation_bar);
        this.f21614b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21614b.setTitleText(h.hot_topic_list_navigationbar_title);
        this.f21615c = (NoNetworkView) this.f21616d.findViewById(c.a.t0.q1.e.view_no_network);
        this.f21617e = (BdListView) this.f21616d.findViewById(c.a.t0.q1.e.hot_topic_more_list);
        BdListViewHelper.d(this.a.getActivity(), this.f21617e, BdListViewHelper.HeadType.DEFAULT);
        this.f21618f = new j(this.a);
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f21620h = pbListView;
        pbListView.a();
        this.f21620h.p(c.a.t0.q1.b.CAM_X0201);
        this.f21617e.setAdapter((ListAdapter) this.f21618f);
        this.f21618f.d(this.f21619g, this.a.getTopicId());
        this.f21617e.setOnItemClickListener(this.f21621i);
    }

    public void h() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f21617e) == null || (pbListView = this.f21620h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f21620h.f();
        this.f21620h.D(this.a.getResources().getString(h.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f21616d);
            this.f21614b.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21615c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21620h.d(i2);
        }
    }
}
