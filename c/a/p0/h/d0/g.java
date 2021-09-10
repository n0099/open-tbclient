package c.a.p0.h.d0;

import androidx.annotation.NonNull;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f11150c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f11151d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f11152a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11153b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1562095737, "Lc/a/p0/h/d0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1562095737, "Lc/a/p0/h/d0/g;");
                return;
            }
        }
        f11150c = k.f7077a;
        f11151d = null;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11151d == null) {
                synchronized (g.class) {
                    if (f11151d == null) {
                        f11151d = new g();
                    }
                }
            }
            return f11151d;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public GameRecorderController b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f11150c) {
                String str = "getRecorderController:" + this.f11152a;
            }
            GameRecorderController gameRecorderController = this.f11152a;
            return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
        }
        return (GameRecorderController) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f11150c) {
                String str = "isGamePause:" + this.f11153b;
            }
            return this.f11153b;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11153b = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f11153b = false;
        }
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gameRecorderController) == null) && (gameRecorderController2 = this.f11152a) != null && gameRecorderController2 == gameRecorderController) {
            gameRecorderController2.p();
            this.f11152a = null;
        }
    }

    public void g(GameRecorderController gameRecorderController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gameRecorderController) == null) {
            GameRecorderController gameRecorderController2 = this.f11152a;
            if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
                gameRecorderController2.p();
            }
            this.f11152a = gameRecorderController;
        }
    }
}
