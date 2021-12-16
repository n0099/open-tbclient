package c.a.s0.l2.c;

import android.content.Context;
import c.a.s0.l2.b.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, dVar) == null) || dVar == null) {
            return;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        long parseLong = Long.parseLong(dVar.f19136e);
        String str = dVar.f19137f;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(context, parseLong, str, str, dVar.f19138g, dVar.f19139h, dVar.n ? 1 : 0)));
    }
}
