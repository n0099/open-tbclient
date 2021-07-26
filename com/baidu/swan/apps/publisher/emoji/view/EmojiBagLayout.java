package com.baidu.swan.apps.publisher.emoji.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.d;
import d.a.o0.a.e;
import d.a.o0.a.f;
import d.a.o0.a.g;
import d.a.o0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmojiBagLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f11273e;

    /* renamed from: f  reason: collision with root package name */
    public CircleIndicator f11274f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f11275g;

    /* renamed from: h  reason: collision with root package name */
    public List<GridView> f11276h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11278f;

        public a(EmojiBagLayout emojiBagLayout, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiBagLayout, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11278f = emojiBagLayout;
            this.f11277e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11277e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f11279e;

        /* renamed from: f  reason: collision with root package name */
        public LayoutInflater f11280f;

        /* renamed from: g  reason: collision with root package name */
        public Context f11281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11282h;

        public b(EmojiBagLayout emojiBagLayout, Context context, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiBagLayout, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11282h = emojiBagLayout;
            this.f11279e = list;
            this.f11280f = LayoutInflater.from(context);
            this.f11281g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < this.f11279e.size()) {
                    return this.f11279e.get(i2);
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 21;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    linearLayout = (LinearLayout) this.f11280f.inflate(g.swanapp_emotion_grid_item, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.height = this.f11282h.getResources().getDimensionPixelSize(d.aiapps_emoji_row_height);
                    linearLayout.setLayoutParams(layoutParams);
                } else {
                    linearLayout = (LinearLayout) view;
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(f.img_item);
                if (i2 == getCount() - 1) {
                    imageView.setImageResource(e.swanapp_publisher_delete);
                } else if (i2 < this.f11279e.size()) {
                    imageView.setImageBitmap(d.a.o0.a.w1.h.b.c().a(this.f11279e.get(i2)));
                }
                return linearLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<GridView> f11283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11284b;

        public c(EmojiBagLayout emojiBagLayout, List<GridView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiBagLayout, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11284b = emojiBagLayout;
            this.f11283a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView(this.f11283a.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11283a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                viewGroup.addView(this.f11283a.get(i2));
                return this.f11283a.get(i2);
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiBagLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final List<String> a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = i2 * 20;
            int min = Math.min(i3 + 20, this.f11275g.size());
            ArrayList arrayList = new ArrayList();
            while (i3 < min) {
                arrayList.add(this.f11275g.get(i3));
                i3++;
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setBackgroundColor(-1);
            setOrientation(1);
            this.f11273e = new ViewPager(context);
            this.f11274f = new CircleIndicator(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.f11273e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.aiapps_emoji_indicator_height));
            layoutParams2.weight = 0.0f;
            this.f11274f.setLayoutParams(layoutParams2);
            this.f11273e.setOverScrollMode(2);
            addView(this.f11273e);
            addView(this.f11274f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f11276h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f11276h.get(i2).setAdapter((ListAdapter) new b(this, getContext(), a(i2)));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            Resources resources = getResources();
            int measuredHeight = getChildAt(0).getMeasuredHeight() - (resources.getDimensionPixelSize(d.aiapps_emoji_row_height) * 3);
            int g2 = (measuredHeight / 4) + n0.g(8.0f);
            int i6 = (measuredHeight - (g2 * 2)) / 2;
            int size = this.f11276h.size();
            for (int i7 = 0; i7 < size; i7++) {
                GridView gridView = this.f11276h.get(i7);
                int dimensionPixelSize = resources.getDimensionPixelSize(d.aiapps_emoji_left_right_padding);
                gridView.setPadding(dimensionPixelSize, g2, dimensionPixelSize, g2);
                gridView.setVerticalSpacing(i6);
                gridView.setHorizontalSpacing(resources.getDimensionPixelSize(d.aiapps_emoji_grid_space));
                b bVar = (b) gridView.getAdapter();
                if (bVar != null && (viewPager = this.f11273e) != null) {
                    viewPager.post(new a(this, bVar));
                }
            }
        }
    }

    public void setEmotionList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f11275g = list;
            if (list == null || list.size() <= 0) {
                return;
            }
            int size = this.f11275g.size();
            int i2 = size % 20;
            int i3 = size / 20;
            if (i2 != 0) {
                i3++;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
                noScrollGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                noScrollGridView.setNumColumns(7);
                noScrollGridView.setStretchMode(2);
                noScrollGridView.setVerticalScrollBarEnabled(false);
                noScrollGridView.setOverScrollMode(2);
                d.a.o0.a.w1.h.a g2 = d.a.o0.a.w1.h.a.g(getContext().getApplicationContext());
                noScrollGridView.setOnItemClickListener(g2.h());
                noScrollGridView.setOnItemLongClickListener(g2.i());
                noScrollGridView.setOnTouchListener(g2.j());
                noScrollGridView.setSelector(new ColorDrawable(0));
                this.f11276h.add(noScrollGridView);
            }
            c();
            this.f11273e.setAdapter(new c(this, this.f11276h));
            this.f11274f.setViewPager(this.f11273e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f11276h = new ArrayList();
        b(context);
    }
}
