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
    private static volatile a nJ;
    private Context mContext;
    private boolean mE;
    private b nI;
    private boolean nG = false;
    private String nH = null;
    private BdStatSwitchData nK = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c nL = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0008a nM = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0008a {
        void ec();
    }

    public static a eJ() {
        if (nJ == null) {
            synchronized (a.class) {
                if (nJ == null) {
                    nJ = new a();
                }
            }
        }
        return nJ;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0008a interfaceC0008a) {
        this.mE = z;
        this.nH = str;
        this.mContext = context;
        try {
            if (this.nI == null && this.mContext != null) {
                this.nI = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.nI, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.nM = interfaceC0008a;
        eK();
    }

    public void eK() {
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
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.nL.eN()) {
                bdStatSwitchData.parserJson(a.this.nL.nO);
            }
            a.this.nG = false;
            if (a.this.mE && a.this.ar(a.this.nL.nO)) {
                String eL = a.this.eL();
                if (!TextUtils.isEmpty(eL) && !eL.equals(a.this.nL.nO)) {
                    a.this.nG = true;
                    bdStatSwitchData.parserJson(eL);
                    a.this.nL.at(eL);
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
                a.this.nK = bdStatSwitchData;
                if (a.this.mE && a.this.nG) {
                    a.this.eM();
                    j.eR().eU();
                }
                if (a.this.nM != null) {
                    a.this.nM.ec();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ar(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.nL.nN >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String eL() {
        if (TextUtils.isEmpty(this.nH)) {
            return null;
        }
        try {
            h a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.nH) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.lG, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM() {
        if (this.mE) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.mE) {
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
                    com.baidu.adp.lib.stats.a.dO().save();
                    if (a.this.mE) {
                        j.eR().eY();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.mE) {
                        a.this.eK();
                        j.eR().eU();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.mE && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.nK.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.nK.isWrite(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.nK.isUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.nK.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.nK.isExactWriteFile(com.baidu.adp.lib.stats.base.a.aq(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.nK.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.nK.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.nK.smallFlowUpload(com.baidu.adp.lib.stats.base.a.aq(str), str2);
    }

    public ArrayList<String> as(String str) {
        return this.nK.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.nK.getTmpSwitchConfData(str) == null) {
            this.nK.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.nK.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.nK.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
