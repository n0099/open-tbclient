package com.baidu.adp.framework.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SocketMessageTask extends MessageTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36027a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36028b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36029c;

    /* renamed from: d  reason: collision with root package name */
    public Class<? extends SocketResponsedMessage> f36030d;

    /* renamed from: e  reason: collision with root package name */
    public DupLicateMode f36031e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class DupLicateMode {
        public static final /* synthetic */ DupLicateMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DupLicateMode NONE;
        public static final DupLicateMode REMOVE_ALL;
        public static final DupLicateMode REMOVE_ME;
        public static final DupLicateMode REMOVE_WAITING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(172233953, "Lcom/baidu/adp/framework/task/SocketMessageTask$DupLicateMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(172233953, "Lcom/baidu/adp/framework/task/SocketMessageTask$DupLicateMode;");
                    return;
                }
            }
            NONE = new DupLicateMode("NONE", 0);
            REMOVE_ME = new DupLicateMode("REMOVE_ME", 1);
            REMOVE_WAITING = new DupLicateMode("REMOVE_WAITING", 2);
            DupLicateMode dupLicateMode = new DupLicateMode("REMOVE_ALL", 3);
            REMOVE_ALL = dupLicateMode;
            $VALUES = new DupLicateMode[]{NONE, REMOVE_ME, REMOVE_WAITING, dupLicateMode};
        }

        public DupLicateMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DupLicateMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DupLicateMode) Enum.valueOf(DupLicateMode.class, str) : (DupLicateMode) invokeL.objValue;
        }

        public static DupLicateMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DupLicateMode[]) $VALUES.clone() : (DupLicateMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketMessageTask(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
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
        this.f36027a = false;
        this.f36028b = false;
        this.f36029c = true;
        this.f36031e = DupLicateMode.NONE;
    }

    public DupLicateMode a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36031e : (DupLicateMode) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36027a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36028b : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? FrameHelper.c(this.mCmd) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36029c : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f36029c = z;
        }
    }

    public void f(DupLicateMode dupLicateMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dupLicateMode) == null) {
            this.f36031e = dupLicateMode;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f36027a = z;
        }
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36030d : (Class) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f36028b = z;
        }
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cls) == null) {
            this.f36030d = cls;
        }
    }
}
