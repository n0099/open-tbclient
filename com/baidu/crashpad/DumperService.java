package com.baidu.crashpad;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import com.baidu.crashpad.ZeusLogUploader;
/* loaded from: classes.dex */
public final class DumperService extends Service implements ZeusLogUploader.OnFinishedListener {
    public static final String CALLBACK = "CRASH_CALLBACK";
    public static final String CRASHLOGENCRYPT = "CRASHLOGENCRYPT";
    public static final String ENCRYPTKEY = "ENCRYPTKEY";
    public static final String HTTPS = "HTTPS";
    public static final String LOG = "CRASH_FILE";
    public static final String SIGNAL = "CRASH_SIGNAL";
    public static final String TAG = "CRASHPAD DumperService";
    public static final String TIME = "CRASH_TIME";
    public static final String TYPE = "LOG_TYPE";
    public String mCallback;
    public String mCrashImei;
    public int mCrashSignal;
    public long mCrashTime;
    public ZeusLogUploader mLogUploader;
    public boolean mCrashLogFailedEncrypt = true;
    public String mEncryptKey = "";

    private boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to DumperService.");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    @Override // com.baidu.crashpad.ZeusLogUploader.OnFinishedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinished(String str, int i2, String str2) {
        Object obj;
        ZeusLogUploader zeusLogUploader;
        Context applicationContext = getApplicationContext();
        String str3 = this.mCallback;
        if (str3 != null && !str3.isEmpty() && !this.mCallback.equals("0")) {
            try {
                obj = Class.forName(this.mCallback).newInstance();
            } catch (Throwable th) {
                Log.e(TAG, "", th);
            }
            if (this.mCrashLogFailedEncrypt && i2 == 3 && (zeusLogUploader = this.mLogUploader) != null && zeusLogUploader.encryptUploadFailedFile(str, true) != 6) {
                str2 = "Failed to encrypt file.";
            }
            String str4 = str2;
            if (obj != null) {
                ((CrashCallback) obj).onCrash(applicationContext, this.mCrashImei, this.mCrashSignal, this.mCrashTime, str, i2, str4);
            }
            stopSelf();
        }
        obj = null;
        if (this.mCrashLogFailedEncrypt) {
            str2 = "Failed to encrypt file.";
        }
        String str42 = str2;
        if (obj != null) {
        }
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            stopSelf();
        }
        String stringExtra = intent.getStringExtra("LOG_TYPE");
        String stringExtra2 = intent.getStringExtra("CRASH_FILE");
        boolean booleanExtra = intent.getBooleanExtra("HTTPS", true);
        this.mCrashSignal = intent.getIntExtra("CRASH_SIGNAL", -1);
        this.mCrashTime = intent.getLongExtra("CRASH_TIME", -1L);
        this.mCallback = intent.getStringExtra("CRASH_CALLBACK");
        this.mCrashLogFailedEncrypt = intent.getBooleanExtra("CRASHLOGENCRYPT", true);
        this.mEncryptKey = intent.getStringExtra("ENCRYPTKEY");
        ZeusLogUploader zeusLogUploader = new ZeusLogUploader(stringExtra, null, booleanExtra);
        this.mLogUploader = zeusLogUploader;
        if (zeusLogUploader != null) {
            ZeusLogUploader.setEncryptKey(this.mEncryptKey);
            ZeusLogUploader.setUploadCrashLogFailedEncrypt(this.mCrashLogFailedEncrypt);
        }
        ZwDebugExtra.init(this);
        String str = this.mCrashImei;
        if (str == null) {
            str = "0";
        }
        this.mCrashImei = str;
        if (!isNetworkConnected(getApplicationContext())) {
            onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
            return 3;
        } else if (!booleanExtra) {
            onFinished(stringExtra2, 3, "doUpload Failed, HTTP is never supported!");
            stopSelf();
            return 0;
        } else {
            ZeusLogUploader zeusLogUploader2 = this.mLogUploader;
            if (zeusLogUploader2 != null) {
                zeusLogUploader2.uploadLogFile(stringExtra2, true, this);
            } else {
                onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
            }
            return 3;
        }
    }
}
