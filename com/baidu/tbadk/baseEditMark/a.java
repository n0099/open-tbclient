package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tbadk.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a {
        void a(boolean z, boolean z2, String str);
    }

    public abstract void a(MarkData markData);

    public abstract void a(InterfaceC0042a interfaceC0042a);

    public abstract void ac(boolean z);

    public abstract String nF();

    public abstract boolean nG();

    public abstract void nH();

    public abstract void nI();

    public abstract MarkData nJ();

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MARK_MANAGER, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
