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
    protected static WeakReference<TbPageContext<?>> aHF = null;
    protected static boolean aHH = false;
    protected String aHD = "183322726";
    protected boolean aHG = true;
    protected transient List<String> aHE = new ArrayList(5);

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
        if (aHF == null) {
            aHF = new WeakReference<>(tbPageContext);
            return;
        }
        aHF.clear();
        aHF = null;
        aHF = new WeakReference<>(tbPageContext);
    }

    public boolean wi() {
        return aHH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aM(boolean z) {
        this.aHG = z;
    }

    public void we() {
        if (aHF != null) {
            aHF.get();
            aHF.clear();
            aHF = null;
        }
    }
}
