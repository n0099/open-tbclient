package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
/* loaded from: classes.dex */
public class WebSettingsAdapter {
    public WebSettingsBoundaryInterface mBoundaryInterface;

    public WebSettingsAdapter(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.mBoundaryInterface = webSettingsBoundaryInterface;
    }

    public int getDisabledActionModeMenuItems() {
        return this.mBoundaryInterface.getDisabledActionModeMenuItems();
    }

    public boolean getOffscreenPreRaster() {
        return this.mBoundaryInterface.getOffscreenPreRaster();
    }

    public boolean getSafeBrowsingEnabled() {
        return this.mBoundaryInterface.getSafeBrowsingEnabled();
    }

    public void setDisabledActionModeMenuItems(int i2) {
        this.mBoundaryInterface.setDisabledActionModeMenuItems(i2);
    }

    public void setOffscreenPreRaster(boolean z) {
        this.mBoundaryInterface.setOffscreenPreRaster(z);
    }

    public void setSafeBrowsingEnabled(boolean z) {
        this.mBoundaryInterface.setSafeBrowsingEnabled(z);
    }
}
