package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import b.a.q0.s.w.b.a;
import b.a.r0.x0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f45138a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f45139b;

    /* renamed from: c  reason: collision with root package name */
    public Context f45140c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f45141d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45142e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f45143f;

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
        this.f45138a = new ArrayList<>();
        this.f45139b = new ArrayList<>();
        new ArrayList();
        this.f45143f = new ArrayList<>();
        this.f45140c = context;
    }

    public final void a(ArrayList<T> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1 || !this.f45142e) {
            return;
        }
        arrayList.add(0, arrayList.get(size - 1));
        arrayList.add(arrayList.get(0));
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<ImageView> arrayList = this.f45138a;
            if (arrayList != null && arrayList.size() > 0) {
                return this.f45138a.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<T> arrayList = this.f45139b;
            if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f45139b.size()) {
                return null;
            }
            return this.f45139b.get(i2);
        }
        return (T) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            ArrayList<ImageView> arrayList = this.f45138a;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void onChangeSkinType() {
        ArrayList<ImageView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (arrayList = this.f45138a) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<ImageView> it = this.f45138a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f45142e = z;
        }
    }

    public void setData(List<T> list, b.a.q0.s.w.a aVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, list, aVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f45139b.clear();
        this.f45139b.addAll(list);
        a(this.f45139b);
        int size = this.f45138a.size();
        int size2 = this.f45139b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                imageView = new ImageView(this.f45140c);
                this.f45138a.add(imageView);
                this.f45143f.add(new RelativeLayout(this.f45140c));
            } else {
                imageView = this.f45138a.get(i2);
                this.f45143f.get(i2);
            }
            if (this.f45139b.get(i2) != null && imageView != null) {
                if (this.f45139b.get(i2) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f45139b.get(i2).a()).intValue()));
                }
                imageView.setOnClickListener(this.f45141d);
            }
        }
        int count = ListUtils.getCount(this.f45139b);
        int count2 = ListUtils.getCount(this.f45138a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f45138a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f45143f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f45143f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f45141d = onClickListener;
        }
    }
}
