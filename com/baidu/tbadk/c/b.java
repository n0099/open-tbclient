package com.baidu.tbadk.c;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class b extends BaseFragment {
    public static final String EDITOR_ENABLE_EXTRA = "is_enable_edit";
    public static final String EDITOR_STATE_EXTRA = "is_edit_state";
    public static final String FRAGMENT_TYPE = "fragment_type";
    protected boolean mIsEnableEdit = false;

    public abstract int getType();

    public boolean isEnableEdit() {
        return this.mIsEnableEdit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendEditEnableMessage(int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(EDITOR_ENABLE_EXTRA, this.mIsEnableEdit);
        bundle.putInt(FRAGMENT_TYPE, i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE, bundle));
    }
}
