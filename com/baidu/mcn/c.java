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
    private McnVideoAdView aeY;
    private McnVideoAdView.a aeZ = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                am amVar = new am("c13404");
                amVar.bJ("tid", aVar.tid);
                amVar.bJ(ImageViewerConfig.FORUM_ID, aVar.fid);
                amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.T("obj_locate", aVar.aeT);
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
                amVar.T("obj_locate", aVar.aeT);
                TiebaStatic.log(amVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.aeS)) {
                b.sX().cS(aVar.aeS);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.aeY = new McnVideoAdView(context);
        this.aeY.setIMcnStatListener(this.aeZ);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.aeY != null) {
            this.aeY.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.aeY != null) {
            this.aeY.dismiss();
        }
    }

    public void reset() {
        if (this.aeY != null) {
            this.aeY.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.aeY != null) {
            this.aeY.b(aVar, viewGroup);
        }
    }

    public void sY() {
        if (this.aeY != null) {
            this.aeY.sY();
        }
    }

    public boolean isShowing() {
        if (this.aeY != null) {
            return this.aeY.isShowing();
        }
        return false;
    }
}
