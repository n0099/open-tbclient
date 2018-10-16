package com.baidu.searchbox.ng.ai.apps.channel.im;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppImClientManager extends AiAppImParserFromBundle {
    private static final boolean DEBUG = false;
    public static final String IM_CAST_ID = "castId";
    public static final String IM_CB_NAME = "cbName";
    private static final String MODULE_TAG = "AiAppIm";
    private static final String TAG = "AiAppImManager";
    private String mAppId;
    private List<ProcessMessageDispatch> mPullMsgDispatchList;
    private List<ProcessMessageDispatch> mRegisterDispatchList;
    private List<ProcessMessageDispatch> mSendMsgDispatchList;

    private AiAppImClientManager() {
        this.mRegisterDispatchList = new ArrayList();
        this.mSendMsgDispatchList = new ArrayList();
        this.mPullMsgDispatchList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final AiAppImClientManager sInstance = new AiAppImClientManager();

        private SingletonHolder() {
        }
    }

    public static AiAppImClientManager getIns() {
        return SingletonHolder.sInstance;
    }

    public boolean registerIm(String str, JSONObject jSONObject, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsMessengerClient msgClient;
        if (TextUtils.isEmpty(str) || jSONObject == null || callbackHandler == null || aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "register im failure, some params is null, please check");
            return false;
        } else if (!jSONObject.has(IM_CAST_ID) || (msgClient = aiApp.getMsgClient()) == null) {
            return false;
        } else {
            this.mAppId = msgClient.getAppId();
            cacheMsgCallback(this.mRegisterDispatchList, jSONObject.optLong(IM_CAST_ID), str, callbackHandler);
            msgClient.sendMessage(201, jSONObject.toString());
            AiAppsLog.i(MODULE_TAG, "register sendMessage success");
            return true;
        }
    }

    public boolean unregisterIm(JSONObject jSONObject, AiApp aiApp) {
        AiAppsMessengerClient msgClient;
        if (jSONObject == null || aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "unregister im failure, some params is null, please check");
            return false;
        } else if (!jSONObject.has(IM_CAST_ID) || (msgClient = aiApp.getMsgClient()) == null) {
            return false;
        } else {
            removeRegisterCallback(jSONObject.optLong(IM_CAST_ID));
            msgClient.sendMessage(202, jSONObject.toString());
            AiAppsLog.i(MODULE_TAG, "unregister im sendMessage success");
            return true;
        }
    }

    public boolean sendImMsg(String str, JSONObject jSONObject, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsMessengerClient msgClient;
        if (TextUtils.isEmpty(str) || jSONObject == null || callbackHandler == null || aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "send im message failure, some params is null, please check");
            return false;
        }
        try {
            jSONObject.put(IM_CB_NAME, str);
        } catch (Exception e) {
            AiAppsLog.e(MODULE_TAG, "send im message data add callback exception");
        }
        if (!jSONObject.has(IM_CAST_ID) || (msgClient = aiApp.getMsgClient()) == null) {
            return false;
        }
        cacheMsgCallback(this.mSendMsgDispatchList, jSONObject.optLong(IM_CAST_ID), str, callbackHandler);
        msgClient.sendMessage(203, jSONObject.toString());
        AiAppsLog.i(MODULE_TAG, "send im message sendMessage success");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fetchImMsgList(String str, JSONObject jSONObject, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsMessengerClient msgClient;
        if (TextUtils.isEmpty(str) || jSONObject == null || callbackHandler == null) {
            AiAppsLog.e(MODULE_TAG, "fetch im message failure, some params is null, please check");
            return false;
        }
        try {
            jSONObject.put(IM_CB_NAME, str);
        } catch (Exception e) {
            AiAppsLog.e(MODULE_TAG, "fetch im message data add callback exception");
        }
        if (!jSONObject.has(IM_CAST_ID) || (msgClient = aiApp.getMsgClient()) == null) {
            return false;
        }
        cacheMsgCallback(this.mPullMsgDispatchList, jSONObject.optLong(IM_CAST_ID), str, callbackHandler);
        msgClient.sendMessage(204, jSONObject.toString());
        AiAppsLog.i(MODULE_TAG, "fetch im message sendMessage success");
        return true;
    }

    public boolean registerImCallback(Object obj) {
        ProcessMessageDispatch processMessageDispatch;
        JSONObject jSONObjectByObject = getJSONObjectByObject(obj);
        if (jSONObjectByObject == null) {
            AiAppsLog.e(MODULE_TAG, "register im callback, data is null");
            return false;
        }
        long optLong = jSONObjectByObject.optLong(IM_CAST_ID);
        if (optLong <= 0 || this.mRegisterDispatchList.isEmpty()) {
            AiAppsLog.e(MODULE_TAG, "register im callback, castId is invalid or callback list is empty");
            return false;
        }
        Iterator<ProcessMessageDispatch> it = this.mRegisterDispatchList.iterator();
        while (true) {
            if (!it.hasNext()) {
                processMessageDispatch = null;
                break;
            }
            processMessageDispatch = it.next();
            if (processMessageDispatch != null && processMessageDispatch.castId == optLong) {
                break;
            }
        }
        if (processMessageDispatch != null) {
            jSONObjectByObject.remove(IM_CAST_ID);
            processMessageDispatch.dispatch(jSONObjectByObject);
            AiAppsLog.i(MODULE_TAG, "register im callback, dispatch data");
            return true;
        }
        return false;
    }

    public boolean sendOrFetchImMsgCallback(boolean z, Object obj) {
        ProcessMessageDispatch processMessageDispatch;
        JSONObject jSONObjectByObject = getJSONObjectByObject(obj);
        if (jSONObjectByObject == null) {
            AiAppsLog.e(MODULE_TAG, "send or fetch im callback, data is null");
            return false;
        }
        List<ProcessMessageDispatch> list = z ? this.mSendMsgDispatchList : this.mPullMsgDispatchList;
        String optString = jSONObjectByObject.optString(IM_CB_NAME);
        if (TextUtils.isEmpty(optString) || list.isEmpty()) {
            AiAppsLog.e(MODULE_TAG, "send or fetch im callback, castId is null or callback list is empty");
            return false;
        }
        Iterator<ProcessMessageDispatch> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                processMessageDispatch = null;
                break;
            }
            processMessageDispatch = it.next();
            if (processMessageDispatch != null && TextUtils.equals(optString, processMessageDispatch.callBackName)) {
                break;
            }
        }
        if (processMessageDispatch != null) {
            jSONObjectByObject.remove(IM_CB_NAME);
            if (processMessageDispatch.dispatch(jSONObjectByObject)) {
                list.remove(processMessageDispatch);
            }
            AiAppsLog.i(MODULE_TAG, "send or fetch im callback, dispatch data");
            return true;
        }
        return false;
    }

    private void removeRegisterCallback(long j) {
        ProcessMessageDispatch processMessageDispatch;
        AiAppsLog.i(MODULE_TAG, "remove register im callback, castId = " + j);
        if (j > 0) {
            Iterator<ProcessMessageDispatch> it = this.mRegisterDispatchList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    processMessageDispatch = null;
                    break;
                }
                processMessageDispatch = it.next();
                if (processMessageDispatch != null && processMessageDispatch.castId == j) {
                    break;
                }
            }
            if (processMessageDispatch != null) {
                this.mRegisterDispatchList.remove(processMessageDispatch);
            }
        }
    }

    private void cacheMsgCallback(List<ProcessMessageDispatch> list, long j, String str, CallbackHandler callbackHandler) {
        ProcessMessageDispatch processMessageDispatch;
        if (list != null && j > 0 && !TextUtils.isEmpty(str) && callbackHandler != null) {
            ProcessMessageDispatch processMessageDispatch2 = new ProcessMessageDispatch(j, str, callbackHandler);
            Iterator<ProcessMessageDispatch> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    processMessageDispatch = null;
                    break;
                }
                processMessageDispatch = it.next();
                if (processMessageDispatch != null && processMessageDispatch.castId == j && TextUtils.equals(processMessageDispatch.callBackName, str)) {
                    break;
                }
            }
            if (processMessageDispatch != null) {
                list.remove(processMessageDispatch);
            }
            list.add(processMessageDispatch2);
        }
    }

    public boolean clearAllCallbackDispatcher(String str) {
        if (TextUtils.equals(str, this.mAppId)) {
            this.mRegisterDispatchList.clear();
            this.mSendMsgDispatchList.clear();
            this.mPullMsgDispatchList.clear();
            this.mAppId = null;
            AiAppsLog.i(MODULE_TAG, "clear all callback dispatcher");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ProcessMessageDispatch {
        private String callBackName;
        private long castId;
        private CallbackHandler handler;

        private ProcessMessageDispatch(long j, String str, CallbackHandler callbackHandler) {
            this.castId = j;
            this.callBackName = str;
            this.handler = callbackHandler;
        }

        public boolean dispatch(JSONObject jSONObject) {
            if (TextUtils.isEmpty(this.callBackName) || this.handler == null || jSONObject == null) {
                return false;
            }
            this.handler.handleSchemeDispatchCallback(this.callBackName, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            return true;
        }
    }
}
