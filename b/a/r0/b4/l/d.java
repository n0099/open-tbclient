package b.a.r0.b4.l;

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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f15040a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f15041b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VideoAttentionPersonListData> f15042c;

    /* renamed from: d  reason: collision with root package name */
    public String f15043d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15044e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15045f;

    /* renamed from: g  reason: collision with root package name */
    public String f15046g;

    /* renamed from: h  reason: collision with root package name */
    public int f15047h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15048i;
    public c j;

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
        this.f15047h = -1;
        this.f15048i = true;
        this.f15041b = new LinkedList();
        this.f15044e = b.a.q0.t.c.e.m() - 1;
        this.f15045f = b.a.q0.t.c.e.l() + 1;
        this.f15042c = new LinkedList();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15041b.clear();
            this.f15041b.add(new VideoItemModel(null, 3));
            this.f15048i = false;
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.f15040a = bdUniqueId;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f15046g = str;
        }
    }

    public void D(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void a(int i2) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f15048i) {
            ArrayList arrayList = new ArrayList(this.f15041b);
            if (this.f15047h < 0) {
                int i3 = this.f15044e;
                this.f15047h = i3;
                if (i3 <= i2) {
                    return;
                }
                if (i3 >= arrayList.size() + 1) {
                    this.f15047h = -1;
                    return;
                }
                VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.f15047h);
                if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                    arrayList.add(this.f15047h, new VideoItemModel(null, 2));
                }
            }
            int i4 = this.f15047h;
            while (true) {
                i4 += this.f15045f;
                if (i4 >= arrayList.size() + 1) {
                    break;
                } else if (i4 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i4)) == null || !videoItemModel.isFunAdType())) {
                    this.f15047h = i4;
                    arrayList.add(i4, new VideoItemModel(null, 2));
                }
            }
            this.f15041b.clear();
            this.f15041b.addAll(arrayList);
            c cVar = this.j;
            if (cVar != null) {
                cVar.onVideoDataAdd();
            }
        }
    }

    public void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (VideoItemData videoItemData : list) {
                arrayList.add(new VideoItemModel(videoItemData, 1));
            }
            this.f15041b.addAll(arrayList);
            c cVar = this.j;
            if (cVar != null) {
                cVar.onVideoDataAdd();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f15041b.size() == 0) {
            this.f15041b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f15041b.size() <= 1 || (videoItemModel = this.f15041b.get(0)) == null || !videoItemModel.isLoadingType()) {
            return;
        }
        this.f15041b.remove(0);
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f15041b.iterator();
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
            int indexOf = this.f15041b.indexOf(videoItemModel);
            int i3 = this.f15047h;
            if (indexOf < i3) {
                this.f15047h = i3 - 1;
            }
            this.f15041b.remove(videoItemModel);
            c cVar = this.j;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f15041b.iterator();
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
                this.f15041b.remove(videoItemModel);
                c cVar = this.j;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            for (int i3 = i2 + 1; i3 < this.f15041b.size(); i3++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f15041b, i3);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.f15041b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.f15047h + this.f15045f > this.f15041b.size() - 1) {
                this.f15047h += this.f15045f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15041b : (List) invokeV.objValue;
    }

    @Nullable
    public UserItemData i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f15041b : (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f15041b.size() : invokeV.intValue;
    }

    @Nullable
    public Long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return (Long) invokeV.objValue;
        }
        int size = this.f15041b.size();
        while (true) {
            size--;
            if (size < 0) {
                return null;
            }
            VideoItemData t = t(size);
            if (t != null) {
                long g2 = b.a.e.e.m.b.g(t.getThreadId(), 0L);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (VideoItemModel) ListUtils.getItem(this.f15041b, i2) : (VideoItemModel) invokeI.objValue;
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f15040a : (BdUniqueId) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f15046g : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f15042c : (List) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f15043d : (String) invokeV.objValue;
    }

    @Nullable
    public String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f15041b, i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.f15041b.get(i2).getVideoItemData() : (VideoItemData) invokeI.objValue;
    }

    public boolean u(VideoItemModel videoItemModel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, videoItemModel, i2)) == null) {
            if (i2 == 0 && this.f15041b.size() > 0 && this.f15041b.get(0).isLoadingType()) {
                this.f15041b.set(0, videoItemModel);
                c cVar = this.j;
                if (cVar != null) {
                    cVar.onVideoDataAdd();
                }
                return true;
            }
            if (i2 < this.f15041b.size()) {
                this.f15041b.add(i2, videoItemModel);
            } else {
                this.f15041b.add(videoItemModel);
            }
            d();
            c cVar2 = this.j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? ListUtils.isEmpty(this.f15041b) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f15041b.size() == 0 || (this.f15041b.size() == 1 && this.f15041b.get(0).isLoadingType()) : invokeV.booleanValue;
    }

    public boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            int i3 = this.f15044e;
            while (i3 < this.f15041b.size()) {
                if (i3 == i2) {
                    return true;
                }
                i3 += this.f15045f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void y(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || list == null) {
            return;
        }
        this.f15047h = -1;
        List arrayList = new ArrayList(this.f15041b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                this.f15047h = i2;
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
        this.f15041b.clear();
        this.f15041b.addAll(arrayList);
        d();
        this.f15048i = true;
        c cVar = this.j;
        if (cVar != null) {
            cVar.onVideoDataReset();
        }
    }

    public void z(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, list, str) == null) {
            this.f15041b.clear();
            this.f15041b.add(new VideoItemModel(null, 4));
            this.f15042c.clear();
            this.f15042c.addAll(list);
            this.f15043d = str;
            this.f15048i = false;
        }
    }
}
