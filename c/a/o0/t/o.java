package c.a.o0.t;

import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TiePlusStat.StatType a;

    /* renamed from: b  reason: collision with root package name */
    public TiePlusStat.RichTextType f11472b;

    /* renamed from: c  reason: collision with root package name */
    public String f11473c;

    /* renamed from: d  reason: collision with root package name */
    public String f11474d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11475e;

    /* renamed from: f  reason: collision with root package name */
    public String f11476f;

    public o(TiePlusStat.StatType statType, TiePlusStat.RichTextType richTextType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {statType, richTextType, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = statType;
        this.f11472b = richTextType;
        this.f11473c = str;
        this.f11474d = str2;
        this.f11476f = str3;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "TiePlusStaticData{statType=" + this.a + ", richTextType=" + this.f11472b + ", tid='" + this.f11473c + "', orderId='" + this.f11474d + "', hasDownload=" + this.f11475e + ", packageName='" + this.f11476f + "'}";
        }
        return (String) invokeV.objValue;
    }
}
