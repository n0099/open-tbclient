package com.baidu.tbadk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Km = null;
    protected static boolean Ko = false;
    protected String Kj = "183322726";
    protected boolean Kn = true;
    protected transient List<String> Kk = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, w wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aM(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nc();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ne();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ng();

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
        if (Km == null) {
            Km = new WeakReference<>(tbPageContext);
            return;
        }
        Km.clear();
        Km = null;
        Km = new WeakReference<>(tbPageContext);
    }

    public boolean nb() {
        return Ko;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab(boolean z) {
        this.Kn = z;
    }

    public boolean mV() {
        return this.Kn;
    }

    public void mX() {
        if (Km != null) {
            Km.get();
            Km.clear();
            Km = null;
        }
    }
}
