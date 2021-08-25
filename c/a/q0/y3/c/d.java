package c.a.q0.y3.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
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
    public BdUniqueId f29160a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f29161b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VideoAttentionPersonListData> f29162c;

    /* renamed from: d  reason: collision with root package name */
    public String f29163d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29164e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29165f;

    /* renamed from: g  reason: collision with root package name */
    public String f29166g;

    /* renamed from: h  reason: collision with root package name */
    public int f29167h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29168i;

    /* renamed from: j  reason: collision with root package name */
    public c f29169j;

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
        this.f29167h = -1;
        this.f29168i = true;
        this.f29161b = new LinkedList();
        this.f29164e = c.a.p0.t.c.e.j() - 1;
        this.f29165f = c.a.p0.t.c.e.i() + 1;
        this.f29162c = new LinkedList();
    }

    public void a(int i2) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f29168i) {
            ArrayList arrayList = new ArrayList(this.f29161b);
            if (this.f29167h < 0) {
                int i3 = this.f29164e;
                this.f29167h = i3;
                if (i3 <= i2) {
                    return;
                }
                if (i3 >= arrayList.size() + 1) {
                    this.f29167h = -1;
                    return;
                }
                VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.f29167h);
                if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                    arrayList.add(this.f29167h, new VideoItemModel(null, 2));
                }
            }
            int i4 = this.f29167h;
            while (true) {
                i4 += this.f29165f;
                if (i4 >= arrayList.size() + 1) {
                    break;
                } else if (i4 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i4)) == null || !videoItemModel.isFunAdType())) {
                    this.f29167h = i4;
                    arrayList.add(i4, new VideoItemModel(null, 2));
                }
            }
            this.f29161b.clear();
            this.f29161b.addAll(arrayList);
            c cVar = this.f29169j;
            if (cVar != null) {
                cVar.onVideoDataAdd();
            }
        }
    }

    public void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (VideoItemData videoItemData : list) {
                arrayList.add(new VideoItemModel(videoItemData, 1));
            }
            this.f29161b.addAll(arrayList);
            c cVar = this.f29169j;
            if (cVar != null) {
                cVar.onVideoDataAdd();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f29161b.size() == 0) {
            this.f29161b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f29161b.size() <= 1 || (videoItemModel = this.f29161b.get(0)) == null || !videoItemModel.isLoadingType()) {
            return;
        }
        this.f29161b.remove(0);
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f29161b.iterator();
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
            int indexOf = this.f29161b.indexOf(videoItemModel);
            int i3 = this.f29167h;
            if (indexOf < i3) {
                this.f29167h = i3 - 1;
            }
            this.f29161b.remove(videoItemModel);
            c cVar = this.f29169j;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f29161b.iterator();
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
                this.f29161b.remove(videoItemModel);
                c cVar = this.f29169j;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            for (int i3 = i2 + 1; i3 < this.f29161b.size(); i3++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f29161b, i3);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.f29161b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.f29167h + this.f29165f > this.f29161b.size() - 1) {
                this.f29167h += this.f29165f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29161b : (List) invokeV.objValue;
    }

    public List<VideoItemModel> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29161b : (List) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29161b.size() : invokeV.intValue;
    }

    public VideoItemModel k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? (VideoItemModel) ListUtils.getItem(this.f29161b, i2) : (VideoItemModel) invokeI.objValue;
    }

    public BdUniqueId l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29160a : (BdUniqueId) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29166g : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29162c : (List) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29163d : (String) invokeV.objValue;
    }

    @Nullable
    public VideoItemData p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f29161b, i2);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    public boolean q(VideoItemModel videoItemModel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, videoItemModel, i2)) == null) {
            if (i2 == 0 && this.f29161b.size() > 0 && this.f29161b.get(0).isLoadingType()) {
                this.f29161b.set(0, videoItemModel);
                c cVar = this.f29169j;
                if (cVar != null) {
                    cVar.onVideoDataAdd();
                }
                return true;
            }
            if (i2 < this.f29161b.size()) {
                this.f29161b.add(i2, videoItemModel);
            } else {
                this.f29161b.add(videoItemModel);
            }
            d();
            c cVar2 = this.f29169j;
            if (cVar2 != null) {
                cVar2.onVideoDataAdd();
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? ListUtils.isEmpty(this.f29161b) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f29161b.size() == 0 || (this.f29161b.size() == 1 && this.f29161b.get(0).isLoadingType()) : invokeV.booleanValue;
    }

    public boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int i3 = this.f29164e;
            while (i3 < this.f29161b.size()) {
                if (i3 == i2) {
                    return true;
                }
                i3 += this.f29165f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void u(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null) {
            return;
        }
        this.f29167h = -1;
        List arrayList = new ArrayList(this.f29161b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                this.f29167h = i2;
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
        this.f29161b.clear();
        this.f29161b.addAll(arrayList);
        d();
        this.f29168i = true;
        c cVar = this.f29169j;
        if (cVar != null) {
            cVar.onVideoDataReset();
        }
    }

    public void v(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, list, str) == null) {
            this.f29161b.clear();
            this.f29161b.add(new VideoItemModel(null, 4));
            this.f29162c.clear();
            this.f29162c.addAll(list);
            this.f29163d = str;
            this.f29168i = false;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29161b.clear();
            this.f29161b.add(new VideoItemModel(null, 3));
            this.f29168i = false;
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.f29160a = bdUniqueId;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f29166g = str;
        }
    }

    public void z(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.f29169j = cVar;
        }
    }
}
