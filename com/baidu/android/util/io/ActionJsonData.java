package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class ActionJsonData {
    public static final int STATUS_DEFAULT = -1;
    public static final int STATUS_OK = 0;
    public static final String TAG = "ActionJsonData";
    public static final String TAG_COMMAND = "command";
    public static final String TAG_DATASET = "dataset";
    public static final String TAG_LINK = "link";
    public static final String TAG_NOTIFICATION = "notification";
    public static final String TAG_SIGN_IN = "sign_in";
    public static final String TAG_STATUS = "status";
    public static final String TAG_TEXT = "text";
    public static final String TAG_VERSION = "version";
    public List<JSONObject> mDataset;
    public Link mLink;
    public int mSignInStatus;
    public int mStatus = -1;
    public int mVersion = 0;

    /* loaded from: classes2.dex */
    public static final class Link {
        public Notification mNotification;
        public SignIn mSignIn;
    }

    /* loaded from: classes2.dex */
    public static final class Notification {
        public String mCommand;
        public String mText;
    }

    /* loaded from: classes2.dex */
    public static final class SignIn {
        public String mCommand;
    }

    public static ActionJsonData fromJson(JSONObject jSONObject) {
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        ActionJsonData actionJsonData = new ActionJsonData();
        actionJsonData.setStatus(jSONObject.optInt("status", -1));
        actionJsonData.setVersion(jSONObject.optInt("version"));
        actionJsonData.setSignIn(jSONObject.optInt(TAG_SIGN_IN));
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("link"));
            String optString = jSONObject2.optString(TAG_NOTIFICATION);
            if (optString != null) {
                JSONObject jSONObject3 = new JSONObject(optString);
                Notification notification = new Notification();
                notification.mText = jSONObject3.optString("text");
                notification.mCommand = jSONObject3.optString("command");
                SignIn signIn = new SignIn();
                signIn.mCommand = new JSONObject(jSONObject2.optString(TAG_SIGN_IN)).optString("command");
                Link link = new Link();
                link.mNotification = notification;
                link.mSignIn = signIn;
                actionJsonData.setLink(link);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(TAG_DATASET);
        JSONArray optJSONArray = jSONObject.optJSONArray(TAG_DATASET);
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    arrayList.add(optJSONObject2);
                }
            }
        } else if (optJSONObject != null) {
            arrayList = new ArrayList(1);
            arrayList.add(optJSONObject);
        }
        actionJsonData.setDataset(arrayList);
        return actionJsonData;
    }

    public List<JSONObject> getDataset() {
        return this.mDataset;
    }

    public Link getLink() {
        return this.mLink;
    }

    public int getSignInStatus() {
        return this.mSignInStatus;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setDataset(List<JSONObject> list) {
        this.mDataset = list;
    }

    public void setLink(Link link) {
        this.mLink = link;
    }

    public void setSignIn(int i) {
        this.mSignInStatus = i;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public static ActionJsonData fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return fromJson(new JSONObject(str));
        } catch (JSONException e2) {
            Log.i(TAG, e2.toString());
            return null;
        }
    }
}
