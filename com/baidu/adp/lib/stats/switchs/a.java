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
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static volatile a xx;
    private Context mContext;
    private boolean mIsMainProcess;
    private b xw;
    private boolean xu = false;
    private String xv = null;
    private BdStatSwitchData xy = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c xz = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0006a xA = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0006a {
        void fT();
    }

    public static a gB() {
        if (xx == null) {
            synchronized (a.class) {
                if (xx == null) {
                    xx = new a();
                }
            }
        }
        return xx;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0006a interfaceC0006a) {
        this.mIsMainProcess = z;
        this.xv = str;
        this.mContext = context;
        try {
            if (this.xw == null && this.mContext != null) {
                this.xw = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.xw, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.xA = interfaceC0006a;
        gC();
    }

    public void gC() {
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
            if (a.this.xz.gF()) {
                bdStatSwitchData.parserJson(a.this.xz.xC);
            }
            a.this.xu = false;
            if (a.this.mIsMainProcess && a.this.aj(a.this.xz.xC)) {
                String gD = a.this.gD();
                if (!TextUtils.isEmpty(gD) && !gD.equals(a.this.xz.xC)) {
                    a.this.xu = true;
                    bdStatSwitchData.parserJson(gD);
                    a.this.xz.al(gD);
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
                a.this.xy = bdStatSwitchData;
                if (a.this.mIsMainProcess && a.this.xu) {
                    a.this.gE();
                    j.gJ().gM();
                }
                if (a.this.xA != null) {
                    a.this.xA.fT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aj(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.xz.xB >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gD() {
        if (TextUtils.isEmpty(this.xv)) {
            return null;
        }
        try {
            h a = new com.baidu.adp.lib.network.a.a().a(this.xv, 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.vO, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE() {
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

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.background".equals(action)) {
                    BdStatisticsManager.getInstance().save();
                    if (a.this.mIsMainProcess) {
                        j.gJ().gQ();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.mIsMainProcess) {
                        a.this.gC();
                        j.gJ().gM();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.mIsMainProcess && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.xy.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.xy.isWrite(com.baidu.adp.lib.stats.base.a.ai(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xy.isUpload(com.baidu.adp.lib.stats.base.a.ai(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xy.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.ai(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xy.isExactWriteFile(com.baidu.adp.lib.stats.base.a.ai(str));
    }

    public int getMaxAlertCount(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.xy.getMaxAlertCount(str, i);
    }

    public int geUploadCycle(String str, int i) {
        return TextUtils.isEmpty(str) ? i : this.xy.geUploadCycle(str, i);
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.xy.smallFlowUpload(com.baidu.adp.lib.stats.base.a.ai(str), str2);
    }

    public ArrayList<String> ak(String str) {
        return this.xy.getChiledTypes(str);
    }

    public boolean a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.xy.getTmpSwitchConfData(str) == null) {
            this.xy.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.xy.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.xy.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
