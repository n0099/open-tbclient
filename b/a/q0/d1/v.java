package b.a.q0.d1;

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
/* loaded from: classes4.dex */
public class v {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f12199a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f12200b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f12201c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12202d = "floor";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-89903266, "Lb/a/q0/d1/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-89903266, "Lb/a/q0/d1/v;");
        }
    }

    public static void a(String str, String str2, String str3, int i2, b.a.e.a.f fVar, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, Integer.valueOf(i2), fVar, baijiahaoData}) == null) {
            f12200b = str;
            f12201c = str2;
            f12199a = str3;
            if (StringUtils.isNull(str3) || fVar == null || fVar.getPageActivity() == null) {
                return;
            }
            if (f12202d.equals(f12199a)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(fVar.getPageActivity()).createSubPbActivityConfig(f12200b, f12201c, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                createSubPbActivityConfig.setBjhData(baijiahaoData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(fVar.getPageActivity()).createNormalCfg(f12200b, f12201c, "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setBjhData(baijiahaoData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
