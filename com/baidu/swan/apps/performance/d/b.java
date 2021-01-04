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
    private boolean dtP;
    private boolean duv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.dtP = false;
        aIg();
        aIf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.dtP = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cD(long j) {
        b(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cE(long j) {
        b(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cF(long j) {
        b(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cG(long j) {
        b(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void b(int i, long j, String str, String str2) {
        ViewGroup aId;
        if (!this.dtP && (aId = aId()) != null) {
            TextView textView = (TextView) aId.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(long j, long j2) {
        ViewGroup aId;
        if (!this.dtP && (aId = aId()) != null) {
            ((TextView) aId.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aId() {
        ViewGroup viewGroup;
        if (e.aMl() != null && e.aMl().aMe() != null && (viewGroup = (ViewGroup) e.aMl().aMe().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aMl().aMe()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.duv = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aIe() {
        e aMl = e.aMl();
        if (aMl != null && aMl.aMe() != null) {
            ViewGroup viewGroup = (ViewGroup) aMl.aMe().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.duv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIf() {
        if (!this.duv) {
            aId();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIg() {
        if (this.duv) {
            aIe();
        }
    }
}
