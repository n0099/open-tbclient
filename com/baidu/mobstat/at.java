package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobstat.MtjConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class at {
    public static final at u = new at();

    /* renamed from: a  reason: collision with root package name */
    public Context f8621a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f8622b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f8623c;

    /* renamed from: g  reason: collision with root package name */
    public long f8627g;

    /* renamed from: h  reason: collision with root package name */
    public long f8628h;

    /* renamed from: i  reason: collision with root package name */
    public long f8629i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public a v;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8624d = true;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<WeakReference<View>> f8625e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public volatile MtjConfig.FeedTrackStrategy f8626f = MtjConfig.FeedTrackStrategy.TRACK_ALL;
    public List<WeakReference<View>> r = new ArrayList();
    public HashMap<WeakReference<View>, ArrayList<ap>> s = new HashMap<>();
    public HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> t = new HashMap<>();
    public ViewTreeObserver.OnScrollChangedListener w = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.mobstat.at.11
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            at atVar = at.this;
            atVar.a(atVar.f8622b);
        }
    };
    public Runnable x = null;
    public float y = 0.0f;
    public float z = 0.0f;
    public Object A = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void a(ao aoVar);

        void a(ArrayList<ap> arrayList);

        void b(ArrayList<aq> arrayList);
    }

    public at() {
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.f8623c = new Handler(handlerThread.getLooper());
    }

    private boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 > 0 && j3 > 50;
    }

    private void e(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        g(hashMap);
    }

    private void f(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> entry : hashMap.entrySet()) {
            HashMap<String, ArrayList<aq>> value = entry.getValue();
            if (value != null) {
                for (Map.Entry<String, ArrayList<aq>> entry2 : value.entrySet()) {
                    entry2.getValue().clear();
                }
                value.clear();
            }
        }
        hashMap.clear();
    }

    private void g(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        ArrayList<aq> arrayList = new ArrayList<>();
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> entry : hashMap.entrySet()) {
            arrayList.addAll(h(entry.getValue()));
        }
        Collections.sort(arrayList, new Comparator<aq>() { // from class: com.baidu.mobstat.at.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(aq aqVar, aq aqVar2) {
                int i2 = ((aqVar.i() - aqVar2.i()) > 0L ? 1 : ((aqVar.i() - aqVar2.i()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.b(arrayList);
        }
        aw.a().b(this.f8621a, arrayList);
    }

    private ArrayList<aq> h(HashMap<String, ArrayList<aq>> hashMap) {
        ArrayList<aq> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<aq>> entry : hashMap.entrySet()) {
            aq b2 = b(entry.getValue());
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    private void d(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        ArrayList<ap> arrayList = new ArrayList<>();
        for (Map.Entry<WeakReference<View>, ArrayList<ap>> entry : this.s.entrySet()) {
            ArrayList<ap> value = entry.getValue();
            if (value != null && value.size() != 0) {
                arrayList.addAll(value);
            }
        }
        Collections.sort(arrayList, new Comparator<ap>() { // from class: com.baidu.mobstat.at.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ap apVar, ap apVar2) {
                int i2 = ((apVar.b() - apVar2.b()) > 0L ? 1 : ((apVar.b() - apVar2.b()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(arrayList);
        }
        aw.a().a(this.f8621a, arrayList);
    }

    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.7
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                at.this.c(activity2, currentTimeMillis);
            }
        });
    }

    public boolean b() {
        return this.f8626f == MtjConfig.FeedTrackStrategy.TRACK_NONE;
    }

    public void b(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.6
            @Override // java.lang.Runnable
            public void run() {
                at.this.f8624d = false;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                at.this.b(activity2, currentTimeMillis);
            }
        });
    }

    public static at a() {
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f8629i = 0L;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = false;
        this.o = "";
    }

    public void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        this.f8626f = feedTrackStrategy;
    }

    private boolean a(View view) {
        if (this.f8626f == MtjConfig.FeedTrackStrategy.TRACK_ALL) {
            return false;
        }
        return (this.f8626f == MtjConfig.FeedTrackStrategy.TRACK_SINGLE && bj.v(view)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, long j) {
        this.f8628h = j;
        String e2 = bj.e(activity);
        this.j = e2;
        if (!TextUtils.isEmpty(this.k) && !this.k.equals(e2)) {
            this.f8629i = 0L;
        }
        if (this.p) {
            a(activity, this.f8627g, j, this.r);
            this.r.clear();
            this.q = false;
        }
        a(this.s, this.t, j);
        b(this.s);
        c(this.s);
        e(this.t);
        f(this.t);
        a(this.f8625e, this.w);
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.1
            @Override // java.lang.Runnable
            public void run() {
                at.this.f8624d = true;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                at.this.a(activity2, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, long j) {
        HashMap<View, Integer> hashMap = new HashMap<>();
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        View a2 = bj.a(activity);
        a(activity, a2, hashMap, arrayList, arrayList2);
        if (this.p && !this.q && a(this.f8627g, j)) {
            ArrayList<WeakReference<View>> a3 = a(hashMap);
            a3.add(new WeakReference<>(a2));
            this.r = a3;
            this.q = true;
        }
        Iterator<View> it = arrayList2.iterator();
        while (it.hasNext()) {
            a(it.next(), this.w, this.f8625e);
        }
        a(this.f8625e);
        if (this.f8624d) {
            a(this.f8622b, j);
            this.f8624d = false;
        }
        a(this.s, j);
        Iterator<View> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            b(it2.next(), activity, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, long j) {
        this.f8621a = activity.getApplicationContext();
        this.f8622b = new WeakReference<>(activity);
        this.f8627g = j;
        String e2 = bj.e(activity);
        if (bj.a(e2, this.j)) {
            this.p = false;
            if (a(e2, this.k, this.j, this.f8629i, this.f8627g, activity)) {
                this.p = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, long j) {
        View view;
        b(this.t, j);
        Iterator<WeakReference<View>> it = this.f8625e.iterator();
        while (it.hasNext()) {
            WeakReference<View> next = it.next();
            if (next != null && (view = next.get()) != null && bj.d(view) && !a(view) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null && bj.d(childAt)) {
                        a(view, childAt, activity, j);
                    }
                }
            }
        }
    }

    public void a(final View view, Activity activity) {
        if (view == null || activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final WeakReference weakReference2 = new WeakReference(view);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.8
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || ((View) weakReference2.get()) == null) {
                    return;
                }
                at.this.a(view, activity2, currentTimeMillis);
            }
        });
    }

    private void b(View view, Activity activity, long j) {
        if (view != null && bj.d(view)) {
            a(this.s, view, new ap(bj.c(view, bj.e(activity)), j, j, j, bj.r(view)));
        }
    }

    public void a(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.9
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    if (at.this.f8622b == null || (activity = (Activity) at.this.f8622b.get()) == null) {
                        return;
                    }
                    String e2 = bj.e(activity);
                    if (TextUtils.isEmpty(at.this.k) || !at.this.k.equals(e2)) {
                        return;
                    }
                    at.this.c();
                }
            });
        }
    }

    private void b(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        d(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Activity activity, long j) {
        View a2 = bj.a(view, activity);
        View n = bj.n(a2);
        if (n == null) {
            if (this.p) {
                return;
            }
            c();
        } else if (a(n)) {
            if (this.p) {
                return;
            }
            c();
        } else {
            this.f8629i = j;
            this.k = bj.e(activity);
            this.l = bj.s(a2);
            this.m = bj.c(n, this.k);
            this.n = bj.r(n);
            this.o = a(activity, a2, n);
        }
    }

    private void b(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, long j) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> entry : hashMap.entrySet()) {
            HashMap<String, ArrayList<aq>> value = entry.getValue();
            if (value != null) {
                for (Map.Entry<String, ArrayList<aq>> entry2 : value.entrySet()) {
                    ArrayList<aq> value2 = entry2.getValue();
                    if (value2 != null && value2.size() != 0) {
                        Iterator<aq> it = value2.iterator();
                        while (it.hasNext()) {
                            aq next = it.next();
                            if (next.k() == next.j()) {
                                next.a(j);
                                next.a(String.valueOf(next.j() - next.i()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void c(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        for (Map.Entry<WeakReference<View>, ArrayList<ap>> entry : hashMap.entrySet()) {
            ArrayList<ap> value = entry.getValue();
            if (value != null) {
                value.clear();
            }
        }
        hashMap.clear();
    }

    public String a(Activity activity, View view, View view2) {
        String s = bj.s(view);
        String t = bj.t(view);
        String e2 = bj.e(activity);
        boolean r = bj.r(view2);
        return aq.a(t, e2, bj.a(activity, view), s, bj.a(view, bj.b(view2)), bj.c(view2, bj.e(activity)), r);
    }

    private LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> b(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, View view) {
        View view2;
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> entry : hashMap.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view2 = key.get()) != null && view2 == view) {
                LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(key, entry.getValue());
                return linkedHashMap;
            }
        }
        return null;
    }

    public void a(final String str) {
        this.f8623c.post(new Runnable() { // from class: com.baidu.mobstat.at.10
            @Override // java.lang.Runnable
            public void run() {
                as.a().a(str);
            }
        });
    }

    public void a(final WeakReference<Activity> weakReference) {
        if (weakReference == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.at.12
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = (Activity) weakReference.get();
                if (activity == null) {
                    return;
                }
                at.this.d(activity, currentTimeMillis);
            }
        };
        Runnable runnable2 = this.x;
        if (runnable2 != null) {
            this.f8623c.removeCallbacks(runnable2);
        }
        this.x = runnable;
        this.f8623c.postDelayed(runnable, 350L);
    }

    private aq b(ArrayList<aq> arrayList) {
        aq aqVar = null;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<aq>() { // from class: com.baidu.mobstat.at.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(aq aqVar2, aq aqVar3) {
                int i2 = ((aqVar2.i() - aqVar3.i()) > 0L ? 1 : ((aqVar2.i() - aqVar3.i()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        Iterator<aq> it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            aq next = it.next();
            long i3 = next.i();
            String l = next.l();
            if (Long.valueOf(l).longValue() >= as.a().d()) {
                if (j == 0) {
                    aqVar = next;
                    j = i3;
                }
                long j2 = i3 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    sb2.append(l);
                } else {
                    sb2.append("|" + l);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append("" + j2);
                } else {
                    sb.append("|" + j2);
                }
                i2 += next.h();
            }
        }
        if (aqVar != null) {
            aqVar.a(sb2.toString());
            aqVar.b(sb.toString());
            aqVar.a(i2);
        }
        return aqVar;
    }

    private void a(ArrayList<WeakReference<View>> arrayList, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WeakReference<View> weakReference = arrayList.get(i2);
            if (weakReference != null) {
                a(weakReference.get(), onScrollChangedListener);
            }
        }
        arrayList.clear();
    }

    private void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        ViewTreeObserver viewTreeObserver;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
    }

    private void a(ArrayList<WeakReference<View>> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<WeakReference<View>> it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference<View> next = it.next();
            if (next == null) {
                arrayList2.add(next);
            } else {
                View view = next.get();
                if (view == null) {
                    arrayList2.add(next);
                } else {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        arrayList.removeAll(arrayList2);
    }

    private void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, ArrayList<WeakReference<View>> arrayList) {
        ViewTreeObserver viewTreeObserver;
        if (view != null && !a(arrayList, view) && !a(view) && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            try {
                viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
                arrayList.add(new WeakReference<>(view));
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(ArrayList<WeakReference<View>> arrayList, View view) {
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (view == arrayList.get(i2).get()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, String str2, String str3, long j, long j2, Activity activity) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str.equals(str2) || !str2.equals(str3) || (activity instanceof IIgnoreAutoTrace)) {
            return false;
        }
        long j3 = j2 - j;
        return j3 > 0 && j3 < 5000;
    }

    private void a(Activity activity, View view, HashMap<View, Integer> hashMap, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int width;
        if (view == null || bj.c(activity, view)) {
            return;
        }
        boolean m = bj.m(view);
        if (m && !a(view) && bj.d(view)) {
            arrayList.add(view);
        }
        if (m) {
            arrayList2.add(view);
        }
        if ((m || (view instanceof WebView) || (view instanceof ScrollView)) && (width = view.getWidth() * view.getHeight()) != 0) {
            hashMap.put(view, Integer.valueOf(width));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(activity, viewGroup.getChildAt(i2), hashMap, arrayList, arrayList2);
            }
        }
    }

    private ArrayList<WeakReference<View>> a(HashMap<View, Integer> hashMap) {
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<View, Integer>>() { // from class: com.baidu.mobstat.at.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<View, Integer> entry, Map.Entry<View, Integer> entry2) {
                return entry2.getValue().compareTo(entry.getValue());
            }
        });
        ArrayList<WeakReference<View>> arrayList2 = new ArrayList<>(arrayList.size());
        for (Map.Entry entry : arrayList) {
            arrayList2.add(new WeakReference<>(entry.getKey()));
        }
        return arrayList2;
    }

    private void a(Activity activity, long j, long j2, List<WeakReference<View>> list) {
        View view;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            list.add(new WeakReference<>(bj.a(activity)));
        }
        View view2 = null;
        Iterator<WeakReference<View>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference<View> next = it.next();
            if (next != null && (view = next.get()) != null) {
                view2 = view;
                break;
            }
        }
        if (TextUtils.isEmpty(this.l)) {
            return;
        }
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String e2 = bj.e(activity);
        String f2 = bj.f(activity);
        ArrayList<Integer> a2 = a(activity, view2);
        int a3 = ah.a(this.f8621a, a2.get(0).intValue());
        int a4 = ah.a(this.f8621a, a2.get(1).intValue());
        ArrayList<Integer> b2 = bj.b(activity, view2);
        int a5 = ah.a(this.f8621a, b2.get(0).intValue());
        int a6 = ah.a(this.f8621a, b2.get(1).intValue());
        if (a5 > a3) {
            a3 = a5;
        }
        if (a6 > a4) {
            a4 = a6;
        }
        if (a3 == 0 || a4 == 0) {
            return;
        }
        a(this.f8621a, new ao(e2, f2, this.l, j2 - j, j, a5, a6, a3, a4, str, this.n, this.o));
    }

    private void a(Context context, ao aoVar) {
        if (aoVar == null) {
            return;
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(aoVar);
        }
        aw.a().a(context, aoVar);
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, long j) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        for (Map.Entry<WeakReference<View>, ArrayList<ap>> entry : hashMap.entrySet()) {
            ArrayList<ap> value = entry.getValue();
            if (value != null && value.size() != 0) {
                Iterator<ap> it = value.iterator();
                while (it.hasNext()) {
                    ap next = it.next();
                    if (next.e() == next.c()) {
                        next.a(j);
                    }
                }
            }
        }
    }

    private LinkedHashMap<WeakReference<View>, ArrayList<ap>> a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, View view) {
        View view2;
        for (Map.Entry<WeakReference<View>, ArrayList<ap>> entry : hashMap.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view2 = key.get()) != null && view2 == view) {
                LinkedHashMap<WeakReference<View>, ArrayList<ap>> linkedHashMap = new LinkedHashMap<>(1);
                linkedHashMap.put(key, entry.getValue());
                return linkedHashMap;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, View view, ap apVar) {
        ArrayList<ap> arrayList;
        WeakReference<View> weakReference;
        ap apVar2;
        String a2 = apVar.a();
        long c2 = apVar.c();
        long e2 = apVar.e();
        boolean d2 = apVar.d();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        LinkedHashMap<WeakReference<View>, ArrayList<ap>> a3 = a(hashMap, view);
        if (a3 != null && a3.size() > 0) {
            Iterator<Map.Entry<WeakReference<View>, ArrayList<ap>>> it = a3.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<WeakReference<View>, ArrayList<ap>> next = it.next();
                weakReference = next.getKey();
                arrayList = next.getValue();
                if (arrayList != null) {
                    Iterator<ap> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ap next2 = it2.next();
                        String a4 = next2.a();
                        long c3 = next2.c();
                        long e3 = next2.e();
                        boolean d3 = next2.d();
                        if (a2.equals(a4) && d2 == d3 && (e3 >= c3 || c3 == c2)) {
                            apVar2 = next2;
                            break;
                        }
                    }
                }
                apVar2 = null;
                if (apVar2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(apVar);
                    if (weakReference == null) {
                        weakReference = new WeakReference<>(view);
                    }
                    hashMap.put(weakReference, arrayList);
                    return;
                }
                apVar2.a(c2);
                apVar2.b(e2);
                return;
            }
        }
        arrayList = null;
        weakReference = null;
        if (arrayList != null) {
        }
        apVar2 = null;
        if (apVar2 != null) {
        }
    }

    private void a(View view, View view2, Activity activity, long j) {
        if (view == null || view2 == null || !bj.a(view2, as.a().c())) {
            return;
        }
        String s = bj.s(view2);
        String t = bj.t(view2);
        String e2 = bj.e(activity);
        boolean r = bj.r(view);
        a(this.t, view, new aq(t, e2, bj.a(activity, view2), s, bj.a(view2, bj.b(view)), bj.c(view, bj.e(activity)), r, 1, j, j, j, String.valueOf(j - j), ""));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, View view, aq aqVar) {
        HashMap<String, ArrayList<aq>> hashMap2;
        WeakReference<View> weakReference;
        if (view == null) {
            return;
        }
        long k = aqVar.k();
        long j = aqVar.j();
        String d2 = aqVar.d();
        String f2 = aqVar.f();
        if (TextUtils.isEmpty(d2) || TextUtils.isEmpty(f2)) {
            return;
        }
        LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> b2 = b(hashMap, view);
        aq aqVar2 = null;
        if (b2 != null && b2.size() > 0) {
            Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>>> it = b2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> next = it.next();
                weakReference = next.getKey();
                hashMap2 = next.getValue();
                if (hashMap2 != null) {
                    for (Map.Entry<String, ArrayList<aq>> entry : hashMap2.entrySet()) {
                        ArrayList<aq> value = entry.getValue();
                        if (value != null && value.size() != 0) {
                            Iterator<aq> it2 = value.iterator();
                            while (it2.hasNext()) {
                                aq next2 = it2.next();
                                long k2 = next2.k();
                                long j2 = next2.j();
                                if (a(next2, aqVar) && (k2 >= j2 || j2 == aqVar.j())) {
                                    aqVar2 = next2;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (aqVar2 != null) {
                    String a2 = a(aqVar);
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                    if (hashMap2 == null) {
                        HashMap<String, ArrayList<aq>> hashMap3 = new HashMap<>();
                        ArrayList<aq> arrayList = new ArrayList<>();
                        arrayList.add(aqVar);
                        hashMap3.put(a2, arrayList);
                        if (weakReference == null) {
                            weakReference = new WeakReference<>(view);
                        }
                        hashMap.put(weakReference, hashMap3);
                        return;
                    }
                    ArrayList<aq> arrayList2 = hashMap2.get(a2);
                    if (arrayList2 == null) {
                        ArrayList<aq> arrayList3 = new ArrayList<>();
                        arrayList3.add(aqVar);
                        hashMap2.put(a2, arrayList3);
                        return;
                    }
                    arrayList2.add(aqVar);
                    return;
                }
                aqVar2.a(j);
                aqVar2.b(k);
                aqVar2.a(String.valueOf(aqVar2.j() - aqVar2.i()));
                return;
            }
        }
        hashMap2 = null;
        weakReference = null;
        if (hashMap2 != null) {
        }
        if (aqVar2 != null) {
        }
    }

    private boolean a(aq aqVar, aq aqVar2) {
        return a(aqVar.a(), aqVar2.a()) && a(aqVar.b(), aqVar2.b()) && a(aqVar.c(), aqVar2.c()) && a(aqVar.d(), aqVar2.d()) && a(aqVar.e(), aqVar2.e()) && a(aqVar.f(), aqVar2.f()) && aqVar.g() == aqVar2.g();
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null) {
            return false;
        }
        return a(jSONArray.toString(), jSONArray2.toString());
    }

    private String a(aq aqVar) {
        return aq.a(aqVar.a(), aqVar.b(), aqVar.c(), aqVar.d(), aqVar.e(), aqVar.f(), aqVar.g());
    }

    private void a(WeakReference<Activity> weakReference, long j) {
        Activity activity;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        d(activity, j);
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap2, long j) {
        for (Map.Entry<WeakReference<View>, ArrayList<ap>> entry : hashMap.entrySet()) {
            ArrayList<ap> value = entry.getValue();
            if (value != null && value.size() != 0) {
                Iterator<ap> it = value.iterator();
                while (it.hasNext()) {
                    ap next = it.next();
                    if (next.e() == next.c()) {
                        next.a(j);
                    }
                }
            }
        }
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> entry2 : hashMap2.entrySet()) {
            HashMap<String, ArrayList<aq>> value2 = entry2.getValue();
            if (value2 != null && value2.size() != 0) {
                for (Map.Entry<String, ArrayList<aq>> entry3 : value2.entrySet()) {
                    ArrayList<aq> value3 = entry3.getValue();
                    if (value3 != null && value3.size() != 0) {
                        Iterator<aq> it2 = value3.iterator();
                        while (it2.hasNext()) {
                            aq next2 = it2.next();
                            if (next2.k() == next2.j()) {
                                next2.a(j);
                                next2.a(String.valueOf(next2.j() - next2.i()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(Activity activity, final WebView webView) {
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.at.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (at.this.A) {
                    at.this.y = webView.getContentHeight();
                    at.this.z = webView.getScale();
                    at.this.A.notifyAll();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Integer> a(Activity activity, View view) {
        int computeHorizontalScrollRange;
        int computeVerticalScrollRange;
        int a2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (view != null && activity != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (view instanceof WebView) {
                synchronized (this.A) {
                    a(activity, (WebView) view);
                    try {
                        this.A.wait(5000L);
                    } catch (Exception unused) {
                    }
                    a2 = (int) (this.y * this.z);
                }
            } else {
                if (view instanceof ScrollView) {
                    ScrollView scrollView = (ScrollView) view;
                    if (scrollView.getChildCount() > 0) {
                        computeHorizontalScrollRange = scrollView.getChildAt(0).getWidth();
                        computeVerticalScrollRange = scrollView.getChildAt(0).getHeight();
                    }
                    computeHorizontalScrollRange = 0;
                    computeVerticalScrollRange = 0;
                } else if (view instanceof ListView) {
                    a2 = bj.a((ListView) view);
                } else if (view instanceof GridView) {
                    a2 = bj.a((GridView) view);
                } else {
                    if (bj.q(view)) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) view;
                            computeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
                            try {
                                computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                        }
                    }
                    computeHorizontalScrollRange = 0;
                    computeVerticalScrollRange = 0;
                }
                if (computeHorizontalScrollRange != 0) {
                    width = computeHorizontalScrollRange;
                }
                if (computeVerticalScrollRange != 0) {
                    height = computeVerticalScrollRange;
                }
                if (width <= 0) {
                    width = 0;
                }
                int i2 = height > 0 ? height : 0;
                arrayList.add(Integer.valueOf(width));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
            computeVerticalScrollRange = a2;
            computeHorizontalScrollRange = 0;
            if (computeHorizontalScrollRange != 0) {
            }
            if (computeVerticalScrollRange != 0) {
            }
            if (width <= 0) {
            }
            if (height > 0) {
            }
            arrayList.add(Integer.valueOf(width));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        arrayList.add(0);
        arrayList.add(0);
        return arrayList;
    }
}
