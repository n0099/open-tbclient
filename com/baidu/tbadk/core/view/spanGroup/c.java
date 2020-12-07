package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int fgH;
    private int fgI;
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
            if (obj == Selection.SELECTION_END && this.fgI != i3) {
                this.fgI = i3;
                a ro = this.mSpanGroupManager.ro(this.fgI);
                if (ro instanceof TbLinkSpanGroup) {
                    int start = ro.getStart();
                    int end = ro.getEnd();
                    if (Math.abs(this.fgI - end) <= Math.abs(this.fgI - start)) {
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
            if (obj == Selection.SELECTION_START && this.fgH != i3) {
                this.fgH = i3;
                a ro2 = this.mSpanGroupManager.ro(this.fgH);
                if (ro2 instanceof TbLinkSpanGroup) {
                    int start2 = ro2.getStart();
                    int end2 = ro2.getEnd();
                    if (Math.abs(this.fgH - end2) <= Math.abs(this.fgH - start2)) {
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
