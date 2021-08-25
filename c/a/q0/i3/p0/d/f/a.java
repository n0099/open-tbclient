package c.a.q0.i3.p0.d.f;

import c.a.q0.i3.p0.d.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f20458a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20459b;

    /* renamed from: c  reason: collision with root package name */
    public final int f20460c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20461d;

    /* renamed from: e  reason: collision with root package name */
    public final String f20462e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20463f;

    public a(String str, int i2, int i3, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20459b = str;
        this.f20460c = i3;
        this.f20461d = j2;
        this.f20462e = str2;
        this.f20463f = i2;
    }

    public abstract void a();

    public byte[] b(RandomAccessFile randomAccessFile, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, randomAccessFile, i2)) == null) {
            if (randomAccessFile != null && i2 >= 0) {
                if (i2 == this.f20460c) {
                    i3 = (int) (this.f20461d - ((i2 - 1) * this.f20463f));
                } else {
                    i3 = this.f20463f;
                }
                byte[] bArr = new byte[i3];
                try {
                    synchronized (randomAccessFile) {
                        randomAccessFile.seek((i2 - 1) * this.f20463f);
                        r3 = randomAccessFile.read(bArr, 0, i3) != -1;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (r3) {
                    return bArr;
                }
            }
            return null;
        }
        return (byte[]) invokeLI.objValue;
    }

    public abstract boolean c();

    public void d(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (eVar = this.f20458a) == null) {
            return;
        }
        eVar.onProgressUpdate(i2 / 100.0f);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    return optJSONObject.optString("video_url");
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f20458a = eVar;
        }
    }

    public abstract d g(ArrayList<Integer> arrayList, String str, int i2);

    public d h(RandomAccessFile randomAccessFile, int i2, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{randomAccessFile, Integer.valueOf(i2), Long.valueOf(j2), str})) == null) {
            byte[] b2 = b(randomAccessFile, i2);
            if (b2 == null) {
                d dVar = new d();
                dVar.f20476b = -1;
                dVar.f20477c = "上传文件不存在";
                return dVar;
            } else if (c()) {
                return null;
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
                netWork.addPostData("chunk_no", String.valueOf(i2));
                netWork.addPostData("chunk_sum", String.valueOf(this.f20460c));
                netWork.addPostData("chunk_size", String.valueOf(b2.length));
                netWork.addPostData("video_size", String.valueOf(this.f20461d));
                netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.f20462e);
                netWork.addPostData("video_len", String.valueOf(j2));
                netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                netWork.addPostData("video_chunk", b2);
                netWork.addPostData("upload_id", str);
                if (c()) {
                    return null;
                }
                String postMultiNetData = netWork.postMultiNetData();
                if (c()) {
                    return null;
                }
                d dVar2 = new d();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    dVar2.f20475a = e(postMultiNetData);
                } else {
                    if (netWork.getNetContext().getResponse().isNetSuccess()) {
                        dVar2.f20476b = netWork.getNetContext().getResponse().mServerErrorCode;
                    } else {
                        dVar2.f20476b = netWork.getNetContext().getResponse().mNetErrorCode;
                    }
                    dVar2.f20477c = netWork.getNetContext().getResponse().mErrorString;
                }
                return dVar2;
            }
        }
        return (d) invokeCommon.objValue;
    }
}
