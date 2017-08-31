package com.baidu.sofire.ac;

import android.accounts.NetworkErrorException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.b;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.f;
import com.baidu.sofire.b.i;
import com.baidu.sofire.b.j;
import com.baidu.sofire.b.k;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.e;
import com.baidu.sofire.jni.Asc;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class U extends Thread {
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 3;
    public static final int NETWORK_TYPE_MOBILE = 5;
    public static final int NETWORK_TYPE_UNCONNECTED = -1;
    public static final int NETWORK_TYPE_UNKNOWN = -2;
    public static final int NETWORK_TYPE_WIFI = 4;
    public static final int OUT_AES_FAIL = 8;
    public static final int OUT_FINISH = 1;
    public static final int OUT_NO_INTERNET = 3;
    public static final int OUT_NULL_APPKEY = 5;
    public static final int OUT_NULL_HOST_PKGINFO = 6;
    public static final int OUT_NULL_PLUGIN_JSON = 10;
    public static final int OUT_NULL_RESPONSE_JSON = 9;
    public static final int OUT_OTHER_THROWABLE = 11;
    public static final int OUT_PING_FAIL = 4;
    public static final int OUT_RESPONSE_EMPTY = 7;
    public static final int OUT_TIME_TOO_CLOSE = 2;
    public static final int OUT_UNSET = 0;
    public static final int TYPE_END = 1;
    public static final int TYPE_START = 0;
    public static final int UPGRADE_DECRYPT_FAIL = 7;
    public static final int UPGRADE_DOWNLOAD_FAIL = 4;
    public static final int UPGRADE_ERROR_CRASH_TIMES = 6;
    public static final int UPGRADE_LOAD_FAIL = 5;
    public static final int UPGRADE_MD5_FAIL = 8;
    public static final int UPGRADE_NETWORK_CHECK_FAIL = 3;
    public static final int UPGRADE_RESULT_EXCEPTION = 2;
    public static final int UPGRADE_RESULT_SUCCESS = 1;
    private Context context;
    private c forHostAPP;
    private com.baidu.sofire.a.a loadedPluginDB;
    private Map<Integer, String> mCloudKeyMap;
    List<Integer> mDownloadPluginsList;
    private int mEndReason;
    private int mFrom;
    private boolean mOut;
    private Map<Integer, String> mStartKeyMap;
    private int mStartNetwork;
    List<Integer> mUnloadPluginsList;
    private Map<Integer, a> mUpgradeResultMap;
    private e preference;
    private File tmpDir;
    private static long sLastCheckTime = 0;
    private static volatile boolean sOutGoing = false;
    private static boolean sPidRegister = false;
    public static boolean sMonitorNetworkWhenUpgradeNoNet = false;
    private static int sRetryPingTimesCount = 0;
    private static int sRetryDownoadHostCareApksTimesCount = 0;
    private static boolean sSetRetrmAlarm = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        int a;
        int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public U(Context context, int i, boolean z) {
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
        this.context = context;
        this.loadedPluginDB = com.baidu.sofire.a.a.an(context);
        this.preference = new e(context);
        this.forHostAPP = c.ap(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.mFrom = i;
        this.mOut = z;
    }

    public U() {
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
    }

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = com.baidu.sofire.a.a.an(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp");
        this.forHostAPP = c.ap(context);
        this.mFrom = intent.getIntExtra("from", 0);
        b.a();
        start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [736=4, 737=4, 739=4] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r13v0 java.util.List<com.baidu.sofire.core.ApkInfo>)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r14v0 java.util.ArrayList)] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ea A[Catch: Throwable -> 0x046e, TRY_ENTER, TryCatch #8 {, blocks: (B:13:0x0013, B:15:0x0020, B:17:0x0027, B:19:0x002e, B:21:0x0034, B:23:0x0042, B:25:0x0048, B:26:0x0053, B:42:0x006f, B:44:0x0079, B:45:0x007f, B:46:0x009e, B:48:0x00a4, B:50:0x00ae, B:52:0x00c0, B:75:0x010d, B:77:0x0114, B:80:0x012d, B:82:0x0134, B:83:0x0137, B:85:0x0141, B:87:0x0148, B:89:0x014f, B:95:0x0180, B:97:0x0186, B:98:0x018b, B:99:0x0193, B:91:0x0156, B:93:0x0168, B:94:0x0173, B:100:0x0194, B:102:0x019e, B:104:0x01a2, B:108:0x01b4, B:111:0x01e4, B:114:0x01f8, B:116:0x01fe, B:118:0x0205, B:120:0x020c, B:122:0x0213, B:127:0x0238, B:129:0x0244, B:130:0x024f, B:132:0x0265, B:133:0x026a, B:134:0x0272, B:141:0x0286, B:124:0x0217, B:126:0x0225, B:142:0x028c, B:163:0x02e3, B:165:0x02fc, B:166:0x030b, B:168:0x0335, B:170:0x0339, B:172:0x0342, B:174:0x034b, B:175:0x0351, B:177:0x037b, B:219:0x049e, B:223:0x0511, B:225:0x052b, B:227:0x052f, B:229:0x0534, B:233:0x055a, B:235:0x0560, B:255:0x0626, B:236:0x0589, B:238:0x05b9, B:240:0x05d1, B:241:0x05da, B:242:0x05fa, B:244:0x0600, B:249:0x0615, B:266:0x0661, B:268:0x069d, B:269:0x06cc, B:273:0x070d, B:275:0x0713, B:276:0x0719, B:277:0x0721, B:280:0x0728, B:282:0x0761, B:286:0x076d, B:287:0x077f, B:289:0x0788, B:291:0x078e, B:292:0x0794, B:293:0x079c, B:294:0x079d, B:296:0x07a3, B:297:0x07a7, B:299:0x07ad, B:301:0x07d1, B:302:0x07dc, B:304:0x07f9, B:306:0x07ff, B:307:0x0804, B:310:0x0812, B:313:0x081f, B:315:0x082a, B:317:0x083f, B:320:0x0856, B:353:0x0978, B:356:0x0980, B:358:0x0998, B:361:0x09a5, B:363:0x09a9, B:364:0x09ab, B:366:0x09b6, B:367:0x09c8, B:369:0x09d3, B:371:0x09dd, B:373:0x09e7, B:375:0x09ef, B:377:0x09f9, B:378:0x0a08, B:380:0x0a0e, B:391:0x0a42, B:392:0x0a49, B:394:0x0a74, B:396:0x0a84, B:398:0x0a88, B:400:0x0a8c, B:402:0x0a9a, B:404:0x0aa0, B:405:0x0aa7, B:407:0x0aad, B:408:0x0ab8, B:410:0x0ac4, B:412:0x0acd, B:413:0x0ada, B:414:0x0adf, B:416:0x0ae5, B:417:0x0af4, B:419:0x0afa, B:420:0x0b01, B:421:0x0b05, B:423:0x0b0e, B:424:0x0b1d, B:426:0x0b21, B:427:0x0b26, B:428:0x0b39, B:430:0x0b3f, B:432:0x0b4f, B:434:0x0b55, B:435:0x0b62, B:436:0x0b6c, B:437:0x0b9f, B:439:0x0ba5, B:441:0x0baf, B:442:0x0bb6, B:443:0x0bb9, B:444:0x0bd0, B:446:0x0bd6, B:448:0x0be2, B:450:0x0bea, B:452:0x0bfa, B:454:0x0c10, B:455:0x0c13, B:457:0x0c41, B:458:0x0c44, B:459:0x0c47, B:460:0x0c53, B:461:0x0c58, B:463:0x0c5e, B:465:0x0c6a, B:466:0x0c70, B:263:0x0654, B:256:0x063a, B:258:0x0640, B:259:0x0645, B:260:0x064d, B:179:0x0381, B:181:0x0387, B:182:0x038c, B:183:0x0394, B:79:0x011b, B:271:0x0706, B:237:0x05b5, B:221:0x050b, B:113:0x01ea, B:143:0x0293, B:145:0x029f, B:147:0x02a3, B:149:0x02ac, B:151:0x02b5, B:152:0x02bb, B:154:0x02c2, B:156:0x02cb, B:158:0x02d1, B:184:0x0395, B:188:0x03b1, B:190:0x03bb, B:192:0x03bf, B:194:0x03c4, B:198:0x03ea, B:200:0x03f0, B:201:0x0413, B:203:0x045f, B:205:0x0465, B:215:0x0481, B:213:0x047b, B:216:0x048b, B:211:0x0475, B:324:0x0862, B:326:0x0895, B:328:0x08a2, B:329:0x08bb, B:331:0x08d3, B:333:0x08d9, B:334:0x08e0, B:382:0x0a1e, B:384:0x0a24, B:348:0x096f, B:106:0x01a6, B:357:0x098d, B:110:0x01d6, B:246:0x060d, B:231:0x053b), top: B:512:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0481 A[Catch: Throwable -> 0x046e, TryCatch #8 {, blocks: (B:13:0x0013, B:15:0x0020, B:17:0x0027, B:19:0x002e, B:21:0x0034, B:23:0x0042, B:25:0x0048, B:26:0x0053, B:42:0x006f, B:44:0x0079, B:45:0x007f, B:46:0x009e, B:48:0x00a4, B:50:0x00ae, B:52:0x00c0, B:75:0x010d, B:77:0x0114, B:80:0x012d, B:82:0x0134, B:83:0x0137, B:85:0x0141, B:87:0x0148, B:89:0x014f, B:95:0x0180, B:97:0x0186, B:98:0x018b, B:99:0x0193, B:91:0x0156, B:93:0x0168, B:94:0x0173, B:100:0x0194, B:102:0x019e, B:104:0x01a2, B:108:0x01b4, B:111:0x01e4, B:114:0x01f8, B:116:0x01fe, B:118:0x0205, B:120:0x020c, B:122:0x0213, B:127:0x0238, B:129:0x0244, B:130:0x024f, B:132:0x0265, B:133:0x026a, B:134:0x0272, B:141:0x0286, B:124:0x0217, B:126:0x0225, B:142:0x028c, B:163:0x02e3, B:165:0x02fc, B:166:0x030b, B:168:0x0335, B:170:0x0339, B:172:0x0342, B:174:0x034b, B:175:0x0351, B:177:0x037b, B:219:0x049e, B:223:0x0511, B:225:0x052b, B:227:0x052f, B:229:0x0534, B:233:0x055a, B:235:0x0560, B:255:0x0626, B:236:0x0589, B:238:0x05b9, B:240:0x05d1, B:241:0x05da, B:242:0x05fa, B:244:0x0600, B:249:0x0615, B:266:0x0661, B:268:0x069d, B:269:0x06cc, B:273:0x070d, B:275:0x0713, B:276:0x0719, B:277:0x0721, B:280:0x0728, B:282:0x0761, B:286:0x076d, B:287:0x077f, B:289:0x0788, B:291:0x078e, B:292:0x0794, B:293:0x079c, B:294:0x079d, B:296:0x07a3, B:297:0x07a7, B:299:0x07ad, B:301:0x07d1, B:302:0x07dc, B:304:0x07f9, B:306:0x07ff, B:307:0x0804, B:310:0x0812, B:313:0x081f, B:315:0x082a, B:317:0x083f, B:320:0x0856, B:353:0x0978, B:356:0x0980, B:358:0x0998, B:361:0x09a5, B:363:0x09a9, B:364:0x09ab, B:366:0x09b6, B:367:0x09c8, B:369:0x09d3, B:371:0x09dd, B:373:0x09e7, B:375:0x09ef, B:377:0x09f9, B:378:0x0a08, B:380:0x0a0e, B:391:0x0a42, B:392:0x0a49, B:394:0x0a74, B:396:0x0a84, B:398:0x0a88, B:400:0x0a8c, B:402:0x0a9a, B:404:0x0aa0, B:405:0x0aa7, B:407:0x0aad, B:408:0x0ab8, B:410:0x0ac4, B:412:0x0acd, B:413:0x0ada, B:414:0x0adf, B:416:0x0ae5, B:417:0x0af4, B:419:0x0afa, B:420:0x0b01, B:421:0x0b05, B:423:0x0b0e, B:424:0x0b1d, B:426:0x0b21, B:427:0x0b26, B:428:0x0b39, B:430:0x0b3f, B:432:0x0b4f, B:434:0x0b55, B:435:0x0b62, B:436:0x0b6c, B:437:0x0b9f, B:439:0x0ba5, B:441:0x0baf, B:442:0x0bb6, B:443:0x0bb9, B:444:0x0bd0, B:446:0x0bd6, B:448:0x0be2, B:450:0x0bea, B:452:0x0bfa, B:454:0x0c10, B:455:0x0c13, B:457:0x0c41, B:458:0x0c44, B:459:0x0c47, B:460:0x0c53, B:461:0x0c58, B:463:0x0c5e, B:465:0x0c6a, B:466:0x0c70, B:263:0x0654, B:256:0x063a, B:258:0x0640, B:259:0x0645, B:260:0x064d, B:179:0x0381, B:181:0x0387, B:182:0x038c, B:183:0x0394, B:79:0x011b, B:271:0x0706, B:237:0x05b5, B:221:0x050b, B:113:0x01ea, B:143:0x0293, B:145:0x029f, B:147:0x02a3, B:149:0x02ac, B:151:0x02b5, B:152:0x02bb, B:154:0x02c2, B:156:0x02cb, B:158:0x02d1, B:184:0x0395, B:188:0x03b1, B:190:0x03bb, B:192:0x03bf, B:194:0x03c4, B:198:0x03ea, B:200:0x03f0, B:201:0x0413, B:203:0x045f, B:205:0x0465, B:215:0x0481, B:213:0x047b, B:216:0x048b, B:211:0x0475, B:324:0x0862, B:326:0x0895, B:328:0x08a2, B:329:0x08bb, B:331:0x08d3, B:333:0x08d9, B:334:0x08e0, B:382:0x0a1e, B:384:0x0a24, B:348:0x096f, B:106:0x01a6, B:357:0x098d, B:110:0x01d6, B:246:0x060d, B:231:0x053b), top: B:512:0x0013 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void run() {
        PublicKey publicKey;
        String str;
        String str2;
        try {
            if (this.mOut) {
                if (!sOutGoing) {
                    sOutGoing = true;
                }
            }
            synchronized (U.class) {
                super.run();
                handleThreadStart();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3 || this.mOut || System.currentTimeMillis() - sLastCheckTime >= 600000) {
                    if (d.d(this.context)) {
                        sLastCheckTime = System.currentTimeMillis();
                    }
                    com.baidu.sofire.b.b.a(this.context, false);
                    Context context = this.context;
                    com.baidu.sofire.a.a an = com.baidu.sofire.a.a.an(context);
                    c ap = c.ap(context);
                    b.a();
                    for (ApkInfo apkInfo : an.a()) {
                        if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                            ap.a(apkInfo.packageName);
                        }
                    }
                    if (this.mFrom == 1 || this.mFrom == 3) {
                        sRetryPingTimesCount = 0;
                        sRetryDownoadHostCareApksTimesCount = 0;
                        com.baidu.sofire.b.b.b(this.context, 0, true);
                        sSetRetrmAlarm = false;
                    }
                    if (this.mFrom == 2) {
                        sSetRetrmAlarm = false;
                    }
                    if (!d.d(this.context)) {
                        if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                            b.a();
                            sMonitorNetworkWhenUpgradeNoNet = true;
                            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                            if (d.Px == null) {
                                d.Px = new MyReceiver().a();
                            }
                            this.context.getApplicationContext().registerReceiver(d.Px, intentFilter);
                        }
                        if (this.mEndReason == 0) {
                            this.mEndReason = 3;
                        }
                        throw new NetworkErrorException("no internet");
                    }
                    sLastCheckTime = System.currentTimeMillis();
                    if (d.Px != null && (sMonitorNetworkWhenUpgradeNoNet || d.a)) {
                        this.context.getApplicationContext().unregisterReceiver(d.Px);
                    }
                    sMonitorNetworkWhenUpgradeNoNet = false;
                    d.a = false;
                    StringBuilder sb = new StringBuilder();
                    Context context2 = this.context;
                    String sb2 = sb.append(d.a()).append("opmon").toString();
                    if (TextUtils.isEmpty(new i(this.context, (byte) 0).a(sb2)) && TextUtils.isEmpty(new i(this.context, (byte) 0).a(sb2))) {
                        if ((this.mFrom == 1 || this.mFrom == 2 || (this.mFrom == 3 && !sSetRetrmAlarm)) && this.preference.b().size() > 0) {
                            sSetRetrmAlarm = true;
                            com.baidu.sofire.b.b.b(this.context, sRetryPingTimesCount, false);
                            sRetryPingTimesCount++;
                        }
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (d.Px == null) {
                            d.Px = new MyReceiver().a();
                        } else {
                            d.Px.a();
                        }
                        this.context.getApplicationContext().registerReceiver(d.Px, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                        if (this.mEndReason == 0) {
                            this.mEndReason = 4;
                        }
                        throw new NetworkErrorException("ping faild");
                    }
                    sRetryPingTimesCount = 0;
                    Context context3 = this.context;
                    String[] e = d.e(context3);
                    String str3 = "";
                    String str4 = "";
                    if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                        str3 = e[0];
                        str4 = e[1];
                    }
                    boolean z = false;
                    if (TextUtils.isEmpty(str3) || TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equals(str3) || TextUtils.isEmpty(str4) || "925fc15df8a49bed0b3eca8d2b44cb7b".equals(str4)) {
                        str3 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                        str4 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                        z = true;
                    }
                    if (z) {
                        JSONObject jSONObject = new JSONObject();
                        String packageName = context3.getPackageName();
                        jSONObject.put("pk", packageName);
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = context3.getPackageManager().getPackageInfo(packageName, 64);
                        } catch (Throwable th) {
                            d.a(th);
                        }
                        if (packageInfo != null) {
                            PublicKey bR = com.baidu.sofire.b.c.bR(packageInfo.applicationInfo.sourceDir);
                            if (bR == null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
                                try {
                                    publicKey = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                                if (publicKey == null) {
                                    byte[] encoded = publicKey.getEncoded();
                                    if (encoded != null) {
                                        jSONObject.put("sm", j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                                    }
                                } else {
                                    jSONObject.put("sm", "");
                                }
                            }
                            publicKey = bR;
                            if (publicKey == null) {
                            }
                        } else {
                            jSONObject.put("sm", "");
                        }
                        String jSONObject2 = jSONObject.toString();
                        b.a();
                        String a2 = f.a(context3, d.a() + "plugin/v1/product/key", jSONObject2, str3, str4, false);
                        String str5 = a2;
                        b.a();
                        JSONObject jSONObject3 = new JSONObject(a2);
                        String optString = jSONObject3.optString("ak");
                        String optString2 = jSONObject3.optString("sk");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            c.ap(context3).a(optString, optString2);
                        }
                    }
                    this.forHostAPP.b(this.context);
                    String a3 = this.preference.a();
                    if (TextUtils.isEmpty(a3)) {
                        k.a(this.context);
                        a3 = this.preference.a();
                    }
                    String str6 = "l:" + a3;
                    b.a();
                    k.b(this.context);
                    this.loadedPluginDB.d();
                    String[] e2 = d.e(this.context);
                    if (e2 == null || e2.length != 2 || TextUtils.isEmpty(e2[0]) || TextUtils.isEmpty(e2[1])) {
                        str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                        str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                    } else {
                        str = e2[0];
                        str2 = e2[1];
                    }
                    String str7 = "a:" + str;
                    b.a();
                    String str8 = "s:" + str2;
                    b.a();
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 5;
                        }
                        throw new NetworkErrorException("appkey or secretKey is null");
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    String packageName2 = this.context.getPackageName();
                    jSONObject6.put("pk", packageName2);
                    jSONObject5.put("pk", packageName2);
                    jSONObject5.put("dm", Build.MODEL);
                    jSONObject6.put("dm", Build.MODEL);
                    jSONObject5.put("cuid", com.baidu.sofire.b.e.a(this.context));
                    jSONObject5.put("al", String.valueOf(Build.VERSION.SDK_INT));
                    jSONObject6.put("al", String.valueOf(Build.VERSION.SDK_INT));
                    jSONObject5.put("ev", "2.0.8");
                    PackageInfo packageInfo2 = this.context.getPackageManager().getPackageInfo(packageName2, 64);
                    if (packageInfo2 == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 6;
                        }
                        throw new NetworkErrorException("hostPkgInfo is null");
                    }
                    jSONObject5.put("av", packageInfo2.versionName);
                    jSONObject6.put("av", packageInfo2.versionName);
                    PublicKey bR2 = com.baidu.sofire.b.c.bR(packageInfo2.applicationInfo.sourceDir);
                    PublicKey publicKey2 = (bR2 != null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0 || packageInfo2.signatures[0] == null) ? bR2 : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo2.signatures[0].toByteArray())).getPublicKey();
                    if (publicKey2 != null) {
                        byte[] encoded2 = publicKey2.getEncoded();
                        if (encoded2 != null) {
                            String a4 = j.a(Base64.encodeToString(encoded2, 0).replace("\n", "").replace("\r", ""));
                            jSONObject5.put("sm", a4);
                            jSONObject6.put("sm", a4);
                        } else {
                            jSONObject5.put("sm", "");
                            jSONObject6.put("sm", "");
                        }
                    }
                    jSONObject5.put("or", this.preference.a.getInt("opi", 0));
                    jSONObject5.put("pt", this.preference.a.getLong("lslt", 0L));
                    String nx = Asc.nx();
                    String str9 = "mt=" + nx;
                    b.a();
                    if (TextUtils.isEmpty(nx)) {
                        jSONObject5.put("mt", "");
                    } else {
                        jSONObject5.put("mt", nx);
                    }
                    jSONObject4.put("device", jSONObject5);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject6);
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(k.a);
                    for (String str10 : hashMap.keySet()) {
                        JSONObject jSONObject7 = new JSONObject((String) hashMap.get(str10));
                        if (jSONObject7 != null) {
                            jSONArray.put(jSONObject7);
                        }
                    }
                    jSONObject4.put("host_apps", jSONArray);
                    String jSONObject8 = jSONObject4.toString();
                    String str11 = "p:" + jSONObject8;
                    b.a();
                    StringBuilder sb3 = new StringBuilder();
                    Context context4 = this.context;
                    String sb4 = sb3.append(d.a()).append("plugin/v1/plugins").toString();
                    if (!sPidRegister) {
                        e eVar = this.preference;
                        eVar.PP.putInt("pdcg", this.preference.a.getInt("pdcg", 0) + 1);
                        eVar.PP.commit();
                        this.preference.a(System.currentTimeMillis());
                        sPidRegister = true;
                    }
                    e eVar2 = this.preference;
                    eVar2.PP.putInt("rtqe", this.preference.a.getInt("rtqe", 0) + 1);
                    eVar2.PP.commit();
                    String a5 = f.a(this.context, sb4, jSONObject8, str, str2, true);
                    String str12 = a5;
                    b.a();
                    JSONObject jSONObject9 = new JSONObject(a5);
                    if (jSONObject9 == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 9;
                        }
                        throw new NetworkErrorException("response json is null");
                    }
                    List<ApkInfo> a6 = this.loadedPluginDB.a();
                    String str13 = "a=" + a6;
                    b.a();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    JSONArray optJSONArray = jSONObject9.optJSONArray("product");
                    long optLong = jSONObject9.optLong("pt");
                    if (optJSONArray != null && optJSONArray.length() > 0 && optLong > 0) {
                        this.preference.a(optJSONArray.toString(), optLong);
                        d.f(this.context);
                    }
                    JSONObject optJSONObject = jSONObject9.optJSONObject("plugin");
                    if (optJSONObject == null) {
                        if (this.mEndReason == 0) {
                            this.mEndReason = 10;
                        }
                        throw new NetworkErrorException("plugin json is null");
                    }
                    if (optJSONObject instanceof JSONObject) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            int optInt = optJSONObject2.optInt("l");
                            String optString3 = optJSONObject2.optString("v");
                            if (this.mCloudKeyMap != null) {
                                this.mCloudKeyMap.put(Integer.valueOf(optInt), optString3);
                            }
                            String optString4 = optJSONObject2.optString("u");
                            String optString5 = optJSONObject2.optString("m");
                            String optString6 = optJSONObject2.optString("sm");
                            if (optString5 != null) {
                                optString5 = optString5.toLowerCase();
                            }
                            String lowerCase = optString6 != null ? optString6.toLowerCase() : optString6;
                            boolean z2 = optJSONObject2.optInt("o") == 1;
                            boolean z3 = optJSONObject2.optInt("d") == 1;
                            int optInt2 = optJSONObject2.optInt("r");
                            if (z2) {
                                e eVar3 = this.preference;
                                if (optInt2 > eVar3.a.getInt("opi", 0)) {
                                    eVar3.PP.putInt("opi", optInt2);
                                    eVar3.PP.commit();
                                }
                            }
                            if (z2 && z3) {
                                arrayList3.add(next);
                            } else {
                                PackageInfo packageInfo3 = new PackageInfo();
                                packageInfo3.packageName = optJSONObject2.optString("p");
                                packageInfo3.versionName = optJSONObject2.optString("v");
                                ApplicationInfo applicationInfo = new ApplicationInfo();
                                applicationInfo.className = optJSONObject2.optString("n");
                                if (!TextUtils.isEmpty(applicationInfo.className) && applicationInfo.className.startsWith(".")) {
                                    applicationInfo.className = next + applicationInfo.className;
                                }
                                applicationInfo.theme = optJSONObject2.optInt(Info.kBaiduTimeKey);
                                packageInfo3.applicationInfo = applicationInfo;
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("a");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList4 = new ArrayList();
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= optJSONArray2.length()) {
                                            break;
                                        }
                                        try {
                                            JSONObject jSONObject10 = optJSONArray2.getJSONObject(i2);
                                            if (jSONObject10 != null) {
                                                ActivityInfo activityInfo = new ActivityInfo();
                                                activityInfo.name = jSONObject10.optString("n");
                                                if (!TextUtils.isEmpty(activityInfo.name) && activityInfo.name.startsWith(".")) {
                                                    activityInfo.name = next + activityInfo.name;
                                                }
                                                activityInfo.packageName = next;
                                                activityInfo.theme = jSONObject10.optInt(Info.kBaiduTimeKey);
                                                activityInfo.labelRes = jSONObject10.optInt("l");
                                                if (!TextUtils.isEmpty(activityInfo.name)) {
                                                    arrayList4.add(activityInfo);
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            d.a(th3);
                                        }
                                        i = i2 + 1;
                                    }
                                    if (arrayList4.size() > 0) {
                                        packageInfo3.activities = (ActivityInfo[]) arrayList4.toArray(new ActivityInfo[arrayList4.size()]);
                                    }
                                }
                                ApkInfo apkInfo2 = new ApkInfo(optInt, next, optString3, optString4, optString5);
                                apkInfo2.isOnce = z2 ? 1 : 0;
                                apkInfo2.runStatus = optJSONObject2.optInt("s");
                                apkInfo2.priority = optJSONObject2.getInt("pr");
                                apkInfo2.isMem = optJSONObject2.optInt("mem") == 1;
                                if (packageInfo3 != null) {
                                    apkInfo2.cloudPkgInfo = packageInfo3;
                                }
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("e");
                                if (optJSONObject3 != null) {
                                    int optInt3 = optJSONObject3.optInt("d");
                                    int optInt4 = optJSONObject3.optInt("n");
                                    apkInfo2.duration = optInt3;
                                    apkInfo2.network = optInt4;
                                }
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ext");
                                if (optJSONObject4 != null && optJSONObject4.optInt("a") == 1) {
                                    List<Integer> b = this.preference.b();
                                    ArrayList arrayList5 = b == null ? new ArrayList() : b;
                                    if (optInt > 0 && !arrayList5.contains(Integer.valueOf(optInt))) {
                                        arrayList5.add(Integer.valueOf(optInt));
                                        int[] iArr = new int[arrayList5.size()];
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= arrayList5.size()) {
                                                break;
                                            }
                                            iArr[i4] = arrayList5.get(i4).intValue();
                                            i3 = i4 + 1;
                                        }
                                        this.preference.c(iArr);
                                    }
                                }
                                apkInfo2.signMD5 = lowerCase;
                                apkInfo2.startTime = System.currentTimeMillis();
                                int indexOf = a6.indexOf(apkInfo2);
                                String str14 = "t=" + apkInfo2 + ", i=" + indexOf;
                                b.a();
                                if (indexOf >= 0) {
                                    ApkInfo apkInfo3 = a6.get(indexOf);
                                    if (!d.c(apkInfo2.versionName, apkInfo3.versionName) || (c.a != null && (c.a == null || c.a.contains(Integer.valueOf(apkInfo2.key))))) {
                                        if (apkInfo3.priority != apkInfo2.priority) {
                                            apkInfo3.priority = apkInfo2.priority;
                                            this.loadedPluginDB.b(apkInfo2.key, apkInfo2.priority);
                                        }
                                        if (apkInfo3.runStatus != apkInfo2.runStatus) {
                                            updateRunStatus(apkInfo3, apkInfo2.runStatus);
                                        }
                                        arrayList.add(apkInfo3);
                                    } else {
                                        if (apkInfo3.runStatus != apkInfo2.runStatus) {
                                            updateRunStatus(apkInfo3, apkInfo2.runStatus);
                                        }
                                        if (apkInfo3.priority != apkInfo2.priority) {
                                            this.loadedPluginDB.b(apkInfo2.key, apkInfo2.priority);
                                        }
                                        if (!this.loadedPluginDB.aV(apkInfo3.key)) {
                                            arrayList2.add(apkInfo2);
                                            if (this.mDownloadPluginsList != null) {
                                                this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                            }
                                        }
                                    }
                                    a6.remove(indexOf);
                                } else {
                                    arrayList2.add(apkInfo2);
                                    if (this.mDownloadPluginsList != null) {
                                        this.mDownloadPluginsList.add(Integer.valueOf(apkInfo2.key));
                                    }
                                }
                            }
                        }
                    }
                    if (c.a != null) {
                        c.a.clear();
                    }
                    new StringBuilder().append(a6).toString();
                    b.a();
                    for (ApkInfo apkInfo4 : a6) {
                        if (!arrayList3.contains(apkInfo4.packageName)) {
                            if (this.mUnloadPluginsList != null) {
                                this.mUnloadPluginsList.add(Integer.valueOf(apkInfo4.key));
                            }
                            this.forHostAPP.a(apkInfo4.packageName);
                        }
                    }
                    d.a(this.context);
                    new StringBuilder().append(arrayList).toString();
                    b.a();
                    com.baidu.sofire.core.e aq = com.baidu.sofire.core.e.aq(this.context.getApplicationContext());
                    final List<Integer> c = this.preference.c();
                    List<Integer> b2 = this.preference.b();
                    for (int i5 = 0; i5 < b2.size(); i5++) {
                        if (!c.contains(b2.get(i5))) {
                            c.add(b2.get(i5));
                        }
                    }
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.addAll(arrayList);
                    arrayList6.addAll(arrayList2);
                    Collections.sort(arrayList6, new Comparator<ApkInfo>() { // from class: com.baidu.sofire.ac.U.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(ApkInfo apkInfo5, ApkInfo apkInfo6) {
                            ApkInfo apkInfo7 = apkInfo5;
                            ApkInfo apkInfo8 = apkInfo6;
                            if (apkInfo7.priority != -1 || apkInfo8.priority == -1) {
                                if ((apkInfo7.priority == -1 || apkInfo8.priority != -1) && apkInfo7.priority >= apkInfo8.priority) {
                                    if (apkInfo7.priority > apkInfo8.priority) {
                                        return 1;
                                    }
                                    int indexOf2 = (c == null || !c.contains(Integer.valueOf(apkInfo7.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo7.key));
                                    int indexOf3 = (c == null || !c.contains(Integer.valueOf(apkInfo8.key))) ? -1 : c.indexOf(Integer.valueOf(apkInfo8.key));
                                    if (indexOf2 == -1 || indexOf3 != -1) {
                                        if ((indexOf2 != -1 || indexOf3 == -1) && indexOf2 <= indexOf3) {
                                            return indexOf2 >= indexOf3 ? 0 : -1;
                                        }
                                        return 1;
                                    }
                                    return -1;
                                }
                                return -1;
                            }
                            return 1;
                        }
                    });
                    for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                        ApkInfo apkInfo5 = (ApkInfo) arrayList6.get(i6);
                        if (arrayList.contains(apkInfo5)) {
                            if (aq.bT(apkInfo5.packageName) == null) {
                                if (this.preference.a.getBoolean("bka", true)) {
                                    File file = new File(this.context.getFilesDir(), ".b");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    File file2 = new File(apkInfo5.pkgPath);
                                    File file3 = new File(file, apkInfo5.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo5.versionName);
                                    if (!d.o(file3)) {
                                        d.a(file2, file3);
                                    }
                                    com.baidu.sofire.c.a(file2, file3);
                                }
                                this.forHostAPP.a(apkInfo5.key, apkInfo5.versionName, null);
                            }
                        } else if (arrayList2.contains(apkInfo5) && !this.loadedPluginDB.aV(apkInfo5.key)) {
                            handlePluginUpgrade(apkInfo5);
                        }
                    }
                    if (this.mEndReason == 0) {
                        this.mEndReason = 1;
                    }
                    handleThreadEnd(null);
                    if (this.mOut && sOutGoing) {
                        sOutGoing = false;
                    }
                } else {
                    if (this.mEndReason == 0) {
                        this.mEndReason = 2;
                        handleThreadEnd(null);
                    }
                    if (this.mOut && sOutGoing) {
                        sOutGoing = false;
                    }
                }
            }
        }
    }

    private void handleThreadEnd(String str) {
        try {
            e eVar = this.preference;
            eVar.PP.putInt("sufzfd", this.preference.a.getInt("sufzfd", 0) + 1);
            eVar.PP.commit();
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        try {
            HashMap hashMap = new HashMap();
            if (this.mStartKeyMap != null) {
                hashMap.put("1", this.mStartKeyMap.keySet());
                hashMap.put("2", this.mStartKeyMap.values());
            }
            hashMap.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Integer.valueOf(this.mFrom));
            if (this.mCloudKeyMap != null) {
                hashMap.put("4", this.mCloudKeyMap.keySet());
                hashMap.put("5", this.mCloudKeyMap.values());
            }
            if (this.mUnloadPluginsList != null) {
                hashMap.put("6", this.mUnloadPluginsList);
            }
            if (this.mDownloadPluginsList != null) {
                hashMap.put(NewWriteModel.THREAD_TYPE_LBS, this.mDownloadPluginsList);
            }
            if (this.mUpgradeResultMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Integer, a> entry : this.mUpgradeResultMap.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    int intValue = entry.getKey().intValue();
                    a value = entry.getValue();
                    if (value != null) {
                        jSONObject2.put("1", value.a);
                        jSONObject2.put("0", value.b);
                    }
                    jSONObject.put(String.valueOf(intValue), jSONObject2);
                }
                hashMap.put("8", jSONObject);
            }
            Map<Integer, String> nl = this.loadedPluginDB.nl();
            if (nl != null) {
                hashMap.put("9", nl.keySet());
                hashMap.put("10", nl.values());
            }
            hashMap.put("11", Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("12", str.replace("\n", "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put("13", Integer.valueOf(this.mStartNetwork));
            hashMap.put("14", Integer.valueOf(d.ao(this.context)));
            d.a(this.context, "1003129", hashMap);
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    private void handleThreadStart() {
        try {
            long j = this.preference.a.getLong("slruct", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0 && currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("1", Integer.valueOf(this.preference.a.getInt("sustfd", 0)));
                e eVar = this.preference;
                eVar.PP.putInt("sustfd", 0);
                eVar.PP.commit();
                JSONObject jSONObject = new JSONObject();
                for (int i = 1; i <= 6; i++) {
                    jSONObject.put(String.valueOf(i), this.preference.a(0, i));
                    this.preference.a(0, i, 0);
                }
                hashMap.put("2", jSONObject);
                hashMap.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, Integer.valueOf(this.preference.a.getInt("sufzfd", 0)));
                e eVar2 = this.preference;
                eVar2.PP.putInt("sufzfd", 0);
                eVar2.PP.commit();
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 1; i2 <= 11; i2++) {
                    jSONObject2.put(String.valueOf(i2), this.preference.a(1, i2));
                    this.preference.a(1, i2, 0);
                }
                hashMap.put("4", jSONObject2);
                d.a(this.context, "1003128", hashMap);
                e eVar3 = this.preference;
                eVar3.PP.putLong("slruct", currentTimeMillis);
                eVar3.PP.commit();
            } else if (j == 0) {
                e eVar4 = this.preference;
                eVar4.PP.putLong("slruct", currentTimeMillis);
                eVar4.PP.commit();
            }
        } catch (Throwable th) {
            try {
                e eVar5 = this.preference;
                eVar5.PP.putInt("sustfd", 0);
                eVar5.PP.commit();
                e eVar6 = this.preference;
                eVar6.PP.putInt("sufzfd", 0);
                eVar6.PP.commit();
                for (int i3 = 1; i3 <= 6; i3++) {
                    this.preference.a(0, i3, 0);
                }
                for (int i4 = 1; i4 <= 11; i4++) {
                    this.preference.a(1, i4, 0);
                }
            } catch (Throwable th2) {
                d.a(th2);
            }
            d.a(th);
        }
        try {
            this.mStartKeyMap = this.loadedPluginDB.nl();
            e eVar7 = this.preference;
            eVar7.PP.putInt("sustfd", this.preference.a.getInt("sustfd", 0) + 1);
            eVar7.PP.commit();
            if (this.mFrom != 0) {
                this.preference.a(0, this.mFrom, this.preference.a(0, this.mFrom) + 1);
            }
            this.mStartNetwork = d.ao(this.context);
        } catch (Throwable th3) {
            d.a(th3);
        }
    }

    private void updateRunStatus(ApkInfo apkInfo, int i) {
        com.baidu.sofire.a.a aVar = this.loadedPluginDB;
        int i2 = apkInfo.key;
        ContentValues contentValues = new ContentValues();
        contentValues.put("rs", Integer.valueOf(i));
        try {
            aVar.Ps.update("pgn", contentValues, "k=" + i2, null);
        } catch (Throwable th) {
            d.a(th);
        }
        this.forHostAPP.a(apkInfo.key, "setRunStatus", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v55 boolean)] */
    private void handlePluginUpgrade(ApkInfo apkInfo) {
        try {
            int ao = d.ao(this.context);
            String str = "a=" + apkInfo;
            b.a();
            List<Integer> b = this.preference.b();
            if ((b == null || !b.contains(Integer.valueOf(apkInfo.key))) && !d.h(this.context, apkInfo.network)) {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 3));
                    return;
                }
                return;
            }
            if (!this.tmpDir.exists()) {
                this.tmpDir.mkdir();
            }
            StringBuilder sb = new StringBuilder("before update, time=" + System.currentTimeMillis() + ", ");
            ApkInfo aT = this.loadedPluginDB.aT(apkInfo.key);
            if (aT == null) {
                sb.append("apkInDB == null");
            } else {
                File file = new File(aT.pkgPath);
                sb.append("origAPK path:" + file.getAbsolutePath() + ", exists=" + file.exists() + ", canRead=" + file.canRead() + ", isFile=" + file.isFile() + ",length" + file.length());
            }
            File file2 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".tmp");
            File file3 = new File(this.tmpDir, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName + ".zip");
            boolean b2 = new i(this.context).b(apkInfo.downloadURL, file2);
            String str2 = "s: " + b2;
            b.a();
            if (b2) {
                if (file3.exists()) {
                    b.a();
                    file3.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                if (com.baidu.sofire.b.a.a(file2, file3, bytes) != 0) {
                    b.a();
                    if (file3.exists()) {
                        file3.delete();
                    }
                    if (asc.df(file2.getAbsolutePath(), file3.getAbsolutePath(), bytes) != 0) {
                        b.a();
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 7));
                        }
                        b2 = false;
                    }
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 4));
            }
            new StringBuilder().append(b2).toString();
            b.a();
            String a2 = j.a(file3);
            String str3 = "ds=" + b2 + ", fm=" + apkInfo.apkMD5 + ", am=" + a2;
            b.a();
            file2.delete();
            if (b2 && apkInfo.apkMD5.equals(a2)) {
                d.a(file3.getAbsolutePath(), true);
                if (this.preference.a.getBoolean("bka", true)) {
                    File file4 = new File(this.context.getFilesDir(), ".b");
                    if (!file4.exists()) {
                        file4.mkdir();
                    }
                    File file5 = new File(file4, apkInfo.key + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apkInfo.versionName);
                    d.a(file3, file5);
                    com.baidu.sofire.c.a(file3, file5);
                }
                apkInfo.pkgPath = file3.getAbsolutePath();
                c cVar = this.forHostAPP;
                sb.toString();
                boolean a3 = cVar.a(apkInfo, "before update, time=" + System.currentTimeMillis() + ", downloadAPK path:" + file3.getAbsolutePath() + ", exists=" + file3.exists() + ", canRead=" + file3.canRead() + ", isFile=" + file3.isFile() + ",length" + file3.length());
                String str4 = apkInfo.packageName + " s=" + a3;
                b.a();
                if (!a3) {
                    if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                        this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 5));
                        return;
                    }
                    return;
                } else if (this.mUpgradeResultMap != null) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 1));
                    return;
                } else {
                    return;
                }
            }
            if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(ao, 8));
            }
            if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                if (b != null && b.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                    sSetRetrmAlarm = true;
                    com.baidu.sofire.b.b.b(this.context, sRetryDownoadHostCareApksTimesCount, false);
                    sRetryDownoadHostCareApksTimesCount++;
                }
                if (!sMonitorNetworkWhenUpgradeNoNet) {
                    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (d.Px == null) {
                        d.Px = new MyReceiver().a();
                    } else {
                        d.Px.a();
                    }
                    this.context.getApplicationContext().registerReceiver(d.Px, intentFilter);
                    sMonitorNetworkWhenUpgradeNoNet = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = this.preference;
            long j = eVar.a.getLong("pu_ap_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                eVar.PP.putLong("pu_ap_fd", System.currentTimeMillis());
                eVar.PP.commit();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (d.c(this.context)) {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0) + 1));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0)));
                } else {
                    hashMap.put("0", Integer.valueOf(this.preference.a.getInt("wi_fa_pu_ap", 0)));
                    hashMap.put("1", Integer.valueOf(this.preference.a.getInt("mo_fa_pu_ap", 0) + 1));
                }
                e eVar2 = this.preference;
                eVar2.PP.putInt("wi_fa_pu_ap", 0);
                eVar2.PP.commit();
                e eVar3 = this.preference;
                eVar3.PP.putInt("mo_fa_pu_ap", 0);
                eVar3.PP.commit();
                e eVar4 = this.preference;
                eVar4.PP.putLong("pu_ap_fd", System.currentTimeMillis());
                eVar4.PP.commit();
                d.a(this.context, "1003116", hashMap);
            } else if (d.c(this.context)) {
                e eVar5 = this.preference;
                eVar5.PP.putInt("wi_fa_pu_ap", this.preference.a.getInt("wi_fa_pu_ap", 0) + 1);
                eVar5.PP.commit();
            } else {
                e eVar6 = this.preference;
                eVar6.PP.putInt("mo_fa_pu_ap", this.preference.a.getInt("mo_fa_pu_ap", 0) + 1);
                eVar6.PP.commit();
            }
            b.a();
            file3.delete();
        } catch (Throwable th) {
            d.a(th);
            try {
                if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                    this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new a(d.ao(this.context), 2));
                }
            } catch (Throwable th2) {
                d.a(th2);
            }
            try {
                List<Integer> b3 = this.preference.b();
                if (this.mFrom == 1 || this.mFrom == 2 || this.mFrom == 3) {
                    if (b3 != null && b3.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                        sSetRetrmAlarm = true;
                        com.baidu.sofire.b.b.b(this.context, sRetryDownoadHostCareApksTimesCount, false);
                        sRetryDownoadHostCareApksTimesCount++;
                    }
                    if (!sMonitorNetworkWhenUpgradeNoNet) {
                        IntentFilter intentFilter2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        if (d.Px == null) {
                            d.Px = new MyReceiver().a();
                        } else {
                            d.Px.a();
                        }
                        this.context.getApplicationContext().registerReceiver(d.Px, intentFilter2);
                        sMonitorNetworkWhenUpgradeNoNet = true;
                    }
                }
            } catch (Throwable th3) {
                d.a(th3);
            }
        }
    }

    public static void handleUploadPidChange(Context context, Intent intent) {
        try {
            b.a();
            com.baidu.sofire.b.b.a(context);
            e eVar = new e(context);
            JSONArray jSONArray = new JSONArray();
            String string = eVar.a.getString("pdcgts", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("_");
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(Long.valueOf(str));
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.a.getInt("rtqe", 0)));
            hashMap.put("1", Integer.valueOf(eVar.a.getInt("pdcg", 0)));
            hashMap.put("2", jSONArray);
            eVar.PP.putInt("rtqe", 0);
            eVar.PP.commit();
            eVar.PP.putInt("pdcg", 0);
            eVar.PP.commit();
            eVar.a(0L);
            d.a(context, "1003122", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
