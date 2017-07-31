package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a abt = null;
    private static HashMap<String, Integer> abu = new HashMap<>();
    private static ArrayList<String> abv;
    private static HashMap<String, l<byte[]>> abw;
    private static HashMap<String, l<String>> abx;

    static {
        abu.put("tb.pb_mark", 50);
        abu.put("tb.pb_history", 300);
        abu.put("tb.pb_normal", 1);
        abu.put("tb.pb_editor", 50);
        abu.put("tb.live_hotlist", 20);
        abu.put("tb.live_hotlist", 20);
        abu.put("tb.my_pages", 5);
        abu.put("tb.my_forums", 3);
        abu.put("tb.my_bookmarks", 3);
        abu.put("tb.my_posts", 3);
        abu.put("tb.im_frsgroup", 50);
        abu.put("tb.im_hotgroup", 30);
        abu.put("tb.im_groupinfo", 50);
        abu.put("tb.im_groupactivity", 50);
        abu.put("tb.im_entergroup", 10);
        abu.put("tb.im_enterforum_groupinfo", 10);
        abu.put("tb.im_group_setting", 3);
        abu.put("tb.im_personal_chat_setting", 3);
        abu.put("tb.im_official_chat_setting", 3);
        abu.put("tb.im_group_search_history", 50);
        abu.put("tb.im_official_history", 50);
        abu.put("tb.im_recommend_detail", 10);
        abu.put("tb.square", 1);
        abu.put("tb.first_dir", 1);
        abu.put("tb.forum_rank", 20);
        abu.put("tb.pic_gif", 50);
        abu.put("tb.official_bar_menu", 1000);
        abu.put("tb.friend_feed", 20);
        abu.put("net_err_record", 30);
        abu.put("tb_face_package", 30);
        abu.put("tb.recommend_friend", 10);
        abu.put("tb.searchperson_history", 5);
        abu.put("tb.game_center_home", 20);
        abu.put("tb.game_center_list", 20);
        abu.put("tb.person_wallet_new", 10);
        abu.put("bottom_write_story", 1);
        abv = new ArrayList<>();
        abv.add("tb.ala.gift_list");
        abv.add("tb.square");
        abv.add("tb.first_dir");
        abv.add("tb.forum_rank");
        abv.add("tb.im_group_setting");
        abv.add("tb.im_personal_chat_setting");
        abv.add("tb.im_official_chat_setting");
        abv.add("net_err_record");
        abv.add("tb_user_profile");
        abv.add("tb_forum_recommend");
        abv.add("tb.ad_killer_tags");
        abv.add("tb.manga.settings");
        abv.add("tb.share_add_experienced");
        abx = new HashMap<>();
        abw = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a tn() {
        if (abt == null) {
            abt = new a();
        }
        return abt;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cP(String str) {
        return L(str, null);
    }

    public l<String> cQ(String str) {
        return M(str, null);
    }

    public l<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = abw.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eQ = BdCacheService.eQ();
            Integer num = abu.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (abv.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eQ.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            abw.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = abx.get(str3);
        BdCacheService eQ = BdCacheService.eQ();
        Integer num = abu.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (abv.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eQ.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void N(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = abx.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eQ().a(lVar);
                    abx.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cR(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        abw.clear();
        abx.clear();
    }
}
