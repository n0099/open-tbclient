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
    public static long axi = 0;
    private TextView axj;
    private TextView axk;
    private TbImageView axl;
    private int axm;
    private Runnable axn;
    private a axo;

    /* loaded from: classes.dex */
    public interface a {
        void bn(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.axm = 3;
        this.axn = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(oD());
        b(eVar);
    }

    public void a(a aVar) {
        this.axo = aVar;
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
                this.axl.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.axl.startLoad(null, 10, false);
                this.axl.invalidate();
                z = false;
            }
            this.axj.setText(colorMsg);
            this.axk.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.axn, j);
            BG().setBackgroundResource(0);
            BF();
            if (this.axo != null) {
                this.axo.bn(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axn);
    }

    private View oD() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.axl = (TbImageView) inflate.findViewById(e.g.image);
        this.axl.setDefaultBgResource(e.d.transparent);
        this.axl.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.axj = (TextView) inflate.findViewById(e.g.toast_text);
        this.axk = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axn);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.axn);
    }

    public void onChangeSkinType(int i) {
        if (i != this.axm) {
            this.axm = i;
            if (this.axl != null) {
                this.axl.invalidate();
            }
            al.h(this.axj, e.d.common_color_10327);
            al.h(this.axk, e.d.cp_cont_i);
        }
    }

    private boolean BO() {
        return System.currentTimeMillis() - axi <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
