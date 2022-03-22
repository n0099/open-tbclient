package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.o0.r.x.b.a;
import c.a.p0.f1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ImageView> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f29888b;

    /* renamed from: c  reason: collision with root package name */
    public Context f29889c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f29890d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29891e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f29892f;

    public CoverFlowLocalAdapter(Context context) {
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
        this.a = new ArrayList<>();
        this.f29888b = new ArrayList<>();
        new ArrayList();
        this.f29892f = new ArrayList<>();
        this.f29889c = context;
    }

    public T b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<T> arrayList = this.f29888b;
            if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.f29888b.size()) {
                return null;
            }
            return this.f29888b.get(i);
        }
        return (T) invokeI.objValue;
    }

    public final void c(ArrayList<T> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1 || !this.f29891e) {
            return;
        }
        arrayList.add(0, arrayList.get(size - 1));
        arrayList.add(arrayList.get(0));
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f29891e = z;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(List<T> list, c.a.o0.r.x.a aVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, aVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f29888b.clear();
        this.f29888b.addAll(list);
        c(this.f29888b);
        int size = this.a.size();
        int size2 = this.f29888b.size();
        for (int i = 0; i < size2; i++) {
            if (i >= size) {
                imageView = new ImageView(this.f29889c);
                this.a.add(imageView);
                this.f29892f.add(new RelativeLayout(this.f29889c));
            } else {
                imageView = this.a.get(i);
                this.f29892f.get(i);
            }
            if (this.f29888b.get(i) != null && imageView != null) {
                if (this.f29888b.get(i) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f29888b.get(i).a()).intValue()));
                }
                imageView.setOnClickListener(this.f29890d);
            }
        }
        int count = ListUtils.getCount(this.f29888b);
        int count2 = ListUtils.getCount(this.a);
        if (count2 > count) {
            ListUtils.removeSubList(this.a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f29892f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f29892f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f29890d = onClickListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<ImageView> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                return this.a.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            ArrayList<ImageView> arrayList = this.a;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            ImageView imageView = (ImageView) ListUtils.getItem(arrayList, i);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            if (imageView.getParent() == null) {
                viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
            imageView.setTag(Integer.valueOf(i));
            return imageView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }
}
