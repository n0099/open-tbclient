package c.a.q0.a.y0;

import androidx.annotation.NonNull;
import c.a.q0.a.k;
import c.a.q0.a.y0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<W extends d> implements ZeusPlugin {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9064g;
    public transient /* synthetic */ FieldHolder $fh;
    public c<W> a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusPlugin.Callback f9065b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public W f9066c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9067d;

    /* renamed from: e  reason: collision with root package name */
    public final List<ZeusPlugin.Command> f9068e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f9069f;

    /* loaded from: classes.dex */
    public class a implements d.a {
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

        @Override // c.a.q0.a.y0.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.a) {
                    boolean unused = b.f9064g;
                    this.a.d();
                    this.a.f9067d = true;
                    boolean unused2 = b.f9064g;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638193369, "Lc/a/q0/a/y0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(638193369, "Lc/a/q0/a/y0/b;");
                return;
            }
        }
        f9064g = k.a;
    }

    public b(@NonNull W w) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9067d = false;
        this.f9068e = new ArrayList();
        this.f9069f = new a(this);
        this.a = new c<>();
        this.f9066c = w;
        boolean z = f9064g;
        this.f9066c.A(this.f9069f);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9068e.size() == 0) {
            return;
        }
        Iterator<ZeusPlugin.Command> it = this.f9068e.iterator();
        while (it.hasNext()) {
            ZeusPlugin.Command next = it.next();
            if (f9064g) {
                String str = "flush-尝试分发Command: + " + next.what;
            }
            this.a.b(next, this.f9066c);
            it.remove();
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            synchronized (this) {
                if (command == null) {
                    return;
                }
                if (this.f9067d) {
                    if (f9064g) {
                        String str = "组件已初始化，直接尝试分发Command: + " + command.what;
                    }
                    this.a.b(command, this.f9066c);
                } else {
                    ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                    command2.what = command.what;
                    command2.arg1 = command.arg1;
                    command2.arg2 = command.arg2;
                    command2.arg3 = command.arg3;
                    command2.arg4 = command.arg4;
                    command2.arg5 = command.arg5;
                    command2.obj = command.obj;
                    this.f9068e.add(command2);
                    if (f9064g) {
                        String str2 = "组件未初始化，加入Pending队列： " + command2.what;
                    }
                    this.a.c(command);
                }
            }
        }
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callback) == null) {
            this.f9065b = callback;
        }
    }
}
