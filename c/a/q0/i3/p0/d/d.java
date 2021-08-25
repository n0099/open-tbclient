package c.a.q0.i3.p0.d;

import c.a.e.e.p.q;
import c.a.q0.y1.g;
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
/* loaded from: classes3.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f20449a;

    /* renamed from: b  reason: collision with root package name */
    public String f20450b;

    /* renamed from: c  reason: collision with root package name */
    public String f20451c;

    /* renamed from: d  reason: collision with root package name */
    public final int f20452d;

    /* renamed from: e  reason: collision with root package name */
    public int f20453e;

    /* renamed from: f  reason: collision with root package name */
    public e f20454f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20455g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i3.p0.d.f.a f20456h;

    /* renamed from: i  reason: collision with root package name */
    public g f20457i;

    public d(String str, int i2, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20451c = str;
        this.f20452d = i2;
        this.f20457i = gVar;
        File file = new File(str);
        if (file.exists()) {
            this.f20449a = file.length();
            this.f20450b = q.b(FileHelper.GetStreamFromFile(file));
            long j2 = this.f20449a;
            int i5 = this.f20452d;
            if (j2 % i5 == 0) {
                this.f20453e = (int) (j2 / i5);
            } else {
                this.f20453e = ((int) (j2 / i5)) + 1;
            }
        }
    }

    @Override // c.a.q0.i3.p0.d.b
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f20454f = eVar;
        }
    }

    @Override // c.a.q0.i3.p0.d.b
    public VideoFinishResult b(String str, int i2) {
        InterceptResult invokeLI;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (StringUtils.isNull(str) || this.f20449a <= 0 || StringUtils.isNull(this.f20450b) || i2 <= 0 || this.f20455g) {
                return null;
            }
            d(10);
            long j2 = i2;
            a c3 = c(this.f20453e, j2, false, null);
            if (c3 != null && !this.f20455g) {
                if (c3.f20441e != 0) {
                    VideoFinishResult videoFinishResult = new VideoFinishResult();
                    videoFinishResult.setErrorNo(c3.f20441e);
                    videoFinishResult.setUserMessage(c3.f20440d);
                    e(302, c3.f20441e, c3.f20440d);
                    return videoFinishResult;
                }
                d(30);
                if (!StringUtils.isNull(c3.f20439c)) {
                    VideoFinishResult videoFinishResult2 = new VideoFinishResult();
                    videoFinishResult2.setVideoMd5(this.f20450b);
                    videoFinishResult2.setVideoUrl(c3.f20439c);
                    f();
                    return videoFinishResult2;
                } else if (this.f20455g) {
                    return null;
                } else {
                    ArrayList<Integer> arrayList = c3.f20437a;
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList<>();
                        int i3 = 0;
                        while (i3 < this.f20453e) {
                            i3++;
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    String str2 = c3.f20438b;
                    c.a.q0.i3.p0.d.f.d g2 = g(arrayList, str2, i2);
                    if (g2 != null && !this.f20455g) {
                        if (g2.f20476b != 0) {
                            VideoFinishResult videoFinishResult3 = new VideoFinishResult();
                            videoFinishResult3.setErrorNo(g2.f20476b);
                            videoFinishResult3.setUserMessage(g2.f20477c);
                            e(303, g2.f20476b, g2.f20477c);
                            return videoFinishResult3;
                        }
                        d(85);
                        if (!StringUtils.isNull(g2.f20475a)) {
                            VideoFinishResult videoFinishResult4 = new VideoFinishResult();
                            videoFinishResult4.setVideoUrl(g2.f20475a);
                            videoFinishResult4.setVideoMd5(this.f20450b);
                            f();
                            return videoFinishResult4;
                        } else if (this.f20455g || (c2 = c(this.f20453e, j2, true, str2)) == null) {
                            return null;
                        } else {
                            VideoFinishResult videoFinishResult5 = new VideoFinishResult();
                            int i4 = c2.f20441e;
                            if (i4 == 0) {
                                videoFinishResult5.setVideoUrl(c2.f20439c);
                                videoFinishResult5.setVideoMd5(this.f20450b);
                                f();
                            } else {
                                videoFinishResult5.setErrorNo(i4);
                                videoFinishResult5.setUserMessage(c2.f20440d);
                                e(304, c2.f20441e, c2.f20440d);
                                TiebaStatic.log(new StatisticItem("c12024").param("params", c2.f20440d));
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

    public final a c(int i2, long j2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z), str})) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_CHECK_VIDEO_STATUS);
            netWork.addPostData("chunk_sum", String.valueOf(i2));
            netWork.addPostData("video_size", String.valueOf(this.f20449a));
            netWork.addPostData("chunk_size", String.valueOf(this.f20452d));
            netWork.addPostData("is_merge", String.valueOf(z ? 1 : 0));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f20450b);
            netWork.addPostData("video_len", String.valueOf(j2));
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
                aVar2.f20441e = netWork.getNetContext().getResponse().mServerErrorCode;
            } else {
                aVar2.f20441e = netWork.getNetContext().getResponse().mNetErrorCode;
            }
            aVar2.f20440d = netWork.getNetContext().getResponse().mErrorString;
            return aVar2;
        }
        return (a) invokeCommon.objValue;
    }

    @Override // c.a.q0.i3.p0.d.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20455g = true;
            c.a.q0.i3.p0.d.f.a aVar = this.f20456h;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void d(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (eVar = this.f20454f) == null) {
            return;
        }
        eVar.onProgressUpdate(i2 / 100.0f);
    }

    public final void e(int i2, int i3, String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) || (gVar = this.f20457i) == null) {
            return;
        }
        gVar.f(i2, i3, str);
    }

    public final void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f20457i) == null) {
            return;
        }
        gVar.j();
    }

    public final c.a.q0.i3.p0.d.f.d g(ArrayList<Integer> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, arrayList, str, i2)) == null) {
            if (ListUtils.isEmpty(arrayList) || StringUtils.isNull(str)) {
                return null;
            }
            if (arrayList.size() > 3) {
                this.f20456h = new c.a.q0.i3.p0.d.f.b(this.f20451c, this.f20452d, this.f20453e, this.f20449a, this.f20450b);
            } else {
                this.f20456h = new c.a.q0.i3.p0.d.f.c(this.f20451c, this.f20452d, this.f20453e, this.f20449a, this.f20450b);
            }
            this.f20456h.f(this.f20454f);
            c.a.q0.i3.p0.d.f.d g2 = this.f20456h.g(arrayList, str, i2);
            this.f20456h = null;
            return g2;
        }
        return (c.a.q0.i3.p0.d.f.d) invokeLLI.objValue;
    }
}
