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
/* loaded from: classes12.dex */
class c extends Handler {
    private b vJ;
    private Map<String, String> vK;

    public c(Looper looper, b bVar) {
        super(looper);
        this.vJ = bVar;
        this.vK = new HashMap();
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
            if (!this.vK.isEmpty()) {
                aVar.a(this.vK);
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
                this.vJ.init();
                return;
            case 2:
                this.vJ.c((a) message.obj);
                return;
            case 3:
                this.vJ.g((a) message.obj);
                return;
            case 4:
                this.vJ.h((a) message.obj);
                return;
            case 5:
                this.vJ.i((a) message.obj);
                return;
            case 6:
                this.vJ.e((a) message.obj);
                return;
            case 20:
                this.vJ.j((a) message.obj);
                return;
            case 21:
                this.vJ.h((List) message.obj);
                return;
            case 97:
                this.vJ.B(((Long) message.obj).longValue());
                return;
            case 98:
                this.vJ.C(((Long) message.obj).longValue());
                return;
            case 99:
                this.vJ.gk();
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
        this.vK.put(str, str2);
    }

    public void setPubParams(Map<String, String> map) {
        if (map != null) {
            this.vK.putAll(map);
        }
    }
}
