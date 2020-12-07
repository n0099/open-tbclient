package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView cbK;
    private McnVideoAdView.a cbL = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13404");
                arVar.dY("tid", aVar.tid);
                arVar.dY("fid", aVar.fid);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.al("obj_locate", aVar.cbG);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                ar arVar = new ar("c13405");
                arVar.dY("tid", aVar.tid);
                arVar.dY("fid", aVar.fid);
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.al("obj_locate", aVar.cbG);
                TiebaStatic.log(arVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cbF)) {
                b.abJ().jJ(aVar.cbF);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.cbK = new McnVideoAdView(context);
        this.cbK.setIMcnStatListener(this.cbL);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.cbK != null) {
            this.cbK.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.cbK != null) {
            this.cbK.dismiss();
        }
    }

    public void reset() {
        if (this.cbK != null) {
            this.cbK.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.cbK != null) {
            this.cbK.b(aVar, viewGroup);
        }
    }

    public void abK() {
        if (this.cbK != null) {
            this.cbK.abK();
        }
    }

    public boolean isShowing() {
        if (this.cbK != null) {
            return this.cbK.isShowing();
        }
        return false;
    }
}
