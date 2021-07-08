package com.baidu.searchbox.player.message;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.session.VideoSession;
/* loaded from: classes2.dex */
public interface IMessengerFactory {
    IMessenger createMessenger(@NonNull VideoSession videoSession);
}
