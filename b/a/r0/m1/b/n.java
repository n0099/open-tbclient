package b.a.r0.m1.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.l.e.w;
import b.a.e.l.e.x;
import b.a.q0.s.g0.f;
import b.a.q0.t.c.m0;
import b.a.r0.b0.c0;
import b.a.r0.m1.b.p.e;
import b.a.r0.x0.q2.a.c;
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
/* loaded from: classes5.dex */
public class n extends b.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.x0.q2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f21073a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f21074b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f21075c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.m1.b.p.d f21076d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f21077e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f21078f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f21079g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f21080h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.g0.g f21081i;
    public b.a.r0.m1.b.p.e j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final f.g q;
    public RecyclerView.OnScrollListener r;
    public e.b s;
    public ReplyMeModel t;
    public b.a.q0.x.x.h u;
    public b.a.r0.m1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes5.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21082a;

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
            this.f21082a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.f21082a.f21073a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21082a.f21073a.getBaseFragmentActivity().hideProgressBar();
            this.f21082a.u.a().hide();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.f21082a.l.setLikeUserData(this.f21082a.m);
                this.f21082a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || m0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.f21082a.f21073a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21083a;

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
            this.f21083a = nVar;
        }

        @Override // b.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21083a.f21073a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21083a.f21073a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21084e;

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
            this.f21084e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21084e.u == null || this.f21084e.u.t() == null) {
                return;
            }
            b.a.e.e.p.l.K(this.f21084e.getPageContext().getPageActivity(), this.f21084e.u.t().h());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21085a;

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
            this.f21085a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.f21085a.w = String.valueOf(j);
                this.f21085a.x = str;
                this.f21085a.y = j2;
                this.f21085a.z = j3;
                n nVar = this.f21085a;
                nVar.V(nVar.w, j4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21086a;

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
            this.f21086a = nVar;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f21086a.u == null || this.f21086a.u.v) {
                    this.f21086a.J(false);
                }
                if (this.f21086a.u == null || this.f21086a.v == null) {
                    return;
                }
                if (!this.f21086a.v.E() || this.f21086a.v.w() == null) {
                    this.f21086a.u.j0(null, null);
                    return;
                }
                this.f21086a.u.j0(this.f21086a.v.w().getName_show(), this.f21086a.v.w().getPortrait());
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21087a;

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
            this.f21087a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f21087a.u != null) {
                    this.f21087a.u.y();
                }
                super.onScrollStateChanged(recyclerView, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21088e;

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
            this.f21088e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21088e.f21074b == null || this.f21088e.f21073a == null) {
                return;
            }
            this.f21088e.f21074b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21088e.f21074b.B(null);
            this.f21088e.f21074b.Q();
            this.f21088e.f21073a.loadmore();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21089e;

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
            this.f21089e = nVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (b.a.e.e.p.j.z()) {
                    if (this.f21089e.f21073a != null) {
                        this.f21089e.f21073a.pullRefresh();
                    }
                } else if (this.f21089e.f21077e != null) {
                    this.f21089e.f21077e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21090a;

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
            this.f21090a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f21090a.f21079g.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f21090a.f21079g.show();
                } else {
                    this.f21090a.f21079g.hide();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21091a;

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
            this.f21091a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f21091a.u != null) {
                this.f21091a.u.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f21092b;

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
            this.f21092b = nVar;
        }

        @Override // b.a.r0.b0.c0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long g2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof b.a.r0.m1.b.p.a)) {
                b.a.r0.m1.b.p.a aVar = (b.a.r0.m1.b.p.a) baseCardInfo;
                if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.H(false);
                    this.f21092b.O();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f21092b.v = aVar;
                    if (aVar.E()) {
                        g2 = b.a.e.e.m.b.g(aVar.t(), 0L);
                    } else {
                        g2 = b.a.e.e.m.b.g(aVar.q(), 0L);
                    }
                    long j = g2;
                    if (this.f21092b.u != null) {
                        this.f21092b.u.T(this.f21092b.v.q());
                    }
                    if (this.f21092b.m == null) {
                        this.f21092b.m = new AttentionHostData();
                    }
                    if (this.f21092b.v != null) {
                        this.f21092b.m.parserWithMetaData(this.f21092b.v.z());
                    }
                    this.f21092b.t.z(j, 2, aVar.i(), aVar.A(), this.f21092b.v != null ? this.f21092b.v.g() : null);
                    if (aVar.x() != null) {
                        StatisticItem param = new StatisticItem(aVar.x()).param("obj_locate", 3);
                        if (aVar.getType() == b.a.r0.m1.b.p.a.B) {
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21093e;

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
            this.f21093e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21093e.f21074b == null) {
                return;
            }
            this.f21093e.f21074b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21093e.f21074b.B(null);
            this.f21093e.f21074b.N();
            this.f21093e.f21073a.loadmore();
        }
    }

    /* renamed from: b.a.r0.m1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1035n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21094a;

        public C1035n(n nVar) {
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
            this.f21094a = nVar;
        }

        @Override // b.a.r0.m1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21094a.j == null) {
                return;
            }
            this.f21094a.f21078f.removeHeaderView(this.f21094a.j.e());
            this.f21094a.o = false;
        }
    }

    /* loaded from: classes5.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21095e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(n nVar, b.a.e.a.f fVar) {
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
                    super((b.a.e.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21095e = nVar;
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
                writeData.setForumId(this.f21095e.w);
                writeData.setForumName(this.f21095e.x);
                writeData.setThreadId(this.f21095e.v.A());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f21095e.v.E()) {
                    writeData.setFloor(this.f21095e.y > 0 ? String.valueOf(this.f21095e.y) : this.f21095e.v.o().n);
                } else {
                    writeData.setFloor(this.f21095e.v.q());
                }
                if (this.f21095e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f21095e.z));
                }
                if (this.f21095e.v != null) {
                    writeData.setBaijiahaoData(this.f21095e.v.g());
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f21095e.w : (String) invokeV.objValue;
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
                if (this.f21095e.v != null) {
                    return this.f21095e.v.q();
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
                if (this.f21095e.v != null) {
                    return this.f21095e.v.A();
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
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
        this.s = new C1035n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.f21073a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21078f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f21073a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            b.a.r0.m1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f21078f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = b.a.q0.s.e0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.j == null) {
                b.a.r0.m1.b.p.e eVar2 = new b.a.r0.m1.b.p.e(this.f21073a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f21078f.addHeaderView(this.j.e(), 0);
            this.o = true;
        }
    }

    public void B(int i2) {
        b.a.r0.m1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f21076d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21077e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void I(int i2, Intent intent) {
        b.a.q0.x.n nVar;
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
                b.a.q0.x.m findToolById = this.u.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.k) != null) {
                    nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.F();
                }
            }
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            b.a.q0.x.x.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            b.a.q0.x.x.h hVar2 = (b.a.q0.x.x.h) new b.a.q0.x.x.i(z).a(this.f21073a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.N(this.f21073a.getPageContext());
            this.u.a0(this.B);
            this.u.O(3);
            this.u.z(this.f21073a.getPageContext());
            this.u.a().showLinePositionBottom(true);
            this.u.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f21080h.addView(this.u.a(), layoutParams);
                this.u.a().hide();
            }
            this.u.U(new b(this));
            this.u.Q(this.C);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, b.a.e.a.j.a(this.f21073a.getPageContext().getContext()));
            this.C = new a(this);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            A();
        }
    }

    public void O() {
        b.a.r0.m1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f21076d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean P(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            b.a.q0.x.x.h hVar = this.u;
            if (hVar != null) {
                if (i2 == 12005) {
                    hVar.i0();
                    b.a.e.e.m.e.a().postDelayed(this.D, 300L);
                }
                this.u.C(i2, i3, intent);
            }
            if (i2 == 25035) {
                I(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a.q0.x.x.h hVar = this.u;
            if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
                return false;
            }
            this.u.y();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View R(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.f21080h = viewGroup;
            this.f21079g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f21081i == null) {
                b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.f21073a.getPageContext());
                this.f21081i = gVar;
                gVar.a(this.q);
            }
            this.f21081i.U(this.f21073a.getUniqueId());
            if (this.f21074b == null) {
                PbListView pbListView = new PbListView(this.f21073a.getContext());
                this.f21074b = pbListView;
                pbListView.b();
            }
            this.f21074b.p(R.color.CAM_X0205);
            this.f21074b.r();
            this.f21074b.s(b.a.e.e.p.l.g(this.f21073a.getContext(), R.dimen.tbds182));
            this.f21074b.x();
            this.f21074b.G(R.dimen.tbfontsize33);
            this.f21074b.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f21074b.A(R.color.CAM_X0110);
            this.f21074b.B(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21080h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f21077e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f21081i);
            this.f21078f = (BdTypeRecyclerView) this.f21080h.findViewById(R.id.replyme_lv);
            b.a.r0.m1.b.p.d dVar = new b.a.r0.m1.b.p.d(this.f21073a.getPageContext(), this.f21078f);
            this.f21076d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f21078f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f21078f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f21078f.setFadingEdgeLength(0);
            this.f21078f.setOverScrollMode(2);
            this.f21078f.addItemDecoration(new DeviderLineDecoration());
            this.f21078f.setRecyclerListener(new l(this));
            this.f21078f.setOnSrollToBottomListener(new m(this));
            this.f21078f.setOnScrollListener(this.F);
            this.f21078f.addOnScrollListener(this.r);
            M();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.f21073a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            K();
            J(false);
            return this.f21080h;
        }
        return (View) invokeL.objValue;
    }

    public void S(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            A();
        }
    }

    public void U(boolean z, ArrayList<b.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f21078f == null) {
            return;
        }
        this.f21077e.setVisibility(0);
        Y(false);
        if (z) {
            this.f21074b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21074b.f();
            this.f21074b.B(this.p);
        } else {
            this.f21074b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21074b.f();
            this.f21074b.C(this.mContext.getResources().getString(R.string.list_no_more));
            this.f21074b.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f21075c == null) {
                this.f21075c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f21075c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f21075c, R.color.CAM_X0201);
            }
            if (this.f21075c.getParent() == null && !this.k) {
                this.k = true;
                this.f21078f.addHeaderView(this.f21075c);
                this.f21075c.setVisibility(0);
                this.f21075c.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21078f.setNextPage(null);
            if (arrayList != null) {
                this.f21076d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f21078f.removeHeaderView(this.f21075c);
            this.k = false;
            b.a.r0.m1.b.p.d dVar = this.f21076d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f21076d.c();
            }
            this.f21078f.setNextPage(this.f21074b);
            this.n = R.color.CAM_X0204;
        }
        A();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void V(String str, long j2) {
        b.a.r0.m1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            b.a.r0.m1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.g() != null && this.v.C()) {
                b.a.q0.x.x.h hVar = this.u;
                if (hVar == null || !hVar.v) {
                    J(true);
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
                b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(this.f21073a.getPageContext());
                this.A = cVar;
                cVar.i(new e(this));
            }
            this.A.g(str, j2);
        }
    }

    public void W(x xVar) {
        b.a.r0.m1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f21076d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void X(w wVar) {
        b.a.r0.m1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f21076d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Y(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f21077e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f21078f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f21078f.setSelection(0);
        }
        this.f21077e.setRefreshing(z);
    }

    @Override // b.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.D);
            b.a.q0.x.x.h hVar = this.u;
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
            b.a.q0.x.x.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().onChangeSkinType(i2);
            }
            PbListView pbListView = this.f21074b;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f21074b.d(i2);
            }
            b.a.q0.s.g0.g gVar = this.f21081i;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoDataView noDataView = this.f21075c;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f21075c, R.color.CAM_X0201);
            }
            O();
            SkinManager.setBackgroundColor(this.f21078f, this.n);
            SkinManager.setBackgroundColor(this.f21077e, R.color.CAM_X0205);
            b.a.r0.m1.b.p.e eVar = this.j;
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
