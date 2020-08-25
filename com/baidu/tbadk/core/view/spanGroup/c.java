package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
/* loaded from: classes2.dex */
public class c implements SpanWatcher {
    private int exA;
    private int exB;
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
            if (obj == Selection.SELECTION_END && this.exB != i3) {
                this.exB = i3;
                a pi = this.mSpanGroupManager.pi(this.exB);
                if (pi instanceof TbLinkSpanGroup) {
                    int start = pi.getStart();
                    int end = pi.getEnd();
                    if (Math.abs(this.exB - end) <= Math.abs(this.exB - start)) {
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
            if (obj == Selection.SELECTION_START && this.exA != i3) {
                this.exA = i3;
                a pi2 = this.mSpanGroupManager.pi(this.exA);
                if (pi2 instanceof TbLinkSpanGroup) {
                    int start2 = pi2.getStart();
                    int end2 = pi2.getEnd();
                    if (Math.abs(this.exA - end2) <= Math.abs(this.exA - start2)) {
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
