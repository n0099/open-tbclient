package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, SoftReference<String>> f11199d = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f11200a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f11201b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Context f11202c;

    /* loaded from: classes2.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f11203a;

        public a(Context context) {
            this.f11203a = context;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a, String str) {
            d.this.a(c0135a.f10811a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a) {
            d.this.a(this.f11203a, c0135a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements f {
        public b() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a, String str) {
            d.this.a(c0135a.f10811a, str);
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a) {
            d dVar = d.this;
            dVar.a(dVar.f11202c, c0135a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiOptions f11206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, SapiOptions sapiOptions) {
            super(z);
            this.f11206a = sapiOptions;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            d.this.c(this.f11206a);
            d.this.b();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
            if (str == null) {
                return;
            }
            d.this.a(str, this.f11206a);
            if (hashMap != null) {
                SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap.get("ETag"));
            }
            d.this.b();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements f {
        public e() {
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a) {
            String c2 = SapiOptions.a.C0135a.c(c0135a.f10811a);
            String b2 = SapiOptions.a.C0135a.b(c0135a.f10811a);
            if (new File(d.this.f11202c.getFilesDir(), c2).exists()) {
                try {
                    String c3 = d.this.c(d.this.f11202c, c2);
                    if (SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, d.this.f11202c)) {
                        d.this.a(b2, c3.getBytes());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(SapiOptions.a.C0135a c0135a);

        void a(SapiOptions.a.C0135a c0135a, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SapiOptions sapiOptions) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        new FaceLoginService().syncFaceLoginUID(this.f11202c, null);
        a(sapiOptions.resetFileExecPer);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new OneKeyLoginSdkCall().preGetPhoneInfo(sapiConfiguration, "init");
        }
    }

    public String d(String str) {
        if (!f11199d.containsKey(str) || f11199d.get(str) == null) {
            return null;
        }
        String str2 = f11199d.get(str).get();
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public void e(String str) {
        f11199d.remove(str);
    }

    public String b(Context context, String str) {
        return a(context, a(str));
    }

    public void a(String str, String str2) {
        f11199d.put(str, new SoftReference<>(str2));
    }

    public String a(Context context, String str) {
        a();
        if (SapiContext.getInstance().getSapiOptions().getCache().c()) {
            String d2 = d(str);
            if (TextUtils.isEmpty(d2)) {
                SapiOptions.a.C0135a b2 = b(str);
                if (b2 != null) {
                    a(b2, new a(context));
                }
                return d(str);
            }
            return d2;
        }
        return null;
    }

    public SapiOptions.a.C0135a b(String str) {
        for (SapiOptions.a.C0135a c0135a : SapiContext.getInstance().getSapiOptions().getCache().a()) {
            if (c0135a.f10811a.equals(str)) {
                return c0135a;
            }
        }
        return null;
    }

    /* renamed from: com.baidu.sapi2.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0140d implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiOptions.a.C0135a f11208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SapiOptions f11209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SapiOptions.a f11210c;

        /* renamed from: com.baidu.sapi2.d$d$a */
        /* loaded from: classes2.dex */
        public class a extends HttpHandlerWrap {
            public a(boolean z) {
                super(z);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                C0140d c0140d = C0140d.this;
                c0140d.f11209b.setCache(c0140d.f11210c);
                SapiContext.getInstance().setSapiOptions(C0140d.this.f11209b);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                C0140d c0140d = C0140d.this;
                d.this.a(str, c0140d.f11208a);
            }
        }

        public C0140d(SapiOptions.a.C0135a c0135a, SapiOptions sapiOptions, SapiOptions.a aVar) {
            this.f11208a = c0135a;
            this.f11209b = sapiOptions;
            this.f11210c = aVar;
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a, String str) {
            if (TextUtils.isEmpty(this.f11208a.f10811a) || TextUtils.isEmpty(str)) {
                return;
            }
            d.this.a(this.f11208a.f10811a, str);
            d dVar = d.this;
            dVar.a(dVar.f11202c, SapiOptions.a.C0135a.c(this.f11208a.f10811a), str.getBytes());
        }

        @Override // com.baidu.sapi2.d.f
        public void a(SapiOptions.a.C0135a c0135a) {
            new HttpClientWrap().get(this.f11208a.f10812b, new HttpHashMapWrap(), null, null, new a(true));
        }
    }

    public void b(SapiOptions sapiOptions) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + "/static/appsapi/conf/android-conf.txt";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        try {
            new HttpClientWrap().get(str, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, 0, new c(true, sapiOptions));
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public String c(String str) throws IOException {
        return com.baidu.sapi2.utils.b.b(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    @TargetApi(4)
    public String c(Context context, String str) throws IOException {
        return com.baidu.sapi2.utils.b.b(context.getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.f5556g + File.separator + str);
    }

    public void a(Context context) {
        this.f11202c = context.getApplicationContext();
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        a(sapiOptions);
        b(sapiOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        if (TextUtils.isEmpty(deviceInfo)) {
            return;
        }
        StatService.onEvent("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
    }

    public void a(SapiOptions sapiOptions) {
        SapiOptions.a cache = sapiOptions.getCache();
        if (cache.c()) {
            for (SapiOptions.a.C0135a c0135a : cache.a()) {
                this.f11200a.add(c0135a.f10811a);
            }
            this.f11201b.addAll(this.f11200a);
            for (SapiOptions.a.C0135a c0135a2 : cache.a()) {
                a(c0135a2, new b());
            }
        }
    }

    public void a(SapiOptions.a.C0135a c0135a, f fVar) {
        if (fVar != null) {
            String b2 = SapiOptions.a.C0135a.b(c0135a.f10811a);
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), b2).exists()) {
                    String c2 = c(b2);
                    if (SecurityUtil.md5(c2.getBytes(), false).equals(c0135a.f10813c)) {
                        fVar.a(c0135a, c2);
                    } else {
                        fVar.a(c0135a);
                    }
                } else {
                    fVar.a(c0135a);
                }
                return;
            } catch (Throwable unused) {
                fVar.a(c0135a);
                return;
            }
        }
        throw new IllegalArgumentException(f.class.getName() + "can't be null");
    }

    public void a(Context context, SapiOptions.a.C0135a c0135a) {
        String c2 = SapiOptions.a.C0135a.c(c0135a.f10811a);
        if (new File(context.getFilesDir(), c2).exists()) {
            try {
                a(c0135a.f10811a, c(context, c2));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public String a(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getHost());
        if (parse.getPort() == -1) {
            str2 = "";
        } else {
            str2 = ":" + parse.getPort();
        }
        sb.append(str2);
        sb.append(parse.getPath());
        String sb2 = sb.toString();
        if (sb2.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
            return sb2;
        }
        return sb2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
    }

    public void a(String str, SapiOptions sapiOptions) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
            SapiContext.getInstance().setSapiOptions(fromJSON);
            SapiContext.getInstance().setPkgSigns(SapiOptions.c.a(jSONObject));
            SapiOptions.a cache = fromJSON.getCache();
            SapiOptions.a cache2 = sapiOptions.getCache();
            c(fromJSON);
            this.f11201b.clear();
            if (cache.c()) {
                for (SapiOptions.a.C0135a c0135a : cache.a()) {
                    this.f11201b.add(c0135a.f10811a);
                }
                for (SapiOptions.a.C0135a c0135a2 : cache.a()) {
                    SapiOptions.a.C0135a c0135a3 = null;
                    for (SapiOptions.a.C0135a c0135a4 : cache2.a()) {
                        if (c0135a4.f10811a.equals(c0135a2.f10811a)) {
                            c0135a3 = c0135a4;
                        }
                    }
                    if (a(c0135a2, c0135a3)) {
                        a(c0135a2, new C0140d(c0135a2, fromJSON, cache2));
                    } else {
                        a(c0135a2, new e());
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void a(String str, SapiOptions.a.C0135a c0135a) {
        if (TextUtils.isEmpty(c0135a.f10811a) || TextUtils.isEmpty(str) || !c0135a.f10813c.equals(SecurityUtil.md5(str.getBytes(), false))) {
            return;
        }
        a(c0135a.f10811a, str);
        a(this.f11202c, SapiOptions.a.C0135a.c(c0135a.f10811a), str.getBytes());
        if (SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.f11202c)) {
            a(SapiOptions.a.C0135a.b(c0135a.f10811a), str.getBytes());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @TargetApi(4)
    public void a(boolean z) {
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
            if (TextUtils.isEmpty(packageDirExecutePer)) {
                return;
            }
            Process process = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    process = runtime.exec("chmod " + packageDirExecutePer + " " + this.f11202c.getApplicationInfo().dataDir);
                    if (process.waitFor() == 0) {
                        SapiContext.getInstance().setPackageDirExecutePer("");
                    }
                    if (process == null) {
                        return;
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    if (process == null) {
                        return;
                    }
                }
                process.destroy();
            } catch (Throwable th) {
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        }
    }

    public boolean a(SapiOptions.a.C0135a c0135a, SapiOptions.a.C0135a c0135a2) {
        return !TextUtils.isEmpty(c0135a.f10813c) && (c0135a2 == null || !c0135a.f10813c.equals(c0135a2.f10813c));
    }

    public void a() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.f11200a) {
            if (!this.f11201b.contains(str)) {
                arrayList.add(str);
                e(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.f11200a.contains(str2)) {
                this.f11200a.remove(str2);
            }
        }
    }

    public void a(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
    }

    public void a(String str, byte[] bArr) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                com.baidu.sapi2.utils.b.a(new File(Environment.getExternalStorageDirectory(), str), bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
