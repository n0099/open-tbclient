package com.baidu.graph.sdk.framework;

import com.baidu.graph.sdk.ui.FragmentType;
import com.baidu.graph.sdk.ui.fragment.result.StringResult;
import org.jetbrains.annotations.NotNull;
/* loaded from: classes3.dex */
public class ExtFragmentResult extends StringResult {
    private FragmentType fragmentType;
    private String result;

    public ExtFragmentResult(String str, FragmentType fragmentType) {
        super(str, fragmentType);
    }

    @Override // com.baidu.graph.sdk.ui.fragment.result.StringResult
    @NotNull
    public String getResult() {
        return this.result;
    }

    @Override // com.baidu.graph.sdk.ui.fragment.result.StringResult
    public void setResult(String str) {
        this.result = str;
    }

    public void setFragmentType(FragmentType fragmentType) {
        this.fragmentType = fragmentType;
    }
}
