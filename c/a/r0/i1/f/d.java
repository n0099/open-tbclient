package c.a.r0.i1.f;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.e.a.f;
import c.a.e.e.p.k;
import c.a.r0.i1.a.j;
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
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends c.a.e.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f19379a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19380b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f19381c;

    /* renamed from: d  reason: collision with root package name */
    public View f19382d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f19383e;

    /* renamed from: f  reason: collision with root package name */
    public j f19384f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f19385g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19386h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f19387i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19388e;

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
            this.f19388e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f19388e.f19385g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", c.a.r0.i1.c.k.f19317a).param("topic_id", this.f19388e.f19379a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19388e.f19379a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f19380b = null;
        this.f19382d = null;
        this.f19383e = null;
        this.f19385g = null;
        this.f19387i = new a(this);
        this.f19379a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f19385g = list.subList(0, 20);
            } else {
                this.f19385g = list;
            }
        }
        g();
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19384f : (j) invokeV.objValue;
    }

    public void f() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f19383e) == null || this.f19386h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f19386h.i();
    }

    public final void g() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f19379a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f19379a.findViewById(R.id.topic_list_root_view);
        this.f19382d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f19380b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19380b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f19381c = (NoNetworkView) this.f19382d.findViewById(R.id.view_no_network);
        this.f19383e = (BdListView) this.f19382d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f19379a.getActivity(), this.f19383e, BdListViewHelper.HeadType.DEFAULT);
        this.f19384f = new j(this.f19379a);
        PbListView pbListView = new PbListView(this.f19379a.getPageContext().getPageActivity());
        this.f19386h = pbListView;
        pbListView.a();
        this.f19386h.o(R.color.CAM_X0201);
        this.f19383e.setAdapter((ListAdapter) this.f19384f);
        this.f19384f.d(this.f19385g, this.f19379a.getTopicId());
        this.f19383e.setOnItemClickListener(this.f19387i);
    }

    public void h() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f19383e) == null || (pbListView = this.f19386h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f19386h.f();
        this.f19386h.A(this.f19379a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f19379a.getLayoutMode().k(i2 == 1);
            this.f19379a.getLayoutMode().j(this.f19382d);
            this.f19380b.onChangeSkinType(this.f19379a.getPageContext(), i2);
            this.f19381c.onChangeSkinType(this.f19379a.getPageContext(), i2);
            this.f19386h.d(i2);
        }
    }
}
