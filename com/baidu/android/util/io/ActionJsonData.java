package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class ActionJsonData {
    public static final int STATUS_DEFAULT = -1;
    public static final int STATUS_OK = 0;
    private static final String TAG = "ActionJsonData";
    public static final String TAG_COMMAND = "command";
    public static final String TAG_DATASET = "dataset";
    public static final String TAG_LINK = "link";
    public static final String TAG_NOTIFICATION = "notification";
    public static final String TAG_SIGN_IN = "sign_in";
    public static final String TAG_STATUS = "status";
    public static final String TAG_TEXT = "text";
    public static final String TAG_VERSION = "version";
    private List<JSONObject> mDataset;
    private Link mLink;
    private int mSignInStatus;
    private int mStatus = -1;
    private int mVersion = 0;

    /* loaded from: classes4.dex */
    public static final class Link {
        public Notification mNotification;
        public SignIn mSignIn;
    }

    /* loaded from: classes4.dex */
    public static final class Notification {
        public String mCommand;
        public String mText;
    }

    /* loaded from: classes4.dex */
    public static final class SignIn {
        public String mCommand;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public List<JSONObject> getDataset() {
        return this.mDataset;
    }

    public void setDataset(List<JSONObject> list) {
        this.mDataset = list;
    }

    public Link getLink() {
        return this.mLink;
    }

    public void setLink(Link link) {
        this.mLink = link;
    }

    public int getSignInStatus() {
        return this.mSignInStatus;
    }

    public void setSignIn(int i) {
        this.mSignInStatus = i;
    }

    public static ActionJsonData fromJson(JSONObject jSONObject) {
        String optString;
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
            if (jSONObject2 != null && (optString = jSONObject2.optString(TAG_NOTIFICATION)) != null) {
                JSONObject jSONObject3 = new JSONObject(optString);
                Notification notification = new Notification();
                notification.mText = jSONObject3.optString("text");
                notification.mCommand = jSONObject3.optString("command");
                SignIn signIn = new SignIn();
                JSONObject jSONObject4 = new JSONObject(jSONObject2.optString(TAG_SIGN_IN));
                if (jSONObject4 != null) {
                    signIn.mCommand = jSONObject4.optString("command");
                }
                Link link = new Link();
                link.mNotification = notification;
                link.mSignIn = signIn;
                actionJsonData.setLink(link);
            }
        } catch (JSONException e) {
            e.printStackTrace();
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

    public static ActionJsonData fromJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return fromJson(new JSONObject(str));
            } catch (JSONException e) {
                Log.i(TAG, e.toString());
            }
        }
        return null;
    }
}
