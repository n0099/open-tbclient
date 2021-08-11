package c.p.a.a.a.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f34272a;

    /* renamed from: b  reason: collision with root package name */
    public int f34273b;

    /* renamed from: c  reason: collision with root package name */
    public long f34274c;

    /* renamed from: d  reason: collision with root package name */
    public long f34275d;

    /* renamed from: e  reason: collision with root package name */
    public String f34276e;

    public e() {
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
        this.f34272a = -1L;
        this.f34273b = -1;
        this.f34274c = -1L;
        this.f34275d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f34272a = downloadInfo.getId();
        this.f34273b = downloadInfo.getStatus();
        this.f34275d = downloadInfo.getCurBytes();
        this.f34274c = downloadInfo.getTotalBytes();
        this.f34276e = downloadInfo.getTargetFilePath();
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            failedException.getErrorCode();
        }
        downloadInfo.isOnlyWifi();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if ((obj instanceof e) && obj != null) {
                e eVar = (e) obj;
                return ((this.f34272a > eVar.f34272a ? 1 : (this.f34272a == eVar.f34272a ? 0 : -1)) == 0) && (this.f34273b == eVar.f34273b) && ((this.f34274c > eVar.f34274c ? 1 : (this.f34274c == eVar.f34274c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f34276e) && TextUtils.isEmpty(eVar.f34276e)) || (!TextUtils.isEmpty(this.f34276e) && !TextUtils.isEmpty(eVar.f34276e) && this.f34276e.equals(eVar.f34276e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f34272a), Integer.valueOf(this.f34273b), Long.valueOf(this.f34274c), this.f34276e}) : invokeV.intValue;
    }
}
