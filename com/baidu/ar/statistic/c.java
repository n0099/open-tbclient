package com.baidu.ar.statistic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.ARConfigKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
class c extends Handler {
    private b uG;
    private Map<String, String> uH;

    public c(Looper looper, b bVar) {
        super(looper);
        this.uG = bVar;
        this.uH = new HashMap();
    }

    public void a(int i, Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                aVar.c("ar_key", ARConfig.getARKey());
            }
            aVar.c("ar_id", ARConfig.getARId());
            aVar.c(ARConfigKey.AR_FROM, ARConfig.getArFrom());
            aVar.c("ar_type", String.valueOf(ARConfig.getARType()));
            if (!this.uH.isEmpty()) {
                aVar.a(this.uH);
            }
        }
        Message obtainMessage = obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.uG.aH();
                return;
            case 2:
                this.uG.c((a) message.obj);
                return;
            case 3:
                this.uG.g((a) message.obj);
                return;
            case 4:
                this.uG.h((a) message.obj);
                return;
            case 5:
                this.uG.i((a) message.obj);
                return;
            case 6:
                this.uG.e((a) message.obj);
                return;
            case 20:
                this.uG.j((a) message.obj);
                return;
            case 21:
                this.uG.e((List) message.obj);
                return;
            case 97:
                this.uG.B(((Long) message.obj).longValue());
                return;
            case 98:
                this.uG.C(((Long) message.obj).longValue());
                return;
            case 99:
                this.uG.eG();
                StatisticApiImpl statisticApiImpl = (StatisticApiImpl) message.obj;
                if (statisticApiImpl != null) {
                    statisticApiImpl.doRelease();
                }
                message.obj = null;
                return;
            default:
                return;
        }
    }

    public void setPubParam(String str, String str2) {
        this.uH.put(str, str2);
    }

    public void setPubParams(Map<String, String> map) {
        if (map != null) {
            this.uH.putAll(map);
        }
    }
}
