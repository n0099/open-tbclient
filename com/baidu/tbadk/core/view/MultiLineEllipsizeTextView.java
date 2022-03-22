package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiLineEllipsizeTextView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f30027b;

    /* renamed from: c  reason: collision with root package name */
    public int f30028c;

    /* renamed from: d  reason: collision with root package name */
    public a f30029d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLineEllipsizeTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30027b = StringHelper.STRING_MORE;
    }

    public final List<Point> a(TextPaint textPaint, CharSequence charSequence, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, textPaint, charSequence, i)) == null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
            int lineCount = staticLayout.getLineCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < lineCount; i2++) {
                arrayList.add(new Point(staticLayout.getLineStart(i2), staticLayout.getLineEnd(i2)));
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.onMeasure(i, i2);
            CharSequence text = getText();
            Rect rect = new Rect();
            if (m.isEmpty(text.toString())) {
                return;
            }
            TextPaint paint = getPaint();
            if (!m.isEmpty(this.f30027b)) {
                String str = this.f30027b;
                paint.getTextBounds(str, 0, str.length() - 1, rect);
            }
            float width = rect.width();
            float paddingRight = getPaddingRight() + getPaddingLeft();
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables.length == 4) {
                if (compoundDrawables[0] != null) {
                    paddingRight += compoundDrawables[0].getBounds().width() + getCompoundDrawablePadding();
                }
                if (compoundDrawables[2] != null) {
                    paddingRight += compoundDrawables[2].getBounds().width() + getCompoundDrawablePadding();
                }
            }
            float measuredWidth = getMeasuredWidth() - paddingRight;
            List<Point> a2 = a(paint, text, (int) measuredWidth);
            if (ListUtils.getCount(a2) > getMaxLines()) {
                Point point = a2.get(getMaxLines() - 1);
                text.toString();
                paint.getTextBounds(String.valueOf(text), point.x, point.y, rect);
                float f2 = (measuredWidth - width) - this.f30028c;
                for (float width2 = rect.width(); width2 > f2 && (i3 = point.y) > point.x; width2 = rect.width()) {
                    point.y = i3 - 1;
                    paint.getTextBounds(String.valueOf(text), point.x, point.y, rect);
                }
                if (paint.measureText(((Object) text.subSequence(point.x, point.y)) + this.f30027b) > f2 + width) {
                    point.y--;
                }
                setText(point.y <= 0 ? this.f30027b : ((Object) text.subSequence(0, point.y)) + this.f30027b);
                a aVar = this.f30029d;
                if (aVar != null) {
                    aVar.a(true);
                }
            } else if (getMaxLines() == Integer.MAX_VALUE && this.f30028c != 0) {
                if (!ListUtils.isEmpty(a2)) {
                    Point point2 = a2.get(a2.size() - 1);
                    paint.getTextBounds(String.valueOf(text), point2.x, point2.y, rect);
                    if (rect.width() > measuredWidth - this.f30028c) {
                        setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + rect.height() + getLineSpacingExtra()));
                    }
                }
                a aVar2 = this.f30029d;
                if (aVar2 != null) {
                    aVar2.a(false);
                }
            }
        }
    }

    public void setEllipsisSuffix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f30027b = str;
        }
    }

    public void setIconWidthForLastLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f30028c = i;
        }
    }

    public void setOnTextMeasuredCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f30029d = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30027b = StringHelper.STRING_MORE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30027b = StringHelper.STRING_MORE;
    }
}
