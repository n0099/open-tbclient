package b.a.p0.a.j0;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public long B;
    public long C;
    public boolean D;
    public int E;
    public String F;

    /* renamed from: a  reason: collision with root package name */
    public String f6227a;

    /* renamed from: b  reason: collision with root package name */
    public String f6228b;

    /* renamed from: c  reason: collision with root package name */
    public String f6229c;

    /* renamed from: d  reason: collision with root package name */
    public int f6230d;

    /* renamed from: e  reason: collision with root package name */
    public String f6231e;

    /* renamed from: f  reason: collision with root package name */
    public String f6232f;

    /* renamed from: g  reason: collision with root package name */
    public String f6233g;

    /* renamed from: h  reason: collision with root package name */
    public String f6234h;

    /* renamed from: i  reason: collision with root package name */
    public String f6235i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public long w;
    public int x;
    public int y;
    public int z;

    public a() {
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
        this.B = PMSAppInfo.DEFAULT_SWAN_APP_PKG_MAX_AGE;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanAppDbInfo{appId='" + this.f6227a + ExtendedMessageFormat.QUOTE + ", appKey='" + this.f6228b + ExtendedMessageFormat.QUOTE + ", errorCode=" + this.f6230d + ", errorDetail='" + this.f6231e + ExtendedMessageFormat.QUOTE + ", errorMsg='" + this.f6232f + ExtendedMessageFormat.QUOTE + ", resumeDate='" + this.f6233g + ExtendedMessageFormat.QUOTE + ", maxSwanVersion='" + this.j + ExtendedMessageFormat.QUOTE + ", minSwanVersion='" + this.k + ExtendedMessageFormat.QUOTE + ", name='" + this.l + ExtendedMessageFormat.QUOTE + ", version='" + this.q + ExtendedMessageFormat.QUOTE + ", type=" + this.r + ", isHaveZip=" + this.s + ", targetSwanVersion='" + this.v + ExtendedMessageFormat.QUOTE + ", mAppZipSize=" + this.w + ", mPendingApsErrcode=" + this.x + ", category=" + this.y + ", versionCode='" + this.A + ExtendedMessageFormat.QUOTE + ", maxAge=" + this.B + ", createTime=" + this.C + ", forceFetchMetaInfoFlag=" + this.D + ", payProtected=" + this.E + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
