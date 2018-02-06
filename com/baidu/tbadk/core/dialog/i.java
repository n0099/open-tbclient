package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.ContriInfo;
/* loaded from: classes.dex */
public class i extends a {
    private TextView aSn;
    private TextView aSo;
    private int aSp;
    private Runnable aSq;
    private ImageView mImageView;

    public i(com.baidu.adp.base.e<?> eVar) {
        super(eVar.getPageActivity());
        this.aSp = 3;
        this.aSq = new Runnable() { // from class: com.baidu.tbadk.core.dialog.i.1
            @Override // java.lang.Runnable
            public void run() {
                i.this.dismiss();
            }
        };
        aO(st());
        b(eVar);
    }

    public void a(ContriInfo contriInfo, long j) {
        if (contriInfo != null) {
            if (j <= 0) {
                j = 3000;
            }
            this.aSn.setText(contriInfo.getColorMsg());
            this.aSo.setText(contriInfo.getAfterMsg());
            com.baidu.adp.lib.g.e.ns().postDelayed(this.aSq, j);
            AV().setBackgroundResource(0);
            AU();
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.aSq);
    }

    private View st() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.star_idol_layout, (ViewGroup) null);
        this.mImageView = (ImageView) inflate.findViewById(d.g.image);
        this.aSn = (TextView) inflate.findViewById(d.g.toast_text);
        this.aSo = (TextView) inflate.findViewById(d.g.describe_text);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void dismiss() {
        super.dismiss();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.aSq);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public void hide() {
        super.hide();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.aSq);
    }

    public void onChangeSkinType(int i) {
        if (i != this.aSp) {
            this.aSp = i;
            aj.c(this.mImageView, d.f.pic_frs_idol_mission_tost);
            aj.r(this.aSn, d.C0140d.common_color_10327);
            aj.r(this.aSo, d.C0140d.cp_cont_i);
        }
    }
}
