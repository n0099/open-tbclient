package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {
    public static long aly = 0;
    private TextView alA;
    private TbImageView alB;
    private int alC;
    private Runnable alD;
    private a alE;
    private TextView alz;

    /* loaded from: classes.dex */
    public interface a {
        void aC(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.alC = 3;
        this.alD = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        w(np());
        b(eVar);
    }

    public void a(a aVar) {
        this.alE = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (xp() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.alB.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.alB.startLoad(null, 10, false);
                this.alB.invalidate();
                z = false;
            }
            this.alz.setText(colorMsg);
            this.alA.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.in().postDelayed(this.alD, j);
            xg().setBackgroundResource(0);
            xf();
            if (this.alE != null) {
                this.alE.aC(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alD);
    }

    private View np() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.star_idol_layout, (ViewGroup) null);
        this.alB = (TbImageView) inflate.findViewById(d.g.image);
        this.alB.setDefaultBgResource(d.C0140d.transparent);
        this.alB.setDefaultResource(d.f.pic_frs_idol_mission_tost);
        this.alz = (TextView) inflate.findViewById(d.g.toast_text);
        this.alA = (TextView) inflate.findViewById(d.g.describe_text);
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
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alD);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alD);
    }

    public void onChangeSkinType(int i) {
        if (i != this.alC) {
            this.alC = i;
            if (this.alB != null) {
                this.alB.invalidate();
            }
            am.h(this.alz, d.C0140d.common_color_10327);
            am.h(this.alA, d.C0140d.cp_cont_i);
        }
    }

    private boolean xp() {
        return System.currentTimeMillis() - aly <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
