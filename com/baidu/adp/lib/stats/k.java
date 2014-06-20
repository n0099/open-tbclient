package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.voice.Amrnb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ h a;
    private boolean b;

    public k(h hVar, boolean z) {
        this.a = hVar;
        this.b = false;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String j;
        String j2;
        if (this.b) {
            this.a.i();
            j2 = this.a.j();
            this.a.h();
            return j2;
        }
        j = this.a.j();
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        Handler handler;
        Handler handler2;
        super.onPostExecute(str);
        this.a.b(str);
        handler = this.a.w;
        handler2 = this.a.w;
        handler.sendMessageDelayed(handler2.obtainMessage(2), 10000L);
        try {
            Class.forName(Amrnb.class.getName());
        } catch (Exception e) {
        }
        try {
            Class.forName(NSGif.class.getName());
        } catch (Exception e2) {
        }
    }
}
