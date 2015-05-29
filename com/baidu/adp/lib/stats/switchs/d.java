package com.baidu.adp.lib.stats.switchs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BroadcastReceiver {
    final /* synthetic */ a this$0;

    private d(a aVar) {
        this.this$0 = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        Serializable serializableExtra;
        BdStatSwitchData bdStatSwitchData;
        boolean z2;
        boolean z3;
        if (intent != null) {
            int intExtra = intent.getIntExtra("intent_data_multiprocess_type", 0);
            if (intExtra == 1) {
                com.baidu.adp.lib.h.a.iB().ix();
                z3 = this.this$0.wu;
                if (z3) {
                    i.iw().clearLogResource();
                }
            } else if (intExtra == 2) {
                z2 = this.this$0.wu;
                if (!z2) {
                    this.this$0.iq();
                }
            } else if (intExtra == 3) {
                z = this.this$0.wu;
                if (!z && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                    BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                    if (bdUploadStatMsgData.parentType != null || bdUploadStatMsgData.childType != null) {
                        String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                        if (!TextUtils.isEmpty(str)) {
                            bdStatSwitchData = this.this$0.xh;
                            bdStatSwitchData.putTmpSwitchConfData(str, bdUploadStatMsgData);
                            this.this$0.b(bdUploadStatMsgData);
                        }
                    }
                }
            }
        }
    }
}
