package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tbadk.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0031a {
        void a(boolean z, boolean z2, String str);
    }

    public abstract void a(MarkData markData);

    public abstract void a(InterfaceC0031a interfaceC0031a);

    public abstract void ad(boolean z);

    public abstract String ns();

    public abstract boolean nt();

    public abstract void nu();

    public abstract void nv();

    public abstract MarkData nw();

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MARK_MANAGER, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
