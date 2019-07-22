package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ad {
    protected static Context ban;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ad bW(Context context) {
        ban = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ad {
        private static ClipboardManager baq = null;

        public b() {
            baq = (ClipboardManager) ban.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            baq.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            return baq.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ad {
        private static android.content.ClipboardManager bao = null;
        private static ClipData bap = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            bao = (android.content.ClipboardManager) ban.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            bap = ClipData.newPlainText("text/plain", charSequence);
            bao.setPrimaryClip(bap);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            try {
                bap = bao.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (bap != null && bap.getItemCount() > 0) {
                return bap.getItemAt(0).getText();
            }
            return "";
        }
    }
}
