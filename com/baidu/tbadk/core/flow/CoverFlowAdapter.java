package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.f.p.n;
import c.a.s0.s.q.b0;
import c.a.s0.s.w.b.a;
import c.a.t0.d1.h;
import c.a.t0.j3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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
    public ArrayList<T> f41649b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41650c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f41651d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TbImageView> f41652e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f41653f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.w.a f41654g;

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
        this.f41649b = new ArrayList<>();
        this.f41652e = new ArrayList<>();
        this.f41653f = new ArrayList<>();
        this.f41650c = context;
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
            ArrayList<T> arrayList = this.f41649b;
            if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f41649b.size()) {
                return null;
            }
            return this.f41649b.get(i2);
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
            if ((ListUtils.getItem(this.f41649b, i2) instanceof b0) && !((b0) ListUtils.getItem(this.f41649b, i2)).l()) {
                RelativeLayout relativeLayout = (RelativeLayout) ListUtils.getItem(this.f41653f, i2);
                TbImageView tbImageView2 = (TbImageView) ListUtils.getItem(this.f41652e, i2);
                relativeLayout.removeView(tbImageView2);
                if (tbImageView.getParent() != null) {
                    ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
                }
                relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.f41654g.b() == null) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                } else {
                    layoutParams.setMargins(0, n.f(this.f41650c, R.dimen.ds220) - n.f(this.f41650c, R.dimen.ds24), 0, 0);
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

    public void setData(List<T> list, c.a.s0.s.w.a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, list, aVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f41654g = aVar;
        this.f41649b.clear();
        this.f41649b.addAll(list);
        a(this.f41649b);
        int size = this.a.size();
        int size2 = this.f41649b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                tbImageView = aVar.d(this.f41650c);
                this.a.add(tbImageView);
                tbImageView2 = aVar.d(this.f41650c);
                this.f41652e.add(tbImageView2);
                this.f41653f.add(new RelativeLayout(this.f41650c));
            } else {
                tbImageView = this.a.get(i2);
                tbImageView2 = this.f41652e.get(i2);
                this.f41653f.get(i2);
            }
            if (this.f41649b.get(i2) != null && tbImageView != null) {
                if (this.f41649b.get(i2) instanceof h) {
                    tbImageView.setImageDrawable(SkinManager.getDrawable(Integer.valueOf(this.f41649b.get(i2).a()).intValue()));
                } else {
                    tbImageView.startLoad(this.f41649b.get(i2).a(), 10, false);
                }
                tbImageView.setOnClickListener(this.f41651d);
                if ((this.f41649b.get(i2) instanceof b0) && !((b0) this.f41649b.get(i2)).l()) {
                    b0 b0Var = (b0) this.f41649b.get(i2);
                    z.u(b0Var.i(), tbImageView2, b0Var.j(), n.f(this.f41650c, R.dimen.ds24));
                }
            }
        }
        int count = ListUtils.getCount(this.f41649b);
        int count2 = ListUtils.getCount(this.a);
        if (count2 > count) {
            ListUtils.removeSubList(this.a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f41652e);
        if (count3 > count) {
            ListUtils.removeSubList(this.f41652e, count, count3);
        }
        int count4 = ListUtils.getCount(this.f41653f);
        if (count4 > count) {
            ListUtils.removeSubList(this.f41653f, count, count4);
        }
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f41651d = onClickListener;
        }
    }
}
