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
import com.baidu.ar.util.IoUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static volatile a EP;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.switchs.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj instanceof BdUploadStatMsgData) {
                        g.ky().bf(((BdUploadStatMsgData) message.obj).parentType);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private b EO;
    private Context mContext;
    private boolean mIsMainProcess;
    private boolean EM = false;
    private String EN = null;
    private BdStatSwitchData ER = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.b ES = new com.baidu.adp.lib.stats.switchs.b();
    InterfaceC0019a ET = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0019a {
        void jK();
    }

    public static a kq() {
        if (EP == null) {
            synchronized (a.class) {
                if (EP == null) {
                    EP = new a();
                }
            }
        }
        return EP;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0019a interfaceC0019a) {
        this.mIsMainProcess = z;
        this.EN = str;
        this.mContext = context;
        try {
            if (this.EO == null && this.mContext != null) {
                this.EO = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.EO, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.ET = interfaceC0019a;
        kr();
    }

    public void kr() {
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
            if (a.this.ES.ku()) {
                bdStatSwitchData.parserJson(a.this.ES.EV);
            }
            a.this.EM = false;
            if (a.this.mIsMainProcess && a.this.bb(a.this.ES.EV)) {
                String ks = a.this.ks();
                if (!TextUtils.isEmpty(ks) && !ks.equals(a.this.ES.EV)) {
                    a.this.EM = true;
                    bdStatSwitchData.parserJson(ks);
                    a.this.ES.bd(ks);
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
                a.this.ER = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.EM) {
                    a.this.kt();
                    g.ky().kB();
                }
                if (a.this.ET != null) {
                    a.this.ET.jK();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bb(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.ES.EU >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ks() {
        if (TextUtils.isEmpty(this.EN)) {
            return null;
        }
        try {
            com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(this.EN, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.Dc, IoUtils.UTF_8);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
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
                        g.ky().kF();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.kr();
                        g.ky().kB();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.ER.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.ER.isWrite(com.baidu.adp.lib.stats.base.a.ba(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ER.isUpload(com.baidu.adp.lib.stats.base.a.ba(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ER.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.ba(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.ER.isExactWriteFile(com.baidu.adp.lib.stats.base.a.ba(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.ER.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.ER.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.ER.smallFlowUpload(com.baidu.adp.lib.stats.base.a.ba(str), str2);
    }

    public ArrayList<String> bc(String str) {
        return this.ER.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.ER.getTmpSwitchConfData(str) == null) {
            this.ER.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.ER.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.ER.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
