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
    public static long asU = 0;
    private TextView asV;
    private TextView asW;
    private TbImageView asX;
    private int asY;
    private Runnable asZ;
    private a ata;

    /* loaded from: classes.dex */
    public interface a {
        void aW(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.asY = 3;
        this.asZ = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oG());
        b(eVar);
    }

    public void a(a aVar) {
        this.ata = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (AD() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.asX.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.asX.startLoad(null, 10, false);
                this.asX.invalidate();
                z = false;
            }
            this.asV.setText(colorMsg);
            this.asW.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jI().postDelayed(this.asZ, j);
            Av().setBackgroundResource(0);
            Au();
            if (this.ata != null) {
                this.ata.aW(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.asZ);
    }

    private View oG() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.asX = (TbImageView) inflate.findViewById(e.g.image);
        this.asX.setDefaultBgResource(e.d.transparent);
        this.asX.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.asV = (TextView) inflate.findViewById(e.g.toast_text);
        this.asW = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.asZ);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.asZ);
    }

    public void onChangeSkinType(int i) {
        if (i != this.asY) {
            this.asY = i;
            if (this.asX != null) {
                this.asX.invalidate();
            }
            al.h(this.asV, e.d.common_color_10327);
            al.h(this.asW, e.d.cp_cont_i);
        }
    }

    private boolean AD() {
        return System.currentTimeMillis() - asU <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
