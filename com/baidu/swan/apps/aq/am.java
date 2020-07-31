package com.baidu.swan.apps.aq;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes7.dex */
public abstract class am {
    protected static Context sTheApp;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static am cJ(Context context) {
        sTheApp = context.getApplicationContext();
        return c.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes7.dex */
    private static class b extends am {
        private static ClipboardManager sInstance = null;

        public b() {
            sInstance = (ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.aq.am
        public void setText(CharSequence charSequence) {
            sInstance.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.aq.am
        public CharSequence getText() {
            return sInstance.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes7.dex */
    private static class a extends am {
        private static android.content.ClipboardManager sInstance = null;
        private static ClipData sClipData = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            sInstance = (android.content.ClipboardManager) sTheApp.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.aq.am
        public void setText(CharSequence charSequence) {
            sClipData = ClipData.newPlainText("text/plain", charSequence);
            try {
                sInstance.setPrimaryClip(sClipData);
            } catch (RuntimeException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.swan.apps.aq.am
        public CharSequence getText() {
            try {
                sClipData = sInstance.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (sClipData != null && sClipData.getItemCount() > 0) {
                return sClipData.getItemAt(0).getText();
            }
            return "";
        }
    }
}
