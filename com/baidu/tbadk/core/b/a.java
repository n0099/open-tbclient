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
    public static a Ss = null;
    private static HashMap<String, Integer> St = new HashMap<>();
    private static ArrayList<String> Su;
    private static HashMap<String, o<byte[]>> Sv;
    private static HashMap<String, o<String>> Sw;

    static {
        St.put("tb.pb_mark", 50);
        St.put("tb.pb_history", 300);
        St.put("tb.pb_normal", 1);
        St.put("tb.pb_editor", 50);
        St.put("tb.live_hotlist", 20);
        St.put("tb.live_hotlist", 20);
        St.put("tb.my_pages", 5);
        St.put("tb.my_forums", 3);
        St.put("tb.my_bookmarks", 3);
        St.put("tb.my_posts", 3);
        St.put("tb.im_frsgroup", 50);
        St.put("tb.im_hotgroup", 30);
        St.put("tb.im_groupinfo", 50);
        St.put("tb.im_groupactivity", 50);
        St.put("tb.im_entergroup", 10);
        St.put("tb.im_enterforum_groupinfo", 10);
        St.put("tb.im_group_setting", 3);
        St.put("tb.im_personal_chat_setting", 3);
        St.put("tb.im_official_chat_setting", 3);
        St.put("tb.im_group_search_history", 50);
        St.put("tb.im_official_history", 50);
        St.put("tb.im_recommend_detail", 10);
        St.put("tb.square", 1);
        St.put("tb.first_dir", 1);
        St.put("tb.forum_rank", 20);
        St.put("tb.pic_gif", 50);
        St.put("tb.official_bar_menu", 1000);
        St.put("tb.friend_feed", 20);
        St.put("net_err_record", 30);
        St.put("tb_face_package", 30);
        St.put("tb.recommend_friend", 10);
        St.put("tb.searchperson_history", 5);
        St.put("tb.game_center_home", 20);
        St.put("tb.game_center_list", 20);
        St.put("tb.ecomm", 5);
        St.put("tb.person_wallet_new", 10);
        Su = new ArrayList<>();
        Su.add("tb.square");
        Su.add("tb.first_dir");
        Su.add("tb.forum_rank");
        Su.add("tb.im_group_setting");
        Su.add("tb.im_personal_chat_setting");
        Su.add("tb.im_official_chat_setting");
        Su.add("net_err_record");
        Su.add("tb_user_profile");
        Su.add("tb_forum_recommend");
        Su.add("tb.ad_killer_tags");
        Su.add("tb.manga.settings");
        Sw = new HashMap<>();
        Sv = new HashMap<>();
    }

    public static a rO() {
        if (Ss == null) {
            Ss = new a();
        }
        return Ss;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cv(String str) {
        return M(str, null);
    }

    public o<String> cw(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Sv.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService cG = BdCacheService.cG();
            Integer num = St.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Su.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = cG.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Sv.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Sw.get(str3);
        BdCacheService cG = BdCacheService.cG();
        Integer num = St.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Su.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cG.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Sw.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.cG().a(oVar);
                    Sw.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cx(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Sv.clear();
        Sw.clear();
    }
}
