package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.c.e.p.a;
import d.b.i0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ForumBroadcastHelper {
    public static final String KEY_PARMARS_BCAST_CONTENT = "content";
    public static final String KEY_PARMARS_BCAST_FROM = "from";
    public static final String KEY_PARMARS_BCAST_ID = "broadcastID";
    public static final String KEY_PARMARS_BCAST_IMAGE = "image";
    public static final String KEY_PARMARS_BCAST_OBJ_SOURCE = "obj_source";
    public static final String KEY_PARMARS_BCAST_THREADLINK = "threadLink";
    public static final String KEY_PARMARS_BCAST_TITLE = "title";
    public static final String KEY_PARMARS_FORUM_ID = "forumID";
    public static final String KEY_PARMARS_FORUM_NAME = "forumName";
    public static final String KEY_PARMARS_THREAD_ID = "threadID";
    public static final String VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS = "broadcast_publish_success";
    public static final String VALUE_PARMARS_BCAST_FROM_EDIT = "failed_broadcast";
    public Context mContext;
    public HashMap<String, Object> params = new HashMap<>();

    public ForumBroadcastHelper(Context context) {
        this.mContext = context;
    }

    public void clipCopy(String str) {
        a.a("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
    }

    public void jumpFlutterEditGenear(String str, String str2) {
        this.params.put(KEY_PARMARS_FORUM_ID, str);
        this.params.put("forumName", str2);
    }

    public void jumpFlutterEditRelease(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.params.put(KEY_PARMARS_BCAST_ID, str);
        this.params.put("forumName", str2);
        this.params.put(KEY_PARMARS_FORUM_ID, str3);
        this.params.put(KEY_PARMARS_THREAD_ID, str4);
        this.params.put("title", str5);
        this.params.put("content", str6);
        this.params.put("image", str7);
        this.params.put("from", str8);
        this.params.put("obj_source", str9);
        HashMap<String, Object> hashMap = this.params;
        hashMap.put(KEY_PARMARS_BCAST_THREADLINK, "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
    }

    public void sendClipBoardMessage() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
    }

    public void start() {
        this.params.put("swipeback", Boolean.FALSE);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.mContext, "BarBroadcastEdit", this.params)));
    }

    public void jumpFlutterEditGenear(String str, String str2, String str3) {
        this.params.put(KEY_PARMARS_FORUM_ID, str);
        this.params.put("forumName", str2);
        this.params.put("obj_source", str3);
    }
}
