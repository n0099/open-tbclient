package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Sa = null;
    protected static boolean Sc = false;
    protected String RX = "183322726";
    protected boolean Sb = true;
    protected transient List<String> RY = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, q qVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aY(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qt();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qw();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void resetValues();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b b(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOTOLIVE_MANAGER_FRAGMENTACTIVITY, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOTOLIVE_MANAGER_ACTIVITY, b.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbPageContext<?> tbPageContext) {
        if (Sa == null) {
            Sa = new WeakReference<>(tbPageContext);
            return;
        }
        Sa.clear();
        Sa = null;
        Sa = new WeakReference<>(tbPageContext);
    }

    public boolean qs() {
        return Sc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(boolean z) {
        this.Sb = z;
    }

    public boolean qm() {
        return this.Sb;
    }

    public void qo() {
        if (Sa != null) {
            Sa.get();
            Sa.clear();
            Sa = null;
        }
    }
}
