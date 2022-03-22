package c.a.p0.q2.e;

import c.a.d.o.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f17659b;

    /* renamed from: c  reason: collision with root package name */
    public int f17660c;

    /* renamed from: d  reason: collision with root package name */
    public String f17661d;

    /* renamed from: e  reason: collision with root package name */
    public int f17662e;

    /* renamed from: f  reason: collision with root package name */
    public int f17663f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17664g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadData f17665h;

    public b(ThreadInfo threadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(threadInfo);
        this.f17664g = z;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17663f : invokeV.intValue;
    }

    public final void b(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        ThreadData threadData = new ThreadData();
        this.f17665h = threadData;
        threadData.parserProtobuf(threadInfo);
        this.a = threadInfo.title;
        this.f17659b = threadInfo.reply_num.intValue();
        this.f17660c = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.f17665h.getMedias())) {
            Iterator<MediaData> it = this.f17665h.getMedias().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f17661d = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f17661d = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f17661d)) {
                        this.f17661d = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f17661d)) {
                        this.f17661d = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f17661d)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f17662e = videoInfo.video_duration.intValue();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f17663f = i;
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a.a : (BdUniqueId) invokeV.objValue;
    }
}
