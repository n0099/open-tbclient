package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pass.face.platform.stat.NetUtil;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Ast {
    public static final String AS_FILE_NAME = "ast";
    public static final long UPADTE_DEFUALT_DELAY_TIME = 15000;
    public static Ast instance;
    public File asFile;
    public Context context;
    public Dev dev;
    public String faceHitKey = "";
    public String faceHitKeyLasttime = "FACE_HIT_KEY_LASSTTIME";
    public SparseArray<Integer> faceIds = new SparseArray<>();
    public boolean isInit;
    public long lastSavetime;
    public Properties properties;
    public String scene;

    private void clear() {
        this.properties.clear();
    }

    private String generateFaceHitKey(String str) {
        return new SimpleDateFormat("yyyy_MM_dd_HH").format(new Date()) + "_" + str;
    }

    public static Ast getInstance() {
        if (instance == null) {
            synchronized (Ast.class) {
                instance = new Ast();
            }
        }
        return instance;
    }

    private boolean initFile() {
        this.asFile = new File(this.context.getFilesDir(), AS_FILE_NAME);
        this.properties = new Properties();
        if (FileUtil.createFile(this.asFile)) {
            return FileUtil.loadPropertiesFile(this.asFile, this.properties);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netRequest() {
        if (this.properties.size() == 0) {
            return;
        }
        NetUtil.uploadData(new NetUtil.RequestAdapter<Object>() { // from class: com.baidu.pass.face.platform.stat.Ast.2
            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public String getRequestString() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mh", "faceSdkStatistic");
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry entry : ((Properties) Ast.this.properties.clone()).entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (!str.equalsIgnoreCase(Ast.this.faceHitKeyLasttime)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", "facesdk");
                            jSONObject2.put("scene", Ast.this.scene);
                            jSONObject2.put("appid", Ast.this.dev.getPackagename());
                            jSONObject2.put("device", Ast.this.dev.getBrand());
                            jSONObject2.put("imei", Ast.this.dev.getUniqueID());
                            jSONObject2.put(IAdRequestParam.OS, "Android");
                            jSONObject2.put(ConstantHelper.LOG_OS, Ast.this.dev.getSysVersion());
                            jSONObject2.put("version", Ast.this.dev.getSdkVersion());
                            if (str.contains("liveness")) {
                                jSONObject2.put("isliving", "true");
                            } else {
                                jSONObject2.put("isliving", "false");
                            }
                            jSONObject2.put(ConstantHelper.LOG_FINISH, "1");
                            String[] split = str.split("_");
                            if (split.length > 4) {
                                jSONObject2.put(TypeAdapters.AnonymousClass27.YEAR, split[0]);
                                jSONObject2.put(TypeAdapters.AnonymousClass27.MONTH, split[1]);
                                jSONObject2.put(Config.TRACE_VISIT_RECENT_DAY, split[2]);
                                jSONObject2.put("hour", split[3]);
                            }
                            jSONObject2.put("num", str2);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("dt", jSONArray);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }

            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public String getURL() {
                return "https://brain.baidu.com/record/api";
            }

            @Override // com.baidu.pass.face.platform.stat.NetUtil.RequestAdapter
            public void parseResponse(InputStream inputStream) throws IOException, JSONException {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                byteArrayOutputStream.flush();
                if (new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF-8")).optInt("code") == 0) {
                    Ast.this.properties.clear();
                    Ast.this.dev.setFirstRun(false);
                    FileUtil.savePropertiesFile(Ast.this.asFile, Ast.this.properties);
                }
            }
        });
    }

    private void sendData() {
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.baidu.pass.face.platform.stat.Ast.1
            @Override // java.lang.Runnable
            public void run() {
                Ast.this.netRequest();
            }
        });
    }

    public void faceHit(String str, int i2, FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null) {
            this.faceIds.clear();
            return;
        }
        int i3 = 0;
        for (FaceInfo faceInfo : faceInfoArr) {
            if (this.faceIds.get(faceInfo.faceID) == null) {
                SparseArray<Integer> sparseArray = this.faceIds;
                int i4 = faceInfo.faceID;
                sparseArray.put(i4, Integer.valueOf(i4));
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        faceHit(str, i2, i3);
    }

    public void immediatelyUpload() {
        sendData();
    }

    public boolean init(Context context, String str, String str2) {
        if (!this.isInit && context != null) {
            this.context = context.getApplicationContext();
            Dev dev = new Dev();
            this.dev = dev;
            dev.init(context);
            this.dev.setSdkVersion(str);
            this.scene = str2;
            initFile();
        }
        return true;
    }

    public void faceHit() {
        faceHit("liveness", 15000L, 1);
    }

    public void faceHit(String str) {
        faceHit(str, 15000L, 1);
    }

    public void faceHit(String str, int i2) {
        faceHit(str, 15000L, i2);
    }

    public void faceHit(String str, long j, int i2) {
        if (this.properties == null) {
            return;
        }
        String generateFaceHitKey = generateFaceHitKey(str);
        String property = this.properties.getProperty(generateFaceHitKey);
        if (TextUtils.isEmpty(property)) {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(i2));
            this.properties.setProperty(this.faceHitKeyLasttime, String.valueOf(System.currentTimeMillis()));
        } else {
            this.properties.setProperty(generateFaceHitKey, String.valueOf(Integer.parseInt(property) + i2));
        }
        FileUtil.savePropertiesFile(this.asFile, this.properties);
        String property2 = this.properties.getProperty(this.faceHitKeyLasttime);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            currentTimeMillis = Long.parseLong(property2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.dev.getFirstRun() || System.currentTimeMillis() - currentTimeMillis >= j) {
            sendData();
        }
    }
}
