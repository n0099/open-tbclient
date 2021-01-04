package com.baidu.tbadk.core.view.spanGroup;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int fqq;
    private int fqr;
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
            if (obj == Selection.SELECTION_END && this.fqr != i3) {
                this.fqr = i3;
                a rA = this.mSpanGroupManager.rA(this.fqr);
                if (rA instanceof TbLinkSpanGroup) {
                    int start = rA.getStart();
                    int end = rA.getEnd();
                    if (Math.abs(this.fqr - end) <= Math.abs(this.fqr - start)) {
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
            if (obj == Selection.SELECTION_START && this.fqq != i3) {
                this.fqq = i3;
                a rA2 = this.mSpanGroupManager.rA(this.fqq);
                if (rA2 instanceof TbLinkSpanGroup) {
                    int start2 = rA2.getStart();
                    int end2 = rA2.getEnd();
                    if (Math.abs(this.fqq - end2) <= Math.abs(this.fqq - start2)) {
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
