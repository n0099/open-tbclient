package com.baidu.share;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShareAssistant {

    /* renamed from: a  reason: collision with root package name */
    private static ShareAssistant f816a = null;
    private d b = new d();
    private b c;

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
            if (f816a == null) {
                f816a = new ShareAssistant(context);
            }
            shareAssistant = f816a;
        }
        return shareAssistant;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        this.b.a(shareModel);
    }

    public void destroy() {
        if (this.b != null) {
            this.b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
        try {
            Crypto.a();
        } catch (Throwable th) {
        }
        f816a = null;
    }

    public boolean registListener(IShareListener iShareListener) {
        return this.b.a(iShareListener);
    }

    public boolean share(ShareModel shareModel) {
        return this.c.a(shareModel);
    }

    public boolean share(ShareModel shareModel, ArrayList arrayList) {
        return this.c.a(shareModel, arrayList);
    }

    public boolean unRegistListener(IShareListener iShareListener) {
        return this.b.b(iShareListener);
    }
}
