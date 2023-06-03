package com.baidu.searchbox.schemedispatch.monitor;

import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public interface IFromCheck {
    SchemeCheckInfo checkSchemeInFromWhiteList(String str, String str2, String str3);

    ArrayList<String> getFromKeyList();
}
