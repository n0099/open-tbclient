package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.w.b.a;
import d.a.s0.u0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f12302a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12303b;

    /* renamed from: c  reason: collision with root package name */
    public Context f12304c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12305d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12306e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12307f;

    public CoverFlowLocalAdapter(Context context) {
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
        this.f12302a = new ArrayList<>();
        this.f12303b = new ArrayList<>();
        new ArrayList();
        this.f12307f = new ArrayList<>();
        this.f12304c = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<ImageView> arrayList = this.f12302a;
            if (arrayList != null && arrayList.size() > 0) {
                return this.f12302a.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    public T i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<T> arrayList = this.f12303b;
            if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f12303b.size()) {
                return null;
            }
            return this.f12303b.get(i2);
        }
        return (T) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            ArrayList<ImageView> arrayList = this.f12302a;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            ImageView imageView = (ImageView) ListUtils.getItem(arrayList, i2);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            if (imageView.getParent() == null) {
                viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
            imageView.setTag(Integer.valueOf(i2));
            return imageView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public final void j(ArrayList<T> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1 || !this.f12306e) {
            return;
        }
        arrayList.add(0, arrayList.get(size - 1));
        arrayList.add(arrayList.get(0));
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f12306e = z;
        }
    }

    public void l(List<T> list, d.a.r0.r.w.a aVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, aVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f12303b.clear();
        this.f12303b.addAll(list);
        j(this.f12303b);
        int size = this.f12302a.size();
        int size2 = this.f12303b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                imageView = new ImageView(this.f12304c);
                this.f12302a.add(imageView);
                this.f12307f.add(new RelativeLayout(this.f12304c));
            } else {
                imageView = this.f12302a.get(i2);
                this.f12307f.get(i2);
            }
            if (this.f12303b.get(i2) != null && imageView != null) {
                if (this.f12303b.get(i2) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f12303b.get(i2).a()).intValue()));
                }
                imageView.setOnClickListener(this.f12305d);
            }
        }
        int count = ListUtils.getCount(this.f12303b);
        int count2 = ListUtils.getCount(this.f12302a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12302a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12307f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12307f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f12305d = onClickListener;
        }
    }
}
