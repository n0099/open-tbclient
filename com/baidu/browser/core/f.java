package com.baidu.browser.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.browser.core.util.BdLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public final class f {
    private static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> agC = new ConcurrentHashMap<>();
    private static volatile boolean agE = false;
    private static a agD = new a(com.baidu.browser.core.async.b.dg("PreferenceQueue").getLooper());

    static {
        agD.sendEmptyMessageDelayed(0, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, Object obj) {
        if (str != null) {
            if (agC.containsKey(str)) {
                ConcurrentHashMap<String, Object> concurrentHashMap = agC.get(str);
                if (concurrentHashMap != null) {
                    if (obj != null) {
                        concurrentHashMap.put(str2, obj);
                    } else {
                        concurrentHashMap.remove(str2);
                    }
                } else if (obj != null && str2 != null) {
                    ConcurrentHashMap<String, Object> concurrentHashMap2 = new ConcurrentHashMap<>();
                    concurrentHashMap2.put(str2, obj);
                    agC.put(str, concurrentHashMap2);
                }
            } else if (obj != null && str2 != null) {
                ConcurrentHashMap<String, Object> concurrentHashMap3 = new ConcurrentHashMap<>();
                concurrentHashMap3.put(str2, obj);
                agC.put(str, concurrentHashMap3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clear(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (str != null && (concurrentHashMap = agC.get(str)) != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void apply() {
        int i;
        if (!agE) {
            agE = true;
            try {
                Context baseContext = b.su().getBaseContext();
                BdLog.d("BdPreferenceQueueWorker", "pending work category: " + agC.size());
                for (String str : agC.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = agC.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                        i = 0;
                    } else {
                        SharedPreferences.Editor edit = baseContext.getSharedPreferences(str, 0).edit();
                        int i2 = 0;
                        for (String str2 : concurrentHashMap.keySet()) {
                            Object obj = concurrentHashMap.get(str2);
                            if (obj != null) {
                                if (obj instanceof Integer) {
                                    edit.putInt(str2, ((Integer) obj).intValue());
                                } else if (obj instanceof Long) {
                                    edit.putLong(str2, ((Long) obj).longValue());
                                } else if (obj instanceof Float) {
                                    edit.putFloat(str2, ((Float) obj).floatValue());
                                } else if (obj instanceof Boolean) {
                                    edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                                } else if (obj instanceof String) {
                                    edit.putString(str2, (String) obj);
                                } else if (obj instanceof Set) {
                                    edit.putStringSet(str2, (Set) obj);
                                }
                                i2++;
                            }
                        }
                        edit.commit();
                        i = i2;
                    }
                    concurrentHashMap.clear();
                    if (i > 0) {
                        BdLog.d("BdPreferenceQueueWorker", str + ".xml " + i + " items have been wroten");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                agE = false;
            }
        }
    }

    public static void sy() {
        Log.d("BdPreferenceQueueWorker", "wait to finish");
        agD.removeMessages(0);
        apply();
        sz();
    }

    public static void sz() {
        if (!agD.hasMessages(0)) {
            agD.sendEmptyMessageDelayed(0, 15000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a extends Handler {
        private a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    f.apply();
                    f.agD.sendEmptyMessageDelayed(0, 15000L);
                    return;
                default:
                    return;
            }
        }
    }
}
