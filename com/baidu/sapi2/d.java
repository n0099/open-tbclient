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
/* loaded from: classes3.dex */
public final class d {
    private static final Map<String, SoftReference<String>> d = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f5212a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f5213b = new ArrayList();
    private Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f5214a;

        a(Context context) {
            this.f5214a = context;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a, String str) {
            d.this.a(c0341a.f5228a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a) {
            d.this.a(this.f5214a, c0341a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements f {
        b() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a, String str) {
            d.this.a(c0341a.f5228a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a) {
            d dVar = d.this;
            dVar.a(dVar.c, c0341a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements f {
        e() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a) {
            String c = e.a.C0341a.c(c0341a.f5228a);
            String b2 = e.a.C0341a.b(c0341a.f5228a);
            if (new File(d.this.c.getFilesDir(), c).exists()) {
                try {
                    String d = d.this.d(d.this.c, c);
                    if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", d.this.c)) {
                        d.this.a(b2, d.getBytes());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface f {
        void a(e.a.C0341a c0341a);

        void a(e.a.C0341a c0341a, String str);
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
                e.a.C0341a c3 = c(context, str);
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
    public e.a.C0341a c(Context context, String str) {
        for (e.a.C0341a c0341a : SapiContext.getInstance().getSapiOptions().e().a()) {
            if (c0341a.f5228a.equals(str)) {
                return c0341a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.sapi2.e f5217a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, com.baidu.sapi2.e eVar) {
            super(z);
            this.f5217a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            d.this.c(this.f5217a);
            d.this.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
            if (str != null) {
                d.this.a(str, this.f5217a);
                if (hashMap != null) {
                    SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap.get(Headers.ETAG));
                }
                d.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0340d implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e.a.C0341a f5219a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.baidu.sapi2.e f5220b;
        final /* synthetic */ e.a c;

        /* renamed from: com.baidu.sapi2.d$d$a */
        /* loaded from: classes3.dex */
        class a extends HttpHandlerWrap {
            a(boolean z) {
                super(z);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                C0340d c0340d = C0340d.this;
                c0340d.f5220b.a(c0340d.c);
                SapiContext.getInstance().setSapiOptions(C0340d.this.f5220b);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                C0340d c0340d = C0340d.this;
                d.this.a(str, c0340d.f5219a);
            }
        }

        C0340d(e.a.C0341a c0341a, com.baidu.sapi2.e eVar, e.a aVar) {
            this.f5219a = c0341a;
            this.f5220b = eVar;
            this.c = aVar;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a, String str) {
            if (TextUtils.isEmpty(this.f5219a.f5228a) || TextUtils.isEmpty(str)) {
                return;
            }
            d.this.a(this.f5219a.f5228a, str);
            d dVar = d.this;
            dVar.a(dVar.c, e.a.C0341a.c(this.f5219a.f5228a), str.getBytes());
        }

        @Override // com.baidu.sapi2.d.f
        public void a(e.a.C0341a c0341a) {
            new HttpClientWrap().get(this.f5219a.f5229b, new HttpHashMapWrap(), null, null, new a(true));
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
            for (e.a.C0341a c0341a : e2.a()) {
                this.f5212a.add(c0341a.f5228a);
            }
            this.f5213b.addAll(this.f5212a);
            for (e.a.C0341a c0341a2 : e2.a()) {
                a(c0341a2, new b());
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

    void a(e.a.C0341a c0341a, f fVar) {
        if (fVar != null) {
            String b2 = e.a.C0341a.b(c0341a.f5228a);
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), b2).exists()) {
                    String b3 = b(b2);
                    if (SecurityUtil.md5(b3.getBytes(), false).equals(c0341a.c)) {
                        fVar.a(c0341a, b3);
                    } else {
                        fVar.a(c0341a);
                    }
                } else {
                    fVar.a(c0341a);
                }
                return;
            } catch (Throwable th) {
                fVar.a(c0341a);
                return;
            }
        }
        throw new IllegalArgumentException(f.class.getName() + "can't be null");
    }

    String b(String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    void a(Context context, e.a.C0341a c0341a) {
        String c2 = e.a.C0341a.c(c0341a.f5228a);
        if (new File(context.getFilesDir(), c2).exists()) {
            try {
                a(c0341a.f5228a, d(context, c2));
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
        e.a.C0341a c0341a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sapi2.e a2 = com.baidu.sapi2.e.a(jSONObject);
            SapiContext.getInstance().setSapiOptions(a2);
            SapiContext.getInstance().setPkgSigns(e.d.a(jSONObject));
            e.a e2 = a2.e();
            e.a e3 = eVar.e();
            c(a2);
            this.f5213b.clear();
            if (e2.c()) {
                for (e.a.C0341a c0341a2 : e2.a()) {
                    this.f5213b.add(c0341a2.f5228a);
                }
                for (e.a.C0341a c0341a3 : e2.a()) {
                    e.a.C0341a c0341a4 = null;
                    Iterator<e.a.C0341a> it = e3.a().iterator();
                    while (true) {
                        c0341a = c0341a4;
                        if (!it.hasNext()) {
                            break;
                        }
                        c0341a4 = it.next();
                        if (!c0341a4.f5228a.equals(c0341a3.f5228a)) {
                            c0341a4 = c0341a;
                        }
                    }
                    if (a(c0341a3, c0341a)) {
                        a(c0341a3, new C0340d(c0341a3, a2, e3));
                    } else {
                        SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                        a(c0341a3, new e());
                    }
                }
            }
        } catch (JSONException e4) {
        }
    }

    void a(String str, e.a.C0341a c0341a) {
        if (TextUtils.isEmpty(c0341a.f5228a) || TextUtils.isEmpty(str) || !c0341a.c.equals(SecurityUtil.md5(str.getBytes(), false))) {
            return;
        }
        a(c0341a.f5228a, str);
        a(this.c, e.a.C0341a.c(c0341a.f5228a), str.getBytes());
        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.c)) {
            a(e.a.C0341a.b(c0341a.f5228a), str.getBytes());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Process */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z) {
        Throwable th;
        Process process;
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
            if (!TextUtils.isEmpty(packageDirExecutePer)) {
                Process process2 = 0;
                try {
                    try {
                        process = Runtime.getRuntime().exec("chmod " + packageDirExecutePer + " " + this.c.getApplicationInfo().dataDir);
                        try {
                            if (process.waitFor() == 0) {
                                SapiContext.getInstance().setPackageDirExecutePer("");
                            }
                            if (process == null) {
                                return;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Log.e(e);
                            if (process == null) {
                                return;
                            }
                            process.destroy();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        process2 = packageDirExecutePer;
                        if (process2 != 0) {
                            process2.destroy();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    process = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (process2 != 0) {
                    }
                    throw th;
                }
                process.destroy();
            }
        }
    }

    boolean a(e.a.C0341a c0341a, e.a.C0341a c0341a2) {
        return !TextUtils.isEmpty(c0341a.c) && (c0341a2 == null || !c0341a.c.equals(c0341a2.c));
    }

    void a() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.f5212a) {
            if (!this.f5213b.contains(str)) {
                arrayList.add(str);
                d(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.f5212a.contains(str2)) {
                this.f5212a.remove(str2);
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
