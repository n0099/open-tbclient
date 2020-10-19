package com.baidu.d.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.d.c.f;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class a {
    private static boolean DEBUG = AppConfig.isDebug();
    private static a ani;
    private String anj;
    private SharedPreferences ank;
    private String mChannel;

    public static a uK() {
        if (ani == null) {
            synchronized (a.class) {
                if (ani == null) {
                    ani = new a();
                }
            }
        }
        return ani;
    }

    private a() {
        init();
    }

    private void init() {
        this.ank = AppRuntime.getAppContext().getSharedPreferences("com.baidu.common.pubparam", 0);
        uM();
        uN();
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String uL() {
        return this.anj;
    }

    private void uM() {
        this.anj = uQ();
        if (TextUtils.isEmpty(this.anj)) {
            this.anj = uR();
        }
    }

    private void uN() {
        this.mChannel = uO();
        if (TextUtils.isEmpty(this.mChannel) && !TextUtils.isEmpty(this.anj)) {
            this.mChannel = this.anj;
            uP();
        }
    }

    private String uO() {
        return this.ank.getString("channel", null);
    }

    private void uP() {
        this.ank.edit().putString("channel", this.mChannel).apply();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, IF, SGET, MOVE_EXCEPTION, INVOKE, INVOKE, CONST_STR, CONST_STR, INVOKE, IF, SGET, MOVE_EXCEPTION] complete} */
    private String uQ() {
        String str = null;
        InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(f.a.tnconfig);
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #4 {Exception -> 0x0079, blocks: (B:33:0x0070, B:35:0x0075), top: B:55:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String uR() {
        BufferedReader bufferedReader;
        InputStream inputStream;
        String str;
        Exception e;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("channel");
        } catch (Exception e2) {
            bufferedReader = null;
            inputStream = null;
            str = null;
            e = e2;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            inputStream = null;
        }
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
                            } catch (Exception e3) {
                                if (DEBUG) {
                                    Log.e("ChannelManager", "readLastChannelFromAssets", e3);
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        if (DEBUG) {
                            Log.e("ChannelManager", "readLastChannelFromAssets", e);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                                if (DEBUG) {
                                    Log.e("ChannelManager", "readLastChannelFromAssets", e5);
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                            if (DEBUG) {
                                Log.e("ChannelManager", "readLastChannelFromAssets", e6);
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                str = null;
                e = e7;
            }
        } catch (Exception e8) {
            bufferedReader = null;
            str = null;
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (inputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        return str;
    }
}
