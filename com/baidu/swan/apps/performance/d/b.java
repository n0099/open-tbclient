package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes3.dex */
class b {
    private boolean cIZ;
    private boolean cJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.cIZ = false;
        axi();
        axh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.cIZ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bx(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void by(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bz(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bA(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup axf;
        if (!this.cIZ && (axf = axf()) != null) {
            TextView textView = (TextView) axf.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j, long j2) {
        ViewGroup axf;
        if (!this.cIZ && (axf = axf()) != null) {
            ((TextView) axf.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup axf() {
        ViewGroup viewGroup;
        if (e.aAs() != null && e.aAs().aAl() != null && (viewGroup = (ViewGroup) e.aAs().aAl().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aAs().aAl()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.cJF = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void axg() {
        e aAs = e.aAs();
        if (aAs != null && aAs.aAl() != null) {
            ViewGroup viewGroup = (ViewGroup) aAs.aAl().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.cJF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void axh() {
        if (!this.cJF) {
            axf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void axi() {
        if (this.cJF) {
            axg();
        }
    }
}
