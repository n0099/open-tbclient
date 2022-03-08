package c.a.r0.v3;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.v3.c.b;
import c.a.r0.v3.c.c;
import c.a.r0.v3.f.e;
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
    public StampMissionModel f24285b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v3.c.b f24286c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24287d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24288e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24289f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24290g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24291h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24292i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24293j;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void b(c.a.r0.v3.c.b bVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                char c2 = 0;
                if ("start".equals(bVar.f24299c)) {
                    c.a.q0.r.j0.b.k().y(this.a.f24289f, bVar.f24305i);
                    this.a.f24286c = bVar;
                    b bVar2 = this.a;
                    bVar2.I(bVar2.f24286c);
                    if (!this.a.u() && this.a.f24291h) {
                        e.e(bVar, this.a.f24290g, this.a.k);
                        this.a.f24291h = false;
                    }
                    this.a.f24288e = true;
                    this.a.f24287d = true;
                } else if (StampMissionHttpRequestMessage.TYPE_SYNC.equals(bVar.f24299c)) {
                    String str2 = bVar.f24300d;
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
                        b.C1494b c1494b = bVar.f24304h;
                        if (c1494b != null) {
                            str = c1494b.a.a;
                        }
                        str = "";
                    } else if (c2 != 1) {
                        if (c2 == 2) {
                            this.a.F(StampMission.Type.REPLAY_THREAD, StampMission.a.f46680c);
                            b.C1494b c1494b2 = bVar.f24304h;
                            if (c1494b2 != null) {
                                str = c1494b2.f24308c.a;
                            }
                        }
                        str = "";
                    } else {
                        this.a.F(StampMission.Type.LIKE_THREAD, StampMission.a.f46679b);
                        b.C1494b c1494b3 = bVar.f24304h;
                        if (c1494b3 != null) {
                            str = c1494b3.f24307b.a;
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

    /* renamed from: c.a.r0.v3.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1493b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947043010, "Lc/a/r0/v3/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1947043010, "Lc/a/r0/v3/b$b;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24287d = false;
        this.f24288e = false;
        this.f24291h = false;
        this.f24292i = false;
        this.f24293j = false;
        this.l = new a(this);
        B();
        w();
        this.f24289f = "key_stamp_mission_dialog_data_" + TbadkCoreApplication.getCurrentAccount();
        this.f24290g = "key_stamp_mission_dialog_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            for (StampMission stampMission : this.a.values()) {
                stampMission.delete();
            }
            c.a.q0.r.j0.b.k().D(this.f24289f);
            this.f24288e = false;
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

    public void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && p()) {
            if (this.k == null) {
                this.k = new c();
            }
            c cVar = this.k;
            cVar.a = i2;
            cVar.f24309b = i3;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(new c.a.r0.v3.e.a());
            C(new c.a.r0.v3.e.b());
            C(new c.a.r0.v3.e.c());
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
            this.f24293j = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f24292i = z;
        }
    }

    public final void F(StampMission.Type type, int i2) {
        Map<StampMission.Type, StampMission> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, type, i2) == null) || (map = this.a) == null || map.get(type) == null) {
            return;
        }
        this.a.get(type).d(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && p() && !u()) {
            String q = c.a.q0.r.j0.b.k().q(this.f24289f, null);
            if (!TextUtils.isEmpty(q)) {
                this.f24286c = c.a.r0.v3.c.b.a(q);
                if (x()) {
                    e.e(this.f24286c, this.f24290g, this.k);
                    this.f24291h = false;
                    return;
                }
                return;
            }
            this.f24291h = true;
            this.f24285b.B();
        }
    }

    public final void H(final String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        new ScreenTopToast(TbadkCoreApplication.getInst()).setTitle(TbadkCoreApplication.getInst().getString(R.string.stamp_top_toast_text)).setBtnText(TbadkCoreApplication.getInst().getString(R.string.stamp_top_toast_btn)).setBtnClickListener(new View.OnClickListener() { // from class: c.a.r0.v3.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    c.a.q0.l.a.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + str);
                }
            }
        }).show((ViewGroup) TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290));
    }

    public final void I(c.a.r0.v3.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.f24301e == 1) {
            this.a.get(StampMission.Type.FOLLOW_FORUM).d(StampMission.a.a);
        }
        if (bVar.f24302f == 1) {
            this.a.get(StampMission.Type.LIKE_THREAD).d(StampMission.a.f46679b);
        }
        if (bVar.f24303g == 1) {
            this.a.get(StampMission.Type.REPLAY_THREAD).d(StampMission.a.f46680c);
        }
    }

    public final void J(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, type) == null) {
            int i2 = C1493b.a[type.ordinal()];
            if (i2 == 1) {
                this.f24285b.z(StampMissionHttpRequestMessage.TASK_FOLLOW);
            } else if (i2 == 2) {
                this.f24285b.z(StampMissionHttpRequestMessage.TASK_LIKE);
            } else if (i2 != 3) {
            } else {
                this.f24285b.z(StampMissionHttpRequestMessage.TASK_REPLY);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.f24292i && !this.f24293j && TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && (UbsABTestHelper.isStampMissionDialogABTestB() || UbsABTestHelper.isStampMissionDialogABTestA()) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TimeHelper.isSameDay(c.a.q0.r.j0.b.k().m(this.f24290g, 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String q = c.a.q0.r.j0.b.k().q(this.f24289f, null);
            if (!TextUtils.isEmpty(q)) {
                this.f24286c = c.a.r0.v3.c.b.a(q);
                this.f24288e = true;
                this.f24287d = true;
                return;
            }
            this.f24285b.B();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StampMissionModel stampMissionModel = new StampMissionModel();
            this.f24285b = stampMissionModel;
            stampMissionModel.A(this.l);
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            c.a.r0.v3.c.b bVar = this.f24286c;
            return currentTimeMillis >= bVar.a && currentTimeMillis <= bVar.f24298b;
        }
        return invokeV.booleanValue;
    }

    public void z(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, type) == null) || !p() || this.f24291h || c.a.q0.r.j0.b.k().m(this.f24290g, 0L) == 0) {
            return;
        }
        if (!this.f24287d) {
            v();
        }
        if (this.f24288e) {
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
