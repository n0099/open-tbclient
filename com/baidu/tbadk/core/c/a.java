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
    private static HashMap<String, o<String>> ZA;
    public static a Zw = null;
    private static HashMap<String, Integer> Zx = new HashMap<>();
    private static ArrayList<String> Zy;
    private static HashMap<String, o<byte[]>> Zz;

    static {
        Zx.put("tb.pb_mark", 50);
        Zx.put("tb.pb_history", 300);
        Zx.put("tb.pb_normal", 1);
        Zx.put("tb.pb_editor", 50);
        Zx.put("tb.live_hotlist", 20);
        Zx.put("tb.live_hotlist", 20);
        Zx.put("tb.my_pages", 5);
        Zx.put("tb.my_forums", 3);
        Zx.put("tb.my_bookmarks", 3);
        Zx.put("tb.my_posts", 3);
        Zx.put("tb.im_frsgroup", 50);
        Zx.put("tb.im_hotgroup", 30);
        Zx.put("tb.im_groupinfo", 50);
        Zx.put("tb.im_groupactivity", 50);
        Zx.put("tb.im_entergroup", 10);
        Zx.put("tb.im_enterforum_groupinfo", 10);
        Zx.put("tb.im_group_setting", 3);
        Zx.put("tb.im_personal_chat_setting", 3);
        Zx.put("tb.im_official_chat_setting", 3);
        Zx.put("tb.im_group_search_history", 50);
        Zx.put("tb.im_official_history", 50);
        Zx.put("tb.im_recommend_detail", 10);
        Zx.put("tb.square", 1);
        Zx.put("tb.first_dir", 1);
        Zx.put("tb.forum_rank", 20);
        Zx.put("tb.pic_gif", 50);
        Zx.put("tb.official_bar_menu", 1000);
        Zx.put("tb.friend_feed", 20);
        Zx.put("net_err_record", 30);
        Zx.put("tb_face_package", 30);
        Zx.put("tb.recommend_friend", 10);
        Zx.put("tb.searchperson_history", 5);
        Zx.put("tb.game_center_home", 20);
        Zx.put("tb.game_center_list", 20);
        Zx.put("tb.person_wallet_new", 10);
        Zy = new ArrayList<>();
        Zy.add("tb.ala.gift_list");
        Zy.add("tb.square");
        Zy.add("tb.first_dir");
        Zy.add("tb.forum_rank");
        Zy.add("tb.im_group_setting");
        Zy.add("tb.im_personal_chat_setting");
        Zy.add("tb.im_official_chat_setting");
        Zy.add("net_err_record");
        Zy.add("tb_user_profile");
        Zy.add("tb_forum_recommend");
        Zy.add("tb.ad_killer_tags");
        Zy.add("tb.manga.settings");
        ZA = new HashMap<>();
        Zz = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a sY() {
        if (Zw == null) {
            Zw = new a();
        }
        return Zw;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cx(String str) {
        return L(str, null);
    }

    public o<String> cy(String str) {
        return M(str, null);
    }

    public o<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Zz.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService eI = BdCacheService.eI();
            Integer num = Zx.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Zy.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = eI.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Zz.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = ZA.get(str3);
        BdCacheService eI = BdCacheService.eI();
        Integer num = Zx.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Zy.contains(str)) {
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
            o<String> oVar = ZA.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.eI().a(oVar);
                    ZA.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cz(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Zz.clear();
        ZA.clear();
    }
}
