package c.a.p0.p4.h;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l3.e0.b;
import c.a.p0.l3.e0.d;
import c.a.p0.l3.f0.c;
import c.a.p0.l3.m;
import c.a.p0.l3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.nad.AdVideoFlowFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a implements IAdBaseAsyncController.a, d<VideoItemModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f17063b;

    /* renamed from: c  reason: collision with root package name */
    public final c f17064c;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<AdvertAppInfo> f17065d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<VideoItemModel, AdvertAppInfo> f17066e;

    /* renamed from: f  reason: collision with root package name */
    public int f17067f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17068g;

    /* renamed from: h  reason: collision with root package name */
    public int f17069h;
    public VideoPlayView i;
    public c.a.p0.l3.e0.a j;
    public final boolean k;
    public c.a l;
    public int m;
    public VideoItemModel n;

    public a(@NonNull List list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.f17067f = 0;
        this.f17068g = true;
        this.f17063b = list;
        this.a = tbPageContext;
        c cVar = (c) z.q().k(IAdBaseAsyncController.Type.VIDEO_FLOW, this);
        this.f17064c = cVar;
        cVar.a(this.a);
        this.f17065d = new LinkedList();
        this.f17066e = new HashMap();
        int s = c.a.p0.a.h().s();
        int t = c.a.p0.a.h().t();
        if (s > 0 && t > 0) {
            z = true;
        }
        this.k = z;
        if (z) {
            c.a.p0.l3.e0.a aVar = new c.a.p0.l3.e0.a();
            this.j = aVar;
            aVar.d(s - 1);
            this.j.e(t);
        }
    }

    @Override // c.a.p0.l3.e0.d
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (i2 != 0) {
                this.f17069h = i2;
            }
            if (this.f17069h - 2 <= i && this.f17065d.isEmpty() && this.f17068g) {
                this.f17064c.loadAd();
                this.f17068g = false;
            }
        }
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f17068g = true;
            this.f17065d.addAll(list);
            VideoItemModel videoItemModel = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel;
            b.b(this.f17063b, this.m, this.j, this.f17067f, videoItemModel, this.f17065d.peek(), this);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            VideoItemModel videoItemModel = this.f17063b.get(i);
            if (this.f17066e.containsKey(videoItemModel)) {
                this.f17064c.o(this.f17066e.get(videoItemModel));
            }
        }
    }

    public AdVideoFlowFragment g(int i) {
        InterceptResult invokeI;
        m k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            AdvertAppInfo advertAppInfo = this.f17066e.get(this.f17063b.get(i));
            if (advertAppInfo == null || (k = this.f17064c.k(advertAppInfo)) == null) {
                return null;
            }
            if ((k instanceof View) && (this.a.getPageActivity() instanceof c.a.a0.f.b)) {
                advertAppInfo.u = c.a.a0.f.d.b(advertAppInfo.u, (c.a.a0.f.b) this.a.getPageActivity(), (View) k);
            }
            k.setPageChangeHandler(this.l, i);
            AdVideoFlowFragment adVideoFlowFragment = new AdVideoFlowFragment();
            adVideoFlowFragment.E0(k);
            return adVideoFlowFragment;
        }
        return (AdVideoFlowFragment) invokeI.objValue;
    }

    public List<VideoItemModel> h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<VideoItemModel, AdvertAppInfo> entry : this.f17066e.entrySet()) {
                if (TextUtils.equals(entry.getValue().a, str)) {
                    arrayList.add(entry.getKey());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.k) {
            this.f17067f = 0;
            this.f17069h = c.a.p0.a.h().s() - 1;
            if (this.f17065d.size() >= 1 || !this.f17068g) {
                return;
            }
            this.f17064c.loadAd();
            this.f17068g = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.l3.e0.d
    /* renamed from: j */
    public void c(int i, int i2, c.a.p0.l3.e0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), cVar, videoItemModel}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f17065d.remove(advertAppInfo);
            this.f17067f = i2;
            this.f17066e.put(videoItemModel, advertAppInfo);
            VideoPlayView videoPlayView = this.i;
            if (videoPlayView != null) {
                videoPlayView.A();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.l3.e0.d
    /* renamed from: k */
    public void e(int i, int i2, VideoItemModel videoItemModel, c.a.p0.l3.e0.c cVar, VideoItemModel videoItemModel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), videoItemModel, cVar, videoItemModel2}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f17065d.remove(advertAppInfo);
            this.f17067f = i2;
            this.f17066e.put(videoItemModel, advertAppInfo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.l3.e0.d
    /* renamed from: l */
    public void d(int i, int i2, int i3, c.a.p0.l3.e0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), cVar, videoItemModel}) == null) {
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && this.k) {
            this.m = i;
            VideoItemModel videoItemModel = (VideoItemModel) c.a.p0.b2.o.k.a.d(this.f17063b, i);
            if (this.f17066e.containsKey(videoItemModel)) {
                AdvertAppInfo advertAppInfo = this.f17066e.get(videoItemModel);
                c.a.p0.l3.m0.d.q(advertAppInfo);
                c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(advertAppInfo));
                this.f17064c.c(advertAppInfo, true);
                return;
            }
            this.f17064c.c(null, false);
            if (i <= this.f17067f) {
                return;
            }
            VideoItemModel videoItemModel2 = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel2;
            b.b(this.f17063b, i, this.j, this.f17067f, videoItemModel2, this.f17065d.peek(), this);
        }
    }

    public void n(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void o(VideoPlayView videoPlayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoPlayView) == null) {
            this.i = videoPlayView;
        }
    }
}
