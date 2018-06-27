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
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {
    public static long alY = 0;
    private TextView alZ;
    private TextView ama;
    private TbImageView amb;
    private int amc;
    private Runnable amd;
    private a ame;

    /* loaded from: classes.dex */
    public interface a {
        void aE(boolean z);
    }

    public h(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.amc = 3;
        this.amd = new Runnable() { // from class: com.baidu.tbadk.core.dialog.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.dismiss();
            }
        };
        w(nn());
        b(eVar);
    }

    public void a(a aVar) {
        this.ame = aVar;
    }

    public void a(ContriInfo contriInfo, long j) {
        boolean z;
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            String colorMsg = contriInfo.getColorMsg();
            if (xx() && !StringUtils.isNull(contriInfo.getPreColorMsg()) && !StringUtils.isNull(contriInfo.getToastBackImage()) && colorMsg != null) {
                colorMsg = contriInfo.getPreColorMsg() + colorMsg;
                this.amb.startLoad(contriInfo.getToastBackImage(), 10, false);
                z = true;
            } else {
                this.amb.startLoad(null, 10, false);
                this.amb.invalidate();
                z = false;
            }
            this.alZ.setText(colorMsg);
            this.ama.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.im().postDelayed(this.amd, j);
            xo().setBackgroundResource(0);
            xn();
            if (this.ame != null) {
                this.ame.aE(z);
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.amd);
    }

    private View nn() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.star_idol_layout, (ViewGroup) null);
        this.amb = (TbImageView) inflate.findViewById(d.g.image);
        this.amb.setDefaultBgResource(d.C0142d.transparent);
        this.amb.setDefaultResource(d.f.pic_frs_idol_mission_tost);
        this.alZ = (TextView) inflate.findViewById(d.g.toast_text);
        this.ama = (TextView) inflate.findViewById(d.g.describe_text);
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
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.amd);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.amd);
    }

    public void onChangeSkinType(int i) {
        if (i != this.amc) {
            this.amc = i;
            if (this.amb != null) {
                this.amb.invalidate();
            }
            am.h(this.alZ, d.C0142d.common_color_10327);
            am.h(this.ama, d.C0142d.cp_cont_i);
        }
    }

    private boolean xx() {
        return System.currentTimeMillis() - alY <= 600000;
    }
}
