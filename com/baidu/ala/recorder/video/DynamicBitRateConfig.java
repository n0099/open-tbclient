package com.baidu.ala.recorder.video;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DynamicBitRateConfig {
    private static final int MAX_BIT_RATE = 2048000;
    private static final int MAX_FPS = 24;
    private static final int MIN_BIT_RATE = 262144;
    private static final int MIN_FPS = 10;
    public static final int TYPE_HARD = 2;
    public static final int TYPE_RTC = 3;
    public static final int TYPE_SOFT = 1;
    private static final int VIDEO_BITRATE_HARD1 = 1331200;
    private static final int VIDEO_BITRATE_HARD2 = 1228800;
    private static final int VIDEO_BITRATE_HARD3 = 1126400;
    private static final int VIDEO_BITRATE_HARD4 = 1024000;
    private static final int VIDEO_BITRATE_HARD5 = 921600;
    private static final int VIDEO_BITRATE_RTC1 = 512000;
    private static final int VIDEO_BITRATE_RTC2 = 409600;
    private static final int VIDEO_BITRATE_RTC3 = 307200;
    private static final int VIDEO_BITRATE_SOFT1 = 1024000;
    private static final int VIDEO_BITRATE_SOFT2 = 921600;
    private static final int VIDEO_BITRATE_SOFT3 = 819200;
    private static final int VIDEO_BITRATE_SOFT4 = 716800;
    private static final int VIDEO_BITRATE_SOFT5 = 614400;
    private static final int VIDEO_DEFAULT_FPS = 15;
    private List<DynamicBitRateItem> bitrates;
    private double decreaseThreshold;
    private int increaseCount;
    private double increaseThreshold;
    private int index;

    public DynamicBitRateConfig(double d, double d2, int i, List<DynamicBitRateItem> list) {
        this.increaseThreshold = 0.006d;
        this.increaseCount = 3;
        this.decreaseThreshold = 0.3d;
        this.index = 0;
        this.increaseThreshold = d;
        this.decreaseThreshold = d2;
        this.increaseCount = i;
        this.bitrates = list;
    }

    private DynamicBitRateConfig() {
        this.increaseThreshold = 0.006d;
        this.increaseCount = 3;
        this.decreaseThreshold = 0.3d;
        this.index = 0;
    }

    public static DynamicBitRateConfig generateDefaultConfig(int i) {
        DynamicBitRateConfig dynamicBitRateConfig = new DynamicBitRateConfig();
        dynamicBitRateConfig.bitrates = new ArrayList();
        if (i == 3) {
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_RTC1, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_RTC2, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(307200, 15));
        } else if (i == 1) {
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(1024000, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(921600, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_SOFT3, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_SOFT4, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_SOFT5, 15));
        } else {
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_HARD1, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_HARD2, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(VIDEO_BITRATE_HARD3, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(1024000, 15));
            dynamicBitRateConfig.bitrates.add(new DynamicBitRateItem(921600, 15));
        }
        return dynamicBitRateConfig;
    }

    public boolean isValid() {
        return this.increaseThreshold > 0.0d && this.increaseThreshold < 1.0d && this.decreaseThreshold > 0.0d && this.decreaseThreshold < 1.0d && this.increaseCount > 0 && isBitConfValid();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isBitConfValid() {
        if (this.bitrates == null || this.bitrates.size() <= 0) {
            return false;
        }
        for (DynamicBitRateItem dynamicBitRateItem : this.bitrates) {
            if (dynamicBitRateItem == null || dynamicBitRateItem.bitrate < 262144 || dynamicBitRateItem.bitrate > MAX_BIT_RATE || dynamicBitRateItem.fps < 10 || dynamicBitRateItem.fps > 24) {
                return false;
            }
            while (r2.hasNext()) {
            }
        }
        return true;
    }

    public double getIncreaseThreshold() {
        return this.increaseThreshold;
    }

    public int getIncreaseCount() {
        return this.increaseCount;
    }

    public double getDecreaseThreshold() {
        return this.decreaseThreshold;
    }

    public List<DynamicBitRateItem> getBitRates() {
        return this.bitrates;
    }

    public void setIncreaseThreshold(double d) {
        if (d > 0.0d && d < 1.0d) {
            this.increaseThreshold = d;
        }
    }

    public void setIncreaseCount(int i) {
        this.increaseCount = i;
    }

    public void setDecreaseThreshold(double d) {
        if (d > 0.0d && d < 1.0d) {
            this.decreaseThreshold = d;
        }
    }

    public boolean decrease() {
        if (this.index < this.bitrates.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean increase() {
        if (this.index > 0) {
            this.index--;
            return true;
        }
        return false;
    }

    public int getCurrentBitRate() {
        try {
            return this.bitrates.get(this.index).bitrate;
        } catch (Exception e) {
            BdLog.e(e);
            return 400000;
        }
    }

    public int getCurrentFps() {
        try {
            return this.bitrates.get(this.index).fps;
        } catch (Exception e) {
            BdLog.e(e);
            return 15;
        }
    }

    public int getStreamLevelPercent() {
        int size = this.bitrates.size();
        if (size == 0) {
            return 100;
        }
        return (int) Math.round(((size - this.index) * 100.0d) / size);
    }

    public boolean isFirstLevel() {
        return this.index == 0;
    }

    public int getCurrentLevel() {
        return this.index + 1;
    }

    public DynamicBitRateConfig deepCopy() {
        DynamicBitRateConfig dynamicBitRateConfig = new DynamicBitRateConfig();
        dynamicBitRateConfig.increaseThreshold = this.increaseThreshold;
        dynamicBitRateConfig.decreaseThreshold = this.decreaseThreshold;
        dynamicBitRateConfig.increaseCount = this.increaseCount;
        dynamicBitRateConfig.index = this.index;
        dynamicBitRateConfig.bitrates = new ArrayList();
        if (this.bitrates != null) {
            for (DynamicBitRateItem dynamicBitRateItem : this.bitrates) {
                if (dynamicBitRateItem != null) {
                    dynamicBitRateConfig.bitrates.add(dynamicBitRateItem.deepCopy());
                }
            }
        }
        return dynamicBitRateConfig;
    }

    public void resetBitRateItem(List<DynamicBitRateItem> list) {
        this.index = 0;
        this.bitrates = list;
    }

    /* loaded from: classes3.dex */
    public static class DynamicBitRateItem {
        public int bitrate;
        public int fps;

        public DynamicBitRateItem(int i, int i2) {
            this.bitrate = i;
            this.fps = i2;
        }

        public DynamicBitRateItem deepCopy() {
            return new DynamicBitRateItem(this.bitrate, this.fps);
        }
    }
}
