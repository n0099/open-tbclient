package c.a.p0.b1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f12926a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f12927b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f12928c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12929d = "floor";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1705478017, "Lc/a/p0/b1/s;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1705478017, "Lc/a/p0/b1/s;");
        }
    }

    public static void a(String str, String str2, String str3, int i2, c.a.e.a.f fVar, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, Integer.valueOf(i2), fVar, baijiahaoData}) == null) {
            f12927b = str;
            f12928c = str2;
            f12926a = str3;
            if (StringUtils.isNull(str3) || fVar == null || fVar.getPageActivity() == null) {
                return;
            }
            if (f12929d.equals(f12926a)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(fVar.getPageActivity()).createSubPbActivityConfig(f12927b, f12928c, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                createSubPbActivityConfig.setBjhData(baijiahaoData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(fVar.getPageActivity()).createNormalCfg(f12927b, f12928c, "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setBjhData(baijiahaoData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
