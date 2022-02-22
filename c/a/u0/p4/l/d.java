package c.a.u0.p4.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f21213b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VideoAttentionPersonListData> f21214c;

    /* renamed from: d  reason: collision with root package name */
    public String f21215d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21216e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21217f;

    /* renamed from: g  reason: collision with root package name */
    public String f21218g;

    /* renamed from: h  reason: collision with root package name */
    public int f21219h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21220i;

    /* renamed from: j  reason: collision with root package name */
    public c f21221j;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21219h = -1;
        this.f21220i = true;
        this.f21213b = new LinkedList();
        this.f21216e = c.a.t0.t.c.e.m() - 1;
        this.f21217f = c.a.t0.t.c.e.l() + 1;
        this.f21214c = new LinkedList();
    }

    public void A(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) {
            this.f21213b.clear();
            this.f21213b.add(new VideoItemModel(null, 4));
            this.f21214c.clear();
            this.f21214c.addAll(list);
            this.f21215d = str;
            this.f21220i = false;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21213b.clear();
            this.f21213b.add(new VideoItemModel(null, 3));
            this.f21220i = false;
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f21218g = str;
        }
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f21221j = cVar;
        }
    }

    public void a(int i2) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f21220i) {
            ArrayList arrayList = new ArrayList(this.f21213b);
            if (this.f21219h < 0) {
                int i3 = this.f21216e;
                this.f21219h = i3;
                if (i3 <= i2) {
                    return;
                }
                if (i3 >= arrayList.size() + 1) {
                    this.f21219h = -1;
                    return;
                }
                VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.f21219h);
                if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                    arrayList.add(this.f21219h, new VideoItemModel(null, 2));
                }
            }
            int i4 = this.f21219h;
            while (true) {
                i4 += this.f21217f;
                if (i4 >= arrayList.size() + 1) {
                    break;
                } else if (i4 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i4)) == null || !videoItemModel.isFunAdType())) {
                    this.f21219h = i4;
                    arrayList.add(i4, new VideoItemModel(null, 2));
                }
            }
            this.f21213b.clear();
            this.f21213b.addAll(arrayList);
            c cVar = this.f21221j;
            if (cVar != null) {
                cVar.onVideoDataAdd();
            }
        }
    }

    public synchronized void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (VideoItemData videoItemData : list) {
                    if (this.f21213b.size() == 0 || w(videoItemData)) {
                        arrayList.add(new VideoItemModel(videoItemData, 1));
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.f21213b.addAll(arrayList);
                }
                if (this.f21221j != null) {
                    this.f21221j.onVideoDataAdd();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f21213b.size() == 0) {
            this.f21213b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f21213b.size() <= 1 || (videoItemModel = this.f21213b.get(0)) == null || !videoItemModel.isLoadingType()) {
            return;
        }
        this.f21213b.remove(0);
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f21213b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next.getHashCode() == i2) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null || !videoItemModel.isFunAdType()) {
                return false;
            }
            int indexOf = this.f21213b.indexOf(videoItemModel);
            int i3 = this.f21219h;
            if (indexOf < i3) {
                this.f21219h = i3 - 1;
            }
            this.f21213b.remove(videoItemModel);
            c cVar = this.f21221j;
            if (cVar != null) {
                cVar.onVideoDataDelete();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f21213b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next != null && next.getVideoItemData() != null && str.equalsIgnoreCase(next.getVideoItemData().thread_id)) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel != null) {
                this.f21213b.remove(videoItemModel);
                c cVar = this.f21221j;
                if (cVar != null) {
                    cVar.onVideoDataDelete();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            for (int i3 = i2 + 1; i3 < this.f21213b.size(); i3++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f21213b, i3);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.f21213b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.f21219h + this.f21217f > this.f21213b.size() - 1) {
                this.f21219h += this.f21217f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21213b : (List) invokeV.objValue;
    }

    @Nullable
    public UserItemData i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            VideoItemData t = t(i2);
            if (t != null) {
                return t.author_info;
            }
            return null;
        }
        return (UserItemData) invokeI.objValue;
    }

    public List<VideoItemModel> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f21213b : (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f21213b.size() : invokeV.intValue;
    }

    @Nullable
    public Long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048592, this)) != null) {
            return (Long) invokeV.objValue;
        }
        int size = this.f21213b.size();
        while (true) {
            size--;
            if (size < 0) {
                return null;
            }
            VideoItemData t = t(size);
            if (t != null) {
                long g2 = c.a.d.f.m.b.g(t.getThreadId(), 0L);
                if (g2 == 0) {
                    return null;
                }
                return Long.valueOf(g2);
            }
        }
    }

    public VideoItemModel m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? (VideoItemModel) ListUtils.getItem(this.f21213b, i2) : (VideoItemModel) invokeI.objValue;
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a : (BdUniqueId) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f21218g : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f21214c : (List) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f21215d : (String) invokeV.objValue;
    }

    @Nullable
    public String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            VideoItemData t = t(i2);
            if (t != null) {
                return t.getThreadId();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Nullable
    public VideoItemData s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f21213b, i2);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    @Nullable
    public final VideoItemData t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? this.f21213b.get(i2).getVideoItemData() : (VideoItemData) invokeI.objValue;
    }

    public boolean u(VideoItemModel videoItemModel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, videoItemModel, i2)) == null) {
            if (i2 == 0 && this.f21213b.size() > 0 && this.f21213b.get(0).isLoadingType()) {
                this.f21213b.set(0, videoItemModel);
                c cVar = this.f21221j;
                if (cVar != null) {
                    cVar.onVideoDataAdd();
                }
                return true;
            }
            if (i2 < this.f21213b.size()) {
                this.f21213b.add(i2, videoItemModel);
            } else {
                this.f21213b.add(videoItemModel);
            }
            d();
            c cVar2 = this.f21221j;
            if (cVar2 != null) {
                cVar2.onVideoDataAdd();
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? ListUtils.isEmpty(this.f21213b) : invokeV.booleanValue;
    }

    public final boolean w(VideoItemData videoItemData) {
        InterceptResult invokeL;
        VideoItemData videoItemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, videoItemData)) == null) {
            if (videoItemData == null || videoItemData.getThreadId() == null) {
                return false;
            }
            if (this.f21213b.size() < 1) {
                return true;
            }
            int i2 = 0;
            for (int size = this.f21213b.size() - 1; size >= 0 && i2 < 30; size--) {
                VideoItemModel videoItemModel = this.f21213b.get(size);
                if (videoItemModel != null && (videoItemData2 = videoItemModel.getVideoItemData()) != null && videoItemData2.getThreadId() != null) {
                    if (videoItemData2.getThreadId().equals(videoItemData.getThreadId())) {
                        return false;
                    }
                    i2++;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f21213b.size() == 0 || (this.f21213b.size() == 1 && this.f21213b.get(0).isLoadingType()) : invokeV.booleanValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            int i3 = this.f21216e;
            while (i3 < this.f21213b.size()) {
                if (i3 == i2) {
                    return true;
                }
                i3 += this.f21217f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void z(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, list) == null) || list == null) {
            return;
        }
        this.f21219h = -1;
        List arrayList = new ArrayList(this.f21213b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                this.f21219h = i2;
            } else {
                int i4 = i3 + 1;
                VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, i3);
                if (videoItemData == null) {
                    arrayList = arrayList.subList(0, i2);
                    i3 = i4;
                    break;
                }
                arrayList.set(i2, new VideoItemModel(videoItemData, 1));
                i3 = i4;
            }
            i2++;
        }
        if (i3 < list.size()) {
            for (VideoItemData videoItemData2 : list.subList(i3, list.size())) {
                arrayList.add(new VideoItemModel(videoItemData2, 1));
            }
        }
        this.f21213b.clear();
        this.f21213b.addAll(arrayList);
        d();
        this.f21220i = true;
        c cVar = this.f21221j;
        if (cVar != null) {
            cVar.onVideoDataReset();
        }
    }
}
