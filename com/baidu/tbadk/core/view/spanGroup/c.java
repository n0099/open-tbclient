package com.baidu.tbadk.core.view.spanGroup;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int flG;
    private int flH;
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
            if (obj == Selection.SELECTION_END && this.flH != i3) {
                this.flH = i3;
                a pU = this.mSpanGroupManager.pU(this.flH);
                if (pU instanceof TbLinkSpanGroup) {
                    int start = pU.getStart();
                    int end = pU.getEnd();
                    if (Math.abs(this.flH - end) <= Math.abs(this.flH - start)) {
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
            if (obj == Selection.SELECTION_START && this.flG != i3) {
                this.flG = i3;
                a pU2 = this.mSpanGroupManager.pU(this.flG);
                if (pU2 instanceof TbLinkSpanGroup) {
                    int start2 = pU2.getStart();
                    int end2 = pU2.getEnd();
                    if (Math.abs(this.flG - end2) <= Math.abs(this.flG - start2)) {
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
