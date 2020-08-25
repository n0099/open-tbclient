package com.baidu.pass.permissions;

import android.content.Context;
/* loaded from: classes4.dex */
public class PermissionsDTO implements com.baidu.pass.a {
    public Context context;
    public String dialogMsg;
    public String dialogTitle;
    public boolean isDarkMode;
    public String[] permissions;
    public String okBtnTxt = "继续";
    public String cancleBtnTxt = "关闭";
    public boolean showExplainDialogAfterForbid = true;
}
