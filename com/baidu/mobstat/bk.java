package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.bi;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class bk implements bi.a {

    /* renamed from: a  reason: collision with root package name */
    public bi f9106a;

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a extends bk {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f9107a;

        /* renamed from: b  reason: collision with root package name */
        public b f9108b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C0111a> f9109c = new WeakHashMap<>();

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0111a extends View.AccessibilityDelegate {

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f9111b;

            /* renamed from: c  reason: collision with root package name */
            public View f9112c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f9113d;

            public C0111a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.f9111b = accessibilityDelegate;
                a.this.f9107a = weakReference;
                this.f9112c = view;
                this.f9113d = z;
            }

            public void a(boolean z) {
                this.f9113d = z;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                Activity activity;
                if (view == this.f9112c && i == 1) {
                    if (bd.c().b() && this.f9113d) {
                        bd c2 = bd.c();
                        c2.a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (bh.c().b()) {
                        bh c3 = bh.c();
                        c3.a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (a.this.f9107a != null && (activity = (Activity) a.this.f9107a.get()) != null) {
                        a.this.f9108b.a(view, this.f9113d, activity);
                    }
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f9111b;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
            }

            public View.AccessibilityDelegate a() {
                return this.f9111b;
            }
        }

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.f9107a = weakReference;
            this.f9108b = bVar;
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            View.AccessibilityDelegate a2 = a(view);
            if (!(a2 instanceof C0111a)) {
                C0111a c0111a = new C0111a(weakReference, view, str, a2, z);
                view.setAccessibilityDelegate(c0111a);
                this.f9109c.put(view, c0111a);
                return;
            }
            ((C0111a) a2).a(z);
        }

        private View.AccessibilityDelegate a(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.baidu.mobstat.bi.a
        public void a(View view, boolean z) {
            a(this.f9107a, view, bj.a(view), z);
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C0111a> weakHashMap = this.f9109c;
            if (weakHashMap == null) {
                return;
            }
            for (Map.Entry<View, C0111a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f9109c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.f9106a == null) {
            bi biVar = new bi(activity, this, z);
            this.f9106a = biVar;
            biVar.a(jSONObject);
        }
        this.f9106a.a(activity);
    }
}
