package com.baidu.searchbox.fluency.view;

import android.os.Build;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.fluency.utils.FpsSpUtil;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes2.dex */
public class FpsOperationProvider extends DebugDataGroupProvider {
    public CompoundButton.OnCheckedChangeListener mSwitchDebugListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.searchbox.fluency.view.FpsOperationProvider.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!FpsOperationProvider.this.canDrawOverLays()) {
                UniversalToast.makeText(AppRuntime.getAppContext(), "请开启浮窗权限！").setDuration(2).showToast();
                return;
            }
            FpsSpUtil.putFpsFloatSwitch(z);
            UniversalToast.makeText(AppRuntime.getAppContext(), "开关已切换，重启生效!").setDuration(2).showToast();
        }
    };

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return "帧率(FPS)监控";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canDrawOverLays() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(AppRuntime.getAppContext());
        }
        return true;
    }

    private List<DebugItemInfo> getGCommunityOperationInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CheckItemInfo("显示FPS浮窗", this.mSwitchDebugListener, Boolean.FALSE));
        return arrayList;
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        return getGCommunityOperationInfo();
    }
}
