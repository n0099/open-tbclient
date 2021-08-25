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
    public long f34378a;

    /* renamed from: b  reason: collision with root package name */
    public int f34379b;

    /* renamed from: c  reason: collision with root package name */
    public long f34380c;

    /* renamed from: d  reason: collision with root package name */
    public long f34381d;

    /* renamed from: e  reason: collision with root package name */
    public String f34382e;

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
        this.f34378a = -1L;
        this.f34379b = -1;
        this.f34380c = -1L;
        this.f34381d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f34378a = downloadInfo.getId();
        this.f34379b = downloadInfo.getStatus();
        this.f34381d = downloadInfo.getCurBytes();
        this.f34380c = downloadInfo.getTotalBytes();
        this.f34382e = downloadInfo.getTargetFilePath();
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
                return ((this.f34378a > eVar.f34378a ? 1 : (this.f34378a == eVar.f34378a ? 0 : -1)) == 0) && (this.f34379b == eVar.f34379b) && ((this.f34380c > eVar.f34380c ? 1 : (this.f34380c == eVar.f34380c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f34382e) && TextUtils.isEmpty(eVar.f34382e)) || (!TextUtils.isEmpty(this.f34382e) && !TextUtils.isEmpty(eVar.f34382e) && this.f34382e.equals(eVar.f34382e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f34378a), Integer.valueOf(this.f34379b), Long.valueOf(this.f34380c), this.f34382e}) : invokeV.intValue;
    }
}
