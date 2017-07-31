package com.baidu.adp.lib.stats.switchs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.g;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.gR().aA(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private static volatile a zc;
    private Context mContext;
    private boolean mIsMainProcess;
    private b zb;
    private boolean yZ = false;
    private String za = null;
    private BdStatSwitchData zd = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b ze = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0007a zf = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0007a {
        void gd();
    }

    public static a gJ() {
        if (zc == null) {
            synchronized (a.class) {
                if (zc == null) {
                    zc = new a();
                }
            }
        }
        return zc;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0007a interfaceC0007a) {
        this.mIsMainProcess = z;
        this.za = str;
        this.mContext = context;
        try {
            if (this.zb == null && this.mContext != null) {
                this.zb = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.zb, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.zf = interfaceC0007a;
        gK();
    }

    public void gK() {
        c cVar = new c();
        cVar.setPriority(4);
        cVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.ze.gN()) {
                bdStatSwitchData.parserJson(a.this.ze.zh);
            }
            a.this.yZ = false;
            if (a.this.mIsMainProcess && a.this.aw(a.this.ze.zh)) {
                String gL = a.this.gL();
                if (!TextUtils.isEmpty(gL) && !gL.equals(a.this.ze.zh)) {
                    a.this.yZ = true;
                    bdStatSwitchData.parserJson(gL);
                    a.this.ze.ay(gL);
                }
            }
            return bdStatSwitchData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            if (bdStatSwitchData != null) {
                a.this.zd = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.yZ) {
                    a.this.gM();
                    g.gR().gU();
                }
                if (a.this.zf != null) {
                    a.this.zf.gd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aw(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.ze.zg >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gL() {
        if (TextUtils.isEmpty(this.za)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.za, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.xv, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM() {
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.updatecmd");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.background".equals(action)) {
                    BdStatisticsManager.getInstance().save();
                    if (a.this.mIsMainProcess) {
                        g.gR().gY();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.gK();
                        g.gR().gU();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.zd.putTmpSwitchConfData(str, bdUploadStatMsgData);
                            a.this.b(bdUploadStatMsgData);
                        }
                    }
                }
            }
        }
    }

    public boolean isWrite(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.zd.isWrite(com.baidu.adp.lib.stats.base.a.av(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.zd.isUpload(com.baidu.adp.lib.stats.base.a.av(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.zd.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.av(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.zd.isExactWriteFile(com.baidu.adp.lib.stats.base.a.av(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.zd.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.zd.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.zd.smallFlowUpload(com.baidu.adp.lib.stats.base.a.av(str), str2);
    }

    public ArrayList<String> ax(String str) {
        return this.zd.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.zd.getTmpSwitchConfData(str) == null) {
            this.zd.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.zd.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.zd.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdUploadStatMsgData bdUploadStatMsgData) {
        long currentTimeMillis = bdUploadStatMsgData.deadLineTime - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            if (currentTimeMillis - 3000 > 0) {
                currentTimeMillis -= 3000;
            }
            Message obtainMessage = mHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = bdUploadStatMsgData;
            mHandler.removeMessages(1);
            mHandler.sendMessageDelayed(obtainMessage, currentTimeMillis);
        }
    }
}
