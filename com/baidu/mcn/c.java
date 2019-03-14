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
    private McnVideoAdView aeS;
    private McnVideoAdView.a aeT = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13404");
                amVar.bJ("tid", aVar.tid);
                amVar.bJ(ImageViewerConfig.FORUM_ID, aVar.fid);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.T("obj_locate", aVar.aeN);
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
                amVar.T("obj_locate", aVar.aeN);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aeM)) {
                b.sY().cQ(aVar.aeM);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aeS = new McnVideoAdView(context);
        this.aeS.setIMcnStatListener(this.aeT);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aeS != null) {
            this.aeS.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aeS != null) {
            this.aeS.dismiss();
        }
    }

    public void reset() {
        if (this.aeS != null) {
            this.aeS.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aeS != null) {
            this.aeS.b(aVar, viewGroup);
        }
    }

    public void sZ() {
        if (this.aeS != null) {
            this.aeS.sZ();
        }
    }

    public boolean isShowing() {
        if (this.aeS != null) {
            return this.aeS.isShowing();
        }
        return false;
    }
}
