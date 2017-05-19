package com.baidu.tbadk.c;

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
    protected static WeakReference<TbPageContext<?>> Qy = null;
    protected static boolean QA = false;
    protected String Qv = "183322726";
    protected boolean Qz = true;
    protected transient List<String> Qw = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ag agVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aW(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nS();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oa();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ob();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oc();

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
        if (Qy == null) {
            Qy = new WeakReference<>(tbPageContext);
            return;
        }
        Qy.clear();
        Qy = null;
        Qy = new WeakReference<>(tbPageContext);
    }

    public boolean nX() {
        return QA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.Qz = z;
    }

    public boolean nR() {
        return this.Qz;
    }

    public void nT() {
        if (Qy != null) {
            Qy.get();
            Qy.clear();
            Qy = null;
        }
    }
}
