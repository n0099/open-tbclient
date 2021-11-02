package b.a.q0.s.r;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.d.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f13514a;

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, Integer> f13515b;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f13516c;

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, l<byte[]>> f13517d;

    /* renamed from: e  reason: collision with root package name */
    public static ConcurrentHashMap<String, l<String>> f13518e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937485276, "Lb/a/q0/s/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937485276, "Lb/a/q0/s/r/a;");
                return;
            }
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        f13515b = concurrentHashMap;
        concurrentHashMap.put("tb.pb_mark", 50);
        f13515b.put("tb.pb_history", 300);
        f13515b.put("tb.pb_normal", 1);
        f13515b.put("tb.pb_editor", 50);
        f13515b.put("tb.live_hotlist", 20);
        f13515b.put("tb.live_hotlist", 20);
        f13515b.put("tb.my_pages", 5);
        f13515b.put("tb.my_forums", 3);
        f13515b.put("tb.my_bookmarks", 3);
        f13515b.put("tb.my_posts", 3);
        f13515b.put("tb.eva_posts", 50);
        f13515b.put("tb.im_frsgroup", 50);
        f13515b.put("tb.im_hotgroup", 30);
        f13515b.put("tb.im_groupinfo", 50);
        f13515b.put("tb.im_groupactivity", 50);
        f13515b.put("tb.im_entergroup", 10);
        f13515b.put("tb.im_enterforum_groupinfo", 10);
        f13515b.put("tb.im_group_setting", 3);
        f13515b.put("tb.im_personal_chat_setting", 3);
        f13515b.put("tb.im_official_chat_setting", 3);
        f13515b.put("tb.im_group_search_history", 50);
        f13515b.put("tb.im_official_history", 50);
        f13515b.put("tb.im_recommend_detail", 10);
        f13515b.put("tb.square", 1);
        f13515b.put("tb.first_dir", 1);
        f13515b.put("tb.forum_rank", 20);
        f13515b.put("tb.pic_gif", 50);
        f13515b.put("tb.official_bar_menu", 1000);
        f13515b.put("tb.friend_feed", 20);
        f13515b.put("net_err_record", 30);
        f13515b.put("tb_face_package", 30);
        f13515b.put("tb.recommend_friend", 10);
        f13515b.put("tb.searchperson_history", 5);
        f13515b.put("tb.game_center_home", 20);
        f13515b.put("tb.game_center_list", 20);
        f13515b.put("tb.person_wallet_new", 10);
        f13515b.put("tb.frs_hottopic", 100);
        ArrayList<String> arrayList = new ArrayList<>();
        f13516c = arrayList;
        arrayList.add("tb.ala.gift_list");
        f13516c.add("tb.square");
        f13516c.add("tb.first_dir");
        f13516c.add("tb.forum_rank");
        f13516c.add("tb.im_group_setting");
        f13516c.add("tb.im_personal_chat_setting");
        f13516c.add("tb.im_official_chat_setting");
        f13516c.add("net_err_record");
        f13516c.add("tb_user_profile");
        f13516c.add("tb_forum_recommend");
        f13516c.add("tb.ad_killer_tags");
        f13516c.add("tb.manga.settings");
        f13516c.add("tb.share_add_experienced");
        f13516c.add("tb.write_privacy_state_space");
        f13516c.add("tb.concern_page_all");
        f13518e = new ConcurrentHashMap<>();
        f13517d = new ConcurrentHashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(2000998);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            synchronized (a.class) {
                if (str == null) {
                    return;
                }
                if (str2 != null) {
                    str = str + str2;
                }
                l<byte[]> lVar = f13517d.get(str);
                if (lVar != null) {
                    BdCacheService.k().j(lVar);
                    f13517d.remove(str);
                }
            }
        }
    }

    public static synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (a.class) {
                c(str, null);
            }
        }
    }

    public static synchronized void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            synchronized (a.class) {
                if (str == null) {
                    return;
                }
                if (str2 != null) {
                    str = str + str2;
                }
                l<String> lVar = f13518e.get(str);
                if (lVar != null) {
                    try {
                        BdCacheService.k().j(lVar);
                        f13518e.remove(str);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                }
            }
        }
    }

    public static synchronized l<byte[]> d(String str) {
        InterceptResult invokeL;
        l<byte[]> e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            synchronized (a.class) {
                e2 = e(str, null);
            }
            return e2;
        }
        return (l) invokeL.objValue;
    }

    public static synchronized l<byte[]> e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            synchronized (a.class) {
                if (str == null) {
                    return null;
                }
                if (str2 != null) {
                    str3 = str + str2;
                } else {
                    str3 = str;
                }
                l<byte[]> lVar = f13517d.get(str3);
                if (lVar == null || !(lVar instanceof l)) {
                    BdCacheService k = BdCacheService.k();
                    Integer num = f13515b.get(str);
                    num = (num == null || num.intValue() == 0) ? 20 : 20;
                    BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                    if (f13516c.contains(str)) {
                        cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                    }
                    try {
                        lVar = k.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    f13517d.put(str3, lVar);
                    return lVar;
                }
                return lVar;
            }
        }
        return (l) invokeLL.objValue;
    }

    @Deprecated
    public static synchronized a f() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (a.class) {
                if (f13514a == null) {
                    f13514a = new a();
                }
                aVar = f13514a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static synchronized l<String> g(String str) {
        InterceptResult invokeL;
        l<String> h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (a.class) {
                h2 = h(str, null);
            }
            return h2;
        }
        return (l) invokeL.objValue;
    }

    public static synchronized l<String> h(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            synchronized (a.class) {
                if (str == null) {
                    return null;
                }
                if (str2 != null) {
                    str3 = str + str2;
                } else {
                    str3 = str;
                }
                l<String> lVar = f13518e.get(str3);
                BdCacheService k = BdCacheService.k();
                Integer num = f13515b.get(str);
                num = (num == null || num.intValue() == 0) ? 20 : 20;
                BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
                if (f13516c.contains(str)) {
                    cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
                }
                try {
                    lVar = k.c(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return lVar;
            }
        }
        return (l) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
            synchronized (a.class) {
                f13517d.clear();
                f13518e.clear();
            }
        }
    }
}
