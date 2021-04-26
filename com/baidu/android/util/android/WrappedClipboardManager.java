package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes.dex */
public abstract class WrappedClipboardManager {

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class HoneycombClipboardManager extends WrappedClipboardManager {
        public static ClipData sClipData;
        public static ClipboardManager sInstance;

        @SuppressLint({"ServiceCast"})
        public HoneycombClipboardManager() {
            sInstance = (ClipboardManager) AppRuntime.getAppContext().getSystemService("clipboard");
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public CharSequence getText() {
            try {
                sClipData = sInstance.getPrimaryClip();
            } catch (Exception unused) {
            }
            ClipData clipData = sClipData;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : sClipData.getItemAt(0).getText();
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public boolean hasText() {
            return sInstance.hasPrimaryClip();
        }

        @Override // com.baidu.android.util.android.WrappedClipboardManager
        public void setText(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            sClipData = newPlainText;
            sInstance.setPrimaryClip(newPlainText);
        }
    }

    public static WrappedClipboardManager newInstance(Context context) {
        return new HoneycombClipboardManager();
    }

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charSequence);
}
