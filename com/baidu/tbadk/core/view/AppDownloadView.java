package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private DownloadData adP;
    public ProgressBar adQ;
    public ImageView adR;
    public TextView adS;
    private final CustomMessageListener downloadListener;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = new a(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = new a(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = new a(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(n.g.app_download_layout, (ViewGroup) this, true);
        this.adQ = (ProgressBar) inflate.findViewById(n.f.frs_app_push_progress);
        this.adR = (ImageView) inflate.findViewById(n.f.frs_app_push_control);
        this.adS = (TextView) inflate.findViewById(n.f.frs_app_push_percent);
    }

    public void a(BdUniqueId bdUniqueId, DownloadData downloadData) {
        if (downloadData != null) {
            this.adP = (DownloadData) downloadData.clone();
            if (this.adP != null) {
                setTag(this.adP);
                a(downloadData);
            }
        }
    }

    private void a(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    as.c(this.adR, n.e.icon_download_play);
                    break;
                case 3:
                    setVisibility(8);
                    break;
                case 5:
                    setVisibility(0);
                    break;
                case 6:
                    setVisibility(8);
                    break;
                case 7:
                    setVisibility(0);
                    as.c(this.adR, n.e.icon_download_pause);
                    break;
            }
            int ai = com.baidu.tbadk.download.b.Bm().ai(downloadData.getId(), downloadData.getName());
            if (ai >= 0) {
                cJ(ai);
            } else {
                cJ(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(int i) {
        int max = Math.max(0, i);
        this.adQ.setProgress(max);
        this.adS.setText(String.valueOf(max) + "%");
    }

    public static int b(DownloadData downloadData) {
        if (com.baidu.tbadk.download.b.Bm().eW(downloadData.getId())) {
            return 3;
        }
        if (com.baidu.tbadk.download.b.Bm().eU(downloadData.getId())) {
            return 5;
        }
        if (com.baidu.tbadk.download.b.Bm().eT(downloadData.getId())) {
            return 1;
        }
        if (!com.baidu.tbadk.download.b.Bm().ak(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
