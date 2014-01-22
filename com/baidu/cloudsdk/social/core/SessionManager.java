package com.baidu.cloudsdk.social.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.cloudsdk.common.util.Validator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SessionManager {
    private static SessionManager a;
    private SharedPreferences b;
    private Context c;

    /* loaded from: classes.dex */
    public class Session {
        private String a;
        private String b;
        private String c;
        private long d;
        private String e;
        private String f;
        private String g;
        private long h;

        private Session(JSONObject jSONObject, boolean z) {
            this.a = jSONObject.getString(SocialConstants.PARAM_MEDIA_TYPE);
            this.e = jSONObject.getString("access_token");
            this.f = jSONObject.getString(SocialConstants.PARAM_SESSION_KEY);
            this.g = jSONObject.getString(SocialConstants.PARAM_SESSION_SECRET);
            this.b = jSONObject.optString(SocialConstants.PARAM_MEDIA_UID);
            this.c = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            this.d = jSONObject.optLong(SocialConstants.PARAM_SOCIAL_UID);
            this.h = jSONObject.optLong(SocialConstants.PARAM_EXPIRES_IN);
            if (z) {
                this.h += System.currentTimeMillis() / 1000;
            }
        }

        public String getAccessToken() {
            return this.e;
        }

        public long getExpires() {
            return this.h;
        }

        public String getMediaType() {
            return this.a;
        }

        public String getMediaUname() {
            return this.c;
        }

        public String getMeidaUid() {
            return this.b;
        }

        public String getSessionKey() {
            return this.f;
        }

        public String getSessionSecret() {
            return this.g;
        }

        public long getSocialUid() {
            return this.d;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() / 1000 > this.h;
        }

        public Session setAccessToken(String str) {
            this.e = str;
            return this;
        }

        public Session setExpires(long j) {
            this.h = j;
            return this;
        }

        public Session setMediaType(String str) {
            this.a = str;
            return this;
        }

        public Session setMediaUid(String str) {
            this.b = str;
            return this;
        }

        public Session setMediaUname(String str) {
            this.c = str;
            return this;
        }

        public Session setSessionKey(String str) {
            this.f = str;
            return this;
        }

        public Session setSessionSecret(String str) {
            this.g = str;
            return this;
        }

        public Session setSocialUid(long j) {
            this.d = j;
            return this;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("access_token", this.e).put(SocialConstants.PARAM_SESSION_KEY, this.f).put(SocialConstants.PARAM_SESSION_SECRET, this.g).put(SocialConstants.PARAM_EXPIRES_IN, this.h).put(SocialConstants.PARAM_MEDIA_TYPE, this.a).putOpt(SocialConstants.PARAM_MEDIA_UID, this.b).putOpt(SocialConstants.PARAM_MEDIA_UNAME, this.c).putOpt(SocialConstants.PARAM_SOCIAL_UID, Long.valueOf(this.d));
            } catch (JSONException e) {
            }
            return jSONObject.toString();
        }
    }

    private SessionManager(Context context) {
        Validator.notNull(context, "context");
        this.c = context.getApplicationContext();
        this.b = context.getSharedPreferences("com.baidu.cloudsdk.social.SESSION", 0);
    }

    private void a() {
        CookieSyncManager.createInstance(this.c);
        CookieManager.getInstance().removeAllCookie();
    }

    public static void clean() {
        if (a != null) {
            a.c = null;
            a = null;
        }
    }

    public static SessionManager getInstance(Context context) {
        if (a == null) {
            a = new SessionManager(context);
        }
        return a;
    }

    public Session get(String str) {
        String string = this.b.getString(str, null);
        if (string == null) {
            return null;
        }
        try {
            return new Session(new JSONObject(string), false);
        } catch (JSONException e) {
            return null;
        }
    }

    public Map getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.b.getAll().entrySet()) {
            try {
                hashMap.put(entry.getKey(), new Session(new JSONObject((String) entry.getValue()), false));
            } catch (JSONException e) {
            }
        }
        return hashMap;
    }

    public boolean remove(String str) {
        a();
        return this.b.edit().remove(str).commit();
    }

    public boolean removeAll() {
        a();
        return this.b.edit().clear().commit();
    }

    public boolean save(Session session) {
        Validator.notNull(session, "session");
        return this.b.edit().putString(session.getMediaType(), session.toString()).commit();
    }

    public boolean save(JSONObject jSONObject) {
        Validator.notNull(jSONObject, "session");
        try {
            return save(new Session(jSONObject, true));
        } catch (JSONException e) {
            return false;
        }
    }
}
