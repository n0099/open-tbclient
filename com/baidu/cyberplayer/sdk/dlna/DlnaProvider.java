package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public abstract class DlnaProvider {

    @Keep
    /* loaded from: classes6.dex */
    public interface DlnaSearchListener {
        void onDeviceChangeNotification(Map<String, Object> map);

        void onRefreshFinishNotification(int i, int i2);
    }

    public abstract CtrlPointProvider ctrlPoint(String str);

    public abstract void search(DlnaSearchListener dlnaSearchListener);

    public abstract void stop();
}
