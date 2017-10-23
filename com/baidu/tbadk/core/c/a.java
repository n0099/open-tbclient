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
    public static a aan = null;
    private static HashMap<String, Integer> aao = new HashMap<>();
    private static ArrayList<String> aap;
    private static HashMap<String, l<byte[]>> aaq;
    private static HashMap<String, l<String>> aar;

    static {
        aao.put("tb.pb_mark", 50);
        aao.put("tb.pb_history", 300);
        aao.put("tb.pb_normal", 1);
        aao.put("tb.pb_editor", 50);
        aao.put("tb.live_hotlist", 20);
        aao.put("tb.live_hotlist", 20);
        aao.put("tb.my_pages", 5);
        aao.put("tb.my_forums", 3);
        aao.put("tb.my_bookmarks", 3);
        aao.put("tb.my_posts", 3);
        aao.put("tb.im_frsgroup", 50);
        aao.put("tb.im_hotgroup", 30);
        aao.put("tb.im_groupinfo", 50);
        aao.put("tb.im_groupactivity", 50);
        aao.put("tb.im_entergroup", 10);
        aao.put("tb.im_enterforum_groupinfo", 10);
        aao.put("tb.im_group_setting", 3);
        aao.put("tb.im_personal_chat_setting", 3);
        aao.put("tb.im_official_chat_setting", 3);
        aao.put("tb.im_group_search_history", 50);
        aao.put("tb.im_official_history", 50);
        aao.put("tb.im_recommend_detail", 10);
        aao.put("tb.square", 1);
        aao.put("tb.first_dir", 1);
        aao.put("tb.forum_rank", 20);
        aao.put("tb.pic_gif", 50);
        aao.put("tb.official_bar_menu", 1000);
        aao.put("tb.friend_feed", 20);
        aao.put("net_err_record", 30);
        aao.put("tb_face_package", 30);
        aao.put("tb.recommend_friend", 10);
        aao.put("tb.searchperson_history", 5);
        aao.put("tb.game_center_home", 20);
        aao.put("tb.game_center_list", 20);
        aao.put("tb.person_wallet_new", 10);
        aao.put("bottom_write_story", 1);
        aap = new ArrayList<>();
        aap.add("tb.ala.gift_list");
        aap.add("tb.square");
        aap.add("tb.first_dir");
        aap.add("tb.forum_rank");
        aap.add("tb.im_group_setting");
        aap.add("tb.im_personal_chat_setting");
        aap.add("tb.im_official_chat_setting");
        aap.add("net_err_record");
        aap.add("tb_user_profile");
        aap.add("tb_forum_recommend");
        aap.add("tb.ad_killer_tags");
        aap.add("tb.manga.settings");
        aap.add("tb.share_add_experienced");
        aar = new HashMap<>();
        aaq = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a sX() {
        if (aan == null) {
            aan = new a();
        }
        return aan;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cH(String str) {
        return M(str, null);
    }

    public l<String> cI(String str) {
        return N(str, null);
    }

    public l<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aaq.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = aao.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aap.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aaq.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aar.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = aao.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aap.contains(str)) {
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
            l<String> lVar = aar.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    aar.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cJ(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aaq.clear();
        aar.clear();
    }
}
