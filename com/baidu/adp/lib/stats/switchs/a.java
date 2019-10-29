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
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.gO().av(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private static volatile a qZ;
    private Context mContext;
    private boolean mIsMainProcess;
    private b qY;
    private boolean qW = false;
    private String qX = null;
    private BdStatSwitchData ra = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b rb = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0017a rc = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0017a {
        void gb();
    }

    public static a gG() {
        if (qZ == null) {
            synchronized (a.class) {
                if (qZ == null) {
                    qZ = new a();
                }
            }
        }
        return qZ;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0017a interfaceC0017a) {
        this.mIsMainProcess = z;
        this.qX = str;
        this.mContext = context;
        try {
            if (this.qY == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.qY = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD);
                intentFilter.addAction(BdStatsConstant.MULTIPROCESS_TYPE_UPLOAD_ALLFILE);
                this.mContext.registerReceiver(this.qY, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.rc = interfaceC0017a;
        gH();
    }

    public void gH() {
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
            if (a.this.rb.gK()) {
                bdStatSwitchData.parserJson(a.this.rb.re);
            }
            a.this.qW = false;
            if (a.this.mIsMainProcess && a.this.ar(a.this.rb.re)) {
                String gI = a.this.gI();
                if (!TextUtils.isEmpty(gI) && !gI.equals(a.this.rb.re)) {
                    a.this.qW = true;
                    bdStatSwitchData.parserJson(gI);
                    a.this.rb.at(gI);
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
                a.this.ra = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.qW && !BdBaseApplication.getInst().checkInterrupt()) {
                    a.this.gJ();
                    g.gO().gR();
                }
                if (a.this.rc != null) {
                    a.this.rc.gb();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ar(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.rb.rd >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gI() {
        if (TextUtils.isEmpty(this.qX)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.qX, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.retBytes, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ() {
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
                        g.gO().gV();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_SWITCH.equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.gH();
                        g.gO().gR();
                    }
                } else if (BdStatsConstant.MULTIPROCESS_TYPE_UPDATE_CMD.equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra(BdStatsConstant.SWITCHS_CMD_BRDMSG_NAME)) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.ra.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.ra.isWrite(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ra.isUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ra.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.ra.isExactWriteFile(com.baidu.adp.lib.stats.base.a.aq(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.ra.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.ra.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.ra.smallFlowUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public ArrayList<String> as(String str) {
        return this.ra.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.ra.getTmpSwitchConfData(str) == null) {
            this.ra.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.ra.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.ra.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
