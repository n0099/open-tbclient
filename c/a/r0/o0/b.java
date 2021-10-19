package c.a.r0.o0;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext<?> tbPageContext, String str) {
        ForumSquareActivityConfig forumSquareActivityConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, str) == null) || tbPageContext == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity(), str);
        } else {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
        }
        tbPageContext.sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
    }
}
