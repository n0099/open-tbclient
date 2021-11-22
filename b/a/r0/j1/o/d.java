package b.a.r0.j1.o;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import b.a.e.a.f;
import b.a.e.f.p.k;
import b.a.r0.j1.h;
import b.a.r0.j1.j.j;
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
/* loaded from: classes4.dex */
public class d extends b.a.e.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f19859a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19860b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f19861c;

    /* renamed from: d  reason: collision with root package name */
    public View f19862d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f19863e;

    /* renamed from: f  reason: collision with root package name */
    public j f19864f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f19865g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19866h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f19867i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19868e;

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
            this.f19868e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f19868e.f19865g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", b.a.r0.j1.l.k.f19802a).param("topic_id", this.f19868e.f19859a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19868e.f19859a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f19860b = null;
        this.f19862d = null;
        this.f19863e = null;
        this.f19865g = null;
        this.f19867i = new a(this);
        this.f19859a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f19865g = list.subList(0, 20);
            } else {
                this.f19865g = list;
            }
        }
        g();
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19864f : (j) invokeV.objValue;
    }

    public void f() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f19863e) == null || this.f19866h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f19866h.j();
    }

    public final void g() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f19859a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(b.a.r0.j1.f.hot_topic_more_activity);
        View findViewById = this.f19859a.findViewById(b.a.r0.j1.e.topic_list_root_view);
        this.f19862d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(b.a.r0.j1.e.view_navigation_bar);
        this.f19860b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19860b.setTitleText(h.hot_topic_list_navigationbar_title);
        this.f19861c = (NoNetworkView) this.f19862d.findViewById(b.a.r0.j1.e.view_no_network);
        this.f19863e = (BdListView) this.f19862d.findViewById(b.a.r0.j1.e.hot_topic_more_list);
        BdListViewHelper.d(this.f19859a.getActivity(), this.f19863e, BdListViewHelper.HeadType.DEFAULT);
        this.f19864f = new j(this.f19859a);
        PbListView pbListView = new PbListView(this.f19859a.getPageContext().getPageActivity());
        this.f19866h = pbListView;
        pbListView.a();
        this.f19866h.p(b.a.r0.j1.b.CAM_X0201);
        this.f19863e.setAdapter((ListAdapter) this.f19864f);
        this.f19864f.d(this.f19865g, this.f19859a.getTopicId());
        this.f19863e.setOnItemClickListener(this.f19867i);
    }

    public void h() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f19863e) == null || (pbListView = this.f19866h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f19866h.f();
        this.f19866h.C(this.f19859a.getResources().getString(h.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f19859a.getLayoutMode().k(i2 == 1);
            this.f19859a.getLayoutMode().j(this.f19862d);
            this.f19860b.onChangeSkinType(this.f19859a.getPageContext(), i2);
            this.f19861c.onChangeSkinType(this.f19859a.getPageContext(), i2);
            this.f19866h.d(i2);
        }
    }
}
