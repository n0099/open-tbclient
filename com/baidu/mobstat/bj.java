package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bh;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class bj implements bh.a {
    public bh a;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a extends bj {
        public WeakReference<Activity> a;
        public b b;
        public final WeakHashMap<View, C0114a> c = new WeakHashMap<>();

        /* renamed from: com.baidu.mobstat.bj$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0114a extends View.AccessibilityDelegate {
            public View.AccessibilityDelegate b;
            public View c;
            public volatile boolean d;
            public long e;
            public long f;

            public C0114a(WeakReference<Activity> weakReference, View view2, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.b = accessibilityDelegate;
                a.this.a = weakReference;
                this.c = view2;
                this.d = z;
            }

            public View.AccessibilityDelegate a() {
                return this.b;
            }

            public void a(boolean z) {
                this.d = z;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view2, int i) {
                Activity activity;
                try {
                    if (CooperService.instance().isCloseTrace()) {
                        a.this.a();
                        return;
                    }
                    this.e = System.currentTimeMillis();
                    if (view2 == this.c && i == 1) {
                        if (bc.c().b() && this.d) {
                            bc c = bc.c();
                            c.a("watch view  OnEvent:" + view2.getClass().getName());
                        }
                        if (bg.c().b()) {
                            bg c2 = bg.c();
                            c2.a("watch view  OnEvent:" + view2.getClass().getName());
                        }
                        if (a.this.a != null && (activity = (Activity) a.this.a.get()) != null) {
                            a.this.b.a(view2, this.d, activity);
                        }
                    }
                    if (this.e - this.f < 100) {
                        return;
                    }
                    this.f = System.currentTimeMillis();
                    if (this.b != null && !(this.b instanceof C0114a) && this.b != this) {
                        this.b.sendAccessibilityEvent(view2, i);
                    } else {
                        super.sendAccessibilityEvent(view2, i);
                    }
                } catch (Throwable unused) {
                    a.this.a();
                    CooperService.instance().setEnableAutoEvent(false);
                }
            }
        }

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.a = weakReference;
            this.b = bVar;
        }

        private View.AccessibilityDelegate a(View view2) {
            try {
                return (View.AccessibilityDelegate) view2.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view2, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.baidu.mobstat.bj
        public void a() {
            WeakHashMap<View, C0114a> weakHashMap = this.c;
            if (weakHashMap == null) {
                return;
            }
            for (Map.Entry<View, C0114a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.c.clear();
        }

        @Override // com.baidu.mobstat.bh.a
        public void a(View view2, boolean z) {
            a(this.a, view2, bi.a(view2), z);
        }

        public void a(WeakReference<Activity> weakReference, View view2, String str, boolean z) {
            View.AccessibilityDelegate a = a(view2);
            if (!(a instanceof C0114a)) {
                C0114a c0114a = new C0114a(weakReference, view2, str, a, z);
                view2.setAccessibilityDelegate(c0114a);
                this.c.put(view2, c0114a);
                return;
            }
            ((C0114a) a).a(z);
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.a == null) {
            bh bhVar = new bh(activity, this, z);
            this.a = bhVar;
            bhVar.a(jSONObject);
        }
        this.a.a(activity);
    }
}
