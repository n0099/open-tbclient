package c.a.p0.v1.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.f;
import c.a.o0.r.t.l;
import c.a.p0.v1.b.p.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class e extends c.a.d.a.d<ChatAggregationFragment> implements f.g, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView B;
    public MessageRedDotView C;
    public View D;
    public ImageView E;
    public TextView F;
    public MessageRedDotView G;
    public View H;
    public ImageView I;
    public TextView J;
    public MessageRedDotView K;
    public c.a.o0.r.t.d L;
    public int M;
    public int N;
    public boolean O;
    public c.a.p0.v1.b.p.e P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public AbsListView.OnScrollListener U;
    public final f.g V;
    public CustomMessageListener W;
    public c.a.d.c.g.a X;
    public e.b Y;
    public final AdapterView.OnItemClickListener Z;
    public final ChatAggregationFragment a;

    /* renamed from: b  reason: collision with root package name */
    public ImMessageCenterModel f19111b;

    /* renamed from: c  reason: collision with root package name */
    public ImMessageCenterShowItemData f19112c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f19113d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.l0.g f19114e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f19115f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f19116g;
    public final AdapterView.OnItemLongClickListener g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageAggregationListAdapter f19117h;
    public final CustomMessageListener h0;
    public ShutDownValidateTipView i;
    public c.a.p0.u1.f.i.a i0;
    public c.a.o0.r.t.j j;
    public final CustomMessageListener j0;
    public l.e k;
    public final c.a.p0.u1.f.i.b k0;
    public NoDataView l;
    public final CustomMessageListener l0;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public View t;
    public View u;
    public View v;
    public ImageView w;
    public TextView x;
    public MessageRedDotView y;
    public View z;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                e eVar = this.a;
                eVar.f19112c = eVar.f19117h.getItem(i);
                if (TbSingleton.getInstance().isImRecForumShow() && this.a.f19112c != null && this.a.f19112c.getDataType() == 2) {
                    return true;
                }
                e eVar2 = this.a;
                eVar2.b0(eVar2.f19112c);
                if (this.a.j != null) {
                    TiebaStatic.log("c12932");
                    this.a.j.m();
                    if (this.a.a != null && this.a.a.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.a.a.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19118b;

        public b(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19118b = eVar;
            this.a = imMessageCenterShowItemData;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (this.f19118b.j != null && this.f19118b.j.isShowing() && this.f19118b.a != null) {
                    this.f19118b.j.dismiss();
                }
                if (i != 0) {
                    BdLog.e("error prepareMenuDialog");
                    return;
                }
                TiebaStatic.log("c12933");
                this.f19118b.f19111b.asyncDeleteItem(this.a, this.f19118b.k0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.d0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.c0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.f0(customResponsedMessage);
                this.a.r0(false);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.f19111b.setData(null, this.a.i0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.f19117h != null) {
                    this.a.f19117h.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.f19117h == null) {
            } else {
                this.a.f19117h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.p0.u1.f.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.p0.u1.f.i.a
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T();
            }
        }
    }

    /* renamed from: c.a.p0.v1.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1448e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public RunnableC1448e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f19115f.F();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.e0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.a.p0.u1.f.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.p0.u1.f.i.b
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.I();
            }
        }

        @Override // c.a.p0.u1.f.i.b
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I();
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f049c, false);
                this.a.T();
            }
        }

        @Override // c.a.p0.u1.f.i.b
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.x0();
            }
        }

        @Override // c.a.p0.u1.f.i.b
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) || this.a.L == null) {
                return;
            }
            this.a.L.b(i);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.V((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.a.f19116g.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.f19116g.c();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.a.f19116g.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!c.a.d.f.p.l.z()) {
                    if (this.a.f19113d != null) {
                        this.a.f19113d.setRefreshing(false);
                        return;
                    }
                    return;
                }
                this.a.r0(true);
                this.a.g0(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && TbSingleton.getInstance().isImRecForumShow() && !this.a.T) {
                this.a.o0();
                this.a.T();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Page page;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof MsgRecForumHttpResMessage;
                if (z || (responsedMessage instanceof MsgRecForumSocketResMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.O || this.a.a == null || responsedMessage.getError() == -100000303) {
                            return;
                        }
                        this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0c15));
                        this.a.O = true;
                        return;
                    }
                    List<RecommendForumInfo> list = null;
                    if (z) {
                        MsgRecForumHttpResMessage msgRecForumHttpResMessage = (MsgRecForumHttpResMessage) responsedMessage;
                        list = msgRecForumHttpResMessage.forumList;
                        page = msgRecForumHttpResMessage.pageInfo;
                    } else if (responsedMessage instanceof MsgRecForumSocketResMessage) {
                        MsgRecForumSocketResMessage msgRecForumSocketResMessage = (MsgRecForumSocketResMessage) responsedMessage;
                        list = msgRecForumSocketResMessage.forumList;
                        page = msgRecForumSocketResMessage.pageInfo;
                    } else {
                        page = null;
                    }
                    this.a.t0(list);
                    if (page != null) {
                        this.a.R = page.has_more.intValue() == 1;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public m(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.r.j0.b.k().u("is_shut_down_validate", true);
                this.a.u0(false);
                this.a.v0(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public n(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.p0.v1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P == null) {
                return;
            }
            this.a.f19115f.removeHeaderView(this.a.P.e());
            this.a.Q = false;
        }
    }

    /* loaded from: classes2.dex */
    public class o implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* loaded from: classes2.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterShowItemData a;

            public a(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, imMessageCenterShowItemData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterShowItemData;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                ImMessageCenterShowItemData imMessageCenterShowItemData;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || (imMessageCenterShowItemData = this.a) == null) {
                        return null;
                    }
                    imMessageCenterShowItemData.setUnReadCount(0);
                    if (this.a.getOwnerName().equals("2")) {
                        c.a.p0.u1.h.d.f().k("apply_join_group");
                    } else if (this.a.getOwnerName().equals("3")) {
                        c.a.p0.u1.h.d.f().k("group_intro_change");
                        c.a.p0.u1.h.d.f().k("group_name_change");
                        c.a.p0.u1.h.d.f().k("group_notice_change");
                        c.a.p0.u1.h.d.f().k("group_level_up");
                        c.a.p0.u1.h.d.f().k("dismiss_group");
                        c.a.p0.u1.h.d.f().k("kick_out");
                        c.a.p0.u1.h.d.f().k("group_activitys_change");
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        public o(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    c.a.o0.s.d.b.g0().b0(c.a.o0.s.d.b.g0().x() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.a.a.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData) == null) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterShowItemData));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.a.f19117h.getItem(i);
            if (!TbSingleton.getInstance().isImRecForumShow() || item == null || item.getDataType() != 2) {
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    a(item);
                    statisticItem.param("obj_type", 6);
                } else if (ownerName.equals("1")) {
                    if (!c.a.p0.v1.a.b.a.a.b(this.a.a.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        return;
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.a.getPageContext().getPageActivity(), c.a.d.f.m.b.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
                } else if (item.getOwnerName().equals("2")) {
                    if (!c.a.p0.v1.a.b.a.a.a(this.a.a.getPageContext().getOrignalPage(), 2008021)) {
                        return;
                    }
                    b(item);
                    statisticItem.param("obj_type", 7);
                    if (c.a.o0.s.d.b.g0().F() != null) {
                        c.a.o0.s.d.b.g0().F().Q(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (item.getOwnerName().equals("3")) {
                    if (!c.a.p0.v1.a.b.a.a.a(this.a.a.getPageContext().getOrignalPage(), 2008013)) {
                        return;
                    }
                    b(item);
                    if (c.a.o0.s.d.b.g0().F() != null) {
                        c.a.o0.s.d.b.g0().F().O(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    if (!c.a.p0.v1.a.b.a.a.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
                        return;
                    }
                    long g2 = c.a.d.f.m.b.g(item.getFriendId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.a.getPageContext().getPageActivity(), g2, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                    if ("801001117".equals(String.valueOf(g2))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    } else if ("3222425470".equals(String.valueOf(g2))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else if (ownerName.equals("7")) {
                    TiebaStatic.log(new StatisticItem("c12614"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.a.a.getPageContext().getPageActivity())));
                    statisticItem.param("obj_type", 6);
                    return;
                } else {
                    a(item);
                    statisticItem.param("obj_type", 6);
                }
                if (!TextUtils.isEmpty(item.getFriendName())) {
                    if ("贴吧热榜".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 8);
                    } else if ("贴吧荣誉墙".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 9);
                    } else if ("贴吧精选".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 10);
                    } else if ("贴吧活动".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 4);
                    } else if ("吧广播".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                if (TextUtils.isEmpty(item.getFriendName()) || !this.a.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13bb).equals(item.getFriendName())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.mContext.getPageActivity()).createNormalCfg(item.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_CLICK);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", item.getForumId());
            statisticItem2.param("fname", item.getForumName());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) c.a.d.a.j.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
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
        this.f19111b = null;
        this.f19112c = null;
        this.f19115f = null;
        this.f19117h = null;
        this.j = null;
        this.m = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 16;
        this.O = false;
        this.Q = false;
        this.S = false;
        this.T = false;
        this.U = new i(this);
        this.V = new j(this);
        this.W = new k(this, 2001371);
        this.X = new l(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.Y = new n(this);
        this.Z = new o(this);
        this.g0 = new a(this);
        this.h0 = new c(this, 0);
        this.i0 = new d(this);
        this.j0 = new f(this, 2001120);
        this.k0 = new g(this);
        this.l0 = new h(this, 2001120);
        this.a = chatAggregationFragment;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19115f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            c.a.p0.v1.b.p.e eVar = this.P;
            if (eVar != null) {
                this.f19115f.removeHeaderView(eVar.e());
                this.Q = false;
                return;
            }
            return;
        }
        long m2 = c.a.o0.r.j0.b.k().m("key_im_open_notification_close_time", 0L);
        if (this.Q) {
            return;
        }
        if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
            if (this.P == null) {
                c.a.p0.v1.b.p.e eVar2 = new c.a.p0.v1.b.p.e(this.mContext);
                this.P = eVar2;
                eVar2.g(this.Y);
            }
            this.f19115f.x(this.P.e(), 0);
            this.Q = true;
        }
    }

    public final void I() {
        c.a.o0.r.t.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (dVar = this.L) != null && dVar.isShowing()) {
            this.L.dismiss();
            this.L = null;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19111b = new ImMessageCenterModel();
            u0(!c.a.o0.r.j0.b.k().h("is_shut_down_validate", false));
        }
    }

    public final void L(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.n = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0905fa);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view.findViewById(R.id.obfuscated_res_0x7f0923d2);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new m(this));
            this.f19116g = (NavigationBarShadowView) view.findViewById(R.id.obfuscated_res_0x7f091502);
            BdListView bdListView = (BdListView) view.findViewById(R.id.obfuscated_res_0x7f0905fb);
            this.f19115f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.f19117h = messageAggregationListAdapter;
            messageAggregationListAdapter.O(this.a.getPageContext());
            this.f19117h.L(this);
            this.f19115f.setAdapter((ListAdapter) this.f19117h);
            this.f19115f.setOnItemClickListener(this.Z);
            this.f19115f.setOnItemLongClickListener(this.g0);
            this.f19115f.setOnScrollListener(this.U);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d0557, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902b5);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b4);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b7);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902b6);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f090153);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090152);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090157);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090154);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091a64);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091a63);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091a67);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091a65);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f090971);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090970);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090975);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090972);
            this.y.setThreeDotMode(2);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.y.setShadowEnabled(false);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.v.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.f19115f.addHeaderView(this.u);
            H();
            this.f19113d = (BdSwipeRefreshLayout) view.findViewById(R.id.obfuscated_res_0x7f091a66);
            if (this.f19114e == null) {
                c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.a.getPageContext());
                this.f19114e = gVar;
                gVar.f(this.V);
            }
            this.f19114e.a0(getPageContext().getUniqueId());
            this.f19113d.setProgressView(this.f19114e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.d.f.p.n.f(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f070246)));
            this.f19115f.addFooterView(this.t);
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.isLogin() : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void O(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            int i2 = MentionActivityConfig.jumpInTab;
            if (i2 != -1) {
                this.s = i2;
                MentionActivityConfig.jumpInTab = -1;
            } else if (bundle != null) {
                this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.j0);
            MessageManager.getInstance().unRegisterListener(this.l0);
            if (TbSingleton.getInstance().isImRecForumShow() && this.T) {
                MessageManager.getInstance().unRegisterListener(this.X);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.W);
        }
    }

    public void Q() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (messageAggregationListAdapter = this.f19117h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public boolean S(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.i;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.b(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.f19117h;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().j(this.n);
            }
            c.a.o0.r.l0.g gVar = this.f19114e;
            if (gVar != null) {
                gVar.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19113d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.w, R.drawable.pic_information_at_me);
            SkinManager.setImageResource(this.A, R.drawable.pic_information_praise);
            SkinManager.setImageResource(this.E, R.drawable.pic_information_reply);
            SkinManager.setImageResource(this.I, R.drawable.pic_information_fans);
            MessageRedDotView messageRedDotView = this.y;
            if (messageRedDotView != null) {
                messageRedDotView.e();
            }
            MessageRedDotView messageRedDotView2 = this.C;
            if (messageRedDotView2 != null) {
                messageRedDotView2.e();
            }
            MessageRedDotView messageRedDotView3 = this.G;
            if (messageRedDotView3 != null) {
                messageRedDotView3.e();
            }
            MessageRedDotView messageRedDotView4 = this.K;
            if (messageRedDotView4 != null) {
                messageRedDotView4.e();
            }
            c.a.p0.v1.b.p.e eVar = this.P;
            if (eVar != null) {
                eVar.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void T() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdListView = this.f19115f) == null || this.f19111b == null) {
            return;
        }
        bdListView.A(0L);
        if (this.f19111b.getData() != null && this.f19111b.getData().size() > 0) {
            this.f19117h.n(this.f19111b.getData());
            if (!TbSingleton.getInstance().isImRecForumShow() || this.S) {
                return;
            }
            this.S = true;
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
            statisticItem.param("obj_param1", "0").param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        if (TbSingleton.getInstance().isImRecForumShow()) {
            MsgRecForumNetMessage msgRecForumNetMessage = new MsgRecForumNetMessage();
            msgRecForumNetMessage.mPn = 1;
            msgRecForumNetMessage.mRn = 15;
            msgRecForumNetMessage.userId = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
            this.a.sendMessage(msgRecForumNetMessage);
            if (!this.S) {
                this.S = true;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem2);
            }
        }
        w0(M(), true);
    }

    public View U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01da, (ViewGroup) null, false);
            K();
            L(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (TbSingleton.getInstance().isImRecForumShow() && !this.T) {
                o0();
            }
            n0();
            a0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void V(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, newsNotifyMessage) == null) || newsNotifyMessage == null) {
            return;
        }
        this.M = newsNotifyMessage.getMsgAtme();
        this.N = newsNotifyMessage.getMsgAgree();
        i0(this.M);
        h0(this.N);
        k0(newsNotifyMessage.getMsgFans());
        m0(newsNotifyMessage.getMsgReplyme());
    }

    public void W(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || !z || (bdListView = this.f19115f) == null || bdListView.getWrappedAdapter() == null || this.f19115f.getWrappedAdapter().getCount() > 0) {
            return;
        }
        c.a.d.f.m.e.a().post(new RunnableC1448e(this));
    }

    public void X(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
        this.s = intExtra;
        if (intExtra == -1) {
            return;
        }
        s0(true);
        Y();
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.f19117h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                s0(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                g0(false);
            }
            boolean M = M();
            if (this.p != M) {
                this.p = M;
                Z(M);
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            H();
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            w0(z, true);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f19115f.F();
            boolean M = M();
            this.p = M;
            if (M) {
                return;
            }
            w0(M, true);
        }
    }

    public final void b0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, imMessageCenterShowItemData) == null) {
            this.k = new b(this, imMessageCenterShowItemData);
            String string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f04a8);
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.a.getPageContext());
            this.j = jVar;
            jVar.j(null, new String[]{string}, this.k);
        }
    }

    public final void c0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.f19111b;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.i0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.f19111b) == null) {
            } else {
                imMessageCenterModel.remove(data, this.i0);
            }
        }
    }

    public final void d0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void e0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            j0();
        }
    }

    public final void f0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.f19111b) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.i0);
        }
    }

    public boolean g0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            if (!z) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            } else {
                this.f19115f.A(0L);
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public final void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.o0.s.d.d.d().y()) {
                    i2 = 0;
                }
                this.C.setThreeDotMode(2);
                this.C.f(i2);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.o0.s.d.d.d().q()) {
                    i2 = 0;
                }
                this.y.setThreeDotMode(2);
                this.y.f(i2);
                this.y.setVisibility(0);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final void j0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (messageAggregationListAdapter = this.f19117h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.o0.s.d.d.d().t()) {
                    i2 = 0;
                }
                this.K.setThreeDotMode(2);
                this.K.f(i2);
                this.K.setVisibility(0);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void l0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bdSwipeRefreshLayout = this.f19113d) == null || bdSwipeRefreshLayout.r()) {
            return;
        }
        r0(true);
    }

    public final void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.o0.s.d.d.d().v()) {
                    i2 = 0;
                }
                this.G.setThreeDotMode(2);
                this.G.f(i2);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.registerListener(2016004, this.h0);
            this.a.registerListener(2016001, this.h0);
            this.a.registerListener(2016010, this.h0);
            this.a.registerListener(2016007, this.h0);
            this.a.registerListener(2016011, this.h0);
            this.a.registerListener(2016002, this.h0);
            this.a.registerListener(this.j0);
            this.a.registerListener(this.l0);
            this.a.registerListener(this.W);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.o0.z0.b bVar = new c.a.o0.z0.b(309712);
            bVar.setResponsedClass(MsgRecForumSocketResMessage.class);
            bVar.g(true);
            bVar.h(false);
            bVar.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(bVar);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, c.a.p0.a4.g0.a.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.X);
            this.T = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (view == this.v) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(getPageContext().getPageActivity())));
                c.a.o0.s.d.b.g0().k();
                c.a.o0.s.d.b.g0().Z(0);
                this.M = 0;
                i0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view == this.z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
                c.a.o0.s.d.b.g0().i();
                c.a.o0.s.d.b.g0().Y(0);
                this.N = 0;
                h0(0);
                TiebaStatic.log("c12926");
                statisticItem.param("obj_type", 2);
            } else if (view == this.D) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
                c.a.o0.s.d.b.g0().p();
                c.a.o0.s.d.b.g0().e0(0);
                m0(0);
            } else if (view == this.H) {
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
                c.a.o0.s.d.b.g0().m();
                c.a.o0.s.d.b.g0().c0(0);
                k0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.o0.r.l0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.r = z;
        }
    }

    public void r0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || this.f19113d == null) {
            return;
        }
        if (z && (bdListView = this.f19115f) != null && bdListView.getFirstVisiblePosition() != 0) {
            this.f19115f.setSelection(0);
        }
        this.f19113d.setRefreshing(z);
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.q = z;
        }
    }

    public final void t0(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData.setDataType(1);
        arrayList.add(imMessageCenterShowItemData);
        ImMessageCenterShowItemData imMessageCenterShowItemData2 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData2.setDataType(3);
        arrayList.add(imMessageCenterShowItemData2);
        for (RecommendForumInfo recommendForumInfo : list) {
            if (recommendForumInfo != null && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                ImMessageCenterShowItemData imMessageCenterShowItemData3 = new ImMessageCenterShowItemData();
                imMessageCenterShowItemData3.setDataType(2);
                imMessageCenterShowItemData3.setAvatar(recommendForumInfo.avatar);
                imMessageCenterShowItemData3.setForumId(recommendForumInfo.forum_id.longValue());
                imMessageCenterShowItemData3.setForumName(recommendForumInfo.forum_name);
                imMessageCenterShowItemData3.setIsLike(recommendForumInfo.is_like.intValue());
                imMessageCenterShowItemData3.setMemberCount(recommendForumInfo.member_count.intValue());
                imMessageCenterShowItemData3.setSlogan(recommendForumInfo.slogan);
                imMessageCenterShowItemData3.setThreadCount(recommendForumInfo.thread_count.intValue());
                arrayList.add(imMessageCenterShowItemData3);
            }
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData4 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData4.setDataType(4);
        arrayList.add(imMessageCenterShowItemData4);
        if (this.f19117h.getCount() == 0) {
            this.f19117h.n(arrayList);
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.m = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (z) {
                if (!N() || this.i.getVisibility() == 0) {
                    return;
                }
                this.i.setVisibility(0);
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public void w0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            I();
            if (this.L == null) {
                this.L = c.a.p0.u1.h.e.m().p(getPageContext().getPageActivity());
            }
            this.L.show();
            this.L.b(0);
        }
    }
}
