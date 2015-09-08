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
    public static a Wq = null;
    private static HashMap<String, Integer> Wr = new HashMap<>();
    private static ArrayList<String> Ws;
    private static HashMap<String, o<byte[]>> Wt;
    private static HashMap<String, o<String>> Wu;

    static {
        Wr.put("tb.pb_mark", 50);
        Wr.put("tb.pb_history", 300);
        Wr.put("tb.pb_normal", 1);
        Wr.put("tb.pb_editor", 50);
        Wr.put("tb.live_hotlist", 20);
        Wr.put("tb.live_hotlist", 20);
        Wr.put("tb.my_pages", 5);
        Wr.put("tb.my_forums", 3);
        Wr.put("tb.my_bookmarks", 3);
        Wr.put("tb.my_posts", 3);
        Wr.put("tb.im_frsgroup", 50);
        Wr.put("tb.im_hotgroup", 30);
        Wr.put("tb.im_groupinfo", 50);
        Wr.put("tb.im_groupactivity", 50);
        Wr.put("tb.im_entergroup", 10);
        Wr.put("tb.im_enterforum_groupinfo", 10);
        Wr.put("tb.im_group_setting", 3);
        Wr.put("tb.im_personal_chat_setting", 3);
        Wr.put("tb.im_official_chat_setting", 3);
        Wr.put("tb.im_group_search_history", 50);
        Wr.put("tb.im_official_history", 50);
        Wr.put("tb.im_recommend_detail", 10);
        Wr.put("tb.square", 1);
        Wr.put("tb.first_dir", 1);
        Wr.put("tb.forum_rank", 20);
        Wr.put("tb.pic_gif", 50);
        Wr.put("tb.official_bar_menu", 1000);
        Wr.put("tb.friend_feed", 20);
        Wr.put("net_err_record", 30);
        Wr.put("tb_face_package", 30);
        Wr.put("tb.recommend_friend", 10);
        Wr.put("tb.searchperson_history", 5);
        Wr.put("tb.game_center_home", 20);
        Wr.put("tb.game_center_list", 20);
        Ws = new ArrayList<>();
        Ws.add("tb.square");
        Ws.add("tb.first_dir");
        Ws.add("tb.forum_rank");
        Ws.add("tb.im_group_setting");
        Ws.add("tb.im_personal_chat_setting");
        Ws.add("tb.im_official_chat_setting");
        Ws.add("net_err_record");
        Ws.add("tb_user_profile");
        Ws.add("tb_forum_recommend");
        Wu = new HashMap<>();
        Wt = new HashMap<>();
    }

    public static a sR() {
        if (Wq == null) {
            Wq = new a();
        }
        return Wq;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cp(String str) {
        return U(str, null);
    }

    public o<String> cq(String str) {
        return V(str, null);
    }

    public o<byte[]> U(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Wt.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gl = BdCacheService.gl();
            Integer num = Wr.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Ws.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gl.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Wt.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> V(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Wu.get(str3);
        BdCacheService gl = BdCacheService.gl();
        Integer num = Wr.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Ws.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gl.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void W(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Wu.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gl().a(oVar);
                    Wu.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cr(String str) {
        W(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Wt.clear();
        Wu.clear();
    }
}
