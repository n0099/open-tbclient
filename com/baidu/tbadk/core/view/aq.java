package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayoutNew amU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ThreadCommentAndPraiseInfoLayoutNew threadCommentAndPraiseInfoLayoutNew) {
        this.amU = threadCommentAndPraiseInfoLayoutNew;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.amU.ams;
        String str = (String) com.baidu.tbadk.core.util.z.c(list, i);
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
            tbPageContext = this.amU.ajP;
            vP.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
