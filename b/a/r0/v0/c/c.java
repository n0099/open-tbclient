package b.a.r0.v0.c;

import b.a.e.e.d.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.e.d.l<byte[]> f24264a;

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
        b();
    }

    public byte[] a(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String str2 = str + "/" + TbadkCoreApplication.getCurrentAccount();
            b.a.e.e.d.l<byte[]> lVar = this.f24264a;
            l.b<byte[]> h2 = lVar != null ? lVar.h(str2) : null;
            if (h2 == null || (bArr = h2.f1705b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f24264a == null) {
            b.a.q0.s.r.a.f();
            this.f24264a = b.a.q0.s.r.a.d("tb.forum_member_info");
        }
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(str)) {
                return;
            }
            b();
            b.a.e.e.d.l<byte[]> lVar = this.f24264a;
            lVar.e(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
