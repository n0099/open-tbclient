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
/* loaded from: classes3.dex */
public class as {
    public static final as u = new as();
    public Context a;
    public WeakReference<Activity> b;
    public Handler c;
    public long g;
    public long h;
    public long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public a v;
    public ViewTreeObserver.OnScrollChangedListener w;
    public boolean d = true;
    public List<WeakReference<View>> e = Collections.synchronizedList(new ArrayList());
    public volatile MtjConfig.FeedTrackStrategy f = MtjConfig.FeedTrackStrategy.TRACK_ALL;
    public List<WeakReference<View>> r = new ArrayList();
    public HashMap<WeakReference<View>, ArrayList<ao>> s = new HashMap<>();
    public HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> t = new HashMap<>();
    public Runnable x = null;
    public float y = 0.0f;
    public float z = 0.0f;
    public Object A = new Object();

    /* loaded from: classes3.dex */
    public interface a {
        void a(an anVar);

        void a(ArrayList<ao> arrayList);

        void b(ArrayList<ap> arrayList);
    }

    private boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 > 0 && j3 > 50;
    }

    public static as a() {
        return u;
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

    /* JADX INFO: Access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener d() {
        if (this.w == null) {
            this.w = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.mobstat.as.14
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    as asVar = as.this;
                    asVar.a(asVar.b);
                }
            };
        }
        return this.w;
    }

    public boolean b() {
        if (this.f == MtjConfig.FeedTrackStrategy.TRACK_NONE) {
            return true;
        }
        return false;
    }

    public as() {
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    private ap a(ArrayList<ap> arrayList) {
        ap apVar = null;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<ap>() { // from class: com.baidu.mobstat.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ap apVar2, ap apVar3) {
                int i = ((apVar2.i() - apVar3.i()) > 0L ? 1 : ((apVar2.i() - apVar3.i()) == 0L ? 0 : -1));
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
        int i = 0;
        Iterator<ap> it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            ap next = it.next();
            long i2 = next.i();
            String l = next.l();
            if (Long.valueOf(l).longValue() >= ar.a().d()) {
                if (j == 0) {
                    apVar = next;
                    j = i2;
                }
                long j2 = i2 - j;
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
                i += next.h();
            }
        }
        if (apVar != null) {
            apVar.a(sb2.toString());
            apVar.b(sb.toString());
            apVar.a(i);
        }
        return apVar;
    }

    private String a(ap apVar) {
        return ap.a(apVar.a(), apVar.b(), apVar.c(), apVar.d(), apVar.e(), apVar.f(), apVar.g());
    }

    private ArrayList<WeakReference<View>> a(HashMap<View, Integer> hashMap) {
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<View, Integer>>() { // from class: com.baidu.mobstat.as.3
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

    private void d(HashMap<WeakReference<View>, ArrayList<ao>> hashMap) {
        ArrayList<ao> arrayList = new ArrayList<>();
        for (Map.Entry<WeakReference<View>, ArrayList<ao>> entry : this.s.entrySet()) {
            ArrayList<ao> value = entry.getValue();
            if (value != null && value.size() != 0) {
                arrayList.addAll(value);
            }
        }
        Collections.sort(arrayList, new Comparator<ao>() { // from class: com.baidu.mobstat.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ao aoVar, ao aoVar2) {
                int i = ((aoVar.b() - aoVar2.b()) > 0L ? 1 : ((aoVar.b() - aoVar2.b()) == 0L ? 0 : -1));
                if (i > 0) {
                    return 1;
                }
                if (i < 0) {
                    return -1;
                }
                return 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(arrayList);
        }
        av.a().a(this.a, arrayList);
    }

    private void f(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap) {
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> entry : hashMap.entrySet()) {
            HashMap<String, ArrayList<ap>> value = entry.getValue();
            if (value != null) {
                for (Map.Entry<String, ArrayList<ap>> entry2 : value.entrySet()) {
                    entry2.getValue().clear();
                }
                value.clear();
            }
        }
        hashMap.clear();
    }

    private void g(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap) {
        ArrayList<ap> arrayList = new ArrayList<>();
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> entry : hashMap.entrySet()) {
            arrayList.addAll(h(entry.getValue()));
        }
        Collections.sort(arrayList, new Comparator<ap>() { // from class: com.baidu.mobstat.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ap apVar, ap apVar2) {
                int i = ((apVar.i() - apVar2.i()) > 0L ? 1 : ((apVar.i() - apVar2.i()) == 0L ? 0 : -1));
                if (i > 0) {
                    return 1;
                }
                if (i < 0) {
                    return -1;
                }
                return 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.b(arrayList);
        }
        av.a().b(this.a, arrayList);
    }

    private LinkedHashMap<WeakReference<View>, ArrayList<ao>> a(HashMap<WeakReference<View>, ArrayList<ao>> hashMap, View view2) {
        View view3;
        for (Map.Entry<WeakReference<View>, ArrayList<ao>> entry : hashMap.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view3 = key.get()) != null && view3 == view2) {
                LinkedHashMap<WeakReference<View>, ArrayList<ao>> linkedHashMap = new LinkedHashMap<>(1);
                linkedHashMap.put(key, entry.getValue());
                return linkedHashMap;
            }
        }
        return null;
    }

    private LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> b(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap, View view2) {
        View view3;
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> entry : hashMap.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view3 = key.get()) != null && view3 == view2) {
                LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(key, entry.getValue());
                return linkedHashMap;
            }
        }
        return null;
    }

    private void b(HashMap<WeakReference<View>, ArrayList<ao>> hashMap) {
        d(hashMap);
    }

    private void c(HashMap<WeakReference<View>, ArrayList<ao>> hashMap) {
        for (Map.Entry<WeakReference<View>, ArrayList<ao>> entry : hashMap.entrySet()) {
            ArrayList<ao> value = entry.getValue();
            if (value != null) {
                value.clear();
            }
        }
        hashMap.clear();
    }

    private void e(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap) {
        g(hashMap);
    }

    private ArrayList<ap> h(HashMap<String, ArrayList<ap>> hashMap) {
        ArrayList<ap> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<ap>> entry : hashMap.entrySet()) {
            ap a2 = a(entry.getValue());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, long j) {
        this.a = activity.getApplicationContext();
        this.b = new WeakReference<>(activity);
        this.g = j;
        String e = bi.e(activity);
        if (bi.a(e, this.j)) {
            this.p = false;
            if (a(e, this.k, this.j, this.i, this.g, activity)) {
                this.p = true;
            }
        }
    }

    private void a(Activity activity, long j, long j2, List<WeakReference<View>> list) {
        View view2;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            list.add(new WeakReference<>(bi.a(activity)));
        }
        View view3 = null;
        Iterator<WeakReference<View>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference<View> next = it.next();
            if (next != null && (view2 = next.get()) != null) {
                view3 = view2;
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
        String e = bi.e(activity);
        String f = bi.f(activity);
        ArrayList<Integer> a2 = a(activity, view3);
        int a3 = ag.a(this.a, a2.get(0).intValue());
        int a4 = ag.a(this.a, a2.get(1).intValue());
        ArrayList<Integer> b = bi.b(activity, view3);
        int a5 = ag.a(this.a, b.get(0).intValue());
        int a6 = ag.a(this.a, b.get(1).intValue());
        if (a5 > a3) {
            a3 = a5;
        }
        if (a6 > a4) {
            a4 = a6;
        }
        if (a3 != 0 && a4 != 0) {
            a(this.a, new an(e, f, this.l, j2 - j, j, a5, a6, a3, a4, str, this.n, this.o));
        }
    }

    private void a(Activity activity, View view2, HashMap<View, Integer> hashMap, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int width;
        if (view2 == null || bi.c(activity, view2)) {
            return;
        }
        boolean n = bi.n(view2);
        if (n && !a(view2) && bi.d(view2)) {
            arrayList.add(view2);
        }
        if (n) {
            arrayList2.add(view2);
        }
        if ((n || (view2 instanceof WebView) || (view2 instanceof ScrollView)) && (width = view2.getWidth() * view2.getHeight()) != 0) {
            hashMap.put(view2, Integer.valueOf(width));
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                try {
                    a(activity, viewGroup.getChildAt(i), hashMap, arrayList, arrayList2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(Activity activity, final WebView webView) {
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.as.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (as.this.A) {
                    as.this.y = webView.getContentHeight();
                    as.this.z = webView.getScale();
                    as.this.A.notifyAll();
                }
            }
        });
    }

    private void a(Context context, an anVar) {
        if (anVar == null) {
            return;
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(anVar);
        }
        av.a().a(context, anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, Activity activity, long j) {
        View a2 = bi.a(view2, activity);
        View o = bi.o(a2);
        if (o == null) {
            if (!this.p) {
                c();
            }
        } else if (a(o)) {
            if (!this.p) {
                c();
            }
        } else {
            this.i = j;
            this.k = bi.e(activity);
            this.l = "";
            Map<String, String> t = bi.t(a2);
            if (t != null && t.size() > 0 && !TextUtils.isEmpty(t.get("title"))) {
                this.l = t.get("title");
            }
            this.m = bi.c(o, this.k);
            this.n = bi.s(o);
            this.o = a(activity, a2, o);
        }
    }

    private void a(View view2, View view3, Activity activity, long j) {
        String str;
        String str2;
        if (view2 == null || view3 == null || !bi.a(view3, ar.a().c())) {
            return;
        }
        Map<String, String> t = bi.t(view3);
        String str3 = "";
        if (t == null || t.size() <= 0) {
            str = "";
        } else {
            if (TextUtils.isEmpty(t.get("title"))) {
                str2 = "";
            } else {
                str2 = t.get("title");
            }
            if (!TextUtils.isEmpty(t.get("content"))) {
                str3 = t.get("content");
            }
            str = str2;
        }
        String u2 = bi.u(view3);
        String e = bi.e(activity);
        boolean s = bi.s(view2);
        String str4 = str3;
        ap apVar = new ap(u2, e, bi.a(activity, view3), str, str4, bi.a(view3, bi.b(view2)), bi.c(view2, bi.e(activity)), s, 1, j, j, j, String.valueOf(j - j), "", new JSONArray());
        av.a().b(str3);
        a(this.t, view2, apVar);
    }

    private void a(View view2, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        ViewTreeObserver viewTreeObserver;
        if (view2 == null || (viewTreeObserver = view2.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, List<WeakReference<View>> list) {
        ViewTreeObserver viewTreeObserver;
        if (view2 == null || a(list, view2) || a(view2) || (viewTreeObserver = view2.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null || list == null) {
            return;
        }
        try {
            viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
            list.add(new WeakReference<>(view2));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, Activity activity, long j) {
        if (view2 == null || !bi.d(view2)) {
            return;
        }
        a(this.s, view2, new ao(bi.c(view2, bi.e(activity)), j, j, j, bi.s(view2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeakReference<Activity> weakReference, long j) {
        Activity activity;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        d(activity, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<WeakReference<View>, ArrayList<ao>> hashMap, long j) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<WeakReference<View>, ArrayList<ao>> entry : hashMap.entrySet()) {
                ArrayList<ao> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    Iterator<ao> it = value.iterator();
                    while (it.hasNext()) {
                        ao next = it.next();
                        if (next.e() == next.c()) {
                            next.a(j);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, long j) {
        this.h = j;
        String e = bi.e(activity);
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
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.as.9
                @Override // java.lang.Runnable
                public void run() {
                    as asVar = as.this;
                    asVar.a(asVar.e, as.this.d());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Activity activity, final long j) {
        HashMap<View, Integer> hashMap = new HashMap<>();
        final ArrayList<View> arrayList = new ArrayList<>();
        final ArrayList<View> arrayList2 = new ArrayList<>();
        View a2 = bi.a(activity);
        a(activity, a2, hashMap, arrayList, arrayList2);
        if (this.p && !this.q && a(this.g, j)) {
            ArrayList<WeakReference<View>> a3 = a(hashMap);
            a3.add(new WeakReference<>(a2));
            this.r = a3;
            this.q = true;
        }
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.as.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        as asVar = as.this;
                        asVar.a((View) it.next(), asVar.d(), as.this.e);
                    }
                    as.this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            as asVar2 = as.this;
                            asVar2.a(asVar2.e);
                            if (as.this.d) {
                                as asVar3 = as.this;
                                asVar3.a(asVar3.b, j);
                                as.this.d = false;
                            }
                            as asVar4 = as.this;
                            asVar4.a(asVar4.s, j);
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                as.this.b((View) it2.next(), activity, j);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<WeakReference<View>, ArrayList<ao>> hashMap, View view2, ao aoVar) {
        ArrayList<ao> arrayList;
        WeakReference<View> weakReference;
        ao aoVar2;
        String a2 = aoVar.a();
        long c = aoVar.c();
        long e = aoVar.e();
        boolean d = aoVar.d();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        LinkedHashMap<WeakReference<View>, ArrayList<ao>> a3 = a(hashMap, view2);
        if (a3 != null && a3.size() > 0) {
            Iterator<Map.Entry<WeakReference<View>, ArrayList<ao>>> it = a3.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<WeakReference<View>, ArrayList<ao>> next = it.next();
                weakReference = next.getKey();
                arrayList = next.getValue();
                if (arrayList != null) {
                    Iterator<ao> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ao next2 = it2.next();
                        String a4 = next2.a();
                        long c2 = next2.c();
                        long e2 = next2.e();
                        boolean d2 = next2.d();
                        if (a2.equals(a4) && d == d2 && (e2 >= c2 || c2 == c)) {
                            aoVar2 = next2;
                            break;
                        }
                    }
                }
                aoVar2 = null;
                if (aoVar2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(aoVar);
                    if (weakReference == null) {
                        weakReference = new WeakReference<>(view2);
                    }
                    hashMap.put(weakReference, arrayList);
                    return;
                }
                aoVar2.a(c);
                aoVar2.b(e);
                return;
            }
        }
        arrayList = null;
        weakReference = null;
        if (arrayList != null) {
        }
        aoVar2 = null;
        if (aoVar2 != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap, View view2, ap apVar) {
        HashMap<String, ArrayList<ap>> hashMap2;
        WeakReference<View> weakReference;
        if (view2 == null) {
            return;
        }
        long k = apVar.k();
        long j = apVar.j();
        String d = apVar.d();
        String f = apVar.f();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(f)) {
            LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> b = b(hashMap, view2);
            ap apVar2 = null;
            if (b != null && b.size() > 0) {
                Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>>> it = b.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> next = it.next();
                    weakReference = next.getKey();
                    hashMap2 = next.getValue();
                    if (hashMap2 != null) {
                        for (Map.Entry<String, ArrayList<ap>> entry : hashMap2.entrySet()) {
                            ArrayList<ap> value = entry.getValue();
                            if (value != null && value.size() != 0) {
                                Iterator<ap> it2 = value.iterator();
                                while (it2.hasNext()) {
                                    ap next2 = it2.next();
                                    long k2 = next2.k();
                                    long j2 = next2.j();
                                    if (a(next2, apVar) && (k2 >= j2 || j2 == apVar.j())) {
                                        apVar2 = next2;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (apVar2 != null) {
                        String a2 = a(apVar);
                        if (TextUtils.isEmpty(a2)) {
                            return;
                        }
                        if (hashMap2 == null) {
                            HashMap<String, ArrayList<ap>> hashMap3 = new HashMap<>();
                            ArrayList<ap> arrayList = new ArrayList<>();
                            arrayList.add(apVar);
                            hashMap3.put(a2, arrayList);
                            if (weakReference == null) {
                                weakReference = new WeakReference<>(view2);
                            }
                            hashMap.put(weakReference, hashMap3);
                            return;
                        }
                        ArrayList<ap> arrayList2 = hashMap2.get(a2);
                        if (arrayList2 == null) {
                            ArrayList<ap> arrayList3 = new ArrayList<>();
                            arrayList3.add(apVar);
                            hashMap2.put(a2, arrayList3);
                            return;
                        }
                        arrayList2.add(apVar);
                        return;
                    }
                    apVar2.a(j);
                    apVar2.b(k);
                    apVar2.a(String.valueOf(apVar2.j() - apVar2.i()));
                    return;
                }
            }
            hashMap2 = null;
            weakReference = null;
            if (hashMap2 != null) {
            }
            if (apVar2 != null) {
            }
        }
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ao>> hashMap, HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap2, long j) {
        HashMap<String, ArrayList<ap>> hashMap3;
        ArrayList<ao> arrayList;
        try {
            for (Map.Entry<WeakReference<View>, ArrayList<ao>> entry : hashMap.entrySet()) {
                try {
                    arrayList = entry.getValue();
                } catch (Exception unused) {
                    arrayList = null;
                }
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator<ao> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ao next = it.next();
                        if (next.e() == next.c()) {
                            next.a(j);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> entry2 : hashMap2.entrySet()) {
                try {
                    hashMap3 = entry2.getValue();
                } catch (Exception unused3) {
                    hashMap3 = null;
                }
                if (hashMap3 != null && hashMap3.size() != 0) {
                    for (Map.Entry<String, ArrayList<ap>> entry3 : hashMap3.entrySet()) {
                        ArrayList<ap> value = entry3.getValue();
                        if (value != null && value.size() != 0) {
                            Iterator<ap> it2 = value.iterator();
                            while (it2.hasNext()) {
                                ap next2 = it2.next();
                                if (next2.k() == next2.j()) {
                                    next2.a(j);
                                    next2.a(String.valueOf(next2.j() - next2.i()));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<WeakReference<View>> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                WeakReference<View> weakReference = null;
                try {
                    weakReference = list.get(i);
                } catch (Exception unused) {
                }
                if (weakReference == null) {
                    arrayList.add(weakReference);
                } else {
                    View view2 = weakReference.get();
                    if (view2 == null) {
                        arrayList.add(weakReference);
                    } else {
                        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            arrayList.add(weakReference);
                        }
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<WeakReference<View>> list, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                WeakReference<View> weakReference = null;
                try {
                    weakReference = list.get(i);
                } catch (Exception unused) {
                }
                if (weakReference != null) {
                    a(weakReference.get(), onScrollChangedListener);
                }
            }
            list.clear();
        }
    }

    private boolean a(View view2) {
        if (this.f == MtjConfig.FeedTrackStrategy.TRACK_ALL) {
            return false;
        }
        if (this.f == MtjConfig.FeedTrackStrategy.TRACK_SINGLE && bi.v(view2)) {
            return false;
        }
        return true;
    }

    public void b(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.8
            @Override // java.lang.Runnable
            public void run() {
                as.this.d = false;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                as.this.b(activity2, currentTimeMillis);
            }
        });
    }

    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.10
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                as.this.c(activity2, currentTimeMillis);
            }
        });
    }

    private boolean a(ap apVar, ap apVar2) {
        String a2 = apVar2.a();
        String b = apVar2.b();
        JSONArray c = apVar2.c();
        String d = apVar2.d();
        String e = apVar2.e();
        String f = apVar2.f();
        boolean g = apVar2.g();
        String a3 = apVar.a();
        String b2 = apVar.b();
        JSONArray c2 = apVar.c();
        String d2 = apVar.d();
        String e2 = apVar.e();
        String f2 = apVar.f();
        boolean g2 = apVar.g();
        if (!a(a3, a2) || !a(b2, b) || !a(c2, c) || !a(d2, d) || !a(e2, e) || !a(f2, f) || g2 != g) {
            return false;
        }
        return true;
    }

    private void b(HashMap<WeakReference<View>, HashMap<String, ArrayList<ap>>> hashMap, long j) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<ap>>> entry : hashMap.entrySet()) {
                HashMap<String, ArrayList<ap>> value = entry.getValue();
                if (value != null) {
                    for (Map.Entry<String, ArrayList<ap>> entry2 : value.entrySet()) {
                        ArrayList<ap> value2 = entry2.getValue();
                        if (value2 != null && value2.size() != 0) {
                            Iterator<ap> it = value2.iterator();
                            while (it.hasNext()) {
                                ap next = it.next();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, long j) {
        View view2;
        b(this.t, j);
        List<WeakReference<View>> list = this.e;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.e.size(); i++) {
                WeakReference<View> weakReference = null;
                try {
                    weakReference = this.e.get(i);
                } catch (Exception unused) {
                }
                if (weakReference != null && (view2 = weakReference.get()) != null && bi.d(view2) && !a(view2) && (view2 instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt != null && bi.d(childAt)) {
                            a(view2, childAt, activity, j);
                        }
                    }
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
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

    private boolean a(List<WeakReference<View>> list, View view2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WeakReference<View> weakReference = null;
            try {
                weakReference = list.get(i);
            } catch (Exception unused) {
            }
            if (weakReference != null && view2 == weakReference.get()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray != null && jSONArray2 != null) {
            return a(jSONArray.toString(), jSONArray2.toString());
        }
        return false;
    }

    public String a(Activity activity, View view2, View view3) {
        String str;
        Map<String, String> t = bi.t(view2);
        if (t != null && t.size() > 0 && !TextUtils.isEmpty(t.get("title"))) {
            str = t.get("title");
        } else {
            str = "";
        }
        String str2 = str;
        String u2 = bi.u(view2);
        String e = bi.e(activity);
        boolean s = bi.s(view3);
        return ap.a(u2, e, bi.a(activity, view2), str2, bi.a(view2, bi.b(view3)), bi.c(view3, bi.e(activity)), s);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Integer> a(Activity activity, View view2) {
        int computeHorizontalScrollRange;
        int computeVerticalScrollRange;
        int a2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        if (view2 != null && activity != null) {
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (view2 instanceof WebView) {
                synchronized (this.A) {
                    a(activity, (WebView) view2);
                    try {
                        this.A.wait(5000L);
                    } catch (Exception unused) {
                    }
                    a2 = (int) (this.y * this.z);
                }
            } else {
                if (view2 instanceof ScrollView) {
                    ScrollView scrollView = (ScrollView) view2;
                    if (scrollView.getChildCount() > 0) {
                        computeHorizontalScrollRange = scrollView.getChildAt(0).getWidth();
                        computeVerticalScrollRange = scrollView.getChildAt(0).getHeight();
                    }
                    computeHorizontalScrollRange = 0;
                    computeVerticalScrollRange = 0;
                } else if (view2 instanceof ListView) {
                    a2 = bi.a((ListView) view2);
                } else if (view2 instanceof GridView) {
                    a2 = bi.a((GridView) view2);
                } else {
                    if (bi.r(view2)) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) view2;
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
                if (height > 0) {
                    i = height;
                }
                arrayList.add(Integer.valueOf(width));
                arrayList.add(Integer.valueOf(i));
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
            arrayList.add(Integer.valueOf(i));
            return arrayList;
        }
        arrayList.add(0);
        arrayList.add(0);
        return arrayList;
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.1
            @Override // java.lang.Runnable
            public void run() {
                as.this.d = true;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null) {
                    return;
                }
                as.this.a(activity2, currentTimeMillis);
            }
        });
    }

    public void a(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.12
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                if (as.this.b == null || (activity = (Activity) as.this.b.get()) == null) {
                    return;
                }
                String e = bi.e(activity);
                if (TextUtils.isEmpty(as.this.k) || !as.this.k.equals(e)) {
                    return;
                }
                as.this.c();
            }
        });
    }

    public void a(final View view2, Activity activity) {
        if (view2 != null && activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final WeakReference weakReference2 = new WeakReference(view2);
            final long currentTimeMillis = System.currentTimeMillis();
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.11
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 == null || ((View) weakReference2.get()) == null) {
                        return;
                    }
                    as.this.a(view2, activity2, currentTimeMillis);
                }
            });
        }
    }

    public void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        this.f = feedTrackStrategy;
    }

    public void a(final String str) {
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.as.13
            @Override // java.lang.Runnable
            public void run() {
                ar.a().a(str);
            }
        });
    }

    public void a(final WeakReference<Activity> weakReference) {
        if (weakReference == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.as.15
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = (Activity) weakReference.get();
                if (activity == null) {
                    return;
                }
                as.this.d(activity, currentTimeMillis);
            }
        };
        Runnable runnable2 = this.x;
        if (runnable2 != null) {
            this.c.removeCallbacks(runnable2);
        }
        this.x = runnable;
        this.c.postDelayed(runnable, 350L);
    }
}
