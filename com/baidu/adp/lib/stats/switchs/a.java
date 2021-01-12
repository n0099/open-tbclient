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
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.c.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static volatile a Pz;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.nA().ce(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private b Py;
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean Pw = false;
    private String Px = null;
    private BdStatSwitchData PD = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b PE = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0017a PF = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0017a {
        void mD();
    }

    public static a nt() {
        if (Pz == null) {
            synchronized (a.class) {
                if (Pz == null) {
                    Pz = new a();
                }
            }
        }
        return Pz;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0017a interfaceC0017a) {
        this.mIsMainProcess = z;
        this.Px = str;
        this.mContext = context;
        try {
            if (this.Py == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.Py = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPLOAD_ALLFILE);
                this.mContext.registerReceiver(this.Py, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.PF = interfaceC0017a;
        nu();
    }

    public void nu() {
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
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.PE.nx()) {
                bdStatSwitchData.parserJson(a.this.PE.PH);
            }
            a.this.Pw = false;
            if (a.this.mIsMainProcess && a.this.bZ(a.this.PE.PH)) {
                String nv = a.this.nv();
                if (!TextUtils.isEmpty(nv) && !nv.equals(a.this.PE.PH)) {
                    a.this.Pw = true;
                    bdStatSwitchData.parserJson(nv);
                    a.this.PE.cb(nv);
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
                a.this.PD = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.Pw && !BdBaseApplication.getInst().checkInterrupt()) {
                    a.this.nw();
                    g.nA().nD();
                }
                if (a.this.PF != null) {
                    a.this.PF.mD();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZ(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.PE.PG >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nv() {
        if (TextUtils.isEmpty(this.Px)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a2 = new com.baidu.adp.lib.network.a.a().a(this.Px, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a2 != null) {
                return new String(a2.retBytes, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
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
                        g.nA().nH();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH.equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.nu();
                        g.nA().nD();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD.equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra(BdStatsConstant.SWITCHS_CMD_BRDMSG_NAME)) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.PD.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.PD.isWrite(com.baidu.adp.lib.stats.base.a.bY(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.PD.isUpload(com.baidu.adp.lib.stats.base.a.bY(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.PD.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.bY(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.PD.isExactWriteFile(com.baidu.adp.lib.stats.base.a.bY(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.PD.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.PD.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.PD.smallFlowUpload(com.baidu.adp.lib.stats.base.a.bY(str), str2);
    }

    public ArrayList<String> ca(String str) {
        return this.PD.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.PD.getTmpSwitchConfData(str) == null) {
            this.PD.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.PD.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.PD.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
            if (currentTimeMillis - IMConnection.RETRY_DELAY_TIMES > 0) {
                currentTimeMillis -= IMConnection.RETRY_DELAY_TIMES;
            }
            Message obtainMessage = mHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = bdUploadStatMsgData;
            mHandler.removeMessages(1);
            mHandler.sendMessageDelayed(obtainMessage, currentTimeMillis);
        }
    }
}
