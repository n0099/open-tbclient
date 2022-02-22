package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.f.p.n;
import c.a.t0.s.r.b0;
import c.a.t0.s.x.b.a;
import c.a.u0.a4.e;
import c.a.u0.e1.h;
import c.a.u0.l3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class CoverFlowAdapter<T extends a> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<TbImageView> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f40477b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40478c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f40479d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TbImageView> f40480e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f40481f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.s.x.a f40482g;

    public CoverFlowAdapter(Context context) {
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
        this.a = new ArrayList<>();
        this.f40477b = new ArrayList<>();
        this.f40480e = new ArrayList<>();
        this.f40481f = new ArrayList<>();
        this.f40478c = context;
    }

    public final void a(ArrayList<T> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || arrayList == null || (size = arrayList.size()) <= 1) {
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
            ArrayList<TbImageView> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                return this.a.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<T> arrayList = this.f40477b;
            if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f40477b.size()) {
                return null;
            }
            return this.f40477b.get(i2);
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
            ArrayList<TbImageView> arrayList = this.a;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            TbImageView tbImageView = (TbImageView) ListUtils.getItem(arrayList, i2);
            if (tbImageView == null) {
                return super.instantiateItem(viewGroup, i2);
            }
            if ((ListUtils.getItem(this.f40477b, i2) instanceof b0) && !((b0) ListUtils.getItem(this.f40477b, i2)).l()) {
                RelativeLayout relativeLayout = (RelativeLayout) ListUtils.getItem(this.f40481f, i2);
                TbImageView tbImageView2 = (TbImageView) ListUtils.getItem(this.f40480e, i2);
                relativeLayout.removeView(tbImageView2);
                if (tbImageView.getParent() != null) {
                    ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
                }
                relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.f40482g.b() == null) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                } else {
                    layoutParams.setMargins(0, n.f(this.f40478c, e.ds220) - n.f(this.f40478c, e.ds24), 0, 0);
                }
                relativeLayout.addView(tbImageView2, layoutParams);
                if (relativeLayout.getParent() == null) {
                    viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
                }
                tbImageView.setTag(Integer.valueOf(i2));
                return relativeLayout;
            }
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            if (tbImageView.getParent() == null) {
                viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i2));
            tbImageView.refresh();
            return tbImageView;
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
        ArrayList<TbImageView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (arrayList = this.a) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<TbImageView> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().refresh();
        }
    }

    public void setData(List<T> list, c.a.t0.s.x.a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, list, aVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f40482g = aVar;
        this.f40477b.clear();
        this.f40477b.addAll(list);
        a(this.f40477b);
        int size = this.a.size();
        int size2 = this.f40477b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                tbImageView = aVar.d(this.f40478c);
                this.a.add(tbImageView);
                tbImageView2 = aVar.d(this.f40478c);
                this.f40480e.add(tbImageView2);
                this.f40481f.add(new RelativeLayout(this.f40478c));
            } else {
                tbImageView = this.a.get(i2);
                tbImageView2 = this.f40480e.get(i2);
                this.f40481f.get(i2);
            }
            if (this.f40477b.get(i2) != null && tbImageView != null) {
                if (this.f40477b.get(i2) instanceof h) {
                    tbImageView.setImageDrawable(SkinManager.getDrawable(Integer.valueOf(this.f40477b.get(i2).a()).intValue()));
                } else {
                    tbImageView.startLoad(this.f40477b.get(i2).a(), 10, false);
                }
                tbImageView.setOnClickListener(this.f40479d);
                if ((this.f40477b.get(i2) instanceof b0) && !((b0) this.f40477b.get(i2)).l()) {
                    b0 b0Var = (b0) this.f40477b.get(i2);
                    z.u(b0Var.i(), tbImageView2, b0Var.j(), n.f(this.f40478c, e.ds24));
                }
            }
        }
        int count = ListUtils.getCount(this.f40477b);
        int count2 = ListUtils.getCount(this.a);
        if (count2 > count) {
            ListUtils.removeSubList(this.a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f40480e);
        if (count3 > count) {
            ListUtils.removeSubList(this.f40480e, count, count3);
        }
        int count4 = ListUtils.getCount(this.f40481f);
        if (count4 > count) {
            ListUtils.removeSubList(this.f40481f, count, count4);
        }
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f40479d = onClickListener;
        }
    }
}
