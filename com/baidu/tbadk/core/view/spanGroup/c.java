package com.baidu.tbadk.core.view.spanGroup;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int fpA;
    private int fpz;
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
            if (obj == Selection.SELECTION_END && this.fpA != i3) {
                this.fpA = i3;
                a qa = this.mSpanGroupManager.qa(this.fpA);
                if (qa instanceof TbLinkSpanGroup) {
                    int start = qa.getStart();
                    int end = qa.getEnd();
                    if (Math.abs(this.fpA - end) <= Math.abs(this.fpA - start)) {
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
            if (obj == Selection.SELECTION_START && this.fpz != i3) {
                this.fpz = i3;
                a qa2 = this.mSpanGroupManager.qa(this.fpz);
                if (qa2 instanceof TbLinkSpanGroup) {
                    int start2 = qa2.getStart();
                    int end2 = qa2.getEnd();
                    if (Math.abs(this.fpz - end2) <= Math.abs(this.fpz - start2)) {
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
