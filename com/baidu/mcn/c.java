package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView aeR;
    private McnVideoAdView.a aeS = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13404");
                amVar.bJ("tid", aVar.tid);
                amVar.bJ(ImageViewerConfig.FORUM_ID, aVar.fid);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.T("obj_locate", aVar.aeM);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13405");
                amVar.bJ("tid", aVar.tid);
                amVar.bJ(ImageViewerConfig.FORUM_ID, aVar.fid);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.T("obj_locate", aVar.aeM);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aeL)) {
                b.sY().cQ(aVar.aeL);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aeR = new McnVideoAdView(context);
        this.aeR.setIMcnStatListener(this.aeS);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aeR != null) {
            this.aeR.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aeR != null) {
            this.aeR.dismiss();
        }
    }

    public void reset() {
        if (this.aeR != null) {
            this.aeR.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aeR != null) {
            this.aeR.b(aVar, viewGroup);
        }
    }

    public void sZ() {
        if (this.aeR != null) {
            this.aeR.sZ();
        }
    }

    public boolean isShowing() {
        if (this.aeR != null) {
            return this.aeR.isShowing();
        }
        return false;
    }
}
