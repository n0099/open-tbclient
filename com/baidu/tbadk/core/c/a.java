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
    public static a aaZ = null;
    private static HashMap<String, Integer> aba = new HashMap<>();
    private static ArrayList<String> abb;
    private static HashMap<String, l<byte[]>> abd;
    private static HashMap<String, l<String>> abe;

    static {
        aba.put("tb.pb_mark", 50);
        aba.put("tb.pb_history", 300);
        aba.put("tb.pb_normal", 1);
        aba.put("tb.pb_editor", 50);
        aba.put("tb.live_hotlist", 20);
        aba.put("tb.live_hotlist", 20);
        aba.put("tb.my_pages", 5);
        aba.put("tb.my_forums", 3);
        aba.put("tb.my_bookmarks", 3);
        aba.put("tb.my_posts", 3);
        aba.put("tb.im_frsgroup", 50);
        aba.put("tb.im_hotgroup", 30);
        aba.put("tb.im_groupinfo", 50);
        aba.put("tb.im_groupactivity", 50);
        aba.put("tb.im_entergroup", 10);
        aba.put("tb.im_enterforum_groupinfo", 10);
        aba.put("tb.im_group_setting", 3);
        aba.put("tb.im_personal_chat_setting", 3);
        aba.put("tb.im_official_chat_setting", 3);
        aba.put("tb.im_group_search_history", 50);
        aba.put("tb.im_official_history", 50);
        aba.put("tb.im_recommend_detail", 10);
        aba.put("tb.square", 1);
        aba.put("tb.first_dir", 1);
        aba.put("tb.forum_rank", 20);
        aba.put("tb.pic_gif", 50);
        aba.put("tb.official_bar_menu", 1000);
        aba.put("tb.friend_feed", 20);
        aba.put("net_err_record", 30);
        aba.put("tb_face_package", 30);
        aba.put("tb.recommend_friend", 10);
        aba.put("tb.searchperson_history", 5);
        aba.put("tb.game_center_home", 20);
        aba.put("tb.game_center_list", 20);
        aba.put("tb.person_wallet_new", 10);
        aba.put("bottom_write_story", 1);
        abb = new ArrayList<>();
        abb.add("tb.ala.gift_list");
        abb.add("tb.square");
        abb.add("tb.first_dir");
        abb.add("tb.forum_rank");
        abb.add("tb.im_group_setting");
        abb.add("tb.im_personal_chat_setting");
        abb.add("tb.im_official_chat_setting");
        abb.add("net_err_record");
        abb.add("tb_user_profile");
        abb.add("tb_forum_recommend");
        abb.add("tb.ad_killer_tags");
        abb.add("tb.manga.settings");
        abb.add("tb.share_add_experienced");
        abb.add("tb.write_privacy_state_space");
        abe = new HashMap<>();
        abd = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a td() {
        if (aaZ == null) {
            aaZ = new a();
        }
        return aaZ;
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
        l<byte[]> lVar = abd.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = aba.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (abb.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            abd.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = abe.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = aba.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (abb.contains(str)) {
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
            l<String> lVar = abe.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    abe.remove(str);
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
        abd.clear();
        abe.clear();
    }
}
