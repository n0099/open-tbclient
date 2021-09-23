package c.a.r0.l1.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.w;
import c.a.e.l.e.x;
import c.a.q0.s.f0.f;
import c.a.q0.t.c.k0;
import c.a.r0.a0.b0;
import c.a.r0.l1.b.p.e;
import c.a.r0.w0.g2.a.c;
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
/* loaded from: classes3.dex */
public class n extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.w0.g2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f21982a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f21983b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f21984c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.l1.b.p.d f21985d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f21986e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f21987f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f21988g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f21989h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.f0.g f21990i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.l1.b.p.e f21991j;
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
    public c.a.q0.x.w.h u;
    public c.a.r0.l1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21992a;

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
            this.f21992a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f21992a.f21982a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21992a.f21982a.getBaseFragmentActivity().hideProgressBar();
            this.f21992a.u.a().hide();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.f21992a.l.setLikeUserData(this.f21992a.m);
                this.f21992a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || k0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.f21992a.f21982a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21993a;

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
            this.f21993a = nVar;
        }

        @Override // c.a.q0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21993a.f21982a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21993a.f21982a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21994e;

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
            this.f21994e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21994e.u == null || this.f21994e.u.u() == null) {
                return;
            }
            c.a.e.e.p.l.K(this.f21994e.getPageContext().getPageActivity(), this.f21994e.u.u().i());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21995a;

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
            this.f21995a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j2, long j3, long j4, String str, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Long.valueOf(j5)}) == null) {
                this.f21995a.w = String.valueOf(j2);
                this.f21995a.x = str;
                this.f21995a.y = j3;
                this.f21995a.z = j4;
                n nVar = this.f21995a;
                nVar.V(nVar.w, j5);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21996a;

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
            this.f21996a = nVar;
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f21996a.u == null || this.f21996a.u.v) {
                    this.f21996a.K(false);
                }
                if (this.f21996a.u == null || this.f21996a.v == null) {
                    return;
                }
                if (!this.f21996a.v.E() || this.f21996a.v.w() == null) {
                    this.f21996a.u.k0(null, null);
                    return;
                }
                this.f21996a.u.k0(this.f21996a.v.w().getName_show(), this.f21996a.v.w().getPortrait());
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21997a;

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
            this.f21997a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f21997a.u != null) {
                    this.f21997a.u.z();
                }
                super.onScrollStateChanged(recyclerView, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21998e;

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
            this.f21998e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21998e.f21983b == null || this.f21998e.f21982a == null) {
                return;
            }
            this.f21998e.f21983b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21998e.f21983b.z(null);
            this.f21998e.f21983b.O();
            this.f21998e.f21982a.loadmore();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21999e;

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
            this.f21999e = nVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (c.a.e.e.p.j.z()) {
                    if (this.f21999e.f21982a != null) {
                        this.f21999e.f21982a.pullRefresh();
                    }
                } else if (this.f21999e.f21986e != null) {
                    this.f21999e.f21986e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22000a;

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
            this.f22000a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f22000a.f21988g.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f22000a.f21988g.show();
                } else {
                    this.f22000a.f21988g.hide();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22001a;

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
            this.f22001a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f22001a.u != null) {
                this.f22001a.u.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f22002b;

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
            this.f22002b = nVar;
        }

        @Override // c.a.r0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long g2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof c.a.r0.l1.b.p.a)) {
                c.a.r0.l1.b.p.a aVar = (c.a.r0.l1.b.p.a) baseCardInfo;
                if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.H(false);
                    this.f22002b.O();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f22002b.v = aVar;
                    if (aVar.E()) {
                        g2 = c.a.e.e.m.b.g(aVar.t(), 0L);
                    } else {
                        g2 = c.a.e.e.m.b.g(aVar.q(), 0L);
                    }
                    long j2 = g2;
                    if (this.f22002b.u != null) {
                        this.f22002b.u.U(this.f22002b.v.q());
                    }
                    if (this.f22002b.m == null) {
                        this.f22002b.m = new AttentionHostData();
                    }
                    if (this.f22002b.v != null) {
                        this.f22002b.m.parserWithMetaData(this.f22002b.v.z());
                    }
                    this.f22002b.t.z(j2, 2, aVar.i(), aVar.A(), this.f22002b.v != null ? this.f22002b.v.g() : null);
                    if (aVar.x() != null) {
                        StatisticItem param = new StatisticItem(aVar.x()).param("obj_locate", 3);
                        if (aVar.getType() == c.a.r0.l1.b.p.a.B) {
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f22003e;

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
            this.f22003e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22003e.f21983b == null) {
                return;
            }
            this.f22003e.f21983b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f22003e.f21983b.z(null);
            this.f22003e.f21983b.L();
            this.f22003e.f21982a.loadmore();
        }
    }

    /* renamed from: c.a.r0.l1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1030n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22004a;

        public C1030n(n nVar) {
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
            this.f22004a = nVar;
        }

        @Override // c.a.r0.l1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22004a.f21991j == null) {
                return;
            }
            this.f22004a.f21987f.removeHeaderView(this.f22004a.f21991j.e());
            this.f22004a.o = false;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f22005e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(n nVar, c.a.e.a.f fVar) {
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
                    super((c.a.e.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22005e = nVar;
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
                writeData.setForumId(this.f22005e.w);
                writeData.setForumName(this.f22005e.x);
                writeData.setThreadId(this.f22005e.v.A());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f22005e.v.E()) {
                    writeData.setFloor(this.f22005e.y > 0 ? String.valueOf(this.f22005e.y) : this.f22005e.v.o().n);
                } else {
                    writeData.setFloor(this.f22005e.v.q());
                }
                if (this.f22005e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f22005e.z));
                }
                if (this.f22005e.v != null) {
                    writeData.setBaijiahaoData(this.f22005e.v.g());
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
        public boolean LoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22005e.w : (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f22005e.v != null) {
                    return this.f22005e.v.q();
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
                if (this.f22005e.v != null) {
                    return this.f22005e.v.A();
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
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
        this.s = new C1030n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.f21982a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21987f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f21982a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            c.a.r0.l1.b.p.e eVar = this.f21991j;
            if (eVar != null) {
                this.f21987f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = c.a.q0.s.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.f21991j == null) {
                c.a.r0.l1.b.p.e eVar2 = new c.a.r0.l1.b.p.e(this.f21982a.getPageContext());
                this.f21991j = eVar2;
                eVar2.g(this.s);
            }
            this.f21987f.addHeaderView(this.f21991j.e(), 0);
            this.o = true;
        }
    }

    public void B(int i2) {
        c.a.r0.l1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f21985d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21986e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void J(int i2, Intent intent) {
        c.a.q0.x.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intent) == null) {
            this.u.a().hideTools();
            this.u.z();
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
                this.u.C(writeData);
                this.u.d0(pbEditorData.getVoiceModel());
                c.a.q0.x.m findToolById = this.u.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.k) != null) {
                    nVar.onAction(new c.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.G();
                }
            }
        }
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.q0.x.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            c.a.q0.x.w.h hVar2 = (c.a.q0.x.w.h) new c.a.q0.x.w.i(z).a(this.f21982a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.O(this.f21982a.getPageContext());
            this.u.b0(this.B);
            this.u.P(3);
            this.u.A(this.f21982a.getPageContext());
            this.u.a().showLinePositionBottom(true);
            this.u.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f21989h.addView(this.u.a(), layoutParams);
                this.u.a().hide();
            }
            this.u.V(new b(this));
            this.u.R(this.C);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, c.a.e.a.j.a(this.f21982a.getPageContext().getContext()));
            this.C = new a(this);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            A();
        }
    }

    public void O() {
        c.a.r0.l1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f21985d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean P(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            c.a.q0.x.w.h hVar = this.u;
            if (hVar != null) {
                if (i2 == 12005) {
                    hVar.j0();
                    c.a.e.e.m.e.a().postDelayed(this.D, 300L);
                }
                this.u.D(i2, i3, intent);
            }
            if (i2 == 25035) {
                J(i3, intent);
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
            c.a.q0.x.w.h hVar = this.u;
            if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
                return false;
            }
            this.u.z();
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
            this.f21989h = viewGroup;
            this.f21988g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f21990i == null) {
                c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f21982a.getPageContext());
                this.f21990i = gVar;
                gVar.a(this.q);
            }
            this.f21990i.V(this.f21982a.getUniqueId());
            if (this.f21983b == null) {
                PbListView pbListView = new PbListView(this.f21982a.getContext());
                this.f21983b = pbListView;
                pbListView.b();
            }
            this.f21983b.o(R.color.CAM_X0205);
            this.f21983b.q();
            this.f21983b.r(c.a.e.e.p.l.g(this.f21982a.getContext(), R.dimen.tbds182));
            this.f21983b.v();
            this.f21983b.E(R.dimen.tbfontsize33);
            this.f21983b.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f21983b.y(R.color.CAM_X0110);
            this.f21983b.z(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21989h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f21986e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f21990i);
            this.f21987f = (BdTypeRecyclerView) this.f21989h.findViewById(R.id.replyme_lv);
            c.a.r0.l1.b.p.d dVar = new c.a.r0.l1.b.p.d(this.f21982a.getPageContext(), this.f21987f);
            this.f21985d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f21987f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f21987f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f21987f.setFadingEdgeLength(0);
            this.f21987f.setOverScrollMode(2);
            this.f21987f.addItemDecoration(new DeviderLineDecoration());
            this.f21987f.setRecyclerListener(new l(this));
            this.f21987f.setOnSrollToBottomListener(new m(this));
            this.f21987f.setOnScrollListener(this.F);
            this.f21987f.addOnScrollListener(this.r);
            N();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.f21982a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            L();
            K(false);
            return this.f21989h;
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

    public void U(boolean z, ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f21987f == null) {
            return;
        }
        this.f21986e.setVisibility(0);
        Y(false);
        if (z) {
            this.f21983b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21983b.f();
            this.f21983b.z(this.p);
        } else {
            this.f21983b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21983b.f();
            this.f21983b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f21983b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f21984c == null) {
                this.f21984c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f21984c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f21984c, R.color.CAM_X0201);
            }
            if (this.f21984c.getParent() == null && !this.k) {
                this.k = true;
                this.f21987f.addHeaderView(this.f21984c);
                this.f21984c.setVisibility(0);
                this.f21984c.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21987f.setNextPage(null);
            if (arrayList != null) {
                this.f21985d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f21987f.removeHeaderView(this.f21984c);
            this.k = false;
            c.a.r0.l1.b.p.d dVar = this.f21985d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f21985d.c();
            }
            this.f21987f.setNextPage(this.f21983b);
            this.n = R.color.CAM_X0204;
        }
        A();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void V(String str, long j2) {
        c.a.r0.l1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            c.a.r0.l1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.g() != null && this.v.C()) {
                c.a.q0.x.w.h hVar = this.u;
                if (hVar == null || !hVar.v) {
                    K(true);
                }
                if (this.u == null || (aVar = this.v) == null) {
                    return;
                }
                if (aVar.E() && this.v.w() != null) {
                    this.u.k0(this.v.w().getName_show(), this.v.w().getPortrait());
                    return;
                } else {
                    this.u.k0(null, null);
                    return;
                }
            }
            if (this.A == null) {
                c.a.r0.w0.g2.a.c cVar = new c.a.r0.w0.g2.a.c(this.f21982a.getPageContext());
                this.A = cVar;
                cVar.i(new e(this));
            }
            this.A.g(str, j2);
        }
    }

    public void W(x xVar) {
        c.a.r0.l1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f21985d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void X(w wVar) {
        c.a.r0.l1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f21985d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Y(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f21986e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f21987f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f21987f.setSelection(0);
        }
        this.f21986e.setRefreshing(z);
    }

    @Override // c.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.D);
            c.a.q0.x.w.h hVar = this.u;
            if (hVar != null) {
                hVar.E();
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
            c.a.q0.x.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().onChangeSkinType(i2);
            }
            PbListView pbListView = this.f21983b;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f21983b.d(i2);
            }
            c.a.q0.s.f0.g gVar = this.f21990i;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoDataView noDataView = this.f21984c;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f21984c, R.color.CAM_X0201);
            }
            O();
            SkinManager.setBackgroundColor(this.f21987f, this.n);
            SkinManager.setBackgroundColor(this.f21986e, R.color.CAM_X0205);
            c.a.r0.l1.b.p.e eVar = this.f21991j;
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
