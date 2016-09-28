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
    public static a Vs = null;
    private static HashMap<String, Integer> Vt = new HashMap<>();
    private static ArrayList<String> Vu;
    private static HashMap<String, o<byte[]>> Vv;
    private static HashMap<String, o<String>> Vw;

    static {
        Vt.put("tb.pb_mark", 50);
        Vt.put("tb.pb_history", 300);
        Vt.put("tb.pb_normal", 1);
        Vt.put("tb.pb_editor", 50);
        Vt.put("tb.live_hotlist", 20);
        Vt.put("tb.live_hotlist", 20);
        Vt.put("tb.my_pages", 5);
        Vt.put("tb.my_forums", 3);
        Vt.put("tb.my_bookmarks", 3);
        Vt.put("tb.my_posts", 3);
        Vt.put("tb.im_frsgroup", 50);
        Vt.put("tb.im_hotgroup", 30);
        Vt.put("tb.im_groupinfo", 50);
        Vt.put("tb.im_groupactivity", 50);
        Vt.put("tb.im_entergroup", 10);
        Vt.put("tb.im_enterforum_groupinfo", 10);
        Vt.put("tb.im_group_setting", 3);
        Vt.put("tb.im_personal_chat_setting", 3);
        Vt.put("tb.im_official_chat_setting", 3);
        Vt.put("tb.im_group_search_history", 50);
        Vt.put("tb.im_official_history", 50);
        Vt.put("tb.im_recommend_detail", 10);
        Vt.put("tb.square", 1);
        Vt.put("tb.first_dir", 1);
        Vt.put("tb.forum_rank", 20);
        Vt.put("tb.pic_gif", 50);
        Vt.put("tb.official_bar_menu", 1000);
        Vt.put("tb.friend_feed", 20);
        Vt.put("net_err_record", 30);
        Vt.put("tb_face_package", 30);
        Vt.put("tb.recommend_friend", 10);
        Vt.put("tb.searchperson_history", 5);
        Vt.put("tb.game_center_home", 20);
        Vt.put("tb.game_center_list", 20);
        Vt.put("tb.ecomm", 5);
        Vt.put("tb.person_wallet_new", 10);
        Vu = new ArrayList<>();
        Vu.add("tb.square");
        Vu.add("tb.first_dir");
        Vu.add("tb.forum_rank");
        Vu.add("tb.im_group_setting");
        Vu.add("tb.im_personal_chat_setting");
        Vu.add("tb.im_official_chat_setting");
        Vu.add("net_err_record");
        Vu.add("tb_user_profile");
        Vu.add("tb_forum_recommend");
        Vu.add("tb.ad_killer_tags");
        Vu.add("tb.manga.settings");
        Vw = new HashMap<>();
        Vv = new HashMap<>();
    }

    public static a ti() {
        if (Vs == null) {
            Vs = new a();
        }
        return Vs;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cz(String str) {
        return M(str, null);
    }

    public o<String> cA(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Vv.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService dB = BdCacheService.dB();
            Integer num = Vt.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Vu.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = dB.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Vv.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Vw.get(str3);
        BdCacheService dB = BdCacheService.dB();
        Integer num = Vt.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Vu.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return dB.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            o<String> oVar = Vw.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.dB().a(oVar);
                    Vw.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cB(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Vv.clear();
        Vw.clear();
    }
}
