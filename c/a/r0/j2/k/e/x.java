package c.a.r0.j2.k.e;

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
public class x implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20345e;

    /* renamed from: f  reason: collision with root package name */
    public int f20346f;

    /* renamed from: g  reason: collision with root package name */
    public String f20347g;

    /* renamed from: h  reason: collision with root package name */
    public String f20348h;

    /* renamed from: i  reason: collision with root package name */
    public int f20349i;

    /* renamed from: j  reason: collision with root package name */
    public long f20350j;
    public MetaData k;
    public HashMap<String, MetaData> l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public c.a.q0.s.q.x0 s;
    public YyExtData t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1537268301, "Lc/a/r0/j2/k/e/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1537268301, "Lc/a/r0/j2/k/e/x;");
                return;
            }
        }
        u = BdUniqueId.gen();
    }

    public x() {
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
        this.q = false;
        this.r = false;
    }

    public void b(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, alaLiveInfo) == null) && alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.live_status.intValue() == 1 && alaLiveInfo.pb_display_type.intValue() == 1) {
            this.f20345e = alaLiveInfo.user_info.user_name;
            this.f20347g = alaLiveInfo.description;
            String str = alaLiveInfo.cover_wide;
            this.f20348h = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f20348h = alaLiveInfo.cover;
            }
            this.f20346f = alaLiveInfo.audience_count.intValue();
            this.f20349i = alaLiveInfo.live_status.intValue();
            this.f20350j = alaLiveInfo.live_id.longValue();
            this.m = alaLiveInfo.live_from.intValue() == 1;
            this.n = alaLiveInfo.third_live_type;
            this.o = alaLiveInfo.third_room_id;
            String str2 = alaLiveInfo.router_type;
            YyExtData yyExtData = new YyExtData();
            this.t = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            Long l = alaLiveInfo.user_info.user_id;
            if (l != null && l.longValue() > 0 && (hashMap = this.l) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.k = metaData;
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
                c.a.q0.s.q.x0 x0Var = new c.a.q0.s.q.x0();
                this.s = x0Var;
                x0Var.k(sparseArray);
                this.s.f14351g = sparseArray2;
            } else {
                this.s = null;
            }
            this.p = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20345e = null;
            this.f20346f = 0;
            this.f20347g = null;
            this.f20348h = null;
            this.f20349i = 0;
            this.f20350j = 0L;
            this.k = null;
            this.l = null;
            this.m = false;
            this.n = null;
            this.o = null;
            this.r = false;
            this.p = false;
        }
    }

    public void d(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.l = hashMap;
        }
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? u : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }
}
