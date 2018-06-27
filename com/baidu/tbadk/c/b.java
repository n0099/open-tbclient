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
    protected static WeakReference<TbPageContext<?>> abe = null;
    protected static boolean abg = false;
    protected String abb = "183322726";
    protected boolean abf = true;
    protected transient List<String> abd = new ArrayList(5);

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
        if (abe == null) {
            abe = new WeakReference<>(tbPageContext);
            return;
        }
        abe.clear();
        abe = null;
        abe = new WeakReference<>(tbPageContext);
    }

    public boolean sm() {
        return abg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(boolean z) {
        this.abf = z;
    }

    public void sj() {
        if (abe != null) {
            abe.get();
            abe.clear();
            abe = null;
        }
    }
}
