package c.a.r0.p1.o.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.r0.p1.d;
import c.a.r0.p1.l.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f21262e;

    /* renamed from: f  reason: collision with root package name */
    public Context f21263f;

    /* renamed from: g  reason: collision with root package name */
    public int f21264g;

    /* renamed from: h  reason: collision with root package name */
    public int f21265h;

    /* renamed from: i  reason: collision with root package name */
    public final int f21266i;

    public b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21262e = new ArrayList();
        this.f21264g = 0;
        this.f21265h = 0;
        this.f21263f = context;
        this.f21264g = context.getResources().getDimensionPixelSize(c.a.r0.p1.c.fontsize28);
        this.f21265h = context.getResources().getDimensionPixelSize(c.a.r0.p1.c.ds16);
        this.f21266i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f21262e.size()) {
                return null;
            }
            return this.f21262e.get(i2);
        }
        return (p) invokeI.objValue;
    }

    public void b(List<p> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f21262e.clear();
            if (list != null && list.size() > 0) {
                this.f21262e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21262e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = new TextView(this.f21263f);
                textView.setGravity(17);
                textView.setTextSize(0, this.f21264g);
                int i3 = this.f21265h;
                textView.setPadding(0, i3, 0, i3);
            }
            p pVar = (p) ListUtils.getItem(this.f21262e, i2);
            if (pVar == null) {
                return null;
            }
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f21193e, 8, (String) null));
            SkinManager.setViewTextColor(textView, c.a.r0.p1.b.CAM_X0106, 1);
            if (i2 == this.f21266i) {
                SkinManager.setBackgroundResource(textView, d.btn_label_white_s);
            } else if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                textView.setBackgroundResource(d.topic_btn_more_item);
            } else {
                textView.setBackgroundResource(d.topic_btn_more_item_1);
            }
            return textView;
        }
        return (View) invokeILL.objValue;
    }
}
