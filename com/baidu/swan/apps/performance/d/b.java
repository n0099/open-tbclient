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
    private boolean ddC;
    private boolean dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.ddC = false;
        aBN();
        aBM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.ddC = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bI(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bK(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aBK;
        if (!this.ddC && (aBK = aBK()) != null) {
            TextView textView = (TextView) aBK.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j, long j2) {
        ViewGroup aBK;
        if (!this.ddC && (aBK = aBK()) != null) {
            ((TextView) aBK.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aBK() {
        ViewGroup viewGroup;
        if (e.aEV() != null && e.aEV().aEO() != null && (viewGroup = (ViewGroup) e.aEV().aEO().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aEV().aEO()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dei = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aBL() {
        e aEV = e.aEV();
        if (aEV != null && aEV.aEO() != null) {
            ViewGroup viewGroup = (ViewGroup) aEV.aEO().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dei = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aBM() {
        if (!this.dei) {
            aBK();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aBN() {
        if (this.dei) {
            aBL();
        }
    }
}
