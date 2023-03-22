package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.xf;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class UserIconBox extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xf<TbImageView> a;
    public Context b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public d g;

    /* loaded from: classes3.dex */
    public interface d {
        void a(@NonNull IconData iconData, int i);
    }

    /* loaded from: classes3.dex */
    public interface e<T extends View> {
        xf<TbImageView> I();
    }

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserIconBox a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public a(UserIconBox userIconBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userIconBox;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof TbImageView) && this.a.a != null) {
                this.a.a.e((TbImageView) view3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ int b;
        public final /* synthetic */ UserIconBox c;

        public b(UserIconBox userIconBox, IconData iconData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconBox, iconData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = userIconBox;
            this.a = iconData;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.g != null) {
                this.c.g.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setBackgroundResource(0);
                tbImageView.setImageDrawable(null);
                tbImageView.setTag(null);
                tbImageView.setOnClickListener(null);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new TbImageView(this.a);
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconBox(Context context) {
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
        this.a = null;
        this.c = true;
        g(context);
    }

    public final boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i <= 0) {
                return false;
            }
            int childCount = getChildCount();
            if (i == childCount) {
                return true;
            }
            int i2 = i - childCount;
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    addView(e(this.b));
                }
            } else {
                removeViews(i, Math.abs(i2));
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconBox(Context context, AttributeSet attributeSet) {
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
        this.a = null;
        this.c = true;
        g(context);
    }

    public final TbImageView e(Context context) {
        InterceptResult invokeL;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            xf<TbImageView> xfVar = this.a;
            if (xfVar != null) {
                tbImageView = xfVar.b();
            } else {
                tbImageView = null;
            }
            if (tbImageView == null || tbImageView.getParent() != null) {
                return new TbImageView(context);
            }
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b = context;
            setOrientation(0);
            setGravity(16);
            Context context2 = this.b;
            if (context2 instanceof e) {
                this.a = ((e) context2).I();
            }
            setOnHierarchyChangeListener(new a(this));
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    public void setAutoChangedStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
        }
    }

    public void setIconOnClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.g = dVar;
        }
    }

    public static xf<TbImageView> d(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            return new xf<>(new c(context), i, 0);
        }
        return (xf) invokeLI.objValue;
    }

    public final LinearLayout.LayoutParams f(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
            layoutParams.leftMargin = i3;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeIII.objValue;
    }

    public void h(List<IconData> list, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            i(list, i, i2, i3, i4, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.baidu.tbadk.core.view.UserIconBox */
    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: android.view.View */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: com.baidu.tbadk.widget.TbImageView */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v2 */
    public void i(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (list == null) {
                setVisibility(8);
                return;
            }
            int min = Math.min(i, ListUtils.getCount(list));
            ?? r14 = 0;
            if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
                setVisibility(8);
                return;
            }
            this.d = i2;
            this.e = i4;
            this.f = z;
            this.d = i2;
            if (!c(min)) {
                setVisibility(8);
            } else if (min > 0) {
                setVisibility(0);
                int i5 = 0;
                while (i5 < min) {
                    View childAt = getChildAt(i5);
                    if (childAt instanceof TbImageView) {
                        if (StringUtils.isNull(list.get(i5).getIcon())) {
                            childAt.setVisibility(8);
                        } else {
                            childAt.setVisibility(r14);
                            TbImageView tbImageView = (TbImageView) childAt;
                            tbImageView.setDefaultResource(R.drawable.icon_moren);
                            if (i5 == 0 && z) {
                                tbImageView.setLayoutParams(f(i2, i3, r14));
                            } else {
                                tbImageView.setLayoutParams(f(i2, i3, i4));
                            }
                            tbImageView.setTag(list.get(i5).getIcon());
                            if (!StringUtils.isNull(list.get(i5).getIconName())) {
                                tbImageView.setContentDescription(list.get(i5).getIconName());
                            }
                            tbImageView.setClickable(r14);
                            tbImageView.setAutoChangeStyle(this.c);
                            tbImageView.setImageDrawable(null);
                            tbImageView.I(list.get(i5).getIcon(), 21, i2, i3, false);
                            tbImageView.setOnClickListener(new b(this, list.get(i5), i5));
                        }
                    }
                    i5++;
                    r14 = 0;
                }
            } else {
                setVisibility(8);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int measuredWidth = getMeasuredWidth();
            int childCount = getChildCount();
            boolean z2 = false;
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (!z2) {
                    if (i7 == 0 && this.f) {
                        i5 = this.d;
                    } else {
                        i5 = this.d + this.e;
                    }
                    i6 += i5;
                    if (i6 > measuredWidth) {
                        z2 = true;
                    }
                }
                if (z2) {
                    childAt.layout(0, 0, 0, 0);
                }
            }
        }
    }
}
