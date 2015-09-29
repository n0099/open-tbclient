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
    private static volatile a xb;
    private Context mContext;
    private boolean vZ;
    private b xa;
    private boolean wY = false;
    private String wZ = null;
    private BdStatSwitchData xc = new BdStatSwitchData();
    private com.baidu.adp.lib.stats.switchs.c xd = new com.baidu.adp.lib.stats.switchs.c();
    InterfaceC0006a xe = null;

    /* renamed from: com.baidu.adp.lib.stats.switchs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0006a {
        void hw();
    }

    public static a id() {
        if (xb == null) {
            synchronized (a.class) {
                if (xb == null) {
                    xb = new a();
                }
            }
        }
        return xb;
    }

    private a() {
    }

    public void a(boolean z, String str, Context context, InterfaceC0006a interfaceC0006a) {
        this.vZ = z;
        this.wZ = str;
        this.mContext = context;
        try {
            if (this.xa == null && this.mContext != null) {
                this.xa = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiprocess2");
                this.mContext.registerReceiver(this.xa, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.xe = interfaceC0006a;
        ie();
    }

    public void ie() {
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
            if (a.this.xd.ii()) {
                bdStatSwitchData.parserJson(a.this.xd.xg);
            }
            a.this.wY = false;
            if (a.this.vZ && a.this.av(a.this.xd.xg)) {
                String ig = a.this.ig();
                if (!TextUtils.isEmpty(ig) && !ig.equals(a.this.xd.xg)) {
                    a.this.wY = true;
                    bdStatSwitchData.parserJson(ig);
                    a.this.xd.ax(ig);
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
                a.this.xc = bdStatSwitchData;
                if (a.this.vZ && a.this.wY) {
                    a.this.ih();
                    i.im().ip();
                }
                if (a.this.xe != null) {
                    a.this.xe.hw();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean av(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.xd.xf >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ig() {
        if (TextUtils.isEmpty(this.wZ)) {
            return null;
        }
        try {
            g a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.wZ) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
            if (a != null) {
                return new String(a.vf, "utf-8");
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih() {
        if (this.vZ) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiprocess2");
            intent.putExtra("intent_data_multiprocess_type", 2);
            this.mContext.sendBroadcast(intent);
        }
    }

    private void a(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.vZ) {
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
                    com.baidu.adp.lib.stats.a.hi().save();
                    if (a.this.vZ) {
                        i.im().it();
                    }
                } else if (intExtra == 2) {
                    if (!a.this.vZ) {
                        a.this.ie();
                        i.im().ip();
                    }
                } else if (intExtra == 3 && !a.this.vZ && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            a.this.xc.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
        return this.xc.isWrite(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean isUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xc.isUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean onlyWifiUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.xc.onlyWifiUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xc.isExactWriteFile(com.baidu.adp.lib.stats.base.a.au(str));
    }

    public boolean smallFlowUpload(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.xc.smallFlowUpload(com.baidu.adp.lib.stats.base.a.au(str), str2);
    }

    public ArrayList<String> aw(String str) {
        return this.xc.getChiledTypes(str);
    }

    public boolean b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.xc.getTmpSwitchConfData(str) == null) {
            this.xc.putTmpSwitchConfData(str, bdUploadStatMsgData);
            a(bdUploadStatMsgData);
            b(bdUploadStatMsgData);
            return true;
        } else if (0 == bdUploadStatMsgData.deadLineTime) {
            this.xc.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < bdUploadStatMsgData.deadLineTime) {
            this.xc.putTmpSwitchConfData(str, bdUploadStatMsgData);
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
