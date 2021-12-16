package c.a.s0.q1.o;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.s0.q1.h;
import c.a.s0.q1.j.j;
import c.a.s0.q1.l.k;
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
    public NavigationBar f21713b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f21714c;

    /* renamed from: d  reason: collision with root package name */
    public View f21715d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21716e;

    /* renamed from: f  reason: collision with root package name */
    public j f21717f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f21718g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f21719h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f21720i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21721e;

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
            this.f21721e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f21721e.f21718g.get(i2)) == null || !l.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", k.a).param("topic_id", this.f21721e.a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f21721e.a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f21713b = null;
        this.f21715d = null;
        this.f21716e = null;
        this.f21718g = null;
        this.f21720i = new a(this);
        this.a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f21718g = list.subList(0, 20);
            } else {
                this.f21718g = list;
            }
        }
        g();
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21717f : (j) invokeV.objValue;
    }

    public void f() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f21716e) == null || this.f21719h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f21719h.j();
    }

    public final void g() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(c.a.s0.q1.f.hot_topic_more_activity);
        View findViewById = this.a.findViewById(c.a.s0.q1.e.topic_list_root_view);
        this.f21715d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(c.a.s0.q1.e.view_navigation_bar);
        this.f21713b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21713b.setTitleText(h.hot_topic_list_navigationbar_title);
        this.f21714c = (NoNetworkView) this.f21715d.findViewById(c.a.s0.q1.e.view_no_network);
        this.f21716e = (BdListView) this.f21715d.findViewById(c.a.s0.q1.e.hot_topic_more_list);
        BdListViewHelper.d(this.a.getActivity(), this.f21716e, BdListViewHelper.HeadType.DEFAULT);
        this.f21717f = new j(this.a);
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f21719h = pbListView;
        pbListView.a();
        this.f21719h.p(c.a.s0.q1.b.CAM_X0201);
        this.f21716e.setAdapter((ListAdapter) this.f21717f);
        this.f21717f.d(this.f21718g, this.a.getTopicId());
        this.f21716e.setOnItemClickListener(this.f21720i);
    }

    public void h() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f21716e) == null || (pbListView = this.f21719h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f21719h.f();
        this.f21719h.D(this.a.getResources().getString(h.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f21715d);
            this.f21713b.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21714c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21719h.d(i2);
        }
    }
}
