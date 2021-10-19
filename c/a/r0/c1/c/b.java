package c.a.r0.c1.c;

import androidx.collection.LongSparseArray;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.r0.b0.e0.h;
import c.a.r0.b0.f0.e;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f16099a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f16100b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16101c;

    /* renamed from: d  reason: collision with root package name */
    public int f16102d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f16103e;

    /* renamed from: f  reason: collision with root package name */
    public int f16104f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f16105g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.c.g.a f16106h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16107i;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16108a;

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
            this.f16108a = bVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f16108a.f16099a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                this.f16108a.f16099a.a(this.f16108a.f(godSquareHttpResponsedMsg.getResult()), this.f16108a.f16101c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                this.f16108a.f16099a.a(this.f16108a.f(godSquareSocketResponsedMsg.getResult()), this.f16108a.f16101c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: c.a.r0.c1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0768b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16109a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0768b(b bVar, int i2) {
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
            this.f16109a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16109a.f16099a == null) {
                return;
            }
            if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                this.f16109a.i(1);
                return;
            }
            GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
            if (godSquareCacheResponsedMsg.getResult() == null || ListUtils.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                this.f16109a.i(1);
            } else {
                this.f16109a.f16099a.a(this.f16109a.f(godSquareCacheResponsedMsg.getResult()), this.f16109a.f16101c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f16102d = 0;
        this.f16103e = new ArrayList();
        this.f16104f = 1;
        this.f16106h = new a(this, CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
        this.f16107i = new C0768b(this, 2016446);
        this.f16099a = cVar;
        this.f16100b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (this.f16105g == null) {
                this.f16105g = new LongSparseArray<>();
            }
            for (User user : list) {
                h hVar = new h();
                MetaData metaData = new MetaData();
                hVar.f15738e = metaData;
                metaData.parserProtobuf(user);
                this.f16105g.put(user.id.longValue(), hVar.f15738e);
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
            if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f16101c) {
                for (Long l : dataRes.recommend_uid_list) {
                    if (l != null && (metaData2 = this.f16105g.get(l.longValue())) != null) {
                        h hVar = new h();
                        hVar.f15738e = metaData2;
                        hVar.f15739f = 1;
                        arrayList2.add(hVar);
                    }
                }
                if (this.f16100b != null && !ListUtils.isEmpty(arrayList2)) {
                    e eVar = new e();
                    eVar.f15764e = this.f16100b.getResources().getString(R.string.special_recommend);
                    eVar.needTopMargin = false;
                    arrayList2.add(0, eVar);
                }
                arrayList.addAll(arrayList2);
            }
            if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
                for (Long l2 : dataRes.hot_uid_list) {
                    if (l2 != null && (metaData = this.f16105g.get(l2.longValue())) != null) {
                        h hVar2 = new h();
                        hVar2.f15738e = metaData;
                        hVar2.f15739f = 0;
                        hVar2.f15740g = this.f16104f;
                        arrayList3.add(hVar2);
                        this.f16104f++;
                    }
                }
                if (this.f16100b != null && !ListUtils.isEmpty(arrayList3) && this.f16101c) {
                    e eVar2 = new e();
                    eVar2.f15764e = this.f16100b.getResources().getString(R.string.hot_god);
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

    public boolean g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            LongSparseArray<MetaData> longSparseArray = this.f16105g;
            return (longSparseArray == null || longSparseArray.get(j2) == null) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f16100b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i2 + "";
        this.f16100b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f16100b == null) {
            return;
        }
        this.f16102d = i2;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i2;
        this.f16100b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16101c = false;
            i(this.f16102d + 1);
        }
    }

    public final void k() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (baseActivity = this.f16100b) == null) {
            return;
        }
        baseActivity.registerListener(this.f16107i);
        this.f16100b.registerListener(this.f16106h);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16104f = 1;
            this.f16101c = true;
            if (j.A()) {
                i(1);
            } else {
                h(1);
            }
        }
    }
}
