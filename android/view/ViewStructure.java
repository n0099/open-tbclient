package android.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class ViewStructure {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewStructure() {
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

    public abstract int addChildCount(int i);

    public abstract void asyncCommit();

    public abstract ViewStructure asyncNewChild(int i);

    public abstract int getChildCount();

    public abstract Bundle getExtras();

    public abstract CharSequence getHint();

    public abstract Rect getTempRect();

    public abstract CharSequence getText();

    public abstract int getTextSelectionEnd();

    public abstract int getTextSelectionStart();

    public abstract boolean hasExtras();

    public abstract ViewStructure newChild(int i);

    public abstract void setAccessibilityFocused(boolean z);

    public abstract void setActivated(boolean z);

    public abstract void setAlpha(float f2);

    public abstract void setAssistBlocked(boolean z);

    public abstract void setCheckable(boolean z);

    public abstract void setChecked(boolean z);

    public abstract void setChildCount(int i);

    public abstract void setClassName(String str);

    public abstract void setClickable(boolean z);

    public abstract void setContentDescription(CharSequence charSequence);

    public abstract void setContextClickable(boolean z);

    public abstract void setDimens(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void setElevation(float f2);

    public abstract void setEnabled(boolean z);

    public abstract void setFocusable(boolean z);

    public abstract void setFocused(boolean z);

    public abstract void setHint(CharSequence charSequence);

    public abstract void setId(int i, String str, String str2, String str3);

    public abstract void setLongClickable(boolean z);

    public abstract void setSelected(boolean z);

    public abstract void setText(CharSequence charSequence);

    public abstract void setText(CharSequence charSequence, int i, int i2);

    public abstract void setTextLines(int[] iArr, int[] iArr2);

    public abstract void setTextStyle(float f2, int i, int i2, int i3);

    public abstract void setTransformation(Matrix matrix);

    public abstract void setVisibility(int i);
}
