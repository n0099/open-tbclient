package com.baidu.tbadk.core.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a Vi = null;
    private static HashMap<String, Integer> Vj = new HashMap<>();
    private static ArrayList<String> Vk;
    private static HashMap<String, o<byte[]>> Vl;
    private static HashMap<String, o<String>> Vm;

    static {
        Vj.put("tb.pb_mark", 50);
        Vj.put("tb.pb_history", 300);
        Vj.put("tb.pb_normal", 1);
        Vj.put("tb.pb_editor", 50);
        Vj.put("tb.live_hotlist", 20);
        Vj.put("tb.live_hotlist", 20);
        Vj.put("tb.my_pages", 5);
        Vj.put("tb.my_forums", 3);
        Vj.put("tb.my_bookmarks", 3);
        Vj.put("tb.my_posts", 3);
        Vj.put("tb.im_frsgroup", 50);
        Vj.put("tb.im_hotgroup", 30);
        Vj.put("tb.im_groupinfo", 50);
        Vj.put("tb.im_groupactivity", 50);
        Vj.put("tb.im_entergroup", 10);
        Vj.put("tb.im_enterforum_groupinfo", 10);
        Vj.put("tb.im_group_setting", 3);
        Vj.put("tb.im_personal_chat_setting", 3);
        Vj.put("tb.im_official_chat_setting", 3);
        Vj.put("tb.im_group_search_history", 50);
        Vj.put("tb.im_official_history", 50);
        Vj.put("tb.im_recommend_detail", 10);
        Vj.put("tb.square", 1);
        Vj.put("tb.first_dir", 1);
        Vj.put("tb.forum_rank", 20);
        Vj.put("tb.pic_gif", 50);
        Vj.put("tb.official_bar_menu", 1000);
        Vj.put("tb.friend_feed", 20);
        Vj.put("net_err_record", 30);
        Vj.put("tb_face_package", 30);
        Vj.put("tb.recommend_friend", 10);
        Vj.put("tb.searchperson_history", 5);
        Vj.put("tb.game_center_home", 20);
        Vj.put("tb.game_center_list", 20);
        Vj.put("tb.ecomm", 5);
        Vj.put("tb.person_wallet_new", 10);
        Vk = new ArrayList<>();
        Vk.add("tb.square");
        Vk.add("tb.first_dir");
        Vk.add("tb.forum_rank");
        Vk.add("tb.im_group_setting");
        Vk.add("tb.im_personal_chat_setting");
        Vk.add("tb.im_official_chat_setting");
        Vk.add("net_err_record");
        Vk.add("tb_user_profile");
        Vk.add("tb_forum_recommend");
        Vk.add("tb.ad_killer_tags");
        Vk.add("tb.manga.settings");
        Vm = new HashMap<>();
        Vl = new HashMap<>();
    }

    public static a sT() {
        if (Vi == null) {
            Vi = new a();
        }
        return Vi;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cx(String str) {
        return M(str, null);
    }

    public o<String> cy(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Vl.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService dB = BdCacheService.dB();
            Integer num = Vj.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Vk.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = dB.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Vl.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Vm.get(str3);
        BdCacheService dB = BdCacheService.dB();
        Integer num = Vj.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Vk.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return dB.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            o<String> oVar = Vm.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.dB().a(oVar);
                    Vm.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cz(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Vl.clear();
        Vm.clear();
    }
}
