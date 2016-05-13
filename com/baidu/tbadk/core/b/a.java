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
    public static a Rr = null;
    private static HashMap<String, Integer> Rs = new HashMap<>();
    private static ArrayList<String> Rt;
    private static HashMap<String, o<byte[]>> Ru;
    private static HashMap<String, o<String>> Rv;

    static {
        Rs.put("tb.pb_mark", 50);
        Rs.put("tb.pb_history", 300);
        Rs.put("tb.pb_normal", 1);
        Rs.put("tb.pb_editor", 50);
        Rs.put("tb.live_hotlist", 20);
        Rs.put("tb.live_hotlist", 20);
        Rs.put("tb.my_pages", 5);
        Rs.put("tb.my_forums", 3);
        Rs.put("tb.my_bookmarks", 3);
        Rs.put("tb.my_posts", 3);
        Rs.put("tb.im_frsgroup", 50);
        Rs.put("tb.im_hotgroup", 30);
        Rs.put("tb.im_groupinfo", 50);
        Rs.put("tb.im_groupactivity", 50);
        Rs.put("tb.im_entergroup", 10);
        Rs.put("tb.im_enterforum_groupinfo", 10);
        Rs.put("tb.im_group_setting", 3);
        Rs.put("tb.im_personal_chat_setting", 3);
        Rs.put("tb.im_official_chat_setting", 3);
        Rs.put("tb.im_group_search_history", 50);
        Rs.put("tb.im_official_history", 50);
        Rs.put("tb.im_recommend_detail", 10);
        Rs.put("tb.square", 1);
        Rs.put("tb.first_dir", 1);
        Rs.put("tb.forum_rank", 20);
        Rs.put("tb.pic_gif", 50);
        Rs.put("tb.official_bar_menu", 1000);
        Rs.put("tb.friend_feed", 20);
        Rs.put("net_err_record", 30);
        Rs.put("tb_face_package", 30);
        Rs.put("tb.recommend_friend", 10);
        Rs.put("tb.searchperson_history", 5);
        Rs.put("tb.game_center_home", 20);
        Rs.put("tb.game_center_list", 20);
        Rt = new ArrayList<>();
        Rt.add("tb.square");
        Rt.add("tb.first_dir");
        Rt.add("tb.forum_rank");
        Rt.add("tb.im_group_setting");
        Rt.add("tb.im_personal_chat_setting");
        Rt.add("tb.im_official_chat_setting");
        Rt.add("net_err_record");
        Rt.add("tb_user_profile");
        Rt.add("tb_forum_recommend");
        Rt.add("tb.ad_killer_tags");
        Rt.add("tb.manga.settings");
        Rv = new HashMap<>();
        Ru = new HashMap<>();
    }

    public static a rS() {
        if (Rr == null) {
            Rr = new a();
        }
        return Rr;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cw(String str) {
        return N(str, null);
    }

    public o<String> cx(String str) {
        return O(str, null);
    }

    public o<byte[]> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Ru.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService cG = BdCacheService.cG();
            Integer num = Rs.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Rt.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = cG.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Ru.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Rv.get(str3);
        BdCacheService cG = BdCacheService.cG();
        Integer num = Rs.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Rt.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cG.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            o<String> oVar = Rv.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.cG().a(oVar);
                    Rv.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cy(String str) {
        P(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Ru.clear();
        Rv.clear();
    }
}
