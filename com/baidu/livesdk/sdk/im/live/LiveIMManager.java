package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import com.baidu.livesdk.api.im.ConnectListener;
import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.IMManager;
import com.baidu.livesdk.api.im.live.LiveIM;
import com.baidu.livesdk.api.im.live.LiveMsgReceiverListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.api.im.live.LiveSendMessageListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class LiveIMManager implements LiveIM {
    public static final boolean DEBUG = false;
    public static final String TAG = "LiveIMController";
    public Context mContext;
    public IMManager mIMManager;
    public boolean mIsRegisterConnectListener = false;
    public final Map<String, LiveIMController> mHashMap = new ConcurrentHashMap();

    public LiveIMManager(Context context, IMManager iMManager) {
        this.mContext = context;
        this.mIMManager = iMManager;
    }

    private LiveIMController create(String str, String str2, boolean z) {
        LiveIMController liveIMController = new LiveIMController(this.mIMManager.build(this.mContext, str, str2, z));
        this.mHashMap.put(str, liveIMController);
        return liveIMController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, LiveIMController> entry : this.mHashMap.entrySet()) {
                LiveIMController liveIMController = this.mHashMap.get(entry.getKey());
                if (liveIMController != null) {
                    liveIMController.enterRoom();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void register() {
        if (this.mIsRegisterConnectListener) {
            return;
        }
        this.mIMManager.unregisterConnectListener();
        this.mIMManager.registerConnectListener(new ConnectListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMManager.1
            @Override // com.baidu.livesdk.api.im.ConnectListener
            public void onResult(int i2) {
                if (i2 == 0) {
                    LiveIMManager.this.reconnect();
                } else if (1 == i2) {
                    LiveIMManager.this.mIMManager.tryConnection();
                }
            }
        });
        this.mIsRegisterConnectListener = true;
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void enterRoom(String str, String str2, int i2, IMCastSetListener iMCastSetListener, boolean z) {
        register();
        create(str, str2, z).enterRoom(str, str2, i2, iMCastSetListener, z);
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void exitRoom(String str) {
        LiveIMController liveIMController = getLiveIMController(str);
        if (liveIMController != null) {
            liveIMController.exitRoom(str);
            this.mHashMap.remove(str);
        }
    }

    public IMConversation getConversation(String str) {
        return this.mHashMap.get(str).getConversation();
    }

    public LiveIMController getLiveIMController(String str) {
        return this.mHashMap.get(str);
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void registerMsgReceiveListener(String str, LiveMsgReceiverListener liveMsgReceiverListener) {
        LiveIMController liveIMController = getLiveIMController(str);
        if (liveIMController != null) {
            liveIMController.registerMsgReceiveListener(str, liveMsgReceiverListener);
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void sendMessage(String str, LiveSendMessage liveSendMessage, LiveSendMessageListener liveSendMessageListener) {
        LiveIMController liveIMController = getLiveIMController(str);
        if (liveIMController != null) {
            liveIMController.sendMessage(str, liveSendMessage, liveSendMessageListener);
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void exitRoom() {
        try {
            for (Map.Entry<String, LiveIMController> entry : this.mHashMap.entrySet()) {
                String key = entry.getKey();
                LiveIMController liveIMController = this.mHashMap.get(key);
                if (liveIMController != null) {
                    if (liveIMController.isConnect()) {
                        liveIMController.exitRoom();
                    }
                    this.mHashMap.remove(key);
                }
            }
            this.mIMManager.unregisterConnectListener();
            this.mIsRegisterConnectListener = false;
        } catch (Exception unused) {
        }
    }
}
