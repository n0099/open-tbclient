package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void Z(boolean z);

    public abstract void a(MarkData markData);

    public abstract void a(b bVar);

    public abstract String pp();

    public abstract boolean pq();

    public abstract void pr();

    public abstract void ps();

    public abstract MarkData pt();

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
