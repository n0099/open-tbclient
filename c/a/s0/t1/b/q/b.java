package c.a.s0.t1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f24011b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.l0.g.a f24012c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f24013d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f24014e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f24015f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f24016g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f24017h;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f24018i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.d.m.e.a> f24019j;

    /* renamed from: k  reason: collision with root package name */
    public OfficialNotificationTextItemAdapter f24020k;
    public boolean l;
    public boolean m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.a.f24014e.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.a.f24014e.show();
                } else {
                    this.a.f24014e.hide();
                }
            }
        }
    }

    /* renamed from: c.a.s0.t1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1408b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24021e;

        public C1408b(b bVar) {
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
            this.f24021e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24021e.f24012c.d();
                if (!this.f24021e.f24017h.getHasMore() || this.f24021e.m) {
                    this.f24021e.f24012c.g(R.string.no_more_msg);
                    return;
                }
                this.f24021e.f24012c.f(R.string.loading);
                if (this.f24021e.f24017h != null) {
                    this.f24021e.f24017h.loadNextPage();
                    this.f24021e.m = true;
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
        this.f24018i = null;
        this.f24019j = new ArrayList();
        this.n = new a(this);
        if (tbPageContext == null) {
            return;
        }
        this.f24015f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f24016g = baseFragmentActivity;
        this.f24017h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.a = viewGroup2;
        this.f24014e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.a.findViewById(R.id.rv_official_notification);
        this.f24011b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f24016g));
        this.f24011b.setFadingEdgeLength(0);
        this.f24011b.setOverScrollMode(2);
        this.f24011b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f24015f, ChatMessage.TYPE_MSG_LEFT);
        this.f24020k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.q0(officialNotificationFragment);
        this.f24019j.add(this.f24020k);
        this.f24011b.addAdapters(this.f24019j);
        c.a.r0.l0.g.a aVar = new c.a.r0.l0.g.a(this.f24016g, this.f24011b);
        this.f24012c = aVar;
        aVar.h(m.f(this.f24016g, R.dimen.tbds182));
        this.f24012c.a();
        this.f24011b.setNextPage(this.f24012c);
        this.f24011b.setOnSrollToBottomListener(new C1408b(this));
        j();
    }

    public void f(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, msgPageData) == null) || this.f24011b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f24011b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f24011b;
            return (bdTypeRecyclerView == null || this.f24018i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msgPageData, i2) == null) || this.f24011b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f24011b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f24011b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.f24020k;
            if (officialNotificationTextItemAdapter != null) {
                officialNotificationTextItemAdapter.K();
            }
            SkinManager.setBackgroundColor(this.f24011b, R.color.CAM_X0201);
            NoDataView noDataView = this.f24013d;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f24015f, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f24013d, R.color.CAM_X0201);
            }
            c.a.r0.l0.g.a aVar = this.f24012c;
            if (aVar != null) {
                aVar.onChangeSkinType(this.f24015f, TbadkCoreApplication.getInst().getSkinType());
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || this.f24011b == null) {
            return;
        }
        this.f24018i = list;
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
            if (this.f24013d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f24016g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f24016g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f24013d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f24013d, R.color.CAM_X0201);
                this.a.addView(this.f24013d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f24011b.setVisibility(8);
            this.f24013d.setVisibility(0);
            this.f24013d.onChangeSkinType(this.f24015f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f24013d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f24011b.setData(arrayList2);
        this.f24011b.setVisibility(0);
    }
}
