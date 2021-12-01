package c.a.r0.i3;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.i3.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f18235b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18236c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18237d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18238e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18239f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18240g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18241h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18242i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18243j;

    /* renamed from: k  reason: collision with root package name */
    public int f18244k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* renamed from: c.a.r0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1077a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1077a(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.E(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                if (responseUnreadPointNum.getNum() <= 0 || this.a.n >= responseUnreadPointNum.getNum()) {
                    this.a.n = responseUnreadPointNum.getNum();
                    this.a.o = false;
                } else {
                    this.a.o = true;
                    a aVar = this.a;
                    aVar.f18238e = aVar.o ? true : this.a.f18238e;
                    this.a.n = responseUnreadPointNum.getNum();
                    this.a.D();
                }
                this.a.H();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    c.a.q0.s.e0.b.j().t("key_feedback_tip_show", true);
                }
                this.a.f18242i = booleanValue;
                this.a.v = booleanValue;
                this.a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
            if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= r2.l("maintab_member_center_red_tip_" + r1, 0)) goto L12;
         */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                    }
                    booleanValue = false;
                }
                this.a.t = booleanValue;
                this.a.f18240g = booleanValue;
                this.a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
            a aVar = this.a;
            aVar.f18239f = aVar.p ? true : this.a.f18239f;
            this.a.D();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                this.a.F();
                if (this.a.f18243j) {
                    TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 1));
                    this.a.f18243j = false;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.G();
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.q0.t.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.g()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (StringUtils.isNull(currentAccount)) {
                        return;
                    }
                    String a = activityPrizeData.a();
                    c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                    String p = j2.p("person_item_activity_prize_red_tip" + currentAccount, "");
                    if (StringUtils.isNull(a) || a.equals(p)) {
                        return;
                    }
                    this.a.f18241h = true;
                    this.a.u = true;
                    this.a.D();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18245e;

        public i(a aVar) {
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
            this.f18245e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18245e.w) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1000599794, "Lc/a/r0/i3/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1000599794, "Lc/a/r0/i3/a$j;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C1077a c1077a) {
        this();
    }

    public static final a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? j.a : (a) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18236c : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18235b : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18240g : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SparseArray sparseArray = new SparseArray();
            if (this.o) {
                sparseArray.append(4, new b.a(this.f18238e, this.n));
            }
            if (this.q) {
                sparseArray.append(2, new b.a(this.f18235b, this.f18244k));
            }
            if (this.r) {
                sparseArray.append(1, new b.a(this.f18237d, this.l));
            }
            if (this.s) {
                sparseArray.append(3, new b.a(this.f18236c, this.m));
            }
            if (this.p) {
                sparseArray.append(5, new b.a(this.f18239f, 0));
            }
            if (this.t) {
                sparseArray.append(7, new b.a(this.f18240g, 0));
            }
            if (this.u) {
                sparseArray.append(9, new b.a(this.f18241h, 0));
            }
            if (this.v) {
                sparseArray.append(10, new b.a(this.f18242i, 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new c.a.r0.i3.b(sparseArray)));
            M();
        }
    }

    public final void E(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) && responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.s = newsNotifyMessage.getMsgBookmark() > this.m;
            this.q = newsNotifyMessage.getMsgFans() > this.f18244k;
            this.r = newsNotifyMessage.getMsgGiftNum() > this.l;
            this.m = newsNotifyMessage.getMsgBookmark();
            this.f18244k = newsNotifyMessage.getMsgFans();
            this.l = newsNotifyMessage.getMsgGiftNum();
            if (this.s || this.q || this.r || this.p) {
                this.f18235b = this.q ? true : this.f18235b;
                this.f18236c = this.s ? true : this.f18236c;
                this.f18237d = this.r ? true : this.f18237d;
                this.f18239f = this.p ? true : this.f18239f;
                D();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new c.a.q0.i0.a(false)));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18235b = false;
            this.f18236c = false;
            this.f18237d = false;
            this.f18238e = false;
            this.f18239f = false;
            this.f18240g = false;
            this.f18241h = false;
            this.f18244k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            x();
            c.a.d.f.m.e.a().post(new i(this));
            y();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder();
            sb.append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            inst.saveBoolean(sb.toString(), !this.o);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = this.f18237d || this.f18236c || this.f18235b || this.f18238e || this.f18239f || this.f18240g || this.f18241h || this.f18243j;
            if (this.a || !TbadkCoreApplication.isLogin()) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new c.a.q0.i0.a(z, 0)));
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.f18238e, this.n));
            sparseArray.append(2, new b.a(this.f18235b, this.f18244k));
            sparseArray.append(1, new b.a(this.f18237d, this.l));
            sparseArray.append(3, new b.a(this.f18236c, this.m));
            sparseArray.append(5, new b.a(this.f18239f, 0));
            sparseArray.append(7, new b.a(this.f18240g, 0));
            sparseArray.append(9, new b.a(this.f18241h, 0));
            sparseArray.append(10, new b.a(this.f18242i, 0));
            sparseArray.append(11, new b.a(this.f18243j, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new c.a.r0.i3.b(sparseArray)));
        }
    }

    public void L(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z2) {
            switch (i2) {
                case 1:
                    this.f18237d = z;
                    break;
                case 2:
                    this.f18235b = z;
                    break;
                case 3:
                    this.f18236c = z;
                    break;
                case 4:
                    this.f18238e = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        c.a.q0.s.e0.b.j().t("member_close_ad_setting_clicked", true);
                    }
                    this.f18239f = z;
                    break;
                case 7:
                    String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                    c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                    j2.w("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.f18240g = z;
                    break;
                case 9:
                    this.f18241h = z;
                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                    c.a.q0.s.e0.b j3 = c.a.q0.s.e0.b.j();
                    j3.x("person_item_activity_prize_red_tip" + currentAccount2, TbadkCoreApplication.getInst().getActivityPrizeData().a());
                    break;
                case 10:
                    this.f18242i = z;
                    break;
                case 11:
                    this.f18243j = z;
                    break;
            }
            K(true);
            J();
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (((this.f18244k > 0 && this.q) || (this.m > 0 && this.s) || this.p || this.u || this.v) && !this.a && TbadkCoreApplication.isLogin()) {
                if (this.v) {
                    c.a.q0.s.e0.b.j().t("key_feedback_tip_tab_show", true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new c.a.q0.i0.a(true, 0)));
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().registerListener(this.x);
            MessageManager.getInstance().registerListener(this.y);
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.C);
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.E);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (!c.a.q0.s.e0.b.j().g("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                this.f18239f = true;
            }
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder();
            sb.append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            this.w = inst.loadBoolean(sb.toString(), false);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new c.a.q0.i0.a(this.f18239f)));
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f18241h : invokeV.booleanValue;
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
        this.a = false;
        this.f18235b = false;
        this.f18236c = false;
        this.f18237d = false;
        this.f18238e = false;
        this.f18239f = false;
        this.f18240g = false;
        this.f18241h = false;
        this.f18242i = c.a.q0.s.e0.b.j().g("key_feedback_tip_show", false);
        this.f18243j = false;
        this.f18244k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = new C1077a(this, 2001120);
        this.y = new b(this, 2001176);
        this.z = new c(this, 2016561);
        this.A = new d(this, 2016459);
        this.B = new e(this, 2001436);
        this.C = new f(this, 2001384);
        this.D = new g(this, 2005016);
        this.E = new h(this, 2001371);
        w();
    }
}
