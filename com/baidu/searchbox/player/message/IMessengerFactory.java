package com.baidu.searchbox.player.message;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.session.VideoSession;
/* loaded from: classes15.dex */
public interface IMessengerFactory {
    IMessenger createMessenger(@NonNull VideoSession videoSession);
}
