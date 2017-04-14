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
    protected static WeakReference<TbPageContext<?>> Rf = null;
    protected static boolean Rh = false;
    protected String Rc = "183322726";
    protected boolean Rg = true;
    protected transient List<String> Rd = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ag agVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aZ(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ol();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void or();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void os();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ot();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ou();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ov();

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
        if (Rf == null) {
            Rf = new WeakReference<>(tbPageContext);
            return;
        }
        Rf.clear();
        Rf = null;
        Rf = new WeakReference<>(tbPageContext);
    }

    public boolean oq() {
        return Rh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af(boolean z) {
        this.Rg = z;
    }

    public boolean ok() {
        return this.Rg;
    }

    public void om() {
        if (Rf != null) {
            Rf.get();
            Rf.clear();
            Rf = null;
        }
    }
}
