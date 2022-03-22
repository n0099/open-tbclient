package c.a.p0.b2.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.p0.b2.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12582b;

    /* renamed from: c  reason: collision with root package name */
    public int f12583c;

    /* renamed from: d  reason: collision with root package name */
    public int f12584d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12585e;

    public b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f12583c = 0;
        this.f12584d = 0;
        this.f12582b = context;
        this.f12583c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
        this.f12584d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
        this.f12585e = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (e) invokeI.objValue;
    }

    public void b(List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.clear();
            if (list != null && list.size() > 0) {
                this.a.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = new TextView(this.f12582b);
                textView.setGravity(17);
                textView.setTextSize(0, this.f12583c);
                int i2 = this.f12584d;
                textView.setPadding(0, i2, 0, i2);
            }
            e eVar = (e) ListUtils.getItem(this.a, i);
            if (eVar == null) {
                return null;
            }
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f12572c, 8, (String) null));
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            if (i == this.f12585e) {
                SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
            } else {
                SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
            }
            return textView;
        }
        return (View) invokeILL.objValue;
    }
}
