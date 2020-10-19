package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
class b {
    private boolean cVI;
    private boolean cVc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.cVc = false;
        azT();
        azS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.cVc = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bF(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bG(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bI(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup azQ;
        if (!this.cVc && (azQ = azQ()) != null) {
            TextView textView = (TextView) azQ.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j, long j2) {
        ViewGroup azQ;
        if (!this.cVc && (azQ = azQ()) != null) {
            ((TextView) azQ.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup azQ() {
        ViewGroup viewGroup;
        if (e.aDb() != null && e.aDb().aCU() != null && (viewGroup = (ViewGroup) e.aDb().aCU().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aDb().aCU()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.cVI = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void azR() {
        e aDb = e.aDb();
        if (aDb != null && aDb.aCU() != null) {
            ViewGroup viewGroup = (ViewGroup) aDb.aCU().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.cVI = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void azS() {
        if (!this.cVI) {
            azQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void azT() {
        if (this.cVI) {
            azR();
        }
    }
}
