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
    public static long axL = 0;
    private TextView axM;
    private TextView axN;
    private TbImageView axO;
    private int axP;
    private Runnable axQ;
    private a axR;

    /* loaded from: classes.dex */
    public interface a {
        void bo(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.axP = 3;
        this.axQ = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oH());
        b(eVar);
    }

    public void a(a aVar) {
        this.axR = aVar;
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
                this.axO.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.axO.startLoad(null, 10, false);
                this.axO.invalidate();
                z = false;
            }
            this.axM.setText(colorMsg);
            this.axN.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.axQ, j);
            BT().setBackgroundResource(0);
            BS();
            if (this.axR != null) {
                this.axR.bo(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axQ);
    }

    private View oH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.axO = (TbImageView) inflate.findViewById(e.g.image);
        this.axO.setDefaultBgResource(e.d.transparent);
        this.axO.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.axM = (TextView) inflate.findViewById(e.g.toast_text);
        this.axN = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axQ);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axQ);
    }

    public void onChangeSkinType(int i) {
        if (i != this.axP) {
            this.axP = i;
            if (this.axO != null) {
                this.axO.invalidate();
            }
            al.h(this.axM, e.d.common_color_10327);
            al.h(this.axN, e.d.cp_cont_i);
        }
    }

    private boolean Cb() {
        return System.currentTimeMillis() - axL <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
