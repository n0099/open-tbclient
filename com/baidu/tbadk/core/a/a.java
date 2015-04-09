package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a OE = null;

    public abstract void a(String str, String str2, String str3, b bVar);

    public abstract c bN(String str);

    public abstract AccountData h(String str, String str2, String str3);

    public abstract void p(Activity activity);

    public static a pD() {
        return OE;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (OE == null && (runTask = MessageManager.getInstance().runTask(2001300, a.class)) != null && runTask.getData() != null) {
            OE = (a) runTask.getData();
        }
    }
}
