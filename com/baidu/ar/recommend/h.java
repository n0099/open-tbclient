package com.baidu.ar.recommend;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.ar.bean.ARResource;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private Context a;
    private i b;
    private ARResource c;
    private a d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<ARResource> list);
    }

    public h(Context context) {
        this.a = context;
    }

    public void a() {
        this.b = new i(this.a, this.c, this.d);
        this.b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a(ARResource aRResource) {
        this.c = aRResource;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void b() {
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
        this.d = null;
    }
}
