package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public HashMap<String, Object> fbY = new HashMap<>();
    private Context mContext;

    public o(Context context) {
        this.mContext = context;
    }

    public void ao(String str, String str2, String str3) {
        this.fbY.put("forumID", str);
        this.fbY.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.fbY.put("obj_source", str3);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.fbY.put("broadcastID", str);
        this.fbY.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.fbY.put("forumID", str3);
        this.fbY.put("threadID", str4);
        this.fbY.put("title", str5);
        this.fbY.put("content", str6);
        this.fbY.put("image", str7);
        this.fbY.put("from", str8);
        this.fbY.put("obj_source", str9);
        this.fbY.put("threadLink", "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
    }

    public void BP(String str) {
        com.baidu.adp.lib.util.a.copyToClipboard("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
    }

    public void bvG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
    }

    public void start() {
        this.fbY.put("swipeback", false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(this.mContext, "BarBroadcastEdit", this.fbY)));
    }
}
