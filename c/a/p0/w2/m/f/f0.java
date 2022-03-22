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
public class f0 implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId o;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f20050b;

    /* renamed from: c  reason: collision with root package name */
    public int f20051c;

    /* renamed from: d  reason: collision with root package name */
    public String f20052d;

    /* renamed from: e  reason: collision with root package name */
    public String f20053e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f20054f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, MetaData> f20055g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20056h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public c.a.o0.r.r.v0 m;
    public YyExtData n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218720827, "Lc/a/p0/w2/m/f/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218720827, "Lc/a/p0/w2/m/f/f0;");
                return;
            }
        }
        o = BdUniqueId.gen();
    }

    public f0() {
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
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, alaLiveInfo) == null) {
            if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.pb_display_type.intValue() == 3 && alaLiveInfo.live_status.intValue() == 1) {
                this.a = alaLiveInfo.user_info.user_name;
                this.f20050b = alaLiveInfo.live_status.intValue();
                this.f20051c = alaLiveInfo.audience_count.intValue();
                this.f20052d = alaLiveInfo.description;
                String str = alaLiveInfo.cover_wide;
                this.f20053e = str;
                if (str == null || TextUtils.isEmpty(str)) {
                    this.f20053e = alaLiveInfo.cover;
                }
                alaLiveInfo.live_id.longValue();
                this.f20056h = alaLiveInfo.live_from.intValue() == 1;
                this.i = alaLiveInfo.third_live_type;
                this.j = alaLiveInfo.third_room_id;
                String str2 = alaLiveInfo.router_type;
                YyExtData yyExtData = new YyExtData();
                this.n = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                Long l = alaLiveInfo.user_info.user_id;
                if (l != null && l.longValue() > 0 && (hashMap = this.f20055g) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                    this.f20054f = metaData;
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
                    this.m = v0Var;
                    v0Var.j(sparseArray);
                    this.m.f10967g = sparseArray2;
                } else {
                    this.m = null;
                }
                this.k = true;
                return;
            }
            this.k = false;
        }
    }

    public void b(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            this.f20055g = hashMap;
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? o : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }
}
