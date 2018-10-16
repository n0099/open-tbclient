package com.baidu.ar.recommend;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SlidingDrawer;
import com.baidu.ar.ARController;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.recommend.a;
import com.baidu.ar.recommend.g;
import com.baidu.ar.recommend.h;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.task.HttpTaskUtility;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UrlUtils;
import com.baidu.ar.util.sputil.SPUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements g.b {
    private com.baidu.ar.b a;
    private Context b;
    private ARController c;
    private ARResource d;
    private ViewGroup e;
    private g f;
    private a g;
    private h j;
    private SlidingDrawer.OnDrawerOpenListener k;
    private boolean h = false;
    private a.InterfaceC0041a i = new a.InterfaceC0041a() { // from class: com.baidu.ar.recommend.f.1
        @Override // com.baidu.ar.recommend.a.InterfaceC0041a
        public void a(String str, int i) {
            Log.d("Download", "progress:" + i + ",arKey:" + str);
            f.this.a(str, i);
        }

        @Override // com.baidu.ar.recommend.a.InterfaceC0041a
        public void a(String str, boolean z, String str2) {
            Log.d("Download", "onFinish: success:" + z + ",arKey:" + str);
            f.this.a(str, z, str2);
        }
    };
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;

    public f(com.baidu.ar.b bVar) {
        this.a = bVar;
        this.b = bVar.h().getActivity().getApplicationContext();
        this.c = bVar.i();
        d.a(String.valueOf(hashCode()));
        d.a().a(ARFileUtils.getImageCacheDir());
        d.a().a(Res.decodeBitmap("bdar_recommend_default_case"));
        this.g = new a();
        this.g.a(this.i);
        this.j = new h(this.b);
    }

    private static ARResource a(List<ARResource> list, String str) {
        for (ARResource aRResource : list) {
            if (TextUtils.equals(aRResource.getKey(), str)) {
                return aRResource;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ARResource> a(List<ARResource> list) {
        ARResource a = a(list, this.d.getKey());
        if (a != null) {
            list.remove(a);
            this.d.setThumbnailUrl(a.getThumbnailUrl());
        }
        this.d.setDownloadStatus(-2);
        list.add(0, this.d);
        return list;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.ar.recommend.f$4] */
    private static void a(final Context context, final String str) {
        new AsyncTask<Void, Void, Void>() { // from class: com.baidu.ar.recommend.f.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                String queryResourceUrl = UrlUtils.getQueryResourceUrl();
                ARLog.d("Statistic doQuery: " + queryResourceUrl);
                HttpUtils.postRequest(queryResourceUrl, HttpTaskUtility.getHttpParamsWithKey(context, str));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (this.f != null) {
            this.f.a(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        if (this.f != null) {
            this.f.a(str, z, str2);
        }
    }

    private void b() {
        if (this.l) {
            this.f.b();
            this.f.c();
            SPUtils.saveShowRecommendAnim(this.b);
            this.l = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f == null) {
            return;
        }
        if (!this.m || !this.n || this.h) {
            this.f.setVisibility(4);
            return;
        }
        this.f.setVisibility(0);
        b();
    }

    private void c(ARResource aRResource) {
        String key = aRResource.getKey();
        switch (aRResource.getDownloadStatus()) {
            case -3:
            case -1:
                a(key);
                this.g.a(this.b, aRResource);
                return;
            case -2:
                if (this.c.switchCaseForRecommend(aRResource)) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_AR);
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.RECOMMEND_CASE_CLICK, key);
                    a(this.b, key);
                    this.f.setSelectedCase(aRResource);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        if (this.j != null) {
            this.j.a((h.a) null);
            this.j.b();
            this.j = null;
        }
        d.b(String.valueOf(hashCode()));
    }

    public void a(SlidingDrawer.OnDrawerCloseListener onDrawerCloseListener) {
        if (this.f != null) {
            this.f.setOnDrawerCloseListener(onDrawerCloseListener);
        }
    }

    public void a(SlidingDrawer.OnDrawerOpenListener onDrawerOpenListener) {
        this.k = onDrawerOpenListener;
    }

    public void a(ARResource aRResource) {
        if (this.f != null) {
            this.f.setLoadingCase(aRResource);
        }
    }

    public void a(ARResource aRResource, ViewGroup viewGroup) {
        if (this.d != null) {
            return;
        }
        this.d = aRResource;
        this.e = viewGroup;
        this.a.h().getHostUI().getTransparentView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.recommend.f.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.f != null) {
                    f.this.f.a();
                    return false;
                }
                return false;
            }
        });
        this.j.a(aRResource);
        this.j.a(new h.a() { // from class: com.baidu.ar.recommend.f.3
            @Override // com.baidu.ar.recommend.h.a
            public void a(List<ARResource> list) {
                if (list == null || list.size() == 0) {
                    return;
                }
                f.this.d.setRelativeList(f.this.a(list));
                f.this.f = new g(f.this.e.getContext());
                f.this.f.setApplicationContext(f.this.b);
                f.this.e.addView(f.this.f);
                f.this.f.setOnItemClickListener(f.this);
                f.this.l = SPUtils.isShowRecommendAnim(f.this.b);
                f.this.f.setRelativeList(list);
                f.this.f.setSelectedCase(f.this.d.getRelativeList().get(0));
                f.this.f.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() { // from class: com.baidu.ar.recommend.f.3.1
                    @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
                    public void onDrawerOpened() {
                        if (f.this.k != null) {
                            f.this.k.onDrawerOpened();
                        }
                    }
                });
                f.this.c();
            }
        });
        this.j.a();
    }

    @Override // com.baidu.ar.recommend.g.b
    public void a(g gVar, View view, int i) {
        c(this.f.a(i));
    }

    public void a(Orientation orientation) {
        if (this.f != null) {
            this.f.a(orientation, true);
        }
    }

    public void a(boolean z) {
        this.h = z;
        c();
    }

    public void b(ARResource aRResource) {
        if (this.f != null) {
            this.f.setLoadingCase(null);
        }
    }

    public void b(boolean z) {
        this.n = z;
        if (this.n) {
            this.m = true;
        }
        c();
    }

    public void c(boolean z) {
        this.m = z;
        if (this.m) {
            c();
        }
    }
}
