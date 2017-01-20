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
    private static ArrayList<String> UB;
    private static HashMap<String, o<byte[]>> UC;
    private static HashMap<String, o<String>> UD;
    public static a Uy = null;
    private static HashMap<String, Integer> Uz = new HashMap<>();

    static {
        Uz.put("tb.pb_mark", 50);
        Uz.put("tb.pb_history", 300);
        Uz.put("tb.pb_normal", 1);
        Uz.put("tb.pb_editor", 50);
        Uz.put("tb.live_hotlist", 20);
        Uz.put("tb.live_hotlist", 20);
        Uz.put("tb.my_pages", 5);
        Uz.put("tb.my_forums", 3);
        Uz.put("tb.my_bookmarks", 3);
        Uz.put("tb.my_posts", 3);
        Uz.put("tb.im_frsgroup", 50);
        Uz.put("tb.im_hotgroup", 30);
        Uz.put("tb.im_groupinfo", 50);
        Uz.put("tb.im_groupactivity", 50);
        Uz.put("tb.im_entergroup", 10);
        Uz.put("tb.im_enterforum_groupinfo", 10);
        Uz.put("tb.im_group_setting", 3);
        Uz.put("tb.im_personal_chat_setting", 3);
        Uz.put("tb.im_official_chat_setting", 3);
        Uz.put("tb.im_group_search_history", 50);
        Uz.put("tb.im_official_history", 50);
        Uz.put("tb.im_recommend_detail", 10);
        Uz.put("tb.square", 1);
        Uz.put("tb.first_dir", 1);
        Uz.put("tb.forum_rank", 20);
        Uz.put("tb.pic_gif", 50);
        Uz.put("tb.official_bar_menu", 1000);
        Uz.put("tb.friend_feed", 20);
        Uz.put("net_err_record", 30);
        Uz.put("tb_face_package", 30);
        Uz.put("tb.recommend_friend", 10);
        Uz.put("tb.searchperson_history", 5);
        Uz.put("tb.game_center_home", 20);
        Uz.put("tb.game_center_list", 20);
        Uz.put("tb.person_wallet_new", 10);
        UB = new ArrayList<>();
        UB.add("tb.ala.gift_list");
        UB.add("tb.square");
        UB.add("tb.first_dir");
        UB.add("tb.forum_rank");
        UB.add("tb.im_group_setting");
        UB.add("tb.im_personal_chat_setting");
        UB.add("tb.im_official_chat_setting");
        UB.add("net_err_record");
        UB.add("tb_user_profile");
        UB.add("tb_forum_recommend");
        UB.add("tb.ad_killer_tags");
        UB.add("tb.manga.settings");
        UD = new HashMap<>();
        UC = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a sR() {
        if (Uy == null) {
            Uy = new a();
        }
        return Uy;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cA(String str) {
        return M(str, null);
    }

    public o<String> cB(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = UC.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService dz = BdCacheService.dz();
            Integer num = Uz.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (UB.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = dz.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            UC.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = UD.get(str3);
        BdCacheService dz = BdCacheService.dz();
        Integer num = Uz.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (UB.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return dz.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = UD.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.dz().a(oVar);
                    UD.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cC(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        UC.clear();
        UD.clear();
    }
}
