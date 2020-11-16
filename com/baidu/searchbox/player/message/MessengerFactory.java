package com.baidu.searchbox.player.message;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.session.VideoSession;
/* loaded from: classes11.dex */
public class MessengerFactory implements IMessengerFactory {
    @Override // com.baidu.searchbox.player.message.IMessengerFactory
    public IMessenger createMessenger(@NonNull VideoSession videoSession) {
        return new HandlerMessenger(videoSession);
    }
}
