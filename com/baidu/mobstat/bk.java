package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bi;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class bk implements bi.a {

    /* renamed from: a  reason: collision with root package name */
    private bi f2588a;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes7.dex */
    public static class a extends bk {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Activity> f2589a;
        private b b;
        private final WeakHashMap<View, C0275a> c = new WeakHashMap<>();

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.f2589a = weakReference;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0275a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;
            private View c;
            private volatile boolean d;

            public void a(boolean z) {
                this.d = z;
            }

            public C0275a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.b = accessibilityDelegate;
                a.this.f2589a = weakReference;
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
                    if (a.this.f2589a != null && (activity = (Activity) a.this.f2589a.get()) != null) {
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
            if (!(a2 instanceof C0275a)) {
                C0275a c0275a = new C0275a(weakReference, view, str, a2, z);
                view.setAccessibilityDelegate(c0275a);
                this.c.put(view, c0275a);
                return;
            }
            ((C0275a) a2).a(z);
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
            a(this.f2589a, view, bj.a(view), z);
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            if (this.c != null) {
                for (Map.Entry<View, C0275a> entry : this.c.entrySet()) {
                    entry.getKey().setAccessibilityDelegate(entry.getValue().a());
                }
                this.c.clear();
            }
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.f2588a == null) {
            this.f2588a = new bi(activity, this, z);
            this.f2588a.a(jSONObject);
        }
        this.f2588a.a(activity);
    }
}
