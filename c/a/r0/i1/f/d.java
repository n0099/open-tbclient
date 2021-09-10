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
    public RelateTopicForumActivity f19364a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19365b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f19366c;

    /* renamed from: d  reason: collision with root package name */
    public View f19367d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f19368e;

    /* renamed from: f  reason: collision with root package name */
    public j f19369f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f19370g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19371h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f19372i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19373e;

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
            this.f19373e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f19373e.f19370g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", c.a.r0.i1.c.k.f19302a).param("topic_id", this.f19373e.f19364a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19373e.f19364a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f19365b = null;
        this.f19367d = null;
        this.f19368e = null;
        this.f19370g = null;
        this.f19372i = new a(this);
        this.f19364a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f19370g = list.subList(0, 20);
            } else {
                this.f19370g = list;
            }
        }
        g();
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19369f : (j) invokeV.objValue;
    }

    public void f() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f19368e) == null || this.f19371h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f19371h.i();
    }

    public final void g() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f19364a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f19364a.findViewById(R.id.topic_list_root_view);
        this.f19367d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f19365b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19365b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f19366c = (NoNetworkView) this.f19367d.findViewById(R.id.view_no_network);
        this.f19368e = (BdListView) this.f19367d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f19364a.getActivity(), this.f19368e, BdListViewHelper.HeadType.DEFAULT);
        this.f19369f = new j(this.f19364a);
        PbListView pbListView = new PbListView(this.f19364a.getPageContext().getPageActivity());
        this.f19371h = pbListView;
        pbListView.a();
        this.f19371h.o(R.color.CAM_X0201);
        this.f19368e.setAdapter((ListAdapter) this.f19369f);
        this.f19369f.d(this.f19370g, this.f19364a.getTopicId());
        this.f19368e.setOnItemClickListener(this.f19372i);
    }

    public void h() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f19368e) == null || (pbListView = this.f19371h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f19371h.f();
        this.f19371h.A(this.f19364a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f19364a.getLayoutMode().k(i2 == 1);
            this.f19364a.getLayoutMode().j(this.f19367d);
            this.f19365b.onChangeSkinType(this.f19364a.getPageContext(), i2);
            this.f19366c.onChangeSkinType(this.f19364a.getPageContext(), i2);
            this.f19371h.d(i2);
        }
    }
}
