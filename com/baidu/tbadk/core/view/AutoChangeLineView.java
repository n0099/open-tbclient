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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.zda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoChangeLineView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int D = 2131305370;
    public static final int E = 2131305371;
    public transient /* synthetic */ FieldHolder $fh;
    public d A;
    public e B;
    public f C;
    public Context a;
    public ColorStateList b;
    public float c;
    public Drawable d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public SelectType n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public ArrayList<Object> v;
    public ArrayList<Integer> w;
    public ArrayList<Integer> x;
    public int y;
    public c z;

    /* loaded from: classes4.dex */
    public interface b<T> {
        CharSequence a(TextView textView, int i, T t);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(TextView textView, Object obj, int i);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(TextView textView, Object obj, int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(TextView textView, Object obj, boolean z, int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        boolean a(TextView textView, Object obj, boolean z, boolean z2, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1637517158, "Lcom/baidu/tbadk/core/view/AutoChangeLineView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1637517158, "Lcom/baidu/tbadk/core/view/AutoChangeLineView;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            NONE = new SelectType(HlsPlaylistParser.METHOD_NONE, 0, 1);
            SINGLE = new SelectType("SINGLE", 1, 2);
            SINGLE_IRREVOCABLY = new SelectType("SINGLE_IRREVOCABLY", 2, 3);
            SelectType selectType = new SelectType("MULTI", 3, 4);
            MULTI = selectType;
            $VALUES = new SelectType[]{NONE, SINGLE, SINGLE_IRREVOCABLY, selectType};
        }

        public SelectType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static SelectType get(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SelectType) Enum.valueOf(SelectType.class, str);
            }
            return (SelectType) invokeL.objValue;
        }

        public static SelectType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SelectType[]) $VALUES.clone();
            }
            return (SelectType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public CharSequence a(TextView textView, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i, str)) == null) {
                return str.trim();
            }
            return (CharSequence) invokeLIL.objValue;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = -2;
        this.f = -2;
        this.g = 0;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
    }

    public void setSelects(int... iArr) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, iArr) == null) && this.n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            SelectType selectType = this.n;
            if (selectType != SelectType.SINGLE && selectType != SelectType.SINGLE_IRREVOCABLY) {
                i = this.o;
            } else {
                i = 1;
            }
            for (int i2 : iArr) {
                if (i2 < childCount) {
                    TextView textView = (TextView) getChildAt(i2);
                    if (!arrayList.contains(textView)) {
                        j(textView, false);
                        arrayList.add(textView);
                    }
                    if (i > 0 && arrayList.size() == i) {
                        return;
                    }
                }
            }
        }
    }

    public void setUnSelects(int... iArr) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, iArr) == null) && this.n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            SelectType selectType = this.n;
            if (selectType != SelectType.SINGLE && selectType != SelectType.SINGLE_IRREVOCABLY) {
                i = this.o;
            } else {
                i = 1;
            }
            for (int i2 : iArr) {
                if (i2 < childCount) {
                    TextView textView = (TextView) getChildAt(i2);
                    if (!arrayList.contains(textView)) {
                        j(textView, true);
                        arrayList.add(textView);
                    }
                    if (i > 0 && arrayList.size() == i) {
                        return;
                    }
                }
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = -2;
        this.f = -2;
        this.g = 0;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
        d(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoChangeLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.e = -2;
        this.f = -2;
        this.g = 0;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
        d(context, attributeSet);
    }

    public final <T> void a(T t, int i, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, t, i, bVar) == null) {
            EMTextView eMTextView = new EMTextView(this.a);
            eMTextView.setPadding(this.h, this.i, this.j, this.k);
            eMTextView.setTextSize(0, this.c);
            eMTextView.setGravity(this.g);
            eMTextView.setTextColor(this.b);
            eMTextView.setBackgroundDrawable(this.d.getConstantState().newDrawable());
            eMTextView.setTag(D, t);
            eMTextView.setTag(E, Integer.valueOf(i));
            eMTextView.setOnClickListener(this);
            eMTextView.setOnLongClickListener(this);
            eMTextView.getPaint().setFakeBoldText(this.t);
            addView(eMTextView, this.e, this.f);
            eMTextView.setText(bVar.a(eMTextView, i, t));
        }
    }

    public final int b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        }
        return invokeF.intValue;
    }

    public final int k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048605, this, f2)) == null) {
            return (int) TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
        }
        return invokeF.intValue;
    }

    public void setCompulsorys(List<Integer> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, list) == null) && this.n == SelectType.MULTI && list != null) {
            this.x.clear();
            this.x.addAll(list);
            e();
            setSelects(list);
        }
    }

    public void setIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.u = z;
        }
    }

    public void setLabelBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            setLabelBackgroundDrawable(new ColorDrawable(i));
        }
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, drawable) == null) {
            this.d = drawable;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setBackgroundDrawable(this.d.getConstantState().newDrawable());
            }
        }
    }

    public void setLabelBackgroundResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            setLabelBackgroundDrawable(getResources().getDrawable(i));
        }
    }

    public void setLabelGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i) == null) && this.g != i) {
            this.g = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setGravity(i);
            }
        }
    }

    public void setLabelTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            setLabelTextColor(ColorStateList.valueOf(i));
        }
    }

    public void setLabelTextSize(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048622, this, f2) == null) && this.c != f2) {
            this.c = f2;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setTextSize(0, f2);
            }
        }
    }

    public void setLabels(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, list) == null) {
            setLabels(list, new a(this));
        }
    }

    public void setLineMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i) == null) && this.m != i) {
            this.m = i;
            requestLayout();
        }
    }

    public void setMaxColumns(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048626, this, i) == null) && this.r != i) {
            this.r = i;
            requestLayout();
        }
    }

    public void setMaxLines(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i) == null) && this.q != i) {
            this.q = i;
            requestLayout();
        }
    }

    public void setMaxSelect(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i) == null) && this.o != i) {
            this.o = i;
            if (this.n == SelectType.MULTI) {
                e();
            }
        }
    }

    public void setMinSelect(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.p = i;
        }
    }

    public void setOnLabelClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, cVar) == null) {
            this.z = cVar;
            c();
        }
    }

    public void setOnLabelLongClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dVar) == null) {
            this.A = dVar;
            c();
        }
    }

    public void setOnLabelSelectChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, eVar) == null) {
            this.B = eVar;
        }
    }

    public void setOnSelectChangeIntercept(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, fVar) == null) {
            this.C = fVar;
        }
    }

    public void setSelects(List<Integer> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, list) == null) && list != null) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = list.get(i).intValue();
            }
            setSelects(iArr);
        }
    }

    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048638, this, z) == null) && this.s != z) {
            this.s = z;
            requestLayout();
        }
    }

    public void setTextBold(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048639, this, z) == null) && this.t != z) {
            this.t = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView = (TextView) getChildAt(i);
                textView.getPaint().setFakeBoldText(this.t);
                textView.invalidate();
            }
        }
    }

    public void setWordMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i) == null) && this.l != i) {
            this.l = i;
            requestLayout();
        }
    }

    public final void c() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView = (TextView) getChildAt(i);
                if (this.z == null && this.A == null && this.n == SelectType.NONE) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setClickable(z);
            }
        }
    }

    public <T> List<T> getSelectLabelDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                Object tag = getChildAt(this.w.get(i).intValue()).getTag(D);
                if (tag != null) {
                    arrayList.add(tag);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zda.AutoChangeLineView);
            this.n = SelectType.get(obtainStyledAttributes.getInt(18, 1));
            this.o = obtainStyledAttributes.getInteger(16, 0);
            this.p = obtainStyledAttributes.getInteger(17, 0);
            this.q = obtainStyledAttributes.getInteger(15, 0);
            this.r = obtainStyledAttributes.getInteger(14, 0);
            this.u = obtainStyledAttributes.getBoolean(0, false);
            this.g = obtainStyledAttributes.getInt(3, this.g);
            this.e = obtainStyledAttributes.getLayoutDimension(12, this.e);
            this.f = obtainStyledAttributes.getLayoutDimension(5, this.f);
            if (obtainStyledAttributes.hasValue(4)) {
                this.b = obtainStyledAttributes.getColorStateList(4);
            } else {
                this.b = ColorStateList.valueOf(-16777216);
            }
            this.c = obtainStyledAttributes.getDimension(11, k(14.0f));
            if (obtainStyledAttributes.hasValue(6)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                this.k = dimensionPixelOffset;
                this.j = dimensionPixelOffset;
                this.i = dimensionPixelOffset;
                this.h = dimensionPixelOffset;
            } else {
                this.h = obtainStyledAttributes.getDimensionPixelOffset(8, b(10.0f));
                this.i = obtainStyledAttributes.getDimensionPixelOffset(10, b(0.0f));
                this.j = obtainStyledAttributes.getDimensionPixelOffset(9, b(10.0f));
                this.k = obtainStyledAttributes.getDimensionPixelOffset(7, b(0.0f));
            }
            this.m = obtainStyledAttributes.getDimensionPixelOffset(13, b(5.0f));
            this.l = obtainStyledAttributes.getDimensionPixelOffset(20, b(5.0f));
            if (obtainStyledAttributes.hasValue(2)) {
                int resourceId = obtainStyledAttributes.getResourceId(2, 0);
                if (resourceId != 0) {
                    this.d = getResources().getDrawable(resourceId);
                } else {
                    this.d = new ColorDrawable(obtainStyledAttributes.getColor(2, 0));
                }
            } else {
                this.d = getResources().getDrawable(R.drawable.bg_default_tag);
            }
            this.s = obtainStyledAttributes.getBoolean(19, false);
            this.t = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                j((TextView) getChildAt(i), false);
            }
            this.w.clear();
        }
    }

    public List<Integer> getCompulsorys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (List) invokeV.objValue;
    }

    public int getLabelGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public ColorStateList getLabelTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getLabelTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.floatValue;
    }

    public <T> List<T> getLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.v;
        }
        return (List) invokeV.objValue;
    }

    public int getLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int getLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public int getMaxColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public int getMaxSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public int getMinSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public List<Integer> getSelectLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.w);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public SelectType getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.n;
        }
        return (SelectType) invokeV.objValue;
    }

    public int getTextPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int getTextPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getTextPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int getTextPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getWordMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final void f(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            int childCount = getChildCount();
            int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 1;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                measureChild(childAt, i, i2);
                if (childAt.getMeasuredWidth() + i5 > size || ((i3 = this.r) > 0 && i6 == i3)) {
                    i10++;
                    int i12 = this.q;
                    if (i12 > 0 && i10 > i12) {
                        i10--;
                        break;
                    }
                    i8 = i8 + this.m + i7;
                    i9 = Math.max(i9, i5);
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                }
                i5 += childAt.getMeasuredWidth();
                i6++;
                i7 = Math.max(i7, childAt.getMeasuredHeight());
                if (i11 != childCount - 1) {
                    int i13 = this.l;
                    if (i5 + i13 > size) {
                        i10++;
                        int i14 = this.q;
                        if (i14 > 0 && i10 > i14) {
                            i10--;
                            break;
                        }
                        i8 = i8 + this.m + i7;
                        i9 = Math.max(i9, i5);
                        i5 = 0;
                        i6 = 0;
                        i7 = 0;
                    } else {
                        i5 += i13;
                    }
                }
            }
            setMeasuredDimension(h(i, Math.max(i9, i5) + getPaddingLeft() + getPaddingRight()), h(i2, i8 + i7 + getPaddingTop() + getPaddingBottom()));
            if (childCount > 0) {
                i4 = i10;
            }
            this.y = i4;
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int i7 = this.r;
                if (i7 > 0 && i6 == i7) {
                    break;
                }
                View childAt = getChildAt(i6);
                measureChild(childAt, i, i2);
                i4 += childAt.getMeasuredWidth();
                if (i6 != childCount - 1) {
                    i4 += this.l;
                }
                i5 = Math.max(i5, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(h(i, i4 + getPaddingLeft() + getPaddingRight()), h(i2, i5 + getPaddingTop() + getPaddingBottom()));
            if (childCount > 0) {
                i3 = 1;
            }
            this.y = i3;
        }
    }

    public final void j(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048604, this, textView, z) == null) && textView.isSelected() != z) {
            textView.setSelected(z);
            if (z) {
                this.w.add((Integer) textView.getTag(E));
            } else {
                this.w.remove((Integer) textView.getTag(E));
            }
            e eVar = this.B;
            if (eVar != null) {
                eVar.a(textView, textView.getTag(D), z, ((Integer) textView.getTag(E)).intValue());
            }
        }
    }

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048602, this, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                i2 = size;
            } else if (mode == Integer.MIN_VALUE) {
                i2 = Math.min(i2, size);
            }
            return ViewGroup.resolveSizeAndState(Math.max(i2, getSuggestedMinimumWidth()), i, 0);
        }
        return invokeII.intValue;
    }

    public <T> void setLabels(List<T> list, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, list, bVar) == null) {
            e();
            removeAllViews();
            this.v.clear();
            if (list != null) {
                this.v.addAll(list);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    a(list.get(i), i, bVar);
                }
                c();
            }
            if (this.n == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
        }
    }

    public final boolean i(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, textView)) == null) {
            f fVar = this.C;
            if (fVar != null && fVar.a(textView, textView.getTag(D), textView.isSelected(), !textView.isSelected(), ((Integer) textView.getTag(E)).intValue())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, view2)) == null) {
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                d dVar = this.A;
                if (dVar != null) {
                    return dVar.a(textView, textView.getTag(D), ((Integer) textView.getTag(E)).intValue());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setSelectType(SelectType selectType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, selectType) == null) && this.n != selectType) {
            this.n = selectType;
            e();
            if (this.n == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.n != SelectType.MULTI) {
                this.x.clear();
            }
            c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, view2) == null) && (view2 instanceof TextView)) {
            TextView textView = (TextView) view2;
            if (!this.u && this.n != SelectType.NONE) {
                boolean z3 = true;
                if (textView.isSelected()) {
                    if (this.n == SelectType.MULTI && this.x.contains((Integer) textView.getTag(E))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z && (this.n != SelectType.MULTI || this.w.size() > this.p)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2 && this.n != SelectType.SINGLE_IRREVOCABLY) {
                        z3 = false;
                    }
                    if (!z3 && !i(textView)) {
                        j(textView, false);
                    }
                } else {
                    SelectType selectType = this.n;
                    if (selectType != SelectType.SINGLE && selectType != SelectType.SINGLE_IRREVOCABLY) {
                        if (selectType == SelectType.MULTI && (((i = this.o) <= 0 || i > this.w.size()) && !i(textView))) {
                            j(textView, true);
                        }
                    } else if (!i(textView)) {
                        e();
                        j(textView, true);
                    }
                }
            }
            c cVar = this.z;
            if (cVar != null) {
                cVar.a(textView, textView.getTag(D), ((Integer) textView.getTag(E)).intValue());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = i3 - i;
            int childCount = getChildCount();
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!this.s && (i7 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i6 = this.r) > 0 && i9 == i6))) {
                    i8++;
                    int i12 = this.q;
                    if (i12 <= 0 || i8 <= i12) {
                        paddingLeft = getPaddingLeft();
                        paddingTop = paddingTop + this.m + i10;
                        i9 = 0;
                        i10 = 0;
                    } else {
                        return;
                    }
                }
                if (!this.s || (i5 = this.r) <= 0 || i9 != i5) {
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.l;
                    i10 = Math.max(i10, childAt.getMeasuredHeight());
                    i9++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            if (this.s) {
                g(i, i2);
            } else {
                f(i, i2);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                super.onRestoreInstanceState(bundle.getParcelable("key_super_state"));
                ColorStateList colorStateList = (ColorStateList) bundle.getParcelable("key_text_color_state");
                if (colorStateList != null) {
                    setLabelTextColor(colorStateList);
                }
                setLabelTextSize(bundle.getFloat("key_text_size_state", this.c));
                this.e = bundle.getInt("key_label_width_state", this.e);
                this.f = bundle.getInt("key_label_height_state", this.f);
                setLabelGravity(bundle.getInt("key_label_gravity_state", this.g));
                int[] intArray = bundle.getIntArray("key_padding_state");
                if (intArray != null && intArray.length == 4) {
                    setLabelTextPadding(intArray[0], intArray[1], intArray[2], intArray[3]);
                }
                setWordMargin(bundle.getInt("key_word_margin_state", this.l));
                setLineMargin(bundle.getInt("key_line_margin_state", this.m));
                setSelectType(SelectType.get(bundle.getInt("key_select_type_state", this.n.value)));
                setMaxSelect(bundle.getInt("key_max_select_state", this.o));
                setMinSelect(bundle.getInt("key_min_select_state", this.p));
                setMaxLines(bundle.getInt("key_max_lines_state", this.q));
                setMaxLines(bundle.getInt("key_max_columns_state", this.r));
                setIndicator(bundle.getBoolean("key_indicator_state", this.u));
                setSingleLine(bundle.getBoolean("key_single_line_state", this.s));
                setTextBold(bundle.getBoolean("key_text_style_state", this.t));
                ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("key_select_compulsory_state");
                if (integerArrayList != null && !integerArrayList.isEmpty()) {
                    setCompulsorys(integerArrayList);
                }
                ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("key_select_labels_state");
                if (integerArrayList2 != null && !integerArrayList2.isEmpty()) {
                    int size = integerArrayList2.size();
                    int[] iArr = new int[size];
                    for (int i = 0; i < size; i++) {
                        iArr[i] = integerArrayList2.get(i).intValue();
                    }
                    setSelects(iArr);
                    return;
                }
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_super_state", super.onSaveInstanceState());
            ColorStateList colorStateList = this.b;
            if (colorStateList != null) {
                bundle.putParcelable("key_text_color_state", colorStateList);
            }
            bundle.putFloat("key_text_size_state", this.c);
            bundle.putInt("key_label_width_state", this.e);
            bundle.putInt("key_label_height_state", this.f);
            bundle.putInt("key_label_gravity_state", this.g);
            bundle.putIntArray("key_padding_state", new int[]{this.h, this.i, this.j, this.k});
            bundle.putInt("key_word_margin_state", this.l);
            bundle.putInt("key_line_margin_state", this.m);
            bundle.putInt("key_select_type_state", this.n.value);
            bundle.putInt("key_max_select_state", this.o);
            bundle.putInt("key_min_select_state", this.p);
            bundle.putInt("key_max_lines_state", this.q);
            bundle.putInt("key_max_columns_state", this.r);
            bundle.putBoolean("key_indicator_state", this.u);
            if (!this.w.isEmpty()) {
                bundle.putIntegerArrayList("key_select_labels_state", this.w);
            }
            if (!this.x.isEmpty()) {
                bundle.putIntegerArrayList("key_select_compulsory_state", this.x);
            }
            bundle.putBoolean("key_single_line_state", this.s);
            bundle.putBoolean("key_text_style_state", this.t);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setCompulsorys(int... iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, iArr) == null) && this.n == SelectType.MULTI && iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(i));
            }
            setCompulsorys(arrayList);
        }
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, colorStateList) == null) {
            this.b = colorStateList;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setTextColor(this.b);
            }
        }
    }

    public void setLabelTextPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048621, this, i, i2, i3, i4) == null) {
            if (this.h != i || this.i != i2 || this.j != i3 || this.k != i4) {
                this.h = i;
                this.i = i2;
                this.j = i3;
                this.k = i4;
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    ((TextView) getChildAt(i5)).setPadding(i, i2, i3, i4);
                }
            }
        }
    }

    public void setOppositeSelects(int... iArr) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, iArr) == null) && this.n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            SelectType selectType = this.n;
            if (selectType != SelectType.SINGLE && selectType != SelectType.SINGLE_IRREVOCABLY) {
                i = this.o;
            } else {
                i = 1;
            }
            for (int i2 : iArr) {
                if (i2 < childCount) {
                    TextView textView = (TextView) getChildAt(i2);
                    if (!arrayList.contains(textView)) {
                        j(textView, false);
                        arrayList.add(textView);
                    }
                    if (i > 0 && arrayList.size() == i) {
                        break;
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                TextView textView2 = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView2)) {
                    j(textView2, false);
                }
            }
        }
    }
}
