package c.a.c0.s.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f2482b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2483c;

    /* renamed from: d  reason: collision with root package name */
    public int f2484d;

    public h() {
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
        this.f2484d = -1;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "VideoPrepareModel{videoUrl='" + this.a + ExtendedMessageFormat.QUOTE + ", interactUrl='" + this.f2482b + ExtendedMessageFormat.QUOTE + ", isNeedPrepare=" + this.f2483c + ", playerStageType=" + this.f2484d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
