package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AutoChangeLineView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int H;
    public static final int I;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> A;
    public ArrayList<Integer> B;
    public int C;
    public c D;
    public d E;
    public e F;
    public f G;

    /* renamed from: e  reason: collision with root package name */
    public Context f40300e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f40301f;

    /* renamed from: g  reason: collision with root package name */
    public float f40302g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f40303h;

    /* renamed from: i  reason: collision with root package name */
    public int f40304i;

    /* renamed from: j  reason: collision with root package name */
    public int f40305j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public SelectType r;
    public int s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ArrayList<Object> z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SelectType {
        public static final /* synthetic */ SelectType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SelectType MULTI;
        public static final SelectType NONE;
        public static final SelectType SINGLE;
        public static final SelectType SINGLE_IRREVOCABLY;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-136988202, "Lcom/baidu/tbadk/core/view/AutoChangeLineView$SelectType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-136988202, "Lcom/baidu/tbadk/core/view/AutoChangeLineView$SelectType;");
                    return;
                }
            }
            NONE = new SelectType(PolyActivity.NONE_PANEL_TYPE, 0, 1);
            SINGLE = new SelectType("SINGLE", 1, 2);
            SINGLE_IRREVOCABLY = new SelectType("SINGLE_IRREVOCABLY", 2, 3);
            SelectType selectType = new SelectType("MULTI", 3, 4);
            MULTI = selectType;
            $VALUES = new SelectType[]{NONE, SINGLE, SINGLE_IRREVOCABLY, selectType};
        }

        public SelectType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static SelectType get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return NONE;
                            }
                            return MULTI;
                        }
                        return SINGLE_IRREVOCABLY;
                    }
                    return SINGLE;
                }
                return NONE;
            }
            return (SelectType) invokeI.objValue;
        }

        public static SelectType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SelectType) Enum.valueOf(SelectType.class, str) : (SelectType) invokeL.objValue;
        }

        public static SelectType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SelectType[]) $VALUES.clone() : (SelectType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoChangeLineView a;

        public a(AutoChangeLineView autoChangeLineView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoChangeLineView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = autoChangeLineView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i2, str)) == null) ? str.trim() : (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        CharSequence a(TextView textView, int i2, T t);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void onLabelClick(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes11.dex */
    public interface d {
        boolean a(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void a(TextView textView, Object obj, boolean z, int i2);
    }

    /* loaded from: classes11.dex */
    public interface f {
        boolean a(TextView textView, Object obj, boolean z, boolean z2, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1637517158, "Lcom/baidu/tbadk/core/view/AutoChangeLineView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1637517158, "Lcom/baidu/tbadk/core/view/AutoChangeLineView;");
                return;
            }
        }
        H = R.id.tag_key_data;
        I = R.id.tag_key_position;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoChangeLineView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40304i = -2;
        this.f40305j = -2;
        this.k = 0;
        this.w = false;
        this.x = false;
        this.z = new ArrayList<>();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.f40300e = context;
    }

    public final <T> void a(T t, int i2, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, t, i2, bVar) == null) {
            EMTextView eMTextView = new EMTextView(this.f40300e);
            eMTextView.setPadding(this.l, this.m, this.n, this.o);
            eMTextView.setTextSize(0, this.f40302g);
            eMTextView.setGravity(this.k);
            eMTextView.setTextColor(this.f40301f);
            eMTextView.setBackgroundDrawable(this.f40303h.getConstantState().newDrawable());
            eMTextView.setTag(H, t);
            eMTextView.setTag(I, Integer.valueOf(i2));
            eMTextView.setOnClickListener(this);
            eMTextView.setOnLongClickListener(this);
            eMTextView.getPaint().setFakeBoldText(this.x);
            addView(eMTextView, this.f40304i, this.f40305j);
            eMTextView.setText(bVar.a(eMTextView, i2, t));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int childCount = getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!this.B.contains(Integer.valueOf(i2))) {
                    k((TextView) getChildAt(i2), false);
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            this.A.removeAll(arrayList);
        }
    }

    public final int c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) ? (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics()) : invokeF.intValue;
    }

    public void clearAllSelect() {
        SelectType selectType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (selectType = this.r) == SelectType.SINGLE_IRREVOCABLY) {
            return;
        }
        if (selectType == SelectType.MULTI && !this.B.isEmpty()) {
            b();
        } else {
            f();
        }
    }

    public void clearCompulsorys() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.r == SelectType.MULTI && !this.B.isEmpty()) {
            this.B.clear();
            f();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setClickable((this.D == null && this.E == null && this.r == SelectType.NONE) ? false : true);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoChangeLineView);
        this.r = SelectType.get(obtainStyledAttributes.getInt(R$styleable.AutoChangeLineView_selectType, 1));
        this.s = obtainStyledAttributes.getInteger(R$styleable.AutoChangeLineView_maxSelect, 0);
        this.t = obtainStyledAttributes.getInteger(R$styleable.AutoChangeLineView_minSelect, 0);
        this.u = obtainStyledAttributes.getInteger(R$styleable.AutoChangeLineView_maxLines, 0);
        this.v = obtainStyledAttributes.getInteger(R$styleable.AutoChangeLineView_maxColumns, 0);
        this.y = obtainStyledAttributes.getBoolean(R$styleable.AutoChangeLineView_isIndicator, false);
        this.k = obtainStyledAttributes.getInt(R$styleable.AutoChangeLineView_labelGravity, this.k);
        this.f40304i = obtainStyledAttributes.getLayoutDimension(R$styleable.AutoChangeLineView_labelTextWidth, this.f40304i);
        this.f40305j = obtainStyledAttributes.getLayoutDimension(R$styleable.AutoChangeLineView_labelTextHeight, this.f40305j);
        if (obtainStyledAttributes.hasValue(R$styleable.AutoChangeLineView_labelTextColor)) {
            this.f40301f = obtainStyledAttributes.getColorStateList(R$styleable.AutoChangeLineView_labelTextColor);
        } else {
            this.f40301f = ColorStateList.valueOf(-16777216);
        }
        this.f40302g = obtainStyledAttributes.getDimension(R$styleable.AutoChangeLineView_labelTextSize, l(14.0f));
        if (obtainStyledAttributes.hasValue(R$styleable.AutoChangeLineView_labelTextPadding)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_labelTextPadding, 0);
            this.o = dimensionPixelOffset;
            this.n = dimensionPixelOffset;
            this.m = dimensionPixelOffset;
            this.l = dimensionPixelOffset;
        } else {
            this.l = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_labelTextPaddingLeft, c(10.0f));
            this.m = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_labelTextPaddingTop, c(0.0f));
            this.n = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_labelTextPaddingRight, c(10.0f));
            this.o = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_labelTextPaddingBottom, c(0.0f));
        }
        this.q = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_lineMargin, c(5.0f));
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.AutoChangeLineView_wordMargin, c(5.0f));
        if (obtainStyledAttributes.hasValue(R$styleable.AutoChangeLineView_labelBackground)) {
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.AutoChangeLineView_labelBackground, 0);
            if (resourceId != 0) {
                this.f40303h = getResources().getDrawable(resourceId);
            } else {
                this.f40303h = new ColorDrawable(obtainStyledAttributes.getColor(R$styleable.AutoChangeLineView_labelBackground, 0));
            }
        } else {
            this.f40303h = getResources().getDrawable(R.drawable.bg_default_tag);
        }
        this.w = obtainStyledAttributes.getBoolean(R$styleable.AutoChangeLineView_singleLine, false);
        this.x = obtainStyledAttributes.getBoolean(R$styleable.AutoChangeLineView_isTextBold, false);
        obtainStyledAttributes.recycle();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                k((TextView) getChildAt(i2), false);
            }
            this.A.clear();
        }
    }

    public final void g(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            int childCount = getChildCount();
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 1;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                measureChild(childAt, i2, i3);
                if (childAt.getMeasuredWidth() + i5 > size || ((i4 = this.v) > 0 && i6 == i4)) {
                    i10++;
                    int i12 = this.u;
                    if (i12 > 0 && i10 > i12) {
                        i10--;
                        break;
                    }
                    i8 = i8 + this.q + i7;
                    i9 = Math.max(i9, i5);
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                }
                i5 += childAt.getMeasuredWidth();
                i6++;
                i7 = Math.max(i7, childAt.getMeasuredHeight());
                if (i11 != childCount - 1) {
                    int i13 = this.p;
                    if (i5 + i13 > size) {
                        i10++;
                        int i14 = this.u;
                        if (i14 > 0 && i10 > i14) {
                            i10--;
                            break;
                        }
                        i8 = i8 + this.q + i7;
                        i9 = Math.max(i9, i5);
                        i5 = 0;
                        i6 = 0;
                        i7 = 0;
                    } else {
                        i5 += i13;
                    }
                }
            }
            setMeasuredDimension(i(i2, Math.max(i9, i5) + getPaddingLeft() + getPaddingRight()), i(i3, i8 + i7 + getPaddingTop() + getPaddingBottom()));
            this.C = childCount > 0 ? i10 : 0;
        }
    }

    public List<Integer> getCompulsorys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public int getLabelGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }

    public ColorStateList getLabelTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40301f : (ColorStateList) invokeV.objValue;
    }

    public float getLabelTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40302g : invokeV.floatValue;
    }

    public <T> List<T> getLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public int getLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.C : invokeV.intValue;
    }

    public int getMaxColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.v : invokeV.intValue;
    }

    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.u : invokeV.intValue;
    }

    public int getMaxSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getMinSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : invokeV.intValue;
    }

    public <T> List<T> getSelectLabelDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = this.A.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object tag = getChildAt(this.A.get(i2).intValue()).getTag(H);
                if (tag != null) {
                    arrayList.add(tag);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getSelectLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.A);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public SelectType getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.r : (SelectType) invokeV.objValue;
    }

    public int getTextPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : invokeV.intValue;
    }

    public int getTextPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.intValue;
    }

    public int getTextPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : invokeV.intValue;
    }

    public int getTextPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getWordMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.p : invokeV.intValue;
    }

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            int childCount = getChildCount();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int i7 = this.v;
                if (i7 > 0 && i6 == i7) {
                    break;
                }
                View childAt = getChildAt(i6);
                measureChild(childAt, i2, i3);
                i4 += childAt.getMeasuredWidth();
                if (i6 != childCount - 1) {
                    i4 += this.p;
                }
                i5 = Math.max(i5, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(i(i2, i4 + getPaddingLeft() + getPaddingRight()), i(i3, i5 + getPaddingTop() + getPaddingBottom()));
            this.C = childCount > 0 ? 1 : 0;
        }
    }

    public final int i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                i3 = size;
            } else if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(i3, size);
            }
            return ViewGroup.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i2, 0);
        }
        return invokeII.intValue;
    }

    public boolean isIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean isSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean isTextBold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public final boolean j(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, textView)) == null) {
            f fVar = this.G;
            return fVar != null && fVar.a(textView, textView.getTag(H), textView.isSelected(), textView.isSelected() ^ true, ((Integer) textView.getTag(I)).intValue());
        }
        return invokeL.booleanValue;
    }

    public final void k(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, textView, z) == null) || textView.isSelected() == z) {
            return;
        }
        textView.setSelected(z);
        if (z) {
            this.A.add((Integer) textView.getTag(I));
        } else {
            this.A.remove((Integer) textView.getTag(I));
        }
        e eVar = this.F;
        if (eVar != null) {
            eVar.a(textView, textView.getTag(H), z, ((Integer) textView.getTag(I)).intValue());
        }
    }

    public final int l(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) ? (int) TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics()) : invokeF.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, view) == null) && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            if (!this.y && this.r != SelectType.NONE) {
                boolean z = true;
                if (textView.isSelected()) {
                    if (!((this.r == SelectType.MULTI && this.B.contains((Integer) textView.getTag(I))) || (this.r == SelectType.MULTI && this.A.size() <= this.t)) && this.r != SelectType.SINGLE_IRREVOCABLY) {
                        z = false;
                    }
                    if (!z && !j(textView)) {
                        k(textView, false);
                    }
                } else {
                    SelectType selectType = this.r;
                    if (selectType != SelectType.SINGLE && selectType != SelectType.SINGLE_IRREVOCABLY) {
                        if (selectType == SelectType.MULTI && (((i2 = this.s) <= 0 || i2 > this.A.size()) && !j(textView))) {
                            k(textView, true);
                        }
                    } else if (!j(textView)) {
                        f();
                        k(textView, true);
                    }
                }
            }
            c cVar = this.D;
            if (cVar != null) {
                cVar.onLabelClick(textView, textView.getTag(H), ((Integer) textView.getTag(I)).intValue());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = i4 - i2;
            int childCount = getChildCount();
            int i9 = 1;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!this.w && (i8 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i7 = this.v) > 0 && i10 == i7))) {
                    i9++;
                    int i13 = this.u;
                    if (i13 > 0 && i9 > i13) {
                        return;
                    }
                    paddingLeft = getPaddingLeft();
                    paddingTop = paddingTop + this.q + i11;
                    i10 = 0;
                    i11 = 0;
                }
                if (this.w && (i6 = this.v) > 0 && i10 == i6) {
                    return;
                }
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.p;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                i10++;
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view)) == null) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                d dVar = this.E;
                if (dVar != null) {
                    return dVar.a(textView, textView.getTag(H), ((Integer) textView.getTag(I)).intValue());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) {
            if (this.w) {
                h(i2, i3);
            } else {
                g(i2, i3);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                super.onRestoreInstanceState(bundle.getParcelable("key_super_state"));
                ColorStateList colorStateList = (ColorStateList) bundle.getParcelable("key_text_color_state");
                if (colorStateList != null) {
                    setLabelTextColor(colorStateList);
                }
                setLabelTextSize(bundle.getFloat("key_text_size_state", this.f40302g));
                this.f40304i = bundle.getInt("key_label_width_state", this.f40304i);
                this.f40305j = bundle.getInt("key_label_height_state", this.f40305j);
                setLabelGravity(bundle.getInt("key_label_gravity_state", this.k));
                int[] intArray = bundle.getIntArray("key_padding_state");
                if (intArray != null && intArray.length == 4) {
                    setLabelTextPadding(intArray[0], intArray[1], intArray[2], intArray[3]);
                }
                setWordMargin(bundle.getInt("key_word_margin_state", this.p));
                setLineMargin(bundle.getInt("key_line_margin_state", this.q));
                setSelectType(SelectType.get(bundle.getInt("key_select_type_state", this.r.value)));
                setMaxSelect(bundle.getInt("key_max_select_state", this.s));
                setMinSelect(bundle.getInt("key_min_select_state", this.t));
                setMaxLines(bundle.getInt("key_max_lines_state", this.u));
                setMaxLines(bundle.getInt("key_max_columns_state", this.v));
                setIndicator(bundle.getBoolean("key_indicator_state", this.y));
                setSingleLine(bundle.getBoolean("key_single_line_state", this.w));
                setTextBold(bundle.getBoolean("key_text_style_state", this.x));
                ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("key_select_compulsory_state");
                if (integerArrayList != null && !integerArrayList.isEmpty()) {
                    setCompulsorys(integerArrayList);
                }
                ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("key_select_labels_state");
                if (integerArrayList2 == null || integerArrayList2.isEmpty()) {
                    return;
                }
                int size = integerArrayList2.size();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = integerArrayList2.get(i2).intValue();
                }
                setSelects(iArr);
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_super_state", super.onSaveInstanceState());
            ColorStateList colorStateList = this.f40301f;
            if (colorStateList != null) {
                bundle.putParcelable("key_text_color_state", colorStateList);
            }
            bundle.putFloat("key_text_size_state", this.f40302g);
            bundle.putInt("key_label_width_state", this.f40304i);
            bundle.putInt("key_label_height_state", this.f40305j);
            bundle.putInt("key_label_gravity_state", this.k);
            bundle.putIntArray("key_padding_state", new int[]{this.l, this.m, this.n, this.o});
            bundle.putInt("key_word_margin_state", this.p);
            bundle.putInt("key_line_margin_state", this.q);
            bundle.putInt("key_select_type_state", this.r.value);
            bundle.putInt("key_max_select_state", this.s);
            bundle.putInt("key_min_select_state", this.t);
            bundle.putInt("key_max_lines_state", this.u);
            bundle.putInt("key_max_columns_state", this.v);
            bundle.putBoolean("key_indicator_state", this.y);
            if (!this.A.isEmpty()) {
                bundle.putIntegerArrayList("key_select_labels_state", this.A);
            }
            if (!this.B.isEmpty()) {
                bundle.putIntegerArrayList("key_select_compulsory_state", this.B);
            }
            bundle.putBoolean("key_single_line_state", this.w);
            bundle.putBoolean("key_text_style_state", this.x);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setCompulsorys(List<Integer> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, list) == null) && this.r == SelectType.MULTI && list != null) {
            this.B.clear();
            this.B.addAll(list);
            f();
            setSelects(list);
        }
    }

    public void setIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.y = z;
        }
    }

    public void setLabelBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            setLabelBackgroundDrawable(new ColorDrawable(i2));
        }
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, drawable) == null) {
            this.f40303h = drawable;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setBackgroundDrawable(this.f40303h.getConstantState().newDrawable());
            }
        }
    }

    public void setLabelBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            setLabelBackgroundDrawable(getResources().getDrawable(i2));
        }
    }

    public void setLabelGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || this.k == i2) {
            return;
        }
        this.k = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((TextView) getChildAt(i3)).setGravity(i2);
        }
    }

    public void setLabelTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            setLabelTextColor(ColorStateList.valueOf(i2));
        }
    }

    public void setLabelTextPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048627, this, i2, i3, i4, i5) == null) {
            if (this.l == i2 && this.m == i3 && this.n == i4 && this.o == i5) {
                return;
            }
            this.l = i2;
            this.m = i3;
            this.n = i4;
            this.o = i5;
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                ((TextView) getChildAt(i6)).setPadding(i2, i3, i4, i5);
            }
        }
    }

    public void setLabelTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048628, this, f2) == null) || this.f40302g == f2) {
            return;
        }
        this.f40302g = f2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setTextSize(0, f2);
        }
    }

    public void setLabels(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, list) == null) {
            setLabels(list, new a(this));
        }
    }

    public void setLineMargin(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || this.q == i2) {
            return;
        }
        this.q = i2;
        requestLayout();
    }

    public void setMaxColumns(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048632, this, i2) == null) || this.v == i2) {
            return;
        }
        this.v = i2;
        requestLayout();
    }

    public void setMaxLines(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || this.u == i2) {
            return;
        }
        this.u = i2;
        requestLayout();
    }

    public void setMaxSelect(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048634, this, i2) == null) || this.s == i2) {
            return;
        }
        this.s = i2;
        if (this.r == SelectType.MULTI) {
            f();
        }
    }

    public void setMinSelect(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setOnLabelClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, cVar) == null) {
            this.D = cVar;
            d();
        }
    }

    public void setOnLabelLongClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, dVar) == null) {
            this.E = dVar;
            d();
        }
    }

    public void setOnLabelSelectChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, eVar) == null) {
            this.F = eVar;
        }
    }

    public void setOnSelectChangeIntercept(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, fVar) == null) {
            this.G = fVar;
        }
    }

    public void setOppositeSelects(int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, iArr) == null) || this.r == SelectType.NONE) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        SelectType selectType = this.r;
        int i2 = (selectType == SelectType.SINGLE || selectType == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.s;
        for (int i3 : iArr) {
            if (i3 < childCount) {
                TextView textView = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView)) {
                    k(textView, false);
                    arrayList.add(textView);
                }
                if (i2 > 0 && arrayList.size() == i2) {
                    break;
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            TextView textView2 = (TextView) getChildAt(i4);
            if (!arrayList.contains(textView2)) {
                k(textView2, false);
            }
        }
    }

    public void setSelectType(SelectType selectType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, selectType) == null) || this.r == selectType) {
            return;
        }
        this.r = selectType;
        f();
        if (this.r == SelectType.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
        if (this.r != SelectType.MULTI) {
            this.B.clear();
        }
        d();
    }

    public void setSelects(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, list) == null) || list == null) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        setSelects(iArr);
    }

    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || this.w == z) {
            return;
        }
        this.w = z;
        requestLayout();
    }

    public void setTextBold(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || this.x == z) {
            return;
        }
        this.x = z;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TextView textView = (TextView) getChildAt(i2);
            textView.getPaint().setFakeBoldText(this.x);
            textView.invalidate();
        }
    }

    public void setUnSelects(int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, iArr) == null) || this.r == SelectType.NONE) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        SelectType selectType = this.r;
        int i2 = (selectType == SelectType.SINGLE || selectType == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.s;
        for (int i3 : iArr) {
            if (i3 < childCount) {
                TextView textView = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView)) {
                    k(textView, true);
                    arrayList.add(textView);
                }
                if (i2 > 0 && arrayList.size() == i2) {
                    return;
                }
            }
        }
    }

    public void setWordMargin(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048647, this, i2) == null) || this.p == i2) {
            return;
        }
        this.p = i2;
        requestLayout();
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, colorStateList) == null) {
            this.f40301f = colorStateList;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setTextColor(this.f40301f);
            }
        }
    }

    public <T> void setLabels(List<T> list, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, list, bVar) == null) {
            f();
            removeAllViews();
            this.z.clear();
            if (list != null) {
                this.z.addAll(list);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(list.get(i2), i2, bVar);
                }
                d();
            }
            if (this.r == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
        }
    }

    public void setSelects(int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, iArr) == null) || this.r == SelectType.NONE) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        SelectType selectType = this.r;
        int i2 = (selectType == SelectType.SINGLE || selectType == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.s;
        for (int i3 : iArr) {
            if (i3 < childCount) {
                TextView textView = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView)) {
                    k(textView, false);
                    arrayList.add(textView);
                }
                if (i2 > 0 && arrayList.size() == i2) {
                    return;
                }
            }
        }
    }

    public void setCompulsorys(int... iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, iArr) == null) && this.r == SelectType.MULTI && iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            setCompulsorys(arrayList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoChangeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40304i = -2;
        this.f40305j = -2;
        this.k = 0;
        this.w = false;
        this.x = false;
        this.z = new ArrayList<>();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.f40300e = context;
        e(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoChangeLineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f40304i = -2;
        this.f40305j = -2;
        this.k = 0;
        this.w = false;
        this.x = false;
        this.z = new ArrayList<>();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.f40300e = context;
        e(context, attributeSet);
    }
}
