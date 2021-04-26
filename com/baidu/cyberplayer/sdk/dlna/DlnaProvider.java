package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public abstract class DlnaProvider {

    @Keep
    /* loaded from: classes2.dex */
    public interface DlnaSearchListener {
        void onDeviceChangeNotification(Map<String, Object> map);

        void onRefreshFinishNotification(int i2, int i3);
    }

    public abstract CtrlPointProvider ctrlPoint(String str);

    public abstract void search(DlnaSearchListener dlnaSearchListener);

    public abstract void stop();
}
