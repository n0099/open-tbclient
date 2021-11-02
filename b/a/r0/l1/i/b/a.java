package b.a.r0.l1.i.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.d;
import b.a.e.a.f;
import b.a.q0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ItemEmotionView;
import com.baidu.tieba.im.forum.detail.ItemFootNavView;
import com.baidu.tieba.im.forum.detail.ItemHeaderView;
import com.baidu.tieba.im.forum.detail.ItemHotThreadView;
import com.baidu.tieba.im.forum.detail.ItemInfoView;
import com.baidu.tieba.im.forum.detail.ItemMsgManage;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes5.dex */
public class a extends d<ForumDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumDetailActivity f20196a;

    /* renamed from: b  reason: collision with root package name */
    public View f20197b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f20198c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f20199d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f20200e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f20201f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f20202g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f20203h;

    /* renamed from: i  reason: collision with root package name */
    public ItemInfoView f20204i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public b.a.q0.s.s.a n;
    public View.OnClickListener o;

    /* renamed from: b.a.r0.l1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1000a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20205e;

        public C1000a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20205e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20205e.n.dismiss();
                this.f20205e.f20196a.clearHistory();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20206e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20206e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20206e.n.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20207e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20207e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f20207e.m.showLine(false);
                } else if (action == 1) {
                    this.f20207e.m.showLine(true);
                } else if (action == 2) {
                    this.f20207e.m.showLine(false);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ c(a aVar, C1000a c1000a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(927702125, "Lb/a/r0/l1/i/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(927702125, "Lb/a/r0/l1/i/b/a;");
                return;
            }
        }
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumDetailActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20196a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20200e : (NoNetworkView) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20196a.hideLoadingView(this.f20197b);
        }
    }

    public void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f20201f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m.onResume(this.f20196a);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20198c = (LinearLayout) this.f20196a.findViewById(R.id.scoll_view_ll);
            TextView textView = new TextView(this.f20196a.getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.f20198c.addView(textView, 0);
            NavigationBar navigationBar = (NavigationBar) this.f20196a.findViewById(R.id.view_navigation_bar);
            this.f20199d = navigationBar;
            navigationBar.setCenterTextTitle(this.f20196a.getPageContext().getString(R.string.forum_detail_title));
            this.f20199d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20199d.showBottomLine();
            this.f20200e = (NoNetworkView) this.f20196a.findViewById(R.id.no_network_view);
            CustomScrollView customScrollView = (CustomScrollView) this.f20196a.findViewById(R.id.scoll_view);
            this.f20202g = customScrollView;
            customScrollView.setOnTouchListener(new c(this, null));
            this.f20203h = (ItemHeaderView) this.f20196a.findViewById(R.id.item_header);
            this.f20204i = (ItemInfoView) this.f20196a.findViewById(R.id.item_info);
            this.j = (ItemMsgManage) this.f20196a.findViewById(R.id.item_msg_manage);
            this.k = (ItemEmotionView) this.f20196a.findViewById(R.id.item_emotion_manage);
            this.l = (ItemHotThreadView) this.f20196a.findViewById(R.id.item_hot_thread);
            ItemFootNavView itemFootNavView = (ItemFootNavView) this.f20196a.findViewById(R.id.item_foot_nav);
            this.m = itemFootNavView;
            itemFootNavView.setClickable(true);
            this.f20197b = this.f20196a.findViewById(R.id.root_rl);
            this.j.setMsgOnClickListener(this.f20196a);
            this.k.setEmotionOnClickListener(this.f20196a);
            this.j.setSwitchChangeListener(this.f20196a);
        }
    }

    public void j(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumEmotionData) == null) {
            this.k.setEmotionData(forumEmotionData);
        }
    }

    public void k(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{recommendForumInfo, Boolean.valueOf(z), Boolean.valueOf(z2), managerApplyInfo, priManagerApplyInfo, managerElectionTab, bzApplySwitch}) == null) {
            this.f20203h.setData(recommendForumInfo);
            this.f20204i.setData(recommendForumInfo);
            this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
            this.m.setData(recommendForumInfo, this.f20196a);
        }
    }

    public void l(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, recommendForumInfo, z) == null) {
            this.j.setShowState(recommendForumInfo, z);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j.setSwitch(z);
        }
    }

    public void o(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.l.setData(list);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f20196a.getLayoutMode().k(i2 == 1);
            this.f20196a.getLayoutMode().j(this.f20197b);
            this.f20199d.onChangeSkinType(getPageContext(), i2);
            this.f20200e.onChangeSkinType(getPageContext(), i2);
            this.f20203h.onChangeSkinType(this.f20196a, i2);
            this.f20204i.onChangeSkinType(this.f20196a, i2);
            this.j.onChangeSkinType(this.f20196a, i2);
            this.l.onChangeSkinType(this.f20196a, i2);
            this.m.onChangeSkinType(this.f20196a, i2);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.n == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f20196a.getPageContext().getPageActivity());
                this.n = aVar;
                aVar.setMessageId(R.string.officical_bar_info_clean_alert);
                this.n.setPositiveButton(R.string.alert_yes_button, new C1000a(this));
                this.n.setNegativeButton(R.string.cancel, new b(this));
            }
            this.n.create(getPageContext()).show();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f20196a.showLoadingView(this.f20197b);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.f20201f == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f20196a.getPageContext().getPageActivity(), this.f20198c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f20196a.getResources().getString(i2)), null);
                this.f20201f = a2;
                a2.setOnClickListener(this.o);
            }
            this.f20201f.setTextOption(NoDataViewFactory.e.d(null, this.f20196a.getResources().getString(i2)));
            this.f20201f.onChangeSkinType(this.f20196a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f20201f.setVisibility(0);
        }
    }

    public void s(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, recommendForumInfo, z) == null) {
            this.m.updateCareBtn(z);
            this.j.setShowState(recommendForumInfo, z);
        }
    }
}
