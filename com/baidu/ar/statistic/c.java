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
/* loaded from: classes.dex */
public class c extends Handler {
    public b wx;
    public Map<String, String> wy;

    public c(Looper looper, b bVar) {
        super(looper);
        this.wx = bVar;
        this.wy = new HashMap();
    }

    public void a(int i, Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                aVar.b("ar_key", ARConfig.getARKey());
            }
            aVar.b(ARConfigKey.AR_ID, ARConfig.getARId());
            aVar.b(ARConfigKey.AR_FROM, ARConfig.getArFrom());
            aVar.b("ar_type", String.valueOf(ARConfig.getARType()));
            if (!this.wy.isEmpty()) {
                aVar.a(this.wy);
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
        int i = message.what;
        if (i == 20) {
            this.wx.j((a) message.obj);
        } else if (i == 21) {
            this.wx.h((List) message.obj);
        } else {
            switch (i) {
                case 1:
                    this.wx.init();
                    return;
                case 2:
                    this.wx.c((a) message.obj);
                    return;
                case 3:
                    this.wx.g((a) message.obj);
                    return;
                case 4:
                    this.wx.h((a) message.obj);
                    return;
                case 5:
                    this.wx.i((a) message.obj);
                    return;
                case 6:
                    this.wx.e((a) message.obj);
                    return;
                default:
                    switch (i) {
                        case 97:
                            this.wx.z(((Long) message.obj).longValue());
                            return;
                        case 98:
                            this.wx.A(((Long) message.obj).longValue());
                            return;
                        case 99:
                            this.wx.gk();
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
        }
    }

    public void setPubParam(String str, String str2) {
        this.wy.put(str, str2);
    }

    public void setPubParams(Map<String, String> map) {
        if (map != null) {
            this.wy.putAll(map);
        }
    }
}
