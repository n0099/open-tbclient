package c.a.s0.q3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f21840c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f21841b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-758102345, "Lc/a/s0/q3/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-758102345, "Lc/a/s0/q3/e;");
                return;
            }
        }
        f21840c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    }

    public e() {
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
        this.f21841b = null;
    }

    public void a() {
        NetWork netWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (netWork = this.f21841b) == null) {
            return;
        }
        netWork.cancelNetConnect();
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NetWork netWork = this.f21841b;
            if (netWork != null) {
                return netWork.getErrorString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NetWork netWork = this.f21841b;
            if (netWork != null) {
                return netWork.getNetContext().getResponse().isRequestSuccess();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
        }
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            String id = currentAccountObj != null ? currentAccountObj.getID() : null;
            NetWork netWork = new NetWork(f21840c);
            this.f21841b = netWork;
            netWork.addPostData("user_id", id);
            this.f21841b.addPostData("forum_ids", str);
            this.f21841b.addPostData("authsid", this.a);
            this.f21841b.getNetContext().getRequest().mNeedBackgroundLogin = true;
            this.f21841b.getNetContext().getRequest().mIsNeedTbs = true;
            this.f21841b.setNeedSig(true);
            return this.f21841b.postNetData();
        }
        return (String) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NetWork netWork = new NetWork(f21840c);
            this.f21841b = netWork;
            netWork.addPostData("authsid", this.a);
            this.f21841b.getNetContext().getRequest().mNeedBackgroundLogin = true;
            this.f21841b.getNetContext().getRequest().mIsNeedTbs = true;
            this.f21841b.setNeedSig(true);
            return this.f21841b.postNetData();
        }
        return (String) invokeV.objValue;
    }
}
