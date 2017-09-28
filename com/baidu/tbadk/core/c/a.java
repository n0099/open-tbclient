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
    private static ArrayList<String> aaB;
    private static HashMap<String, l<byte[]>> aaC;
    private static HashMap<String, l<String>> aaD;
    public static a aaz = null;
    private static HashMap<String, Integer> aaA = new HashMap<>();

    static {
        aaA.put("tb.pb_mark", 50);
        aaA.put("tb.pb_history", 300);
        aaA.put("tb.pb_normal", 1);
        aaA.put("tb.pb_editor", 50);
        aaA.put("tb.live_hotlist", 20);
        aaA.put("tb.live_hotlist", 20);
        aaA.put("tb.my_pages", 5);
        aaA.put("tb.my_forums", 3);
        aaA.put("tb.my_bookmarks", 3);
        aaA.put("tb.my_posts", 3);
        aaA.put("tb.im_frsgroup", 50);
        aaA.put("tb.im_hotgroup", 30);
        aaA.put("tb.im_groupinfo", 50);
        aaA.put("tb.im_groupactivity", 50);
        aaA.put("tb.im_entergroup", 10);
        aaA.put("tb.im_enterforum_groupinfo", 10);
        aaA.put("tb.im_group_setting", 3);
        aaA.put("tb.im_personal_chat_setting", 3);
        aaA.put("tb.im_official_chat_setting", 3);
        aaA.put("tb.im_group_search_history", 50);
        aaA.put("tb.im_official_history", 50);
        aaA.put("tb.im_recommend_detail", 10);
        aaA.put("tb.square", 1);
        aaA.put("tb.first_dir", 1);
        aaA.put("tb.forum_rank", 20);
        aaA.put("tb.pic_gif", 50);
        aaA.put("tb.official_bar_menu", 1000);
        aaA.put("tb.friend_feed", 20);
        aaA.put("net_err_record", 30);
        aaA.put("tb_face_package", 30);
        aaA.put("tb.recommend_friend", 10);
        aaA.put("tb.searchperson_history", 5);
        aaA.put("tb.game_center_home", 20);
        aaA.put("tb.game_center_list", 20);
        aaA.put("tb.person_wallet_new", 10);
        aaA.put("bottom_write_story", 1);
        aaB = new ArrayList<>();
        aaB.add("tb.ala.gift_list");
        aaB.add("tb.square");
        aaB.add("tb.first_dir");
        aaB.add("tb.forum_rank");
        aaB.add("tb.im_group_setting");
        aaB.add("tb.im_personal_chat_setting");
        aaB.add("tb.im_official_chat_setting");
        aaB.add("net_err_record");
        aaB.add("tb_user_profile");
        aaB.add("tb_forum_recommend");
        aaB.add("tb.ad_killer_tags");
        aaB.add("tb.manga.settings");
        aaB.add("tb.share_add_experienced");
        aaD = new HashMap<>();
        aaC = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a te() {
        if (aaz == null) {
            aaz = new a();
        }
        return aaz;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cI(String str) {
        return N(str, null);
    }

    public l<String> cJ(String str) {
        return O(str, null);
    }

    public l<byte[]> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aaC.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = aaA.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aaB.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aaC.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aaD.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = aaA.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aaB.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eE.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void P(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = aaD.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    aaD.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cK(String str) {
        P(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aaC.clear();
        aaD.clear();
    }
}
