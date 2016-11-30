package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Mz = null;
    protected static boolean MB = false;
    protected String Mw = "183322726";
    protected boolean MA = true;
    protected transient List<String> Mx = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ag agVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bc(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nM();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nQ();

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
        if (Mz == null) {
            Mz = new WeakReference<>(tbPageContext);
            return;
        }
        Mz.clear();
        Mz = null;
        Mz = new WeakReference<>(tbPageContext);
    }

    public boolean nL() {
        return MB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.MA = z;
    }

    public boolean nF() {
        return this.MA;
    }

    public void nH() {
        if (Mz != null) {
            Mz.get();
            Mz.clear();
            Mz = null;
        }
    }
}
