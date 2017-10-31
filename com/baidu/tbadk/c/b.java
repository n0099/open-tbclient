package com.baidu.tbadk.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Rk = null;
    protected static boolean Rm = false;
    protected String Rh = "183322726";
    protected boolean Rl = true;
    protected transient List<String> Ri = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ae aeVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ba(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nS();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nT();

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
        if (Rk == null) {
            Rk = new WeakReference<>(tbPageContext);
            return;
        }
        Rk.clear();
        Rk = null;
        Rk = new WeakReference<>(tbPageContext);
    }

    public boolean nO() {
        return Rm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(boolean z) {
        this.Rl = z;
    }

    public boolean nI() {
        return this.Rl;
    }

    public void nK() {
        if (Rk != null) {
            Rk.get();
            Rk.clear();
            Rk = null;
        }
    }
}
