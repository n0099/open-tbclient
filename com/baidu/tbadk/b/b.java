package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Kl = null;
    protected static boolean Kn = false;
    protected String Ki = "183322726";
    protected boolean Km = true;
    protected transient List<String> Kj = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ab abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aP(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mR();

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
        if (Kl == null) {
            Kl = new WeakReference<>(tbPageContext);
            return;
        }
        Kl.clear();
        Kl = null;
        Kl = new WeakReference<>(tbPageContext);
    }

    public boolean mM() {
        return Kn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(boolean z) {
        this.Km = z;
    }

    public boolean mG() {
        return this.Km;
    }

    public void mI() {
        if (Kl != null) {
            Kl.get();
            Kl.clear();
            Kl = null;
        }
    }
}
