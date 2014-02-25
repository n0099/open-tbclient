package com;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class av implements TextWatcher {
    final /* synthetic */ ShareDialog a;

    public av(ShareDialog shareDialog) {
        this.a = shareDialog;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.a.a(this.a.mMaxLength - editable.length());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
