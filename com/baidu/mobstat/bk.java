package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bi;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class bk implements bi.a {
    private bi a;

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes6.dex */
    public static class a extends bk {
        private WeakReference<Activity> a;
        private b b;
        private final WeakHashMap<View, C0077a> c = new WeakHashMap<>();

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.a = weakReference;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0077a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;
            private View c;
            private volatile boolean d;

            public void a(boolean z) {
                this.d = z;
            }

            public C0077a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.b = accessibilityDelegate;
                a.this.a = weakReference;
                this.c = view;
                this.d = z;
            }

            public View.AccessibilityDelegate a() {
                return this.b;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                Activity activity;
                if (view == this.c && i == 1) {
                    if (bd.c().b() && this.d) {
                        bd.c().a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (bh.c().b()) {
                        bh.c().a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (a.this.a != null && (activity = (Activity) a.this.a.get()) != null) {
                        a.this.b.a(view, this.d, activity);
                    }
                }
                if (this.b != null) {
                    this.b.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
            }
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            View.AccessibilityDelegate a = a(view);
            if (!(a instanceof C0077a)) {
                C0077a c0077a = new C0077a(weakReference, view, str, a, z);
                view.setAccessibilityDelegate(c0077a);
                this.c.put(view, c0077a);
                return;
            }
            ((C0077a) a).a(z);
        }

        private View.AccessibilityDelegate a(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.mobstat.bi.a
        public void a(View view, boolean z) {
            a(this.a, view, bj.a(view), z);
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            if (this.c != null) {
                for (Map.Entry<View, C0077a> entry : this.c.entrySet()) {
                    entry.getKey().setAccessibilityDelegate(entry.getValue().a());
                }
                this.c.clear();
            }
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.a == null) {
            this.a = new bi(activity, this, z);
            this.a.a(jSONObject);
        }
        this.a.a(activity);
    }
}
