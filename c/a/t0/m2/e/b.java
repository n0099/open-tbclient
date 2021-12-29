package c.a.t0.m2.e;

import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19860e;

    /* renamed from: f  reason: collision with root package name */
    public int f19861f;

    /* renamed from: g  reason: collision with root package name */
    public int f19862g;

    /* renamed from: h  reason: collision with root package name */
    public String f19863h;

    /* renamed from: i  reason: collision with root package name */
    public int f19864i;

    /* renamed from: j  reason: collision with root package name */
    public int f19865j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19866k;
    public d2 l;

    public b(ThreadInfo threadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d(threadInfo);
        this.f19866k = z;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19865j : invokeV.intValue;
    }

    public final void d(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        d2 d2Var = new d2();
        this.l = d2Var;
        d2Var.c3(threadInfo);
        this.f19860e = threadInfo.title;
        this.f19861f = threadInfo.reply_num.intValue();
        this.f19862g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.l.F0())) {
            Iterator<MediaData> it = this.l.F0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f19863h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f19863h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f19863h)) {
                        this.f19863h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f19863h)) {
                        this.f19863h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f19863h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f19864i = videoInfo.video_duration.intValue();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f19865j = i2;
        }
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a.a : (BdUniqueId) invokeV.objValue;
    }
}
