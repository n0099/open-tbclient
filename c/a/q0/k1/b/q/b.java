package c.a.q0.k1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f21466a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21467b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.i0.g.a f21468c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f21469d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f21470e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f21471f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f21472g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f21473h;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f21474i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.e.l.e.a> f21475j;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21476a;

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
            this.f21476a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f21476a.f21470e.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f21476a.f21470e.show();
                } else {
                    this.f21476a.f21470e.hide();
                }
            }
        }
    }

    /* renamed from: c.a.q0.k1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1002b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21477e;

        public C1002b(b bVar) {
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
            this.f21477e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21477e.f21468c.d();
                if (!this.f21477e.f21473h.getHasMore() || this.f21477e.m) {
                    this.f21477e.f21468c.g(R.string.no_more_msg);
                    return;
                }
                this.f21477e.f21468c.f(R.string.loading);
                if (this.f21477e.f21473h != null) {
                    this.f21477e.f21473h.loadNextPage();
                    this.f21477e.m = true;
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
        this.f21474i = null;
        this.f21475j = new ArrayList();
        this.n = new a(this);
        if (tbPageContext == null) {
            return;
        }
        this.f21471f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f21472g = baseFragmentActivity;
        this.f21473h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f21466a = viewGroup2;
        this.f21470e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21466a.findViewById(R.id.rv_official_notification);
        this.f21467b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f21472g));
        this.f21467b.setFadingEdgeLength(0);
        this.f21467b.setOverScrollMode(2);
        this.f21467b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f21471f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.r0(officialNotificationFragment);
        this.f21475j.add(this.k);
        this.f21467b.addAdapters(this.f21475j);
        c.a.p0.i0.g.a aVar = new c.a.p0.i0.g.a(this.f21472g, this.f21467b);
        this.f21468c = aVar;
        aVar.h(l.g(this.f21472g, R.dimen.tbds182));
        this.f21468c.a();
        this.f21467b.setNextPage(this.f21468c);
        this.f21467b.setOnSrollToBottomListener(new C1002b(this));
        j();
    }

    public void f(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, msgPageData) == null) || this.f21467b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f21467b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21467b;
            return (bdTypeRecyclerView == null || this.f21474i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msgPageData, i2) == null) || this.f21467b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f21467b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f21467b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21466a : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
            if (officialNotificationTextItemAdapter != null) {
                officialNotificationTextItemAdapter.P();
            }
            SkinManager.setBackgroundColor(this.f21467b, R.color.CAM_X0201);
            NoDataView noDataView = this.f21469d;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21471f, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f21469d, R.color.CAM_X0201);
            }
            c.a.p0.i0.g.a aVar = this.f21468c;
            if (aVar != null) {
                aVar.onChangeSkinType(this.f21471f, TbadkCoreApplication.getInst().getSkinType());
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || this.f21467b == null) {
            return;
        }
        this.f21474i = list;
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
            if (this.f21469d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f21472g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f21472g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f21469d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f21469d, R.color.CAM_X0201);
                this.f21466a.addView(this.f21469d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f21467b.setVisibility(8);
            this.f21469d.setVisibility(0);
            this.f21469d.onChangeSkinType(this.f21471f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f21469d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f21467b.setData(arrayList2);
        this.f21467b.setVisibility(0);
    }
}
