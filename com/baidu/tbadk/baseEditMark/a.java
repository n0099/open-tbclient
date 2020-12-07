package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tbadk.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0583a {
        void d(boolean z, boolean z2, String str);
    }

    public abstract void a(MarkData markData);

    public abstract void a(InterfaceC0583a interfaceC0583a);

    public abstract String bkX();

    public abstract boolean bkY();

    public abstract void bkZ();

    public abstract void bla();

    public abstract MarkData blb();

    public abstract void iH(boolean z);

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MARK_MANAGER, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MARK_MANAGER_1, a.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
