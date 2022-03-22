package c.a.p0.w2.m.f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes3.dex */
public class d0 implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f20034b;

    /* renamed from: c  reason: collision with root package name */
    public String f20035c;

    /* renamed from: d  reason: collision with root package name */
    public String f20036d;

    /* renamed from: e  reason: collision with root package name */
    public int f20037e;

    /* renamed from: f  reason: collision with root package name */
    public long f20038f;

    /* renamed from: g  reason: collision with root package name */
    public MetaData f20039g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, MetaData> f20040h;
    public boolean i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.a.o0.r.r.v0 o;
    public YyExtData p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218718905, "Lc/a/p0/w2/m/f/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218718905, "Lc/a/p0/w2/m/f/d0;");
                return;
            }
        }
        q = BdUniqueId.gen();
    }

    public d0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, alaLiveInfo) == null) && alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.a = alaLiveInfo.user_info.user_name;
            this.f20035c = alaLiveInfo.description;
            String str = alaLiveInfo.cover_wide;
            this.f20036d = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f20036d = alaLiveInfo.cover;
            }
            this.f20034b = alaLiveInfo.audience_count.intValue();
            this.f20037e = alaLiveInfo.live_status.intValue();
            this.f20038f = alaLiveInfo.live_id.longValue();
            this.i = alaLiveInfo.live_from.intValue() == 1;
            this.j = alaLiveInfo.third_live_type;
            this.k = alaLiveInfo.third_room_id;
            String str2 = alaLiveInfo.router_type;
            YyExtData yyExtData = new YyExtData();
            this.p = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            Long l = alaLiveInfo.user_info.user_id;
            if (l != null && l.longValue() > 0 && (hashMap = this.f20040h) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.f20039g = metaData;
                metaData.setIsLike(metaData.hadConcerned());
            }
            List<DislikeInfo> list = alaLiveInfo.dislike_info;
            if (ListUtils.getCount(list) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                c.a.o0.r.r.v0 v0Var = new c.a.o0.r.r.v0();
                this.o = v0Var;
                v0Var.j(sparseArray);
                this.o.f10967g = sparseArray2;
            } else {
                this.o = null;
            }
            this.l = true;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.f20034b = 0;
            this.f20035c = null;
            this.f20036d = null;
            this.f20037e = 0;
            this.f20038f = 0L;
            this.f20039g = null;
            this.f20040h = null;
            this.i = false;
            this.j = null;
            this.k = null;
            this.n = false;
            this.l = false;
        }
    }

    public void e(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.f20040h = hashMap;
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.booleanValue;
    }
}
