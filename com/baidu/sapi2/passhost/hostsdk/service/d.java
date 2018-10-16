package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements ISpManagerService {
    public static final String a = "SpManagerService";
    private HashMap<String, ISpManagerService.ISPer> b;
    private Context c;

    /* loaded from: classes.dex */
    private static class b {
        public static d a = new d();

        private b() {
        }
    }

    public static d a() {
        return b.a;
    }

    public void a(Context context) {
        this.c = context;
    }

    private d() {
        this.b = new HashMap<>();
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService
    public ISpManagerService.ISPer getSPer(String str, int i) {
        return a(i + BaseRequestAction.SPLITE + str);
    }

    private ISpManagerService.ISPer a(String str) {
        ISpManagerService.ISPer iSPer;
        synchronized (this.b) {
            iSPer = this.b.get(str);
            if (iSPer == null) {
                iSPer = new a(str);
            }
            this.b.put(str, iSPer);
        }
        return iSPer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ISpManagerService.ISPer {
        private String b;
        private SharedPreferences c;
        private SharedPreferences.Editor d;

        public a(String str) {
            this.b = str;
            if (d.this.c == null) {
                Log.e(d.a, "SPer() ctx null");
            }
            this.c = d.this.c.getSharedPreferences(str, 0);
        }

        private SharedPreferences.Editor a() {
            if (this.d == null) {
                this.d = this.c.edit();
            }
            return this.d;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public SharedPreferences getPreferences() {
            return this.c;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public String getString(String str) {
            return this.c.getString(str, null);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public String getString(String str, String str2) {
            return this.c.getString(str, str2);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public int getInt(String str) {
            return this.c.getInt(str, 0);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public int getInt(String str, int i) {
            return this.c.getInt(str, i);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public float getFloat(String str) {
            return this.c.getFloat(str, 0.0f);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public float getFloat(String str, float f) {
            return this.c.getFloat(str, f);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public long getLong(String str) {
            return this.c.getLong(str, 0L);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public long getLong(String str, long j) {
            return this.c.getLong(str, j);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean getBoolean(String str) {
            return this.c.getBoolean(str, false);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean getBoolean(String str, boolean z) {
            return this.c.getBoolean(str, z);
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean putString(String str, String str2, boolean z) {
            SharedPreferences.Editor a = a();
            a.putString(str, str2);
            if (z) {
                return a.commit();
            }
            return true;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean putInt(String str, int i, boolean z) {
            SharedPreferences.Editor a = a();
            a.putInt(str, i);
            if (z) {
                return a.commit();
            }
            return true;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean putFloat(String str, float f, boolean z) {
            SharedPreferences.Editor a = a();
            a.putFloat(str, f);
            if (z) {
                return a.commit();
            }
            return true;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean putLong(String str, long j, boolean z) {
            SharedPreferences.Editor a = a();
            a.putLong(str, j);
            if (z) {
                return a.commit();
            }
            return true;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean putBoolean(String str, boolean z, boolean z2) {
            SharedPreferences.Editor a = a();
            a.putBoolean(str, z);
            if (z2) {
                return a.commit();
            }
            return true;
        }

        @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISpManagerService.ISPer
        public boolean commit() {
            return a().commit();
        }
    }
}
