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
import d.a.q0.a.d;
import d.a.q0.a.e;
import d.a.q0.a.f;
import d.a.q0.a.g;
import d.a.q0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmojiBagLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f11230e;

    /* renamed from: f  reason: collision with root package name */
    public CircleIndicator f11231f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f11232g;

    /* renamed from: h  reason: collision with root package name */
    public List<GridView> f11233h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11235f;

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
            this.f11235f = emojiBagLayout;
            this.f11234e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11234e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f11236e;

        /* renamed from: f  reason: collision with root package name */
        public LayoutInflater f11237f;

        /* renamed from: g  reason: collision with root package name */
        public Context f11238g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11239h;

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
            this.f11239h = emojiBagLayout;
            this.f11236e = list;
            this.f11237f = LayoutInflater.from(context);
            this.f11238g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < this.f11236e.size()) {
                    return this.f11236e.get(i2);
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
                    linearLayout = (LinearLayout) this.f11237f.inflate(g.swanapp_emotion_grid_item, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.height = this.f11239h.getResources().getDimensionPixelSize(d.aiapps_emoji_row_height);
                    linearLayout.setLayoutParams(layoutParams);
                } else {
                    linearLayout = (LinearLayout) view;
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(f.img_item);
                if (i2 == getCount() - 1) {
                    imageView.setImageResource(e.swanapp_publisher_delete);
                } else if (i2 < this.f11236e.size()) {
                    imageView.setImageBitmap(d.a.q0.a.w1.h.b.c().a(this.f11236e.get(i2)));
                }
                return linearLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<GridView> f11240a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmojiBagLayout f11241b;

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
            this.f11241b = emojiBagLayout;
            this.f11240a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView(this.f11240a.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11240a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                viewGroup.addView(this.f11240a.get(i2));
                return this.f11240a.get(i2);
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
            int min = Math.min(i3 + 20, this.f11232g.size());
            ArrayList arrayList = new ArrayList();
            while (i3 < min) {
                arrayList.add(this.f11232g.get(i3));
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
            this.f11230e = new ViewPager(context);
            this.f11231f = new CircleIndicator(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.f11230e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.aiapps_emoji_indicator_height));
            layoutParams2.weight = 0.0f;
            this.f11231f.setLayoutParams(layoutParams2);
            this.f11230e.setOverScrollMode(2);
            addView(this.f11230e);
            addView(this.f11231f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f11233h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f11233h.get(i2).setAdapter((ListAdapter) new b(this, getContext(), a(i2)));
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
            int size = this.f11233h.size();
            for (int i7 = 0; i7 < size; i7++) {
                GridView gridView = this.f11233h.get(i7);
                int dimensionPixelSize = resources.getDimensionPixelSize(d.aiapps_emoji_left_right_padding);
                gridView.setPadding(dimensionPixelSize, g2, dimensionPixelSize, g2);
                gridView.setVerticalSpacing(i6);
                gridView.setHorizontalSpacing(resources.getDimensionPixelSize(d.aiapps_emoji_grid_space));
                b bVar = (b) gridView.getAdapter();
                if (bVar != null && (viewPager = this.f11230e) != null) {
                    viewPager.post(new a(this, bVar));
                }
            }
        }
    }

    public void setEmotionList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f11232g = list;
            if (list == null || list.size() <= 0) {
                return;
            }
            int size = this.f11232g.size();
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
                d.a.q0.a.w1.h.a g2 = d.a.q0.a.w1.h.a.g(getContext().getApplicationContext());
                noScrollGridView.setOnItemClickListener(g2.h());
                noScrollGridView.setOnItemLongClickListener(g2.i());
                noScrollGridView.setOnTouchListener(g2.j());
                noScrollGridView.setSelector(new ColorDrawable(0));
                this.f11233h.add(noScrollGridView);
            }
            c();
            this.f11230e.setAdapter(new c(this, this.f11233h));
            this.f11231f.setViewPager(this.f11230e);
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
        this.f11233h = new ArrayList();
        b(context);
    }
}
