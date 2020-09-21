package com.baidu.ar.arplay.core.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class ARPMessage {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static ARPMessage mARPMessage = null;
    private Handler mHandler;
    private List<ArCallback> mMsgHandlers;
    private boolean mIsInitNative = false;
    private HandlerThread mThread = new HandlerThread("msg_callback_thread");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class ArCallback {
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class ArMessage {
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* loaded from: classes10.dex */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    public ARPMessage() {
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        ARPMessage.this.processIncomingMessage((ArMessage) message.obj);
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.mMsgHandlers = new LinkedList();
    }

    public static ARPMessage getInstance() {
        ARPMessage aRPMessage;
        if (mARPMessage == null) {
            synchronized (ARPMessage.class) {
                if (mARPMessage == null) {
                    mARPMessage = new ARPMessage();
                }
                aRPMessage = mARPMessage;
            }
            return aRPMessage;
        }
        return mARPMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        for (ArCallback arCallback : this.mMsgHandlers) {
            if (arCallback.mMessageType == 0 || arMessage.mMessageType == arCallback.mMessageType) {
                if (-1 == arCallback.mMessageId || arMessage.mResMessageID == arCallback.mMessageId) {
                    arCallback.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
                }
            }
        }
    }

    private static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ARPMessage aRPMessage = (ARPMessage) ((WeakReference) obj).get();
        if (aRPMessage == null) {
            return;
        }
        aRPMessage.receiveMsgFromEngine(i, i2, hashMap, i3);
    }

    private void sendMessageImpl(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        if (ARPEngine.getInstance().isEngineCanAccess()) {
            if (-1 == i2) {
                sendMessageToEngine(i, getMessageID(), hashMap, i3);
            } else {
                sendMessageToEngine(i, i2, hashMap, i3);
            }
        }
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    native int getMessageID();

    native void nativeFinalize();

    native void nativeSetup(Object obj);

    public void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        Log.d("ARPMessage", "receiveMsgFromEngine :" + i);
        this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
    }

    public synchronized void registerMessageHandler(final int i, final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.2
            @Override // java.lang.Runnable
            public void run() {
                ARPMessage.this.mMsgHandlers.add(new ArCallback(i, -1, messageHandler));
            }
        });
    }

    public void release() {
        this.mHandler.removeCallbacks(null);
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.4
            @Override // java.lang.Runnable
            public void run() {
                if (ARPMessage.this.mMsgHandlers != null) {
                    ARPMessage.this.mMsgHandlers.clear();
                }
            }
        });
        nativeFinalize();
        this.mIsInitNative = false;
    }

    public synchronized void removeMessageHandeler(final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.3
            @Override // java.lang.Runnable
            public void run() {
                if (ARPMessage.this.mMsgHandlers == null) {
                    return;
                }
                Iterator it = ARPMessage.this.mMsgHandlers.iterator();
                while (it.hasNext()) {
                    if (((ArCallback) it.next()).mHandler == messageHandler) {
                        it.remove();
                    }
                }
            }
        });
    }

    public void sendLuaScriptToEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_COLOR_KEY, Integer.valueOf(i));
        if (!z) {
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setUp() {
        if (this.mIsInitNative) {
            return;
        }
        nativeSetup(new WeakReference(this));
        this.mIsInitNative = true;
    }
}
