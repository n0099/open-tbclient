package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.FileUtil;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static final String a = "sapi_share";
    private static final String b = ".BD_SAPI_CACHE/.sapi_temp/";
    private static final String c = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
    private static final String d = "w0d4o27mh3k1e461";
    private static final String e = "2314906973403010";
    private static final int f = 5;
    private Context g = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        b.a(this.g, z, new a() { // from class: com.baidu.sapi2.share.c.1
            @Override // com.baidu.sapi2.share.c.a
            public void a(final b bVar) {
                ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.c.1.1
                    @Override // java.lang.Runnable
                    @TargetApi(8)
                    public void run() {
                        String str;
                        String md5 = MD5Util.toMd5(c.this.g.getPackageName().getBytes(), false);
                        try {
                            str = new String(Base64.encode(new AES().encrypt(bVar.a().toString(), c.e, c.d), 0));
                        } catch (Exception e2) {
                            Log.e(e2);
                            str = "";
                        }
                        c.this.a(md5, str);
                        c.this.b(md5, str);
                    }
                }));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(String str) {
        b b2 = b(str);
        if (b2 == null) {
            return c(str);
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.g.getSharedPreferences(a, 5);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @TargetApi(8)
    private b b(String str) {
        try {
            String string = this.g.createPackageContext(str, 2).getSharedPreferences(a, 5).getString(MD5Util.toMd5(str.getBytes(), false), "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            b a2 = b.a(new JSONObject(new String(new AES().decrypt(Base64.decode(string, 0), e, d))));
            a2.g = 0;
            return a2;
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory(), b + str);
        if (TextUtils.isEmpty(str2)) {
            FileUtil.deleteFile(file);
            return;
        }
        try {
            FileUtil.write(file, str2.getBytes(), false);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @TargetApi(8)
    private b c(String str) {
        try {
            String read = FileUtil.read(Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + b + MD5Util.toMd5(str.getBytes(), false));
            if (TextUtils.isEmpty(read)) {
                return null;
            }
            b a2 = b.a(new JSONObject(new String(new AES().decrypt(Base64.decode(read, 0), e, d))));
            a2.g = 1;
            return a2;
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;

        private b() {
        }

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            bVar.a = jSONObject.optString("url");
            bVar.b = jSONObject.optString("displayname");
            bVar.c = jSONObject.optString("app");
            bVar.e = jSONObject.optString("uid");
            bVar.d = jSONObject.optString("pkg");
            bVar.f = jSONObject.optInt(FrsActivityConfig.FLAG, -1);
            return bVar;
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    b a = a(jSONArray.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return arrayList;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.a);
                jSONObject.put("displayname", this.b);
                jSONObject.put("app", this.c);
                jSONObject.put("uid", this.e);
                jSONObject.put("pkg", this.d);
                jSONObject.put(FrsActivityConfig.FLAG, this.f);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                JSONObject a = bVar.a();
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            return jSONArray;
        }

        public static void a(final Context context, boolean z, final a aVar) {
            if (SapiAccountManager.getInstance().isLogin()) {
                if (z) {
                    b bVar = new b();
                    bVar.b = SapiAccountManager.getInstance().getSession().displayname;
                    bVar.a = SapiContext.getInstance(context).getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                    bVar.c = SapiUtils.getAppName(context);
                    bVar.d = context.getPackageName();
                    bVar.e = UUID.randomUUID().toString();
                    bVar.f = 0;
                    aVar.a(bVar);
                    return;
                }
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.share.c.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        b bVar2 = new b();
                        bVar2.f = 1;
                        a.this.a(bVar2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        b bVar2 = new b();
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                            bVar2.a = c.c;
                        } else {
                            bVar2.a = getUserInfoResult.portraitHttps;
                        }
                        SapiContext.getInstance(context).put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, bVar2.a);
                        bVar2.b = session.displayname;
                        bVar2.c = SapiUtils.getAppName(context);
                        bVar2.d = context.getPackageName();
                        bVar2.e = UUID.randomUUID().toString();
                        bVar2.f = 0;
                        a.this.a(bVar2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        b bVar2 = new b();
                        bVar2.f = 1;
                        a.this.a(bVar2);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, SapiAccountManager.getInstance().getSession().bduss);
                return;
            }
            b bVar2 = new b();
            bVar2.f = 1;
            aVar.a(bVar2);
        }
    }
}
