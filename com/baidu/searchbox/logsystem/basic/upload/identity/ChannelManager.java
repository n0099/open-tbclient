package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class ChannelManager {
    public static boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_CHANNEL = "channel";
    public static final String PREFS_NAME = "com.baidu.common.pubparam";
    public static final String TAG = "ChannelManager";
    public static volatile ChannelManager sInstance;
    public SharedPreferences mCache;
    public String mChannel;
    public String mLastChannel;

    public ChannelManager() {
        init();
    }

    public static ChannelManager getInstance() {
        if (sInstance == null) {
            synchronized (ChannelManager.class) {
                if (sInstance == null) {
                    sInstance = new ChannelManager();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        this.mCache = AppRuntime.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        initLastChannel();
        initChanel();
    }

    private void initChanel() {
        String readChannelFromCache = readChannelFromCache();
        this.mChannel = readChannelFromCache;
        if (TextUtils.isEmpty(readChannelFromCache) && !TextUtils.isEmpty(this.mLastChannel)) {
            this.mChannel = this.mLastChannel;
            saveCannelToCache();
        }
    }

    private void initLastChannel() {
        String readLastChannelFromRaw = readLastChannelFromRaw();
        this.mLastChannel = readLastChannelFromRaw;
        if (TextUtils.isEmpty(readLastChannelFromRaw)) {
            this.mLastChannel = readLastChannelFromAssets();
        }
    }

    private String readChannelFromCache() {
        return this.mCache.getString("channel", null);
    }

    private void saveCannelToCache() {
        this.mCache.edit().putString("channel", this.mChannel).apply();
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String getLastChannel() {
        return this.mLastChannel;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0081 A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #2 {Exception -> 0x007d, blocks: (B:45:0x0079, B:49:0x0081), top: B:59:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readLastChannelFromAssets() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        String str;
        InputStream inputStream2 = null;
        String str2 = null;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("file:///android_asset/channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
                inputStream2 = inputStream;
                str = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            str = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            inputStream = null;
        }
        try {
            str2 = bufferedReader.readLine();
            inputStream.close();
            bufferedReader.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    if (DEBUG) {
                        Log.e(TAG, "readLastChannelFromAssets", e3);
                        return str2;
                    }
                    return str2;
                }
            }
            bufferedReader.close();
            return str2;
        } catch (IOException e4) {
            e = e4;
            String str3 = str2;
            inputStream2 = inputStream;
            str = str3;
            try {
                if (DEBUG) {
                    Log.e(TAG, "readLastChannelFromAssets", e);
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            Log.e(TAG, "readLastChannelFromAssets", e5);
                        }
                        return str;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str;
            } catch (Throwable th4) {
                InputStream inputStream3 = inputStream2;
                th = th4;
                inputStream = inputStream3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        if (DEBUG) {
                            Log.e(TAG, "readLastChannelFromAssets", e6);
                        }
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            if (inputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.DEBUG == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        android.util.Log.e(com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.TAG, "readLastChannelFromRaw", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.DEBUG == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readLastChannelFromRaw() {
        Resources resources = AppRuntime.getAppContext().getResources();
        int identifier = resources.getIdentifier("tnconfig", "raw", AppRuntime.getAppContext().getPackageName());
        String str = null;
        if (identifier == 0) {
            return null;
        }
        InputStream openRawResource = resources.openRawResource(identifier);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        try {
            try {
                str = bufferedReader.readLine();
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e) {
                    e = e;
                }
            } catch (IOException e2) {
                if (DEBUG) {
                    Log.e(TAG, "readLastChannelFromRaw", e2);
                }
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return str;
        } catch (Throwable th) {
            try {
                openRawResource.close();
                bufferedReader.close();
            } catch (Exception e4) {
                if (DEBUG) {
                    Log.e(TAG, "readLastChannelFromRaw", e4);
                }
            }
            throw th;
        }
    }
}
