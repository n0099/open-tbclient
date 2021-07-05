package com.baidu.swan.apps.core.prefetch.image.res;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import d.a.q0.a.r1.l.e;
import d.a.q0.a.v2.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanPrefetchImageRes implements d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, List<String>> f10956b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f10957c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f10958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanPrefetchImageRes f10960g;

        public a(SwanPrefetchImageRes swanPrefetchImageRes, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanPrefetchImageRes, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10960g = swanPrefetchImageRes;
            this.f10958e = list;
            this.f10959f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                for (String str : this.f10958e) {
                    this.f10960g.f(str);
                }
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "start prefetch image appKey = " + this.f10959f + " ; cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanPrefetchImageRes f10961a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1098821640, "Lcom/baidu/swan/apps/core/prefetch/image/res/SwanPrefetchImageRes$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1098821640, "Lcom/baidu/swan/apps/core/prefetch/image/res/SwanPrefetchImageRes$b;");
                    return;
                }
            }
            f10961a = new SwanPrefetchImageRes();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-546394186, "Lcom/baidu/swan/apps/core/prefetch/image/res/SwanPrefetchImageRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-546394186, "Lcom/baidu/swan/apps/core/prefetch/image/res/SwanPrefetchImageRes;");
                return;
            }
        }
        f10956b = new HashMap<>(10);
        f10957c = new ArrayList();
    }

    public static SwanPrefetchImageRes b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? b.f10961a : (SwanPrefetchImageRes) invokeV.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            f10956b.put("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m", new ArrayList<String>(this, 5) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/yt/bdsp/home-white.png");
                    add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
                    add("https://iknow-base.cdn.bcebos.com/iknow/new-question/action/share-fade.png");
                    add("https://ggkkmuup9wuugp6ep8d.exp.bcevod.com/mda-kmnq7gvfeygk02md/mda-kmnq7gvfeygk02md00000000.jpg");
                }
            });
            f10956b.put("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD", new ArrayList<String>(this, 4) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://baikebcs.bdimg.com/front-end/swanapp-baike/secondKnow/miaodong.png");
                    add("https://bkimg.cdn.bcebos.com/pic/960a304e251f95cad1c89509a45c683e6709c93df473?x-bce-process=image/format,f_auto");
                    add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
                }
            });
            f10956b.put("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://edu-wenku.bdimg.com/v1/wkSmallApp/reader/vip-log-1608713911973.png");
                    add("https://himg.bdimg.com/sys/portraitn/item/wenku.1.8852809f.wUdxH_g8daTrRTb7rjrZyQ.jpg");
                    add("https://edu-tob.bdimg.com/v1/wap/1242-546-1612841825060.jpg");
                }
            });
            f10956b.put("flFqXclepWs7RdugAszy9eERL7G5dS0I", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://tieba-fe.cdn.bcebos.com/xcx/icon_like_grey26.png");
                    add("https://tb1.bdstatic.com/tb/cms/smartapp/img/logo.png");
                    add("https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/yt/bdsp/home-white.png");
                }
            });
            f10956b.put("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://pic2.zhimg.com/80/v2-c6ceb5628d1a6eef60b2ac060082d173_hd.png");
                    add("https://pic1.zhimg.com/v2-1728e56c612f23e9b03d8de3f5b5bdac_l.jpg?source=1940ef5c");
                    add("https://pic3.zhimg.com/v2-3c4942f4bf79f8e5e09c9acb7e714b3f.jpg");
                }
            });
            f10956b.put("x0s1yYl7sOlmmtKUhZmZbEvaYTeUMbXk", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("http://statics.itc.cn/mobile/smartprogram/ic_comment_66.png");
                    add("http://sucimg.itc.cn/avatarimg/5f90c8ac6b0840e2b782674ffb5eec11_1505445351147");
                    add("http://hiphotos.baidu.com/baidu/pic/item/eac4b74543a982263381ea0d8582b9014a90eb5d.png");
                }
            });
            f10956b.put("GeVyFwtN81ARbPF3GIbuaPlRPT3SfzYB", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://himg.bdimg.com/sys/portrait/item/507979756461766535303035a53e.jpg");
                    add("https://exp-picture.cdn.bcebos.com/46a92de039723d03f8184235bb486143d6d45745.jpg?x-bce-process=image%2Fquality%2Cq_80");
                    add("http://hiphotos.baidu.com/baidu/pic/item/eac4b74543a982263381ea0d8582b9014a90eb5d.png");
                }
            });
            f10956b.put("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", new ArrayList<String>(this, 3) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("http://www.iqiyipic.com/common/fix/wx-iqiyi/player-tip-bg.jpg");
                    add("http://statics-web.iqiyi.com/common/mp/bd/c-video-hot-gray.png?caplist=png,jpg,webp");
                    add("https://static-d.iqiyi.com/mp/wx/icon-video-guide.png");
                }
            });
            f10956b.put("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", new ArrayList<String>(this, 2) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("https://med-fe.cdn.bcebos.com/brand/search-bg.png");
                    add("https://zhuanjia.cdn.bcebos.com/zhuanjia/b1563546428451876634.png");
                    add("https://himg.baidu.com/sys/portrait/item/0e506357");
                }
            });
            f10956b.put("lUSdNPhcMS0ilYhpv0cKCksPgBcw6C3n", new ArrayList<String>(this, 1) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    add("http://b.hiphotos.baidu.com/baike/whfpf%3D640%2C360%2C0/sign=f5fefd63a8cc7cd9fa7867995f3c170b/3c6d55fbb2fb431634739cf42ba4462308f7d3d4.jpg");
                }
            });
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.d("SwanPerformance", "prefetch image init cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str) && e.n()) {
            if (f10957c.contains(str)) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "has prefetch this appKey = " + str);
                    return;
                }
                return;
            }
            List<String> list = f10956b.get(str);
            if (list != null && !list.isEmpty()) {
                f10957c.add(str);
                q.j(new a(this, list, str), "PrefetchImageRes");
            } else if (d.a.q0.a.f1.f.a.f47786a) {
                Log.d("SwanPerformance", "can't find res, appKey = " + str);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f10957c.clear();
        }
    }

    public final void f(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            BdNet bdNet = new BdNet(d.a.q0.a.c1.a.b());
            bdNet.setEventListener(new INetListener(this) { // from class: com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SwanPrefetchImageRes this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetDownloadComplete(BdNet bdNet2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdNet2) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetDownloadError(BdNet bdNet2, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet2, bdNetTask, netError, i2) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetReceiveData(BdNet bdNet2, BdNetTask bdNetTask, byte[] bArr, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet2, bdNetTask, bArr, i2) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetReceiveHeaders(BdNet bdNet2, BdNetTask bdNetTask) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, bdNet2, bdNetTask) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public boolean onNetRedirect(BdNet bdNet2, BdNetTask bdNetTask, int i2) {
                    InterceptResult invokeLLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(1048580, this, bdNet2, bdNetTask, i2)) == null) {
                        return false;
                    }
                    return invokeLLI.booleanValue;
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetResponseCode(BdNet bdNet2, BdNetTask bdNetTask, int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLLI(1048581, this, bdNet2, bdNetTask, i2) == null) && d.a.q0.a.f1.f.a.f47786a) {
                        Log.d("SwanPerformance", "response code = " + i2);
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetStateChanged(BdNet bdNet2, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLI(1048582, this, bdNet2, bdNetTask, netState, i2) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetTaskComplete(BdNet bdNet2, BdNetTask bdNetTask) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048583, this, bdNet2, bdNetTask) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetTaskStart(BdNet bdNet2, BdNetTask bdNetTask) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet2, bdNetTask) == null) && d.a.q0.a.f1.f.a.f47786a) {
                        Log.d("SwanPerformance", "start prefetch image = " + bdNetTask.getUrl());
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetUploadComplete(BdNet bdNet2, BdNetTask bdNetTask) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048585, this, bdNet2, bdNetTask) == null) {
                    }
                }

                @Override // com.baidu.webkit.net.INetListener
                public void onNetUploadData(BdNet bdNet2, BdNetTask bdNetTask, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLII(1048586, this, bdNet2, bdNetTask, i2, i3) == null) {
                    }
                }
            });
            BdNetTask obtainTask = bdNet.obtainTask(str);
            obtainTask.setMethod(BdNet.HttpMethod.METHOD_HEAD);
            bdNet.start(obtainTask);
        }
    }

    public SwanPrefetchImageRes() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
