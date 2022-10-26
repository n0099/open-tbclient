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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.MtjConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class as {
    public static /* synthetic */ Interceptable $ic;
    public static final as u;
    public transient /* synthetic */ FieldHolder $fh;
    public Object A;
    public Context a;
    public WeakReference b;
    public Handler c;
    public boolean d;
    public List e;
    public volatile MtjConfig.FeedTrackStrategy f;
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
    public List r;
    public HashMap s;
    public HashMap t;
    public a v;
    public ViewTreeObserver.OnScrollChangedListener w;
    public Runnable x;
    public float y;
    public float z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(an anVar);

        void a(ArrayList arrayList);

        void b(ArrayList arrayList);
    }

    private boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j2 - j;
            return j3 > 0 && j3 > 50;
        }
        return invokeCommon.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657408, "Lcom/baidu/mobstat/as;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657408, "Lcom/baidu/mobstat/as;");
                return;
            }
        }
        u = new as();
    }

    public static as a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return u;
        }
        return (as) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            this.i = 0L;
            this.k = "";
            this.l = "";
            this.m = "";
            this.n = false;
            this.o = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) {
            if (this.w == null) {
                this.w = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.baidu.mobstat.as.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ as a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public void onScrollChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            as asVar = this.a;
                            asVar.a(asVar.b);
                        }
                    }
                };
            }
            return this.w;
        }
        return (ViewTreeObserver.OnScrollChangedListener) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f == MtjConfig.FeedTrackStrategy.TRACK_NONE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public as() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = Collections.synchronizedList(new ArrayList());
        this.f = MtjConfig.FeedTrackStrategy.TRACK_ALL;
        this.r = new ArrayList();
        this.s = new HashMap();
        this.t = new HashMap();
        this.x = null;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = new Object();
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    private ap a(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, arrayList)) == null) {
            ap apVar = null;
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            Collections.sort(arrayList, new Comparator(this) { // from class: com.baidu.mobstat.as.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ as a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ap apVar2, ap apVar3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apVar2, apVar3)) == null) {
                        int i = ((apVar2.i() - apVar3.i()) > 0L ? 1 : ((apVar2.i() - apVar3.i()) == 0L ? 0 : -1));
                        if (i > 0) {
                            return 1;
                        }
                        if (i < 0) {
                            return -1;
                        }
                        return 0;
                    }
                    return invokeLL.intValue;
                }
            });
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            Iterator it = arrayList.iterator();
            long j = 0;
            while (it.hasNext()) {
                ap apVar2 = (ap) it.next();
                long i2 = apVar2.i();
                String l = apVar2.l();
                if (Long.valueOf(l).longValue() >= ar.a().d()) {
                    if (j == 0) {
                        apVar = apVar2;
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
                    i += apVar2.h();
                }
            }
            if (apVar != null) {
                apVar.a(sb2.toString());
                apVar.b(sb.toString());
                apVar.a(i);
            }
            return apVar;
        }
        return (ap) invokeL.objValue;
    }

    private String a(ap apVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, apVar)) == null) {
            return ap.a(apVar.a(), apVar.b(), apVar.c(), apVar.d(), apVar.e(), apVar.f(), apVar.g());
        }
        return (String) invokeL.objValue;
    }

    private void c(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, this, hashMap) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                ArrayList arrayList = (ArrayList) entry.getValue();
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            hashMap.clear();
        }
    }

    private ArrayList h(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, this, hashMap)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                ap a2 = a((ArrayList) entry.getValue());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private ArrayList a(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hashMap)) == null) {
            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator(this) { // from class: com.baidu.mobstat.as.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ as a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry entry, Map.Entry entry2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, entry, entry2)) == null) {
                        return ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue());
                    }
                    return invokeLL.intValue;
                }
            });
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (Map.Entry entry : arrayList) {
                arrayList2.add(new WeakReference(entry.getKey()));
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    private void d(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, this, hashMap) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.s.entrySet()) {
                ArrayList arrayList2 = (ArrayList) entry.getValue();
                if (arrayList2 != null && arrayList2.size() != 0) {
                    arrayList.addAll(arrayList2);
                }
            }
            Collections.sort(arrayList, new Comparator(this) { // from class: com.baidu.mobstat.as.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ as a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ao aoVar, ao aoVar2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, aoVar, aoVar2)) == null) {
                        int i = ((aoVar.b() - aoVar2.b()) > 0L ? 1 : ((aoVar.b() - aoVar2.b()) == 0L ? 0 : -1));
                        if (i > 0) {
                            return 1;
                        }
                        if (i < 0) {
                            return -1;
                        }
                        return 0;
                    }
                    return invokeLL.intValue;
                }
            });
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(arrayList);
            }
            av.a().a(this.a, arrayList);
        }
    }

    private void f(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, this, hashMap) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                HashMap hashMap2 = (HashMap) entry.getValue();
                if (hashMap2 != null) {
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        ((ArrayList) entry2.getValue()).clear();
                    }
                    hashMap2.clear();
                }
            }
            hashMap.clear();
        }
    }

    private void g(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65600, this, hashMap) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                arrayList.addAll(h((HashMap) entry.getValue()));
            }
            Collections.sort(arrayList, new Comparator(this) { // from class: com.baidu.mobstat.as.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ as a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ap apVar, ap apVar2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, apVar, apVar2)) == null) {
                        int i = ((apVar.i() - apVar2.i()) > 0L ? 1 : ((apVar.i() - apVar2.i()) == 0L ? 0 : -1));
                        if (i > 0) {
                            return 1;
                        }
                        if (i < 0) {
                            return -1;
                        }
                        return 0;
                    }
                    return invokeLL.intValue;
                }
            });
            a aVar = this.v;
            if (aVar != null) {
                aVar.b(arrayList);
            }
            av.a().b(this.a, arrayList);
        }
    }

    private LinkedHashMap a(HashMap hashMap, View view2) {
        InterceptResult invokeLL;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, hashMap, view2)) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                WeakReference weakReference = (WeakReference) entry.getKey();
                if (weakReference != null && (view3 = (View) weakReference.get()) != null && view3 == view2) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                    linkedHashMap.put(weakReference, (ArrayList) entry.getValue());
                    return linkedHashMap;
                }
            }
            return null;
        }
        return (LinkedHashMap) invokeLL.objValue;
    }

    private LinkedHashMap b(HashMap hashMap, View view2) {
        InterceptResult invokeLL;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, this, hashMap, view2)) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                WeakReference weakReference = (WeakReference) entry.getKey();
                if (weakReference != null && (view3 = (View) weakReference.get()) != null && view3 == view2) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(weakReference, (HashMap) entry.getValue());
                    return linkedHashMap;
                }
            }
            return null;
        }
        return (LinkedHashMap) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65587, this, activity, j) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            View a2 = bi.a(activity);
            a(activity, a2, hashMap, arrayList, arrayList2);
            if (this.p && !this.q && a(this.g, j)) {
                ArrayList a3 = a(hashMap);
                a3.add(new WeakReference(a2));
                this.r = a3;
                this.q = true;
            }
            if (activity != null) {
                activity.runOnUiThread(new Runnable(this, arrayList2, j, arrayList, activity) { // from class: com.baidu.mobstat.as.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ArrayList a;
                    public final /* synthetic */ long b;
                    public final /* synthetic */ ArrayList c;
                    public final /* synthetic */ Activity d;
                    public final /* synthetic */ as e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, arrayList2, Long.valueOf(j), arrayList, activity};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.e = this;
                        this.a = arrayList2;
                        this.b = j;
                        this.c = arrayList;
                        this.d = activity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Iterator it = this.a.iterator();
                            while (it.hasNext()) {
                                as asVar = this.e;
                                asVar.a((View) it.next(), asVar.d(), this.e.e);
                            }
                            this.e.c.post(new Runnable(this) { // from class: com.baidu.mobstat.as.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        as asVar2 = this.a.e;
                                        asVar2.a(asVar2.e);
                                        if (this.a.e.d) {
                                            as asVar3 = this.a.e;
                                            asVar3.a(asVar3.b, this.a.b);
                                            this.a.e.d = false;
                                        }
                                        as asVar4 = this.a.e;
                                        asVar4.a(asVar4.s, this.a.b);
                                        Iterator it2 = this.a.c.iterator();
                                        while (it2.hasNext()) {
                                            AnonymousClass2 anonymousClass2 = this.a;
                                            anonymousClass2.e.b((View) it2.next(), anonymousClass2.d, anonymousClass2.b);
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, this, activity, j) == null) {
            this.a = activity.getApplicationContext();
            this.b = new WeakReference(activity);
            this.g = j;
            String e = bi.e(activity);
            if (bi.a(e, this.j)) {
                this.p = false;
                if (a(e, this.k, this.j, this.i, this.g, activity)) {
                    this.p = true;
                }
            }
        }
    }

    private void a(Activity activity, long j, long j2, List list) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, this, new Object[]{activity, Long.valueOf(j), Long.valueOf(j2), list}) != null) || list == null) {
            return;
        }
        if (list.size() == 0) {
            list.add(new WeakReference(bi.a(activity)));
        }
        View view3 = null;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && (view2 = (View) weakReference.get()) != null) {
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
        ArrayList a2 = a(activity, view3);
        int a3 = ag.a(this.a, ((Integer) a2.get(0)).intValue());
        int a4 = ag.a(this.a, ((Integer) a2.get(1)).intValue());
        ArrayList b = bi.b(activity, view3);
        int a5 = ag.a(this.a, ((Integer) b.get(0)).intValue());
        int a6 = ag.a(this.a, ((Integer) b.get(1)).intValue());
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

    private void a(Activity activity, View view2, HashMap hashMap, ArrayList arrayList, ArrayList arrayList2) {
        int width;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65547, this, activity, view2, hashMap, arrayList, arrayList2) != null) || view2 == null || bi.c(activity, view2)) {
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

    private void a(Activity activity, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, activity, webView) == null) {
            activity.runOnUiThread(new Runnable(this, webView) { // from class: com.baidu.mobstat.as.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebView a;
                public final /* synthetic */ as b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, webView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = webView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    synchronized (this.b.A) {
                        this.b.y = this.a.getContentHeight();
                        this.b.z = this.a.getScale();
                        this.b.A.notifyAll();
                    }
                }
            });
        }
    }

    private void a(Context context, an anVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65549, this, context, anVar) != null) || anVar == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{view2, activity, Long.valueOf(j)}) == null) {
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
                Map t = bi.t(a2);
                if (t != null && t.size() > 0 && !TextUtils.isEmpty((CharSequence) t.get("title"))) {
                    this.l = (String) t.get("title");
                }
                this.m = bi.c(o, this.k);
                this.n = bi.s(o);
                this.o = a(activity, a2, o);
            }
        }
    }

    private void a(View view2, View view3, Activity activity, long j) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65551, this, new Object[]{view2, view3, activity, Long.valueOf(j)}) != null) || view2 == null || view3 == null || !bi.a(view3, ar.a().c())) {
            return;
        }
        Map t = bi.t(view3);
        String str3 = "";
        if (t == null || t.size() <= 0) {
            str = "";
        } else {
            if (TextUtils.isEmpty((CharSequence) t.get("title"))) {
                str2 = "";
            } else {
                str2 = (String) t.get("title");
            }
            if (!TextUtils.isEmpty((CharSequence) t.get("content"))) {
                str3 = (String) t.get("content");
            }
            str = str2;
        }
        String str4 = str3;
        ap apVar = new ap(bi.u(view3), bi.e(activity), bi.a(activity, view3), str, str4, bi.a(view3, bi.b(view2)), bi.c(view2, bi.e(activity)), bi.s(view2), 1, j, j, j, String.valueOf(j - j), "", new JSONArray());
        av.a().b(str3);
        a(this.t, view2, apVar);
    }

    private void a(View view2, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, this, view2, onScrollChangedListener) != null) || view2 == null || (viewTreeObserver = view2.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, List list) {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65553, this, view2, onScrollChangedListener, list) != null) || view2 == null || a(list, view2) || a(view2) || (viewTreeObserver = view2.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null || list == null) {
            return;
        }
        try {
            viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
            list.add(new WeakReference(view2));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeakReference weakReference, long j) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65561, this, weakReference, j) != null) || weakReference == null || (activity = (Activity) weakReference.get()) == null) {
            return;
        }
        d(activity, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap hashMap, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65562, this, hashMap, j) == null) && hashMap != null && hashMap.size() != 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                ArrayList arrayList = (ArrayList) entry.getValue();
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ao aoVar = (ao) it.next();
                        if (aoVar.e() == aoVar.c()) {
                            aoVar.a(j);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap hashMap, View view2, ao aoVar) {
        ArrayList arrayList;
        WeakReference weakReference;
        ao aoVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, this, hashMap, view2, aoVar) == null) {
            String a2 = aoVar.a();
            long c = aoVar.c();
            long e = aoVar.e();
            boolean d = aoVar.d();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            LinkedHashMap a3 = a(hashMap, view2);
            if (a3 != null && a3.size() > 0) {
                Iterator it = a3.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    weakReference = (WeakReference) entry.getKey();
                    arrayList = (ArrayList) entry.getValue();
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ao aoVar3 = (ao) it2.next();
                            String a4 = aoVar3.a();
                            long c2 = aoVar3.c();
                            long e2 = aoVar3.e();
                            boolean d2 = aoVar3.d();
                            if (a2.equals(a4) && d == d2 && (e2 >= c2 || c2 == c)) {
                                aoVar2 = aoVar3;
                                break;
                            }
                        }
                    }
                    aoVar2 = null;
                    if (aoVar2 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(aoVar);
                        if (weakReference == null) {
                            weakReference = new WeakReference(view2);
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
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap hashMap, View view2, ap apVar) {
        HashMap hashMap2;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65564, this, hashMap, view2, apVar) != null) || view2 == null) {
            return;
        }
        long k = apVar.k();
        long j = apVar.j();
        String d = apVar.d();
        String f = apVar.f();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(f)) {
            LinkedHashMap b = b(hashMap, view2);
            ap apVar2 = null;
            if (b != null && b.size() > 0) {
                Iterator it = b.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    weakReference = (WeakReference) entry.getKey();
                    hashMap2 = (HashMap) entry.getValue();
                    if (hashMap2 != null) {
                        for (Map.Entry entry2 : hashMap2.entrySet()) {
                            ArrayList arrayList = (ArrayList) entry2.getValue();
                            if (arrayList != null && arrayList.size() != 0) {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ap apVar3 = (ap) it2.next();
                                    long k2 = apVar3.k();
                                    long j2 = apVar3.j();
                                    if (a(apVar3, apVar) && (k2 >= j2 || j2 == apVar.j())) {
                                        apVar2 = apVar3;
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
                            HashMap hashMap3 = new HashMap();
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(apVar);
                            hashMap3.put(a2, arrayList2);
                            if (weakReference == null) {
                                weakReference = new WeakReference(view2);
                            }
                            hashMap.put(weakReference, hashMap3);
                            return;
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(a2);
                        if (arrayList3 == null) {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(apVar);
                            hashMap2.put(a2, arrayList4);
                            return;
                        }
                        arrayList3.add(apVar);
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

    private void a(HashMap hashMap, HashMap hashMap2, long j) {
        HashMap hashMap3;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{hashMap, hashMap2, Long.valueOf(j)}) == null) {
            try {
                for (Map.Entry entry : hashMap.entrySet()) {
                    try {
                        arrayList = (ArrayList) entry.getValue();
                    } catch (Exception unused) {
                        arrayList = null;
                    }
                    if (arrayList != null && arrayList.size() != 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ao aoVar = (ao) it.next();
                            if (aoVar.e() == aoVar.c()) {
                                aoVar.a(j);
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            try {
                for (Map.Entry entry2 : hashMap2.entrySet()) {
                    try {
                        hashMap3 = (HashMap) entry2.getValue();
                    } catch (Exception unused3) {
                        hashMap3 = null;
                    }
                    if (hashMap3 != null && hashMap3.size() != 0) {
                        for (Map.Entry entry3 : hashMap3.entrySet()) {
                            ArrayList arrayList2 = (ArrayList) entry3.getValue();
                            if (arrayList2 != null && arrayList2.size() != 0) {
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    ap apVar = (ap) it2.next();
                                    if (apVar.k() == apVar.j()) {
                                        apVar.a(j);
                                        apVar.a(String.valueOf(apVar.j() - apVar.i()));
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65566, this, list) == null) && list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                WeakReference weakReference = null;
                try {
                    weakReference = (WeakReference) list.get(i);
                } catch (Exception unused) {
                }
                if (weakReference == null) {
                    arrayList.add(weakReference);
                } else {
                    View view2 = (View) weakReference.get();
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
    public void a(List list, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65567, this, list, onScrollChangedListener) == null) && list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                WeakReference weakReference = null;
                try {
                    weakReference = (WeakReference) list.get(i);
                } catch (Exception unused) {
                }
                if (weakReference != null) {
                    a((View) weakReference.get(), onScrollChangedListener);
                }
            }
            list.clear();
        }
    }

    private boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, this, view2)) == null) {
            if (this.f == MtjConfig.FeedTrackStrategy.TRACK_ALL) {
                return false;
            }
            if (this.f == MtjConfig.FeedTrackStrategy.TRACK_SINGLE && bi.v(view2)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void b(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, this, hashMap) == null) {
            d(hashMap);
        }
    }

    private void e(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65596, this, hashMap) == null) {
            g(hashMap);
        }
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, activity) != null) || activity == null) {
            return;
        }
        this.c.post(new Runnable(this, new WeakReference(activity), System.currentTimeMillis()) { // from class: com.baidu.mobstat.as.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;
            public final /* synthetic */ long b;
            public final /* synthetic */ as c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = r7;
                this.b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || (activity2 = (Activity) this.a.get()) == null) {
                    return;
                }
                this.c.c(activity2, this.b);
            }
        });
    }

    private boolean a(ap apVar, ap apVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, this, apVar, apVar2)) == null) {
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
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65579, this, activity, j) == null) {
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
                activity.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobstat.as.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ as a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            as asVar = this.a;
                            asVar.a(asVar.e, this.a.d());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, long j) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65592, this, activity, j) == null) {
            b(this.t, j);
            List list = this.e;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.e.size(); i++) {
                    WeakReference weakReference = null;
                    try {
                        weakReference = (WeakReference) this.e.get(i);
                    } catch (Exception unused) {
                    }
                    if (weakReference != null && (view2 = (View) weakReference.get()) != null && bi.d(view2) && !a(view2) && (view2 instanceof ViewGroup)) {
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
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, this, str, str2)) == null) {
            if (str == str2) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(String str, String str2, String str3, long j, long j2, Activity activity) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), activity})) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str.equals(str2) || !str2.equals(str3) || (activity instanceof IIgnoreAutoTrace)) {
                return false;
            }
            long j3 = j2 - j;
            if (j3 <= 0 || j3 >= 5000) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(List list, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, this, list, view2)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                WeakReference weakReference = null;
                try {
                    weakReference = (WeakReference) list.get(i);
                } catch (Exception unused) {
                }
                if (weakReference != null && view2 == weakReference.get()) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, this, jSONArray, jSONArray2)) == null) {
            if (jSONArray == null && jSONArray2 == null) {
                return true;
            }
            if (jSONArray != null && jSONArray2 != null) {
                return a(jSONArray.toString(), jSONArray2.toString());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, Activity activity, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65580, this, new Object[]{view2, activity, Long.valueOf(j)}) != null) || view2 == null || !bi.d(view2)) {
            return;
        }
        a(this.s, view2, new ao(bi.c(view2, bi.e(activity)), j, j, j, bi.s(view2)));
    }

    public String a(Activity activity, View view2, View view3) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, view2, view3)) == null) {
            Map t = bi.t(view2);
            if (t != null && t.size() > 0 && !TextUtils.isEmpty((CharSequence) t.get("title"))) {
                str = (String) t.get("title");
            } else {
                str = "";
            }
            String str2 = str;
            return ap.a(bi.u(view2), bi.e(activity), bi.a(activity, view2), str2, bi.a(view2, bi.b(view3)), bi.c(view3, bi.e(activity)), bi.s(view3));
        }
        return (String) invokeLLL.objValue;
    }

    private void b(HashMap hashMap, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65584, this, hashMap, j) == null) && hashMap != null && hashMap.size() != 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                HashMap hashMap2 = (HashMap) entry.getValue();
                if (hashMap2 != null) {
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        ArrayList arrayList = (ArrayList) entry2.getValue();
                        if (arrayList != null && arrayList.size() != 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ap apVar = (ap) it.next();
                                if (apVar.k() == apVar.j()) {
                                    apVar.a(j);
                                    apVar.a(String.valueOf(apVar.j() - apVar.i()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList a(Activity activity, View view2) {
        InterceptResult invokeLL;
        int computeHorizontalScrollRange;
        int computeVerticalScrollRange;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, view2)) == null) {
            ArrayList arrayList = new ArrayList();
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
        return (ArrayList) invokeLL.objValue;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || activity == null) {
            return;
        }
        this.c.post(new Runnable(this, new WeakReference(activity), System.currentTimeMillis()) { // from class: com.baidu.mobstat.as.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;
            public final /* synthetic */ long b;
            public final /* synthetic */ as c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = r7;
                this.b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.d = true;
                Activity activity2 = (Activity) this.a.get();
                if (activity2 == null) {
                    return;
                }
                this.c.a(activity2, this.b);
            }
        });
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) != null) || activity == null) {
            return;
        }
        this.c.post(new Runnable(this, new WeakReference(activity), System.currentTimeMillis()) { // from class: com.baidu.mobstat.as.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;
            public final /* synthetic */ long b;
            public final /* synthetic */ as c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = r7;
                this.b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.d = false;
                Activity activity2 = (Activity) this.a.get();
                if (activity2 == null) {
                    return;
                }
                this.c.b(activity2, this.b);
            }
        });
    }

    public void a(KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, keyEvent) != null) || keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return;
        }
        this.c.post(new Runnable(this) { // from class: com.baidu.mobstat.as.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ as a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.a.b == null || (activity = (Activity) this.a.b.get()) == null) {
                    return;
                }
                String e = bi.e(activity);
                if (TextUtils.isEmpty(this.a.k) || !this.a.k.equals(e)) {
                    return;
                }
                this.a.c();
            }
        });
    }

    public void a(View view2, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, activity) == null) && view2 != null && activity != null) {
            this.c.post(new Runnable(this, new WeakReference(activity), new WeakReference(view2), view2, System.currentTimeMillis()) { // from class: com.baidu.mobstat.as.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeakReference a;
                public final /* synthetic */ WeakReference b;
                public final /* synthetic */ View c;
                public final /* synthetic */ long d;
                public final /* synthetic */ as e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, r8, view2, Long.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = r7;
                    this.b = r8;
                    this.c = view2;
                    this.d = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || (activity2 = (Activity) this.a.get()) == null || ((View) this.b.get()) == null) {
                        return;
                    }
                    this.e.a(this.c, activity2, this.d);
                }
            });
        }
    }

    public void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, feedTrackStrategy) == null) {
            this.f = feedTrackStrategy;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.c.post(new Runnable(this, str) { // from class: com.baidu.mobstat.as.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ as b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ar.a().a(this.a);
                    }
                }
            });
        }
    }

    public void a(WeakReference weakReference) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, weakReference) != null) || weakReference == null) {
            return;
        }
        Runnable runnable = new Runnable(this, weakReference, System.currentTimeMillis()) { // from class: com.baidu.mobstat.as.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;
            public final /* synthetic */ long b;
            public final /* synthetic */ as c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, weakReference, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = weakReference;
                this.b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || (activity = (Activity) this.a.get()) == null) {
                    return;
                }
                this.c.d(activity, this.b);
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
