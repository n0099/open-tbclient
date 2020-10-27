package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int eUn;
    private int eUo;
    private SpanGroupManager mSpanGroupManager;

    public c(@NonNull SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (this.mSpanGroupManager != null) {
            if (obj == Selection.SELECTION_END && this.eUo != i3) {
                this.eUo = i3;
                a qf = this.mSpanGroupManager.qf(this.eUo);
                if (qf instanceof TbLinkSpanGroup) {
                    int start = qf.getStart();
                    int end = qf.getEnd();
                    if (Math.abs(this.eUo - end) <= Math.abs(this.eUo - start)) {
                        start = end;
                    }
                    int selectionStart = Selection.getSelectionStart(spannable);
                    if (selectionStart > spannable.length()) {
                        selectionStart = spannable.length();
                    }
                    if (start > spannable.length()) {
                        start = spannable.length();
                    }
                    Selection.setSelection(spannable, selectionStart, start);
                }
            }
            if (obj == Selection.SELECTION_START && this.eUn != i3) {
                this.eUn = i3;
                a qf2 = this.mSpanGroupManager.qf(this.eUn);
                if (qf2 instanceof TbLinkSpanGroup) {
                    int start2 = qf2.getStart();
                    int end2 = qf2.getEnd();
                    if (Math.abs(this.eUn - end2) <= Math.abs(this.eUn - start2)) {
                        start2 = end2;
                    }
                    int selectionEnd = Selection.getSelectionEnd(spannable);
                    if (selectionEnd > spannable.length()) {
                        selectionEnd = spannable.length();
                    }
                    if (start2 > spannable.length()) {
                        start2 = spannable.length();
                    }
                    Selection.setSelection(spannable, start2, selectionEnd);
                }
            }
        }
    }
}
