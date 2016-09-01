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
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static final Handler mHandler = new com.baidu.adp.lib.stats.switchs.b();
    private static volatile a qG;
    private Context mContext;
    private boolean pG;
    private b qF;
    private boolean qD = false;
    private String qE = null;
    private BdStatSwitchData qH = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c qI = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0008a qJ = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0008a {
        void eW();
    }

    public static a fD() {
        if (qG == null) {
            synchronized (a.class) {
                if (qG == null) {
                    qG = new a();
                }
            }
        }
        return qG;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0008a interfaceC0008a) {
        this.pG = z;
        this.qE = str;
        this.mContext = context;
        try {
            if (this.qF == null && this.mContext != null) {
                this.qF = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.qF, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.qJ = interfaceC0008a;
        fE();
    }

    public void fE() {
        c cVar = new c(this, null);
        cVar.setPriority(4);
        cVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private c() {
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.qI.fH()) {
                bdStatSwitchData.parserJson(a.this.qI.qL);
            }
            a.this.qD = false;
            if (a.this.pG && a.this.au(a.this.qI.qL)) {
                String fF = a.this.fF();
                if (!TextUtils.isEmpty(fF) && !fF.equals(a.this.qI.qL)) {
                    a.this.qD = true;
                    bdStatSwitchData.parserJson(fF);
                    a.this.qI.aw(fF);
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
                a.this.qH = bdStatSwitchData;
                if (a.this.pG && a.this.qD) {
                    a.this.fG();
                    j.fL().fO();
                }
                if (a.this.qJ != null) {
                    a.this.qJ.eW();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean au(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.qI.qK >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fF() {
        if (TextUtils.isEmpty(this.qE)) {
            return null;
        }
        try {
            h a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.qE) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.oG, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        if (this.pG) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.pG) {
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

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.background".equals(action)) {
                    com.baidu.adp.lib.stats.a.eI().save();
                    if (a.this.pG) {
                        j.fL().fS();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.pG) {
                        a.this.fE();
                        j.fL().fO();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.pG && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.qH.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.qH.isWrite(com.baidu.adp.lib.stats.base.a.at(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.qH.isUpload(com.baidu.adp.lib.stats.base.a.at(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.qH.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.at(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.qH.isExactWriteFile(com.baidu.adp.lib.stats.base.a.at(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.qH.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.qH.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.qH.smallFlowUpload(com.baidu.adp.lib.stats.base.a.at(str), str2);
    }

    public ArrayList<String> av(String str) {
        return this.qH.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.qH.getTmpSwitchConfData(str) == null) {
            this.qH.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.qH.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.qH.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
