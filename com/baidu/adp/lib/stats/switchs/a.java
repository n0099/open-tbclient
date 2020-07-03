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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static volatile a No;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.mu().cc(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private b Nn;
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean Nl = false;
    private String Nm = null;
    private BdStatSwitchData Np = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b Nq = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0023a Nr = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0023a {
        void lv();
    }

    public static a mn() {
        if (No == null) {
            synchronized (a.class) {
                if (No == null) {
                    No = new a();
                }
            }
        }
        return No;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0023a interfaceC0023a) {
        this.mIsMainProcess = z;
        this.Nm = str;
        this.mContext = context;
        try {
            if (this.Nn == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.Nn = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPLOAD_ALLFILE);
                this.mContext.registerReceiver(this.Nn, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.Nr = interfaceC0023a;
        mo();
    }

    public void mo() {
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
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.Nq.mr()) {
                bdStatSwitchData.parserJson(a.this.Nq.Nt);
            }
            a.this.Nl = false;
            if (a.this.mIsMainProcess && a.this.bY(a.this.Nq.Nt)) {
                String mp = a.this.mp();
                if (!TextUtils.isEmpty(mp) && !mp.equals(a.this.Nq.Nt)) {
                    a.this.Nl = true;
                    bdStatSwitchData.parserJson(mp);
                    a.this.Nq.ca(mp);
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
                a.this.Np = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.Nl && !BdBaseApplication.getInst().checkInterrupt()) {
                    a.this.mq();
                    g.mu().mx();
                }
                if (a.this.Nr != null) {
                    a.this.Nr.lv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bY(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.Nq.Ns >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mp() {
        if (TextUtils.isEmpty(this.Nm)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.Nm, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.retBytes, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq() {
        if (this.mIsMainProcess) {
            Intent intent = new Intent(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH);
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.mIsMainProcess) {
            Intent intent = new Intent(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD);
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
                if (BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND.equals(action)) {
                    BdStatisticsManager.getInstance().save();
                    if (a.this.mIsMainProcess) {
                        g.mu().mB();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH.equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.mo();
                        g.mu().mx();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD.equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra(BdStatsConstant.SWITCHS_CMD_BRDMSG_NAME)) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.Np.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.Np.isWrite(com.baidu.adp.lib.stats.base.a.bX(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Np.isUpload(com.baidu.adp.lib.stats.base.a.bX(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Np.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.bX(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.Np.isExactWriteFile(com.baidu.adp.lib.stats.base.a.bX(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.Np.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.Np.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.Np.smallFlowUpload(com.baidu.adp.lib.stats.base.a.bX(str), str2);
    }

    public ArrayList<String> bZ(String str) {
        return this.Np.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.Np.getTmpSwitchConfData(str) == null) {
            this.Np.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.Np.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.Np.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
