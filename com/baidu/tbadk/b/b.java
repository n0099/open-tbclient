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
    protected static WeakReference<TbPageContext<?>> aGw = null;
    protected static boolean aGy = false;
    protected String aGu = "183322726";
    protected boolean aGx = true;
    protected transient List<String> aGv = new ArrayList(5);

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
    public void a(TbPageContext<?> tbPageContext) {
        if (aGw == null) {
            aGw = new WeakReference<>(tbPageContext);
            return;
        }
        aGw.clear();
        aGw = null;
        aGw = new WeakReference<>(tbPageContext);
    }

    public boolean vw() {
        return aGy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJ(boolean z) {
        this.aGx = z;
    }

    public void vs() {
        if (aGw != null) {
            aGw.get();
            aGw.clear();
            aGw = null;
        }
    }
}
