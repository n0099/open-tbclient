package com.baidu.ar.recg.feares;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.ar.recg.search.FeatureSearchResult;
import com.baidu.ar.recg.search.FrameResizeParams;
import com.baidu.ar.recg.search.LocalImageSearchManager;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.MD5Utils;
import com.baidu.ar.util.Utils;
import com.baidu.ar.util.ZipUtils;
import com.baidu.baiduarsdk.ArBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.baidu.ar.recg.feares.a {
    private static final String a = f.class.getSimpleName();
    private static volatile boolean j = false;
    private static volatile boolean k = false;
    private static volatile f l;
    private HandlerThread b;
    private Handler c;
    private e d;
    private List<FeatureResource> e;
    private int f = 0;
    private int g = 0;
    private FrameResizeParams h = null;
    private byte[] i = null;

    /* loaded from: classes3.dex */
    private class a {
        com.baidu.ar.recg.feares.c a;
        String b;

        a(com.baidu.ar.recg.feares.c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private com.baidu.ar.recg.feares.a a;

        public b(Looper looper, com.baidu.ar.recg.feares.a aVar) {
            super(looper);
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        String a;
        HashMap<String, String> b;

        c(String str, HashMap<String, String> hashMap) {
            this.a = str;
            this.b = hashMap;
        }
    }

    private f() {
        e();
    }

    public static f a() {
        if (l == null) {
            synchronized (f.class) {
                if (l == null) {
                    l = new f();
                }
            }
        }
        return l;
    }

    private ArrayList<File> a(File file) {
        File[] listFiles = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isFile()) {
                    a(file2);
                } else if (Utils.isUTF8(file2.getPath())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    private void a(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            if (file.exists()) {
                this.e = b(FileUtils.readFileText(file));
                if (this.e != null) {
                    if (this.e.size() > 0) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.d != null) {
            this.d.onFeatureJsonParse(z);
        }
    }

    private static void a(boolean z) {
        k = z;
    }

    private boolean a(File file, File file2) {
        FileUtils.deleteDir(new File(file.toString() + "/fea"));
        boolean unzip = ZipUtils.unzip(file2, file);
        if (!unzip) {
            Log.e(a, "handleDownloadResource unzip failed");
        }
        return unzip;
    }

    private String[] a(ArrayList<File> arrayList) {
        String[] strArr = new String[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return strArr;
            }
            strArr[i2] = arrayList.get(i2).getPath();
            i = i2 + 1;
        }
    }

    private File b(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + str2);
    }

    private List<FeatureResource> b(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    FeatureResource featureResource = new FeatureResource();
                    featureResource.a(jSONObject.getString("arFileName"));
                    featureResource.b(jSONObject.getString(ARConfigKey.OLD_AR_KEY));
                    featureResource.c(jSONObject.getString(ARConfigKey.OLD_AR_TYPE));
                    featureResource.d(jSONObject.getString("contentId"));
                    featureResource.e(jSONObject.getString("contentTitle"));
                    featureResource.f(jSONObject.getString("contentVersionId"));
                    featureResource.g(jSONObject.getString("createUser"));
                    featureResource.h(jSONObject.getString("os"));
                    featureResource.i(jSONObject.getString("sdkMax"));
                    featureResource.j(jSONObject.getString("sdkMin"));
                    featureResource.k(jSONObject.getString("tag"));
                    featureResource.l(jSONObject.getString("arId"));
                    featureResource.m(jSONObject.getString("imageUrl"));
                    featureResource.n(jSONObject.getString("imageMd5"));
                    featureResource.o(jSONObject.getString("onlineStatus"));
                    arrayList.add(featureResource);
                }
                return arrayList;
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void b(int i, int i2, byte[] bArr) {
        String str;
        boolean z;
        if (j) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f != i || this.g != i2 || this.h == null) {
                this.h = LocalImageSearchManager.getFrameResizeParams(i, i2, 800);
                this.f = i;
                this.g = i2;
            }
            if (this.i == null || this.i.length < this.h.getWidth() * this.h.getHeight()) {
                this.i = new byte[this.h.getWidth() * this.h.getHeight()];
            }
            boolean frameResize = LocalImageSearchManager.frameResize(bArr, i, i2, this.i, this.h.getWidth(), this.h.getHeight(), this.h.getScale());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            FeatureSearchResult[] searchByYUVImage = frameResize ? LocalImageSearchManager.searchByYUVImage(this.i, this.h.getWidth(), this.h.getHeight(), this.i.length) : LocalImageSearchManager.searchByYUVImage(bArr, i, i2, bArr.length);
            Log.e("qatest", "本地识图: " + ((System.currentTimeMillis() - currentTimeMillis) - currentTimeMillis2) + " ms");
            if (searchByYUVImage != null && searchByYUVImage.length > 0 && searchByYUVImage[0] != null && this.e != null && this.e.size() > 0) {
                String fileName = searchByYUVImage[0].getFileName();
                if (!TextUtils.isEmpty(fileName)) {
                    for (FeatureResource featureResource : this.e) {
                        if (fileName.equals(featureResource.a())) {
                            z = true;
                            str = featureResource.b();
                            break;
                        }
                    }
                }
            }
            str = "";
            z = false;
            if (this.d == null || k) {
                return;
            }
            this.d.onYuvImageSearch(z, str);
        }
    }

    private void b(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append((Object) entry.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.lastIndexOf("&"));
        }
        String post = HttpUtils.post(str, sb.toString());
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(post);
            dVar.a(jSONObject.getInt("errorNum") == 0);
            dVar.a(jSONObject.getInt("errorNum"));
            dVar.a(jSONObject.getString("errorMsg"));
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            com.baidu.ar.recg.feares.c cVar = new com.baidu.ar.recg.feares.c();
            cVar.a(jSONObject2.getString("url"));
            cVar.b(jSONObject2.getString(ARResourceKey.HTTP_AR_MD5));
            dVar.a(cVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.d != null) {
            this.d.onResourceRequest(dVar);
        }
    }

    private void c(com.baidu.ar.recg.feares.c cVar, String str) {
        boolean z = false;
        File b2 = b(str, cVar.a().substring(cVar.a().lastIndexOf("/")));
        if (b2.exists() && b2.length() > 0) {
            z = a(b2.getParentFile(), b2);
        }
        if (this.d != null) {
            this.d.onFeatureFilesUnzip(z);
        }
    }

    private void c(String str) {
        ArrayList<File> a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (a2 = a(file)) != null && a2.size() > 0) {
            z = LocalImageSearchManager.initLocalFeatures(a(a2));
            j = z;
        }
        if (this.d != null) {
            this.d.onFeatureFilesInit(z);
        }
    }

    private void d(com.baidu.ar.recg.feares.c cVar, String str) {
        boolean z;
        File b2 = b(str, cVar.a().substring(cVar.a().lastIndexOf("/")));
        FileUtils.deleteFileIfExist(b2);
        boolean downloadFile = HttpUtils.downloadFile(cVar.a(), b2);
        if (downloadFile) {
            try {
                String fileMD5String = MD5Utils.getFileMD5String(b2);
                downloadFile = !TextUtils.isEmpty(fileMD5String) && fileMD5String.equals(cVar.b());
                if (!downloadFile) {
                    FileUtils.deleteFileIfExist(b2);
                    Log.e(a, "handleDownloadResource md5 failed");
                }
                z = downloadFile;
            } catch (Exception e) {
                e.printStackTrace();
                z = downloadFile;
            }
        } else {
            z = downloadFile;
        }
        if (z && !(z = a(b2.getParentFile(), b2))) {
            Log.e(a, "handleDownloadResource unzip failed");
        }
        if (this.d != null) {
            this.d.onResourceDownload(z, cVar.b());
        }
    }

    private void e() {
        if (b()) {
            return;
        }
        this.b = new HandlerThread("FeatureSearchThread");
        this.b.start();
        this.c = new b(this.b.getLooper(), this);
    }

    private void f() {
        if (this.e != null) {
            this.e.clear();
            this.e = null;
        }
        boolean deleteFeatures = LocalImageSearchManager.deleteFeatures();
        j = !deleteFeatures;
        if (this.d != null) {
            this.d.onFeaturesClear(deleteFeatures);
        }
    }

    private void g() {
        if (this.b != null) {
            this.b.getLooper().quit();
        }
        if (this.d != null) {
            this.d.onThreadQuit();
            this.d = null;
        }
        this.b = null;
        this.c = null;
        l = null;
    }

    public void a(int i, int i2, byte[] bArr) {
        if (this.c != null) {
            this.c.removeMessages(1006);
            this.c.sendMessage(this.c.obtainMessage(1006, i, i2, bArr));
        }
    }

    @Override // com.baidu.ar.recg.feares.a
    public void a(Message message) {
        if (message == null) {
            return;
        }
        switch (message.what) {
            case 1001:
                c cVar = (c) message.obj;
                b(cVar.a, cVar.b);
                return;
            case 1002:
                a aVar = (a) message.obj;
                d(aVar.a, aVar.b);
                return;
            case 1003:
                a((String) message.obj);
                return;
            case 1004:
                c((String) message.obj);
                return;
            case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                f();
                return;
            case 1006:
                b(message.arg1, message.arg2, (byte[]) message.obj);
                return;
            case 1007:
                g();
                return;
            case 1008:
                a aVar2 = (a) message.obj;
                c(aVar2.a, aVar2.b);
                return;
            default:
                return;
        }
    }

    public void a(com.baidu.ar.recg.feares.c cVar, String str) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1002, new a(cVar, str)));
        }
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    public void a(String str, String str2) {
        a(false);
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1003, str));
            this.c.sendMessage(this.c.obtainMessage(1004, str2));
        }
    }

    public void a(String str, HashMap<String, String> hashMap) {
        if (this.c != null) {
            this.c.removeMessages(1007);
            this.c.sendMessage(this.c.obtainMessage(1001, new c(str, hashMap)));
        }
    }

    public void b(com.baidu.ar.recg.feares.c cVar, String str) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1008, new a(cVar, str)));
        }
    }

    public boolean b() {
        return this.b != null && this.b.isAlive();
    }

    public void c() {
        a(true);
        if (this.c != null) {
            this.c.removeMessages(1006);
            this.c.sendMessage(this.c.obtainMessage(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC));
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1007));
        }
    }
}
