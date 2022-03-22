package c.a.p0.f1.n1;

import c.a.d.o.e.n;
import c.a.o0.k0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import tbclient.AdMixFloor;
import tbclient.App;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportPageHeadInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, MetaData> f14272b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f14273c;

    /* renamed from: d  reason: collision with root package name */
    public int f14274d;

    /* renamed from: e  reason: collision with root package name */
    public String f14275e;

    /* renamed from: f  reason: collision with root package name */
    public String f14276f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14277g;

    /* renamed from: h  reason: collision with root package name */
    public SportScheduleInfo f14278h;
    public int i;
    public ItemInfo j;
    public List<App> k;
    public int l;
    public List<AdMixFloor> m;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14272b = new HashMap<>();
        this.f14273c = new ArrayList<>();
        this.i = 1;
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.has_more.intValue() == 1;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f14272b.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.setUserMap(this.f14272b);
                    threadData.forceReadUserMap = true;
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.insertItemToTitleOrAbstractText();
                    this.f14273c.add(threadData);
                }
            }
        }
        this.l = dataRes.ad_show_select.intValue();
        this.m = dataRes.ad_mix_list;
        String str = dataRes.ad_sample_map_key;
        this.k = dataRes.app_list;
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.f14273c);
        this.f14274d = dataRes.new_thread_num.intValue();
        SportPageHeadInfo sportPageHeadInfo = dataRes.sport_head_info;
        if (sportPageHeadInfo != null) {
            this.f14275e = sportPageHeadInfo.head_url;
            this.f14276f = sportPageHeadInfo.jump_url;
            this.f14277g = sportPageHeadInfo.is_ad.intValue() == 1;
        }
        this.f14278h = dataRes.sport_schedule_info;
        this.i = dataRes.sort_type.intValue();
        this.j = dataRes.item_info;
    }

    @Override // c.a.o0.k0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.o0.k0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
