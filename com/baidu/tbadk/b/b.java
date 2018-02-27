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
    protected static WeakReference<TbPageContext<?>> aHE = null;
    protected static boolean aHG = false;
    protected String aHC = "183322726";
    protected boolean aHF = true;
    protected transient List<String> aHD = new ArrayList(5);

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
        if (aHE == null) {
            aHE = new WeakReference<>(tbPageContext);
            return;
        }
        aHE.clear();
        aHE = null;
        aHE = new WeakReference<>(tbPageContext);
    }

    public boolean wi() {
        return aHG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aM(boolean z) {
        this.aHF = z;
    }

    public void we() {
        if (aHE != null) {
            aHE.get();
            aHE.clear();
            aHE = null;
        }
    }
}
