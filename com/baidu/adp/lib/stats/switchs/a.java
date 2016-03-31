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
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static final Handler mHandler = new com.baidu.adp.lib.stats.switchs.b();
    private static volatile a xJ;
    private Context mContext;
    private boolean wI;
    private b xI;
    private boolean xG = false;
    private String xH = null;
    private BdStatSwitchData xK = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c xL = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0008a xM = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0008a {
        void hN();
    }

    public static a ix() {
        if (xJ == null) {
            synchronized (a.class) {
                if (xJ == null) {
                    xJ = new a();
                }
            }
        }
        return xJ;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0008a interfaceC0008a) {
        this.wI = z;
        this.xH = str;
        this.mContext = context;
        try {
            if (this.xI == null && this.mContext != null) {
                this.xI = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.mContext.registerReceiver(this.xI, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.xM = interfaceC0008a;
        iy();
    }

    public void iy() {
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
            if (a.this.xL.iB()) {
                bdStatSwitchData.parserJson(a.this.xL.xO);
            }
            a.this.xG = false;
            if (a.this.wI && a.this.ay(a.this.xL.xO)) {
                String iz = a.this.iz();
                if (!TextUtils.isEmpty(iz) && !iz.equals(a.this.xL.xO)) {
                    a.this.xG = true;
                    bdStatSwitchData.parserJson(iz);
                    a.this.xL.aA(iz);
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
                a.this.xK = bdStatSwitchData;
                if (a.this.wI && a.this.xG) {
                    a.this.iA();
                    i.iF().iI();
                }
                if (a.this.xM != null) {
                    a.this.xM.hN();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ay(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.xL.xN >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iz() {
        if (TextUtils.isEmpty(this.xH)) {
            return null;
        }
        try {
            h a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.xH) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.vN, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA() {
        if (this.wI) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.wI) {
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
                    com.baidu.adp.lib.stats.a.hz().save();
                    if (a.this.wI) {
                        i.iF().iM();
                    }
                } else if ("com.baidu.adp.stats.switch".equals(action)) {
                    if (!a.this.wI) {
                        a.this.iy();
                        i.iF().iI();
                    }
                } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !a.this.wI && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.xK.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.xK.isWrite(com.baidu.adp.lib.stats.base.a.ax(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xK.isUpload(com.baidu.adp.lib.stats.base.a.ax(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xK.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.ax(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xK.isExactWriteFile(com.baidu.adp.lib.stats.base.a.ax(str));
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.xK.smallFlowUpload(com.baidu.adp.lib.stats.base.a.ax(str), str2);
    }

    public ArrayList<String> az(String str) {
        return this.xK.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.xK.getTmpSwitchConfData(str) == null) {
            this.xK.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.xK.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.xK.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
