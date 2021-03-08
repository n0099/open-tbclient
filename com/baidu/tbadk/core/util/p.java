package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public HashMap<String, Object> fbf = new HashMap<>();
    private Context mContext;

    public p(Context context) {
        this.mContext = context;
    }

    public void ap(String str, String str2, String str3) {
        this.fbf.put("forumID", str);
        this.fbf.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.fbf.put("obj_source", str3);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.fbf.put("broadcastID", str);
        this.fbf.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.fbf.put("forumID", str3);
        this.fbf.put("threadID", str4);
        this.fbf.put("title", str5);
        this.fbf.put("content", str6);
        this.fbf.put("image", str7);
        this.fbf.put("from", str8);
        this.fbf.put("obj_source", str9);
        this.fbf.put("threadLink", "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
    }

    public void Bb(String str) {
        com.baidu.adp.lib.util.a.copyToClipboard("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
    }

    public void bsk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
    }

    public void start() {
        this.fbf.put("swipeback", false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(this.mContext, "BarBroadcastEdit", this.fbf)));
    }
}
