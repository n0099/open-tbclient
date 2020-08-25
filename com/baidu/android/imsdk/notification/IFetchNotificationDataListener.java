package com.baidu.android.imsdk.notification;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes9.dex */
public interface IFetchNotificationDataListener extends IMListener {
    void onFetchResult(List<NotificationMsgData> list, boolean z);
}
