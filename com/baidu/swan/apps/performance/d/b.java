package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes8.dex */
class b {
    private boolean cGZ;
    private boolean cHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.cGZ = false;
        awz();
        awy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.cGZ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bw(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bx(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void by(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bz(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aww;
        if (!this.cGZ && (aww = aww()) != null) {
            TextView textView = (TextView) aww.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(long j, long j2) {
        ViewGroup aww;
        if (!this.cGZ && (aww = aww()) != null) {
            ((TextView) aww.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aww() {
        ViewGroup viewGroup;
        if (e.azJ() != null && e.azJ().azC() != null && (viewGroup = (ViewGroup) e.azJ().azC().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.azJ().azC()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.cHF = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void awx() {
        e azJ = e.azJ();
        if (azJ != null && azJ.azC() != null) {
            ViewGroup viewGroup = (ViewGroup) azJ.azC().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.cHF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void awy() {
        if (!this.cHF) {
            aww();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void awz() {
        if (this.cHF) {
            awx();
        }
    }
}
