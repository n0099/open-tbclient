package com.baidu.searchbox.ui.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BdLinkTouchDecorHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ITouchableSpan mTouchableSpan;

    public BdLinkTouchDecorHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private ITouchableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, textView, spannable, motionEvent)) == null) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            Layout layout = textView.getLayout();
            int lineForVertical = layout.getLineForVertical(y + textView.getScrollY());
            float f = scrollX;
            if (f >= layout.getLineLeft(lineForVertical) && f <= layout.getLineRight(lineForVertical)) {
                i = layout.getOffsetForHorizontal(lineForVertical, f);
            } else {
                i = -1;
            }
            ITouchableSpan[] iTouchableSpanArr = (ITouchableSpan[]) spannable.getSpans(i, i, ITouchableSpan.class);
            if (iTouchableSpanArr.length <= 0) {
                return null;
            }
            return iTouchableSpanArr[0];
        }
        return (ITouchableSpan) invokeLLL.objValue;
    }

    private void updatePressStatus(ITouchableSpan iTouchableSpan, TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, iTouchableSpan, textView, z) == null) {
            if (iTouchableSpan != null) {
                iTouchableSpan.setPressed(z);
            }
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).onSpanSetPressed(z);
            }
        }
    }

    public void clearSpanState(@Nullable TextView textView) {
        ITouchableSpan iTouchableSpan;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, textView) == null) && (iTouchableSpan = this.mTouchableSpan) != null && textView != null) {
            updatePressStatus(iTouchableSpan, textView, false);
        }
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, spannable, motionEvent)) == null) {
            boolean z3 = true;
            if (motionEvent.getAction() == 0) {
                ITouchableSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
                this.mTouchableSpan = pressedSpan;
                if (pressedSpan != null) {
                    updatePressStatus(pressedSpan, textView, true);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.mTouchableSpan), spannable.getSpanEnd(this.mTouchableSpan));
                }
                if (textView instanceof ISpanTouchFix) {
                    ISpanTouchFix iSpanTouchFix = (ISpanTouchFix) textView;
                    if (this.mTouchableSpan != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    iSpanTouchFix.setTouchSpanHit(z2);
                }
                if (this.mTouchableSpan != null) {
                    return true;
                }
                return false;
            } else if (motionEvent.getAction() == 2) {
                ITouchableSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
                ITouchableSpan iTouchableSpan = this.mTouchableSpan;
                if (iTouchableSpan != null && pressedSpan2 != iTouchableSpan) {
                    updatePressStatus(iTouchableSpan, textView, false);
                    this.mTouchableSpan = null;
                    Selection.removeSelection(spannable);
                }
                if (textView instanceof ISpanTouchFix) {
                    ISpanTouchFix iSpanTouchFix2 = (ISpanTouchFix) textView;
                    if (this.mTouchableSpan != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iSpanTouchFix2.setTouchSpanHit(z);
                }
                if (this.mTouchableSpan != null) {
                    return true;
                }
                return false;
            } else if (motionEvent.getAction() == 1) {
                ITouchableSpan iTouchableSpan2 = this.mTouchableSpan;
                if (iTouchableSpan2 != null) {
                    updatePressStatus(iTouchableSpan2, textView, false);
                    this.mTouchableSpan.onClick(textView);
                } else {
                    z3 = false;
                }
                this.mTouchableSpan = null;
                Selection.removeSelection(spannable);
                if (textView instanceof ISpanTouchFix) {
                    ((ISpanTouchFix) textView).setTouchSpanHit(z3);
                }
                return z3;
            } else {
                ITouchableSpan iTouchableSpan3 = this.mTouchableSpan;
                if (iTouchableSpan3 != null) {
                    updatePressStatus(iTouchableSpan3, textView, false);
                }
                if (textView instanceof ISpanTouchFix) {
                    ((ISpanTouchFix) textView).setTouchSpanHit(false);
                }
                Selection.removeSelection(spannable);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
