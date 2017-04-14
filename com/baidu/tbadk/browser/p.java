package com.baidu.tbadk.browser;

import android.net.Uri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements bb.a {
    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean a;
        boolean a2;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        String str = strArr[0];
        String str2 = null;
        if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#") || str.startsWith("https://tieba.baidu.com/mo/q/blitz/index#")) {
            int indexOf = str.indexOf("page/", 0) + "page/".length();
            int indexOf2 = str.indexOf("?", 0);
            if (indexOf > "page/".length() && indexOf2 > indexOf) {
                str2 = str.substring(indexOf, indexOf2);
            }
            if (indexOf2 > -1) {
                a = i.a(tbPageContext, Uri.parse("tieba://lego?" + str.substring(indexOf2 + 1)), str2, false);
                return a ? 0 : 3;
            }
            return 3;
        } else if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) {
            int indexOf3 = str.indexOf("page/", 0) + "page/".length();
            int indexOf4 = str.indexOf("?", 0);
            if (indexOf3 > "page/".length() && indexOf4 > indexOf3) {
                str2 = str.substring(indexOf3, indexOf4);
            }
            if (indexOf4 > -1) {
                a2 = i.a(tbPageContext, Uri.parse("tieba://lego?" + str.substring(indexOf4 + 1)), str2, true);
                return a2 ? 0 : 3;
            }
            return 3;
        } else {
            return 3;
        }
    }
}
