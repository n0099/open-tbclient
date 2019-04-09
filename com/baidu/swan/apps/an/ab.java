package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ab {
    protected static Context aWz;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ab ct(Context context) {
        aWz = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ab {
        private static ClipboardManager aWC = null;

        public b() {
            aWC = (ClipboardManager) aWz.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWC.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            return aWC.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ab {
        private static android.content.ClipboardManager aWA = null;
        private static ClipData aWB = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            aWA = (android.content.ClipboardManager) aWz.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWB = ClipData.newPlainText("text/plain", charSequence);
            aWA.setPrimaryClip(aWB);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            try {
                aWB = aWA.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (aWB != null && aWB.getItemCount() > 0) {
                return aWB.getItemAt(0).getText();
            }
            return "";
        }
    }
}
