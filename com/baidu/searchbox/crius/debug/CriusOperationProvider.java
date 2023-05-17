package com.baidu.searchbox.crius.debug;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.util.CriusAbTestManager;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes3.dex */
public class CriusOperationProvider extends DebugDataGroupProvider {
    public View.OnClickListener criusBaseListener = new View.OnClickListener() { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusActivity.class));
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
        }
    };
    public View.OnClickListener criusFlattenListener = new View.OnClickListener() { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusFlattenActivity.class));
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
        }
    };
    public View.OnClickListener benchmarkListener = new View.OnClickListener() { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusBenchmarkActivity.class));
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
        }
    };
    public CompoundButton.OnCheckedChangeListener mCriusVisitedListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.4
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CriusAbTestManager.updateVisitedState(z);
            if (z) {
                Toast.makeText(AppRuntime.getAppContext(), "切到已读态", 0).show();
            } else {
                Toast.makeText(AppRuntime.getAppContext(), "是否已读，根据调用方决定", 0).show();
            }
        }
    };

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return "灵动";
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        return getGCommunityOperationInfo();
    }

    private List<DebugItemInfo> getGCommunityOperationInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextItemInfo("", "sample-base", this.criusBaseListener));
        arrayList.add(new TextItemInfo("", "sample-扁平化", this.criusFlattenListener));
        arrayList.add(new TextItemInfo("", "benchmark", this.benchmarkListener));
        arrayList.add(new CheckItemInfo("灵动强制已读态", this.mCriusVisitedListener, Boolean.valueOf(CriusAbTestManager.isVisited())));
        return arrayList;
    }
}
