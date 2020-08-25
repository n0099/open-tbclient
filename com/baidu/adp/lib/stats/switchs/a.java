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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static volatile a NU;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.nT().cf(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private b NT;
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean NQ = false;
    private String NR = null;
    private BdStatSwitchData NV = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b NW = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0020a NX = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0020a {
        void mU();
    }

    public static a nM() {
        if (NU == null) {
            synchronized (a.class) {
                if (NU == null) {
                    NU = new a();
                }
            }
        }
        return NU;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0020a interfaceC0020a) {
        this.mIsMainProcess = z;
        this.NR = str;
        this.mContext = context;
        try {
            if (this.NT == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.NT = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPLOAD_ALLFILE);
                this.mContext.registerReceiver(this.NT, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.NX = interfaceC0020a;
        nN();
    }

    public void nN() {
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
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.NW.nQ()) {
                bdStatSwitchData.parserJson(a.this.NW.NZ);
            }
            a.this.NQ = false;
            if (a.this.mIsMainProcess && a.this.cb(a.this.NW.NZ)) {
                String nO = a.this.nO();
                if (!TextUtils.isEmpty(nO) && !nO.equals(a.this.NW.NZ)) {
                    a.this.NQ = true;
                    bdStatSwitchData.parserJson(nO);
                    a.this.NW.cd(nO);
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
                a.this.NV = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.NQ && !BdBaseApplication.getInst().checkInterrupt()) {
                    a.this.nP();
                    g.nT().nW();
                }
                if (a.this.NX != null) {
                    a.this.NX.mU();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cb(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.NW.NY >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nO() {
        if (TextUtils.isEmpty(this.NR)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.NR, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.retBytes, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP() {
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
                        g.nT().oa();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH.equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.nN();
                        g.nT().nW();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD.equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra(BdStatsConstant.SWITCHS_CMD_BRDMSG_NAME)) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.NV.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.NV.isWrite(com.baidu.adp.lib.stats.base.a.ca(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.NV.isUpload(com.baidu.adp.lib.stats.base.a.ca(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.NV.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.ca(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.NV.isExactWriteFile(com.baidu.adp.lib.stats.base.a.ca(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.NV.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.NV.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.NV.smallFlowUpload(com.baidu.adp.lib.stats.base.a.ca(str), str2);
    }

    public ArrayList<String> cc(String str) {
        return this.NV.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.NV.getTmpSwitchConfData(str) == null) {
            this.NV.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.NV.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.NV.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
