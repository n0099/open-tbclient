package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class b extends g {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a dLZ;
    private final boolean dMa;
    private final String mFileName;

    public b(String str) {
        super(str);
        this.dLZ = new a();
        this.mFileName = str;
        this.dMa = ProcessUtils.isMainProcess() || aMf();
    }

    public boolean aMe() {
        return this.dMa;
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.c.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return aMe() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dMa ? super.edit() : this.dLZ;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.dMa) {
            return cD(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.b(getName(), 4, str, str2));
        if (DEBUG) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    private String getName() {
        return this.mFileName;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.dMa) {
            return ad(str, i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.b(getName(), 1, str, String.valueOf(i)));
        if (DEBUG) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.dMa) {
            return s(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.b(getName(), 2, str, String.valueOf(j)));
        if (DEBUG) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (this.dMa) {
            return f(str, f);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.b(getName(), 5, str, String.valueOf(f)));
        if (DEBUG) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.dMa) {
                return ah(str, z);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.b(getName(), 3, str, String.valueOf(z)));
            if (DEBUG) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getBoolean("result_value"));
            }
            return callOnMainWithContentProvider.mResult.getBoolean("result_value");
        } catch (ClassCastException e) {
            Log.e("IpcSp", "getBoolean", e);
            return false;
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.dMa) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 4, str, str2));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (this.dMa) {
            super.putInt(str, i);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 1, str, String.valueOf(i)));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.dMa) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (this.dMa) {
            super.putFloat(str, f);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 5, str, String.valueOf(f)));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.dMa) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.dMa) {
            super.remove(str);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 101, str, ""));
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.dMa) {
            super.clear();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.b(getName(), 100, "", ""));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cD(String str, String str2) {
        return super.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ad(String str, int i) {
        return super.getInt(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long s(String str, long j) {
        return super.getLong(str, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float f(String str, float f) {
        return super.getFloat(str, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ah(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    /* loaded from: classes9.dex */
    private class a implements SharedPreferences.Editor {
        final Deque<Runnable> dMb;

        private a() {
            this.dMb = new ArrayDeque();
        }

        private a g(Runnable runnable) {
            synchronized (this.dMb) {
                this.dMb.offer(runnable);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(final String str, @Nullable final String str2) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putString(str, str2);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(final String str, @Nullable final Set<String> set) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putStringSet(str, set);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(final String str, final int i) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putInt(str, i);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(final String str, final long j) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putLong(str, j);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(final String str, final float f) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putFloat(str, f);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(final String str, final boolean z) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.putBoolean(str, z);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(final String str) {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.remove(str);
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            return g(new Runnable() { // from class: com.baidu.swan.apps.storage.c.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.clear();
                }
            });
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            synchronized (this.dMb) {
                while (!this.dMb.isEmpty()) {
                    Runnable poll = this.dMb.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }
    }
}
