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
    public interface InterfaceC0530a {
        void c(boolean z, boolean z2, String str);
    }

    public abstract void a(MarkData markData);

    public abstract void a(InterfaceC0530a interfaceC0530a);

    public abstract String bbt();

    public abstract boolean bbu();

    public abstract void bbv();

    public abstract void bbw();

    public abstract MarkData bbx();

    public abstract void hy(boolean z);

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
