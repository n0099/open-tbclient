package com.baidu.d.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.d.c.g;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class a {
    private static boolean DEBUG = AppConfig.isDebug();
    private static a anS;
    private SharedPreferences mCache;
    private String mChannel;
    private String mLastChannel;

    public static a ub() {
        if (anS == null) {
            synchronized (a.class) {
                if (anS == null) {
                    anS = new a();
                }
            }
        }
        return anS;
    }

    private a() {
        init();
    }

    private void init() {
        this.mCache = AppRuntime.getAppContext().getSharedPreferences("com.baidu.common.pubparam", 0);
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
        InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(g.a.tnconfig);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        try {
            try {
                str = bufferedReader.readLine();
            } finally {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e("ChannelManager", "readLastChannelFromRaw", e);
                    }
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e("ChannelManager", "readLastChannelFromRaw", e2);
            }
            try {
                openRawResource.close();
                bufferedReader.close();
            } catch (Exception e3) {
                if (DEBUG) {
                    Log.e("ChannelManager", "readLastChannelFromRaw", e3);
                }
            }
        }
        return str;
    }

    private String readLastChannelFromAssets() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        String str;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    try {
                        str = bufferedReader.readLine();
                    } catch (Exception e) {
                        e = e;
                        str = null;
                    }
                    try {
                        inputStream.close();
                        bufferedReader.close();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                if (DEBUG) {
                                    Log.e("ChannelManager", "readLastChannelFromAssets", e2);
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        if (DEBUG) {
                            Log.e("ChannelManager", "readLastChannelFromAssets", e);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                                if (DEBUG) {
                                    Log.e("ChannelManager", "readLastChannelFromAssets", e4);
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            if (DEBUG) {
                                Log.e("ChannelManager", "readLastChannelFromAssets", e5);
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                str = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader = null;
            inputStream = null;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStream = null;
        }
        return str;
    }
}
