package b.a.r0.j1.o.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import b.a.r0.j1.d;
import b.a.r0.j1.l.p;
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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f18560e;

    /* renamed from: f  reason: collision with root package name */
    public Context f18561f;

    /* renamed from: g  reason: collision with root package name */
    public int f18562g;

    /* renamed from: h  reason: collision with root package name */
    public int f18563h;

    /* renamed from: i  reason: collision with root package name */
    public final int f18564i;

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
        this.f18560e = new ArrayList();
        this.f18562g = 0;
        this.f18563h = 0;
        this.f18561f = context;
        this.f18562g = context.getResources().getDimensionPixelSize(b.a.r0.j1.c.fontsize28);
        this.f18563h = context.getResources().getDimensionPixelSize(b.a.r0.j1.c.ds16);
        this.f18564i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f18560e.size()) {
                return null;
            }
            return this.f18560e.get(i2);
        }
        return (p) invokeI.objValue;
    }

    public void b(List<p> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f18560e.clear();
            if (list != null && list.size() > 0) {
                this.f18560e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18560e.size() : invokeV.intValue;
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
                textView = new TextView(this.f18561f);
                textView.setGravity(17);
                textView.setTextSize(0, this.f18562g);
                int i3 = this.f18563h;
                textView.setPadding(0, i3, 0, i3);
            }
            p pVar = (p) ListUtils.getItem(this.f18560e, i2);
            if (pVar == null) {
                return null;
            }
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f18485e, 8, (String) null));
            SkinManager.setViewTextColor(textView, b.a.r0.j1.b.CAM_X0106, 1);
            if (i2 == this.f18564i) {
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
