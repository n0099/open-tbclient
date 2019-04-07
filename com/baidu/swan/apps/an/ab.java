package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ab {
    protected static Context aWy;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ab ct(Context context) {
        aWy = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ab {
        private static ClipboardManager aWB = null;

        public b() {
            aWB = (ClipboardManager) aWy.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWB.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            return aWB.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ab {
        private static android.content.ClipboardManager aWz = null;
        private static ClipData aWA = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            aWz = (android.content.ClipboardManager) aWy.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWA = ClipData.newPlainText("text/plain", charSequence);
            aWz.setPrimaryClip(aWA);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            try {
                aWA = aWz.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (aWA != null && aWA.getItemCount() > 0) {
                return aWA.getItemAt(0).getText();
            }
            return "";
        }
    }
}
