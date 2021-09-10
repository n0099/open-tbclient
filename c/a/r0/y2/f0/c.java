package c.a.r0.y2.f0;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public INetWorkCore f29349a;

    /* renamed from: b  reason: collision with root package name */
    public HttpNetContext f29350b;

    public c() {
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
        this.f29349a = null;
        this.f29350b = null;
        d();
    }

    public boolean a(String str, Handler handler, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, handler, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? b(str, handler, i2, i3, i4, false) : invokeCommon.booleanValue;
    }

    public boolean b(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, handler, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            c().getRequest().addBdussData(this.f29349a);
            return this.f29349a.downloadFile(str, handler, i2, i3, i4, z);
        }
        return invokeCommon.booleanValue;
    }

    public HttpNetContext c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29350b : (HttpNetContext) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29350b = new HttpNetContext();
            this.f29349a = new d(this.f29350b);
            this.f29350b.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
            c.a.e.e.j.b.a.o(TbadkCoreApplication.getInst().getCuid());
            c.a.e.e.j.b.a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
            c.a.e.e.j.b.a.r(TbadkCoreApplication.getInst().getCuidGid());
        }
    }

    public void e() {
        INetWorkCore iNetWorkCore;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iNetWorkCore = this.f29349a) == null) {
            return;
        }
        iNetWorkCore.setCancel();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f29350b.getRequest().getNetWorkParam().mUrl = str;
        }
    }
}
