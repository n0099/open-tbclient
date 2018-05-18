package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class i extends a {
    private TextView adA;
    private TextView adB;
    private int adC;
    private Runnable adD;
    private ImageView mImageView;

    public i(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.adC = 3;
        this.adD = new Runnable() { // from class: com.baidu.tbadk.core.dialog.i.1
            @Override // java.lang.Runnable
            public void run() {
                i.this.dismiss();
            }
        };
        w(kz());
        b(eVar);
    }

    public void a(ContriInfo contriInfo, long j) {
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            this.adA.setText(contriInfo.getColorMsg());
            this.adB.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.fw().postDelayed(this.adD, j);
            tD().setBackgroundResource(0);
            tC();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.adD);
    }

    private View kz() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.star_idol_layout, (ViewGroup) null);
        this.mImageView = (ImageView) inflate.findViewById(d.g.image);
        this.adA = (TextView) inflate.findViewById(d.g.toast_text);
        this.adB = (TextView) inflate.findViewById(d.g.describe_text);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void dismiss() {
        super.dismiss();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.adD);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.adD);
    }

    public void onChangeSkinType(int i) {
        if (i != this.adC) {
            this.adC = i;
            ak.c(this.mImageView, d.f.pic_frs_idol_mission_tost);
            ak.h(this.adA, d.C0126d.common_color_10327);
            ak.h(this.adB, d.C0126d.cp_cont_i);
        }
    }
}
