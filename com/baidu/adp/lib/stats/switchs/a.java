package com.baidu.adp.lib.stats.switchs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.g;
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
    private static volatile a xh;
    private Context mContext;
    private boolean wf;
    private b xg;
    private boolean xe = false;
    private String xf = null;
    private BdStatSwitchData xi = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c xj = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0006a xk = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0006a {
        void hz();
    }

    public static a ih() {
        if (xh == null) {
            synchronized (a.class) {
                if (xh == null) {
                    xh = new a();
                }
            }
        }
        return xh;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0006a interfaceC0006a) {
        this.wf = z;
        this.xf = str;
        this.mContext = context;
        try {
            if (this.xg == null && this.mContext != null) {
                this.xg = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiprocess2");
                this.mContext.registerReceiver(this.xg, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.xk = interfaceC0006a;
        ii();
    }

    public void ii() {
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
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.xj.il()) {
                bdStatSwitchData.parserJson(a.this.xj.xm);
            }
            a.this.xe = false;
            if (a.this.wf && a.this.ax(a.this.xj.xm)) {
                String ij = a.this.ij();
                if (!TextUtils.isEmpty(ij) && !ij.equals(a.this.xj.xm)) {
                    a.this.xe = true;
                    bdStatSwitchData.parserJson(ij);
                    a.this.xj.az(ij);
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
                a.this.xi = bdStatSwitchData;
                if (a.this.wf && a.this.xe) {
                    a.this.ik();
                    i.ip().is();
                }
                if (a.this.xk != null) {
                    a.this.xk.hz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ax(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.xj.xl >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ij() {
        if (TextUtils.isEmpty(this.xf)) {
            return null;
        }
        try {
            g a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.xf) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.vl, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik() {
        if (this.wf) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiprocess2");
            intent.putExtra("intent_data_multiprocess_type", 2);
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.wf) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiprocess2");
            intent.putExtra("intent_data_multiprocess_type", 3);
            intent.putExtra("switchsCmdBrdMsg", bdUploadStatMsgData);
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
                int intExtra = intent.getIntExtra("intent_data_multiprocess_type", 0);
                if (intExtra == 1) {
                    com.baidu.adp.lib.stats.a.hl().save();
                    if (a.this.wf) {
                        i.ip().iw();
                    }
                } else if (intExtra == 2) {
                    if (!a.this.wf) {
                        a.this.ii();
                        i.ip().is();
                    }
                } else if (intExtra == 3 && !a.this.wf && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.xi.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.xi.isWrite(com.baidu.adp.lib.stats.base.a.aw(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xi.isUpload(com.baidu.adp.lib.stats.base.a.aw(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xi.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.aw(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xi.isExactWriteFile(com.baidu.adp.lib.stats.base.a.aw(str));
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.xi.smallFlowUpload(com.baidu.adp.lib.stats.base.a.aw(str), str2);
    }

    public ArrayList<String> ay(String str) {
        return this.xi.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.xi.getTmpSwitchConfData(str) == null) {
            this.xi.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.xi.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.xi.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
