package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.e;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.k;
import com.baidubce.http.Headers;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public final class d {
    private static final Map<String, SoftReference<String>> d = new ConcurrentHashMap();
    private final List<String> a = new ArrayList();
    private final List<String> b = new ArrayList();
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a implements f {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a, String str) {
            d.this.a(c0292a.a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a) {
            d.this.a(this.a, c0292a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class b implements f {
        b() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a, String str) {
            d.this.a(c0292a.a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a) {
            d dVar = d.this;
            dVar.a(dVar.c, c0292a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class e implements f {
        e() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a) {
            String c = e.a.C0292a.c(c0292a.a);
            String b = e.a.C0292a.b(c0292a.a);
            if (new File(d.this.c.getFilesDir(), c).exists()) {
                try {
                    String d = d.this.d(d.this.c, c);
                    if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", d.this.c)) {
                        d.this.a(b, d.getBytes());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface f {
        void a(e.a.C0292a c0292a);

        void a(e.a.C0292a c0292a, String str);
    }

    String c(String str) {
        if (d.containsKey(str) && d.get(str) != null) {
            String str2 = d.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    void d(String str) {
        d.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(Context context, String str) {
        if (SapiContext.getInstance().getBoolean(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false)) {
            return a(context, a(str));
        }
        return null;
    }

    @TargetApi(4)
    String d(Context context, String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(context.getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.g + File.separator + str);
    }

    void a(String str, String str2) {
        d.put(str, new SoftReference<>(str2));
    }

    String a(Context context, String str) {
        a();
        if (SapiContext.getInstance().getSapiOptions().e().c()) {
            String c2 = c(str);
            if (TextUtils.isEmpty(c2)) {
                e.a.C0292a c3 = c(context, str);
                if (c3 != null) {
                    a(c3, new a(context));
                }
                return c(str);
            }
            return c2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.a.C0292a c(Context context, String str) {
        for (e.a.C0292a c0292a : SapiContext.getInstance().getSapiOptions().e().a()) {
            if (c0292a.a.equals(str)) {
                return c0292a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class c extends HttpHandlerWrap {
        final /* synthetic */ com.baidu.sapi2.e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, com.baidu.sapi2.e eVar) {
            super(z);
            this.a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            d.this.c(this.a);
            d.this.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
            if (str != null) {
                d.this.a(str, this.a);
                if (hashMap != null) {
                    SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap.get(Headers.ETAG));
                }
                d.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.d$d  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0291d implements f {
        final /* synthetic */ e.a.C0292a a;
        final /* synthetic */ com.baidu.sapi2.e b;
        final /* synthetic */ e.a c;

        /* renamed from: com.baidu.sapi2.d$d$a */
        /* loaded from: classes25.dex */
        class a extends HttpHandlerWrap {
            a(boolean z) {
                super(z);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                C0291d c0291d = C0291d.this;
                c0291d.b.a(c0291d.c);
                SapiContext.getInstance().setSapiOptions(C0291d.this.b);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                C0291d c0291d = C0291d.this;
                d.this.a(str, c0291d.a);
            }
        }

        C0291d(e.a.C0292a c0292a, com.baidu.sapi2.e eVar, e.a aVar) {
            this.a = c0292a;
            this.b = eVar;
            this.c = aVar;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a, String str) {
            if (TextUtils.isEmpty(this.a.a) || TextUtils.isEmpty(str)) {
                return;
            }
            d.this.a(this.a.a, str);
            d dVar = d.this;
            dVar.a(dVar.c, e.a.C0292a.c(this.a.a), str.getBytes());
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0292a c0292a) {
            new HttpClientWrap().get(this.a.b, new HttpHashMapWrap(), null, null, new a(true));
        }
    }

    void b(com.baidu.sapi2.e eVar) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + "/static/appsapi/conf/android-conf.txt";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        try {
            new HttpClientWrap().get(str, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, 0, new c(true, eVar));
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.sapi2.e eVar) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccountManager.getInstance().preFetchStoken(SapiContext.getInstance().getCurrentAccount(), false);
        new FaceLoginService().syncFaceLoginUID(this.c, null);
        a(eVar.s);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new OneKeyLoginSdkCall().a(sapiConfiguration, OneKeyLoginSdkCall.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.c = context.getApplicationContext();
        com.baidu.sapi2.e sapiOptions = SapiContext.getInstance().getSapiOptions();
        a(sapiOptions);
        b(sapiOptions);
    }

    void a(com.baidu.sapi2.e eVar) {
        e.a e2 = eVar.e();
        if (e2.c()) {
            for (e.a.C0292a c0292a : e2.a()) {
                this.a.add(c0292a.a);
            }
            this.b.addAll(this.a);
            for (e.a.C0292a c0292a2 : e2.a()) {
                a(c0292a2, new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        if (TextUtils.isEmpty(deviceInfo)) {
            return;
        }
        k.a("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
    }

    void a(e.a.C0292a c0292a, f fVar) {
        if (fVar != null) {
            String b2 = e.a.C0292a.b(c0292a.a);
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), b2).exists()) {
                    String b3 = b(b2);
                    if (SecurityUtil.md5(b3.getBytes(), false).equals(c0292a.c)) {
                        fVar.a(c0292a, b3);
                    } else {
                        fVar.a(c0292a);
                    }
                } else {
                    fVar.a(c0292a);
                }
                return;
            } catch (Throwable th) {
                fVar.a(c0292a);
                return;
            }
        }
        throw new IllegalArgumentException(f.class.getName() + "can't be null");
    }

    String b(String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    void a(Context context, e.a.C0292a c0292a) {
        String c2 = e.a.C0292a.c(c0292a.a);
        if (new File(context.getFilesDir(), c2).exists()) {
            try {
                a(c0292a.a, d(context, c2));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : ":" + parse.getPort()) + parse.getPath();
        return !str2.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION) ? str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : str2;
    }

    void a(String str, com.baidu.sapi2.e eVar) {
        e.a.C0292a c0292a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sapi2.e a2 = com.baidu.sapi2.e.a(jSONObject);
            SapiContext.getInstance().setSapiOptions(a2);
            SapiContext.getInstance().setPkgSigns(e.d.a(jSONObject));
            e.a e2 = a2.e();
            e.a e3 = eVar.e();
            c(a2);
            this.b.clear();
            if (e2.c()) {
                for (e.a.C0292a c0292a2 : e2.a()) {
                    this.b.add(c0292a2.a);
                }
                for (e.a.C0292a c0292a3 : e2.a()) {
                    e.a.C0292a c0292a4 = null;
                    Iterator<e.a.C0292a> it = e3.a().iterator();
                    while (true) {
                        c0292a = c0292a4;
                        if (!it.hasNext()) {
                            break;
                        }
                        c0292a4 = it.next();
                        if (!c0292a4.a.equals(c0292a3.a)) {
                            c0292a4 = c0292a;
                        }
                    }
                    if (a(c0292a3, c0292a)) {
                        a(c0292a3, new C0291d(c0292a3, a2, e3));
                    } else {
                        SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                        a(c0292a3, new e());
                    }
                }
            }
        } catch (JSONException e4) {
        }
    }

    void a(String str, e.a.C0292a c0292a) {
        if (TextUtils.isEmpty(c0292a.a) || TextUtils.isEmpty(str) || !c0292a.c.equals(SecurityUtil.md5(str.getBytes(), false))) {
            return;
        }
        a(c0292a.a, str);
        a(this.c, e.a.C0292a.c(c0292a.a), str.getBytes());
        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.c)) {
            a(e.a.C0292a.b(c0292a.a), str.getBytes());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z) {
        Process process;
        Exception e2;
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
            if (!TextUtils.isEmpty(packageDirExecutePer)) {
                Process process2 = null;
                try {
                    process = Runtime.getRuntime().exec("chmod " + packageDirExecutePer + " " + this.c.getApplicationInfo().dataDir);
                    try {
                        try {
                            if (process.waitFor() == 0) {
                                SapiContext.getInstance().setPackageDirExecutePer("");
                            }
                            if (process == null) {
                                return;
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.e(e2);
                            if (process == null) {
                                return;
                            }
                            process.destroy();
                        }
                    } catch (Throwable th) {
                        process2 = process;
                        th = th;
                        if (process2 != null) {
                            process2.destroy();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    process = null;
                    e2 = e4;
                } catch (Throwable th2) {
                    th = th2;
                    if (process2 != null) {
                    }
                    throw th;
                }
                process.destroy();
            }
        }
    }

    boolean a(e.a.C0292a c0292a, e.a.C0292a c0292a2) {
        return !TextUtils.isEmpty(c0292a.c) && (c0292a2 == null || !c0292a.c.equals(c0292a2.c));
    }

    void a() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.a) {
            if (!this.b.contains(str)) {
                arrayList.add(str);
                d(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.a.contains(str2)) {
                this.a.remove(str2);
            }
        }
    }

    void a(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            fileOutputStream.write(bArr);
            SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (fileOutputStream == null) {
                return;
            }
        }
        try {
            fileOutputStream.close();
        } catch (Throwable th2) {
        }
    }

    void a(String str, byte[] bArr) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                com.baidu.sapi2.utils.a.a(new File(Environment.getExternalStorageDirectory(), str), bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
