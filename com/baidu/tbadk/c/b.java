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
    protected static WeakReference<TbPageContext<?>> aba = null;
    protected static boolean abd = false;
    protected String aaY = "183322726";
    protected boolean abb = true;
    protected transient List<String> aaZ = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ba(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void si();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void so();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sr();

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
        if (aba == null) {
            aba = new WeakReference<>(tbPageContext);
            return;
        }
        aba.clear();
        aba = null;
        aba = new WeakReference<>(tbPageContext);
    }

    public boolean sm() {
        return abd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(boolean z) {
        this.abb = z;
    }

    public void sj() {
        if (aba != null) {
            aba.get();
            aba.clear();
            aba = null;
        }
    }
}
