package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3672a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3673b = "heartbeatcfg.cfg";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3674c = "stastics bean http request";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3675d = "publish_data";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3676e = "sign";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3677f = "/odp/wireless/sdk/heartbeat";

    /* renamed from: h  reason: collision with root package name */
    public static final String f3678h = "utf-8";
    public static a i;

    /* renamed from: g  reason: collision with root package name */
    public String f3679g = "https://www.baifubao.com";
    public HeartBeatCfgEntity j = null;
    public Context k = null;
    public String l;
    public boolean m;

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (i == null) {
                i = new a();
            }
            aVar = i;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (NetworkUtils.isNetworkAvailable(this.k)) {
            try {
                String e2 = e();
                if (!TextUtils.isEmpty(e2)) {
                    String str = f3672a;
                    LogUtil.i(str, f3672a + " execute success,response:" + e2);
                    try {
                        String optString = new JSONObject(e2).optString("content");
                        if (!TextUtils.isEmpty(optString)) {
                            a(HeartBeatCfgEntity.build(optString));
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    String str2 = f3672a;
                    LogUtil.w(str2, f3672a + " the response is null.");
                }
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        String str3 = f3672a;
        LogUtil.d(str3, f3672a + " loadCfg current network is't available.");
    }

    private String e() throws RestRuntimeException {
        Context context = this.k;
        RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "stastics bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("ua", this.l));
        arrayList.add(new RestNameValuePair("nettype", new com.baidu.apollon.restnet.rest.b(this.k).e()));
        arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new RestHttpRequestInterceptor() { // from class: com.baidu.apollon.heartbeat.a.2
            @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
            public void intercept(Context context2, d dVar) {
                dVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
        });
        restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
        restTemplate.setRequestInterceptor(arrayList2);
        return (String) restTemplate.a(this.f3679g + f3677f, arrayList, "utf-8", String.class);
    }

    public boolean b() {
        return this.m;
    }

    public void b(Context context) {
        if (context == null) {
            return;
        }
        this.k = context;
        new Thread(new Runnable() { // from class: com.baidu.apollon.heartbeat.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                HeartBeatCfgEntity c2 = aVar.c(aVar.k);
                if (c2 != null) {
                    long b2 = c.b(a.this.k, c.f3699b, 300L);
                    if (!c2.isValidRequestTime(b2)) {
                        a.this.a(c2);
                        return;
                    }
                    String str = a.f3672a;
                    LogUtil.i(str, a.f3672a + " onChange lastRequestTime:" + b2 + " execute tryLoadCfg.");
                    a.this.d();
                    return;
                }
                a.this.d();
            }
        }).start();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00b9 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public HeartBeatCfgEntity c(Context context) {
        FileReader fileReader;
        HeartBeatCfgEntity heartBeatCfgEntity;
        ?? sb = new StringBuilder();
        sb.append(context.getCacheDir());
        sb.append(File.separator);
        sb.append(f3673b);
        File file = new File(sb.toString());
        FileReader fileReader2 = null;
        HeartBeatCfgEntity heartBeatCfgEntity2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (file.exists() && file.isFile()) {
                    fileReader = new FileReader(file);
                    try {
                        String copyToString = FileCopyUtils.copyToString(fileReader);
                        if (!TextUtils.isEmpty(copyToString)) {
                            heartBeatCfgEntity2 = HeartBeatCfgEntity.build(copyToString);
                        } else {
                            LogUtil.w(f3672a, f3672a + " cache:" + file.getPath() + " content json is empty.");
                        }
                        heartBeatCfgEntity = heartBeatCfgEntity2;
                        fileReader2 = fileReader;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    }
                } else {
                    LogUtil.w(f3672a, f3672a + " cache:" + file.getPath() + " isn't exist.");
                    heartBeatCfgEntity = null;
                }
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return heartBeatCfgEntity;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileReader = null;
        } catch (IOException e7) {
            e = e7;
            fileReader = null;
        } catch (Throwable th2) {
            sb = 0;
            th = th2;
            if (sb != 0) {
                try {
                    sb.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3679g = str;
    }

    public void b(String str) {
        this.l = str;
    }

    public String a() {
        return this.f3679g;
    }

    public HeartBeatCfgEntity a(Context context) {
        if (context == null) {
            return null;
        }
        if (this.j == null) {
            this.j = c(context);
        }
        return this.j;
    }

    public void a(Context context, HeartBeatCfgEntity heartBeatCfgEntity) {
        if (context == null || heartBeatCfgEntity == null) {
            return;
        }
        this.k = context;
        a(heartBeatCfgEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HeartBeatCfgEntity heartBeatCfgEntity) {
        boolean z;
        if (heartBeatCfgEntity != null) {
            HeartBeatCfgEntity heartBeatCfgEntity2 = this.j;
            if ((heartBeatCfgEntity2 == null || (heartBeatCfgEntity2 != null && !TextUtils.equals(heartBeatCfgEntity2.toString(), heartBeatCfgEntity.toString()))) && heartBeatCfgEntity.checkResponseValidity()) {
                this.j = heartBeatCfgEntity;
                heartBeatCfgEntity.storeResponse(this.k);
                z = true;
                String str = f3672a;
                LogUtil.i(str, f3672a + " refreshHeartBeatCfg mResponse.");
                if (z) {
                    return;
                }
                HeartBeatManager.getInstance().applyBeating();
                return;
            }
        } else {
            String str2 = f3672a;
            LogUtil.w(str2, f3672a + " refreshHeartBeatCfg resp is null || mResponse = resp.");
        }
        z = false;
        if (z) {
        }
    }
}
