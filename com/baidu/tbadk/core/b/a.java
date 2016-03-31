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
    public static a Wh = null;
    private static HashMap<String, Integer> Wi = new HashMap<>();
    private static ArrayList<String> Wj;
    private static HashMap<String, o<byte[]>> Wk;
    private static HashMap<String, o<String>> Wl;

    static {
        Wi.put("tb.pb_mark", 50);
        Wi.put("tb.pb_history", 300);
        Wi.put("tb.pb_normal", 1);
        Wi.put("tb.pb_editor", 50);
        Wi.put("tb.live_hotlist", 20);
        Wi.put("tb.live_hotlist", 20);
        Wi.put("tb.my_pages", 5);
        Wi.put("tb.my_forums", 3);
        Wi.put("tb.my_bookmarks", 3);
        Wi.put("tb.my_posts", 3);
        Wi.put("tb.im_frsgroup", 50);
        Wi.put("tb.im_hotgroup", 30);
        Wi.put("tb.im_groupinfo", 50);
        Wi.put("tb.im_groupactivity", 50);
        Wi.put("tb.im_entergroup", 10);
        Wi.put("tb.im_enterforum_groupinfo", 10);
        Wi.put("tb.im_group_setting", 3);
        Wi.put("tb.im_personal_chat_setting", 3);
        Wi.put("tb.im_official_chat_setting", 3);
        Wi.put("tb.im_group_search_history", 50);
        Wi.put("tb.im_official_history", 50);
        Wi.put("tb.im_recommend_detail", 10);
        Wi.put("tb.square", 1);
        Wi.put("tb.first_dir", 1);
        Wi.put("tb.forum_rank", 20);
        Wi.put("tb.pic_gif", 50);
        Wi.put("tb.official_bar_menu", 1000);
        Wi.put("tb.friend_feed", 20);
        Wi.put("net_err_record", 30);
        Wi.put("tb_face_package", 30);
        Wi.put("tb.recommend_friend", 10);
        Wi.put("tb.searchperson_history", 5);
        Wi.put("tb.game_center_home", 20);
        Wi.put("tb.game_center_list", 20);
        Wj = new ArrayList<>();
        Wj.add("tb.square");
        Wj.add("tb.first_dir");
        Wj.add("tb.forum_rank");
        Wj.add("tb.im_group_setting");
        Wj.add("tb.im_personal_chat_setting");
        Wj.add("tb.im_official_chat_setting");
        Wj.add("net_err_record");
        Wj.add("tb_user_profile");
        Wj.add("tb_forum_recommend");
        Wj.add("tb.ad_killer_tags");
        Wj.add("tb.manga.settings");
        Wl = new HashMap<>();
        Wk = new HashMap<>();
    }

    public static a um() {
        if (Wh == null) {
            Wh = new a();
        }
        return Wh;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cy(String str) {
        return N(str, null);
    }

    public o<String> cz(String str) {
        return O(str, null);
    }

    public o<byte[]> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Wk.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gs = BdCacheService.gs();
            Integer num = Wi.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Wj.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gs.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Wk.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Wl.get(str3);
        BdCacheService gs = BdCacheService.gs();
        Integer num = Wi.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Wj.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gs.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void P(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Wl.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gs().a(oVar);
                    Wl.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cA(String str) {
        P(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Wk.clear();
        Wl.clear();
    }
}
