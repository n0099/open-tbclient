package com.baidu.live.adp.lib.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class GuideBuilder {
    private boolean mBuilt;
    private List<Component> mComponents = new ArrayList();
    private Configuration mConfiguration = new Configuration();
    private OnVisibilityChangedListener mOnVisibilityChangedListener;

    /* loaded from: classes3.dex */
    public interface OnVisibilityChangedListener {
        void onDismiss();

        void onShown();
    }

    public GuideBuilder setAlpha(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i < 0 || i > 255) {
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        this.mConfiguration.mAlpha = i;
        return this;
    }

    public GuideBuilder setTargetView(View view) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (view == null) {
            throw new BuildException("Illegal view.");
        }
        this.mConfiguration.mTargetView = view;
        return this;
    }

    public GuideBuilder setTargetViewId(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.mConfiguration.mTargetViewId = i;
        return this;
    }

    public GuideBuilder setFullingViewId(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal view id.");
        }
        this.mConfiguration.mFullingViewId = i;
        return this;
    }

    public GuideBuilder setFullingColorId(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal color resource id.");
        }
        this.mConfiguration.mFullingColorId = i;
        return this;
    }

    public GuideBuilder setAutoDismiss(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.mConfiguration.mAutoDismiss = z;
        return this;
    }

    public GuideBuilder setOverlayTarget(boolean z) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.mConfiguration.mOverlayTarget = z;
        return this;
    }

    public GuideBuilder setEnterAnimationId(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.mConfiguration.mEnterAnimationId = i;
        return this;
    }

    public GuideBuilder setExitAnimationId(int i) {
        if (this.mBuilt) {
            throw new BuildException("Already created. rebuild a new one.");
        }
        if (i <= 0) {
            throw new BuildException("Illegal animation resource id.");
        }
        this.mConfiguration.mExitAnimationId = i;
        return this;
    }

    public GuideBuilder addComponent(Component component) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.mComponents.add(component);
        return this;
    }

    public GuideBuilder setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        if (this.mBuilt) {
            throw new BuildException("Already created, rebuild a new one.");
        }
        this.mOnVisibilityChangedListener = onVisibilityChangedListener;
        return this;
    }

    public GuideBuilder setOutsideTouchable(boolean z) {
        this.mConfiguration.mOutsideTouchable = z;
        return this;
    }

    public Guide createGuide() {
        Guide guide = new Guide();
        guide.setComponents((Component[]) this.mComponents.toArray(new Component[this.mComponents.size()]));
        guide.setConfiguration(this.mConfiguration);
        guide.setCallback(this.mOnVisibilityChangedListener);
        this.mComponents = null;
        this.mConfiguration = null;
        this.mOnVisibilityChangedListener = null;
        this.mBuilt = true;
        return guide;
    }
}
