package com.baidu.tbadk.core.message;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class EnterHomeWorkMessage extends CustomResponsedMessage<String> {
    private Activity mActivity;

    public EnterHomeWorkMessage(Activity activity) {
        super(CmdConfigCustom.CMD_ENTER_HOMEWORK);
        this.mActivity = activity;
    }

    public Activity getActivity() {
        return this.mActivity;
    }
}
