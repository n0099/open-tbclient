package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.ReferenceDt;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class FastPublishUtils {
    private static final String FORWARD_SUCCESS = "1";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = FastPublishUtils.class.getSimpleName();

    public static void gotoFastPublish(final UgcSchemeModel ugcSchemeModel) {
        if (ugcSchemeModel != null) {
            if (!NetWorkUtils.isNetworkConnected(AppRuntime.getAppContext())) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
            } else {
                goLogin(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.utils.FastPublishUtils.1
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            FastPublishUtils.goPublish(UgcSchemeModel.this);
                        }
                    }
                }, ugcSchemeModel);
            }
        }
    }

    private static void goLogin(ILoginResultListener iLoginResultListener, UgcSchemeModel ugcSchemeModel) {
        if (!UgcLoginUtils.isLogin()) {
            UgcLoginUtils.login(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
        } else if (!UgcLoginUtils.isGuestLogin()) {
            goPublish(ugcSchemeModel);
        } else {
            UgcLoginUtils.bindPhone(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void goPublish(UgcSchemeModel ugcSchemeModel) {
        if (ugcSchemeModel != null) {
            String str = ugcSchemeModel.referenceDt;
            if (!TextUtils.isEmpty(str)) {
                ReferenceDt referenceDt = getReferenceDt(str);
                JSONObject requestJson = getRequestJson(referenceDt);
                JSONObject extObject = getExtObject(ugcSchemeModel);
                sendForwardRequest(getRequestModel(requestJson, ugcSchemeModel, extObject), ugcSchemeModel, referenceDt, extObject);
            }
        }
    }

    private static JSONObject getExtObject(UgcSchemeModel ugcSchemeModel) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(ugcSchemeModel.ext)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(ugcSchemeModel.ext);
        } catch (JSONException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d(TAG, "快速转发，初始化透传字段数据异常:" + e.toString());
            }
            jSONObject = null;
        }
        return jSONObject;
    }

    private static ReferenceDt getReferenceDt(String str) {
        return (ReferenceDt) new Gson().fromJson(str, (Class<Object>) ReferenceDt.class);
    }

    public static PublishRequestModel getRequestModel(JSONObject jSONObject, UgcSchemeModel ugcSchemeModel, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        publishRequestModel.data = jSONObject;
        publishRequestModel.postUrl = ugcSchemeModel.url;
        publishRequestModel.sourceFrom = ugcSchemeModel.sourceFrom;
        publishRequestModel.extObject = jSONObject2;
        return publishRequestModel;
    }

    public static JSONObject getRequestJson(ReferenceDt referenceDt) {
        JSONObject jSONObject = new JSONObject();
        Gson gson = new Gson();
        HttpRequestPublishModule.Forward forward = new HttpRequestPublishModule.Forward();
        forward.url = referenceDt.url;
        forward.title = referenceDt.title;
        forward.avatar = referenceDt.avatar;
        forward.id = referenceDt.id;
        forward.refType = referenceDt.refType;
        forward.accountType = referenceDt.accountType;
        forward.nid = referenceDt.nid;
        forward.tid = referenceDt.tid;
        forward.channel = referenceDt.channel;
        forward.picCount = referenceDt.picCount;
        forward.videoDuration = referenceDt.videoDuration;
        forward.thumbpic = referenceDt.thumbpic;
        forward.attachmentInfo = referenceDt.attachmentInfo;
        try {
            jSONObject.put("forward", new JSONObject(gson.toJson(forward)));
        } catch (JSONException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d(TAG, "快速转发，初始化requestJson数据异常:" + e.toString());
            }
        }
        return jSONObject;
    }

    private static void sendForwardRequest(PublishRequestModel publishRequestModel, final UgcSchemeModel ugcSchemeModel, final ReferenceDt referenceDt, final JSONObject jSONObject) {
        if (publishRequestModel != null) {
            PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.utils.FastPublishUtils.2
                @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
                public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                    FastPublishUtils.publishSuccess(publishResultInfo, UgcSchemeModel.this, referenceDt, jSONObject);
                }

                @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
                public void onFailed(String str) {
                    FastPublishUtils.publishFail(str, UgcSchemeModel.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void publishSuccess(PublishModels.PublishResultInfo publishResultInfo, UgcSchemeModel ugcSchemeModel, ReferenceDt referenceDt, JSONObject jSONObject) {
        notifyFeedForwardNum(referenceDt, jSONObject);
        handleSuccessCallback(publishResultInfo, ugcSchemeModel);
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
        showForwardToast(ugcSchemeModel);
    }

    private static void showForwardToast(UgcSchemeModel ugcSchemeModel) {
        if (ugcSchemeModel.showToast == 0 || ugcSchemeModel.showToast == 2) {
            UniversalToast.makeText(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.ugc_forward_success)).showToast();
        }
    }

    private static void handleSuccessCallback(PublishModels.PublishResultInfo publishResultInfo, UgcSchemeModel ugcSchemeModel) {
        if (!TextUtils.isEmpty(ugcSchemeModel.ugcCallback)) {
            if (publishResultInfo != null) {
                UnitedSchemeUGCDispatcher.handleCallback(ugcSchemeModel.ugcCallback, publishResultInfo.requestId);
                return;
            }
            return;
        }
        UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.remove("publish");
        if ((UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.get("publish") instanceof NullableCallbackHandler) && publishResultInfo != null) {
            Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.talos.schemesecondcallback", publishResultInfo.requestId);
        }
    }

    public static void publishFail(String str, UgcSchemeModel ugcSchemeModel) {
        if (TextUtils.isEmpty(str)) {
            str = AppRuntime.getAppContext().getString(R.string.ugc_release_fail);
        }
        if (ugcSchemeModel.showToast == 0 || ugcSchemeModel.showToast == 1) {
            UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
        }
    }

    public static void notifyFeedForwardNum(ReferenceDt referenceDt, JSONObject jSONObject) {
        if (referenceDt != null && !TextUtils.isEmpty(referenceDt.nid)) {
            JSONObject jSONObject2 = new JSONObject();
            String str = referenceDt.nid;
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("forward_rel_id"))) {
                str = "dt_" + jSONObject.optString("forward_rel_id");
            }
            try {
                jSONObject2.put("nid", str);
                jSONObject2.put("type", "1");
                Sender.sendBroadcast(AppRuntime.getAppContext(), Contract.FORWARD_NUM_ACTION, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d(TAG, "通知feed计数异常:" + e.toString());
                }
            }
        }
    }
}
