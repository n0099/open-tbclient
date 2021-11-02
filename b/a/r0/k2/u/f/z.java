package b.a.r0.k2.u.f;

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
/* loaded from: classes5.dex */
public class z implements b.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19532e;

    /* renamed from: f  reason: collision with root package name */
    public int f19533f;

    /* renamed from: g  reason: collision with root package name */
    public int f19534g;

    /* renamed from: h  reason: collision with root package name */
    public String f19535h;

    /* renamed from: i  reason: collision with root package name */
    public String f19536i;
    public MetaData j;
    public HashMap<String, MetaData> k;
    public boolean l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;
    public b.a.q0.s.q.x0 q;
    public YyExtData r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(526669378, "Lb/a/r0/k2/u/f/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(526669378, "Lb/a/r0/k2/u/f/z;");
                return;
            }
        }
        s = BdUniqueId.gen();
    }

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = false;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, alaLiveInfo) == null) {
            if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.pb_display_type.intValue() == 3 && alaLiveInfo.live_status.intValue() == 1) {
                this.f19532e = alaLiveInfo.user_info.user_name;
                this.f19533f = alaLiveInfo.live_status.intValue();
                this.f19534g = alaLiveInfo.audience_count.intValue();
                this.f19535h = alaLiveInfo.description;
                String str = alaLiveInfo.cover_wide;
                this.f19536i = str;
                if (str == null || TextUtils.isEmpty(str)) {
                    this.f19536i = alaLiveInfo.cover;
                }
                alaLiveInfo.live_id.longValue();
                this.l = alaLiveInfo.live_from.intValue() == 1;
                this.m = alaLiveInfo.third_live_type;
                this.n = alaLiveInfo.third_room_id;
                String str2 = alaLiveInfo.router_type;
                YyExtData yyExtData = new YyExtData();
                this.r = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                Long l = alaLiveInfo.user_info.user_id;
                if (l != null && l.longValue() > 0 && (hashMap = this.k) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                    this.j = metaData;
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
                    b.a.q0.s.q.x0 x0Var = new b.a.q0.s.q.x0();
                    this.q = x0Var;
                    x0Var.j(sparseArray);
                    this.q.f13484g = sparseArray2;
                } else {
                    this.q = null;
                }
                this.o = true;
                return;
            }
            this.o = false;
        }
    }

    public void d(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            this.k = hashMap;
        }
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? s : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : invokeV.booleanValue;
    }
}
