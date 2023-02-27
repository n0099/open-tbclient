package com.baidu.searchbox.debug.data;

import android.widget.CompoundButton;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/debug/data/CheckItemInfo;", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getCheckedChangeListener", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "", "isChecked", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Landroid/widget/CompoundButton$OnCheckedChangeListener;Ljava/lang/Boolean;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class CheckItemInfo extends DebugItemInfo {
    public CompoundButton.OnCheckedChangeListener checkedChangeListener;
    public String content;
    public final Boolean isChecked;

    public CheckItemInfo(String str, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, Boolean bool) {
        super(null, ViewType.CHECKBOX_VIEW);
        this.content = str;
        this.checkedChangeListener = onCheckedChangeListener;
        this.isChecked = bool;
    }

    public final CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.checkedChangeListener;
    }

    public final String getContent() {
        return this.content;
    }

    public final Boolean isChecked() {
        return this.isChecked;
    }

    public final void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.checkedChangeListener = onCheckedChangeListener;
    }

    public final void setContent(String str) {
        this.content = str;
    }
}
