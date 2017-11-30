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
    public static a abg = null;
    private static HashMap<String, Integer> abh = new HashMap<>();
    private static ArrayList<String> abi;
    private static HashMap<String, l<byte[]>> abj;
    private static HashMap<String, l<String>> abk;

    static {
        abh.put("tb.pb_mark", 50);
        abh.put("tb.pb_history", 300);
        abh.put("tb.pb_normal", 1);
        abh.put("tb.pb_editor", 50);
        abh.put("tb.live_hotlist", 20);
        abh.put("tb.live_hotlist", 20);
        abh.put("tb.my_pages", 5);
        abh.put("tb.my_forums", 3);
        abh.put("tb.my_bookmarks", 3);
        abh.put("tb.my_posts", 3);
        abh.put("tb.im_frsgroup", 50);
        abh.put("tb.im_hotgroup", 30);
        abh.put("tb.im_groupinfo", 50);
        abh.put("tb.im_groupactivity", 50);
        abh.put("tb.im_entergroup", 10);
        abh.put("tb.im_enterforum_groupinfo", 10);
        abh.put("tb.im_group_setting", 3);
        abh.put("tb.im_personal_chat_setting", 3);
        abh.put("tb.im_official_chat_setting", 3);
        abh.put("tb.im_group_search_history", 50);
        abh.put("tb.im_official_history", 50);
        abh.put("tb.im_recommend_detail", 10);
        abh.put("tb.square", 1);
        abh.put("tb.first_dir", 1);
        abh.put("tb.forum_rank", 20);
        abh.put("tb.pic_gif", 50);
        abh.put("tb.official_bar_menu", 1000);
        abh.put("tb.friend_feed", 20);
        abh.put("net_err_record", 30);
        abh.put("tb_face_package", 30);
        abh.put("tb.recommend_friend", 10);
        abh.put("tb.searchperson_history", 5);
        abh.put("tb.game_center_home", 20);
        abh.put("tb.game_center_list", 20);
        abh.put("tb.person_wallet_new", 10);
        abh.put("bottom_write_story", 1);
        abi = new ArrayList<>();
        abi.add("tb.ala.gift_list");
        abi.add("tb.square");
        abi.add("tb.first_dir");
        abi.add("tb.forum_rank");
        abi.add("tb.im_group_setting");
        abi.add("tb.im_personal_chat_setting");
        abi.add("tb.im_official_chat_setting");
        abi.add("net_err_record");
        abi.add("tb_user_profile");
        abi.add("tb_forum_recommend");
        abi.add("tb.ad_killer_tags");
        abi.add("tb.manga.settings");
        abi.add("tb.share_add_experienced");
        abk = new HashMap<>();
        abj = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a tg() {
        if (abg == null) {
            abg = new a();
        }
        return abg;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cO(String str) {
        return M(str, null);
    }

    public l<String> cP(String str) {
        return N(str, null);
    }

    public l<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = abj.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = abh.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (abi.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            abj.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = abk.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = abh.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (abi.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eE.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = abk.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    abk.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cQ(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        abj.clear();
        abk.clear();
    }
}
