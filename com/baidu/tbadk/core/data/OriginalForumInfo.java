package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class OriginalForumInfo implements Serializable {
    public String id;
    public String ori_avatar;
    public String ori_fname;
    public long ori_member_num;

    public static OriginalForumInfo parser(OriForumInfo oriForumInfo) {
        if (oriForumInfo == null) {
            return null;
        }
        OriginalForumInfo originalForumInfo = new OriginalForumInfo();
        originalForumInfo.id = String.valueOf(oriForumInfo.ori_fid);
        originalForumInfo.ori_fname = oriForumInfo.ori_fname;
        originalForumInfo.ori_avatar = oriForumInfo.ori_avatar;
        originalForumInfo.ori_member_num = oriForumInfo.ori_member_num.longValue();
        return originalForumInfo;
    }
}
