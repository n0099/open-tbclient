package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes.dex */
class b extends DisplayManagerCompat {
    private final WindowManager mWindowManager;

    public b(Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display getDisplay(int i) {
        Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == i) {
            return defaultDisplay;
        }
        return null;
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display[] getDisplays() {
        return new Display[]{this.mWindowManager.getDefaultDisplay()};
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display[] getDisplays(String str) {
        return str == null ? getDisplays() : new Display[0];
    }
}
