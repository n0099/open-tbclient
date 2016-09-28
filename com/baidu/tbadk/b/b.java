package com.baidu.tbadk.b;

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
    protected static WeakReference<TbPageContext<?>> Mw = null;
    protected static boolean My = false;
    protected String Mt = "183322726";
    protected boolean Mx = true;
    protected transient List<String> Mu = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ae aeVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bc(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nM();

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
        if (Mw == null) {
            Mw = new WeakReference<>(tbPageContext);
            return;
        }
        Mw.clear();
        Mw = null;
        Mw = new WeakReference<>(tbPageContext);
    }

    public boolean nH() {
        return My;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.Mx = z;
    }

    public boolean nB() {
        return this.Mx;
    }

    public void nD() {
        if (Mw != null) {
            Mw.get();
            Mw.clear();
            Mw = null;
        }
    }
}
