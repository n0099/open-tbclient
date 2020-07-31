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
/* loaded from: classes11.dex */
class c extends Handler {
    private b vg;
    private Map<String, String> vh;

    public c(Looper looper, b bVar) {
        super(looper);
        this.vg = bVar;
        this.vh = new HashMap();
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
            if (!this.vh.isEmpty()) {
                aVar.a(this.vh);
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
                this.vg.aV();
                return;
            case 2:
                this.vg.c((a) message.obj);
                return;
            case 3:
                this.vg.g((a) message.obj);
                return;
            case 4:
                this.vg.h((a) message.obj);
                return;
            case 5:
                this.vg.i((a) message.obj);
                return;
            case 6:
                this.vg.e((a) message.obj);
                return;
            case 20:
                this.vg.j((a) message.obj);
                return;
            case 21:
                this.vg.g((List) message.obj);
                return;
            case 97:
                this.vg.B(((Long) message.obj).longValue());
                return;
            case 98:
                this.vg.C(((Long) message.obj).longValue());
                return;
            case 99:
                this.vg.eW();
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
        this.vh.put(str, str2);
    }

    public void setPubParams(Map<String, String> map) {
        if (map != null) {
            this.vh.putAll(map);
        }
    }
}
