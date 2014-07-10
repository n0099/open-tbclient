package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.voice.Amrnb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ d a;
    private boolean b;

    public g(d dVar, boolean z) {
        this.a = dVar;
        this.b = false;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public BdStatSwitchData doInBackground(Object... objArr) {
        boolean z;
        String str;
        boolean z2;
        if (!this.b) {
            z = this.a.u;
            if (!z) {
                this.a.k();
                str = null;
            } else {
                str = this.a.l();
            }
        } else {
            this.a.k();
            z2 = this.a.u;
            str = z2 ? this.a.l() : null;
            this.a.j();
        }
        if (str != null) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            return bdStatSwitchData;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        boolean z;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bdStatSwitchData);
        this.a.a(bdStatSwitchData);
        z = this.a.u;
        if (z) {
            this.a.h();
        }
        handler = this.a.y;
        handler2 = this.a.y;
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
