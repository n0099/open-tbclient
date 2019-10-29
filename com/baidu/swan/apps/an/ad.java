package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ad {
    protected static Context btK;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ad bW(Context context) {
        btK = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ad {
        private static ClipboardManager btN = null;

        public b() {
            btN = (ClipboardManager) btK.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            btN.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            return btN.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ad {
        private static android.content.ClipboardManager btL = null;
        private static ClipData btM = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            btL = (android.content.ClipboardManager) btK.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            btM = ClipData.newPlainText("text/plain", charSequence);
            btL.setPrimaryClip(btM);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            try {
                btM = btL.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (btM != null && btM.getItemCount() > 0) {
                return btM.getItemAt(0).getText();
            }
            return "";
        }
    }
}
