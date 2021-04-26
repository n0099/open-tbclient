package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMAckRequest extends BaseHttpRequest {
    public static final String TAG = "IMAckRequest";
    public JSONArray mAckList = new JSONArray();
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public ArrayList<ChatMsg> mMsgList;
    public long mTriggerId;
    public long mUk;

    public IMAckRequest(Context context, String str, long j, long j2, int i2, int i3, long j3, long j4, boolean z, ArrayList<ChatMsg> arrayList) {
        this.mContext = context;
        this.mKey = str;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i2;
        this.mCount = i3;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mIsReliable = z;
        this.mMsgList = arrayList;
        this.mTriggerId = Utility.getTriggerId(context);
    }

    private void getShortAckMsgs(ArrayList<ChatMsg> arrayList) {
        LogUtils.d(TAG, "getShortAckMsgs begin~~~");
        new LinkedList();
        List<NewAckMessage.Tripule> handleAck = MessageParser.handleAck(this.mContext, arrayList, false, false);
        if (handleAck == null || handleAck.size() <= 0) {
            return;
        }
        Context context = this.mContext;
        NewAckMessage newAckMessage = new NewAckMessage(context, IMSDK.getInstance(context).getUk(), this.mTriggerId, this.mIsReliable);
        newAckMessage.addTriples(handleAck);
        this.mAckList = newAckMessage.getJsonArray();
        LogUtils.d(TAG, "ack msgs: " + this.mAckList);
    }

    public String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
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
            sb.append("=");
            sb.append(jSONObject.opt(str));
        }
        LogUtils.d(TAG, "sign string:" + ((Object) sb));
        return getMd5(sb.toString());
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        hashMap.put("Cookie", "BDUSS=" + bduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return BaseHttpRequest.getHostUrl(this.mContext) + "imsapi/1.0/im_msg_ack/liveshow";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Utility.readAppId(this.mContext));
            jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put("uk", this.mUk);
            jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
            jSONObject.put(Constants.KEY_DEVICE_ID, Utility.getDeviceId(this.mContext));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            LogUtils.d(TAG, "mMsgList.size:" + this.mMsgList.size());
            getShortAckMsgs(this.mMsgList);
            jSONObject.put("msgs", this.mAckList == null ? "" : this.mAckList.toString());
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e2) {
            LogUtils.d(TAG, "getRequestParameter error：" + e2.toString());
        }
        LogUtils.d(TAG, "IMAckRequest getRequestParameter:" + jSONObject);
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        String str = new String(bArr);
        LogUtils.d(TAG, "errorCode：" + i2 + ", resultContent: " + str);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "errorCode：" + i2 + ", resultContent: " + str);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
