package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
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
/* loaded from: classes7.dex */
public class at {
    private static final at u = new at();

    /* renamed from: a  reason: collision with root package name */
    private Context f2547a;
    private WeakReference<Activity> b;
    private Handler c;
    private long g;
    private long h;
    private long i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private boolean q;
    private a v;
    private boolean d = true;
    private ArrayList<WeakReference<View>> e = new ArrayList<>();
    private volatile MtjConfig.FeedTrackStrategy f = MtjConfig.FeedTrackStrategy.TRACK_ALL;
    private List<WeakReference<View>> r = new ArrayList();
    private HashMap<WeakReference<View>, ArrayList<ap>> s = new HashMap<>();
    private HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> t = new HashMap<>();
    private ViewTreeObserver.OnScrollChangedListener w = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.mobstat.at.11
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            at.this.a(at.this.b);
        }
    };
    private Runnable x = null;
    private float y = 0.0f;
    private float z = 0.0f;
    private Object A = new Object();

    /* loaded from: classes7.dex */
    public interface a {
        void a(ao aoVar);

        void a(ArrayList<ap> arrayList);

        void b(ArrayList<aq> arrayList);
    }

    public static at a() {
        return u;
    }

    private at() {
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    public void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        this.f = feedTrackStrategy;
    }

    public boolean b() {
        if (this.f != MtjConfig.FeedTrackStrategy.TRACK_NONE) {
            return false;
        }
        return true;
    }

    private boolean a(View view) {
        if (this.f == MtjConfig.FeedTrackStrategy.TRACK_ALL) {
            return false;
        }
        return (this.f == MtjConfig.FeedTrackStrategy.TRACK_SINGLE && bj.v(view)) ? false : true;
    }

    public void a(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.1
                @Override // java.lang.Runnable
                public void run() {
                    at.this.d = true;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null) {
                        at.this.a(activity2, currentTimeMillis);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, long j) {
        this.f2547a = activity.getApplicationContext();
        this.b = new WeakReference<>(activity);
        this.g = j;
        String e = bj.e(activity);
        if (bj.a(e, this.j)) {
            this.p = false;
            if (a(e, this.k, this.j, this.i, this.g, activity)) {
                this.p = true;
            }
        }
    }

    public void b(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.6
                @Override // java.lang.Runnable
                public void run() {
                    at.this.d = false;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null) {
                        at.this.b(activity2, currentTimeMillis);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, long j) {
        this.h = j;
        String e = bj.e(activity);
        this.j = e;
        if (!TextUtils.isEmpty(this.k) && !this.k.equals(e)) {
            this.i = 0L;
        }
        if (this.p) {
            a(activity, this.g, j, this.r);
            this.r.clear();
            this.q = false;
        }
        a(this.s, this.t, j);
        b(this.s);
        c(this.s);
        e(this.t);
        f(this.t);
        a(this.e, this.w);
    }

    public void c(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.7
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null) {
                        at.this.c(activity2, currentTimeMillis);
                    }
                }
            });
        }
    }

    public void a(final View view, Activity activity) {
        if (view != null && activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final WeakReference weakReference2 = new WeakReference(view);
            final long currentTimeMillis = System.currentTimeMillis();
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.8
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null && ((View) weakReference2.get()) != null) {
                        at.this.a(view, activity2, currentTimeMillis);
                    }
                }
            });
        }
    }

    public void a(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.9
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    if (at.this.b != null && (activity = (Activity) at.this.b.get()) != null) {
                        String e = bj.e(activity);
                        if (!TextUtils.isEmpty(at.this.k) && at.this.k.equals(e)) {
                            at.this.c();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Activity activity, long j) {
        View a2 = bj.a(view, activity);
        View n = bj.n(a2);
        if (n == null) {
            if (!this.p) {
                c();
            }
        } else if (a(n)) {
            if (!this.p) {
                c();
            }
        } else {
            this.i = j;
            this.k = bj.e(activity);
            this.l = bj.s(a2);
            this.m = bj.c(n, this.k);
            this.n = bj.r(n);
            this.o = a(activity, a2, n);
        }
    }

    public String a(Activity activity, View view, View view2) {
        String s = bj.s(view);
        String t = bj.t(view);
        String e = bj.e(activity);
        boolean r = bj.r(view2);
        return aq.a(t, e, bj.a(activity, view), s, bj.a(view, bj.b(view2)), bj.c(view2, bj.e(activity)), r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i = 0L;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = false;
        this.o = "";
    }

    public void a(final String str) {
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.at.10
            @Override // java.lang.Runnable
            public void run() {
                as.a().a(str);
            }
        });
    }

    public void a(final WeakReference<Activity> weakReference) {
        if (weakReference != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.at.12
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        at.this.d(activity, currentTimeMillis);
                    }
                }
            };
            if (this.x != null) {
                this.c.removeCallbacks(this.x);
            }
            this.x = runnable;
            this.c.postDelayed(runnable, 350L);
        }
    }

    private void a(ArrayList<WeakReference<View>> arrayList, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            WeakReference<View> weakReference = arrayList.get(i);
            if (weakReference != null) {
                a(weakReference.get(), onScrollChangedListener);
            }
        }
        arrayList.clear();
    }

    private void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        ViewTreeObserver viewTreeObserver;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    private void a(ArrayList<WeakReference<View>> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
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
    }

    private void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, ArrayList<WeakReference<View>> arrayList) {
        ViewTreeObserver viewTreeObserver;
        if (view != null && !a(arrayList, view) && !a(view) && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            try {
                viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
                arrayList.add(new WeakReference<>(view));
            } catch (Exception e) {
            }
        }
    }

    private boolean a(ArrayList<WeakReference<View>> arrayList, View view) {
        boolean z;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (view != arrayList.get(i).get()) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        return z;
    }

    private boolean a(String str, String str2, String str3, long j, long j2, Activity activity) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str.equals(str2) || !str2.equals(str3) || (activity instanceof IIgnoreAutoTrace)) {
            return false;
        }
        long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 5000) {
            return false;
        }
        return true;
    }

    private boolean a(long j, long j2) {
        long j3 = j2 - j;
        if (j3 <= 0 || j3 <= 50) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, long j) {
        HashMap<View, Integer> hashMap = new HashMap<>();
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        View a2 = bj.a(activity);
        a(activity, a2, hashMap, arrayList, arrayList2);
        if (this.p && !this.q && a(this.g, j)) {
            ArrayList<WeakReference<View>> a3 = a(hashMap);
            a3.add(new WeakReference<>(a2));
            this.r = a3;
            this.q = true;
        }
        Iterator<View> it = arrayList2.iterator();
        while (it.hasNext()) {
            a(it.next(), this.w, this.e);
        }
        a(this.e);
        if (this.d) {
            a(this.b, j);
            this.d = false;
        }
        a(this.s, j);
        Iterator<View> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            b(it2.next(), activity, j);
        }
    }

    private void a(Activity activity, View view, HashMap<View, Integer> hashMap, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int width;
        if (view != null && !bj.c(activity, view)) {
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
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < viewGroup.getChildCount()) {
                        a(activity, viewGroup.getChildAt(i2), hashMap, arrayList, arrayList2);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
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
        View view2;
        if (list != null) {
            if (list.size() == 0) {
                list.add(new WeakReference<>(bj.a(activity)));
            }
            Iterator<WeakReference<View>> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                WeakReference<View> next = it.next();
                if (next != null && (view2 = next.get()) != null) {
                    view = view2;
                    break;
                }
            }
            if (!TextUtils.isEmpty(this.l)) {
                String str = this.m;
                if (!TextUtils.isEmpty(str)) {
                    String e = bj.e(activity);
                    String f = bj.f(activity);
                    ArrayList<Integer> a2 = a(activity, view);
                    int a3 = ah.a(this.f2547a, a2.get(0).intValue());
                    int a4 = ah.a(this.f2547a, a2.get(1).intValue());
                    ArrayList<Integer> b = bj.b(activity, view);
                    int a5 = ah.a(this.f2547a, b.get(0).intValue());
                    int a6 = ah.a(this.f2547a, b.get(1).intValue());
                    int i = a5 > a3 ? a5 : a3;
                    int i2 = a6 > a4 ? a6 : a4;
                    if (i != 0 && i2 != 0) {
                        a(this.f2547a, new ao(e, f, this.l, j2 - j, j, a5, a6, i, i2, str, this.n, this.o));
                    }
                }
            }
        }
    }

    private void a(Context context, ao aoVar) {
        if (aoVar != null) {
            if (this.v != null) {
                this.v.a(aoVar);
            }
            aw.a().a(context, aoVar);
        }
    }

    private void b(View view, Activity activity, long j) {
        if (view != null && bj.d(view)) {
            a(this.s, view, new ap(bj.c(view, bj.e(activity)), j, j, j, bj.r(view)));
        }
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, long j) {
        if (hashMap != null && hashMap.size() != 0) {
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

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, View view, ap apVar) {
        ap apVar2;
        String a2 = apVar.a();
        long c = apVar.c();
        long e = apVar.e();
        boolean d = apVar.d();
        if (!TextUtils.isEmpty(a2)) {
            WeakReference<View> weakReference = null;
            ArrayList<ap> arrayList = null;
            LinkedHashMap<WeakReference<View>, ArrayList<ap>> a3 = a(hashMap, view);
            if (a3 != null && a3.size() > 0) {
                Iterator<Map.Entry<WeakReference<View>, ArrayList<ap>>> it = a3.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<WeakReference<View>, ArrayList<ap>> next = it.next();
                    weakReference = next.getKey();
                    arrayList = next.getValue();
                }
            }
            if (arrayList != null) {
                Iterator<ap> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    apVar2 = it2.next();
                    String a4 = apVar2.a();
                    long c2 = apVar2.c();
                    long e2 = apVar2.e();
                    boolean d2 = apVar2.d();
                    if (a2.equals(a4) && d == d2 && (e2 >= c2 || c2 == c)) {
                        break;
                    }
                }
            }
            apVar2 = null;
            if (apVar2 == null) {
                ArrayList<ap> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
                arrayList2.add(apVar);
                hashMap.put(weakReference == null ? new WeakReference<>(view) : weakReference, arrayList2);
                return;
            }
            apVar2.a(c);
            apVar2.b(e);
        }
    }

    private void b(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        d(hashMap);
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
                long b = apVar.b() - apVar2.b();
                if (b > 0) {
                    return 1;
                }
                if (b < 0) {
                    return -1;
                }
                return 0;
            }
        });
        if (this.v != null) {
            this.v.a(arrayList);
        }
        aw.a().a(this.f2547a, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, long j) {
        View view;
        b(this.t, j);
        Iterator<WeakReference<View>> it = this.e.iterator();
        while (it.hasNext()) {
            WeakReference<View> next = it.next();
            if (next != null && (view = next.get()) != null && bj.d(view) && !a(view) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt != null && bj.d(childAt)) {
                            a(view, childAt, activity, j);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    private void b(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, long j) {
        if (hashMap != null && hashMap.size() != 0) {
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
    }

    private void a(View view, View view2, Activity activity, long j) {
        if (view != null && view2 != null && bj.a(view2, as.a().c())) {
            String s = bj.s(view2);
            String t = bj.t(view2);
            String e = bj.e(activity);
            boolean r = bj.r(view);
            a(this.t, view, new aq(t, e, bj.a(activity, view2), s, bj.a(view2, bj.b(view)), bj.c(view, bj.e(activity)), r, 1, j, j, j, String.valueOf(j - j), ""));
        }
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, View view, aq aqVar) {
        HashMap<String, ArrayList<aq>> hashMap2;
        aq aqVar2;
        aq aqVar3;
        if (view != null) {
            long k = aqVar.k();
            long j = aqVar.j();
            String d = aqVar.d();
            String f = aqVar.f();
            if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(f)) {
                WeakReference<View> weakReference = null;
                LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> b = b(hashMap, view);
                if (b != null && b.size() > 0) {
                    Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>>> it = b.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry<WeakReference<View>, HashMap<String, ArrayList<aq>>> next = it.next();
                        hashMap2 = next.getValue();
                        weakReference = next.getKey();
                        if (hashMap2 != null) {
                            aqVar2 = null;
                        } else {
                            aqVar2 = null;
                            for (Map.Entry<String, ArrayList<aq>> entry : hashMap2.entrySet()) {
                                ArrayList<aq> value = entry.getValue();
                                if (value != null && value.size() != 0) {
                                    Iterator<aq> it2 = value.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            aqVar3 = aqVar2;
                                            break;
                                        }
                                        aqVar3 = it2.next();
                                        long k2 = aqVar3.k();
                                        long j2 = aqVar3.j();
                                        if (a(aqVar3, aqVar) && (k2 >= j2 || j2 == aqVar.j())) {
                                            break;
                                        }
                                    }
                                    aqVar2 = aqVar3;
                                }
                            }
                        }
                        if (aqVar2 != null) {
                            String a2 = a(aqVar);
                            if (!TextUtils.isEmpty(a2)) {
                                if (hashMap2 == null) {
                                    HashMap<String, ArrayList<aq>> hashMap3 = new HashMap<>();
                                    ArrayList<aq> arrayList = new ArrayList<>();
                                    arrayList.add(aqVar);
                                    hashMap3.put(a2, arrayList);
                                    hashMap.put(weakReference == null ? new WeakReference<>(view) : weakReference, hashMap3);
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
                            return;
                        }
                        aqVar2.a(j);
                        aqVar2.b(k);
                        aqVar2.a(String.valueOf(aqVar2.j() - aqVar2.i()));
                        return;
                    }
                }
                hashMap2 = null;
                if (hashMap2 != null) {
                }
                if (aqVar2 != null) {
                }
            }
        }
    }

    private boolean a(aq aqVar, aq aqVar2) {
        String a2 = aqVar2.a();
        String b = aqVar2.b();
        JSONArray c = aqVar2.c();
        String d = aqVar2.d();
        String e = aqVar2.e();
        String f = aqVar2.f();
        boolean g = aqVar2.g();
        String a3 = aqVar.a();
        String b2 = aqVar.b();
        JSONArray c2 = aqVar.c();
        String d2 = aqVar.d();
        String e2 = aqVar.e();
        String f2 = aqVar.f();
        boolean g2 = aqVar.g();
        if (!a(a3, a2) || !a(b2, b) || !a(c2, c) || !a(d2, d) || !a(e2, e) || !a(f2, f) || g2 != g) {
            return false;
        }
        return true;
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

    private String a(aq aqVar) {
        return aq.a(aqVar.a(), aqVar.b(), aqVar.c(), aqVar.d(), aqVar.e(), aqVar.f(), aqVar.g());
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
                long i = aqVar.i() - aqVar2.i();
                if (i > 0) {
                    return 1;
                }
                if (i < 0) {
                    return -1;
                }
                return 0;
            }
        });
        if (this.v != null) {
            this.v.b(arrayList);
        }
        aw.a().b(this.f2547a, arrayList);
    }

    private ArrayList<aq> h(HashMap<String, ArrayList<aq>> hashMap) {
        ArrayList<aq> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<aq>> entry : hashMap.entrySet()) {
            aq b = b(entry.getValue());
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private aq b(ArrayList<aq> arrayList) {
        long j;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<aq>() { // from class: com.baidu.mobstat.at.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(aq aqVar, aq aqVar2) {
                long i = aqVar.i() - aqVar2.i();
                if (i > 0) {
                    return 1;
                }
                if (i < 0) {
                    return -1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Iterator<aq> it = arrayList.iterator();
        int i = 0;
        long j2 = 0;
        aq aqVar = null;
        while (it.hasNext()) {
            aq next = it.next();
            long i2 = next.i();
            String l = next.l();
            if (Long.valueOf(l).longValue() >= as.a().d()) {
                if (j2 == 0) {
                    j = i2;
                    aqVar = next;
                } else {
                    j = j2;
                }
                long j3 = i2 - j;
                if (j3 < 0) {
                    j3 = 0;
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    sb2.append(l);
                } else {
                    sb2.append("|" + l);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append("" + j3);
                } else {
                    sb.append("|" + j3);
                }
                j2 = j;
                i = next.h() + i;
            }
        }
        if (aqVar != null) {
            aqVar.a(sb2.toString());
            aqVar.b(sb.toString());
            aqVar.a(i);
            return aqVar;
        }
        return aqVar;
    }

    private void a(WeakReference<Activity> weakReference, long j) {
        Activity activity;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            d(activity, j);
        }
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Integer> a(Activity activity, View view) {
        int i;
        int i2;
        int i3;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (view == null || activity == null) {
            arrayList.add(0);
            arrayList.add(0);
            return arrayList;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (view instanceof WebView) {
            synchronized (this.A) {
                a(activity, (WebView) view);
                try {
                    this.A.wait(5000L);
                } catch (Exception e) {
                }
                i3 = (int) (this.y * this.z);
            }
            i2 = 0;
        } else if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (scrollView.getChildCount() > 0) {
                i2 = scrollView.getChildAt(0).getWidth();
                i3 = scrollView.getChildAt(0).getHeight();
            }
            i3 = 0;
            i2 = 0;
        } else if (view instanceof ListView) {
            i3 = bj.a((ListView) view);
            i2 = 0;
        } else if (view instanceof GridView) {
            i3 = bj.a((GridView) view);
            i2 = 0;
        } else {
            if (bj.q(view)) {
                try {
                    RecyclerView recyclerView = (RecyclerView) view;
                    i = recyclerView.computeHorizontalScrollRange();
                    try {
                        i2 = i;
                        i3 = recyclerView.computeVerticalScrollRange();
                    } catch (Exception e2) {
                        i2 = i;
                        i3 = 0;
                        if (i2 == 0) {
                        }
                        if (i3 == 0) {
                        }
                        if (i2 <= 0) {
                        }
                        if (i3 > 0) {
                        }
                        arrayList.add(Integer.valueOf(i2));
                        arrayList.add(Integer.valueOf(r1));
                        return arrayList;
                    }
                } catch (Exception e3) {
                    i = 0;
                }
            }
            i3 = 0;
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = width;
        }
        if (i3 == 0) {
            i3 = height;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int i4 = i3 > 0 ? i3 : 0;
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i4));
        return arrayList;
    }
}
