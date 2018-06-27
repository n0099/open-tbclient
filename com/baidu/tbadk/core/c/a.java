package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a akO = null;
    private static HashMap<String, Integer> akP = new HashMap<>();
    private static ArrayList<String> akQ;
    private static HashMap<String, l<byte[]>> akR;
    private static HashMap<String, l<String>> akS;

    static {
        akP.put("tb.pb_mark", 50);
        akP.put("tb.pb_history", 300);
        akP.put("tb.pb_normal", 1);
        akP.put("tb.pb_editor", 50);
        akP.put("tb.live_hotlist", 20);
        akP.put("tb.live_hotlist", 20);
        akP.put("tb.my_pages", 5);
        akP.put("tb.my_forums", 3);
        akP.put("tb.my_bookmarks", 3);
        akP.put("tb.my_posts", 3);
        akP.put("tb.im_frsgroup", 50);
        akP.put("tb.im_hotgroup", 30);
        akP.put("tb.im_groupinfo", 50);
        akP.put("tb.im_groupactivity", 50);
        akP.put("tb.im_entergroup", 10);
        akP.put("tb.im_enterforum_groupinfo", 10);
        akP.put("tb.im_group_setting", 3);
        akP.put("tb.im_personal_chat_setting", 3);
        akP.put("tb.im_official_chat_setting", 3);
        akP.put("tb.im_group_search_history", 50);
        akP.put("tb.im_official_history", 50);
        akP.put("tb.im_recommend_detail", 10);
        akP.put("tb.square", 1);
        akP.put("tb.first_dir", 1);
        akP.put("tb.forum_rank", 20);
        akP.put("tb.pic_gif", 50);
        akP.put("tb.official_bar_menu", 1000);
        akP.put("tb.friend_feed", 20);
        akP.put("net_err_record", 30);
        akP.put("tb_face_package", 30);
        akP.put("tb.recommend_friend", 10);
        akP.put("tb.searchperson_history", 5);
        akP.put("tb.game_center_home", 20);
        akP.put("tb.game_center_list", 20);
        akP.put("tb.person_wallet_new", 10);
        akP.put("tb.frs_hottopic", 100);
        akQ = new ArrayList<>();
        akQ.add("tb.ala.gift_list");
        akQ.add("tb.square");
        akQ.add("tb.first_dir");
        akQ.add("tb.forum_rank");
        akQ.add("tb.im_group_setting");
        akQ.add("tb.im_personal_chat_setting");
        akQ.add("tb.im_official_chat_setting");
        akQ.add("net_err_record");
        akQ.add("tb_user_profile");
        akQ.add("tb_forum_recommend");
        akQ.add("tb.ad_killer_tags");
        akQ.add("tb.manga.settings");
        akQ.add("tb.share_add_experienced");
        akQ.add("tb.write_privacy_state_space");
        akS = new HashMap<>();
        akR = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a xj() {
        if (akO == null) {
            akO = new a();
        }
        return akO;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> dA(String str) {
        return Q(str, null);
    }

    public l<String> dB(String str) {
        return R(str, null);
    }

    public l<byte[]> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = akR.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService he = BdCacheService.he();
            Integer num = akP.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (akQ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = he.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            akR.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = akS.get(str3);
        BdCacheService he = BdCacheService.he();
        Integer num = akP.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (akQ.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return he.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void S(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = akS.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.he().a(lVar);
                    akS.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void dC(String str) {
        S(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        akR.clear();
        akS.clear();
    }
}
