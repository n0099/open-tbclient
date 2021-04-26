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
    public bi f8992a;

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a extends bk {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f8993a;

        /* renamed from: b  reason: collision with root package name */
        public b f8994b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C0111a> f8995c = new WeakHashMap<>();

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0111a extends View.AccessibilityDelegate {

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f8997b;

            /* renamed from: c  reason: collision with root package name */
            public View f8998c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f8999d;

            public C0111a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.f8997b = accessibilityDelegate;
                a.this.f8993a = weakReference;
                this.f8998c = view;
                this.f8999d = z;
            }

            public void a(boolean z) {
                this.f8999d = z;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i2) {
                Activity activity;
                if (view == this.f8998c && i2 == 1) {
                    if (bd.c().b() && this.f8999d) {
                        bd c2 = bd.c();
                        c2.a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (bh.c().b()) {
                        bh c3 = bh.c();
                        c3.a("watch view  OnEvent:" + view.getClass().getName());
                    }
                    if (a.this.f8993a != null && (activity = (Activity) a.this.f8993a.get()) != null) {
                        a.this.f8994b.a(view, this.f8999d, activity);
                    }
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f8997b;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i2);
                } else {
                    super.sendAccessibilityEvent(view, i2);
                }
            }

            public View.AccessibilityDelegate a() {
                return this.f8997b;
            }
        }

        public a(int i2, WeakReference<Activity> weakReference, b bVar) {
            this.f8993a = weakReference;
            this.f8994b = bVar;
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            View.AccessibilityDelegate a2 = a(view);
            if (!(a2 instanceof C0111a)) {
                C0111a c0111a = new C0111a(weakReference, view, str, a2, z);
                view.setAccessibilityDelegate(c0111a);
                this.f8995c.put(view, c0111a);
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
            a(this.f8993a, view, bj.a(view), z);
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C0111a> weakHashMap = this.f8995c;
            if (weakHashMap == null) {
                return;
            }
            for (Map.Entry<View, C0111a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f8995c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.f8992a == null) {
            bi biVar = new bi(activity, this, z);
            this.f8992a = biVar;
            biVar.a(jSONObject);
        }
        this.f8992a.a(activity);
    }
}
