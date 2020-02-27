package com.baidu.searchbox.ugc.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.utils.UgcConfigUrl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class QuestionResponseModel {
    public static final String IMAGE = "image";
    public static final String TEXT = "html";
    public static final String VIDEO = "video";
    public QuestionModel questionModel;
    public ReplyModel replyModel;
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = QuestionResponseModel.class.getSimpleName();

    /* loaded from: classes13.dex */
    public static class Origin {
        public int height;
        public String pic_type;
        public String src;
        public int width;
    }

    /* loaded from: classes13.dex */
    public interface QuestionEditCallback {
        void onFailed(String str);

        void onSuccess(List<ReplyContentModel> list);
    }

    /* loaded from: classes13.dex */
    public static class ReplyContentModel {
        public ReplyData data;
        public String type;
    }

    /* loaded from: classes13.dex */
    public static class ReplyData {
        public String cover;
        public String duration;
        public String durationStr;
        public String mediaId;
        public Origin origin;
        public String size;
        public String sizeStr;
        public String src;
        public String value;
    }

    /* loaded from: classes13.dex */
    class ReplyModel {
        public String encodeRid;
        public List<ReplyContentModel> replyList;

        ReplyModel() {
        }
    }

    /* loaded from: classes13.dex */
    class QuestionModel {
        public String content;
        public String encodeQid;
        public String title;

        QuestionModel() {
        }
    }

    public void getEditContent(String str, String str2, final QuestionEditCallback questionEditCallback) {
        String generateEditContentParams = generateEditContentParams(str, str2);
        try {
            String processUrl = UgcRuntime.getUgcInterface().processUrl(UgcConfigUrl.getQuestionEdit());
            if (!TextUtils.isEmpty(processUrl)) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(processUrl)).addParam("data", generateEditContentParams).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false))).build().executeAsyncOnUIBack(new StringResponseCallback() { // from class: com.baidu.searchbox.ugc.model.QuestionResponseModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onSuccess(String str3, int i) {
                        if (QuestionResponseModel.DEBUG) {
                            Log.d(QuestionResponseModel.TAG, "onSuccess: " + str3 + ", statusCode = " + i);
                        }
                        String str4 = null;
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            if (TextUtils.equals(jSONObject.optString("errno"), "0")) {
                                ArrayList parseQuestionResponse = QuestionResponseModel.this.parseQuestionResponse(jSONObject);
                                if (parseQuestionResponse == null || parseQuestionResponse.size() <= 0) {
                                    questionEditCallback.onFailed(null);
                                } else {
                                    questionEditCallback.onSuccess(parseQuestionResponse);
                                    return;
                                }
                            } else {
                                str4 = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                            }
                        } catch (Exception e) {
                            if (QuestionResponseModel.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        if (questionEditCallback != null) {
                            questionEditCallback.onFailed(str4);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (QuestionResponseModel.DEBUG && exc != null) {
                            Log.d(QuestionResponseModel.TAG, "onFail: " + exc.getMessage());
                        }
                        if (questionEditCallback != null) {
                            questionEditCallback.onFailed(null);
                        }
                    }
                });
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            if (questionEditCallback != null) {
                questionEditCallback.onFailed(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ReplyContentModel> parseQuestionResponse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        if (jSONObject == null || jSONObject.optJSONObject("data") == null || (optJSONObject = jSONObject.optJSONObject("data").optJSONObject("603")) == null || (optJSONObject2 = optJSONObject.optJSONObject("wenda")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("data")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("reply")) == null) {
            return null;
        }
        JSONArray optJSONArray = optJSONObject4.optJSONArray("arrContent");
        ArrayList<ReplyContentModel> arrayList = new ArrayList<>();
        if (optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ReplyContentModel replyContentModel = new ReplyContentModel();
                JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                if (optJSONObject5 != null) {
                    replyContentModel.type = optJSONObject5.optString("type");
                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("data");
                    if (optJSONObject6 != null) {
                        ReplyData replyData = new ReplyData();
                        replyData.value = optJSONObject6.optString("value");
                        replyData.src = optJSONObject6.optString(UserAccountActionItem.KEY_SRC);
                        replyData.cover = optJSONObject6.optString("cover");
                        replyData.size = optJSONObject6.optString(TiebaInitialize.LogFields.SIZE);
                        replyData.duration = optJSONObject6.optString("duration");
                        replyData.sizeStr = optJSONObject6.optString("sizeStr");
                        replyData.durationStr = optJSONObject6.optString("durationStr");
                        replyData.mediaId = optJSONObject6.optString("media_id");
                        JSONObject optJSONObject7 = optJSONObject6.optJSONObject("origin");
                        Origin origin = new Origin();
                        if (optJSONObject7 != null) {
                            origin.src = optJSONObject7.optString(UserAccountActionItem.KEY_SRC);
                            origin.width = optJSONObject7.optInt("width");
                            origin.height = optJSONObject7.optInt("height");
                            origin.pic_type = optJSONObject7.optString("pic_type");
                        }
                        replyData.origin = origin;
                        replyContentModel.data = replyData;
                    }
                    arrayList.add(replyContentModel);
                }
            }
            return arrayList;
        }
        return null;
    }

    private String generateEditContentParams(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.put("wenda", "0");
            jSONObject.put("sign", jSONObject2);
            jSONObject3.put("qid", str);
            jSONObject3.put("rid", str2);
            jSONObject4.put("resource_params", jSONObject3);
            jSONObject.put("params", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
