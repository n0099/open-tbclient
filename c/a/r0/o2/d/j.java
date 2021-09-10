package c.a.r0.o2.d;

import c.a.e.l.e.n;
import c.a.q0.u.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = list.get(i2);
            if (nVar instanceof m) {
                m mVar = (m) nVar;
                if (!mVar.d()) {
                    jSONArray.put(mVar.b());
                }
            }
        }
        jSONArray.put(str);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
        httpMessage.addParam("pic_list", jSONArray.toString());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void b(m mVar, List<n> list) {
        m mVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, mVar, list) == null) || mVar == null || ListUtils.isEmpty(list) || StringUtils.isNull(mVar.b())) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = list.get(i2);
            if ((nVar instanceof m) && (mVar2 = (m) nVar) != mVar && !mVar2.d()) {
                jSONArray.put(mVar2.b());
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
        httpMessage.addParam("pic_list", jSONArray.toString());
        if (jSONArray.length() <= 0) {
            httpMessage.addParam("truncat", 1);
        } else {
            httpMessage.addParam("truncat", 0);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static String c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || StringUtils.isNull(str)) {
                return null;
            }
            if (tbPageContext.getResources().getDisplayMetrics().densityDpi > 240.0f) {
                return "http://tb.himg.baidu.com/sys/portraith/item/" + str;
            }
            return "http://tb.himg.baidu.com/sys/portraitl/item/" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static void d(m mVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, mVar, bdUniqueId) == null) || mVar == null || StringUtils.isNull(mVar.b()) || !ListUtils.isEmpty(MessageManager.getInstance().findMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT, bdUniqueId))) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        httpMessage.addParam("pic_url", mVar.b());
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
