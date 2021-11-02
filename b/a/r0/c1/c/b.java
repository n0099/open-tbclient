package b.a.r0.c1.c;

import androidx.collection.LongSparseArray;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.r0.b0.e0.h;
import b.a.r0.b0.f0.e;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f15134a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f15135b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15136c;

    /* renamed from: d  reason: collision with root package name */
    public int f15137d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f15138e;

    /* renamed from: f  reason: collision with root package name */
    public int f15139f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f15140g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.c.g.a f15141h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15142i;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15143a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15143a = bVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f15143a.f15134a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                this.f15143a.f15134a.a(this.f15143a.f(godSquareHttpResponsedMsg.getResult()), this.f15143a.f15136c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                this.f15143a.f15134a.a(this.f15143a.f(godSquareSocketResponsedMsg.getResult()), this.f15143a.f15136c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: b.a.r0.c1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0763b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15144a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0763b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15144a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f15144a.f15134a == null) {
                return;
            }
            if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                this.f15144a.i(1);
                return;
            }
            GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
            if (godSquareCacheResponsedMsg.getResult() == null || ListUtils.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                this.f15144a.i(1);
            } else {
                this.f15144a.f15134a.a(this.f15144a.f(godSquareCacheResponsedMsg.getResult()), this.f15144a.f15136c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15137d = 0;
        this.f15138e = new ArrayList();
        this.f15139f = 1;
        this.f15141h = new a(this, CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
        this.f15142i = new C0763b(this, 2016446);
        this.f15134a = cVar;
        this.f15135b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (this.f15140g == null) {
                this.f15140g = new LongSparseArray<>();
            }
            for (User user : list) {
                h hVar = new h();
                MetaData metaData = new MetaData();
                hVar.f14764e = metaData;
                metaData.parserProtobuf(user);
                this.f15140g.put(user.id.longValue(), hVar.f14764e);
            }
        }
    }

    public final List<n> f(DataRes dataRes) {
        InterceptResult invokeL;
        MetaData metaData;
        MetaData metaData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes)) == null) {
            if (dataRes == null || ListUtils.isEmpty(dataRes.user_list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            e(dataRes.user_list);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f15136c) {
                for (Long l : dataRes.recommend_uid_list) {
                    if (l != null && (metaData2 = this.f15140g.get(l.longValue())) != null) {
                        h hVar = new h();
                        hVar.f14764e = metaData2;
                        hVar.f14765f = 1;
                        arrayList2.add(hVar);
                    }
                }
                if (this.f15135b != null && !ListUtils.isEmpty(arrayList2)) {
                    e eVar = new e();
                    eVar.f14788e = this.f15135b.getResources().getString(R.string.special_recommend);
                    eVar.needTopMargin = false;
                    arrayList2.add(0, eVar);
                }
                arrayList.addAll(arrayList2);
            }
            if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
                for (Long l2 : dataRes.hot_uid_list) {
                    if (l2 != null && (metaData = this.f15140g.get(l2.longValue())) != null) {
                        h hVar2 = new h();
                        hVar2.f14764e = metaData;
                        hVar2.f14765f = 0;
                        hVar2.f14766g = this.f15139f;
                        arrayList3.add(hVar2);
                        this.f15139f++;
                    }
                }
                if (this.f15135b != null && !ListUtils.isEmpty(arrayList3) && this.f15136c) {
                    e eVar2 = new e();
                    eVar2.f14788e = this.f15135b.getResources().getString(R.string.hot_god);
                    if (ListUtils.isEmpty(arrayList2)) {
                        eVar2.needTopMargin = false;
                    } else {
                        eVar2.needTopMargin = true;
                    }
                    arrayList3.add(0, eVar2);
                }
                arrayList.addAll(arrayList3);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public boolean g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            LongSparseArray<MetaData> longSparseArray = this.f15140g;
            return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f15135b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i2 + "";
        this.f15135b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f15135b == null) {
            return;
        }
        this.f15137d = i2;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i2;
        this.f15135b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15136c = false;
            i(this.f15137d + 1);
        }
    }

    public final void k() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (baseActivity = this.f15135b) == null) {
            return;
        }
        baseActivity.registerListener(this.f15142i);
        this.f15135b.registerListener(this.f15141h);
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15139f = 1;
            this.f15136c = true;
            if (j.A()) {
                i(1);
            } else {
                h(1);
            }
        }
    }
}
