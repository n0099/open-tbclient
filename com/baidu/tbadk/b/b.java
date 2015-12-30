package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> SH = null;
    protected static boolean SJ = false;
    protected String SF = "183322726";
    protected boolean SI = true;
    protected transient List<String> SG = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void b(boolean z, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aN(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qa();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qb();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qc();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void qe();

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
        if (SH == null) {
            SH = new WeakReference<>(tbPageContext);
            return;
        }
        SH.clear();
        SH = null;
        SH = new WeakReference<>(tbPageContext);
    }

    public boolean pZ() {
        return SJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(boolean z) {
        this.SI = z;
    }

    public boolean pT() {
        return this.SI;
    }

    public void pV() {
        if (SH != null) {
            SH.get();
            SH.clear();
            SH = null;
        }
    }
}
