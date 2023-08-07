package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a75;
import com.baidu.tieba.b75;
import com.baidu.tieba.df7;
import com.baidu.tieba.mx9;
import com.baidu.tieba.u15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowAdapter<T extends b75> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<TbImageView> a;
    public ArrayList<T> b;
    public Context c;
    public View.OnClickListener d;
    public ArrayList<TbImageView> e;
    public ArrayList<RelativeLayout> f;
    public a75 g;

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
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public CoverFlowAdapter(Context context) {
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
        this.b = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.c = context;
    }

    public T b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<T> arrayList = this.b;
            if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.b.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return (T) invokeI.objValue;
    }

    public void c() {
        ArrayList<TbImageView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (arrayList = this.a) != null && arrayList.size() > 0) {
            Iterator<TbImageView> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<TbImageView> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                return 0;
            }
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public final void d(ArrayList<T> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || arrayList == null || (size = arrayList.size()) <= 1) {
            return;
        }
        arrayList.add(0, arrayList.get(size - 1));
        arrayList.add(arrayList.get(0));
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(List<T> list, a75 a75Var) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, list, a75Var) == null) && list != null && !list.isEmpty()) {
            this.g = a75Var;
            this.b.clear();
            this.b.addAll(list);
            d(this.b);
            int size = this.a.size();
            int size2 = this.b.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    tbImageView = a75Var.d(this.c);
                    this.a.add(tbImageView);
                    tbImageView2 = a75Var.d(this.c);
                    this.e.add(tbImageView2);
                    this.f.add(new RelativeLayout(this.c));
                } else {
                    tbImageView = this.a.get(i);
                    tbImageView2 = this.e.get(i);
                    this.f.get(i);
                }
                if (this.b.get(i) != null && tbImageView != null) {
                    if (this.b.get(i) instanceof df7) {
                        tbImageView.setImageDrawable(SkinManager.getDrawable(Integer.valueOf(this.b.get(i).getPicUrl()).intValue()));
                    } else {
                        tbImageView.startLoad(this.b.get(i).getPicUrl(), 10, false);
                    }
                    tbImageView.setOnClickListener(this.d);
                    if ((this.b.get(i) instanceof u15) && !((u15) this.b.get(i)).n()) {
                        u15 u15Var = (u15) this.b.get(i);
                        mx9.k(u15Var.j(), tbImageView2, u15Var.k(), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701e8));
                    }
                }
            }
            int count = ListUtils.getCount(this.b);
            int count2 = ListUtils.getCount(this.a);
            if (count2 > count) {
                ListUtils.removeSubList(this.a, count, count2);
            }
            int count3 = ListUtils.getCount(this.e);
            if (count3 > count) {
                ListUtils.removeSubList(this.e, count, count3);
            }
            int count4 = ListUtils.getCount(this.f);
            if (count4 > count) {
                ListUtils.removeSubList(this.f, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            ArrayList<TbImageView> arrayList = this.a;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            TbImageView tbImageView = (TbImageView) ListUtils.getItem(arrayList, i);
            if (tbImageView == null) {
                return super.instantiateItem(viewGroup, i);
            }
            if ((ListUtils.getItem(this.b, i) instanceof u15) && !((u15) ListUtils.getItem(this.b, i)).n()) {
                RelativeLayout relativeLayout = (RelativeLayout) ListUtils.getItem(this.f, i);
                TbImageView tbImageView2 = (TbImageView) ListUtils.getItem(this.e, i);
                relativeLayout.removeView(tbImageView2);
                if (tbImageView.getParent() != null) {
                    ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
                }
                relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.g.b() == null) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                } else {
                    layoutParams.setMargins(0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f07039a) - BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701e8), 0, 0);
                }
                relativeLayout.addView(tbImageView2, layoutParams);
                if (relativeLayout.getParent() == null) {
                    viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
                }
                tbImageView.setTag(Integer.valueOf(i));
                return relativeLayout;
            }
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            if (tbImageView.getParent() == null) {
                viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i));
            tbImageView.refresh();
            return tbImageView;
        }
        return invokeLI.objValue;
    }
}
