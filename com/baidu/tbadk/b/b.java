package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> QM = null;
    protected static boolean QO = false;
    protected String QJ = "183322726";
    protected boolean QN = true;
    protected transient List<String> QK = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ah ahVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aW(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nY();

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
        if (QM == null) {
            QM = new WeakReference<>(tbPageContext);
            return;
        }
        QM.clear();
        QM = null;
        QM = new WeakReference<>(tbPageContext);
    }

    public boolean nT() {
        return QO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ad(boolean z) {
        this.QN = z;
    }

    public boolean nN() {
        return this.QN;
    }

    public void nP() {
        if (QM != null) {
            QM.get();
            QM.clear();
            QM = null;
        }
    }
}
