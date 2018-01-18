package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> aGt = null;
    protected static boolean aGv = false;
    protected String aGr = "183322726";
    protected boolean aGu = true;
    protected transient List<String> aGs = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ea(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vw();

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
    public void a(TbPageContext<?> tbPageContext) {
        if (aGt == null) {
            aGt = new WeakReference<>(tbPageContext);
            return;
        }
        aGt.clear();
        aGt = null;
        aGt = new WeakReference<>(tbPageContext);
    }

    public boolean vv() {
        return aGv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aI(boolean z) {
        this.aGu = z;
    }

    public void vr() {
        if (aGt != null) {
            aGt.get();
            aGt.clear();
            aGt = null;
        }
    }
}
