package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void W(boolean z);

    public abstract void a(MarkData markData);

    public abstract void a(b bVar);

    public abstract String oP();

    public abstract boolean oQ();

    public abstract void oR();

    public abstract void oS();

    public abstract MarkData oT();

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
