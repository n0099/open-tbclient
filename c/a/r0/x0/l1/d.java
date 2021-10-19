package c.a.r0.x0.l1;

import c.a.e.l.e.n;
import c.a.q0.k0.b.h;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportPageHeadInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27186e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f27187f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f27188g;

    /* renamed from: h  reason: collision with root package name */
    public int f27189h;

    /* renamed from: i  reason: collision with root package name */
    public String f27190i;

    /* renamed from: j  reason: collision with root package name */
    public String f27191j;
    public boolean k;
    public SportScheduleInfo l;
    public int m;
    public ItemInfo n;
    public List<App> o;

    public d() {
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
        this.f27187f = new HashMap<>();
        this.f27188g = new ArrayList<>();
        this.m = 1;
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f27186e = dataRes.has_more.intValue() == 1;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f27187f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    d2 d2Var = new d2();
                    d2Var.D4(this.f27187f);
                    d2Var.I2 = true;
                    d2Var.Y2(threadInfo);
                    d2Var.c3();
                    d2Var.G1();
                    this.f27188g.add(d2Var);
                }
            }
        }
        this.o = dataRes.app_list;
        c.a.q0.b.f.a.d(this.f27188g);
        this.f27189h = dataRes.new_thread_num.intValue();
        SportPageHeadInfo sportPageHeadInfo = dataRes.sport_head_info;
        if (sportPageHeadInfo != null) {
            this.f27190i = sportPageHeadInfo.head_url;
            this.f27191j = sportPageHeadInfo.jump_url;
            this.k = sportPageHeadInfo.is_ad.intValue() == 1;
        }
        this.l = dataRes.sport_schedule_info;
        this.m = dataRes.sort_type.intValue();
        this.n = dataRes.item_info;
    }

    @Override // c.a.q0.k0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.q0.k0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
