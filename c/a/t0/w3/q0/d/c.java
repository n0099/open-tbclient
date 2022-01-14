package c.a.t0.w3.q0.d;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.t;
import c.a.t0.h2.g;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoBlockUploadResult;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24967b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24968c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24969d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24970e;

    /* renamed from: f  reason: collision with root package name */
    public e f24971f;

    /* renamed from: g  reason: collision with root package name */
    public g f24972g;

    public c(String str, int i2, int i3, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24967b = false;
        this.f24968c = str;
        this.f24970e = i2;
        this.f24969d = i3 / i2;
        this.f24972g = gVar;
    }

    @Override // c.a.t0.w3.q0.d.b
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f24971f = eVar;
        }
    }

    @Override // c.a.t0.w3.q0.d.b
    public VideoFinishResult b(String str, int i2) throws IOException {
        InterceptResult invokeLI;
        long j2;
        VideoBlockUploadResult i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            String str3 = null;
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                c.a.t0.w3.q0.b.a();
                VideoFinishResult videoFinishResult = new VideoFinishResult();
                String b2 = t.b(FileHelper.GetStreamFromFile(file));
                if (!StringUtils.isNull(b2)) {
                    b2 = b2.toLowerCase();
                }
                String str4 = b2;
                c.a.t0.w3.q0.c c2 = c.a.t0.w3.q0.b.c(str4);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                long length = file.length();
                int d2 = d(length, this.f24970e);
                int d3 = d(d2, this.f24969d);
                String str5 = c2 != null ? c2.a : null;
                int i4 = c2 != null ? c2.f24962b : 0;
                if (i4 < d2 && randomAccessFile.skipBytes(this.f24970e * i4) < this.f24970e * i4) {
                    randomAccessFile.close();
                    return null;
                }
                String str6 = str5;
                int i5 = i4;
                VideoBlockUploadResult videoBlockUploadResult = null;
                while (i5 < d2) {
                    f(i5, d2, 10);
                    int i6 = i5 + 1;
                    int i7 = i5;
                    VideoBlockUploadResult videoBlockUploadResult2 = videoBlockUploadResult;
                    byte[] c3 = c(randomAccessFile, i5, d2, length);
                    f(i7, d2, 25);
                    if (c3 == null || c3.length <= 0) {
                        j2 = length;
                        videoBlockUploadResult = videoBlockUploadResult2;
                    } else {
                        f(i7, d2, 40);
                        j2 = length;
                        this.a = e(str4, length, d3, str6);
                        f(i7, d2, 55);
                        if (i6 == d2) {
                            i3 = j(c3, i6, d3, d2);
                        } else if (i6 % this.f24969d == 0) {
                            VideoBlockUploadResult h2 = h(c3, i6, d3, d2);
                            str2 = h2.upload_id;
                            videoBlockUploadResult = h2;
                            f(i7, d2, 80);
                            if (videoBlockUploadResult == null && !videoBlockUploadResult.isSuccess()) {
                                videoFinishResult.setUserMessage(videoBlockUploadResult.getErrorMessage());
                                videoFinishResult.setErrorNo(videoBlockUploadResult.getErrorCode());
                                g gVar = this.f24972g;
                                if (gVar != null) {
                                    gVar.f(305, videoBlockUploadResult.getErrorCode(), videoBlockUploadResult.getErrorMessage());
                                }
                                if (videoFinishResult.getErrorNo() == 320033) {
                                    c.a.t0.w3.q0.b.b(str4);
                                }
                                randomAccessFile.close();
                                TiebaStatic.log(new StatisticItem("c12024").param("params", videoBlockUploadResult.getErrorMessage()));
                                return videoFinishResult;
                            }
                            c.a.t0.w3.q0.b.d(str4, str2, i6);
                            f(i7, d2, 100);
                            str6 = str2;
                        } else {
                            i3 = i(i6, c3, d3, d2);
                        }
                        videoBlockUploadResult = i3;
                        str2 = str6;
                        f(i7, d2, 80);
                        if (videoBlockUploadResult == null) {
                        }
                        c.a.t0.w3.q0.b.d(str4, str2, i6);
                        f(i7, d2, 100);
                        str6 = str2;
                    }
                    i5 = i6;
                    length = j2;
                    str3 = null;
                }
                videoFinishResult.setErrorMessage(str3);
                videoFinishResult.setErrorNo(0);
                if (videoBlockUploadResult != null) {
                    videoFinishResult.setVideoUrl(videoBlockUploadResult.video_url);
                }
                c.a.t0.w3.q0.b.b(str4);
                videoFinishResult.setVideoMd5(str4);
                randomAccessFile.close();
                g gVar2 = this.f24972g;
                if (gVar2 != null) {
                    gVar2.j();
                }
                return videoFinishResult;
            }
            return null;
        }
        return (VideoFinishResult) invokeLI.objValue;
    }

    public final byte[] c(RandomAccessFile randomAccessFile, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{randomAccessFile, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (randomAccessFile != null && i2 >= 0) {
                if (i2 == i3 - 1) {
                    i4 = (int) (j2 - (i2 * this.f24970e));
                } else {
                    i4 = this.f24970e;
                }
                byte[] bArr = new byte[i4];
                boolean z = false;
                try {
                    z = randomAccessFile.read(bArr, 0, i4) != -1;
                } catch (IOException unused) {
                }
                if (z) {
                    return bArr;
                }
            }
            return null;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @Override // c.a.t0.w3.q0.d.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24967b = true;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public final int d(long j2, int i2) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            long j4 = i2;
            if (j2 % j4 == 0) {
                j3 = j2 / j4;
            } else {
                j3 = (j2 / j4) + 1;
            }
            return (int) j3;
        }
        return invokeCommon.intValue;
    }

    public final NetWork e(String str, long j2, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), str2})) == null) {
            NetWork netWork = new NetWork();
            netWork.addPostData("forum_id", this.f24968c);
            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            netWork.addPostData("total_length", String.valueOf(j2));
            netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, str);
            netWork.addPostData("block_num", String.valueOf(i2));
            netWork.addPostData("upload_id", str2);
            return netWork;
        }
        return (NetWork) invokeCommon.objValue;
    }

    public final void f(int i2, int i3, int i4) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (eVar = this.f24971f) == null) {
            return;
        }
        eVar.onProgressUpdate((i2 + (i4 / 100.0f)) / i3);
    }

    public final VideoBlockUploadResult g(NetWork netWork) {
        InterceptResult invokeL;
        int netErrorCode;
        String errMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, netWork)) == null) {
            VideoBlockUploadResult videoBlockUploadResult = new VideoBlockUploadResult();
            if (this.f24967b) {
                netErrorCode = netWork.getServerErrorCode();
                errMsg = netWork.getErrorString();
            } else {
                String postMultiNetData = netWork.postMultiNetData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    OrmObject objectWithJsonStr = OrmObject.objectWithJsonStr(postMultiNetData, VideoBlockUploadResult.class);
                    if (objectWithJsonStr instanceof VideoBlockUploadResult) {
                        VideoBlockUploadResult videoBlockUploadResult2 = (VideoBlockUploadResult) objectWithJsonStr;
                        if (videoBlockUploadResult2.isSuccess()) {
                            netErrorCode = videoBlockUploadResult2.getErrorCode();
                            String errorMessage = videoBlockUploadResult2.getErrorMessage();
                            videoBlockUploadResult.upload_id = videoBlockUploadResult2.upload_id;
                            videoBlockUploadResult.video_url = videoBlockUploadResult2.video_url;
                            errMsg = errorMessage;
                        }
                    }
                    errMsg = null;
                    netErrorCode = 0;
                } else if (netWork.getNetErrorCode() == 200) {
                    netErrorCode = netWork.getServerErrorCode();
                    errMsg = netWork.getErrorString();
                } else {
                    netErrorCode = netWork.getNetErrorCode();
                    errMsg = TbErrInfo.getErrMsg(-7);
                }
            }
            videoBlockUploadResult.setErrorNo(netErrorCode);
            videoBlockUploadResult.setErrorMessage(errMsg);
            return videoBlockUploadResult;
        }
        return (VideoBlockUploadResult) invokeL.objValue;
    }

    public final VideoBlockUploadResult h(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3, i4)) == null) {
            int i5 = this.f24969d;
            int i6 = i2 / i5;
            k(this.a, i5, bArr.length, i6 == i3 ? i4 - ((i6 - 1) * i5) : i5, i6, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_BLOCK);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeLIII.objValue;
    }

    public final VideoBlockUploadResult i(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i5 = this.f24969d;
            int i6 = i2 % i5;
            int length = bArr.length;
            int i7 = (i2 / i5) + 1;
            if (i7 == i3) {
                i5 = i4 - ((i7 - 1) * i5);
            }
            k(this.a, i6, length, i5, i7, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_CHUNK);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeCommon.objValue;
    }

    public final VideoBlockUploadResult j(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048586, this, bArr, i2, i3, i4)) == null) {
            int length = bArr.length;
            int i7 = this.f24969d;
            if (i2 % i7 == 0) {
                i5 = i2 / i7;
            } else {
                i5 = (i2 / i7) + 1;
            }
            int i8 = i5;
            if (i8 == i3) {
                i6 = i4 - ((i8 - 1) * this.f24969d);
            } else {
                i6 = this.f24969d;
            }
            k(this.a, i6, length, i6, i8, bArr);
            NetWork netWork = this.a;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.VIDEO_UPLOAD_FILE);
            return g(this.a);
        }
        return (VideoBlockUploadResult) invokeLIII.objValue;
    }

    public final void k(NetWork netWork, int i2, long j2, int i3, int i4, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{netWork, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), bArr}) == null) || netWork == null) {
            return;
        }
        netWork.addPostData("chunk_no", String.valueOf(i2));
        netWork.addPostData("chunk_length", String.valueOf(j2));
        netWork.addPostData("chunk_num", String.valueOf(i3));
        netWork.addPostData("block_no", String.valueOf(i4));
        netWork.addPostData("video_chunk", bArr);
    }
}
