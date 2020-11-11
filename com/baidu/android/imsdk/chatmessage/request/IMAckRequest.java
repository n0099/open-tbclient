package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.SapiContext;
import com.baidu.webkit.internal.ETAG;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMAckRequest extends BaseHttpRequest {
    private static final String TAG = "IMAckRequest";
    private JSONArray mAckList = new JSONArray();
    private long mBeginid;
    private int mCategory;
    private long mContacter;
    private int mCount;
    private long mEndid;
    private boolean mIsReliable;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private long mTriggerId;
    private long mUk;

    public IMAckRequest(Context context, String str, long j, long j2, int i, int i2, long j3, long j4, boolean z, ArrayList<ChatMsg> arrayList) {
        this.mContext = context;
        this.mKey = str;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mIsReliable = z;
        this.mMsgList = arrayList;
        this.mTriggerId = Utility.getTriggerId(this.mContext);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + new String(bArr));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + new String(bArr));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Utility.readAppId(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put("uk", this.mUk);
            jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
            jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            getShortAckMsgs(this.mMsgList);
            jSONObject.put("msgs", this.mAckList == null ? "" : this.mAckList.toString());
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e) {
            LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
        }
        LogUtils.d(TAG, "IMAckRequest getRequestParameter:" + jSONObject);
        return jSONObject.toString().getBytes();
    }

    protected String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            treeSet.add(keys.next());
        }
        for (String str : treeSet) {
            sb.append(str);
            sb.append(ETAG.EQUAL);
            sb.append(jSONObject.opt(str));
        }
        LogUtils.d(TAG, "sign string:" + ((Object) sb));
        return getMd5(sb.toString());
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl(this.mContext) + "imsapi/1.0/im_msg_ack/liveshow";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    private void getShortAckMsgs(ArrayList<ChatMsg> arrayList) {
        LogUtils.d(TAG, "getShortAckMsgs begin~~~");
        new LinkedList();
        List<NewAckMessage.Tripule> handleAck = MessageParser.handleAck(this.mContext, arrayList, false, false);
        if (handleAck != null && handleAck.size() > 0) {
            NewAckMessage newAckMessage = new NewAckMessage(this.mContext, IMSDK.getInstance(this.mContext).getUk(), this.mTriggerId, this.mIsReliable);
            newAckMessage.addTriples(handleAck);
            this.mAckList = newAckMessage.getJsonArray();
            LogUtils.d(TAG, "ack msgs: " + this.mAckList);
        }
    }
}
