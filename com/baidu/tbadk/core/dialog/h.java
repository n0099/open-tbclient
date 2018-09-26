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
    public static long aoc = 0;
    private TextView aod;
    private TextView aoe;
    private TbImageView aof;
    private int aog;
    private Runnable aoh;
    private a aoi;

    /* loaded from: classes.dex */
    public interface a {
        void aM(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.aog = 3;
        this.aoh = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        G(ov());
        b(eVar);
    }

    public void a(a aVar) {
        this.aoi = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (yv() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.aof.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.aof.startLoad(null, 10, false);
                this.aof.invalidate();
                z = false;
            }
            this.aod.setText(colorMsg);
            this.aoe.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.jt().postDelayed(this.aoh, j);
            ym().setBackgroundResource(0);
            yl();
            if (this.aoi != null) {
                this.aoi.aM(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aoh);
    }

    private View ov() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.star_idol_layout, (ViewGroup) null);
        this.aof = (TbImageView) inflate.findViewById(e.g.image);
        this.aof.setDefaultBgResource(e.d.transparent);
        this.aof.setDefaultResource(e.f.pic_frs_idol_mission_tost);
        this.aod = (TextView) inflate.findViewById(e.g.toast_text);
        this.aoe = (TextView) inflate.findViewById(e.g.describe_text);
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
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aoh);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aoh);
    }

    public void onChangeSkinType(int i) {
        if (i != this.aog) {
            this.aog = i;
            if (this.aof != null) {
                this.aof.invalidate();
            }
            al.h(this.aod, e.d.common_color_10327);
            al.h(this.aoe, e.d.cp_cont_i);
        }
    }

    private boolean yv() {
        return System.currentTimeMillis() - aoc <= KeepJobService.JOB_CHECK_PERIODIC;
    }
}
