package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class UserIconBox extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.k.b<TbImageView> f12610e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12611f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12612g;

    /* renamed from: h  reason: collision with root package name */
    public int f12613h;

    /* renamed from: i  reason: collision with root package name */
    public int f12614i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconBox f12615e;

        public a(UserIconBox userIconBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12615e = userIconBox;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof TbImageView) && this.f12615e.f12610e != null) {
                this.f12615e.f12610e.e((TbImageView) view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d.a.c.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12616a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12616a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TbImageView(this.f12616a) : (TbImageView) invokeV.objValue;
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
    }

    /* loaded from: classes4.dex */
    public interface c<T extends View> {
        d.a.c.e.k.b<TbImageView> getUserIconPool();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12610e = null;
        this.f12612g = true;
        f(context);
    }

    public static d.a.c.e.k.b<TbImageView> c(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) ? new d.a.c.e.k.b<>(new b(context), i2, 0) : (d.a.c.e.k.b) invokeLI.objValue;
    }

    public final boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return false;
            }
            int childCount = getChildCount();
            if (i2 == childCount) {
                return true;
            }
            int i3 = i2 - childCount;
            if (i3 > 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    addView(d(this.f12611f));
                }
            } else {
                removeViews(i2, Math.abs(i3));
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final TbImageView d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d.a.c.e.k.b<TbImageView> bVar = this.f12610e;
            TbImageView b2 = bVar != null ? bVar.b() : null;
            return (b2 == null || b2.getParent() != null) ? new TbImageView(context) : b2;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final LinearLayout.LayoutParams e(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
            layoutParams.leftMargin = i4;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeIII.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f12611f = context;
            setOrientation(0);
            setGravity(16);
            Context context2 = this.f12611f;
            if (context2 instanceof c) {
                this.f12610e = ((c) context2).getUserIconPool();
            }
            setOnHierarchyChangeListener(new a(this));
        }
    }

    public void g(List<IconData> list, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            h(list, i2, i3, i4, i5, false);
        }
    }

    public void h(List<IconData> list, int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            if (list == null) {
                setVisibility(8);
                return;
            }
            int min = Math.min(i2, ListUtils.getCount(list));
            if (min == 1 && TextUtils.isEmpty(list.get(0).getIcon())) {
                setVisibility(8);
                return;
            }
            this.f12613h = i3;
            this.f12614i = i5;
            this.j = z;
            this.f12613h = i3;
            if (!b(min)) {
                setVisibility(8);
            } else if (min > 0) {
                setVisibility(0);
                for (int i6 = 0; i6 < min; i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt instanceof TbImageView) {
                        if (StringUtils.isNull(list.get(i6).getIcon())) {
                            childAt.setVisibility(8);
                        } else {
                            childAt.setVisibility(0);
                            TbImageView tbImageView = (TbImageView) childAt;
                            tbImageView.setDefaultResource(R.drawable.icon_moren);
                            if (i6 == 0 && z) {
                                tbImageView.setLayoutParams(e(i3, i4, 0));
                            } else {
                                tbImageView.setLayoutParams(e(i3, i4, i5));
                            }
                            tbImageView.setTag(list.get(i6).getIcon());
                            if (!StringUtils.isNull(list.get(i6).getIconName())) {
                                tbImageView.setContentDescription(list.get(i6).getIconName());
                            }
                            tbImageView.setClickable(false);
                            tbImageView.setAutoChangeStyle(this.f12612g);
                            tbImageView.setImageDrawable(null);
                            tbImageView.J(list.get(i6).getIcon(), 21, i3, i4, false);
                        }
                    }
                }
            } else {
                setVisibility(8);
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setIsNight(TbadkCoreApplication.getInst().getSkinType() == 1);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int measuredWidth = getMeasuredWidth();
            int childCount = getChildCount();
            boolean z2 = false;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (!z2) {
                    if (i8 == 0 && this.j) {
                        i6 = this.f12613h;
                    } else {
                        i6 = this.f12613h + this.f12614i;
                    }
                    i7 += i6;
                    if (i7 > measuredWidth) {
                        z2 = true;
                    }
                }
                if (z2) {
                    childAt.layout(0, 0, 0, 0);
                }
            }
        }
    }

    public void setAutoChangedStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f12612g = z;
        }
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
        this.f12610e = null;
        this.f12612g = true;
        f(context);
    }
}
