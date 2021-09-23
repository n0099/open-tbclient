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
    public long f34510a;

    /* renamed from: b  reason: collision with root package name */
    public int f34511b;

    /* renamed from: c  reason: collision with root package name */
    public long f34512c;

    /* renamed from: d  reason: collision with root package name */
    public long f34513d;

    /* renamed from: e  reason: collision with root package name */
    public String f34514e;

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
        this.f34510a = -1L;
        this.f34511b = -1;
        this.f34512c = -1L;
        this.f34513d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f34510a = downloadInfo.getId();
        this.f34511b = downloadInfo.getStatus();
        this.f34513d = downloadInfo.getCurBytes();
        this.f34512c = downloadInfo.getTotalBytes();
        this.f34514e = downloadInfo.getTargetFilePath();
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
                return ((this.f34510a > eVar.f34510a ? 1 : (this.f34510a == eVar.f34510a ? 0 : -1)) == 0) && (this.f34511b == eVar.f34511b) && ((this.f34512c > eVar.f34512c ? 1 : (this.f34512c == eVar.f34512c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f34514e) && TextUtils.isEmpty(eVar.f34514e)) || (!TextUtils.isEmpty(this.f34514e) && !TextUtils.isEmpty(eVar.f34514e) && this.f34514e.equals(eVar.f34514e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f34510a), Integer.valueOf(this.f34511b), Long.valueOf(this.f34512c), this.f34514e}) : invokeV.intValue;
    }
}
