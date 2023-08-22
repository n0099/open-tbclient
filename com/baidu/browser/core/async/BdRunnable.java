package com.baidu.browser.core.async;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fw;
import com.baidu.tieba.gw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class BdRunnable implements Runnable, gw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gw a;
    public STATUS b;

    public abstract void c();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            RUNNING = new STATUS("RUNNING", 2);
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (STATUS) Enum.valueOf(STATUS.class, str);
            }
            return (STATUS) invokeL.objValue;
        }

        public static STATUS[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (STATUS[]) $VALUES.clone();
            }
            return (STATUS[]) invokeV.objValue;
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

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            STATUS status = this.b;
            if (status != STATUS.COMPLETE && status != STATUS.FAIL) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gw
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = STATUS.COMPLETE;
            gw gwVar = this.a;
            if (gwVar != null) {
                gwVar.onComplete();
            }
            fw.f().d();
        }
    }

    @Override // com.baidu.tieba.gw
    public void onStart() {
        gw gwVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gwVar = this.a) != null) {
            gwVar.onStart();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                onStart();
                this.b = STATUS.RUNNING;
                c();
                onComplete();
            } catch (Error e) {
                b(e);
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    @Override // com.baidu.tieba.gw
    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            this.b = STATUS.FAIL;
            gw gwVar = this.a;
            if (gwVar != null) {
                gwVar.a(exc);
            }
            fw.f().d();
        }
    }

    @Override // com.baidu.tieba.gw
    public void b(Error error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, error) == null) {
            this.b = STATUS.FAIL;
            gw gwVar = this.a;
            if (gwVar != null) {
                gwVar.b(error);
            }
            fw.f().d();
        }
    }
}
