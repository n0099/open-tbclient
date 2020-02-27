package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
/* loaded from: classes13.dex */
public abstract class WrappedClipboardManager {
    protected static Context sTheApp;

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charSequence);

    public static WrappedClipboardManager newInstance(Context context) {
        sTheApp = context.getApplicationContext();
        return Build.VERSION.SDK_INT >= 11 ? new HoneycombClipboardManager() : new OldClipboardManager();
    }

    /* loaded from: classes13.dex */
    private static class OldClipboardManager extends WrappedClipboardManager {
        private static ClipboardManager sInstance = null;

        public OldClipboardManager() {
            sInstance = (ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public void setText(CharSequence charSequence) {
            sInstance.setText(charSequence);
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public boolean hasText() {
            return sInstance.hasText();
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public CharSequence getText() {
            return sInstance.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes13.dex */
    private static class HoneycombClipboardManager extends WrappedClipboardManager {
        private static android.content.ClipboardManager sInstance = null;
        private static ClipData sClipData = null;

        @SuppressLint({"ServiceCast"})
        public HoneycombClipboardManager() {
            sInstance = (android.content.ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public void setText(CharSequence charSequence) {
            sClipData = ClipData.newPlainText("text/plain", charSequence);
            sInstance.setPrimaryClip(sClipData);
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public boolean hasText() {
            return sInstance.hasPrimaryClip();
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public CharSequence getText() {
            try {
                sClipData = sInstance.getPrimaryClip();
            } catch (Exception e) {
            }
            return (sClipData == null || sClipData.getItemCount() <= 0) ? "" : sClipData.getItemAt(0).getText();
        }
    }
}
