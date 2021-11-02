package com.baidu.searchbox.ui;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CustomLinkMovementMethod extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnLinkMovementListener mLinkListener;

    /* loaded from: classes7.dex */
    public interface OnLinkMovementListener {
        void onLinkTouch(TextView textView, MotionEvent motionEvent);

        void onNoLinkTouch(TextView textView, MotionEvent motionEvent);
    }

    public CustomLinkMovementMethod() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, textView, spannable, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                OnLinkMovementListener onLinkMovementListener = this.mLinkListener;
                if (onLinkMovementListener != null) {
                    onLinkMovementListener.onLinkTouch(textView, motionEvent);
                }
                return true;
            }
            OnLinkMovementListener onLinkMovementListener2 = this.mLinkListener;
            if (onLinkMovementListener2 != null) {
                onLinkMovementListener2.onNoLinkTouch(textView, motionEvent);
            }
            Selection.removeSelection(spannable);
            super.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void setLinkMovementListener(OnLinkMovementListener onLinkMovementListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLinkMovementListener) == null) {
            this.mLinkListener = onLinkMovementListener;
        }
    }
}
