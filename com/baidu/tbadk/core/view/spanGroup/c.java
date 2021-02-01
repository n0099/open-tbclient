package com.baidu.tbadk.core.view.spanGroup;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class c implements SpanWatcher {
    private int fnY;
    private int fnZ;
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
            if (obj == Selection.SELECTION_END && this.fnZ != i3) {
                this.fnZ = i3;
                a pZ = this.mSpanGroupManager.pZ(this.fnZ);
                if (pZ instanceof TbLinkSpanGroup) {
                    int start = pZ.getStart();
                    int end = pZ.getEnd();
                    if (Math.abs(this.fnZ - end) <= Math.abs(this.fnZ - start)) {
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
            if (obj == Selection.SELECTION_START && this.fnY != i3) {
                this.fnY = i3;
                a pZ2 = this.mSpanGroupManager.pZ(this.fnY);
                if (pZ2 instanceof TbLinkSpanGroup) {
                    int start2 = pZ2.getStart();
                    int end2 = pZ2.getEnd();
                    if (Math.abs(this.fnY - end2) <= Math.abs(this.fnY - start2)) {
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
