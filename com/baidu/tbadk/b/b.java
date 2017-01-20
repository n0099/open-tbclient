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
    protected static WeakReference<TbPageContext<?>> LK = null;
    protected static boolean LM = false;
    protected String LH = "183322726";
    protected boolean LL = true;
    protected transient List<String> LI = new ArrayList(5);

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
    public abstract void nA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nK();

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
        if (LK == null) {
            LK = new WeakReference<>(tbPageContext);
            return;
        }
        LK.clear();
        LK = null;
        LK = new WeakReference<>(tbPageContext);
    }

    public boolean nF() {
        return LM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.LL = z;
    }

    public boolean nz() {
        return this.LL;
    }

    public void nB() {
        if (LK != null) {
            LK.get();
            LK.clear();
            LK = null;
        }
    }
}
