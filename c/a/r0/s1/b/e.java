package c.a.r0.s1.b;

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
import c.a.q0.s.g0.f;
import c.a.q0.s.s.i;
import c.a.r0.s1.b.p.e;
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
import com.baidu.tbadk.core.dialog.BdProgressDialog1080;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
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
    public View L;
    public ImageView M;
    public TextView N;
    public MessageRedDotView O;
    public BdProgressDialog1080 P;
    public int Q;
    public int R;
    public boolean S;
    public c.a.r0.s1.b.p.e T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public AbsListView.OnScrollListener Y;
    public final f.g Z;
    public CustomMessageListener a0;
    public c.a.d.c.g.a b0;
    public e.b c0;
    public final AdapterView.OnItemClickListener d0;

    /* renamed from: e  reason: collision with root package name */
    public final ChatAggregationFragment f23345e;
    public final AdapterView.OnItemLongClickListener e0;

    /* renamed from: f  reason: collision with root package name */
    public ImMessageCenterModel f23346f;
    public final CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public ImMessageCenterShowItemData f23347g;
    public c.a.r0.r1.f.i.a g0;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f23348h;
    public final CustomMessageListener h0;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.g0.g f23349i;
    public final c.a.r0.r1.f.i.b i0;

    /* renamed from: j  reason: collision with root package name */
    public BdListView f23350j;

    /* renamed from: k  reason: collision with root package name */
    public NavigationBarShadowView f23351k;
    public final CustomMessageListener k0;
    public MessageAggregationListAdapter l;
    public ShutDownValidateTipView m;
    public PopupDialog n;
    public i.e o;
    public NoDataView p;
    public boolean q;
    public RelativeLayout r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23352e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23352e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                e eVar = this.f23352e;
                eVar.f23347g = eVar.l.getItem(i2);
                if (TbSingleton.getInstance().isImRecForumShow() && this.f23352e.f23347g != null && this.f23352e.f23347g.getDataType() == 2) {
                    return true;
                }
                e eVar2 = this.f23352e;
                eVar2.e0(eVar2.f23347g);
                if (this.f23352e.n != null) {
                    TiebaStatic.log("c12932");
                    this.f23352e.n.showDialog();
                    if (this.f23352e.f23345e != null && this.f23352e.f23345e.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.f23352e.f23345e.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f23353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23354f;

        public b(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23354f = eVar;
            this.f23353e = imMessageCenterShowItemData;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f23354f.n != null && this.f23354f.n.isShowing() && this.f23354f.f23345e != null) {
                    this.f23354f.n.dismiss();
                }
                if (i2 != 0) {
                    BdLog.e("error prepareMenuDialog");
                    return;
                }
                TiebaStatic.log("c12933");
                this.f23354f.f23346f.asyncDeleteItem(this.f23353e, this.f23354f.i0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.g0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.f0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.i0(customResponsedMessage);
                this.a.t0(false);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.f23346f.setData(null, this.a.g0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.l != null) {
                    this.a.l.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.l == null) {
            } else {
                this.a.l.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.r0.r1.f.i.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.r0.r1.f.i.a
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.W();
            }
        }
    }

    /* renamed from: c.a.r0.s1.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1349e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23355e;

        public RunnableC1349e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23355e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23355e.f23350j.startPullRefresh();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.h0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements c.a.r0.r1.f.i.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.r0.r1.f.i.b
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G();
            }
        }

        @Override // c.a.r0.r1.f.i.b
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.G();
                this.a.f23345e.showToast(R.string.delete_success, false);
                this.a.W();
            }
        }

        @Override // c.a.r0.r1.f.i.b
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.z0();
            }
        }

        @Override // c.a.r0.r1.f.i.b
        public void onProgressUpdate(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) || this.a.P == null) {
                return;
            }
            this.a.P.setPercent(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.Y((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23356e;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23356e = eVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f23356e.f23351k.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f23356e.f23351k.show();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f23356e.f23351k.hide();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23357e;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23357e = eVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!c.a.d.f.p.j.z()) {
                    if (this.f23357e.f23348h != null) {
                        this.f23357e.f23348h.setRefreshing(false);
                        return;
                    }
                    return;
                }
                this.f23357e.t0(true);
                this.f23357e.j0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && TbSingleton.getInstance().isImRecForumShow() && !this.a.X) {
                this.a.r0();
                this.a.W();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
                        if (this.a.S || this.a.f23345e == null || responsedMessage.getError() == -100000303) {
                            return;
                        }
                        this.a.f23345e.showToast(this.a.getActivity().getString(R.string.neterror));
                        this.a.S = true;
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
                    this.a.v0(list);
                    if (page != null) {
                        this.a.V = page.has_more.intValue() == 1;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23358e;

        public m(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23358e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.s.e0.b.j().t("is_shut_down_validate", true);
                this.f23358e.w0(false);
                this.f23358e.x0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.r0.s1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.T == null) {
                return;
            }
            this.a.f23350j.removeHeaderView(this.a.T.e());
            this.a.U = false;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23359e;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterShowItemData f23360e;

            public a(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, imMessageCenterShowItemData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23360e = imMessageCenterShowItemData;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                ImMessageCenterShowItemData imMessageCenterShowItemData;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || (imMessageCenterShowItemData = this.f23360e) == null) {
                        return null;
                    }
                    imMessageCenterShowItemData.setUnReadCount(0);
                    if (this.f23360e.getOwnerName().equals("2")) {
                        c.a.r0.r1.h.d.f().k("apply_join_group");
                    } else if (this.f23360e.getOwnerName().equals("3")) {
                        c.a.r0.r1.h.d.f().k("group_intro_change");
                        c.a.r0.r1.h.d.f().k("group_name_change");
                        c.a.r0.r1.h.d.f().k("group_notice_change");
                        c.a.r0.r1.h.d.f().k("group_level_up");
                        c.a.r0.r1.h.d.f().k("dismiss_group");
                        c.a.r0.r1.h.d.f().k("kick_out");
                        c.a.r0.r1.h.d.f().k("group_activitys_change");
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23359e = eVar;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    c.a.q0.t.d.b.g0().b0(c.a.q0.t.d.b.g0().x() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.f23359e.l.getItem(i2);
            if (!TbSingleton.getInstance().isImRecForumShow() || item == null || item.getDataType() != 2) {
                TiebaStatic.eventStat(this.f23359e.f23345e.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    a(item);
                    statisticItem.param("obj_type", 6);
                } else if (ownerName.equals("1")) {
                    if (!c.a.r0.s1.a.b.a.a.b(this.f23359e.f23345e.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f23359e.f23345e.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity(), c.a.d.f.m.b.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
                } else if (item.getOwnerName().equals("2")) {
                    if (!c.a.r0.s1.a.b.a.a.a(this.f23359e.f23345e.getPageContext().getOrignalPage(), 2008021)) {
                        return;
                    }
                    b(item);
                    statisticItem.param("obj_type", 7);
                    if (c.a.q0.t.d.b.g0().F() != null) {
                        c.a.q0.t.d.b.g0().F().Q(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity())));
                } else if (item.getOwnerName().equals("3")) {
                    if (!c.a.r0.s1.a.b.a.a.a(this.f23359e.f23345e.getPageContext().getOrignalPage(), 2008013)) {
                        return;
                    }
                    b(item);
                    if (c.a.q0.t.d.b.g0().F() != null) {
                        c.a.q0.t.d.b.g0().F().O(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    if (!c.a.r0.s1.a.b.a.a.a(this.f23359e.f23345e.getPageContext().getOrignalPage(), 2002006)) {
                        return;
                    }
                    long g2 = c.a.d.f.m.b.g(item.getFriendId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity(), g2, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                    if ("801001117".equals(String.valueOf(g2))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    } else if ("3222425470".equals(String.valueOf(g2))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else if (ownerName.equals("7")) {
                    TiebaStatic.log(new StatisticItem("c12614"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.f23359e.f23345e.getPageContext().getPageActivity())));
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
                if (TextUtils.isEmpty(item.getFriendName()) || !this.f23359e.f23345e.getPageContext().getPageActivity().getString(R.string.tieba_user_notify).equals(item.getFriendName())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f23359e.mContext.getPageActivity()).createNormalCfg(item.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
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
        this.f23346f = null;
        this.f23347g = null;
        this.f23350j = null;
        this.l = null;
        this.n = null;
        this.q = true;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = 16;
        this.S = false;
        this.U = false;
        this.W = false;
        this.X = false;
        this.Y = new i(this);
        this.Z = new j(this);
        this.a0 = new k(this, 2001371);
        this.b0 = new l(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.c0 = new n(this);
        this.d0 = new o(this);
        this.e0 = new a(this);
        this.f0 = new c(this, 0);
        this.g0 = new d(this);
        this.h0 = new f(this, 2001120);
        this.i0 = new g(this);
        this.k0 = new h(this, 2001120);
        this.f23345e = chatAggregationFragment;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23350j == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            c.a.r0.s1.b.p.e eVar = this.T;
            if (eVar != null) {
                this.f23350j.removeHeaderView(eVar.e());
                this.U = false;
                return;
            }
            return;
        }
        long l2 = c.a.q0.s.e0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.U) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.T == null) {
                c.a.r0.s1.b.p.e eVar2 = new c.a.r0.s1.b.p.e(this.mContext);
                this.T = eVar2;
                eVar2.g(this.c0);
            }
            this.f23350j.addHeaderView(this.T.e(), 0);
            this.U = true;
        }
    }

    public final void G() {
        BdProgressDialog1080 bdProgressDialog1080;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdProgressDialog1080 = this.P) != null && bdProgressDialog1080.isShowing()) {
            this.P.dismiss();
            this.P = null;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23346f = new ImMessageCenterModel();
            w0(!c.a.q0.s.e0.b.j().g("is_shut_down_validate", false));
        }
    }

    public final void L(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.r = (RelativeLayout) view.findViewById(R.id.chat_list);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
            this.m = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.m.setShutDownClickListener(new m(this));
            this.f23351k = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
            BdListView bdListView = (BdListView) view.findViewById(R.id.chat_list_content);
            this.f23350j = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.f23345e.getPageContext().getPageActivity());
            this.l = messageAggregationListAdapter;
            messageAggregationListAdapter.O(this.f23345e.getPageContext());
            this.l.L(this);
            this.f23350j.setAdapter((ListAdapter) this.l);
            this.f23350j.setOnItemClickListener(this.d0);
            this.f23350j.setOnItemLongClickListener(this.e0);
            this.f23350j.setOnScrollListener(this.Y);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
            this.y = inflate;
            this.z = inflate.findViewById(R.id.at_me_layout);
            this.A = (ImageView) this.y.findViewById(R.id.at_me_icon);
            this.B = (TextView) this.y.findViewById(R.id.at_me_text);
            this.C = (MessageRedDotView) this.y.findViewById(R.id.at_me_new_message);
            this.D = this.y.findViewById(R.id.agree_me_layout);
            this.E = (ImageView) this.y.findViewById(R.id.agree_me_icon);
            this.F = (TextView) this.y.findViewById(R.id.agree_me_text);
            this.G = (MessageRedDotView) this.y.findViewById(R.id.agree_me_new_message);
            this.H = this.y.findViewById(R.id.reply_me_layout);
            this.I = (ImageView) this.y.findViewById(R.id.reply_me_icon);
            this.J = (TextView) this.y.findViewById(R.id.reply_me_text);
            this.K = (MessageRedDotView) this.y.findViewById(R.id.reply_me_new_message);
            this.L = this.y.findViewById(R.id.fans_layout);
            this.M = (ImageView) this.y.findViewById(R.id.fans_icon);
            this.N = (TextView) this.y.findViewById(R.id.fans_text);
            this.O = (MessageRedDotView) this.y.findViewById(R.id.fans_new_message);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.O.setThreeDotMode(2);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.K.setShadowEnabled(false);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.L.setOnClickListener(this);
            this.f23350j.addHeaderView(this.y);
            F();
            this.f23348h = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
            if (this.f23349i == null) {
                c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.f23345e.getPageContext());
                this.f23349i = gVar;
                gVar.a(this.Z);
            }
            this.f23349i.V(getPageContext().getUniqueId());
            this.f23348h.setProgressView(this.f23349i);
            this.x = new View(this.f23345e.getFragmentActivity());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.d.f.p.l.f(this.f23345e.getFragmentActivity(), R.dimen.ds150)));
            this.f23350j.addFooterView(this.x);
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.isLogin() : invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void Q(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            int i2 = MentionActivityConfig.jumpInTab;
            if (i2 != -1) {
                this.w = i2;
                MentionActivityConfig.jumpInTab = -1;
            } else if (bundle != null) {
                this.w = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.w);
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.k0);
            if (TbSingleton.getInstance().isImRecForumShow() && this.X) {
                MessageManager.getInstance().unRegisterListener(this.b0);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.a0);
        }
    }

    public void T() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (messageAggregationListAdapter = this.l) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public boolean V(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f23345e.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.m;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.onChangeSkinType(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().j(this.r);
            }
            c.a.q0.s.g0.g gVar = this.f23349i;
            if (gVar != null) {
                gVar.C(i2);
            }
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f23348h, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0105);
            SkinManager.setImageResource(this.A, R.drawable.pic_information_at_me);
            SkinManager.setImageResource(this.E, R.drawable.pic_information_praise);
            SkinManager.setImageResource(this.I, R.drawable.pic_information_reply);
            SkinManager.setImageResource(this.M, R.drawable.pic_information_fans);
            MessageRedDotView messageRedDotView = this.C;
            if (messageRedDotView != null) {
                messageRedDotView.onChangeSkinType();
            }
            MessageRedDotView messageRedDotView2 = this.G;
            if (messageRedDotView2 != null) {
                messageRedDotView2.onChangeSkinType();
            }
            MessageRedDotView messageRedDotView3 = this.K;
            if (messageRedDotView3 != null) {
                messageRedDotView3.onChangeSkinType();
            }
            MessageRedDotView messageRedDotView4 = this.O;
            if (messageRedDotView4 != null) {
                messageRedDotView4.onChangeSkinType();
            }
            c.a.r0.s1.b.p.e eVar = this.T;
            if (eVar != null) {
                eVar.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void W() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdListView = this.f23350j) == null || this.f23346f == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
        if (this.f23346f.getData() != null && this.f23346f.getData().size() > 0) {
            this.l.n(this.f23346f.getData());
            if (!TbSingleton.getInstance().isImRecForumShow() || this.W) {
                return;
            }
            this.W = true;
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
            this.f23345e.sendMessage(msgRecForumNetMessage);
            if (!this.W) {
                this.W = true;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem2);
            }
        }
        y0(M(), true);
    }

    public View X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.s = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
            K();
            L(this.s);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (TbSingleton.getInstance().isImRecForumShow() && !this.X) {
                r0();
            }
            q0();
            d0();
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    public void Y(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, newsNotifyMessage) == null) || newsNotifyMessage == null) {
            return;
        }
        this.Q = newsNotifyMessage.getMsgAtme();
        this.R = newsNotifyMessage.getMsgAgree();
        l0(this.Q);
        k0(this.R);
        n0(newsNotifyMessage.getMsgFans());
        p0(newsNotifyMessage.getMsgReplyme());
    }

    public void Z(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || !z || (bdListView = this.f23350j) == null || bdListView.getWrappedAdapter() == null || this.f23350j.getWrappedAdapter().getCount() > 0) {
            return;
        }
        c.a.d.f.m.e.a().post(new RunnableC1349e(this));
    }

    public void a0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
        this.w = intExtra;
        if (intExtra == -1) {
            return;
        }
        u0(true);
        b0();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                u0(true);
            }
            if (this.v || this.u) {
                this.v = false;
                this.u = false;
                j0(false);
            }
            boolean M = M();
            if (this.t != M) {
                this.t = M;
                c0(M);
            }
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.onActivityStart(this.f23345e.getPageContext());
            }
            F();
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            y0(z, true);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f23350j.startPullRefresh();
            boolean M = M();
            this.t = M;
            if (M) {
                return;
            }
            y0(M, true);
        }
    }

    public final void e0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, imMessageCenterShowItemData) == null) {
            this.o = new b(this, imMessageCenterShowItemData);
            String string = this.f23345e.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
            PopupDialog popupDialog = new PopupDialog(this.f23345e.getPageContext());
            this.n = popupDialog;
            popupDialog.setDefaultContentView(null, new String[]{string}, this.o);
        }
    }

    public final void f0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.f23346f;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.g0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.f23346f) == null) {
            } else {
                imMessageCenterModel.remove(data, this.g0);
            }
        }
    }

    public final void g0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f23345e.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public final void h0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            m0();
        }
    }

    public final void i0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.f23346f) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.g0);
        }
    }

    public boolean j0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            if (!z) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            } else {
                this.f23350j.completePullRefreshPostDelayed(0L);
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.q0.t.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.q0.t.d.d.d().w()) {
                    i2 = 0;
                }
                this.G.setThreeDotMode(2);
                this.G.refresh(i2);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        }
    }

    public final void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.q0.t.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.q0.t.d.d.d().o()) {
                    i2 = 0;
                }
                this.C.setThreeDotMode(2);
                this.C.refresh(i2);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void m0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (messageAggregationListAdapter = this.l) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.q0.t.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.q0.t.d.d.d().r()) {
                    i2 = 0;
                }
                this.O.setThreeDotMode(2);
                this.O.refresh(i2);
                this.O.setVisibility(0);
                return;
            }
            this.O.setVisibility(8);
        }
    }

    public void o0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bdSwipeRefreshLayout = this.f23348h) == null || bdSwipeRefreshLayout.isRefreshing()) {
            return;
        }
        t0(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (view == this.z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(getPageContext().getPageActivity())));
                c.a.q0.t.d.b.g0().k();
                c.a.q0.t.d.b.g0().Z(0);
                this.Q = 0;
                l0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view == this.D) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
                c.a.q0.t.d.b.g0().i();
                c.a.q0.t.d.b.g0().Y(0);
                this.R = 0;
                k0(0);
                TiebaStatic.log("c12926");
                statisticItem.param("obj_type", 2);
            } else if (view == this.H) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
                c.a.q0.t.d.b.g0().p();
                c.a.q0.t.d.b.g0().e0(0);
                p0(0);
            } else if (view == this.L) {
                c.a.r0.i3.a.v().L(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
                c.a.q0.t.d.b.g0().m();
                c.a.q0.t.d.b.g0().c0(0);
                n0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.q0.s.g0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
        }
    }

    public final void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 > 0) {
                if (c.a.q0.t.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!c.a.q0.t.d.d.d().t()) {
                    i2 = 0;
                }
                this.K.setThreeDotMode(2);
                this.K.refresh(i2);
                this.K.setVisibility(0);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f23345e.registerListener(2016004, this.f0);
            this.f23345e.registerListener(2016001, this.f0);
            this.f23345e.registerListener(2016010, this.f0);
            this.f23345e.registerListener(2016007, this.f0);
            this.f23345e.registerListener(2016011, this.f0);
            this.f23345e.registerListener(2016002, this.f0);
            this.f23345e.registerListener(this.h0);
            this.f23345e.registerListener(this.k0);
            this.f23345e.registerListener(this.a0);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c.a.q0.z0.b bVar = new c.a.q0.z0.b(309712);
            bVar.setResponsedClass(MsgRecForumSocketResMessage.class);
            bVar.g(true);
            bVar.h(false);
            bVar.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(bVar);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, c.a.r0.t3.f0.a.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f23345e.registerListener(this.b0);
            this.X = true;
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.v = z;
        }
    }

    public void t0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || this.f23348h == null) {
            return;
        }
        if (z && (bdListView = this.f23350j) != null && bdListView.getFirstVisiblePosition() != 0) {
            this.f23350j.setSelection(0);
        }
        this.f23348h.setRefreshing(z);
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.u = z;
        }
    }

    public final void v0(List<RecommendForumInfo> list) {
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
        this.l.n(arrayList);
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.q = z;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (z) {
                if (!O() || this.m.getVisibility() == 0) {
                    return;
                }
                this.m.setVisibility(0);
            } else if (this.m.getVisibility() != 8) {
                this.m.setVisibility(8);
            }
        }
    }

    public void y0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            G();
            if (this.P == null) {
                this.P = c.a.r0.r1.h.e.m().p(getPageContext().getPageActivity());
            }
            this.P.show();
            this.P.setPercent(0);
        }
    }
}
