package com.baidu.swan.apps.ao;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes8.dex */
public abstract class al {
    protected static Context dQO;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static al dQ(Context context) {
        dQO = context.getApplicationContext();
        return c.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes8.dex */
    private static class b extends al {
        private static ClipboardManager dQR = null;

        public b() {
            dQR = (ClipboardManager) dQO.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dQR.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            return dQR.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes8.dex */
    private static class a extends al {
        private static android.content.ClipboardManager dQP = null;
        private static ClipData dQQ = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            dQP = (android.content.ClipboardManager) dQO.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dQQ = ClipData.newPlainText("text/plain", charSequence);
            try {
                dQP.setPrimaryClip(dQQ);
            } catch (RuntimeException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            try {
                dQQ = dQP.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (dQQ != null && dQQ.getItemCount() > 0) {
                return dQQ.getItemAt(0).getText();
            }
            return "";
        }
    }
}
