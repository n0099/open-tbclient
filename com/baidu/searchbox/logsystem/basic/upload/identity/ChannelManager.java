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
/* loaded from: classes15.dex */
public class ChannelManager {
    private static boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_CHANNEL = "channel";
    private static final String PREFS_NAME = "com.baidu.common.pubparam";
    private static final String TAG = "ChannelManager";
    private static volatile ChannelManager sInstance;
    private SharedPreferences mCache;
    private String mChannel;
    private String mLastChannel;

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

    private ChannelManager() {
        init();
    }

    private void init() {
        this.mCache = AppRuntime.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        initLastChannel();
        initChanel();
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String getLastChannel() {
        return this.mLastChannel;
    }

    private void initLastChannel() {
        this.mLastChannel = readLastChannelFromRaw();
        if (TextUtils.isEmpty(this.mLastChannel)) {
            this.mLastChannel = readLastChannelFromAssets();
        }
    }

    private void initChanel() {
        this.mChannel = readChannelFromCache();
        if (TextUtils.isEmpty(this.mChannel) && !TextUtils.isEmpty(this.mLastChannel)) {
            this.mChannel = this.mLastChannel;
            saveCannelToCache();
        }
    }

    private String readChannelFromCache() {
        return this.mCache.getString("channel", null);
    }

    private void saveCannelToCache() {
        this.mCache.edit().putString("channel", this.mChannel).apply();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, IF, SGET, MOVE_EXCEPTION, INVOKE, INVOKE, CONST_STR, CONST_STR, INVOKE, IF, SGET, MOVE_EXCEPTION] complete} */
    private String readLastChannelFromRaw() {
        String str = null;
        Resources resources = AppRuntime.getAppContext().getResources();
        int identifier = resources.getIdentifier("tnconfig", "raw", AppRuntime.getAppContext().getPackageName());
        if (identifier != 0) {
            InputStream openRawResource = resources.openRawResource(identifier);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
            try {
                try {
                    str = bufferedReader.readLine();
                } catch (IOException e) {
                    if (DEBUG) {
                        Log.e(TAG, "readLastChannelFromRaw", e);
                    }
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception e2) {
                        if (DEBUG) {
                            Log.e(TAG, "readLastChannelFromRaw", e2);
                        }
                    }
                }
            } finally {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e3) {
                    if (DEBUG) {
                        Log.e(TAG, "readLastChannelFromRaw", e3);
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #4 {Exception -> 0x0079, blocks: (B:33:0x0070, B:35:0x0075), top: B:59:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readLastChannelFromAssets() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        String str;
        IOException e;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("file:///android_asset/channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    try {
                        str = bufferedReader.readLine();
                        try {
                            inputStream.close();
                            bufferedReader.close();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                    if (DEBUG) {
                                        Log.e(TAG, "readLastChannelFromAssets", e2);
                                    }
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e3) {
                            e = e3;
                            if (DEBUG) {
                                Log.e(TAG, "readLastChannelFromAssets", e);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                    if (DEBUG) {
                                        Log.e(TAG, "readLastChannelFromAssets", e4);
                                    }
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        }
                    } catch (IOException e5) {
                        str = null;
                        e = e5;
                    }
                } catch (Throwable th) {
                    th = th;
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
            } catch (IOException e7) {
                bufferedReader = null;
                str = null;
                e = e7;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (IOException e8) {
            bufferedReader = null;
            inputStream = null;
            str = null;
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStream = null;
        }
        return str;
    }
}
