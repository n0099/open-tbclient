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
    private static volatile a xc;
    private Context mContext;
    private boolean wa;
    private b xb;
    private boolean wZ = false;
    private String xa = null;
    private BdStatSwitchData xd = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c xe = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0006a xf = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0006a {
        void hy();
    }

    public static a ig() {
        if (xc == null) {
            synchronized (a.class) {
                if (xc == null) {
                    xc = new a();
                }
            }
        }
        return xc;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0006a interfaceC0006a) {
        this.wa = z;
        this.xa = str;
        this.mContext = context;
        try {
            if (this.xb == null && this.mContext != null) {
                this.xb = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiprocess2");
                this.mContext.registerReceiver(this.xb, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.xf = interfaceC0006a;
        ih();
    }

    public void ih() {
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
            if (a.this.xe.ik()) {
                bdStatSwitchData.parserJson(a.this.xe.xh);
            }
            a.this.wZ = false;
            if (a.this.wa && a.this.av(a.this.xe.xh)) {
                String ii = a.this.ii();
                if (!TextUtils.isEmpty(ii) && !ii.equals(a.this.xe.xh)) {
                    a.this.wZ = true;
                    bdStatSwitchData.parserJson(ii);
                    a.this.xe.ax(ii);
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
                a.this.xd = bdStatSwitchData;
                if (a.this.wa && a.this.wZ) {
                    a.this.ij();
                    i.io().ir();
                }
                if (a.this.xf != null) {
                    a.this.xf.hy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean av(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.xe.xg >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ii() {
        if (TextUtils.isEmpty(this.xa)) {
            return null;
        }
        try {
            g a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.xa) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.vg, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij() {
        if (this.wa) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiprocess2");
            intent.putExtra("intent_data_multiprocess_type", 2);
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.wa) {
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
                    com.baidu.adp.lib.stats.a.hk().save();
                    if (a.this.wa) {
                        i.io().iv();
                    }
                } else if (intExtra == 2) {
                    if (!a.this.wa) {
                        a.this.ih();
                        i.io().ir();
                    }
                } else if (intExtra == 3 && !a.this.wa && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.xd.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.xd.isWrite(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xd.isUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xd.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xd.isExactWriteFile(com.baidu.adp.lib.stats.base.a.au(str));
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.xd.smallFlowUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public ArrayList<String> aw(String str) {
        return this.xd.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.xd.getTmpSwitchConfData(str) == null) {
            this.xd.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.xd.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.xd.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
