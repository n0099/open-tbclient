package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes9.dex */
public interface IPraiseElementBuilder<RESULT> {
    PreBuildConfig getPreBuildConfig();

    RESULT getResult(FetchConfig fetchConfig);

    void preBuild(PreBuildConfig preBuildConfig);

    /* loaded from: classes9.dex */
    public static class PreBuildConfig {
        private Map<Integer, Integer> elementCntsMap;
        private WeakReference<IResourceProvider> resourceProvider;

        public IResourceProvider getResourceProvider() {
            if (this.resourceProvider == null) {
                return null;
            }
            return this.resourceProvider.get();
        }

        public PreBuildConfig setResourceProvider(IResourceProvider iResourceProvider) {
            this.resourceProvider = new WeakReference<>(iResourceProvider);
            return this;
        }

        public Map<Integer, Integer> getElementCntsMap() {
            return this.elementCntsMap;
        }

        public void setElementCntsMap(Map<Integer, Integer> map) {
            this.elementCntsMap = map;
        }
    }

    /* loaded from: classes9.dex */
    public static class FetchConfig {
        private WeakReference<Drawable.Callback> callback;
        private int canvasHeight;
        private int canvasWidth;
        private int height;
        private int left;
        private String pkgTag;
        private int strategy;
        private String strategyTag;
        private int top;
        private int width;

        public int getLeft() {
            return this.left;
        }

        public FetchConfig setLeft(int i) {
            this.left = i;
            return this;
        }

        public int getTop() {
            return this.top;
        }

        public FetchConfig setTop(int i) {
            this.top = i;
            return this;
        }

        public int getWidth() {
            return this.width;
        }

        public FetchConfig setWidth(int i) {
            this.width = i;
            return this;
        }

        public int getHeight() {
            return this.height;
        }

        public FetchConfig setHeight(int i) {
            this.height = i;
            return this;
        }

        public Drawable.Callback getDrawableCallback() {
            if (this.callback == null) {
                return null;
            }
            return this.callback.get();
        }

        public FetchConfig setDrawableCallback(Drawable.Callback callback) {
            this.callback = new WeakReference<>(callback);
            return this;
        }

        public String getStrategyTag() {
            return this.strategyTag;
        }

        public FetchConfig setStrategyTag(String str) {
            this.strategyTag = str;
            return this;
        }

        public int getStrategy() {
            return this.strategy;
        }

        public FetchConfig setStrategy(int i) {
            this.strategy = i;
            return this;
        }

        public int getCanvasWidth() {
            return this.canvasWidth;
        }

        public FetchConfig setCanvasWidth(int i) {
            this.canvasWidth = i;
            return this;
        }

        public int getCanvasHeight() {
            return this.canvasHeight;
        }

        public FetchConfig setCanvasHeight(int i) {
            this.canvasHeight = i;
            return this;
        }

        public String getPkgTag() {
            return this.pkgTag;
        }

        public FetchConfig setPkgTag(String str) {
            this.pkgTag = str;
            return this;
        }
    }
}
