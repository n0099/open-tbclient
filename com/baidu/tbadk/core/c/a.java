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
    public static a ZW = null;
    private static HashMap<String, Integer> ZX = new HashMap<>();
    private static ArrayList<String> ZY;
    private static HashMap<String, l<byte[]>> ZZ;
    private static HashMap<String, l<String>> aaa;

    static {
        ZX.put("tb.pb_mark", 50);
        ZX.put("tb.pb_history", 300);
        ZX.put("tb.pb_normal", 1);
        ZX.put("tb.pb_editor", 50);
        ZX.put("tb.live_hotlist", 20);
        ZX.put("tb.live_hotlist", 20);
        ZX.put("tb.my_pages", 5);
        ZX.put("tb.my_forums", 3);
        ZX.put("tb.my_bookmarks", 3);
        ZX.put("tb.my_posts", 3);
        ZX.put("tb.im_frsgroup", 50);
        ZX.put("tb.im_hotgroup", 30);
        ZX.put("tb.im_groupinfo", 50);
        ZX.put("tb.im_groupactivity", 50);
        ZX.put("tb.im_entergroup", 10);
        ZX.put("tb.im_enterforum_groupinfo", 10);
        ZX.put("tb.im_group_setting", 3);
        ZX.put("tb.im_personal_chat_setting", 3);
        ZX.put("tb.im_official_chat_setting", 3);
        ZX.put("tb.im_group_search_history", 50);
        ZX.put("tb.im_official_history", 50);
        ZX.put("tb.im_recommend_detail", 10);
        ZX.put("tb.square", 1);
        ZX.put("tb.first_dir", 1);
        ZX.put("tb.forum_rank", 20);
        ZX.put("tb.pic_gif", 50);
        ZX.put("tb.official_bar_menu", 1000);
        ZX.put("tb.friend_feed", 20);
        ZX.put("net_err_record", 30);
        ZX.put("tb_face_package", 30);
        ZX.put("tb.recommend_friend", 10);
        ZX.put("tb.searchperson_history", 5);
        ZX.put("tb.game_center_home", 20);
        ZX.put("tb.game_center_list", 20);
        ZX.put("tb.person_wallet_new", 10);
        ZX.put("bottom_write_story", 1);
        ZY = new ArrayList<>();
        ZY.add("tb.ala.gift_list");
        ZY.add("tb.square");
        ZY.add("tb.first_dir");
        ZY.add("tb.forum_rank");
        ZY.add("tb.im_group_setting");
        ZY.add("tb.im_personal_chat_setting");
        ZY.add("tb.im_official_chat_setting");
        ZY.add("net_err_record");
        ZY.add("tb_user_profile");
        ZY.add("tb_forum_recommend");
        ZY.add("tb.ad_killer_tags");
        ZY.add("tb.manga.settings");
        ZY.add("tb.share_add_experienced");
        aaa = new HashMap<>();
        ZZ = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a td() {
        if (ZW == null) {
            ZW = new a();
        }
        return ZW;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cJ(String str) {
        return L(str, null);
    }

    public l<String> cK(String str) {
        return M(str, null);
    }

    public l<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = ZZ.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eF = BdCacheService.eF();
            Integer num = ZX.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (ZY.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eF.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            ZZ.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aaa.get(str3);
        BdCacheService eF = BdCacheService.eF();
        Integer num = ZX.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (ZY.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eF.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            l<String> lVar = aaa.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eF().a(lVar);
                    aaa.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cL(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ZZ.clear();
        aaa.clear();
    }
}
