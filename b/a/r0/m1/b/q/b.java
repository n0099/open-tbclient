package b.a.r0.m1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationTextItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f21148a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21149b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.k0.g.a f21150c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f21151d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f21152e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f21153f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f21154g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f21155h;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f21156i;
    public List<b.a.e.l.e.a> j;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21157a;

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
            this.f21157a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f21157a.f21152e.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f21157a.f21152e.show();
                } else {
                    this.f21157a.f21152e.hide();
                }
            }
        }
    }

    /* renamed from: b.a.r0.m1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1038b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21158e;

        public C1038b(b bVar) {
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
            this.f21158e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21158e.f21150c.d();
                if (!this.f21158e.f21155h.getHasMore() || this.f21158e.m) {
                    this.f21158e.f21150c.g(R.string.no_more_msg);
                    return;
                }
                this.f21158e.f21150c.f(R.string.loading);
                if (this.f21158e.f21155h != null) {
                    this.f21158e.f21155h.loadNextPage();
                    this.f21158e.m = true;
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, officialNotificationFragment, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21156i = null;
        this.j = new ArrayList();
        this.n = new a(this);
        if (tbPageContext == null) {
            return;
        }
        this.f21153f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f21154g = baseFragmentActivity;
        this.f21155h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f21148a = viewGroup2;
        this.f21152e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21148a.findViewById(R.id.rv_official_notification);
        this.f21149b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f21154g));
        this.f21149b.setFadingEdgeLength(0);
        this.f21149b.setOverScrollMode(2);
        this.f21149b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f21153f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.q0(officialNotificationFragment);
        this.j.add(this.k);
        this.f21149b.addAdapters(this.j);
        b.a.q0.k0.g.a aVar = new b.a.q0.k0.g.a(this.f21154g, this.f21149b);
        this.f21150c = aVar;
        aVar.h(l.g(this.f21154g, R.dimen.tbds182));
        this.f21150c.a();
        this.f21149b.setNextPage(this.f21150c);
        this.f21149b.setOnSrollToBottomListener(new C1038b(this));
        j();
    }

    public void f(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, msgPageData) == null) || this.f21149b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f21149b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21149b;
            return (bdTypeRecyclerView == null || this.f21156i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msgPageData, i2) == null) || this.f21149b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f21149b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f21149b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21148a : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
            if (officialNotificationTextItemAdapter != null) {
                officialNotificationTextItemAdapter.O();
            }
            SkinManager.setBackgroundColor(this.f21149b, R.color.CAM_X0201);
            NoDataView noDataView = this.f21151d;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21153f, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f21151d, R.color.CAM_X0201);
            }
            b.a.q0.k0.g.a aVar = this.f21150c;
            if (aVar != null) {
                aVar.onChangeSkinType(this.f21153f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void k(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            if (msgPageData.getIsNewAdd() ? g(msgPageData.getNewAddNum()) : false) {
                l(msgPageData);
            } else {
                m(msgPageData);
            }
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void l(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            o(msgPageData);
            h(msgPageData, 0);
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void m(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, msgPageData) == null) {
            h(msgPageData, -1);
        }
    }

    public void n(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msgPageData) == null) {
            try {
                h(msgPageData, -1);
            } catch (Exception unused) {
                h(msgPageData, -1);
            }
        }
    }

    public final void o(MsgPageData msgPageData) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, msgPageData) == null) || msgPageData == null || msgPageData.getChatMessages() == null || msgPageData.getChatMessages().size() == 0 || (size = msgPageData.getChatMessages().size()) <= 100) {
            return;
        }
        int i2 = size - 100;
        for (int i3 = 0; i3 < i2; i3++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public void p(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || this.f21149b == null) {
            return;
        }
        this.f21156i = list;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 > 0) {
                if (list.get(i2).getCacheData() == null) {
                    list.get(i2).setCacheData(new MsgCacheData());
                }
                list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
            }
        }
        arrayList2.addAll(arrayList);
        if (arrayList2.isEmpty()) {
            if (this.f21151d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f21154g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f21154g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f21151d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f21151d, R.color.CAM_X0201);
                this.f21148a.addView(this.f21151d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f21149b.setVisibility(8);
            this.f21151d.setVisibility(0);
            this.f21151d.onChangeSkinType(this.f21153f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f21151d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f21149b.setData(arrayList2);
        this.f21149b.setVisibility(0);
    }
}
