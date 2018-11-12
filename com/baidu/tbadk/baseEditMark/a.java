package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: com.baidu.tbadk.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0144a {
        void a(boolean z, boolean z2, String str);
    }

    public abstract void a(MarkData markData);

    public abstract void a(InterfaceC0144a interfaceC0144a);

    public abstract void aO(boolean z);

    public abstract String vl();

    public abstract boolean vm();

    public abstract void vn();

    public abstract void vo();

    public abstract MarkData vp();

    public static a a(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921318, a.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }
}
