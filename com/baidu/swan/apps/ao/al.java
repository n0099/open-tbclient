package com.baidu.swan.apps.ao;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes8.dex */
public abstract class al {
    protected static Context dNh;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static al dS(Context context) {
        dNh = context.getApplicationContext();
        return c.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes8.dex */
    private static class b extends al {
        private static ClipboardManager dNk = null;

        public b() {
            dNk = (ClipboardManager) dNh.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dNk.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            return dNk.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes8.dex */
    private static class a extends al {
        private static android.content.ClipboardManager dNi = null;
        private static ClipData dNj = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            dNi = (android.content.ClipboardManager) dNh.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dNj = ClipData.newPlainText("text/plain", charSequence);
            try {
                dNi.setPrimaryClip(dNj);
            } catch (RuntimeException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            try {
                dNj = dNi.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (dNj != null && dNj.getItemCount() > 0) {
                return dNj.getItemAt(0).getText();
            }
            return "";
        }
    }
}
