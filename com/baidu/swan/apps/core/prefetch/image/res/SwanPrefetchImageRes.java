package com.baidu.swan.apps.core.prefetch.image.res;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.cr2;
import com.baidu.tieba.pk3;
import com.baidu.tieba.v73;
import com.baidu.tieba.w13;
import com.baidu.tieba.zs2;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanPrefetchImageRes implements zs2 {
    public static final HashMap<String, List<String>> c = new HashMap<>(10);
    public static final List<String> d = new ArrayList();

    /* loaded from: classes3.dex */
    public static class b {
        public static final SwanPrefetchImageRes a = new SwanPrefetchImageRes();
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public a(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.a) {
                SwanPrefetchImageRes.this.f(str);
            }
            if (zs2.a) {
                Log.d("SwanPerformance", "start prefetch image appKey = " + this.b + " ; cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    public SwanPrefetchImageRes() {
    }

    public static SwanPrefetchImageRes b() {
        return b.a;
    }

    public void e() {
        d.clear();
    }

    public final void f(@NonNull String str) {
        BdNet bdNet = new BdNet(cr2.c());
        bdNet.setEventListener(new INetListener() { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.12
            @Override // com.baidu.webkit.net.INetListener
            public void onNetDownloadComplete(BdNet bdNet2) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetDownloadError(BdNet bdNet2, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetReceiveData(BdNet bdNet2, BdNetTask bdNetTask, byte[] bArr, int i) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetReceiveHeaders(BdNet bdNet2, BdNetTask bdNetTask) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public boolean onNetRedirect(BdNet bdNet2, BdNetTask bdNetTask, int i) {
                return false;
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetStateChanged(BdNet bdNet2, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetTaskComplete(BdNet bdNet2, BdNetTask bdNetTask) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetUploadComplete(BdNet bdNet2, BdNetTask bdNetTask) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetUploadData(BdNet bdNet2, BdNetTask bdNetTask, int i, int i2) {
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetResponseCode(BdNet bdNet2, BdNetTask bdNetTask, int i) {
                if (zs2.a) {
                    Log.d("SwanPerformance", "response code = " + i);
                }
            }

            @Override // com.baidu.webkit.net.INetListener
            public void onNetTaskStart(BdNet bdNet2, BdNetTask bdNetTask) {
                if (zs2.a) {
                    Log.d("SwanPerformance", "start prefetch image = " + bdNetTask.getUrl());
                }
            }
        });
        BdNetTask obtainTask = bdNet.obtainTask(str);
        obtainTask.setMethod(BdNet.HttpMethod.METHOD_HEAD);
        bdNet.start(obtainTask);
    }

    @SuppressLint({"BDOfflineUrl"})
    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        c.put("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m", new ArrayList<String>(5) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.1
            {
                add("https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/yt/bdsp/home-white.png");
                add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
                add("https://iknow-base.cdn.bcebos.com/iknow/new-question/action/share-fade.png");
                add("https://ggkkmuup9wuugp6ep8d.exp.bcevod.com/mda-kmnq7gvfeygk02md/mda-kmnq7gvfeygk02md00000000.jpg");
            }
        });
        c.put("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD", new ArrayList<String>(4) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.2
            {
                add("https://baikebcs.bdimg.com/front-end/swanapp-baike/secondKnow/miaodong.png");
                add("https://bkimg.cdn.bcebos.com/pic/960a304e251f95cad1c89509a45c683e6709c93df473?x-bce-process=image/format,f_auto");
                add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
            }
        });
        c.put("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.3
            {
                add("https://edu-wenku.bdimg.com/v1/wkSmallApp/reader/vip-log-1608713911973.png");
                add("https://himg.bdimg.com/sys/portraitn/item/wenku.1.8852809f.wUdxH_g8daTrRTb7rjrZyQ.jpg");
                add("https://edu-tob.bdimg.com/v1/wap/1242-546-1612841825060.jpg");
            }
        });
        c.put("flFqXclepWs7RdugAszy9eERL7G5dS0I", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.4
            {
                add("https://tieba-fe.cdn.bcebos.com/xcx/icon_like_grey26.png");
                add("https://tb1.bdstatic.com/tb/cms/smartapp/img/logo.png");
                add("https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/yt/bdsp/home-white.png");
            }
        });
        c.put("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.5
            {
                add("https://pic2.zhimg.com/80/v2-c6ceb5628d1a6eef60b2ac060082d173_hd.png");
                add("https://pic1.zhimg.com/v2-1728e56c612f23e9b03d8de3f5b5bdac_l.jpg?source=1940ef5c");
                add("https://pic3.zhimg.com/v2-3c4942f4bf79f8e5e09c9acb7e714b3f.jpg");
            }
        });
        c.put("x0s1yYl7sOlmmtKUhZmZbEvaYTeUMbXk", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.6
            {
                add("http://statics.itc.cn/mobile/smartprogram/ic_comment_66.png");
                add("http://sucimg.itc.cn/avatarimg/5f90c8ac6b0840e2b782674ffb5eec11_1505445351147");
                add("http://hiphotos.baidu.com/baidu/pic/item/eac4b74543a982263381ea0d8582b9014a90eb5d.png");
            }
        });
        c.put("GeVyFwtN81ARbPF3GIbuaPlRPT3SfzYB", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.7
            {
                add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
                add("https://exp-picture.cdn.bcebos.com/46a92de039723d03f8184235bb486143d6d45745.jpg?x-bce-process=image%2Fquality%2Cq_80");
                add("http://hiphotos.baidu.com/baidu/pic/item/eac4b74543a982263381ea0d8582b9014a90eb5d.png");
            }
        });
        c.put("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", new ArrayList<String>(3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.8
            {
                add("http://www.iqiyipic.com/common/fix/wx-iqiyi/player-tip-bg.jpg");
                add("http://statics-web.iqiyi.com/common/mp/bd/c-video-hot-gray.png?caplist=png,jpg,webp");
                add("https://static-d.iqiyi.com/mp/wx/icon-video-guide.png");
            }
        });
        c.put("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", new ArrayList<String>(2) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.9
            {
                add("https://med-fe.cdn.bcebos.com/brand/search-bg.png");
                add("https://zhuanjia.cdn.bcebos.com/zhuanjia/b1563546428451876634.png");
                add("https://himg.baidu.com/sys/portrait/item/0e506357");
            }
        });
        c.put("lUSdNPhcMS0ilYhpv0cKCksPgBcw6C3n", new ArrayList<String>(1) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.10
            {
                add("http://b.hiphotos.baidu.com/baike/whfpf%3D640%2C360%2C0/sign=f5fefd63a8cc7cd9fa7867995f3c170b/3c6d55fbb2fb431634739cf42ba4462308f7d3d4.jpg");
            }
        });
        if (zs2.a) {
            Log.d("SwanPerformance", "prefetch image init cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str) || !w13.m()) {
            return;
        }
        if (d.contains(str)) {
            if (zs2.a) {
                Log.d("SwanPerformance", "has prefetch this appKey = " + str);
                return;
            }
            return;
        }
        List<String> list = c.get(str);
        if (list != null && !list.isEmpty()) {
            v73 b0 = v73.b0();
            if (b0 != null && !b0.I()) {
                d.add(str);
                pk3.k(new a(list, str), "PrefetchImageRes");
            } else if (zs2.a) {
                Log.d("SwanPerformance", "app is occupied");
            }
        } else if (zs2.a) {
            Log.d("SwanPerformance", "can't find res, appKey = " + str);
        }
    }
}
