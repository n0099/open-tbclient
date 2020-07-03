package com.baidu.mcn;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class c {
    private McnVideoAdView btQ;
    private McnVideoAdView.a btR = new McnVideoAdView.a() { // from class: com.baidu.mcn.c.1
        @Override // com.baidu.mcn.McnVideoAdView.a
        public void a(a aVar) {
            if (aVar != null) {
                ao aoVar = new ao("c13404");
                aoVar.dk("tid", aVar.tid);
                aoVar.dk("fid", aVar.fid);
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar.ag("obj_locate", aVar.btM);
                TiebaStatic.log(aoVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void b(a aVar) {
            if (aVar != null) {
                ao aoVar = new ao("c13405");
                aoVar.dk("tid", aVar.tid);
                aoVar.dk("fid", aVar.fid);
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar.ag("obj_locate", aVar.btM);
                TiebaStatic.log(aoVar);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.a
        public void c(a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.btL)) {
                b.MG().gn(aVar.btL);
            }
        }
    };
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
        this.btQ = new McnVideoAdView(context);
        this.btQ.setIMcnStatListener(this.btR);
    }

    public void a(a aVar, ViewGroup viewGroup) {
        if (this.btQ != null) {
            this.btQ.a(aVar, viewGroup);
        }
    }

    public void dismiss() {
        if (this.btQ != null) {
            this.btQ.dismiss();
        }
    }

    public void reset() {
        if (this.btQ != null) {
            this.btQ.reset();
        }
    }

    public void b(a aVar, ViewGroup viewGroup) {
        if (this.btQ != null) {
            this.btQ.b(aVar, viewGroup);
        }
    }

    public void MH() {
        if (this.btQ != null) {
            this.btQ.MH();
        }
    }

    public boolean isShowing() {
        if (this.btQ != null) {
            return this.btQ.isShowing();
        }
        return false;
    }
}
