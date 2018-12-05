package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {
    public static long axh = 0;
    private TextView axi;
    private TextView axj;
    private TbImageView axk;
    private int axl;
    private Runnable axm;
    private a axn;

    /* loaded from: classes.dex */
    public interface a {
        void bn(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.axl = 3;
        this.axm = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oD());
        b(eVar);
    }

    public void a(a aVar) {
        this.axn = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (BO() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.axk.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.axk.startLoad(null, 10, false);
                this.axk.invalidate();
                z = false;
            }
            this.axi.setText(colorMsg);
            this.axj.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.axm, j);
            BG().setBackgroundResource(0);
            BF();
            if (this.axn != null) {
                this.axn.bn(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axm);
    }

    private View oD() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.axk = (TbImageView) inflate.findViewById(e.g.image);
        this.axk.setDefaultBgResource(e.d.transparent);
        this.axk.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.axi = (TextView) inflate.findViewById(e.g.toast_text);
        this.axj = (TextView) inflate.findViewById(e.g.describe_text);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void dismiss() {
        super.dismiss();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axm);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axm);
    }

    public void onChangeSkinType(int i) {
        if (i != this.axl) {
            this.axl = i;
            if (this.axk != null) {
                this.axk.invalidate();
            }
            al.h(this.axi, e.d.common_color_10327);
            al.h(this.axj, e.d.cp_cont_i);
        }
    }

    private boolean BO() {
        return System.currentTimeMillis() - axh <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
