package com.baidu.share;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShareAssistant {
    private static ShareAssistant a = null;
    private a b = new a();
    private b c;

    static {
        System.loadLibrary("share");
    }

    private ShareAssistant(Context context) {
        this.c = null;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.c = new b(context);
    }

    public static synchronized ShareAssistant a(Context context) {
        ShareAssistant shareAssistant;
        synchronized (ShareAssistant.class) {
            if (a == null) {
                a = new ShareAssistant(context);
            }
            shareAssistant = a;
        }
        return shareAssistant;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ShareModel shareModel) {
        a aVar = this.b;
        if (shareModel == null || aVar.a == null) {
            return;
        }
        synchronized (aVar.a) {
            int size = aVar.a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) aVar.a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    public void destroy() {
        if (this.b != null) {
            a aVar = this.b;
            synchronized (aVar.a) {
                aVar.a.clear();
            }
        }
        if (this.c != null) {
            this.c.a = null;
        }
        Crypto.a();
        a = null;
    }

    public boolean registListener(IShareListener iShareListener) {
        return this.b.a(iShareListener);
    }

    public boolean share(ShareModel shareModel) {
        return this.c.a(shareModel, null);
    }

    public boolean share(ShareModel shareModel, ArrayList arrayList) {
        return this.c.a(shareModel, arrayList);
    }

    public boolean unRegistListener(IShareListener iShareListener) {
        return this.b.b(iShareListener);
    }
}
