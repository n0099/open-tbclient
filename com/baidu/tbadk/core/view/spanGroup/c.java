package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int ehl;
    private int ehm;
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
            if (obj == Selection.SELECTION_END && this.ehm != i3) {
                this.ehm = i3;
                a mJ = this.mSpanGroupManager.mJ(this.ehm);
                if (mJ instanceof TbLinkSpanGroup) {
                    int start = mJ.getStart();
                    int end = mJ.getEnd();
                    if (Math.abs(this.ehm - end) <= Math.abs(this.ehm - start)) {
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
            if (obj == Selection.SELECTION_START && this.ehl != i3) {
                this.ehl = i3;
                a mJ2 = this.mSpanGroupManager.mJ(this.ehl);
                if (mJ2 instanceof TbLinkSpanGroup) {
                    int start2 = mJ2.getStart();
                    int end2 = mJ2.getEnd();
                    if (Math.abs(this.ehl - end2) <= Math.abs(this.ehl - start2)) {
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
