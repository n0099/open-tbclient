package c.a.q0.i3;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Wire f20224c;

    /* renamed from: d  reason: collision with root package name */
    public static e f20225d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f20226a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.e.d.l<byte[]> f20227b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(43856113, "Lc/a/q0/i3/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(43856113, "Lc/a/q0/i3/e;");
                return;
            }
        }
        f20224c = new Wire(new Class[0]);
    }

    public e() {
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
        this.f20226a = null;
        this.f20227b = null;
        this.f20227b = BdCacheService.l().a("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f20225d == null) {
                synchronized (e.class) {
                    if (f20225d == null) {
                        f20225d = new e();
                    }
                }
            }
            return f20225d;
        }
        return (e) invokeV.objValue;
    }

    public void a(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, bArr, z) == null) || str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.e.e.d.l<byte[]> lVar = this.f20227b;
            lVar.e(currentAccount + str, bArr, h());
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        c.a.e.e.d.l<byte[]> lVar2 = this.f20227b;
        lVar2.i(currentAccount2 + str, bArr, h());
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f20227b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.e.e.d.l<byte[]> lVar = this.f20227b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f20224c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.forum == null || frsPageResIdl.data.forum.banner_list == null || frsPageResIdl.data.forum.banner_list.app == null || frsPageResIdl.data.forum.banner_list.app.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (App app : frsPageResIdl.data.forum.banner_list.app) {
                if (app != null && str2.equals(c.a.q0.x2.c.a(app))) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(frsPageResIdl.data.forum.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            DataRes.Builder builder3 = new DataRes.Builder(frsPageResIdl.data);
            ForumInfo.Builder builder4 = new ForumInfo.Builder(frsPageResIdl.data.forum);
            builder4.banner_list = builder.build(true);
            builder3.forum = builder4.build(true);
            builder2.data = builder3.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || this.f20227b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.e.e.d.l<byte[]> lVar = this.f20227b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f20224c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.ala_stage_list == null) {
                return;
            }
            DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
            if (builder.ala_stage_list != null) {
                builder.ala_stage_list.clear();
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            builder2.data = builder.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || this.f20227b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.e.e.d.l<byte[]> lVar = this.f20227b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f20224c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.thread_list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : frsPageResIdl.data.thread_list) {
                if (threadInfo != null && threadInfo.tid != null && str2 != null && str2.equals(threadInfo.tid.toString())) {
                    arrayList.add(threadInfo);
                }
            }
            DataRes.Builder builder = new DataRes.Builder(frsPageResIdl.data);
            if (builder.thread_list != null) {
                builder.thread_list.removeAll(arrayList);
            }
            FrsPageResIdl.Builder builder2 = new FrsPageResIdl.Builder(frsPageResIdl);
            builder2.data = builder.build(true);
            a(str, builder2.build(true).toByteArray(), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.f20227b != null && str != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                c.a.e.e.d.l<byte[]> lVar = this.f20227b;
                byte[] bArr = lVar.get(currentAccount + str);
                if (bArr != null && bArr.length > 0) {
                    m mVar = new m();
                    this.f20226a = mVar;
                    mVar.parserProtobuf(bArr, false);
                    ForumData forumData = this.f20226a.forum;
                    if (forumData == null || forumData.getFrsBannerData() == null) {
                        return true;
                    }
                    this.f20226a.forum.getFrsBannerData().f14241i = false;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final User f(List<User> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, list, j2)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (User user : list) {
                if (user != null && user.id.longValue() == j2) {
                    return user;
                }
            }
            return null;
        }
        return (User) invokeLJ.objValue;
    }

    public String g(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i2, i3, i4)) == null) {
            String str2 = str + i2 + i3;
            if (i4 != 0) {
                return str + i2 + i3 + FrsRequestData.CATEGORY_ID_KEY + i4;
            }
            return str2;
        }
        return (String) invokeLIII.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long l = c.a.p0.s.d0.b.j().l("key_frs_cache_time", 604800000L);
            if (l < 0) {
                return 604800000L;
            }
            return l;
        }
        return invokeV.longValue;
    }

    public m j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20226a : (m) invokeV.objValue;
    }

    public final boolean k(long j2, List<ThreadInfo> list) {
        InterceptResult invokeJL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j2, list)) == null) {
            int count = ListUtils.getCount(list);
            for (int i2 = 0; i2 < count; i2++) {
                ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list, i2);
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        l.b<byte[]> h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str == null || str.length() <= 0 || (h2 = this.f20227b.h(str)) == null) {
                return false;
            }
            return UtilHelper.isSameDay(h2.f2225c, System.currentTimeMillis());
        }
        return invokeL.booleanValue;
    }

    public void m(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, bArr) == null) || this.f20227b == null || str == null || bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f20224c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || (count = ListUtils.getCount((list = frsPageResIdl.data.thread_list))) <= 0) {
                return;
            }
            if (count >= 15) {
                a(str, bArr, true);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.e.e.d.l<byte[]> lVar = this.f20227b;
            byte[] bArr2 = lVar.get(currentAccount + str);
            if (bArr2 != null) {
                FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) f20224c.parseFrom(bArr2, FrsPageResIdl.class);
                if (frsPageResIdl2 != null && frsPageResIdl2.data != null && frsPageResIdl2.data.thread_list != null) {
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int count2 = ListUtils.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 15; i2 < count2 && count < i3; i3 = 15) {
                        ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list2, i2);
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.is_top.intValue() == 0 && !k(threadInfo.tid.longValue(), list)) {
                            arrayList.add(threadInfo);
                            User f2 = f(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (f2 != null) {
                                arrayList2.add(f2);
                            }
                            count++;
                        }
                        i2++;
                    }
                    FrsPageResIdl.Builder builder = new FrsPageResIdl.Builder(frsPageResIdl);
                    DataRes.Builder builder2 = new DataRes.Builder(frsPageResIdl.data);
                    builder2.thread_list.addAll(arrayList);
                    builder2.user_list.addAll(arrayList2);
                    builder.data = builder2.build(true);
                    a(str, builder.build(true).toByteArray(), true);
                    return;
                }
                a(str, bArr, true);
                return;
            }
            a(str, bArr, true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void n(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) || str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.e.e.d.l<byte[]> lVar = this.f20227b;
            lVar.remove(currentAccount + str);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        c.a.e.e.d.l<byte[]> lVar2 = this.f20227b;
        lVar2.d(currentAccount2 + str);
    }
}
