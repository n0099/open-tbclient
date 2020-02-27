package com.baidu.searchbox.ugc.webjs;

import android.text.TextUtils;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class IconsInfo implements Serializable {
    public String enable;
    public String msg;

    public boolean needShowErrorMsg() {
        return TextUtils.equals(this.enable, "0") && !TextUtils.isEmpty(this.msg);
    }
}
