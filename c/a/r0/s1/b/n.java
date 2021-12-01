package c.a.r0.s1.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.m.e.w;
import c.a.d.m.e.x;
import c.a.q0.s.g0.f;
import c.a.q0.t.c.m0;
import c.a.r0.d1.r2.a.c;
import c.a.r0.g0.d0;
import c.a.r0.s1.b.p.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class n extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.d1.r2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;
    public final ReplyMessageFragment a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f23392b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f23393c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s1.b.p.d f23394d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f23395e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f23396f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f23397g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f23398h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.g0.g f23399i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.s1.b.p.e f23400j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23401k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final f.g q;
    public RecyclerView.OnScrollListener r;
    public e.b s;
    public ReplyMeModel t;
    public c.a.q0.x.x.h u;
    public c.a.r0.s1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.a().hide();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || m0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // c.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23402e;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23402e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23402e.u == null || this.f23402e.u.t() == null) {
                return;
            }
            c.a.d.f.p.l.K(this.f23402e.getPageContext().getPageActivity(), this.f23402e.u.t().h());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j2, long j3, long j4, String str, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Long.valueOf(j5)}) == null) {
                this.a.w = String.valueOf(j2);
                this.a.x = str;
                this.a.y = j3;
                this.a.z = j4;
                n nVar = this.a;
                nVar.V(nVar.w, j5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // c.a.r0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.u == null || this.a.u.v) {
                    this.a.E(false);
                }
                if (this.a.u == null || this.a.v == null) {
                    return;
                }
                if (!this.a.v.E() || this.a.v.w() == null) {
                    this.a.u.j0(null, null);
                    return;
                }
                this.a.u.j0(this.a.v.w().getName_show(), this.a.v.w().getPortrait());
            }
        }

        @Override // c.a.r0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.a.u != null) {
                    this.a.u.y();
                }
                super.onScrollStateChanged(recyclerView, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23403e;

        public g(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23403e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23403e.f23392b == null || this.f23403e.a == null) {
                return;
            }
            this.f23403e.f23392b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f23403e.f23392b.B(null);
            this.f23403e.f23392b.Q();
            this.f23403e.a.loadmore();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23404e;

        public h(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23404e = nVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (c.a.d.f.p.j.z()) {
                    if (this.f23404e.a != null) {
                        this.f23404e.a.pullRefresh();
                    }
                } else if (this.f23404e.f23395e != null) {
                    this.f23404e.f23395e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public i(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.a.f23397g.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.a.f23397g.show();
                } else {
                    this.a.f23397g.hide();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public j(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.a.u != null) {
                this.a.u.F();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f23405b;

        public k(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23405b = nVar;
        }

        @Override // c.a.r0.g0.d0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long g2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof c.a.r0.s1.b.p.a)) {
                c.a.r0.s1.b.p.a aVar = (c.a.r0.s1.b.p.a) baseCardInfo;
                if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.H(false);
                    this.f23405b.K();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f23405b.v = aVar;
                    if (aVar.E()) {
                        g2 = c.a.d.f.m.b.g(aVar.t(), 0L);
                    } else {
                        g2 = c.a.d.f.m.b.g(aVar.q(), 0L);
                    }
                    long j2 = g2;
                    if (this.f23405b.u != null) {
                        this.f23405b.u.T(this.f23405b.v.q());
                    }
                    if (this.f23405b.m == null) {
                        this.f23405b.m = new AttentionHostData();
                    }
                    if (this.f23405b.v != null) {
                        this.f23405b.m.parserWithMetaData(this.f23405b.v.z());
                    }
                    this.f23405b.t.z(j2, 2, aVar.i(), aVar.A(), this.f23405b.v != null ? this.f23405b.v.g() : null);
                    if (aVar.x() != null) {
                        StatisticItem param = new StatisticItem(aVar.x()).param("obj_locate", 3);
                        if (aVar.getType() == c.a.r0.s1.b.p.a.B) {
                            param.param("obj_type", 1);
                        } else {
                            param.param("obj_type", 2);
                        }
                        TiebaStatic.log(param);
                    }
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23406e;

        public m(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23406e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23406e.f23392b == null) {
                return;
            }
            this.f23406e.f23392b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f23406e.f23392b.B(null);
            this.f23406e.f23392b.N();
            this.f23406e.a.loadmore();
        }
    }

    /* renamed from: c.a.r0.s1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1351n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public C1351n(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // c.a.r0.s1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f23400j == null) {
                return;
            }
            this.a.f23396f.removeHeaderView(this.a.f23400j.e());
            this.a.o = false;
        }
    }

    /* loaded from: classes6.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23407e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(n nVar, c.a.d.a.f fVar) {
            super(fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.d.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23407e = nVar;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData D(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.f23407e.w);
                writeData.setForumName(this.f23407e.x);
                writeData.setThreadId(this.f23407e.v.A());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f23407e.v.E()) {
                    writeData.setFloor(this.f23407e.y > 0 ? String.valueOf(this.f23407e.y) : this.f23407e.v.o().n);
                } else {
                    writeData.setFloor(this.f23407e.v.q());
                }
                if (this.f23407e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f23407e.z));
                }
                if (this.f23407e.v != null) {
                    writeData.setBaijiahaoData(this.f23407e.v.g());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean G() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23407e.w : (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean loadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f23407e.v != null) {
                    return this.f23407e.v.q();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.f23407e.v != null) {
                    return this.f23407e.v.A();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new g(this);
        this.q = new h(this);
        this.r = new i(this);
        this.s = new C1351n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23396f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            c.a.r0.s1.b.p.e eVar = this.f23400j;
            if (eVar != null) {
                this.f23396f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = c.a.q0.s.e0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.f23400j == null) {
                c.a.r0.s1.b.p.e eVar2 = new c.a.r0.s1.b.p.e(this.a.getPageContext());
                this.f23400j = eVar2;
                eVar2.g(this.s);
            }
            this.f23396f.addHeaderView(this.f23400j.e(), 0);
            this.o = true;
        }
    }

    public void B(int i2) {
        c.a.r0.s1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f23394d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23395e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void D(int i2, Intent intent) {
        c.a.q0.x.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intent) == null) {
            this.u.a().hideTools();
            this.u.y();
            this.u.a().resetChangeToLauncher();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.u.B(writeData);
                this.u.c0(pbEditorData.getVoiceModel());
                c.a.q0.x.m findToolById = this.u.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.f13698k) != null) {
                    nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.F();
                }
            }
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.q0.x.x.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            c.a.q0.x.x.h hVar2 = (c.a.q0.x.x.h) new c.a.q0.x.x.i(z).a(this.a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.N(this.a.getPageContext());
            this.u.a0(this.B);
            this.u.O(3);
            this.u.z(this.a.getPageContext());
            this.u.a().showLinePositionBottom(true);
            this.u.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f23398h.addView(this.u.a(), layoutParams);
                this.u.a().hide();
            }
            this.u.U(new b(this));
            this.u.Q(this.C);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, c.a.d.a.j.a(this.a.getPageContext().getContext()));
            this.C = new a(this);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            A();
        }
    }

    public void K() {
        c.a.r0.s1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f23394d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean L(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            c.a.q0.x.x.h hVar = this.u;
            if (hVar != null) {
                if (i2 == 12005) {
                    hVar.i0();
                    c.a.d.f.m.e.a().postDelayed(this.D, 300L);
                }
                this.u.C(i2, i3, intent);
            }
            if (i2 == 25035) {
                D(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.q0.x.x.h hVar = this.u;
            if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
                return false;
            }
            this.u.y();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View O(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.f23398h = viewGroup;
            this.f23397g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f23399i == null) {
                c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.a.getPageContext());
                this.f23399i = gVar;
                gVar.a(this.q);
            }
            this.f23399i.V(this.a.getUniqueId());
            if (this.f23392b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.f23392b = pbListView;
                pbListView.b();
            }
            this.f23392b.p(R.color.CAM_X0205);
            this.f23392b.r();
            this.f23392b.s(c.a.d.f.p.l.f(this.a.getContext(), R.dimen.tbds182));
            this.f23392b.x();
            this.f23392b.G(R.dimen.tbfontsize33);
            this.f23392b.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f23392b.A(R.color.CAM_X0110);
            this.f23392b.B(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f23398h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f23395e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f23399i);
            this.f23396f = (BdTypeRecyclerView) this.f23398h.findViewById(R.id.replyme_lv);
            c.a.r0.s1.b.p.d dVar = new c.a.r0.s1.b.p.d(this.a.getPageContext(), this.f23396f);
            this.f23394d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f23396f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f23396f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f23396f.setFadingEdgeLength(0);
            this.f23396f.setOverScrollMode(2);
            this.f23396f.addItemDecoration(new DeviderLineDecoration());
            this.f23396f.setRecyclerListener(new l(this));
            this.f23396f.setOnSrollToBottomListener(new m(this));
            this.f23396f.setOnScrollListener(this.F);
            this.f23396f.addOnScrollListener(this.r);
            G();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            F();
            E(false);
            return this.f23398h;
        }
        return (View) invokeL.objValue;
    }

    public void Q(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            A();
        }
    }

    public void T(boolean z, ArrayList<c.a.d.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f23396f == null) {
            return;
        }
        this.f23395e.setVisibility(0);
        Y(false);
        if (z) {
            this.f23392b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f23392b.f();
            this.f23392b.B(this.p);
        } else {
            this.f23392b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f23392b.f();
            this.f23392b.C(this.mContext.getResources().getString(R.string.list_no_more));
            this.f23392b.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f23393c == null) {
                this.f23393c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f23393c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f23393c, R.color.CAM_X0201);
            }
            if (this.f23393c.getParent() == null && !this.f23401k) {
                this.f23401k = true;
                this.f23396f.addHeaderView(this.f23393c);
                this.f23393c.setVisibility(0);
                this.f23393c.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f23396f.setNextPage(null);
            if (arrayList != null) {
                this.f23394d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f23396f.removeHeaderView(this.f23393c);
            this.f23401k = false;
            c.a.r0.s1.b.p.d dVar = this.f23394d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f23394d.c();
            }
            this.f23396f.setNextPage(this.f23392b);
            this.n = R.color.CAM_X0204;
        }
        A();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void V(String str, long j2) {
        c.a.r0.s1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            c.a.r0.s1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.g() != null && this.v.C()) {
                c.a.q0.x.x.h hVar = this.u;
                if (hVar == null || !hVar.v) {
                    E(true);
                }
                if (this.u == null || (aVar = this.v) == null) {
                    return;
                }
                if (aVar.E() && this.v.w() != null) {
                    this.u.j0(this.v.w().getName_show(), this.v.w().getPortrait());
                    return;
                } else {
                    this.u.j0(null, null);
                    return;
                }
            }
            if (this.A == null) {
                c.a.r0.d1.r2.a.c cVar = new c.a.r0.d1.r2.a.c(this.a.getPageContext());
                this.A = cVar;
                cVar.i(new e(this));
            }
            this.A.g(str, j2);
        }
    }

    public void W(x xVar) {
        c.a.r0.s1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f23394d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void X(w wVar) {
        c.a.r0.s1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f23394d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Y(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f23395e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f23396f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f23396f.setSelection(0);
        }
        this.f23395e.setRefreshing(z);
    }

    @Override // c.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.D);
            c.a.q0.x.x.h hVar = this.u;
            if (hVar != null) {
                hVar.D();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyMeModel replyMeModel = this.t;
            if (replyMeModel != null) {
                replyMeModel.A(null);
                this.t.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            c.a.q0.x.x.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().onChangeSkinType(i2);
            }
            PbListView pbListView = this.f23392b;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f23392b.d(i2);
            }
            c.a.q0.s.g0.g gVar = this.f23399i;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoDataView noDataView = this.f23393c;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f23393c, R.color.CAM_X0201);
            }
            K();
            SkinManager.setBackgroundColor(this.f23396f, this.n);
            SkinManager.setBackgroundColor(this.f23395e, R.color.CAM_X0205);
            c.a.r0.s1.b.p.e eVar = this.f23400j;
            if (eVar != null) {
                eVar.f(i2);
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
        }
    }
}
