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
    private static volatile a CA;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.js().aQ(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private b Cz;
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean Cx = false;
    private String Cy = null;
    private BdStatSwitchData CB = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b CC = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0017a CD = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0017a {
        void iD();
    }

    public static a jk() {
        if (CA == null) {
            synchronized (a.class) {
                if (CA == null) {
                    CA = new a();
                }
            }
        }
        return CA;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0017a interfaceC0017a) {
        this.mIsMainProcess = z;
        this.Cy = str;
        this.mContext = context;
        try {
            if (this.Cz == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.Cz = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.Cz, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.CD = interfaceC0017a;
        jl();
    }

    public void jl() {
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
            if (a.this.CC.jo()) {
                bdStatSwitchData.parserJson(a.this.CC.CF);
            }
            a.this.Cx = false;
            if (a.this.mIsMainProcess && a.this.aM(a.this.CC.CF)) {
                String jm = a.this.jm();
                if (!TextUtils.isEmpty(jm) && !jm.equals(a.this.CC.CF)) {
                    a.this.Cx = true;
                    bdStatSwitchData.parserJson(jm);
                    a.this.CC.aO(jm);
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
                a.this.CB = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.Cx && !BdBaseApplication.getInst().checkInterrupt()) {
                    a.this.jn();
                    g.js().jv();
                }
                if (a.this.CD != null) {
                    a.this.CD.iD();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aM(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.CC.CE >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jm() {
        if (TextUtils.isEmpty(this.Cy)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.Cy, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.AN, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn() {
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
                        g.js().jz();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.jl();
                        g.js().jv();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.CB.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.CB.isWrite(com.baidu.adp.lib.stats.base.a.aL(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.CB.isUpload(com.baidu.adp.lib.stats.base.a.aL(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.CB.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.aL(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.CB.isExactWriteFile(com.baidu.adp.lib.stats.base.a.aL(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.CB.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.CB.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.CB.smallFlowUpload(com.baidu.adp.lib.stats.base.a.aL(str), str2);
    }

    public ArrayList<String> aN(String str) {
        return this.CB.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.CB.getTmpSwitchConfData(str) == null) {
            this.CB.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.CB.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.CB.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
