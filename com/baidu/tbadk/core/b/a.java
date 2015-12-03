package com.baidu.tbadk.core.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a WZ = null;
    private static HashMap<String, Integer> Xa = new HashMap<>();
    private static ArrayList<String> Xb;
    private static HashMap<String, o<byte[]>> Xc;
    private static HashMap<String, o<String>> Xd;

    static {
        Xa.put("tb.pb_mark", 50);
        Xa.put("tb.pb_history", 300);
        Xa.put("tb.pb_normal", 1);
        Xa.put("tb.pb_editor", 50);
        Xa.put("tb.live_hotlist", 20);
        Xa.put("tb.live_hotlist", 20);
        Xa.put("tb.my_pages", 5);
        Xa.put("tb.my_forums", 3);
        Xa.put("tb.my_bookmarks", 3);
        Xa.put("tb.my_posts", 3);
        Xa.put("tb.im_frsgroup", 50);
        Xa.put("tb.im_hotgroup", 30);
        Xa.put("tb.im_groupinfo", 50);
        Xa.put("tb.im_groupactivity", 50);
        Xa.put("tb.im_entergroup", 10);
        Xa.put("tb.im_enterforum_groupinfo", 10);
        Xa.put("tb.im_group_setting", 3);
        Xa.put("tb.im_personal_chat_setting", 3);
        Xa.put("tb.im_official_chat_setting", 3);
        Xa.put("tb.im_group_search_history", 50);
        Xa.put("tb.im_official_history", 50);
        Xa.put("tb.im_recommend_detail", 10);
        Xa.put("tb.square", 1);
        Xa.put("tb.first_dir", 1);
        Xa.put("tb.forum_rank", 20);
        Xa.put("tb.pic_gif", 50);
        Xa.put("tb.official_bar_menu", 1000);
        Xa.put("tb.friend_feed", 20);
        Xa.put("net_err_record", 30);
        Xa.put("tb_face_package", 30);
        Xa.put("tb.recommend_friend", 10);
        Xa.put("tb.searchperson_history", 5);
        Xa.put("tb.game_center_home", 20);
        Xa.put("tb.game_center_list", 20);
        Xb = new ArrayList<>();
        Xb.add("tb.square");
        Xb.add("tb.first_dir");
        Xb.add("tb.forum_rank");
        Xb.add("tb.im_group_setting");
        Xb.add("tb.im_personal_chat_setting");
        Xb.add("tb.im_official_chat_setting");
        Xb.add("net_err_record");
        Xb.add("tb_user_profile");
        Xb.add("tb_forum_recommend");
        Xd = new HashMap<>();
        Xc = new HashMap<>();
    }

    public static a ts() {
        if (WZ == null) {
            WZ = new a();
        }
        return WZ;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cy(String str) {
        return Q(str, null);
    }

    public o<String> cz(String str) {
        return R(str, null);
    }

    public o<byte[]> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Xc.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gk = BdCacheService.gk();
            Integer num = Xa.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Xb.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gk.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Xc.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Xd.get(str3);
        BdCacheService gk = BdCacheService.gk();
        Integer num = Xa.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Xb.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gk.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void S(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Xd.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gk().a(oVar);
                    Xd.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cA(String str) {
        S(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Xc.clear();
        Xd.clear();
    }
}
