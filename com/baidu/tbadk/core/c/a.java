package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a ZL = null;
    private static HashMap<String, Integer> ZM = new HashMap<>();
    private static ArrayList<String> ZN;
    private static HashMap<String, o<byte[]>> ZO;
    private static HashMap<String, o<String>> ZP;

    static {
        ZM.put("tb.pb_mark", 50);
        ZM.put("tb.pb_history", 300);
        ZM.put("tb.pb_normal", 1);
        ZM.put("tb.pb_editor", 50);
        ZM.put("tb.live_hotlist", 20);
        ZM.put("tb.live_hotlist", 20);
        ZM.put("tb.my_pages", 5);
        ZM.put("tb.my_forums", 3);
        ZM.put("tb.my_bookmarks", 3);
        ZM.put("tb.my_posts", 3);
        ZM.put("tb.im_frsgroup", 50);
        ZM.put("tb.im_hotgroup", 30);
        ZM.put("tb.im_groupinfo", 50);
        ZM.put("tb.im_groupactivity", 50);
        ZM.put("tb.im_entergroup", 10);
        ZM.put("tb.im_enterforum_groupinfo", 10);
        ZM.put("tb.im_group_setting", 3);
        ZM.put("tb.im_personal_chat_setting", 3);
        ZM.put("tb.im_official_chat_setting", 3);
        ZM.put("tb.im_group_search_history", 50);
        ZM.put("tb.im_official_history", 50);
        ZM.put("tb.im_recommend_detail", 10);
        ZM.put("tb.square", 1);
        ZM.put("tb.first_dir", 1);
        ZM.put("tb.forum_rank", 20);
        ZM.put("tb.pic_gif", 50);
        ZM.put("tb.official_bar_menu", 1000);
        ZM.put("tb.friend_feed", 20);
        ZM.put("net_err_record", 30);
        ZM.put("tb_face_package", 30);
        ZM.put("tb.recommend_friend", 10);
        ZM.put("tb.searchperson_history", 5);
        ZM.put("tb.game_center_home", 20);
        ZM.put("tb.game_center_list", 20);
        ZM.put("tb.person_wallet_new", 10);
        ZN = new ArrayList<>();
        ZN.add("tb.ala.gift_list");
        ZN.add("tb.square");
        ZN.add("tb.first_dir");
        ZN.add("tb.forum_rank");
        ZN.add("tb.im_group_setting");
        ZN.add("tb.im_personal_chat_setting");
        ZN.add("tb.im_official_chat_setting");
        ZN.add("net_err_record");
        ZN.add("tb_user_profile");
        ZN.add("tb_forum_recommend");
        ZN.add("tb.ad_killer_tags");
        ZN.add("tb.manga.settings");
        ZP = new HashMap<>();
        ZO = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a to() {
        if (ZL == null) {
            ZL = new a();
        }
        return ZL;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> ct(String str) {
        return K(str, null);
    }

    public o<String> cu(String str) {
        return L(str, null);
    }

    public o<byte[]> K(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = ZO.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService eI = BdCacheService.eI();
            Integer num = ZM.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (ZN.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = eI.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            ZO.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = ZP.get(str3);
        BdCacheService eI = BdCacheService.eI();
        Integer num = ZM.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (ZN.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eI.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void M(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = ZP.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.eI().a(oVar);
                    ZP.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cv(String str) {
        M(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ZO.clear();
        ZP.clear();
    }
}
