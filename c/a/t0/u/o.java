package c.a.t0.u;

import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TiePlusStat.StatType a;

    /* renamed from: b  reason: collision with root package name */
    public TiePlusStat.RichTextType f14564b;

    /* renamed from: c  reason: collision with root package name */
    public String f14565c;

    /* renamed from: d  reason: collision with root package name */
    public String f14566d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14567e;

    /* renamed from: f  reason: collision with root package name */
    public String f14568f;

    public o(TiePlusStat.StatType statType, TiePlusStat.RichTextType richTextType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {statType, richTextType, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = statType;
        this.f14564b = richTextType;
        this.f14565c = str;
        this.f14566d = str2;
        this.f14568f = str3;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "TiePlusStaticData{statType=" + this.a + ", richTextType=" + this.f14564b + ", tid='" + this.f14565c + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f14566d + ExtendedMessageFormat.QUOTE + ", hasDownload=" + this.f14567e + ", packageName='" + this.f14568f + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
