package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes9.dex */
class b {
    private boolean drR;
    private boolean drk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.drk = false;
        aEI();
        aEH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.drk = true;
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
        ViewGroup aEF;
        if (!this.drk && (aEF = aEF()) != null) {
            TextView textView = (TextView) aEF.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(long j, long j2) {
        ViewGroup aEF;
        if (!this.drk && (aEF = aEF()) != null) {
            ((TextView) aEF.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aEF() {
        ViewGroup viewGroup;
        if (e.aIL() != null && e.aIL().aIE() != null && (viewGroup = (ViewGroup) e.aIL().aIE().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aIL().aIE()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.drR = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aEG() {
        e aIL = e.aIL();
        if (aIL != null && aIL.aIE() != null) {
            ViewGroup viewGroup = (ViewGroup) aIL.aIE().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.drR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEH() {
        if (!this.drR) {
            aEF();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEI() {
        if (this.drR) {
            aEG();
        }
    }
}
