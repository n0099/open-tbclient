package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a75;
import com.baidu.tieba.b75;
import com.baidu.tieba.bw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DownloadFlowAdapter<T extends b75> extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<View> a;
    public ArrayList<T> b;
    public Context c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    public bw5 f;
    public Map<String, String> g;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public DownloadFlowAdapter(Context context) {
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
        new ArrayList();
        new ArrayList();
        this.g = new HashMap();
        this.c = context;
        this.f = bw5.c();
        i();
    }

    public final void f(ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.clear();
            LayoutInflater from = LayoutInflater.from(this.c);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next();
                View inflate = from.inflate(R.layout.person_center_viewpager_download_custom_layout, (ViewGroup) null);
                inflate.setOnClickListener(this.d);
                inflate.findViewById(R.id.rl_btn_view).setOnClickListener(this.e);
                this.a.add(inflate);
            }
        }
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

    public final void e(List<T> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        int size = this.b.size();
        if (size <= 1) {
            return;
        }
        this.b.add(0, this.b.get(size - 1));
        this.b.add(this.b.get(0));
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Map<String, String> map = this.g;
            if (map != null && map.size() > 0) {
                Iterator<Map.Entry<String, String>> it = this.g.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    if (next != null && this.g.containsKey(str) && next.getKey().equals(str)) {
                        if (next.getValue().equals(bw5.j)) {
                            return true;
                        }
                        if (next.getValue().equals(bw5.k)) {
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) && (obj instanceof View)) {
            viewGroup.removeView((View) obj);
        }
    }

    public void g(List<T> list, a75 a75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, list, a75Var) == null) && list != null && !list.isEmpty()) {
            e(list);
            f(this.b);
            notifyDataSetChanged();
        }
    }

    public void h(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, onClickListener, onClickListener2) == null) {
            this.d = onClickListener;
            this.e = onClickListener2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<View> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                return 0;
            }
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public void i() {
        bw5 bw5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (bw5Var = this.f) == null) {
            return;
        }
        this.g = bw5Var.e();
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            ArrayList<View> arrayList = this.a;
            if (arrayList == null) {
                return super.instantiateItem(viewGroup, i);
            }
            View view2 = (View) ListUtils.getItem(arrayList, i);
            ApkDownloadInfoData apkDownloadInfoData = (ApkDownloadInfoData) ListUtils.getItem(this.b, i);
            if (view2 != null && this.b.size() != 0 && apkDownloadInfoData != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.rl_card_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_apk_cover);
                TextView textView = (TextView) view2.findViewById(R.id.tv_apk_name_info);
                ImageView imageView = (ImageView) view2.findViewById(R.id.iv_red_point);
                TextView textView2 = (TextView) view2.findViewById(R.id.tv_apk_download_state);
                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.rl_btn_view);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, 1, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0109, 1, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.tv_install), R.color.CAM_X0101, 1, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(imageView, R.color.CAM_X0301);
                SkinManager.setBackgroundColor(relativeLayout2, R.color.CAM_X0302);
                tbImageView.setConrers(15);
                EMManager.from(relativeLayout).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
                EMManager.from(imageView).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0301);
                EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0302);
                tbImageView.startLoad(apkDownloadInfoData.getmApkImgUrl(), 10, false);
                textView.setText(apkDownloadInfoData.getmApkName());
                if (apkDownloadInfoData.getStatus() != null) {
                    int i2 = apkDownloadInfoData.getStatus().status;
                    if (i2 != 3) {
                        if (i2 != 4) {
                            textView2.setText(R.string.mypage_download_unknown);
                        } else {
                            textView2.setText(R.string.mypage_download_installed);
                        }
                    } else {
                        textView2.setText(R.string.mypage_download_complete);
                    }
                }
                if (c(apkDownloadInfoData.getApkPackageName())) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                view2.setTag(Integer.valueOf(i));
                relativeLayout2.setTag(Integer.valueOf(i));
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                viewGroup.addView(view2, new ViewGroup.LayoutParams(-2, -2));
                return view2;
            }
            return super.instantiateItem(viewGroup, i);
        }
        return invokeLI.objValue;
    }
}
