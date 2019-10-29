package com.baidu.live.tieba.pb.interactionpopupwindow;

import java.io.Serializable;
/* loaded from: classes6.dex */
public interface IBaseDialogData extends Serializable {
    public static final int TYPE_CUSTOM = 1;

    int getFrom();

    int getType();
}
