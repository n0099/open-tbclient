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
    public static a Wk = null;
    private static HashMap<String, Integer> Wl = new HashMap<>();
    private static ArrayList<String> Wm;
    private static HashMap<String, o<byte[]>> Wn;
    private static HashMap<String, o<String>> Wo;

    static {
        Wl.put("tb.pb_mark", 50);
        Wl.put("tb.pb_history", 300);
        Wl.put("tb.pb_normal", 1);
        Wl.put("tb.pb_editor", 50);
        Wl.put("tb.live_hotlist", 20);
        Wl.put("tb.live_hotlist", 20);
        Wl.put("tb.my_pages", 5);
        Wl.put("tb.my_forums", 3);
        Wl.put("tb.my_bookmarks", 3);
        Wl.put("tb.my_posts", 3);
        Wl.put("tb.im_frsgroup", 50);
        Wl.put("tb.im_hotgroup", 30);
        Wl.put("tb.im_groupinfo", 50);
        Wl.put("tb.im_groupactivity", 50);
        Wl.put("tb.im_entergroup", 10);
        Wl.put("tb.im_enterforum_groupinfo", 10);
        Wl.put("tb.im_group_setting", 3);
        Wl.put("tb.im_personal_chat_setting", 3);
        Wl.put("tb.im_official_chat_setting", 3);
        Wl.put("tb.im_group_search_history", 50);
        Wl.put("tb.im_official_history", 50);
        Wl.put("tb.im_recommend_detail", 10);
        Wl.put("tb.square", 1);
        Wl.put("tb.first_dir", 1);
        Wl.put("tb.forum_rank", 20);
        Wl.put("tb.pic_gif", 50);
        Wl.put("tb.official_bar_menu", 1000);
        Wl.put("tb.friend_feed", 20);
        Wl.put("net_err_record", 30);
        Wl.put("tb_face_package", 30);
        Wl.put("tb.recommend_friend", 10);
        Wl.put("tb.searchperson_history", 5);
        Wl.put("tb.game_center_home", 20);
        Wl.put("tb.game_center_list", 20);
        Wm = new ArrayList<>();
        Wm.add("tb.square");
        Wm.add("tb.first_dir");
        Wm.add("tb.forum_rank");
        Wm.add("tb.im_group_setting");
        Wm.add("tb.im_personal_chat_setting");
        Wm.add("tb.im_official_chat_setting");
        Wm.add("net_err_record");
        Wm.add("tb_user_profile");
        Wm.add("tb_forum_recommend");
        Wo = new HashMap<>();
        Wn = new HashMap<>();
    }

    public static a sL() {
        if (Wk == null) {
            Wk = new a();
        }
        return Wk;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cq(String str) {
        return T(str, null);
    }

    public o<String> cr(String str) {
        return U(str, null);
    }

    public o<byte[]> T(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Wn.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gl = BdCacheService.gl();
            Integer num = Wl.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Wm.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gl.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Wn.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> U(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Wo.get(str3);
        BdCacheService gl = BdCacheService.gl();
        Integer num = Wl.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Wm.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gl.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void V(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Wo.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gl().a(oVar);
                    Wo.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cs(String str) {
        V(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Wn.clear();
        Wo.clear();
    }
}
