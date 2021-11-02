package b.a.r0.b4.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.z2.d0.b;
import b.a.r0.z2.d0.d;
import b.a.r0.z2.e0.c;
import b.a.r0.z2.m;
import b.a.r0.z2.y;
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
/* loaded from: classes4.dex */
public class a implements IAdBaseAsyncController.a, d<VideoItemModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f15071a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f15072b;

    /* renamed from: c  reason: collision with root package name */
    public final c f15073c;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<AdvertAppInfo> f15074d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<VideoItemModel, AdvertAppInfo> f15075e;

    /* renamed from: f  reason: collision with root package name */
    public int f15076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15077g;

    /* renamed from: h  reason: collision with root package name */
    public int f15078h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPlayView f15079i;
    public b.a.r0.z2.d0.a j;
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
        this.f15076f = 0;
        this.f15077g = true;
        this.f15072b = list;
        this.f15071a = tbPageContext;
        c cVar = (c) y.o().k(IAdBaseAsyncController.Type.VIDEO_FLOW, this);
        this.f15073c = cVar;
        cVar.a(this.f15071a);
        this.f15074d = new LinkedList();
        this.f15075e = new HashMap();
        int s = b.a.r0.a.h().s();
        int t = b.a.r0.a.h().t();
        if (s > 0 && t > 0) {
            z = true;
        }
        this.k = z;
        if (z) {
            b.a.r0.z2.d0.a aVar = new b.a.r0.z2.d0.a();
            this.j = aVar;
            aVar.d(s - 1);
            this.j.e(t);
        }
    }

    @Override // b.a.r0.z2.d0.d
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (i3 != 0) {
                this.f15078h = i3;
            }
            if (this.f15078h - 2 <= i2 && this.f15074d.isEmpty() && this.f15077g) {
                this.f15073c.loadAd();
                this.f15077g = false;
            }
        }
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f15077g = true;
            this.f15074d.addAll(list);
            VideoItemModel videoItemModel = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel;
            b.b(this.f15072b, this.m, this.j, this.f15076f, videoItemModel, this.f15074d.peek(), this);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            VideoItemModel videoItemModel = this.f15072b.get(i2);
            if (this.f15075e.containsKey(videoItemModel)) {
                this.f15073c.m(this.f15075e.get(videoItemModel));
            }
        }
    }

    public AdVideoFlowFragment g(int i2) {
        InterceptResult invokeI;
        m j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            AdvertAppInfo advertAppInfo = this.f15075e.get(this.f15072b.get(i2));
            if (advertAppInfo == null || (j = this.f15073c.j(advertAppInfo)) == null) {
                return null;
            }
            j.setPageChangeHandler(this.l, i2);
            AdVideoFlowFragment adVideoFlowFragment = new AdVideoFlowFragment();
            adVideoFlowFragment.setAdView(j);
            return adVideoFlowFragment;
        }
        return (AdVideoFlowFragment) invokeI.objValue;
    }

    public List<VideoItemModel> h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<VideoItemModel, AdvertAppInfo> entry : this.f15075e.entrySet()) {
                if (TextUtils.equals(entry.getValue().X3, str)) {
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
            this.f15076f = 0;
            this.f15078h = b.a.r0.a.h().s() - 1;
            if (this.f15074d.size() >= 1 || !this.f15077g) {
                return;
            }
            this.f15073c.loadAd();
            this.f15077g = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.z2.d0.d
    /* renamed from: j */
    public void c(int i2, int i3, b.a.r0.z2.d0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, videoItemModel}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f15074d.remove(advertAppInfo);
            this.f15076f = i3;
            this.f15075e.put(videoItemModel, advertAppInfo);
            VideoPlayView videoPlayView = this.f15079i;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.z2.d0.d
    /* renamed from: k */
    public void e(int i2, int i3, VideoItemModel videoItemModel, b.a.r0.z2.d0.c cVar, VideoItemModel videoItemModel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), videoItemModel, cVar, videoItemModel2}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) cVar;
            this.f15074d.remove(advertAppInfo);
            this.f15076f = i3;
            this.f15075e.put(videoItemModel, advertAppInfo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.z2.d0.d
    /* renamed from: l */
    public void d(int i2, int i3, int i4, b.a.r0.z2.d0.c cVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar, videoItemModel}) == null) {
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && this.k) {
            this.m = i2;
            VideoItemModel videoItemModel = (VideoItemModel) b.a.r0.q1.o.k.a.d(this.f15072b, i2);
            if (this.f15075e.containsKey(videoItemModel)) {
                AdvertAppInfo advertAppInfo = this.f15075e.get(videoItemModel);
                b.a.r0.z2.l0.d.q(advertAppInfo);
                b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
                this.f15073c.b(advertAppInfo, true);
                return;
            }
            this.f15073c.b(null, false);
            if (i2 <= this.f15076f) {
                return;
            }
            VideoItemModel videoItemModel2 = new VideoItemModel(new VideoItemData(), 5);
            this.n = videoItemModel2;
            b.b(this.f15072b, i2, this.j, this.f15076f, videoItemModel2, this.f15074d.peek(), this);
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
            this.f15079i = videoPlayView;
        }
    }
}
