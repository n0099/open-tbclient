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
    public static long atH = 0;
    private TextView atI;
    private TextView atJ;
    private TbImageView atK;
    private int atL;
    private Runnable atM;
    private a atN;

    /* loaded from: classes.dex */
    public interface a {
        void bm(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.atL = 3;
        this.atM = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oE());
        b(eVar);
    }

    public void a(a aVar) {
        this.atN = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (AK() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.atK.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.atK.startLoad(null, 10, false);
                this.atK.invalidate();
                z = false;
            }
            this.atI.setText(colorMsg);
            this.atJ.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.atM, j);
            AC().setBackgroundResource(0);
            AB();
            if (this.atN != null) {
                this.atN.bm(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.atM);
    }

    private View oE() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.atK = (TbImageView) inflate.findViewById(e.g.image);
        this.atK.setDefaultBgResource(e.d.transparent);
        this.atK.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.atI = (TextView) inflate.findViewById(e.g.toast_text);
        this.atJ = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.atM);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.atM);
    }

    public void onChangeSkinType(int i) {
        if (i != this.atL) {
            this.atL = i;
            if (this.atK != null) {
                this.atK.invalidate();
            }
            al.h(this.atI, e.d.common_color_10327);
            al.h(this.atJ, e.d.cp_cont_i);
        }
    }

    private boolean AK() {
        return System.currentTimeMillis() - atH <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
