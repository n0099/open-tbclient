package b.a.q0.u;

import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TiePlusStat.StatType f14920a;

    /* renamed from: b  reason: collision with root package name */
    public TiePlusStat.RichTextType f14921b;

    /* renamed from: c  reason: collision with root package name */
    public String f14922c;

    /* renamed from: d  reason: collision with root package name */
    public String f14923d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14924e;

    /* renamed from: f  reason: collision with root package name */
    public String f14925f;

    public m(TiePlusStat.StatType statType, TiePlusStat.RichTextType richTextType, String str, String str2, String str3) {
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
        this.f14920a = statType;
        this.f14921b = richTextType;
        this.f14922c = str;
        this.f14923d = str2;
        this.f14925f = str3;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "TiePlusStaticData{statType=" + this.f14920a + ", richTextType=" + this.f14921b + ", tid='" + this.f14922c + ExtendedMessageFormat.QUOTE + ", orderId='" + this.f14923d + ExtendedMessageFormat.QUOTE + ", hasDownload=" + this.f14924e + ", packageName='" + this.f14925f + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
