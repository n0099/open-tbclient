package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> RT = null;
    protected static boolean RV = false;
    protected String RQ = "183322726";
    protected boolean RU = true;
    protected transient List<String> RR = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, aa aaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bb(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oa();

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
        if (RT == null) {
            RT = new WeakReference<>(tbPageContext);
            return;
        }
        RT.clear();
        RT = null;
        RT = new WeakReference<>(tbPageContext);
    }

    public boolean nV() {
        return RV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(boolean z) {
        this.RU = z;
    }

    public boolean nP() {
        return this.RU;
    }

    public void nR() {
        if (RT != null) {
            RT.get();
            RT.clear();
            RT = null;
        }
    }
}
