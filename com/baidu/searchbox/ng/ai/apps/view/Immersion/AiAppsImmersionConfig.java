package com.baidu.searchbox.ng.ai.apps.view.Immersion;
/* loaded from: classes2.dex */
public class AiAppsImmersionConfig {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsImmersionConfig";
    public int customStatusBarViewBg;
    public boolean isOccupyStatusBar;
    public boolean isShowNavBar;
    public boolean isShowStatusBar;
    public int statusBarColor;
    public boolean useLightStatusBar;

    private AiAppsImmersionConfig() {
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean isOccupyStatusBar = false;

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setStatusBarColor(int i) {
            this.statusBarColor = i;
            return this;
        }

        public Builder setCustomStatusBarViewBg(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public Builder showNavBar(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public Builder useLightStatusBar(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public Builder showStatusBar(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public Builder occupyStatusBar(boolean z) {
            this.isOccupyStatusBar = z;
            return this;
        }

        public AiAppsImmersionConfig build() {
            AiAppsImmersionConfig aiAppsImmersionConfig = new AiAppsImmersionConfig();
            aiAppsImmersionConfig.customStatusBarViewBg = this.customStatBarViewBg;
            aiAppsImmersionConfig.isShowNavBar = this.isShowNavBar;
            aiAppsImmersionConfig.isShowStatusBar = this.isShowStatBar;
            aiAppsImmersionConfig.useLightStatusBar = this.useLightStatBar;
            aiAppsImmersionConfig.statusBarColor = this.statusBarColor;
            aiAppsImmersionConfig.isOccupyStatusBar = this.isOccupyStatusBar;
            return aiAppsImmersionConfig;
        }
    }
}
