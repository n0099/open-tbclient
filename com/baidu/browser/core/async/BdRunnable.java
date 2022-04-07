package com.baidu.browser.core.async;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.repackage.ay;
import com.repackage.zx;
/* loaded from: classes.dex */
public abstract class BdRunnable implements Runnable, ay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ay a;
    public STATUS b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class STATUS {
        public static final /* synthetic */ STATUS[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final STATUS COMPLETE;
        public static final STATUS FAIL;
        public static final STATUS INITED;
        public static final STATUS QUEUED;
        public static final STATUS RUNNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1985849230, "Lcom/baidu/browser/core/async/BdRunnable$STATUS;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1985849230, "Lcom/baidu/browser/core/async/BdRunnable$STATUS;");
                    return;
                }
            }
            INITED = new STATUS("INITED", 0);
            QUEUED = new STATUS("QUEUED", 1);
            RUNNING = new STATUS(TornadoLiteRuntime.STATE_RUNNING, 2);
            FAIL = new STATUS("FAIL", 3);
            STATUS status = new STATUS("COMPLETE", 4);
            COMPLETE = status;
            $VALUES = new STATUS[]{INITED, QUEUED, RUNNING, FAIL, status};
        }

        public STATUS(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static STATUS valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (STATUS) Enum.valueOf(STATUS.class, str) : (STATUS) invokeL.objValue;
        }

        public static STATUS[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (STATUS[]) $VALUES.clone() : (STATUS[]) invokeV.objValue;
        }
    }

    public BdRunnable() {
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
        this.b = STATUS.INITED;
    }

    @Override // com.repackage.ay
    public void a(Error error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
            this.b = STATUS.FAIL;
            ay ayVar = this.a;
            if (ayVar != null) {
                ayVar.a(error);
            }
            zx.f().d();
        }
    }

    public abstract void b();

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            STATUS status = this.b;
            return status == STATUS.COMPLETE || status == STATUS.FAIL;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ay
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = STATUS.COMPLETE;
            ay ayVar = this.a;
            if (ayVar != null) {
                ayVar.onComplete();
            }
            zx.f().d();
        }
    }

    @Override // com.repackage.ay
    public void onException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            this.b = STATUS.FAIL;
            ay ayVar = this.a;
            if (ayVar != null) {
                ayVar.onException(exc);
            }
            zx.f().d();
        }
    }

    @Override // com.repackage.ay
    public void onStart() {
        ay ayVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ayVar = this.a) == null) {
            return;
        }
        ayVar.onStart();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                onStart();
                this.b = STATUS.RUNNING;
                b();
                onComplete();
            } catch (Error e) {
                a(e);
            } catch (Exception e2) {
                onException(e2);
            }
        }
    }
}
