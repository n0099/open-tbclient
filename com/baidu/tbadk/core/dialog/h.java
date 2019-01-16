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
    public static long axK = 0;
    private TextView axL;
    private TextView axM;
    private TbImageView axN;
    private int axO;
    private Runnable axP;
    private a axQ;

    /* loaded from: classes.dex */
    public interface a {
        void bo(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.axO = 3;
        this.axP = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oH());
        b(eVar);
    }

    public void a(a aVar) {
        this.axQ = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (Cb() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.axN.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.axN.startLoad(null, 10, false);
                this.axN.invalidate();
                z = false;
            }
            this.axL.setText(colorMsg);
            this.axM.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.axP, j);
            BT().setBackgroundResource(0);
            BS();
            if (this.axQ != null) {
                this.axQ.bo(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axP);
    }

    private View oH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.axN = (TbImageView) inflate.findViewById(e.g.image);
        this.axN.setDefaultBgResource(e.d.transparent);
        this.axN.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.axL = (TextView) inflate.findViewById(e.g.toast_text);
        this.axM = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axP);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axP);
    }

    public void onChangeSkinType(int i) {
        if (i != this.axO) {
            this.axO = i;
            if (this.axN != null) {
                this.axN.invalidate();
            }
            al.h(this.axL, e.d.common_color_10327);
            al.h(this.axM, e.d.cp_cont_i);
        }
    }

    private boolean Cb() {
        return System.currentTimeMillis() - axK <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
