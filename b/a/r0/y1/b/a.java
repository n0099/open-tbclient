package b.a.r0.y1.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.a.j;
import b.a.e.f.p.l;
import b.a.q0.x.a0.a;
import b.a.r0.y1.a.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.tieba.memberCenter.bubble.SetBubbleResultData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends b.a.q0.x.a0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.e A;
    public BubbleListModel q;
    public BubbleListData r;
    public Context s;
    public int t;
    public String u;
    public BubbleListModel.c v;
    public BubbleListModel.d w;
    public CustomMessageListener x;
    public View.OnClickListener y;
    public c.e z;

    /* renamed from: b.a.r0.y1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1409a implements a.InterfaceC0749a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f28768a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28769b;

        public C1409a(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28769b = aVar;
            this.f28768a = context;
        }

        @Override // b.a.q0.x.a0.a.InterfaceC0749a
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            BubbleView bubbleView;
            BubbleView bubbleView2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    bubbleView2 = new BubbleView(this.f28768a);
                    bubbleView = bubbleView2;
                } else {
                    bubbleView = view;
                    bubbleView2 = (BubbleView) view;
                }
                BubbleListData.BubbleData M = this.f28769b.M(i2);
                if (M != null) {
                    bubbleView2.setData(M, BubbleListModel.y(this.f28769b.r.getB_info()));
                    bubbleView2.setGravity(17);
                    bubbleView2.setTag(Integer.valueOf(i2));
                    bubbleView2.setOnClickListener(this.f28769b.y);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) j.a(this.f28769b.s);
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(bubbleView);
                return bubbleView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28770a;

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
            this.f28770a = aVar;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bubbleListData) == null) {
                this.f28770a.r = null;
                if (bubbleListData == null) {
                    UtilHelper.showToast(this.f28770a.s, R.string.neterror);
                } else if (bubbleListData.getError_code().equals("0")) {
                    UtilHelper.showToast(this.f28770a.s, R.string.neterror);
                } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    UtilHelper.showToast(this.f28770a.s, bubbleListData.getError_msg());
                } else {
                    UtilHelper.showToast(this.f28770a.s, R.string.neterror);
                }
                if (this.f28770a.h() != null) {
                    this.f28770a.h().onLoadFail();
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                if (bubbleListData == null) {
                    this.f28770a.h().onLoadFail();
                    return;
                }
                this.f28770a.r = bubbleListData.m38clone();
                if (this.f28770a.q.A() > 0) {
                    List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                    if (b_info == null || b_info.size() == 0) {
                        return;
                    }
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == this.f28770a.q.A()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            this.f28770a.q.G(this.f28770a.q.A());
                            this.f28770a.q.F(this.f28770a.q.A(), l.k(this.f28770a.s), l.i(this.f28770a.s));
                        }
                    }
                    this.f28770a.q.H(-1);
                }
                this.f28770a.N();
                this.f28770a.h().b(this.f28770a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28771a;

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
            this.f28771a = aVar;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null && setBubbleResultData.getB_info() != null) {
                    this.f28771a.u = setBubbleResultData.getB_info().getB_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.f28771a.u);
                    int z = this.f28771a.q.z();
                    if (z == 0) {
                        TbadkCoreApplication.getInst().setDefaultBubble("");
                        for (BubbleListData.BubbleData bubbleData : this.f28771a.r.getB_info()) {
                            if (bubbleData.getBcode() != 0) {
                                if (bubbleData.isDef()) {
                                    bubbleData.setIs_def(0);
                                }
                            } else {
                                bubbleData.setIs_def(1);
                            }
                        }
                    } else if (setBubbleResultData.getB_info().canUser()) {
                        for (BubbleListData.BubbleData bubbleData2 : this.f28771a.r.getB_info()) {
                            if (bubbleData2.getBcode() == z) {
                                bubbleData2.setIs_def(1);
                            } else if (bubbleData2.isDef()) {
                                bubbleData2.setIs_def(0);
                            }
                            if (bubbleData2.getBcode() == z) {
                                bubbleData2.setCan_use(1);
                            }
                        }
                    } else {
                        UtilHelper.showToast(this.f28771a.s, R.string.setdefualt_error);
                        if (this.f28771a.r != null && this.f28771a.r.getB_info() != null && this.f28771a.r.getB_info().size() > 0) {
                            if (this.f28771a.r.getB_info().get(0).getBcode() == 0) {
                                this.f28771a.t = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= this.f28771a.r.getB_info().size()) {
                                        break;
                                    } else if (this.f28771a.r.getB_info().get(i2).isDef()) {
                                        this.f28771a.t = i2;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                this.f28771a.r.getB_info().get(this.f28771a.t).setIs_def(0);
                                this.f28771a.r.getB_info().get(0).setIs_def(1);
                            } else {
                                BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                                bubbleData3.setBcode(0);
                                this.f28771a.r.getB_info().add(0, bubbleData3);
                            }
                        }
                    }
                    this.f28771a.N();
                    this.f28771a.h().b(this.f28771a);
                    return;
                }
                this.f28771a.h().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null) {
                    if (setBubbleResultData.getError_code().equals("0")) {
                        UtilHelper.showToast(this.f28771a.s, R.string.neterror);
                    } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                        UtilHelper.showToast(this.f28771a.s, setBubbleResultData.getError_msg());
                    } else {
                        UtilHelper.showToast(this.f28771a.s, R.string.neterror);
                    }
                } else {
                    UtilHelper.showToast(this.f28771a.s, R.string.neterror);
                }
                if (this.f28771a.h() != null) {
                    this.f28771a.h().onLoadFail();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28772a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f28772a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f28772a.q.E(0, 50, 0, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28773e;

        public e(a aVar) {
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
            this.f28773e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f28773e.r != null && (view instanceof BubbleView)) {
                BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) ListUtils.getItem(this.f28773e.r.getB_info(), ((Integer) view.getTag()).intValue());
                TbadkSettings inst = TbadkSettings.getInst();
                boolean loadBoolean = inst.loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
                if (bubbleData == null || bubbleData.isDef()) {
                    return;
                }
                if (bubbleData.getBcode() == 0 || bubbleData.canUse() || loadBoolean) {
                    this.f28773e.O(bubbleData.getBcode());
                } else if (bubbleData.isFree()) {
                    if (this.f28773e.s instanceof TbPageContextSupport) {
                        b.a.r0.y1.a.c.a(((TbPageContextSupport) this.f28773e.s).getPageContext(), bubbleData, this.f28773e.z);
                    }
                } else if (this.f28773e.s instanceof TbPageContextSupport) {
                    b.a.r0.y1.a.c.b(((TbPageContextSupport) this.f28773e.s).getPageContext(), bubbleData, this.f28773e.A);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28774a;

        public f(a aVar) {
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
            this.f28774a = aVar;
        }

        @Override // b.a.r0.y1.a.c.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f28774a.O(i2);
            }
        }

        @Override // b.a.r0.y1.a.c.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28775a;

        public g(a aVar) {
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
            this.f28775a = aVar;
        }

        @Override // b.a.r0.y1.a.c.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f28775a.q.H(i2);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f28775a.s, true, 23004, "pop_unable");
                memberPayActivityConfig.setSceneId("4002001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }

        @Override // b.a.r0.y1.a.c.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0;
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this, 2010040);
        this.y = new e(this);
        this.z = new f(this);
        this.A = new g(this);
    }

    public final BubbleListData.BubbleData M(int i2) {
        InterceptResult invokeI;
        BubbleListData bubbleListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= c() || (bubbleListData = this.r) == null) {
                return null;
            }
            return bubbleListData.getB_info().get(i2);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BubbleListData bubbleListData = this.r;
            boolean z = false;
            if (bubbleListData != null && bubbleListData.getB_info() != null && this.r.getB_info().size() > 0) {
                BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
                bubbleData.setBcode(0);
                if (this.r.getB_info().get(0).getBcode() != 0) {
                    this.r.getB_info().add(0, bubbleData);
                }
                this.t = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.r.getB_info().size()) {
                        break;
                    } else if (this.r.getB_info().get(i2).isDef()) {
                        this.t = i2;
                        this.u = this.r.getB_info().get(i2).getBg_url();
                        TbadkCoreApplication.getInst().setDefaultBubble(this.u);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (this.t != 0 && !TextUtils.isEmpty(this.u)) {
                sendAction(new b.a.q0.x.a(2, 12, " "));
                z = true;
            } else {
                sendAction(new b.a.q0.x.a(2, 12, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
            sendAction(new b.a.q0.x.a(25, -1, this.u));
        }
    }

    public final void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.q.F(i2, l.k(this.s), l.i(this.s));
            this.q.G(i2);
            if (h() != null) {
                h().a();
            }
        }
    }

    @Override // b.a.q0.x.a0.a
    public void a() {
        BubbleListModel bubbleListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bubbleListModel = this.q) == null) {
            return;
        }
        bubbleListModel.unRegisterListener();
        this.q.K(this.x);
        this.q = null;
    }

    @Override // b.a.q0.x.a0.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BubbleListData bubbleListData = this.r;
            if (bubbleListData == null || bubbleListData.getB_info() == null) {
                return 0;
            }
            return this.r.getB_info().size();
        }
        return invokeV.intValue;
    }

    @Override // b.a.q0.x.a0.a
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = context;
            a.b bVar = new a.b();
            bVar.f14970a = R.drawable.icon_bubble;
            bVar.f14971b = 0;
            w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26));
            q(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30));
            r(bVar);
            o(2);
            v(2);
            x(new C1409a(this, context));
            this.u = TbadkCoreApplication.getInst().getDefaultBubble();
            if (this.q == null) {
                Context context2 = this.s;
                if (context2 instanceof TbPageContext) {
                    this.q = new BubbleListModel((TbPageContext) context2);
                } else {
                    this.q = new BubbleListModel(null);
                }
            }
            this.q.I(this.v);
            this.q.J(this.w);
            this.q.D(this.x);
            this.q.B();
            this.q.C();
            if (h() != null) {
                h().a();
            }
            this.q.E(0, 50, l.k(this.s), l.i(this.s));
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(b.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.q == null) {
                Context context = this.s;
                if (context instanceof TbPageContext) {
                    this.q = new BubbleListModel((TbPageContext) context);
                } else {
                    this.q = new BubbleListModel(null);
                }
            }
            if (h() != null) {
                h().a();
            }
            this.q.E(0, 50, l.k(this.s), l.i(this.s));
        }
    }
}
