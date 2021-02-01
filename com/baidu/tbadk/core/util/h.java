package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    public static boolean a(com.baidu.tbadk.core.data.ar arVar) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            b(arVar);
        }
        return isLogin;
    }

    private static void b(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921530, arVar));
        }
    }

    public static void dN(String str, String str2) {
        ar arVar = new ar("c14059");
        arVar.dR("obj_locate", str);
        arVar.dR("obj_type", str2);
        TiebaStatic.log(arVar);
    }

    public static void ao(String str, String str2, String str3) {
        ar arVar = new ar("c14560");
        arVar.dR("obj_locate", str);
        arVar.dR("obj_type", str2);
        arVar.dR("obj_source", str3);
        TiebaStatic.log(arVar);
    }
}
