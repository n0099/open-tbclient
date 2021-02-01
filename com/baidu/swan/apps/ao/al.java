package com.baidu.swan.apps.ao;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes9.dex */
public abstract class al {
    protected static Context dPn;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static al dR(Context context) {
        dPn = context.getApplicationContext();
        return c.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes9.dex */
    private static class b extends al {
        private static ClipboardManager dPq = null;

        public b() {
            dPq = (ClipboardManager) dPn.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dPq.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            return dPq.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes9.dex */
    private static class a extends al {
        private static android.content.ClipboardManager dPo = null;
        private static ClipData dPp = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            dPo = (android.content.ClipboardManager) dPn.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dPp = ClipData.newPlainText("text/plain", charSequence);
            try {
                dPo.setPrimaryClip(dPp);
            } catch (RuntimeException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            try {
                dPp = dPo.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (dPp != null && dPp.getItemCount() > 0) {
                return dPp.getItemAt(0).getText();
            }
            return "";
        }
    }
}
