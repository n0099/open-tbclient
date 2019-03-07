package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b implements ServiceConnection {
    public static HashMap<String, WeakReference<ServiceConnection>> a = new HashMap<>();
    public Context b;
    private boolean c;

    public b(Context context, boolean z) {
        this.c = false;
        this.b = context;
        this.c = z;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = null;
        if (componentName != null) {
            try {
                str = componentName.getPackageName() + componentName.getClassName();
            } catch (Throwable th) {
            }
        }
        if (!TextUtils.isEmpty(str)) {
            a.remove(str);
        }
        this.b.getApplicationContext().unbindService(this);
        try {
            if (this.c) {
                ArrayList<d> arrayList = new ArrayList<>();
                d dVar = new d();
                dVar.a(componentName);
                if (componentName != null) {
                    dVar.a(2, true);
                } else {
                    dVar.a(2, false);
                }
                arrayList.add(dVar);
                JSONObject b = f.cj().ck().b(this.b.getPackageName(), arrayList);
                if (b != null) {
                    e.d(this.b, "android_awake", b);
                }
            }
        } catch (Throwable th2) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
