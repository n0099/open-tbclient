package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bi;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public abstract class bk implements bi.a {

    /* renamed from: a  reason: collision with root package name */
    private bi f2584a;

    /* loaded from: classes17.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes17.dex */
    public static class a extends bk {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Activity> f2585a;
        private b b;
        private final WeakHashMap<View, C0255a> c = new WeakHashMap<>();

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.f2585a = weakReference;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public class C0255a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;
            private View c;
            private volatile boolean d;

            public void a(boolean z) {
                this.d = z;
            }

            public C0255a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.b = accessibilityDelegate;
                a.this.f2585a = weakReference;
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
                    if (a.this.f2585a != null && (activity = (Activity) a.this.f2585a.get()) != null) {
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
            View.AccessibilityDelegate a2 = a(view);
            if (!(a2 instanceof C0255a)) {
                C0255a c0255a = new C0255a(weakReference, view, str, a2, z);
                view.setAccessibilityDelegate(c0255a);
                this.c.put(view, c0255a);
                return;
            }
            ((C0255a) a2).a(z);
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
            a(this.f2585a, view, bj.a(view), z);
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            if (this.c != null) {
                for (Map.Entry<View, C0255a> entry : this.c.entrySet()) {
                    entry.getKey().setAccessibilityDelegate(entry.getValue().a());
                }
                this.c.clear();
            }
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.f2584a == null) {
            this.f2584a = new bi(activity, this, z);
            this.f2584a.a(jSONObject);
        }
        this.f2584a.a(activity);
    }
}
