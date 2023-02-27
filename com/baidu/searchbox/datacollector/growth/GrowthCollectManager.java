package com.baidu.searchbox.datacollector.growth;

import android.content.Context;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.datacollector.growth.model.ActiveData;
import com.baidu.searchbox.datacollector.growth.model.ChannelData;
import com.baidu.searchbox.datacollector.growth.model.ClipBoardData;
import com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor;
import com.baidu.searchbox.datacollector.growth.service.LifeCycleHelper;
/* loaded from: classes2.dex */
public class GrowthCollectManager {
    public static volatile boolean hasInit;

    public static void init() {
        if (!hasInit) {
            synchronized (GrowthCollectManager.class) {
                if (!hasInit) {
                    BdBoxActivityManager.registerGlobalLifeCycle(new LifeCycleHelper());
                    hasInit = true;
                }
            }
        }
    }

    public static void statisticActiveData(ActiveData activeData, Context context) {
        GrowthCollectProcessor.getInstance().statisticActiveData(activeData, context);
    }

    public static void statisticChannelData(ChannelData channelData) {
        GrowthCollectProcessor.getInstance().statisticChannelData(channelData);
    }

    public static void statisticClipBoardData(ClipBoardData clipBoardData) {
        GrowthCollectProcessor.getInstance().statisticClipBoardData(clipBoardData);
    }

    public static void statisticDeviceData(Context context) {
        GrowthCollectProcessor.getInstance().statisticDeviceData(context);
    }
}
