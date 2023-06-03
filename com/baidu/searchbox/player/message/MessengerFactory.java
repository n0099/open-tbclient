package com.baidu.searchbox.player.message;
/* loaded from: classes4.dex */
public class MessengerFactory implements IMessengerFactory {
    @Override // com.baidu.searchbox.player.message.IMessengerFactory
    public IMessenger createMessenger() {
        return new HandlerMessenger();
    }
}
