package com.baidu.searchbox.ugc.emoji.edittextrule;

import android.text.Editable;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public interface IEditTextPatternRule {
    void afterTextChanged(Editable editable);

    void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

    Pattern getMatchPattern();

    boolean onDelete();

    void onSelectionChanged(int i, int i2);

    void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
}
