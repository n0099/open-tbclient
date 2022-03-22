package c.a.p0.a4;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Wire f12178c;

    /* renamed from: d  reason: collision with root package name */
    public static e f12179d;
    public transient /* synthetic */ FieldHolder $fh;
    public n a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.f.d.l<byte[]> f12180b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706312599, "Lc/a/p0/a4/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1706312599, "Lc/a/p0/a4/e;");
                return;
            }
        }
        f12178c = new Wire(new Class[0]);
    }

    public e() {
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
        this.a = null;
        this.f12180b = null;
        this.f12180b = BdCacheService.k().a("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f12179d == null) {
                synchronized (e.class) {
                    if (f12179d == null) {
                        f12179d = new e();
                    }
                }
            }
            return f12179d;
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
            c.a.d.f.d.l<byte[]> lVar = this.f12180b;
            lVar.e(currentAccount + str, bArr, h());
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        c.a.d.f.d.l<byte[]> lVar2 = this.f12180b;
        lVar2.i(currentAccount2 + str, bArr, h());
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f12180b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.d.f.d.l<byte[]> lVar = this.f12180b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f12178c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || frsPageResIdl.data.forum == null || frsPageResIdl.data.forum.banner_list == null || frsPageResIdl.data.forum.banner_list.app == null || frsPageResIdl.data.forum.banner_list.app.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (App app : frsPageResIdl.data.forum.banner_list.app) {
                if (app != null && str2.equals(c.a.p0.l3.c.a(app))) {
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
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || this.f12180b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.d.f.d.l<byte[]> lVar = this.f12180b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f12178c.parseFrom(bArr, FrsPageResIdl.class);
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || this.f12180b == null || str == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        c.a.d.f.d.l<byte[]> lVar = this.f12180b;
        byte[] bArr = lVar.get(currentAccount + str);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f12178c.parseFrom(bArr, FrsPageResIdl.class);
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
            if (this.f12180b != null && str != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                c.a.d.f.d.l<byte[]> lVar = this.f12180b;
                byte[] bArr = lVar.get(currentAccount + str);
                if (bArr != null && bArr.length > 0) {
                    n nVar = new n();
                    this.a = nVar;
                    nVar.parserProtobuf(bArr, false);
                    ForumData forumData = this.a.forum;
                    if (forumData == null || forumData.getFrsBannerData() == null) {
                        return true;
                    }
                    this.a.forum.getFrsBannerData().i = false;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final User f(List<User> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, list, j)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (User user : list) {
                if (user != null && user.id.longValue() == j) {
                    return user;
                }
            }
            return null;
        }
        return (User) invokeLJ.objValue;
    }

    public String g(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i, i2, i3)) == null) {
            String str2 = str + i + i2;
            if (i3 != 0) {
                return str + i + i2 + FrsRequestData.CATEGORY_ID_KEY + i3;
            }
            return str2;
        }
        return (String) invokeLIII.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long m = c.a.o0.r.j0.b.k().m("key_frs_cache_time", 604800000L);
            if (m < 0) {
                return 604800000L;
            }
            return m;
        }
        return invokeV.longValue;
    }

    public n j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (n) invokeV.objValue;
    }

    public final boolean k(long j, List<ThreadInfo> list) {
        InterceptResult invokeJL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, list)) == null) {
            int count = ListUtils.getCount(list);
            for (int i = 0; i < count; i++) {
                ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list, i);
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == j) {
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
            if (str == null || str.length() <= 0 || (h2 = this.f12180b.h(str)) == null) {
                return false;
            }
            return UtilHelper.isSameDay(h2.f2090c, System.currentTimeMillis());
        }
        return invokeL.booleanValue;
    }

    public void m(String str, byte[] bArr) {
        List<ThreadInfo> list;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, bArr) == null) || this.f12180b == null || str == null || bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) f12178c.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl == null || frsPageResIdl.data == null || (count = ListUtils.getCount((list = frsPageResIdl.data.thread_list))) <= 0) {
                return;
            }
            if (count >= 15) {
                a(str, bArr, true);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.d.f.d.l<byte[]> lVar = this.f12180b;
            byte[] bArr2 = lVar.get(currentAccount + str);
            if (bArr2 != null) {
                FrsPageResIdl frsPageResIdl2 = (FrsPageResIdl) f12178c.parseFrom(bArr2, FrsPageResIdl.class);
                if (frsPageResIdl2 != null && frsPageResIdl2.data != null && frsPageResIdl2.data.thread_list != null) {
                    List<ThreadInfo> list2 = frsPageResIdl2.data.thread_list;
                    int count2 = ListUtils.getCount(list2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = 0;
                    for (int i2 = 15; i < count2 && count < i2; i2 = 15) {
                        ThreadInfo threadInfo = (ThreadInfo) ListUtils.getItem(list2, i);
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.is_top.intValue() == 0 && !k(threadInfo.tid.longValue(), list)) {
                            arrayList.add(threadInfo);
                            User f2 = f(frsPageResIdl2.data.user_list, threadInfo.author_id.longValue());
                            if (f2 != null) {
                                arrayList2.add(f2);
                            }
                            count++;
                        }
                        i++;
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
            c.a.d.f.d.l<byte[]> lVar = this.f12180b;
            lVar.remove(currentAccount + str);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        c.a.d.f.d.l<byte[]> lVar2 = this.f12180b;
        lVar2.d(currentAccount2 + str);
    }
}
