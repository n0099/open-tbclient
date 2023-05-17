package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes4.dex */
public interface IPraiseElementBuilder<RESULT> {
    PreBuildConfig getPreBuildConfig();

    RESULT getResult(FetchConfig fetchConfig);

    void preBuild(PreBuildConfig preBuildConfig);

    /* loaded from: classes4.dex */
    public static class FetchConfig {
        public WeakReference<Drawable.Callback> callback;
        public int canvasHeight;
        public int canvasWidth;
        public int height;
        public int left;
        public String pkgTag;
        public int strategy;
        public String strategyTag;
        public int top;
        public int width;

        public int getCanvasHeight() {
            return this.canvasHeight;
        }

        public int getCanvasWidth() {
            return this.canvasWidth;
        }

        public Drawable.Callback getDrawableCallback() {
            WeakReference<Drawable.Callback> weakReference = this.callback;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public int getHeight() {
            return this.height;
        }

        public int getLeft() {
            return this.left;
        }

        public String getPkgTag() {
            return this.pkgTag;
        }

        public int getStrategy() {
            return this.strategy;
        }

        public String getStrategyTag() {
            return this.strategyTag;
        }

        public int getTop() {
            return this.top;
        }

        public int getWidth() {
            return this.width;
        }

        public FetchConfig setCanvasHeight(int i) {
            this.canvasHeight = i;
            return this;
        }

        public FetchConfig setCanvasWidth(int i) {
            this.canvasWidth = i;
            return this;
        }

        public FetchConfig setDrawableCallback(Drawable.Callback callback) {
            this.callback = new WeakReference<>(callback);
            return this;
        }

        public FetchConfig setHeight(int i) {
            this.height = i;
            return this;
        }

        public FetchConfig setLeft(int i) {
            this.left = i;
            return this;
        }

        public FetchConfig setPkgTag(String str) {
            this.pkgTag = str;
            return this;
        }

        public FetchConfig setStrategy(int i) {
            this.strategy = i;
            return this;
        }

        public FetchConfig setStrategyTag(String str) {
            this.strategyTag = str;
            return this;
        }

        public FetchConfig setTop(int i) {
            this.top = i;
            return this;
        }

        public FetchConfig setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class PreBuildConfig {
        public Map<Integer, Integer> elementCntsMap;
        public WeakReference<IResourceProvider> resourceProvider;

        public Map<Integer, Integer> getElementCntsMap() {
            return this.elementCntsMap;
        }

        public IResourceProvider getResourceProvider() {
            WeakReference<IResourceProvider> weakReference = this.resourceProvider;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public void setElementCntsMap(Map<Integer, Integer> map) {
            this.elementCntsMap = map;
        }

        public PreBuildConfig setResourceProvider(IResourceProvider iResourceProvider) {
            this.resourceProvider = new WeakReference<>(iResourceProvider);
            return this;
        }
    }
}
