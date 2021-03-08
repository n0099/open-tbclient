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
    private boolean dsN;
    private boolean dtu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.dsN = false;
        aEL();
        aEK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.dsN = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cJ(long j) {
        b(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cK(long j) {
        b(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cL(long j) {
        b(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(long j) {
        b(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void b(int i, long j, String str, String str2) {
        ViewGroup aEI;
        if (!this.dsN && (aEI = aEI()) != null) {
            TextView textView = (TextView) aEI.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(long j, long j2) {
        ViewGroup aEI;
        if (!this.dsN && (aEI = aEI()) != null) {
            ((TextView) aEI.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aEI() {
        ViewGroup viewGroup;
        if (e.aIO() != null && e.aIO().aIH() != null && (viewGroup = (ViewGroup) e.aIO().aIH().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aIO().aIH()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dtu = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aEJ() {
        e aIO = e.aIO();
        if (aIO != null && aIO.aIH() != null) {
            ViewGroup viewGroup = (ViewGroup) aIO.aIH().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dtu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEK() {
        if (!this.dtu) {
            aEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEL() {
        if (this.dtu) {
            aEJ();
        }
    }
}
