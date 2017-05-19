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
    private static HashMap<String, o<byte[]>> ZA;
    private static HashMap<String, o<String>> ZB;
    public static a Zx = null;
    private static HashMap<String, Integer> Zy = new HashMap<>();
    private static ArrayList<String> Zz;

    static {
        Zy.put("tb.pb_mark", 50);
        Zy.put("tb.pb_history", 300);
        Zy.put("tb.pb_normal", 1);
        Zy.put("tb.pb_editor", 50);
        Zy.put("tb.live_hotlist", 20);
        Zy.put("tb.live_hotlist", 20);
        Zy.put("tb.my_pages", 5);
        Zy.put("tb.my_forums", 3);
        Zy.put("tb.my_bookmarks", 3);
        Zy.put("tb.my_posts", 3);
        Zy.put("tb.im_frsgroup", 50);
        Zy.put("tb.im_hotgroup", 30);
        Zy.put("tb.im_groupinfo", 50);
        Zy.put("tb.im_groupactivity", 50);
        Zy.put("tb.im_entergroup", 10);
        Zy.put("tb.im_enterforum_groupinfo", 10);
        Zy.put("tb.im_group_setting", 3);
        Zy.put("tb.im_personal_chat_setting", 3);
        Zy.put("tb.im_official_chat_setting", 3);
        Zy.put("tb.im_group_search_history", 50);
        Zy.put("tb.im_official_history", 50);
        Zy.put("tb.im_recommend_detail", 10);
        Zy.put("tb.square", 1);
        Zy.put("tb.first_dir", 1);
        Zy.put("tb.forum_rank", 20);
        Zy.put("tb.pic_gif", 50);
        Zy.put("tb.official_bar_menu", 1000);
        Zy.put("tb.friend_feed", 20);
        Zy.put("net_err_record", 30);
        Zy.put("tb_face_package", 30);
        Zy.put("tb.recommend_friend", 10);
        Zy.put("tb.searchperson_history", 5);
        Zy.put("tb.game_center_home", 20);
        Zy.put("tb.game_center_list", 20);
        Zy.put("tb.person_wallet_new", 10);
        Zz = new ArrayList<>();
        Zz.add("tb.ala.gift_list");
        Zz.add("tb.square");
        Zz.add("tb.first_dir");
        Zz.add("tb.forum_rank");
        Zz.add("tb.im_group_setting");
        Zz.add("tb.im_personal_chat_setting");
        Zz.add("tb.im_official_chat_setting");
        Zz.add("net_err_record");
        Zz.add("tb_user_profile");
        Zz.add("tb_forum_recommend");
        Zz.add("tb.ad_killer_tags");
        Zz.add("tb.manga.settings");
        ZB = new HashMap<>();
        ZA = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a sZ() {
        if (Zx == null) {
            Zx = new a();
        }
        return Zx;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cy(String str) {
        return L(str, null);
    }

    public o<String> cz(String str) {
        return M(str, null);
    }

    public o<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = ZA.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService eI = BdCacheService.eI();
            Integer num = Zy.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Zz.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = eI.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            ZA.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = ZB.get(str3);
        BdCacheService eI = BdCacheService.eI();
        Integer num = Zy.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Zz.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eI.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void N(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = ZB.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.eI().a(oVar);
                    ZB.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cA(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ZA.clear();
        ZB.clear();
    }
}
