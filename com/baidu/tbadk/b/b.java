package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> aHP = null;
    protected static boolean aHR = false;
    protected String aHN = "183322726";
    protected boolean aHQ = true;
    protected transient List<String> aHO = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ea(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wn();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContext(TbPageContext<?> tbPageContext) {
        if (aHP == null) {
            aHP = new WeakReference<>(tbPageContext);
            return;
        }
        aHP.clear();
        aHP = null;
        aHP = new WeakReference<>(tbPageContext);
    }

    public boolean wi() {
        return aHR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aM(boolean z) {
        this.aHQ = z;
    }

    public void we() {
        if (aHP != null) {
            aHP.get();
            aHP.clear();
            aHP = null;
        }
    }
}
