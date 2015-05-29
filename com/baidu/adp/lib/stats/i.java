package com.baidu.adp.lib.stats;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.voice.Amrnb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ f this$0;
    private boolean wF;

    public i(f fVar, boolean z) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        BdAsyncTaskParallel bdAsyncTaskParallel2;
        this.this$0 = fVar;
        this.wF = false;
        this.wF = z;
        bdAsyncTaskParallel = fVar.wD;
        if (bdAsyncTaskParallel == null) {
            fVar.wD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        bdAsyncTaskParallel2 = fVar.wD;
        setParallel(bdAsyncTaskParallel2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public BdStatSwitchData doInBackground(Object... objArr) {
        boolean z;
        String str;
        boolean z2;
        BdStatLog bdStatLog;
        BdDebugLog bdDebugLog;
        BdErrorLog bdErrorLog;
        BdPerformanceLog bdPerformanceLog;
        boolean z3;
        if (!this.wF) {
            z = this.this$0.wu;
            if (!z) {
                this.this$0.hD();
                str = null;
            } else {
                str = this.this$0.hE();
            }
        } else {
            this.this$0.hD();
            z3 = this.this$0.wu;
            str = z3 ? this.this$0.hE() : null;
            this.this$0.hB();
        }
        z2 = this.this$0.wu;
        if (z2) {
            bdStatLog = this.this$0.wv;
            bdStatLog.clearLogResource();
            bdDebugLog = this.this$0.ww;
            bdDebugLog.clearLogResource();
            bdErrorLog = this.this$0.wx;
            bdErrorLog.clearLogResource();
            bdPerformanceLog = this.this$0.wy;
            bdPerformanceLog.clearLogResource();
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
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        boolean z;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bdStatSwitchData);
        this.this$0.a(bdStatSwitchData);
        z = this.this$0.wu;
        if (z) {
            this.this$0.sendMultiProcessBroadcast();
        }
        handler = this.this$0.mHandler;
        handler2 = this.this$0.mHandler;
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
