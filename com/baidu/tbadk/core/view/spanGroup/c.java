package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int eZk;
    private int eZl;
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
            if (obj == Selection.SELECTION_END && this.eZl != i3) {
                this.eZl = i3;
                a qN = this.mSpanGroupManager.qN(this.eZl);
                if (qN instanceof TbLinkSpanGroup) {
                    int start = qN.getStart();
                    int end = qN.getEnd();
                    if (Math.abs(this.eZl - end) <= Math.abs(this.eZl - start)) {
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
            if (obj == Selection.SELECTION_START && this.eZk != i3) {
                this.eZk = i3;
                a qN2 = this.mSpanGroupManager.qN(this.eZk);
                if (qN2 instanceof TbLinkSpanGroup) {
                    int start2 = qN2.getStart();
                    int end2 = qN2.getEnd();
                    if (Math.abs(this.eZk - end2) <= Math.abs(this.eZk - start2)) {
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
