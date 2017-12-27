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
    protected static WeakReference<TbPageContext<?>> aGv = null;
    protected static boolean aGx = false;
    protected String aGs = "183322726";
    protected boolean aGw = true;
    protected transient List<String> aGt = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ab abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void eb(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vr();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vx();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vz();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
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
        if (aGv == null) {
            aGv = new WeakReference<>(tbPageContext);
            return;
        }
        aGv.clear();
        aGv = null;
        aGv = new WeakReference<>(tbPageContext);
    }

    public boolean vw() {
        return aGx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aI(boolean z) {
        this.aGw = z;
    }

    public boolean vq() {
        return this.aGw;
    }

    public void vs() {
        if (aGv != null) {
            aGv.get();
            aGv.clear();
            aGv = null;
        }
    }
}
