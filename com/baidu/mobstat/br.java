package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bp;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class br implements bp.a {
    private bp a;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes3.dex */
    public static class a extends br {
        private WeakReference<Activity> a;
        private b b;
        private final WeakHashMap<View, C0075a> c = new WeakHashMap<>();

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.a = weakReference;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.mobstat.br$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0075a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;
            private View c;
            private volatile boolean d;

            public void a(boolean z) {
                this.d = z;
            }

            public C0075a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
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
                    if (bk.c().b() && this.d) {
                        bk.c().a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (bo.c().b()) {
                        bo.c().a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (a.this.a != null && (activity = (Activity) a.this.a.get()) != null) {
                        a.this.b.a(view, this.d, activity);
                    }
                }
                if (this.b != null) {
                    this.b.sendAccessibilityEvent(view, i);
                }
            }
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            View.AccessibilityDelegate a = a(view);
            if (!(a instanceof C0075a)) {
                C0075a c0075a = new C0075a(weakReference, view, str, a, z);
                view.setAccessibilityDelegate(c0075a);
                this.c.put(view, c0075a);
                return;
            }
            ((C0075a) a).a(z);
        }

        private View.AccessibilityDelegate a(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.mobstat.bp.a
        public void a(View view, boolean z) {
            a(this.a, view, bq.a(view), z);
        }

        @Override // com.baidu.mobstat.br
        public void a() {
            if (this.c != null) {
                for (Map.Entry<View, C0075a> entry : this.c.entrySet()) {
                    entry.getKey().setAccessibilityDelegate(entry.getValue().a());
                }
                this.c.clear();
            }
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.a == null) {
            this.a = new bp(activity, this, z);
            this.a.a(jSONObject);
        }
        this.a.a(activity);
    }
}
