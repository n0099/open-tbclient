package com.baidu.searchbox.ng.ai.apps.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class AiAppWrappedClipboardManager {
    protected static Context sTheApp;

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charSequence);

    public static AiAppWrappedClipboardManager newInstance(Context context) {
        sTheApp = context.getApplicationContext();
        return AiAppAPIUtils.hasHoneycomb() ? new HoneycombClipboardManager() : new OldClipboardManager();
    }

    /* loaded from: classes2.dex */
    private static class OldClipboardManager extends AiAppWrappedClipboardManager {
        private static ClipboardManager sInstance = null;

        public OldClipboardManager() {
            sInstance = (ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public void setText(CharSequence charSequence) {
            sInstance.setText(charSequence);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public boolean hasText() {
            return sInstance.hasText();
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public CharSequence getText() {
            return sInstance.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class HoneycombClipboardManager extends AiAppWrappedClipboardManager {
        private static android.content.ClipboardManager sInstance = null;
        private static ClipData sClipData = null;

        @SuppressLint({"ServiceCast"})
        public HoneycombClipboardManager() {
            sInstance = (android.content.ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public void setText(CharSequence charSequence) {
            sClipData = ClipData.newPlainText("text/plain", charSequence);
            sInstance.setPrimaryClip(sClipData);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public boolean hasText() {
            return sInstance.hasPrimaryClip();
        }

        @Override // com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager
        public CharSequence getText() {
            try {
                sClipData = sInstance.getPrimaryClip();
            } catch (Exception e) {
            }
            return (sClipData == null || sClipData.getItemCount() <= 0) ? "" : sClipData.getItemAt(0).getText();
        }
    }
}
