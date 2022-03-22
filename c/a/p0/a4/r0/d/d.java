package c.a.p0.a4.r0.d;

import c.a.d.f.p.t;
import c.a.p0.l2.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f12355b;

    /* renamed from: c  reason: collision with root package name */
    public String f12356c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12357d;

    /* renamed from: e  reason: collision with root package name */
    public int f12358e;

    /* renamed from: f  reason: collision with root package name */
    public e f12359f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12360g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a4.r0.d.f.a f12361h;
    public g i;

    public d(String str, int i, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12356c = str;
        this.f12357d = i;
        this.i = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.a = file.length();
            this.f12355b = t.b(FileHelper.GetStreamFromFile(file));
            long j = this.a;
            int i4 = this.f12357d;
            if (j % i4 == 0) {
                this.f12358e = (int) (j / i4);
            } else {
                this.f12358e = ((int) (j / i4)) + 1;
            }
        }
    }

    @Override // c.a.p0.a4.r0.d.b
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f12359f = eVar;
        }
    }

    @Override // c.a.p0.a4.r0.d.b
    public VideoFinishResult b(String str, int i) {
        InterceptResult invokeLI;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (StringUtils.isNull(str) || this.a <= 0 || StringUtils.isNull(this.f12355b) || i <= 0 || this.f12360g) {
                return null;
            }
            d(10);
            long j = i;
            a c3 = c(this.f12358e, j, false, null);
            if (c3 != null && !this.f12360g) {
                if (c3.f12348e != 0) {
                    VideoFinishResult videoFinishResult = new VideoFinishResult();
                    videoFinishResult.setErrorNo(c3.f12348e);
                    videoFinishResult.setUserMessage(c3.f12347d);
                    e(302, c3.f12348e, c3.f12347d);
                    return videoFinishResult;
                }
                d(30);
                if (!StringUtils.isNull(c3.f12346c)) {
                    VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                    videoFinishResult2.setVideoMd5(this.f12355b);
                    videoFinishResult2.setVideoUrl(c3.f12346c);
                    f();
                    return videoFinishResult2;
                } else if (this.f12360g) {
                    return null;
                } else {
                    ArrayList<Integer> arrayList = c3.a;
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList<>();
                        int i2 = 0;
                        while (i2 < this.f12358e) {
                            i2++;
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    String str2 = c3.f12345b;
                    c.a.p0.a4.r0.d.f.d g2 = g(arrayList, str2, i);
                    if (g2 != null && !this.f12360g) {
                        if (g2.f12377b != 0) {
                            VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                            videoFinishResult3.setErrorNo(g2.f12377b);
                            videoFinishResult3.setUserMessage(g2.f12378c);
                            e(303, g2.f12377b, g2.f12378c);
                            return videoFinishResult3;
                        }
                        d(85);
                        if (!StringUtils.isNull(g2.a)) {
                            VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                            videoFinishResult4.setVideoUrl(g2.a);
                            videoFinishResult4.setVideoMd5(this.f12355b);
                            f();
                            return videoFinishResult4;
                        } else if (this.f12360g || (c2 = c(this.f12358e, j, true, str2)) == null) {
                            return null;
                        } else {
                            VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                            int i3 = c2.f12348e;
                            if (i3 == 0) {
                                videoFinishResult5.setVideoUrl(c2.f12346c);
                                videoFinishResult5.setVideoMd5(this.f12355b);
                                f();
                            } else {
                                videoFinishResult5.setErrorNo(i3);
                                videoFinishResult5.setUserMessage(c2.f12347d);
                                e(304, c2.f12348e, c2.f12347d);
                                TiebaStatic.log(new StatisticItem("c12024").param("params", c2.f12347d));
                            }
                            d(100);
                            return videoFinishResult5;
                        }
                    }
                }
            }
            return null;
        }
        return (VideoFinishResult) invokeLI.objValue;
    }

    public final a c(int i, long j, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z), str})) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
            netWork.addPostData("chunk_sum", String.valueOf(i));
            netWork.addPostData("video_size", String.valueOf(this.a));
            netWork.addPostData("chunk_size", String.valueOf(this.f12357d));
            netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f12355b);
            netWork.addPostData("video_len", String.valueOf(j));
            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            if (!StringUtils.isNull(str)) {
                netWork.addPostData("upload_id", str);
            }
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                a aVar = new a();
                aVar.a(postNetData);
                return aVar;
            }
            a aVar2 = new a();
            if (netWork.getNetContext().getResponse().isNetSuccess()) {
                aVar2.f12348e = netWork.getNetContext().getResponse().mServerErrorCode;
            } else {
                aVar2.f12348e = netWork.getNetContext().getResponse().mNetErrorCode;
            }
            aVar2.f12347d = netWork.getNetContext().getResponse().mErrorString;
            return aVar2;
        }
        return (a) invokeCommon.objValue;
    }

    @Override // c.a.p0.a4.r0.d.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12360g = true;
            c.a.p0.a4.r0.d.f.a aVar = this.f12361h;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void d(int i) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (eVar = this.f12359f) == null) {
            return;
        }
        eVar.onProgressUpdate(i / 100.0f);
    }

    public final void e(int i, int i2, String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) || (gVar = this.i) == null) {
            return;
        }
        gVar.f(i, i2, str);
    }

    public final void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.i) == null) {
            return;
        }
        gVar.j();
    }

    public final c.a.p0.a4.r0.d.f.d g(ArrayList<Integer> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, arrayList, str, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
                return null;
            }
            if (arrayList.size() > 3) {
                this.f12361h = new c.a.p0.a4.r0.d.f.b(this.f12356c, this.f12357d, this.f12358e, this.a, this.f12355b);
            } else {
                this.f12361h = new c.a.p0.a4.r0.d.f.c(this.f12356c, this.f12357d, this.f12358e, this.a, this.f12355b);
            }
            this.f12361h.f(this.f12359f);
            c.a.p0.a4.r0.d.f.d g2 = this.f12361h.g(arrayList, str, i);
            this.f12361h = null;
            return g2;
        }
        return (c.a.p0.a4.r0.d.f.d) invokeLLI.objValue;
    }
}
