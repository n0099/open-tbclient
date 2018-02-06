package com.baidu.graph.sdk.framework;

import com.baidu.graph.sdk.framework.ar.ARConstants;
import com.baidu.graph.sdk.ui.FragmentType;
import com.baidu.graph.sdk.ui.fragment.result.BaseResult;
/* loaded from: classes3.dex */
public class ARFinishResult extends BaseResult {
    private ARConstants.ARFinishMode mARFinishMode;
    private String mResult;

    public ARFinishResult(FragmentType fragmentType) {
        super(fragmentType);
    }

    public ARFinishResult(String str, FragmentType fragmentType, ARConstants.ARFinishMode aRFinishMode) {
        super(fragmentType);
        this.mResult = str;
        this.mARFinishMode = aRFinishMode;
    }

    public String getResult() {
        return this.mResult;
    }

    public void setResult(String str) {
        this.mResult = str;
    }

    public ARConstants.ARFinishMode getARFinishMode() {
        return this.mARFinishMode;
    }

    public void setARFinishMode(ARConstants.ARFinishMode aRFinishMode) {
        this.mARFinishMode = aRFinishMode;
    }
}
