package com.baidu.live.tbadk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"WrongCall"})
@Deprecated
/* loaded from: classes7.dex */
public class TbListTextView extends TextView {
    private boolean checkSelection;

    public TbListTextView(Context context) {
        super(context);
        this.checkSelection = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.checkSelection = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkSelection = true;
    }

    public void setCheckSelection(boolean z) {
        this.checkSelection = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.checkSelection) {
            return super.onTouchEvent(motionEvent);
        }
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            fixOnMeasure(i, i2);
        }
    }

    private void fixOnMeasure(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            fixSpannedWithSpaces(new SpannableStringBuilder(text), i, i2);
        } else {
            fallbackToString(i, i2);
        }
    }

    private void fixSpannedWithSpaces(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        FixingResult addSpacesAroundSpansUntilFixed = addSpacesAroundSpansUntilFixed(spannableStringBuilder, i, i2);
        if (addSpacesAroundSpansUntilFixed.isFixed) {
            removeUnneededSpaces(i, i2, spannableStringBuilder, addSpacesAroundSpansUntilFixed);
        } else {
            fallbackToString(i, i2);
        }
    }

    private FixingResult addSpacesAroundSpansUntilFixed(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (isNotSpace(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (isNotSpace(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                setTextAndMeasure(spannableStringBuilder, i, i2);
                return FixingResult.fixed(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                BdLog.e(e.getMessage());
            }
        }
        return FixingResult.notFixed();
    }

    private boolean isNotSpace(CharSequence charSequence, int i) {
        return charSequence == null || i < 0 || i >= charSequence.length() || charSequence.charAt(i) != ' ';
    }

    private void setTextAndMeasure(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    private void removeUnneededSpaces(int i, int i2, SpannableStringBuilder spannableStringBuilder, FixingResult fixingResult) {
        for (Object obj : fixingResult.spansWithSpacesAfter) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                setTextAndMeasure(spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        boolean z = true;
        for (Object obj2 : fixingResult.spansWithSpacesBefore) {
            int spanStart = spannableStringBuilder.getSpanStart(obj2);
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                setTextAndMeasure(spannableStringBuilder, i, i2);
                z = false;
            } catch (IndexOutOfBoundsException e2) {
                spannableStringBuilder.insert(spanStart - 1, " ");
                z = true;
            }
        }
        if (z) {
            setText(spannableStringBuilder);
            super.onMeasure(i, i2);
        }
    }

    private void fallbackToString(int i, int i2) {
        setTextAndMeasure(getText().toString(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class FixingResult {
        public final boolean isFixed;
        public final List<Object> spansWithSpacesAfter;
        public final List<Object> spansWithSpacesBefore;

        public static FixingResult fixed(List<Object> list, List<Object> list2) {
            return new FixingResult(true, list, list2);
        }

        public static FixingResult notFixed() {
            return new FixingResult(false, null, null);
        }

        private FixingResult(boolean z, List<Object> list, List<Object> list2) {
            this.isFixed = z;
            this.spansWithSpacesBefore = list;
            this.spansWithSpacesAfter = list2;
        }
    }
}
