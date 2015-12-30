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
    private DownloadData aeu;
    public ProgressBar aev;
    public ImageView aew;
    public TextView aex;
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
        View inflate = LayoutInflater.from(context).inflate(n.h.app_download_layout, (ViewGroup) this, true);
        this.aev = (ProgressBar) inflate.findViewById(n.g.frs_app_push_progress);
        this.aew = (ImageView) inflate.findViewById(n.g.frs_app_push_control);
        this.aex = (TextView) inflate.findViewById(n.g.frs_app_push_percent);
    }

    public void a(BdUniqueId bdUniqueId, DownloadData downloadData) {
        if (downloadData != null) {
            this.aeu = (DownloadData) downloadData.clone();
            if (this.aeu != null) {
                setTag(this.aeu);
                a(downloadData);
            }
        }
    }

    private void a(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    as.c(this.aew, n.f.icon_download_play);
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
                    as.c(this.aew, n.f.icon_download_pause);
                    break;
            }
            int ah = com.baidu.tbadk.download.b.Bb().ah(downloadData.getId(), downloadData.getName());
            if (ah >= 0) {
                cC(ah);
            } else {
                cC(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(int i) {
        int max = Math.max(0, i);
        this.aev.setProgress(max);
        this.aex.setText(String.valueOf(max) + "%");
    }

    public static int b(DownloadData downloadData) {
        if (com.baidu.tbadk.download.b.Bb().fa(downloadData.getId())) {
            return 3;
        }
        if (com.baidu.tbadk.download.b.Bb().eY(downloadData.getId())) {
            return 5;
        }
        if (com.baidu.tbadk.download.b.Bb().eX(downloadData.getId())) {
            return 1;
        }
        if (!com.baidu.tbadk.download.b.Bb().aj(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
