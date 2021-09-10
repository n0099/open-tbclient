package c.a.q0.t.j;

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
/* loaded from: classes3.dex */
public class c extends c.a.e.c.g.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f14956g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14957a;

    /* renamed from: b  reason: collision with root package name */
    public int f14958b;

    /* renamed from: c  reason: collision with root package name */
    public long f14959c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f14960d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f14961e;

    /* renamed from: f  reason: collision with root package name */
    public int f14962f;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f14963a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14964b;

        /* renamed from: c  reason: collision with root package name */
        public long f14965c;

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
                int i3 = this.f14963a + 1;
                this.f14963a = i3;
                if (this.f14964b || i3 < i2) {
                    return;
                }
                this.f14964b = true;
                this.f14965c = System.currentTimeMillis();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f14963a = 0;
                if (this.f14964b) {
                    this.f14964b = false;
                    this.f14965c = 0L;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1672473154, "Lc/a/q0/t/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1672473154, "Lc/a/q0/t/j/c;");
                return;
            }
        }
        f14956g = new c();
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
        this.f14958b = 3;
        this.f14959c = 300000L;
        this.f14960d = new SparseArray<>();
        this.f14961e = new HashSet<>();
        this.f14962f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f14956g : (c) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14962f : invokeV.intValue;
    }

    @Modify(description = "长连接是否可用", type = 32)
    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f14962f = 0;
            if (this.f14957a) {
                this.f14962f = 3;
                return false;
            } else if (this.f14961e.contains(Integer.valueOf(i2))) {
                this.f14962f = 6;
                return false;
            } else if (!MessageManager.getInstance().getSocketClient().v()) {
                this.f14962f = 1;
                return false;
            } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
                c.a.e.c.e.c.i.a("lcapimgr", i2, 0, "isAPIAvailableNow", 0, "deepsleep");
                this.f14962f = 2;
                return false;
            } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
                return false;
            } else {
                b bVar = this.f14960d.get(i2);
                if (bVar != null && bVar.f14964b) {
                    if (Math.abs(System.currentTimeMillis() - bVar.f14965c) > this.f14959c) {
                        bVar.b();
                    } else {
                        this.f14962f = 4;
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
            b bVar = this.f14960d.get(i2);
            if (bVar == null) {
                bVar = new b(null);
                this.f14960d.append(i2, bVar);
            }
            if (bVar != null) {
                bVar.a(this.f14958b);
            }
            this.f14962f = 5;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f14960d.remove(i2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < this.f14960d.size(); i2++) {
                this.f14960d.valueAt(i2).b();
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f14957a = z;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f14958b = i2;
        }
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f14959c = j2;
        }
    }

    public void j(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        this.f14961e.clear();
        for (int i2 : iArr) {
            this.f14961e.add(Integer.valueOf(i2));
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
