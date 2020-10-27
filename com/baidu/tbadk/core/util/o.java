package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public HashMap<String, Object> eGd = new HashMap<>();
    private Context mContext;

    public o(Context context) {
        this.mContext = context;
    }

    public void aj(String str, String str2, String str3) {
        this.eGd.put("forumID", str);
        this.eGd.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.eGd.put("obj_source", str3);
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.eGd.put("broadcastID", str);
        this.eGd.put(TbTitleActivityConfig.FORUM_NAME, str2);
        this.eGd.put("forumID", str3);
        this.eGd.put("threadID", str4);
        this.eGd.put("title", str5);
        this.eGd.put("content", str6);
        this.eGd.put("image", str7);
        this.eGd.put("from", str8);
        this.eGd.put("obj_source", str9);
        this.eGd.put("threadLink", "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
    }

    public void Bw(String str) {
        com.baidu.adp.lib.util.a.copyToClipboard("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
    }

    public void bnW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
    }

    public void start() {
        this.eGd.put("swipeback", false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(this.mContext, "BarBroadcastEdit", this.eGd)));
    }
}
