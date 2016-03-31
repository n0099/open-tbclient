package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Pv = null;
    protected static boolean Px = false;
    protected String Ps = "183322726";
    protected boolean Pw = true;
    protected transient List<String> Pt = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, w wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aX(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pK();

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
        if (Pv == null) {
            Pv = new WeakReference<>(tbPageContext);
            return;
        }
        Pv.clear();
        Pv = null;
        Pv = new WeakReference<>(tbPageContext);
    }

    public boolean pG() {
        return Px;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(boolean z) {
        this.Pw = z;
    }

    public boolean pA() {
        return this.Pw;
    }

    public void pC() {
        if (Pv != null) {
            Pv.get();
            Pv.clear();
            Pv = null;
        }
    }
}
