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
    public static a VQ = null;
    private static HashMap<String, Integer> VR = new HashMap<>();
    private static ArrayList<String> VS;
    private static HashMap<String, o<byte[]>> VT;
    private static HashMap<String, o<String>> VU;

    static {
        VR.put("tb.pb_mark", 50);
        VR.put("tb.pb_history", 300);
        VR.put("tb.pb_normal", 1);
        VR.put("tb.pb_editor", 50);
        VR.put("tb.live_hotlist", 20);
        VR.put("tb.live_hotlist", 20);
        VR.put("tb.my_pages", 5);
        VR.put("tb.my_forums", 3);
        VR.put("tb.my_bookmarks", 3);
        VR.put("tb.my_posts", 3);
        VR.put("tb.im_frsgroup", 50);
        VR.put("tb.im_hotgroup", 30);
        VR.put("tb.im_groupinfo", 50);
        VR.put("tb.im_groupactivity", 50);
        VR.put("tb.im_entergroup", 10);
        VR.put("tb.im_enterforum_groupinfo", 10);
        VR.put("tb.im_group_setting", 3);
        VR.put("tb.im_personal_chat_setting", 3);
        VR.put("tb.im_official_chat_setting", 3);
        VR.put("tb.im_group_search_history", 50);
        VR.put("tb.im_official_history", 50);
        VR.put("tb.im_recommend_detail", 10);
        VR.put("tb.square", 1);
        VR.put("tb.first_dir", 1);
        VR.put("tb.forum_rank", 20);
        VR.put("tb.pic_gif", 50);
        VR.put("tb.official_bar_menu", 1000);
        VR.put("tb.friend_feed", 20);
        VR.put("net_err_record", 30);
        VR.put("tb_face_package", 30);
        VR.put("tb.recommend_friend", 10);
        VR.put("tb.searchperson_history", 5);
        VR.put("tb.game_center_home", 20);
        VR.put("tb.game_center_list", 20);
        VR.put("tb.ecomm", 5);
        VR.put("tb.person_wallet_new", 10);
        VS = new ArrayList<>();
        VS.add("tb.square");
        VS.add("tb.first_dir");
        VS.add("tb.forum_rank");
        VS.add("tb.im_group_setting");
        VS.add("tb.im_personal_chat_setting");
        VS.add("tb.im_official_chat_setting");
        VS.add("net_err_record");
        VS.add("tb_user_profile");
        VS.add("tb_forum_recommend");
        VS.add("tb.ad_killer_tags");
        VS.add("tb.manga.settings");
        VU = new HashMap<>();
        VT = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a tm() {
        if (VQ == null) {
            VQ = new a();
        }
        return VQ;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cB(String str) {
        return M(str, null);
    }

    public o<String> cC(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = VT.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService dB = BdCacheService.dB();
            Integer num = VR.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (VS.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = dB.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            VT.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = VU.get(str3);
        BdCacheService dB = BdCacheService.dB();
        Integer num = VR.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (VS.contains(str)) {
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
            o<String> oVar = VU.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.dB().a(oVar);
                    VU.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cD(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        VT.clear();
        VU.clear();
    }
}
