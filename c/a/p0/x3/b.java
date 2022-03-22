package c.a.p0.x3;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.x3.c.b;
import c.a.p0.x3.c.c;
import c.a.p0.x3.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.stampmission.model.StampMissionModel;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b m;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<StampMission.Type, StampMission> a;

    /* renamed from: b  reason: collision with root package name */
    public StampMissionModel f20693b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.x3.c.b f20694c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20695d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20696e;

    /* renamed from: f  reason: collision with root package name */
    public final String f20697f;

    /* renamed from: g  reason: collision with root package name */
    public final String f20698g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20699h;
    public boolean i;
    public boolean j;
    public c k;
    public final StampMissionModel.b l;

    /* loaded from: classes3.dex */
    public class a implements StampMissionModel.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.stampmission.model.StampMissionModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
            if (r0.equals(com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage.TASK_FOLLOW) == false) goto L41;
         */
        @Override // com.baidu.tieba.stampmission.model.StampMissionModel.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(c.a.p0.x3.c.b bVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                char c2 = 0;
                if ("start".equals(bVar.f20705c)) {
                    c.a.o0.r.j0.b.k().y(this.a.f20697f, bVar.i);
                    this.a.f20694c = bVar;
                    b bVar2 = this.a;
                    bVar2.I(bVar2.f20694c);
                    if (!this.a.u() && this.a.f20699h) {
                        e.e(bVar, this.a.f20698g, this.a.k);
                        this.a.f20699h = false;
                    }
                    this.a.f20696e = true;
                    this.a.f20695d = true;
                } else if (StampMissionHttpRequestMessage.TYPE_SYNC.equals(bVar.f20705c)) {
                    String str2 = bVar.f20706d;
                    int hashCode = str2.hashCode();
                    if (hashCode == -549184070) {
                        if (str2.equals(StampMissionHttpRequestMessage.TASK_REPLY)) {
                            c2 = 2;
                        }
                        c2 = 65535;
                    } else if (hashCode != -163617491) {
                        if (hashCode == 1596610899) {
                        }
                        c2 = 65535;
                    } else {
                        if (str2.equals(StampMissionHttpRequestMessage.TASK_LIKE)) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    }
                    if (c2 == 0) {
                        this.a.F(StampMission.Type.FOLLOW_FORUM, StampMission.a.a);
                        b.C1548b c1548b = bVar.f20710h;
                        if (c1548b != null) {
                            str = c1548b.a.a;
                        }
                        str = "";
                    } else if (c2 != 1) {
                        if (c2 == 2) {
                            this.a.F(StampMission.Type.REPLAY_THREAD, StampMission.a.f36067c);
                            b.C1548b c1548b2 = bVar.f20710h;
                            if (c1548b2 != null) {
                                str = c1548b2.f20713c.a;
                            }
                        }
                        str = "";
                    } else {
                        this.a.F(StampMission.Type.LIKE_THREAD, StampMission.a.f36066b);
                        b.C1548b c1548b3 = bVar.f20710h;
                        if (c1548b3 != null) {
                            str = c1548b3.f20712b.a;
                        }
                        str = "";
                    }
                    this.a.H(str);
                    if (this.a.t()) {
                        this.a.delete();
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.x3.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1547b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-179889914, "Lc/a/p0/x3/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-179889914, "Lc/a/p0/x3/b$b;");
                    return;
                }
            }
            int[] iArr = new int[StampMission.Type.values().length];
            a = iArr;
            try {
                iArr[StampMission.Type.FOLLOW_FORUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[StampMission.Type.LIKE_THREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[StampMission.Type.REPLAY_THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20695d = false;
        this.f20696e = false;
        this.f20699h = false;
        this.i = false;
        this.j = false;
        this.l = new a(this);
        B();
        w();
        this.f20697f = "key_stamp_mission_dialog_data_" + TbadkCoreApplication.getCurrentAccount();
        this.f20698g = "key_stamp_mission_dialog_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            for (StampMission stampMission : this.a.values()) {
                stampMission.delete();
            }
            c.a.o0.r.j0.b.k().D(this.f20697f);
            this.f20696e = false;
        }
    }

    public static b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (m == null) {
                synchronized (b.class) {
                    if (m == null) {
                        m = new b();
                    }
                }
            }
            return m;
        }
        return (b) invokeV.objValue;
    }

    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && p()) {
            if (this.k == null) {
                this.k = new c();
            }
            c cVar = this.k;
            cVar.a = i;
            cVar.f20714b = i2;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(new c.a.p0.x3.e.a());
            C(new c.a.p0.x3.e.b());
            C(new c.a.p0.x3.e.c());
        }
    }

    public final void C(StampMission stampMission) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stampMission) == null) {
            if (this.a == null) {
                this.a = new HashMap();
            }
            if (stampMission == null || stampMission.getType() == null) {
                return;
            }
            this.a.put(stampMission.getType(), stampMission);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.i = z;
        }
    }

    public final void F(StampMission.Type type, int i) {
        Map<StampMission.Type, StampMission> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, type, i) == null) || (map = this.a) == null || map.get(type) == null) {
            return;
        }
        this.a.get(type).d(i);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && p() && !u()) {
            String q = c.a.o0.r.j0.b.k().q(this.f20697f, null);
            if (!TextUtils.isEmpty(q)) {
                this.f20694c = c.a.p0.x3.c.b.a(q);
                if (x()) {
                    e.e(this.f20694c, this.f20698g, this.k);
                    this.f20699h = false;
                    return;
                }
                return;
            }
            this.f20699h = true;
            this.f20693b.D();
        }
    }

    public final void H(final String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        ScreenTopToast screenTopToast = new ScreenTopToast(TbadkCoreApplication.getInst());
        screenTopToast.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11c1));
        screenTopToast.k(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11c0));
        screenTopToast.j(new View.OnClickListener() { // from class: c.a.p0.x3.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    c.a.o0.l.a.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + str);
                }
            }
        });
        screenTopToast.n((ViewGroup) TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290));
    }

    public final void I(c.a.p0.x3.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.f20707e == 1) {
            this.a.get(StampMission.Type.FOLLOW_FORUM).d(StampMission.a.a);
        }
        if (bVar.f20708f == 1) {
            this.a.get(StampMission.Type.LIKE_THREAD).d(StampMission.a.f36066b);
        }
        if (bVar.f20709g == 1) {
            this.a.get(StampMission.Type.REPLAY_THREAD).d(StampMission.a.f36067c);
        }
    }

    public final void J(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, type) == null) {
            int i = C1547b.a[type.ordinal()];
            if (i == 1) {
                this.f20693b.B(StampMissionHttpRequestMessage.TASK_FOLLOW);
            } else if (i == 2) {
                this.f20693b.B(StampMissionHttpRequestMessage.TASK_LIKE);
            } else if (i != 3) {
            } else {
                this.f20693b.B(StampMissionHttpRequestMessage.TASK_REPLY);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.i && !this.j && TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && (UbsABTestHelper.isStampMissionDialogABTestB() || UbsABTestHelper.isStampMissionDialogABTestA()) : invokeV.booleanValue;
    }

    public int q(StampMission.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, type)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null) {
                return 0;
            }
            return this.a.get(type).a();
        }
        return invokeL.intValue;
    }

    public int s(StampMission.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, type)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null) {
                return 0;
            }
            return this.a.get(type).b();
        }
        return invokeL.intValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null) {
                return false;
            }
            for (StampMission stampMission : map.values()) {
                if (stampMission.a() != stampMission.b()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TimeHelper.isSameDay(c.a.o0.r.j0.b.k().m(this.f20698g, 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String q = c.a.o0.r.j0.b.k().q(this.f20697f, null);
            if (!TextUtils.isEmpty(q)) {
                this.f20694c = c.a.p0.x3.c.b.a(q);
                this.f20696e = true;
                this.f20695d = true;
                return;
            }
            this.f20693b.D();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StampMissionModel stampMissionModel = new StampMissionModel();
            this.f20693b = stampMissionModel;
            stampMissionModel.C(this.l);
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            c.a.p0.x3.c.b bVar = this.f20694c;
            return currentTimeMillis >= bVar.a && currentTimeMillis <= bVar.f20704b;
        }
        return invokeV.booleanValue;
    }

    public void z(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, type) == null) || !p() || this.f20699h || c.a.o0.r.j0.b.k().m(this.f20698g, 0L) == 0) {
            return;
        }
        if (!this.f20695d) {
            v();
        }
        if (this.f20696e) {
            if (!x()) {
                delete();
                return;
            }
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null || this.a.get(type).c()) {
                return;
            }
            J(type);
        }
    }
}
