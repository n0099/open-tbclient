package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int fac;
    private int fad;
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
            if (obj == Selection.SELECTION_END && this.fad != i3) {
                this.fad = i3;
                a qp = this.mSpanGroupManager.qp(this.fad);
                if (qp instanceof TbLinkSpanGroup) {
                    int start = qp.getStart();
                    int end = qp.getEnd();
                    if (Math.abs(this.fad - end) <= Math.abs(this.fad - start)) {
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
            if (obj == Selection.SELECTION_START && this.fac != i3) {
                this.fac = i3;
                a qp2 = this.mSpanGroupManager.qp(this.fac);
                if (qp2 instanceof TbLinkSpanGroup) {
                    int start2 = qp2.getStart();
                    int end2 = qp2.getEnd();
                    if (Math.abs(this.fac - end2) <= Math.abs(this.fac - start2)) {
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
