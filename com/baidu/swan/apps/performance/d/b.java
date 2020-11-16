package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes7.dex */
class b {
    private boolean dhO;
    private boolean dix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.dhO = false;
        aDF();
        aDE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.dhO = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cf(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cg(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aDC;
        if (!this.dhO && (aDC = aDC()) != null) {
            TextView textView = (TextView) aDC.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(long j, long j2) {
        ViewGroup aDC;
        if (!this.dhO && (aDC = aDC()) != null) {
            ((TextView) aDC.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aDC() {
        ViewGroup viewGroup;
        if (e.aGN() != null && e.aGN().aGG() != null && (viewGroup = (ViewGroup) e.aGN().aGG().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aGN().aGG()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dix = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aDD() {
        e aGN = e.aGN();
        if (aGN != null && aGN.aGG() != null) {
            ViewGroup viewGroup = (ViewGroup) aGN.aGG().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dix = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDE() {
        if (!this.dix) {
            aDC();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDF() {
        if (this.dix) {
            aDD();
        }
    }
}
