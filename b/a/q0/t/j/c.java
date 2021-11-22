package b.a.q0.t.j;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
@ModifyClass
/* loaded from: classes4.dex */
public class c extends b.a.e.c.g.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f14839g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14840a;

    /* renamed from: b  reason: collision with root package name */
    public int f14841b;

    /* renamed from: c  reason: collision with root package name */
    public long f14842c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f14843d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f14844e;

    /* renamed from: f  reason: collision with root package name */
    public int f14845f;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f14846a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14847b;

        /* renamed from: c  reason: collision with root package name */
        public long f14848c;

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
                }
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = this.f14846a + 1;
                this.f14846a = i3;
                if (this.f14847b || i3 < i2) {
                    return;
                }
                this.f14847b = true;
                this.f14848c = System.currentTimeMillis();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f14846a = 0;
                if (this.f14847b) {
                    this.f14847b = false;
                    this.f14848c = 0L;
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1965876161, "Lb/a/q0/t/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1965876161, "Lb/a/q0/t/j/c;");
                return;
            }
        }
        f14839g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super(1001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14841b = 3;
        this.f14842c = 300000L;
        this.f14843d = new SparseArray<>();
        this.f14844e = new HashSet<>();
        this.f14845f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f14839g : (c) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14845f : invokeV.intValue;
    }

    @Modify(description = "长连接是否可用", type = 32)
    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f14845f = 0;
            if (this.f14840a) {
                this.f14845f = 3;
                return false;
            } else if (this.f14844e.contains(Integer.valueOf(i2))) {
                this.f14845f = 6;
                return false;
            } else if (!MessageManager.getInstance().getSocketClient().v()) {
                this.f14845f = 1;
                return false;
            } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
                b.a.e.c.e.c.i.a("lcapimgr", i2, 0, "isAPIAvailableNow", 0, "deepsleep");
                this.f14845f = 2;
                return false;
            } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
                return false;
            } else {
                b bVar = this.f14843d.get(i2);
                if (bVar != null && bVar.f14847b) {
                    if (Math.abs(System.currentTimeMillis() - bVar.f14848c) > this.f14842c) {
                        bVar.b();
                    } else {
                        this.f14845f = 4;
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b bVar = this.f14843d.get(i2);
            if (bVar == null) {
                bVar = new b(null);
                this.f14843d.append(i2, bVar);
            }
            if (bVar != null) {
                bVar.a(this.f14841b);
            }
            this.f14845f = 5;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f14843d.remove(i2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < this.f14843d.size(); i2++) {
                this.f14843d.valueAt(i2).b();
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f14840a = z;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f14841b = i2;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f14842c = j;
        }
    }

    public void j(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        this.f14844e.clear();
        for (int i2 : iArr) {
            this.f14844e.add(Integer.valueOf(i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            f();
        }
    }
}
