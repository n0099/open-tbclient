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
    public static a aaK = null;
    private static HashMap<String, Integer> aaL = new HashMap<>();
    private static ArrayList<String> aaM;
    private static HashMap<String, l<byte[]>> aaN;
    private static HashMap<String, l<String>> aaO;

    static {
        aaL.put("tb.pb_mark", 50);
        aaL.put("tb.pb_history", 300);
        aaL.put("tb.pb_normal", 1);
        aaL.put("tb.pb_editor", 50);
        aaL.put("tb.live_hotlist", 20);
        aaL.put("tb.live_hotlist", 20);
        aaL.put("tb.my_pages", 5);
        aaL.put("tb.my_forums", 3);
        aaL.put("tb.my_bookmarks", 3);
        aaL.put("tb.my_posts", 3);
        aaL.put("tb.im_frsgroup", 50);
        aaL.put("tb.im_hotgroup", 30);
        aaL.put("tb.im_groupinfo", 50);
        aaL.put("tb.im_groupactivity", 50);
        aaL.put("tb.im_entergroup", 10);
        aaL.put("tb.im_enterforum_groupinfo", 10);
        aaL.put("tb.im_group_setting", 3);
        aaL.put("tb.im_personal_chat_setting", 3);
        aaL.put("tb.im_official_chat_setting", 3);
        aaL.put("tb.im_group_search_history", 50);
        aaL.put("tb.im_official_history", 50);
        aaL.put("tb.im_recommend_detail", 10);
        aaL.put("tb.square", 1);
        aaL.put("tb.first_dir", 1);
        aaL.put("tb.forum_rank", 20);
        aaL.put("tb.pic_gif", 50);
        aaL.put("tb.official_bar_menu", 1000);
        aaL.put("tb.friend_feed", 20);
        aaL.put("net_err_record", 30);
        aaL.put("tb_face_package", 30);
        aaL.put("tb.recommend_friend", 10);
        aaL.put("tb.searchperson_history", 5);
        aaL.put("tb.game_center_home", 20);
        aaL.put("tb.game_center_list", 20);
        aaL.put("tb.person_wallet_new", 10);
        aaL.put("bottom_write_story", 1);
        aaM = new ArrayList<>();
        aaM.add("tb.ala.gift_list");
        aaM.add("tb.square");
        aaM.add("tb.first_dir");
        aaM.add("tb.forum_rank");
        aaM.add("tb.im_group_setting");
        aaM.add("tb.im_personal_chat_setting");
        aaM.add("tb.im_official_chat_setting");
        aaM.add("net_err_record");
        aaM.add("tb_user_profile");
        aaM.add("tb_forum_recommend");
        aaM.add("tb.ad_killer_tags");
        aaM.add("tb.manga.settings");
        aaM.add("tb.share_add_experienced");
        aaO = new HashMap<>();
        aaN = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a td() {
        if (aaK == null) {
            aaK = new a();
        }
        return aaK;
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
        l<byte[]> lVar = aaN.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = aaL.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aaM.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aaN.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aaO.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = aaL.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aaM.contains(str)) {
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
            l<String> lVar = aaO.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    aaO.remove(str);
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
        aaN.clear();
        aaO.clear();
    }
}
