package c.a.p0.c2.e;

import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
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
/* loaded from: classes3.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f16306e;

    /* renamed from: f  reason: collision with root package name */
    public int f16307f;

    /* renamed from: g  reason: collision with root package name */
    public int f16308g;

    /* renamed from: h  reason: collision with root package name */
    public String f16309h;

    /* renamed from: i  reason: collision with root package name */
    public int f16310i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16311j;
    public c2 k;

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
        b(threadInfo);
        this.f16311j = z;
    }

    public final void b(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        c2 c2Var = new c2();
        this.k = c2Var;
        c2Var.S2(threadInfo);
        this.f16306e = threadInfo.title;
        this.f16307f = threadInfo.reply_num.intValue();
        this.f16308g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.C0())) {
            Iterator<MediaData> it = this.k.C0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f16309h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f16309h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f16309h)) {
                        this.f16309h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f16309h)) {
                        this.f16309h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f16309h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f16310i = videoInfo.video_duration.intValue();
        }
    }

    @Override // c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.f16304a : (BdUniqueId) invokeV.objValue;
    }
}
