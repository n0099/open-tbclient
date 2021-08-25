package c.a.q0.k1.b;

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
import c.a.p0.s.f0.f;
import c.a.p0.t.c.k0;
import c.a.q0.a0.b0;
import c.a.q0.k1.b.p.e;
import c.a.q0.v0.f2.a.c;
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
    public c.a.q0.v0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f21388a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f21389b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f21390c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.k1.b.p.d f21391d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f21392e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f21393f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f21394g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f21395h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.f0.g f21396i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.k1.b.p.e f21397j;
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
    public c.a.p0.x.w.h u;
    public c.a.q0.k1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21398a;

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
            this.f21398a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f21398a.f21388a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21398a.f21388a.getBaseFragmentActivity().hideProgressBar();
            this.f21398a.u.a().hide();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.f21398a.l.setLikeUserData(this.f21398a.m);
                this.f21398a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || k0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.f21398a.f21388a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21399a;

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
            this.f21399a = nVar;
        }

        @Override // c.a.p0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21399a.f21388a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f21399a.f21388a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21400e;

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
            this.f21400e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21400e.u == null || this.f21400e.u.u() == null) {
                return;
            }
            c.a.e.e.p.l.K(this.f21400e.getPageContext().getPageActivity(), this.f21400e.u.u().i());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21401a;

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
            this.f21401a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j2, long j3, long j4, String str, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Long.valueOf(j5)}) == null) {
                this.f21401a.w = String.valueOf(j2);
                this.f21401a.x = str;
                this.f21401a.y = j3;
                this.f21401a.z = j4;
                n nVar = this.f21401a;
                nVar.V(nVar.w, j5);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21402a;

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
            this.f21402a = nVar;
        }

        @Override // c.a.q0.v0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.q0.v0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f21402a.u == null || this.f21402a.u.v) {
                    this.f21402a.K(false);
                }
                if (this.f21402a.u == null || this.f21402a.v == null) {
                    return;
                }
                if (!this.f21402a.v.E() || this.f21402a.v.w() == null) {
                    this.f21402a.u.i0(null);
                } else {
                    this.f21402a.u.i0(this.f21402a.v.w().getName_show());
                }
            }
        }

        @Override // c.a.q0.v0.f2.a.c.d
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
        public final /* synthetic */ n f21403a;

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
            this.f21403a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f21403a.u != null) {
                    this.f21403a.u.y();
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
        public final /* synthetic */ n f21404e;

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
            this.f21404e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21404e.f21389b == null || this.f21404e.f21388a == null) {
                return;
            }
            this.f21404e.f21389b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21404e.f21389b.z(null);
            this.f21404e.f21389b.O();
            this.f21404e.f21388a.loadmore();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21405e;

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
            this.f21405e = nVar;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (c.a.e.e.p.j.z()) {
                    if (this.f21405e.f21388a != null) {
                        this.f21405e.f21388a.pullRefresh();
                    }
                } else if (this.f21405e.f21392e != null) {
                    this.f21405e.f21392e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21406a;

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
            this.f21406a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f21406a.f21394g.show();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f21406a.f21394g.show();
                } else {
                    this.f21406a.f21394g.hide();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21407a;

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
            this.f21407a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f21407a.u != null) {
                this.f21407a.u.F();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f21408b;

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
            this.f21408b = nVar;
        }

        @Override // c.a.q0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof c.a.q0.k1.b.p.a)) {
                c.a.q0.k1.b.p.a aVar = (c.a.q0.k1.b.p.a) baseCardInfo;
                if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.H(false);
                    this.f21408b.O();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f21408b.v = aVar;
                    if (aVar.E()) {
                        f2 = c.a.e.e.m.b.f(aVar.t(), 0L);
                    } else {
                        f2 = c.a.e.e.m.b.f(aVar.q(), 0L);
                    }
                    long j2 = f2;
                    if (this.f21408b.m == null) {
                        this.f21408b.m = new AttentionHostData();
                    }
                    if (this.f21408b.v != null) {
                        this.f21408b.m.parserWithMetaData(this.f21408b.v.z());
                    }
                    this.f21408b.t.z(j2, 2, aVar.i(), aVar.A(), this.f21408b.v != null ? this.f21408b.v.g() : null);
                    if (aVar.x() != null) {
                        StatisticItem param = new StatisticItem(aVar.x()).param("obj_locate", 3);
                        if (aVar.getType() == c.a.q0.k1.b.p.a.B) {
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
        public final /* synthetic */ n f21409e;

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
            this.f21409e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21409e.f21389b == null) {
                return;
            }
            this.f21409e.f21389b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21409e.f21389b.z(null);
            this.f21409e.f21389b.L();
            this.f21409e.f21388a.loadmore();
        }
    }

    /* renamed from: c.a.q0.k1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0999n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f21410a;

        public C0999n(n nVar) {
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
            this.f21410a = nVar;
        }

        @Override // c.a.q0.k1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21410a.f21397j == null) {
                return;
            }
            this.f21410a.f21393f.removeHeaderView(this.f21410a.f21397j.e());
            this.f21410a.o = false;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21411e;

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
            this.f21411e = nVar;
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
        public WriteData C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.f21411e.w);
                writeData.setForumName(this.f21411e.x);
                writeData.setThreadId(this.f21411e.v.A());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f21411e.v.E()) {
                    writeData.setFloor(this.f21411e.y > 0 ? String.valueOf(this.f21411e.y) : this.f21411e.v.o().n);
                } else {
                    writeData.setFloor(this.f21411e.v.q());
                }
                if (this.f21411e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f21411e.z));
                }
                if (this.f21411e.v != null) {
                    writeData.setBaijiahaoData(this.f21411e.v.g());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
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

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean LoadData() {
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
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        this.s = new C0999n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.f21388a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21393f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f21388a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            c.a.q0.k1.b.p.e eVar = this.f21397j;
            if (eVar != null) {
                this.f21393f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = c.a.p0.s.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.f21397j == null) {
                c.a.q0.k1.b.p.e eVar2 = new c.a.q0.k1.b.p.e(this.f21388a.getPageContext());
                this.f21397j = eVar2;
                eVar2.g(this.s);
            }
            this.f21393f.addHeaderView(this.f21397j.e(), 0);
            this.o = true;
        }
    }

    public void B(int i2) {
        c.a.q0.k1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f21391d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21392e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void J(int i2, Intent intent) {
        c.a.p0.x.n nVar;
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
                this.u.b0(pbEditorData.getVoiceModel());
                c.a.p0.x.m findToolById = this.u.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.k) != null) {
                    nVar.onAction(new c.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.F();
                }
            }
        }
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.p0.x.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            c.a.p0.x.w.h hVar2 = (c.a.p0.x.w.h) new c.a.p0.x.w.i(z).a(this.f21388a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.N(this.f21388a.getPageContext());
            this.u.Z(this.B);
            this.u.O(3);
            this.u.z(this.f21388a.getPageContext());
            this.u.a().showLinePositionBottom(true);
            this.u.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f21395h.addView(this.u.a(), layoutParams);
                this.u.a().hide();
            }
            this.u.T(new b(this));
            this.u.Q(this.C);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, c.a.e.a.j.a(this.f21388a.getPageContext().getContext()));
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
        c.a.q0.k1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f21391d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean P(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            c.a.p0.x.w.h hVar = this.u;
            if (hVar != null) {
                if (i2 == 12005) {
                    hVar.h0();
                    c.a.e.e.m.e.a().postDelayed(this.D, 300L);
                }
                this.u.C(i2, i3, intent);
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
            c.a.p0.x.w.h hVar = this.u;
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
            this.f21395h = viewGroup;
            this.f21394g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f21396i == null) {
                c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f21388a.getPageContext());
                this.f21396i = gVar;
                gVar.a(this.q);
            }
            this.f21396i.V(this.f21388a.getUniqueId());
            if (this.f21389b == null) {
                PbListView pbListView = new PbListView(this.f21388a.getContext());
                this.f21389b = pbListView;
                pbListView.b();
            }
            this.f21389b.o(R.color.CAM_X0205);
            this.f21389b.q();
            this.f21389b.r(c.a.e.e.p.l.g(this.f21388a.getContext(), R.dimen.tbds182));
            this.f21389b.v();
            this.f21389b.E(R.dimen.tbfontsize33);
            this.f21389b.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f21389b.y(R.color.CAM_X0110);
            this.f21389b.z(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21395h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f21392e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f21396i);
            this.f21393f = (BdTypeRecyclerView) this.f21395h.findViewById(R.id.replyme_lv);
            c.a.q0.k1.b.p.d dVar = new c.a.q0.k1.b.p.d(this.f21388a.getPageContext(), this.f21393f);
            this.f21391d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f21393f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f21393f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f21393f.setFadingEdgeLength(0);
            this.f21393f.setOverScrollMode(2);
            this.f21393f.addItemDecoration(new DeviderLineDecoration());
            this.f21393f.setRecyclerListener(new l(this));
            this.f21393f.setOnSrollToBottomListener(new m(this));
            this.f21393f.setOnScrollListener(this.F);
            this.f21393f.addOnScrollListener(this.r);
            N();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.f21388a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            L();
            K(false);
            return this.f21395h;
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
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f21393f == null) {
            return;
        }
        this.f21392e.setVisibility(0);
        Y(false);
        if (z) {
            this.f21389b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21389b.f();
            this.f21389b.z(this.p);
        } else {
            this.f21389b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21389b.f();
            this.f21389b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f21389b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f21390c == null) {
                this.f21390c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f21390c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f21390c, R.color.CAM_X0201);
            }
            if (this.f21390c.getParent() == null && !this.k) {
                this.k = true;
                this.f21393f.addHeaderView(this.f21390c);
                this.f21390c.setVisibility(0);
                this.f21390c.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21393f.setNextPage(null);
            if (arrayList != null) {
                this.f21391d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f21393f.removeHeaderView(this.f21390c);
            this.k = false;
            c.a.q0.k1.b.p.d dVar = this.f21391d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f21391d.c();
            }
            this.f21393f.setNextPage(this.f21389b);
            this.n = R.color.CAM_X0204;
        }
        A();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void V(String str, long j2) {
        c.a.q0.k1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            c.a.q0.k1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.g() != null && this.v.C()) {
                c.a.p0.x.w.h hVar = this.u;
                if (hVar == null || !hVar.v) {
                    K(true);
                }
                if (this.u == null || (aVar = this.v) == null) {
                    return;
                }
                if (aVar.E() && this.v.w() != null) {
                    this.u.i0(this.v.w().getName_show());
                    return;
                } else {
                    this.u.i0(null);
                    return;
                }
            }
            if (this.A == null) {
                c.a.q0.v0.f2.a.c cVar = new c.a.q0.v0.f2.a.c(this.f21388a.getPageContext());
                this.A = cVar;
                cVar.i(new e(this));
            }
            this.A.g(str, j2);
        }
    }

    public void W(x xVar) {
        c.a.q0.k1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f21391d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void X(w wVar) {
        c.a.q0.k1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f21391d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Y(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f21392e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f21393f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f21393f.setSelection(0);
        }
        this.f21392e.setRefreshing(z);
    }

    @Override // c.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.D);
            c.a.p0.x.w.h hVar = this.u;
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
            c.a.p0.x.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().onChangeSkinType(i2);
            }
            PbListView pbListView = this.f21389b;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f21389b.d(i2);
            }
            c.a.p0.s.f0.g gVar = this.f21396i;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoDataView noDataView = this.f21390c;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f21390c, R.color.CAM_X0201);
            }
            O();
            SkinManager.setBackgroundColor(this.f21393f, this.n);
            SkinManager.setBackgroundColor(this.f21392e, R.color.CAM_X0205);
            c.a.q0.k1.b.p.e eVar = this.f21397j;
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
