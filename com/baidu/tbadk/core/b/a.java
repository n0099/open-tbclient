package com.baidu.tbadk.core.b;

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
    public static a Vk = null;
    private static HashMap<String, Integer> Vl = new HashMap<>();
    private static ArrayList<String> Vm;
    private static HashMap<String, o<byte[]>> Vn;
    private static HashMap<String, o<String>> Vo;

    static {
        Vl.put("tb.pb_mark", 50);
        Vl.put("tb.pb_history", 300);
        Vl.put("tb.pb_normal", 1);
        Vl.put("tb.pb_editor", 50);
        Vl.put("tb.live_hotlist", 20);
        Vl.put("tb.live_hotlist", 20);
        Vl.put("tb.my_pages", 5);
        Vl.put("tb.my_forums", 3);
        Vl.put("tb.my_bookmarks", 3);
        Vl.put("tb.my_posts", 3);
        Vl.put("tb.im_frsgroup", 50);
        Vl.put("tb.im_hotgroup", 30);
        Vl.put("tb.im_groupinfo", 50);
        Vl.put("tb.im_groupactivity", 50);
        Vl.put("tb.im_entergroup", 10);
        Vl.put("tb.im_enterforum_groupinfo", 10);
        Vl.put("tb.im_group_setting", 3);
        Vl.put("tb.im_personal_chat_setting", 3);
        Vl.put("tb.im_official_chat_setting", 3);
        Vl.put("tb.im_group_search_history", 50);
        Vl.put("tb.im_official_history", 50);
        Vl.put("tb.im_recommend_detail", 10);
        Vl.put("tb.square", 1);
        Vl.put("tb.first_dir", 1);
        Vl.put("tb.forum_rank", 20);
        Vl.put("tb.pic_gif", 50);
        Vl.put("tb.official_bar_menu", 1000);
        Vl.put("tb.friend_feed", 20);
        Vl.put("net_err_record", 30);
        Vl.put("tb_face_package", 30);
        Vl.put("tb.recommend_friend", 10);
        Vl.put("tb.searchperson_history", 5);
        Vl.put("tb.game_center_home", 20);
        Vl.put("tb.game_center_list", 20);
        Vl.put("tb.person_wallet_new", 10);
        Vm = new ArrayList<>();
        Vm.add("tb.square");
        Vm.add("tb.first_dir");
        Vm.add("tb.forum_rank");
        Vm.add("tb.im_group_setting");
        Vm.add("tb.im_personal_chat_setting");
        Vm.add("tb.im_official_chat_setting");
        Vm.add("net_err_record");
        Vm.add("tb_user_profile");
        Vm.add("tb_forum_recommend");
        Vm.add("tb.ad_killer_tags");
        Vm.add("tb.manga.settings");
        Vo = new HashMap<>();
        Vn = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a sX() {
        if (Vk == null) {
            Vk = new a();
        }
        return Vk;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cC(String str) {
        return M(str, null);
    }

    public o<String> cD(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Vn.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService dB = BdCacheService.dB();
            Integer num = Vl.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Vm.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = dB.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Vn.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Vo.get(str3);
        BdCacheService dB = BdCacheService.dB();
        Integer num = Vl.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Vm.contains(str)) {
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
            o<String> oVar = Vo.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.dB().a(oVar);
                    Vo.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cE(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Vn.clear();
        Vo.clear();
    }
}
