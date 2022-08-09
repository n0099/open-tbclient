package com.baidu.tbadk.abtest.group;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
/* loaded from: classes3.dex */
public interface IThreadCardUbsABTest {
    void setABTest(BdUniqueId bdUniqueId, UsbAbTestSwitch usbAbTestSwitch);

    boolean showNewPicCut();

    boolean showNewUI();

    boolean showNoName();

    boolean showNoReadState();

    boolean showWeakenName();
}
