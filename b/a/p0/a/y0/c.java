package b.a.p0.a.y0;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import b.a.p0.a.y0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class c<W extends d> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9313b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a<W>> f9314a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1340265530, "Lb/a/p0/a/y0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1340265530, "Lb/a/p0/a/y0/c;");
                return;
            }
        }
        f9313b = k.f6863a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9314a = new HashMap<>();
    }

    public void a(a<W> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (f9313b) {
                String str = aVar.b() + " command added to supported command list";
            }
            this.f9314a.put(aVar.b(), aVar);
        }
    }

    public void b(@Nullable ZeusPlugin.Command command, @Nullable W w) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command, w) == null) {
            if (command == null || TextUtils.isEmpty(command.what)) {
                boolean z = f9313b;
            } else if (w == null) {
                boolean z2 = f9313b;
            } else {
                a<W> aVar = this.f9314a.get(command.what);
                if (aVar == null) {
                    if (f9313b) {
                        String str = command.what + " command is not supported, haven't dispatched";
                        return;
                    }
                    return;
                }
                if (f9313b) {
                    String str2 = command.what + " command dispatched";
                }
                aVar.a(command, w);
            }
        }
    }

    public void c(@Nullable ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                a<W> aVar = this.f9314a.get(command.what);
                if (aVar == null) {
                    if (f9313b) {
                        String str = command.what + " command is not supported, haven't mocked";
                        return;
                    }
                    return;
                }
                if (f9313b) {
                    String str2 = command.what + " cached command return value processed";
                }
                aVar.c(command);
                return;
            }
            boolean z = f9313b;
        }
    }
}
