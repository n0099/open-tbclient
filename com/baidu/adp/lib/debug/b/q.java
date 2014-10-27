package com.baidu.adp.lib.debug.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
class q extends Handler {
    final /* synthetic */ m hO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.hO = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.hO.hE.setText("fps:" + com.baidu.adp.lib.debug.d.cA());
                    break;
                case 1:
                    this.hO.hF.setText("mem:" + com.baidu.adp.lib.debug.d.cB());
                    break;
                case 2:
                    this.hO.hG.setText("cpu:" + com.baidu.adp.lib.debug.d.cC());
                    break;
                case 3:
                    this.hO.hH.setText("gc:" + com.baidu.adp.lib.debug.d.cD());
                    break;
                case 4:
                    this.hO.hI.setText("strictMode:" + com.baidu.adp.lib.debug.d.cE());
                    break;
                case 5:
                    Log.i("Monitor", "battery run");
                    this.hO.hJ.setText("battery:" + com.baidu.adp.lib.debug.d.cI());
                    break;
                case 6:
                    this.hO.hM.setText("-T:" + com.baidu.adp.lib.debug.d.cF().cP() + "kb");
                    this.hO.hK.setText("-S:" + com.baidu.adp.lib.debug.d.cF().cR() + "kb");
                    this.hO.hL.setText("-R:" + com.baidu.adp.lib.debug.d.cF().cQ() + "kb");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
