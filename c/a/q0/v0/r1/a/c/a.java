package c.a.q0.v0.r1.a.c;

import c.a.e.e.d.l;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.b1.n;
import c.a.q0.v0.r1.a.d.e;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f27102a;

    /* renamed from: b  reason: collision with root package name */
    public c f27103b;

    /* renamed from: c.a.q0.v0.r1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1269a extends h0<GameForumGuideTabResIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f27105b;

        public C1269a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27105b = aVar;
            this.f27104a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public GameForumGuideTabResIdl doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Wire wire = new Wire(new Class[0]);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                l lVar = this.f27105b.f27102a;
                byte[] bArr = (byte[]) lVar.get(currentAccount + this.f27104a);
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (GameForumGuideTabResIdl) wire.parseFrom(bArr, GameForumGuideTabResIdl.class);
                } catch (IOException e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return (GameForumGuideTabResIdl) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<GameForumGuideTabResIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27106a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27106a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gameForumGuideTabResIdl) == null) || gameForumGuideTabResIdl == null) {
                return;
            }
            List<e> a2 = c.a.q0.v0.r1.a.b.a.a(gameForumGuideTabResIdl.data.sub_tab_list);
            List<c.a.e.l.e.n> b2 = c.a.q0.v0.r1.a.b.a.b(gameForumGuideTabResIdl.data.thread_list);
            boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
            if (this.f27106a.f27103b != null) {
                this.f27106a.f27103b.a(a2, b2, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<e> list, List<c.a.e.l.e.n> list2, boolean z);
    }

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
        this.f27102a = null;
        this.f27102a = BdCacheService.l().a("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f27102a == null || str == null) {
            return;
        }
        k0.b(new C1269a(this, str), new b(this));
    }

    public void d(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, z) == null) || str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            l<byte[]> lVar = this.f27102a;
            lVar.e(currentAccount + str, bArr, 604800000L);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        l<byte[]> lVar2 = this.f27102a;
        lVar2.i(currentAccount2 + str, bArr, 604800000L);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f27103b = cVar;
        }
    }
}
