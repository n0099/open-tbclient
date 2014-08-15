package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.voice.Amrnb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ f a;
    private boolean b;

    public i(f fVar, boolean z) {
        this.a = fVar;
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
            z = this.a.v;
            if (!z) {
                this.a.l();
                str = null;
            } else {
                str = this.a.m();
            }
        } else {
            this.a.l();
            z2 = this.a.v;
            str = z2 ? this.a.m() : null;
            this.a.k();
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
        z = this.a.v;
        if (z) {
            this.a.h();
        }
        handler = this.a.z;
        handler2 = this.a.z;
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
