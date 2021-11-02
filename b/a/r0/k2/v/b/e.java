package b.a.r0.k2.v.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class e implements d, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19656e;

    /* renamed from: f  reason: collision with root package name */
    public int f19657f;

    /* renamed from: g  reason: collision with root package name */
    public int f19658g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f19659h;

    /* renamed from: i  reason: collision with root package name */
    public String f19660i;

    public e(ExcContent excContent) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f19659h = new ArrayList<>(1);
        this.f19656e = excContent.src;
        String str = excContent.bsize;
        this.f19660i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f19657f = b.a.e.e.m.b.e(split[0], 0);
                this.f19658g = b.a.e.e.m.b.e(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f19657f <= 0) {
            this.f19657f = 1;
        }
        if (this.f19658g <= 0) {
            this.f19658g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f19658g;
        preLoadImageInfo.width = this.f19657f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f19656e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f19659h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return 0;
            }
            return (i2 * this.f19658g) / this.f19657f;
        }
        return invokeI.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19656e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19659h : (ArrayList) invokeV.objValue;
    }

    @Override // b.a.r0.k2.v.b.d
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
