package com.baidu.tbadk.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> SX = null;
    protected static boolean SZ = false;
    protected String SV = "183322726";
    protected boolean SY = true;
    protected transient List<String> SW = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aY(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oT();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oX();

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
        if (SX == null) {
            SX = new WeakReference<>(tbPageContext);
            return;
        }
        SX.clear();
        SX = null;
        SX = new WeakReference<>(tbPageContext);
    }

    public boolean oS() {
        return SZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af(boolean z) {
        this.SY = z;
    }

    public void oP() {
        if (SX != null) {
            SX.get();
            SX.clear();
            SX = null;
        }
    }
}
