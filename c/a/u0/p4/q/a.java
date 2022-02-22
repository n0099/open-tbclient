package c.a.u0.p4.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.l3.d0.b;
import c.a.u0.l3.d0.d;
import c.a.u0.l3.e0.c;
import c.a.u0.l3.m;
import c.a.u0.l3.y;
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
/* loaded from: classes8.dex */
public class a implements IAdBaseAsyncController.a, d<VideoItemModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f21253b;

    /* renamed from: c  reason: collision with root package name */
    public final c f21254c;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<AdvertAppInfo> f21255d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<VideoItemModel, AdvertAppInfo> f21256e;

    /* renamed from: f  reason: collision with root package name */
    public int f21257f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21258g;

    /* renamed from: h  reason: collision with root package name */
    public int f21259h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPlayView f21260i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.u0.l3.d0.a f21261j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.f21257f = 0;
        this.f21258g = true;
        this.f21253b = list;
        this.a = tbPageContext;
        c cVar = (c) y.q().k(IAdBaseAsyncController.Type.VIDEO_FLOW, this);
        this.f21254c = cVar;
        cVar.a(this.a);
        this.f21255d = new LinkedList();
        this.f21256e = new HashMap();
        int s = c.a.u0.a.h().s();
        int t = c.a.u0.a.h().t();
        if (s > 0 && t > 0) {
            z = true;
        }
        this.k = z;
        if (z) {
            c.a.u0.l3.d0.a aVar = new c.a.u0.l3.d0.a();
            this.f21261j = aVar;
            aVar.d(s - 1);
            this.f21261j.e(t);
        }
    }

    @Override // c.a.u0.l3.d0.d
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (i3 != 0) {
                this.f21259h = i3;
            }
            if (this.f21259h - 2 <= i2 && this.f21255d.isEmpty() && this.f21258g) {
                this.f21254c.loadAd();
                this.f21258g = false;
            }
        }
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f21258g = true;
            this.f21255d.addAll(list);
            VideoItemModel videoItemModel = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel;
            b.b(this.f21253b, this.m, this.f21261j, this.f21257f, videoItemModel, this.f21255d.peek(), this);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            VideoItemModel videoItemModel = this.f21253b.get(i2);
            if (this.f21256e.containsKey(videoItemModel)) {
                this.f21254c.n(this.f21256e.get(videoItemModel));
            }
        }
    }

    public AdVideoFlowFragment g(int i2) {
        InterceptResult invokeI;
        m j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            AdvertAppInfo advertAppInfo = this.f21256e.get(this.f21253b.get(i2));
            if (advertAppInfo == null || (j2 = this.f21254c.j(advertAppInfo)) == null) {
                return null;
            }
            j2.setPageChangeHandler(this.l, i2);
            AdVideoFlowFragment adVideoFlowFragment = new AdVideoFlowFragment();
            adVideoFlowFragment.setAdView(j2);
            return adVideoFlowFragment;
        }
        return (AdVideoFlowFragment) invokeI.objValue;
    }

    public List<VideoItemModel> h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<VideoItemModel, AdvertAppInfo> entry : this.f21256e.entrySet()) {
                if (TextUtils.equals(entry.getValue().g4, str)) {
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
            this.f21257f = 0;
            this.f21259h = c.a.u0.a.h().s() - 1;
            if (this.f21255d.size() >= 1 || !this.f21258g) {
                return;
            }
            this.f21254c.loadAd();
            this.f21258g = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.l3.d0.d
    /* renamed from: j */
    public void c(int i2, int i3, c.a.u0.l3.d0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, videoItemModel}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f21255d.remove(advertAppInfo);
            this.f21257f = i3;
            this.f21256e.put(videoItemModel, advertAppInfo);
            VideoPlayView videoPlayView = this.f21260i;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.l3.d0.d
    /* renamed from: k */
    public void e(int i2, int i3, VideoItemModel videoItemModel, c.a.u0.l3.d0.c cVar, VideoItemModel videoItemModel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), videoItemModel, cVar, videoItemModel2}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f21255d.remove(advertAppInfo);
            this.f21257f = i3;
            this.f21256e.put(videoItemModel, advertAppInfo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.l3.d0.d
    /* renamed from: l */
    public void d(int i2, int i3, int i4, c.a.u0.l3.d0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar, videoItemModel}) == null) {
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && this.k) {
            this.m = i2;
            VideoItemModel videoItemModel = (VideoItemModel) c.a.u0.z1.o.k.a.d(this.f21253b, i2);
            if (this.f21256e.containsKey(videoItemModel)) {
                AdvertAppInfo advertAppInfo = this.f21256e.get(videoItemModel);
                c.a.u0.l3.l0.d.q(advertAppInfo);
                c.a.u0.z1.o.h.c.g(c.a.u0.z1.o.h.c.e(advertAppInfo));
                this.f21254c.b(advertAppInfo, true);
                return;
            }
            this.f21254c.b(null, false);
            if (i2 <= this.f21257f) {
                return;
            }
            VideoItemModel videoItemModel2 = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel2;
            b.b(this.f21253b, i2, this.f21261j, this.f21257f, videoItemModel2, this.f21255d.peek(), this);
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
            this.f21260i = videoPlayView;
        }
    }
}
