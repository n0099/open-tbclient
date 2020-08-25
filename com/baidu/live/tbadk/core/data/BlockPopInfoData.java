package com.baidu.live.tbadk.core.data;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class BlockPopInfoData implements Serializable {
    public static final int TYPE_CAN_NOT_POST = 1;
    public static final int TYPE_CAN_POST = 0;
    public static final int TYPE_JUMP_TO_H5 = 2;
    public static final int TYPE_SHOW_DIALOG = 1;
    private static final long serialVersionUID = -9216537902294235110L;
    public String ahead_info;
    public Integer ahead_type;
    public String ahead_url;
    public String block_info;
    public Integer can_post;
    public String ok_info;
}
