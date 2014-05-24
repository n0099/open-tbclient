package com.baidu.tbadk.core.atomData;

import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class bf extends com.baidu.tbadk.core.frameworkData.a {
    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            com.baidu.adp.lib.util.k.a(getContext(), getContext().getString(com.baidu.tieba.y.web_view_corrupted));
            return false;
        }
        return true;
    }
}
