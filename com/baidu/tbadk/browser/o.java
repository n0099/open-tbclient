package com.baidu.tbadk.browser;

import android.net.Uri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements bg.a {
    @Override // com.baidu.tbadk.core.util.bg.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean a;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        String str = strArr[0];
        String str2 = null;
        if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#")) {
            int indexOf = str.indexOf("page/", 0) + "page/".length();
            int indexOf2 = str.indexOf("?", 0);
            if (indexOf > "page/".length() && indexOf2 > indexOf) {
                str2 = str.substring(indexOf, indexOf2);
            }
            if (indexOf2 > -1) {
                a = Static.a(tbPageContext, Uri.parse("tieba://lego?" + str.substring(indexOf2 + 1)), str2);
                return !a ? 3 : 0;
            }
            return 3;
        }
        return 3;
    }
}
