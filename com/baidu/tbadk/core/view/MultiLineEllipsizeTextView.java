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
import c.a.d.f.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MultiLineEllipsizeTextView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f41170f;

    /* renamed from: g  reason: collision with root package name */
    public int f41171g;

    /* renamed from: h  reason: collision with root package name */
    public a f41172h;

    /* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41170f = "...";
    }

    public final List<Point> a(TextPaint textPaint, CharSequence charSequence, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, textPaint, charSequence, i2)) == null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
            int lineCount = staticLayout.getLineCount();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < lineCount; i3++) {
                arrayList.add(new Point(staticLayout.getLineStart(i3), staticLayout.getLineEnd(i3)));
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            CharSequence text = getText();
            Rect rect = new Rect();
            if (k.isEmpty(text.toString())) {
                return;
            }
            TextPaint paint = getPaint();
            if (!k.isEmpty(this.f41170f)) {
                String str = this.f41170f;
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
                float f2 = (measuredWidth - width) - this.f41171g;
                for (float width2 = rect.width(); width2 > f2 && (i4 = point.y) > point.x; width2 = rect.width()) {
                    point.y = i4 - 1;
                    paint.getTextBounds(String.valueOf(text), point.x, point.y, rect);
                }
                if (paint.measureText(((Object) text.subSequence(point.x, point.y)) + this.f41170f) > f2 + width) {
                    point.y--;
                }
                setText(point.y <= 0 ? this.f41170f : ((Object) text.subSequence(0, point.y)) + this.f41170f);
                a aVar = this.f41172h;
                if (aVar != null) {
                    aVar.a(true);
                }
            } else if (getMaxLines() == Integer.MAX_VALUE && this.f41171g != 0) {
                if (!ListUtils.isEmpty(a2)) {
                    Point point2 = a2.get(a2.size() - 1);
                    paint.getTextBounds(String.valueOf(text), point2.x, point2.y, rect);
                    if (rect.width() > measuredWidth - this.f41171g) {
                        setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + rect.height() + getLineSpacingExtra()));
                    }
                }
                a aVar2 = this.f41172h;
                if (aVar2 != null) {
                    aVar2.a(false);
                }
            }
        }
    }

    public void setEllipsisSuffix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f41170f = str;
        }
    }

    public void setIconWidthForLastLine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f41171g = i2;
        }
    }

    public void setOnTextMeasuredCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f41172h = aVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41170f = "...";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLineEllipsizeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41170f = "...";
    }
}
