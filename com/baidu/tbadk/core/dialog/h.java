package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {
    public static long alx = 0;
    private TbImageView alA;
    private int alB;
    private Runnable alC;
    private a alD;
    private TextView aly;
    private TextView alz;

    /* loaded from: classes.dex */
    public interface a {
        void aD(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.alB = 3;
        this.alC = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        w(np());
        b(eVar);
    }

    public void a(a aVar) {
        this.alD = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (xo() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.alA.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.alA.startLoad(null, 10, false);
                this.alA.invalidate();
                z = false;
            }
            this.aly.setText(colorMsg);
            this.alz.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.in().postDelayed(this.alC, j);
            xf().setBackgroundResource(0);
            xe();
            if (this.alD != null) {
                this.alD.aD(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alC);
    }

    private View np() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(f.h.star_idol_layout, (ViewGroup) null);
        this.alA = (TbImageView) inflate.findViewById(f.g.image);
        this.alA.setDefaultBgResource(f.d.transparent);
        this.alA.setDefaultResource(f.C0146f.pic_frs_idol_mission_tost);
        this.aly = (TextView) inflate.findViewById(f.g.toast_text);
        this.alz = (TextView) inflate.findViewById(f.g.describe_text);
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
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alC);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.alC);
    }

    public void onChangeSkinType(int i) {
        if (i != this.alB) {
            this.alB = i;
            if (this.alA != null) {
                this.alA.invalidate();
            }
            am.h(this.aly, f.d.common_color_10327);
            am.h(this.alz, f.d.cp_cont_i);
        }
    }

    private boolean xo() {
        return System.currentTimeMillis() - alx <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
