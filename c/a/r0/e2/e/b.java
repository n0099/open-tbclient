package c.a.r0.e2.e;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
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
    public String f17313e;

    /* renamed from: f  reason: collision with root package name */
    public int f17314f;

    /* renamed from: g  reason: collision with root package name */
    public int f17315g;

    /* renamed from: h  reason: collision with root package name */
    public String f17316h;

    /* renamed from: i  reason: collision with root package name */
    public int f17317i;

    /* renamed from: j  reason: collision with root package name */
    public int f17318j;
    public boolean k;
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
        c(threadInfo);
        this.k = z;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17318j : invokeV.intValue;
    }

    public final void c(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        d2 d2Var = new d2();
        this.l = d2Var;
        d2Var.Y2(threadInfo);
        this.f17313e = threadInfo.title;
        this.f17314f = threadInfo.reply_num.intValue();
        this.f17315g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.l.E0())) {
            Iterator<MediaData> it = this.l.E0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f17316h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f17316h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f17316h)) {
                        this.f17316h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f17316h)) {
                        this.f17316h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f17316h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f17317i = videoInfo.video_duration.intValue();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17318j = i2;
        }
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a.f17311a : (BdUniqueId) invokeV.objValue;
    }
}
