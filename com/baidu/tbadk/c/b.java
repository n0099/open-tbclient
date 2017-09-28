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
    protected static WeakReference<TbPageContext<?>> Rh = null;
    protected static boolean Rj = false;
    protected String Re = "183322726";
    protected boolean Ri = true;
    protected transient List<String> Rf = new ArrayList(5);

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
    public abstract void nN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nT();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nX();

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
        if (Rh == null) {
            Rh = new WeakReference<>(tbPageContext);
            return;
        }
        Rh.clear();
        Rh = null;
        Rh = new WeakReference<>(tbPageContext);
    }

    public boolean nS() {
        return Rj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.Ri = z;
    }

    public boolean nM() {
        return this.Ri;
    }

    public void nO() {
        if (Rh != null) {
            Rh.get();
            Rh.clear();
            Rh = null;
        }
    }
}
